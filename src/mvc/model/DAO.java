package mvc.model;


import mvc.observer.Observer;
import mvc.view.AbstractView;

import java.util.List;
import java.util.ArrayList;

public abstract class DAO<T> {

    public abstract T add(T elt);

    public abstract boolean remove(T elt);

    public abstract T update(T elt);

    public abstract T read(T rech);

    public abstract List<T> getAll();

    public List<T> getNotification() {
        return getAll();
    }

    public void addObserver(Observer o){
        List<Observer> myObservers = new ArrayList<>();
        myObservers.add(o);
    }
}
