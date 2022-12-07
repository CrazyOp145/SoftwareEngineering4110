package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public interface ISubject {
    void registerObserver(IitemOberver observer);
    void removeObserver(IitemOberver observer);
    void notifyObservers(EnumObserverStates observeType, IitemOberver observer);
    void notifyObservers(EnumObserverStates observeType);
}
