package persistance.dao;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {
    int create(T t) throws SQLException;

    T read(int id) throws SQLException;

    List<T> getItems() throws SQLException;

    void update(T t) throws SQLException;

    void delete(int id) throws SQLException;
}

