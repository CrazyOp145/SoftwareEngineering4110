package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public class CheckStock implements IitemOberverExpire{


    @Override
    public void update(String itemName, EnumBehaviors newBehavior, EnumObserverStates observeType) {
        switch (observeType){
            case NEW_VALUE :
                System.out.println("Inventory Alert: " + itemName + ": Stock status update to: " + newBehavior);
                break;
            case REGISTER:
                System.out.println("Inventory: Observing item stock");
                break;
            case REMOVE:
                System.out.println("Inventory: Not observing behaviors");
                break;
            default:
                System.out.println("Nothing");
                break;
        }
    }
}