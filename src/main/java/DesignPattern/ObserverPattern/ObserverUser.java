package DesignPattern.ObserverPattern;

public class ObserverUser implements Observer {

    Observable observable;

    public ObserverUser(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {

    }
}
