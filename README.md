# SoftwareEngineering4110

## WSU INC. Wholesale Food Distribution
* For information on the application visit the wiki or click the link: [https://github.com/CrazyOp145/SoftwareEngineering4110/wiki]
* For a guide on how to install: [https://github.com/CrazyOp145/SoftwareEngineering4110/blob/main/installation.md]


## Run Application in Intellij IDEA

Firstly, open the file within Intellij IDEA. 

Then open the src folder, open the Profiles folder, then the Login folder.

Next, open up the LoginValidationGUI.java.

Then at the top of the IDE select Run and Run the LoginValidationGUI.java.

## SAMPLE LOGIN

User ID: 123456

Password: Chris1234

User Role: owner

See UserData.csv for more Logins

## Authors/Contributers

### Mahz Alam: Features #3 & #7
#### Feature 3
Feature 3 is the vendor profile. The vendor profile shall have it's own id and name. 
To create a vendor profile you must be travel to the create tab on the user menu and select vendor profile. 
If the box is not solid then you must sign into a valid account. 
To be able to update or search for one you must do a similar selection where you can click on the vendor option for the given tabs available.
Due to scarce time and issues happening at home that my team was aware of, I was unable to fully finish my feature 3
however I made enough for my team to be able to test.

#### Feature 7
Although feature 7 was incomplete, the goal was to create an invoice using the customer orders. 
The customer invoice shall be created by taking the file CustomerOrder.csv and reading information to be able to make a full
invoice for the specified customer. Due to odd styling of the CustomerOrder.csv, reading the csv file became difficult
and we decided to make a mock CustomInvoice.csv so my team could properly test their features.
The logic for feature 7 is still available in the code.

### Paulo Burgess: Features #2 & #6
#### Feature 2
For feature two when a user of type Owner logs into the system it will allow them
to create a Customer Profile. Once Customer profiles are created the Owner user will then be able
to search for different customer profiles using their ID's or names. They will also be able to see
a full list of Customer Profiles. They can also delete or update any customer profiles. Deleting a customer
profile will also cause the system to delete all linked invoices linked to that profile.
 *NOTE * Feature 7 was not implemented, so I needed to test this feature using sample Invoices it was hard coded in. The hard coded
file is called "customerInvoicesTest.csv" you can edit the ID in there to match the ID of any customer to ensure that it deletes it
*NOTE END *
#### Feature 6
For feature 6 when a salesperson user logs into the System they will be able to create a
customer order for a customer profile. It will allow them to add 1-5 items to an order for a specific order
and choose need by dates for all of the items they select as well as the quantity they need. It will automatically update the quantity on hand
of that item.

### Shijie Du: Features #4 & #5
#### Feature 4
The feature 4 is mostly about creating the item profile. As role of a purchase user; owner user; inventory manager user you can create, update 
delete and search for an item that is in the system. All users should be able to view a list of item in the system. 

#### Feature 6
Feature 6 allow purchaser user to create a purchase order to make a purchase form the chosen vendor. Evertime a new purchse order is 
created, the vendor will receive a update for their balance as well. All purchaser user should also be able to view the purchase by it's 
order number. 

### David Her: Features #1 & #8
#### Feature 1
Feature 1 includes main 5 functions for Owners and Administrators. The main feature is for the system to log in and log out the user. 
Then the other funcstion are to allow the Owner and Administrators to create, update, search, and delete User Profiles. 
The feature also restricts the access of certain functions of Users based on what the User Role is.

#### Feature 8
Feature 8 consists of small functions that are parts of every other feature. These samll functions include searching for expired items, seasonal discounts, unpaid invoices, etc. I was not able to implement any of these because of the time constraint and issues we had with other code.
