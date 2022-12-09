package Oberver;

import javax.swing.*;

/**
 *
 * @author Paulo Burgess GN7231
 *
 */
public class CheckExpire implements IitemOberver{


    @Override
    public void update(String itemName, EnumBehaviors newBehavior, EnumObserverStates observeType) {
        switch (newBehavior){
            case EXPIRED :
                JOptionPane.showMessageDialog(null, "Two Or More Items are Expired.");
                break;
            case INSTOCK:
                System.out.println("Hello");
                break;
            default:
                System.out.println("Nothing");
                break;
        }
    }
}
