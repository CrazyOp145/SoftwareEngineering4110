package ItemProfiles;

import ItemProfiles.BakeryProducts;
import ItemProfiles.Dairy;
import ItemProfiles.Fruits;
import ItemProfiles.ItemProfile;

public class ItemProfileFactory {
    public ItemProfile createItemProfile(String newItemType){
        ItemProfile newItem = null;
        if(newItemType.equals("ItemProfiles.Vegetables")){
            return new Vegetables();
        }else if(newItemType.equals("ItemProfiles.Fruits")){
            return new Fruits();
        }else if(newItemType.equals("ItemProfiles.Dairy")){
            return new Dairy();
        }else if(newItemType.equals("ItemProfiles.Meat")){
            return new Meat();
        }else if(newItemType.equals("ItemProfiles.Juice")){
            return new Juice();
        }else if(newItemType.equals("ItemProfiles.Nuts")){
            return new Nuts();
        }else if(newItemType.equals("ItemProfiles.Snacks")){
            return new Snacks();
        }else if(newItemType.equals("Profiles.Soda")){
            return new Soda();
        }else if(newItemType.equals("Bakery")) {
            return new BakeryProducts();
        }
        else return null;
    }
}
