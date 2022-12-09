package Profiles.Items;

import java.time.LocalDate;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public abstract class ItemProfile {
    private int itemID;
    private String itemName;
    private int vendorID;
    private double sellingPrice;
    private double purchasePrice;
    private String itemCategory;
    private LocalDate date;
    private double quantity;

    private String unit;

    public ItemProfile() {}

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID() {
        this.itemID = IdProvider.getInstance().getUniqueId();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        //check date if it's a past date
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
