import javafx.beans.property.SimpleStringProperty;

public class PurchaseOrderList {
        private SimpleStringProperty orderId,itemId, itemName, quantity, sellingP, purchaseP, needDate;

        public String getItemId() {
            return itemId.get();
        }

        public String getItemName() {
            return itemName.get();
        }

        public String getQuantity() {
            return quantity.get();
        }

        public String getPurchasePrice() {
            return purchaseP.get();
        }

        public String getExpireDate() {
            return needDate.get();
        }

//    PurchaseOrderList(String orderId, String itemId, String itemName, String quantity, String purchaseP, String needDate, String) {
//            this.itemId = new SimpleStringProperty(itemId);
//            this.itemName = new SimpleStringProperty(itemName);
//            this.quantity = new SimpleStringProperty(quantity);
//            this.purchaseP = new SimpleStringProperty(purchaseP);
//            this.needDate = new SimpleStringProperty(needDate);
//        }



}
