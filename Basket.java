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

    public Basket(HashMap items){
        mItems = items;
    }

    //Method to add items to basket
    public void addItems(HashMap<String, Integer> itemsToAdd){
        for(Map.Entry<String, Integer> item : itemsToAdd.entrySet()){

        }
    }

    public void removeItems(HashMap<String, Integer> itemsToRemove){

    }

    //Mutator methods for class variables
    public HashMap<String, Integer> getItems(){
        return mItems;
    }

    public void setItems(HashMap<String, Integer> items){
        mItems = items;
    }
}