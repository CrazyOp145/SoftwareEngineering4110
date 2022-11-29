public class itemProfileFactory {
    public itemProfile createItemProfile(String newItemType){
        itemProfile newItem = null;
        if(newItemType.equals("Vegetables")){
            return new vegetables();
        }else if(newItemType.equals("Fruits")){
            return new fruits();
        }else if(newItemType.equals("Dairy")){
            return new dairy();
        }else if(newItemType.equals("Meat")){
            return new meat();
        }else if(newItemType.equals("Juice")){
            return new juice();
        }else if(newItemType.equals("Nuts")){
            return new nuts();
        }else if(newItemType.equals("Snacks")){
            return new snacks();
        }else if(newItemType.equals("Soda")){
            return new soda();
        }else if(newItemType.equals("Bakery")) {
            return new bakeryProducts();
        }
        else return null;
    }
}
