import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class ItemList {
    private SimpleStringProperty itemId, itemName, quantity, sellingP, purchaseP, expireDate, itemCategory, unit;
    String needDate, needQuantity;

    public void setNeedQuantity(String needQuantity) {
        this.needQuantity = needQuantity;
    }
    public void setNeedDate(String needDate) {this.needDate = needDate;}
    public String getNeedQuantity() {
        return needQuantity;
    }
    public String getNeedDate() {
        return needDate;
    }
    public String getItemCategory() {
        return itemCategory.get();
    }
    public String getUnit() {
        return unit.get();
    }
    public String getItemId() {
        return itemId.get();
    }

    public String getItemName() {
        return itemName.get();
    }

    public String getQuantity() {
        return quantity.get();
    }

    public String getSellingPrice() {
        return sellingP.get();
    }

    public String getPurchasePrice() {
        return purchaseP.get();
    }

    public String getExpireDate() {
        return expireDate.get();
    }


    ItemList(){};
    ItemList(String itemId, String itemName, String quantity
            , String sellingP, String purchaseP, String expireDate) {
        this.itemId = new SimpleStringProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleStringProperty(quantity);
        this.sellingP = new SimpleStringProperty(sellingP);
        this.purchaseP = new SimpleStringProperty(purchaseP);
        this.expireDate = new SimpleStringProperty(expireDate);
    }

    ItemList(String itemId, String itemName, String quantity, String sellingP,
             String purchaseP, String expireDate, String itemCategory, String unit) {
        this.itemId = new SimpleStringProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleStringProperty(quantity);
        this.sellingP = new SimpleStringProperty(sellingP);
        this.purchaseP = new SimpleStringProperty(purchaseP);
        this.expireDate = new SimpleStringProperty(expireDate);
        this.itemCategory = new SimpleStringProperty(itemCategory);
        this.unit = new SimpleStringProperty(unit);
        //this.needDate = needDate;
        //this.needQuantity = needQuantity;
    }


}
