import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by  Avik Hasija on 02/23/2018.
 */

public class ItemCounter{
    ArrayList<RideEndpoint> rideEndpointsLog = new ArrayList<>();

    public static void main (String[] args){
        new ItemCounter();   
    }

    public ItemCounter(){
        /**
         * Ride data would presumably be fetched from a data source like an API, then
         * deserialized to Java Ride objects (ie. using a library like Gson).
         * 
         * For the purposes of this exercise, mock data has been created to test.
        */

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        //Creating ride objects and processing
        processRide(new Ride(sdf.parse("07:00"), sdf.parse("07:30"), new Basket(new HashMap<String, Integer>(){
            {
                put("apple", 2);
                put("brownie", 1);
            }
        })));
        processRide(new Ride(sdf.parse("07:10"), sdf.parse("08:00"), new Basket(new HashMap<String, Integer>(){
            {
                put("apple", 1);
                put("carrot", 3);
            }
        })));
        processRide(new Ride(sdf.parse("07:20"), sdf.parse("07:45"), new Basket(new HashMap<String, Integer>(){
            {
                put("apple", 2);
                put("brownie", 2);
                put("diamond", 4);
            }
        })));

        //Print interval data
        printItemsPerInterval();
    }

    public void processRide(Ride ride){
        //To process rides, create endpoint objects at the ride's start and end times.
        rideEndpointsLog.add(new RideEndpoint(ride.getStartTime(), false, ride.getBasket()));
        rideEndpointsLog.add(new RideEndpoint(ride.getEndTime(), true, ride.getBasket()));
    }

    public void printItemsPerInterval(){
        //First, sort list of endpoints so that it is ordered chronologically
        //The time complexity of the Collections.sort method is O(n logn)
        Collections.sort(rideEndpointsLog, new Comparator<RideEndpoint>() {
            @Override
            public int compare(RideEndpoint e1, RideEndpoint e2){
                return e1.getTime().compareTo(e2.getTime());
            }
        });

        //Now, iterate through list of endpoint objects, keeping track of previous time to print intervals.
        //Create an active basket to print and update at each endpoint object.
        Date previousTime = null;
        Date currentTime = null;
        Basket currentBasket = new Basket();
    
        for(int i = 0; i < rideEndpointsLog.size(); i++){
            RideEndpoint currentEndpoint = rideEndpointsLog.get(i);

            //Update previous and current times.
            previousTime = currentTime;
            currentTime = currentEndpoint.getTime();

            //Add or remove from basket depending on whether ride is starting/ending
            //if(currentEndpoint.getIsRideEnding() ? currentBasket.removeItems(currentEndpoint.getBasket()) : currentBasket.addItems(currentEndpoint.getBasket()));
            
            if (previousTime != null && !currentTime.equals(previousTime)){
                //Print only if this is not the first endpoint in the list and there are no duplicate times
                System.out.print(previousTime + "-" + currentTime + "->");
            }
        }
    }
}