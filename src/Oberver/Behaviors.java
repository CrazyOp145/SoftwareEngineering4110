package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
import java.util.ArrayList;

public class Behaviors implements ISubjectExpire{
    private ArrayList<IitemOberverExpire> observers = new ArrayList<>();
    private EnumBehaviors behavior;
    private String itemName;

    public Behaviors(String itemName, EnumBehaviors behaviorType){
        this.behavior = behaviorType;
        this.itemName = itemName;
        notifyObservers(EnumObserverStates.NONE);
    }

    public EnumBehaviors getBehavior(){
        return behavior;
    }
    public void setBehavior(EnumBehaviors newBehaviorType){
        this.behavior = newBehaviorType;
        notifyObservers(EnumObserverStates.NEW_VALUE);
    }

    @Override
    public void registerObserver(IitemOberverExpire observer) {
        observers.add(observer);
        notifyObservers(EnumObserverStates.REGISTER, observer);
    }

    @Override
    public void removeObserver(IitemOberverExpire observer) {
        notifyObservers(EnumObserverStates.REMOVE, observer);
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(EnumObserverStates observeType, IitemOberverExpire observer) {
        observer.update(this.itemName, this.behavior, observeType);
    }

    @Override
    public void notifyObservers(EnumObserverStates observeType) {
        for(IitemOberverExpire ob: observers){
            ob.update(this.itemName, this.behavior, observeType);
        }
    }
}
