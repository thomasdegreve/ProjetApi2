package mvc.model;

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
}
