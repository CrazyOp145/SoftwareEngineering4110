package Profiles.Items;

import Profiles.Items.Categories.*;

/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class ItemProfileFactory {
    public ItemProfile createItemProfile(String newItemType){
        ItemProfile newItem = null;
        if(newItemType.equals("Profiles.Items.Categories.Vegetables")){
            return new Vegetables();
        }else if(newItemType.equals("Profiles.Items.Categories.Fruits")){
            return new Fruits();
        }else if(newItemType.equals("Profiles.Items.Categories.Dairy")){
            return new Dairy();
        }else if(newItemType.equals("Profiles.Items.Categories.Meat")){
            return new Meat();
        }else if(newItemType.equals("Profiles.Items.Categories.Juice")){
            return new Juice();
        }else if(newItemType.equals("Profiles.Items.Categories.Nuts")){
            return new Nuts();
        }else if(newItemType.equals("Profiles.Items.Categories.Snacks")){
            return new Snacks();
        }else if(newItemType.equals("Profiles.Items.Categories.Soda")){
            return new Soda();
        }else if(newItemType.equals("Bakery")) {
            return new BakeryProducts();
        }
        else return null;
    }
}
