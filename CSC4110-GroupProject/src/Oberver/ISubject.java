package Oberver;

public interface ISubject {
    void registerObserver(IitemOberver observer);
    void removeObserver(IitemOberver observer);
    void notifyObservers(EnumObserverStates observeType, IitemOberver observer);
    void notifyObservers(EnumObserverStates observeType);
}
