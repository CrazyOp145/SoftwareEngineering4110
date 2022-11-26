package Profiles;

public class VendorProfile {
    public class vendorProfile extends UserProfiles{
        String vendorName;
        String street, city;
        char state;
        String phone;
        double balance, lPaidAmount;
        String lOrderDate, discountStartDate;


        public vendorProfile(String vendorName, String vendorID, String password, String street, String city, char state,
                             String phone, double balance, double lPaidAmount, String lOrderDate, String discountStartDate){
            super(null,null,vendorID,password);
            this.vendorName = vendorName;
            this.street = street;
            this.city = city;
            this.state = state;
            this.phone = phone;
            this.balance = balance;
            this.lPaidAmount = lPaidAmount;
            this.lOrderDate = lOrderDate;
            this.discountStartDate = discountStartDate;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setState(char state) {
            this.state = state;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public void setlPaidAmount(double lPaidAmount) {
            this.lPaidAmount = lPaidAmount;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setlOrderDate(String lOrderDate) {
            this.lOrderDate = lOrderDate;
        }

        public void setDiscountStartDate(String discountStartDate) {
            this.discountStartDate = discountStartDate;
        }
    }
}
