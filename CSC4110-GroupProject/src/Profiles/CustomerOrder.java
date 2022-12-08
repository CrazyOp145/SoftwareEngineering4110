package Profiles;
/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CustomerOrder {
    private String OrderID;
    private String[] OrderItems;
    private double SubTotal;

    public CustomerOrder(){

    }
    public CustomerOrder(String OrderID, String[] OrderItems, double SubTotal){
        this.OrderID = OrderID;
        this.OrderItems = OrderItems;
        this.SubTotal = SubTotal;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String[] getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(String[] orderItems) {
        OrderItems = orderItems;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double subTotal) {
        SubTotal = subTotal;
    }
}
