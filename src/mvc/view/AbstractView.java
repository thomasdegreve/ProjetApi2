package mvc.view;

import mvc.observer.Observer;
import mvc.controller.Controller;

import java.util.Comparator;
import java.util.List;


public abstract  class AbstractView<T> implements Observer {

    protected Controller<T> controller;
    protected List<T> la;

    public void setController(Controller<T> controller) {
        this.controller = controller;
    }

    public abstract void menu();

    public abstract void affList(List la);

    public List<T> getAll(){
        Comparator<T> comparator;
        return null;
    }
    @Override
    public void update(List la) {
        this.la = la;
        affList(la);
    }
}
