package connexio;

import java.util.List;

public interface CRUD<T> {
    int create(T t);
    T read(int id);
    List<T> getItems();
    void update(T t);
    void delete(int id);
}

