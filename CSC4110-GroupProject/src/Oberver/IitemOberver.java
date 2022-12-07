package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public interface IitemOberver {
    void update(String itemName, EnumBehaviors newBehavior, EnumObserverStates observeType);
}
