package Oberver;

import java.util.ArrayList;

public class Behavior implements ISubject{
    private ArrayList<IitemOberver> observers = new ArrayList<>();
    private EnumBehaviors behavior;
    private String itemName;

    public Behavior(String itemName, EnumBehaviors behaviorType){
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
    public void registerObserver(IitemOberver observer) {
        observers.add(observer);
        notifyObservers(EnumObserverStates.REGISTER, observer);
    }

    @Override
    public void removeObserver(IitemOberver observer) {
        notifyObservers(EnumObserverStates.REMOVE, observer);
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(EnumObserverStates observeType, IitemOberver observer) {
        observer.update(this.itemName, this.behavior, observeType);
    }

    @Override
    public void notifyObservers(EnumObserverStates observeType) {
        for(IitemOberver ob: observers){
            ob.update(this.itemName, this.behavior, observeType);
        }
    }
}
