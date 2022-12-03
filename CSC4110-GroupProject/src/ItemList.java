import javafx.beans.property.SimpleStringProperty;

public class ItemList {
    private SimpleStringProperty itemId, itemName, quantity, sellingP, purchaseP, expireDate;
    String needDate, needQuantity;

    public void setNeedQuantity(String needQuantity) {
        this.needQuantity = needQuantity;
    }
    public void setNeedDate(String needDate) {this.needDate = needDate;
    }
    public String getNeedQuantity() {
        return needQuantity;
    }
    public String getNeedDate() {
        return needDate;
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


    ItemList(String itemId, String itemName, String quantity, String sellingP, String purchaseP, String expireDate) {
        this.itemId = new SimpleStringProperty(itemId);
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleStringProperty(quantity);
        this.sellingP = new SimpleStringProperty(sellingP);
        this.purchaseP = new SimpleStringProperty(purchaseP);
        this.expireDate = new SimpleStringProperty(expireDate);
    }


}
