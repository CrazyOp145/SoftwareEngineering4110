public class ItemProfileFactory {
    public ItemProfile createItemProfile(String newItemType){
        ItemProfile newItem = null;
        if(newItemType.equals("Vegetables")){
            return new Vegetables();
        }else if(newItemType.equals("Fruits")){
            return new Fruits();
        }else if(newItemType.equals("Dairy")){
            return new Dairy();
        }else if(newItemType.equals("Meat")){
            return new Meat();
        }else if(newItemType.equals("Juice")){
            return new Juice();
        }else if(newItemType.equals("Nuts")){
            return new Nuts();
        }else if(newItemType.equals("Snacks")){
            return new Snacks();
        }else if(newItemType.equals("Soda")){
            return new Soda();
        }else if(newItemType.equals("Bakery")) {
            return new BakeryProducts();
        }
        else return null;
    }
}
