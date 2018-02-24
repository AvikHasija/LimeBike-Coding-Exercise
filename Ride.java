import java.sql.Time;
import java.util.Date;

/**
* Created by  Avik Hasija on 02/23/2018.
*/

public class Ride {
    private Date mStartTime;
    private Date mEndTime;
    private Basket mBasket;
    
    //Mutator methods for class variables
    public Date getStartTime(){
        return mStartTime;
    }

    public Date getEndTime(){
        return mEndTime;
    }

    public Basket getBasket(){
        return mBasket;
    }

    public void setStartTime(Date startTime){
        mStartTime = startTime;
    }

    public void setEndTime(Date endTime){
        mEndTime = endTime;    
    }

    public void setBasket(Basket basket){
        mBasket = basket;
    }

}