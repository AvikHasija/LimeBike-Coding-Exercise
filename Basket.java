import java.util.HashMap;
import java.util.Map;

/**
* Created by  Avik Hasija on 02/23/2018.
*/

public class Basket {
    private HashMap<String, Integer> mItems;

    public Basket(){
        mItems = new HashMap<String, Integer>();
    }

    public Basket(HashMap<String, Integer> items){
        mItems = items;
    }

    //Method to add items to basket
    public void addItems(Basket appendItems){
        
    }

    public void removeItems(Basket removeItems){

    }

    //Mutator methods for class variables
    public HashMap<String, Integer> getItems(){
        return mItems;
    }

    public void setItems(HashMap<String, Integer> items){
        mItems = items;
    }
}