public class itemProfileFactory {
    public itemProfile createItemProfile(String newItemType){
        itemProfile newItem = null;
        if(newItemType.equals("vegetables")){
            return new vegetables();
        }else if(newItemType.equals("fruits")){
            return new fruits();
        }else if(newItemType.equals("dairy")){
            return new dairy();
        }else if(newItemType.equals("meat")){
            return new meat();
        }else if(newItemType.equals("juice")){
            return new juice();
        }else if(newItemType.equals("nuts")){
            return new nuts();
        }else if(newItemType.equals("snacks")){
            return new snacks();
        }else if(newItemType.equals("soda")){
            return new soda();
        } else return null;
    }
}
