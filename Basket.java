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
    public void addItems(Basket basket){
        HashMap<String, Integer> items = basket.getItems();

        for(String itemName : items.keySet()){
            //If current basket already contains an item, update its value. Else, add the item.
            if(mItems.containsKey(itemName)){
                mItems.put(itemName, (mItems.get(itemName) + items.get(itemName)));
            } else {
                mItems.put(itemName, items.get(itemName));
            }
        }
    }

    //Method to remove items from basket
    public void removeItems(Basket basket){
        HashMap<String, Integer> items = basket.getItems();

        for(String itemName : items.keySet()){
            if(mItems.containsKey(itemName)){
                //If item is completely removed, remove entry from hashmap. Else, update value
                if((mItems.get(itemName) - items.get(itemName)) < 1 ){
                    mItems.remove(itemName);
                } else{
                    mItems.put(itemName, (mItems.get(itemName) - items.get(itemName)));
                }
            } else {
                throw new Error("Item is not in basket, and cannot be removed!");
            }
        }
    }

    //Mutator methods for class variables
    public HashMap<String, Integer> getItems(){
        return mItems;
    }

    public void setItems(HashMap<String, Integer> items){
        mItems = items;
    }
}