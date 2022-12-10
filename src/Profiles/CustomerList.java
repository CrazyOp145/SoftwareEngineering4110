package Profiles;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CustomerList {
    private SimpleStringProperty customerID, customerName, itemID, companyName, itemName, streetAddress, city, state, phoneNumber,
            balance,lastPaidAmount, lastOrderDate, quantity, sellingPrice, purchasePrice, expireDate;
    public String getCustomerID() {
        return customerID.get();
    }
    public String getCompanyName() {
        return companyName.get();
    }
    public String getStreetAddress() {
        return streetAddress.get();
    }
    public String getCity() {
        return city.get();
    }
    public String getState() {
        return state.get();
    }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }
    public String getBalance() {
        return balance.get();
    }
    public String getLastPaidAmount() {
        return lastPaidAmount.get();
    }
    public String getLastOrderDate() {
        return lastOrderDate.get();
    }
    public String getItemID(){return itemID.get();}
    public String getItemName(){return itemName.get();}
    public String getQuantity(){return quantity.get();}
    public String getSellingPrice(){return sellingPrice.get();}
    public String getPurchasePrice(){return purchasePrice.get();}
    public String getExpireDate(){return expireDate.get();}
    public String getCustomerName(){return customerName.get();}


    public CustomerList(String customerID, String companyName, String address, String city, String state, String phoneNumber,
                        String balance, String lastPaidAmount, String lastOrderDate) {
        this.customerID = new SimpleStringProperty(customerID);
        this.companyName = new SimpleStringProperty(companyName);
        this.streetAddress = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.balance = new SimpleStringProperty(balance);
        this.lastPaidAmount = new SimpleStringProperty(lastPaidAmount);
        this.lastOrderDate = new SimpleStringProperty(lastOrderDate);
    }

    public CustomerList( String customerName, String itemID, String itemName,String purchasePrice, String expireDate, String quantity, String sellingPrice){
        this.customerName = new SimpleStringProperty(customerName);
        this.itemID = new SimpleStringProperty(itemID);
        this.itemName = new SimpleStringProperty(itemName);
        this.quantity = new SimpleStringProperty(quantity);
        this.sellingPrice = new SimpleStringProperty(sellingPrice);
        this.purchasePrice = new SimpleStringProperty(purchasePrice);
        this.expireDate = new SimpleStringProperty(expireDate);
    }


}