package DesignPattern.ObserverPattern;

public class ObserverUser implements Observer {

    Subject subject;

    public ObserverUser(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {

    }
}
