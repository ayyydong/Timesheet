package placeholder;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class ObservableValue extends Observable {
    public int test;
    protected Set<Observer> observers;


    public ObservableValue(int test) {
        this.test = test;
        observers = new HashSet<>();
    }

    public void setValue(int n) {
        this.test = n;
        setChanged();
        notifyObservers();
        System.out.println("The value has been changed");
    }

    public int getValue() {
        return test;
    }

    public void addObserver(TextObserver to) {
        observers.add(to);
    }
}
