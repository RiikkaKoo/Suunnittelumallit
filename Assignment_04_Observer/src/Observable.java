import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    // List of all the observers for this observable.
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("New observer added.");
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed.");
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
