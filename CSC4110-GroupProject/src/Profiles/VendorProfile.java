package Profiles;

import java.time.LocalDate;

public class VendorProfile implements UserProfiles{
        private String vendorName, vendorID, vendorPW;
        private String street, city, state;
        private String phone;
        private double balance, lastPaidAmount;
        private LocalDate lastOrderDate, discountStartDate;

        public VendorProfile(){
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
        @Override
        public double getLastPaidAmount() {
            return 0;
        }

        @Override
        public void setLastPaidAmount(double lastPaidAmount) {
            this.lastPaidAmount = lastPaidAmount;
        }

        @Override
        public LocalDate getLastOrderDate() {
            return lastOrderDate;
        }

        @Override
        public void setLastOrderDate(LocalDate lastOrderDate) {
            this.lastOrderDate = lastOrderDate;
        }
        @Override
        public String getCompanyName() {
            return vendorName;
        }

        @Override
        public String getCustomerID() {
            return null;
        }

        public String getID(){
            return vendorID;
        }

        @Override
        public String getCity() {
            return city;
        }

        @Override
        public String getStreetAddress() {
            return street;
        }

        @Override
        public String getState() {
            return state;
        }

        @Override
        public String getPhone() {
            return phone;
        }

         public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public double getBalance() {
            return balance;
        }

        public void setDiscountStartDate(LocalDate discountStartDate) {
            this.discountStartDate = discountStartDate;
        }

        public LocalDate getDiscountStartDate(){
            return discountStartDate;
        }
}
