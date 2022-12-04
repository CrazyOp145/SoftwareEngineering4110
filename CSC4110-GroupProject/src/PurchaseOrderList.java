import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class PurchaseOrderList {
        private SimpleStringProperty itemId, itemName, quantity, purchaseP, needDate;

        public String getItemId() {
            return itemId.get();
        }

        public String getItemName() {
            return itemName.get();
        }

        public String getPurchaseQuantity() {
            return quantity.get();
        }

        public String getPurchasePrice() {
            return purchaseP.get();
        }

        public String getNeedDate() {
            return needDate.get();
        }

    PurchaseOrderList( String itemId, String itemName, String quantity, String purchaseP, String needDate) {
            this.itemId = new SimpleStringProperty(itemId);
            this.itemName = new SimpleStringProperty(itemName);
            this.quantity = new SimpleStringProperty(quantity);
            this.purchaseP = new SimpleStringProperty(purchaseP);
            this.needDate = new SimpleStringProperty(needDate);
        }



}
