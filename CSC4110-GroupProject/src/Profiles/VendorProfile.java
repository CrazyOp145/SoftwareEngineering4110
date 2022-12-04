package Profiles;
public class VendorProfile implements UserProfiles{
        private String vendorName, vendorID, vendorPW;
        private String street, city, state;
        private String phone;
        private double balance, lPaidAmount;
        private String lOrderDate, discountStartDate;

        public VendorProfile(){
        }
        public VendorProfile(String vendorName, String street, String city, String state,
                             String phone, double balance, double lPaidAmount, String lOrderDate, String discountStartDate){
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

        @Override
        public void setFirstName(String firstName) {
            vendorName = firstName;
        }

        @Override
        public void setLastName(String lName) {
            lName = null;
        }

        @Override
        public void setID(String id) {
            vendorID = id;
        }

        @Override
        public void setPassword(String pw) {
            vendorPW = pw;
        }

        @Override
        public String getUserType() {
            return "Vendor";
        }

        @Override
        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public void setState(String state) {
            this.state = state;
        }

        @Override
        public void setCity(String city) {
            this.city = city;
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
