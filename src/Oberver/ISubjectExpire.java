package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public interface ISubjectExpire {
    void registerObserver(IitemOberverExpire observer);
    void removeObserver(IitemOberverExpire observer);
    void notifyObservers(EnumObserverStates observeType, IitemOberverExpire observer);
    void notifyObservers(EnumObserverStates observeType);
}
