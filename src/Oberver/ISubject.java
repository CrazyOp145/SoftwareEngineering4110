package Oberver;
/**
 *
 * @author Shijie DU  HG5241
 *
 */
public interface ISubject {
    void registerObserver(IitemObserver observer);
    void removeObserver(IitemObserver observer);
    void notifyObservers();
}
