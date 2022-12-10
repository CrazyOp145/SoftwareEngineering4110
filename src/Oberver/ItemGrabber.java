package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
import java.util.ArrayList;

public class ItemGrabber implements ISubject{
    private ArrayList<IitemObserver> observers;
    private double quantity;

    public ItemGrabber(){
        observers = new ArrayList<>();
        //notifyObservers(EnumObserverStates.NONE);
    }

    public double getQuantity(){
        return quantity;
    }
    public void setQuantity(double newQuantity){
        this.quantity = newQuantity;
        //notifyObservers(EnumObserverStates.NEW_VALUE);
    }

    @Override
    public void registerObserver(IitemObserver newObserver) {
        observers.add(newObserver);
        //notifyObservers(EnumObserverStates.REGISTER, newObserver);
    }

    @Override
    public void removeObserver(IitemObserver deleteObserver) {
        //notifyObservers(EnumObserverStates.REMOVE, observer);
        observers.remove(deleteObserver);
        System.out.println("Observer "+ deleteObserver + " deleted");
    }


    @Override
    public void notifyObservers() {
        for(IitemObserver ob: observers){
            ob.update();
        }
    }
}
