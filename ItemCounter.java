import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* Created by  Avik Hasija on 02/23/2018.
*/

public class ItemCounter{
    ArrayList<RideEndpoint> rideEndpointsLog = new ArrayList<RideEndpoint>();

    public static void main (String[] args){
        //Create fake rides
        
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

        //Now, iterate through endpoint objects, keeping track of previous time to print intervals.
        //Create an active basket to print and update at each endpoint object.
        Date previousTime = null;
        Basket currentBasket;
        for(int i = 0; i < rideEndpointsLog.size(); i++){
            if (previousTime == null){ //Handling first endpoint in list
                previousTime = rideEndpointsLog.get(i).getTime();

            } else {

            }
        }
    }
}