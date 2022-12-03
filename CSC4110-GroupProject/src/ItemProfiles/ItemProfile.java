package ItemProfiles;

import java.time.LocalDate;

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
        while(itemName.length() > 20){
            System.out.println("Item name is too long, renter the name...");
        }
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
        while(sellingPrice < 0){
            System.out.println("Enter a selling price greater than 0");
        }
        this.sellingPrice = sellingPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        while(purchasePrice < 0){
            System.out.println("Enter a purchase price greater than 0");
        }
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
        while(quantity < 0){
            System.out.println("Enter a quantity greater than 0");
        }
        this.quantity = quantity;
    }
}
