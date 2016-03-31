package goal.design.patterns.observer;

public interface Subject {

    public void register(Observer o);

    public void unregister(Observer o);

    public void notifyObservers();
}
