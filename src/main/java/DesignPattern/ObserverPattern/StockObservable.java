package DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class StockObservable implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    private Integer value;

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observerList){
            observer.update();
        }
    }

    @Override
    public Object getUpdate() {
        return value;
    }

    @Override
    public void postMessage(Object msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.value=(Integer)msg;
        notifyObservers();
    }
}
