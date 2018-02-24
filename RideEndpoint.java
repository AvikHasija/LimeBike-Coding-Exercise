import java.util.Date;

/**
* Created by  Avik Hasija on 02/23/2018.
*/

public class RideEndpoint{
    private Date mTime;
    private boolean mIsRideEnding;
    private Basket mBasket;

    public RideEndpoint(Date time, boolean isRideEnding, Basket basket){
        mTime = time;
        mIsRideEnding = isRideEnding;
        mBasket = basket;
    }

    //Mutator methods for class variables
    public Date getTime(){
        return mTime;
    }

    public boolean getIsRideEnding(){
        return mIsRideEnding;
    }

    public Basket getBasket(){
        return mBasket;
    }

    public void setTime(Date time){
        mTime = time;
    }

    public void setIsRideEnding(boolean isRideEnding){
        mIsRideEnding = isRideEnding;
    }

    public void setBasket(Basket basket){
        mBasket = basket;
    }
}