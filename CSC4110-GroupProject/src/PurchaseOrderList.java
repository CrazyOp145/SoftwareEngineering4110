import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class PurchaseOrderList {
        private SimpleStringProperty itemId, itemName, purchaseP, expireDate,quantity, needDate,subtotal;

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

        public String getNeedDate() {
            return needDate.get();
        }
        public String getSubtotal() {
        return subtotal.get();
    }
        public String getExpireDate() {
        return expireDate.get();
    }

    PurchaseOrderList( String itemId, String itemName, String purchaseP,String expireDate,
                       String quantity, String needDate,String subtotal) {
            this.itemId = new SimpleStringProperty(itemId);
            this.itemName = new SimpleStringProperty(itemName);
            this.purchaseP = new SimpleStringProperty(purchaseP);
            this.expireDate = new SimpleStringProperty(expireDate);
            this.quantity = new SimpleStringProperty(quantity);
            this.needDate = new SimpleStringProperty(needDate);
            this.subtotal = new SimpleStringProperty(subtotal);
        }



}
