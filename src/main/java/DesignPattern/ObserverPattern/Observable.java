package DesignPattern.ObserverPattern;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
    Object getUpdate();
    void postMessage(Object value);
}
