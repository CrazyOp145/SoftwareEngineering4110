package Profiles.Items;

import java.util.Scanner;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class ItemProfileTest {
    public static void main(String args[]){
        //Create factory object
        ItemProfileFactory itemFactory = new ItemProfileFactory();
        ItemProfile theItem = null;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter type of item to create: ");
        if(input.hasNextLine()) {
            String itemType = input.nextLine();
            theItem = itemFactory.createItemProfile(itemType);
        }else{
            System.out.print("Please enter correct item type next time");
        }

    }

}
