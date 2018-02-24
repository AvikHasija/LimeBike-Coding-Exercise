import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by  Avik Hasija on 02/23/2018.
 */

public class ItemCounter{
    SimpleDateFormat mSDF = new SimpleDateFormat("HH:mm");
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

        try{
            //Creating ride objects and processing
            processRide(new Ride(mSDF.parse("07:00"), mSDF.parse("07:30"), new Basket(new HashMap<String, Integer>(){
                {
                    put("apple", 2);
                    put("brownie", 1);
                }
            })));
            processRide(new Ride(mSDF.parse("07:10"), mSDF.parse("08:00"), new Basket(new HashMap<String, Integer>(){
                {
                    put("apple", 1);
                    put("carrot", 3);
                }
            })));
            processRide(new Ride(mSDF.parse("07:20"), mSDF.parse("07:45"), new Basket(new HashMap<String, Integer>(){
                {
                    put("apple", 1);
                    put("brownie", 2);
                    put("diamond", 4);
                }
            })));
        } catch (ParseException e){
            e.printStackTrace();
        }
        

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

            if (previousTime != null && !currentTime.equals(previousTime)){
                //Print only if this is not the first endpoint in the list and there are no duplicate times
                System.out.print(mSDF.format(previousTime) + "-" + mSDF.format(currentTime) + " -> ");
                for(String itemName : currentBasket.getItems().keySet()){
                    System.out.print(currentBasket.getItems().get(itemName) + " " + itemName + ", ");
                }
                System.out.print('\n');
            }

            //Add or remove from basket depending on whether ride is starting/ending
            if(currentEndpoint.getIsRideEnding()){
                currentBasket.removeItems(currentEndpoint.getBasket());
            } else {
                currentBasket.addItems(currentEndpoint.getBasket());
            }
        }
    }
}