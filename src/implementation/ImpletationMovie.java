package implementation;

import connexio.CRUD;
import connexio.Connexio;

import java.sql.Connection;
import java.util.List;

public class ImpletationMovie implements CRUD {

    static Connection con = Connexio.getConnection();

    @Override
    public int create(Object entity) {
        return 0;
    }

    @Override
    public Object read(int id) {
        return null;
    }

    @Override
    public List getAll() {
        return List.of();
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(int id) {

    }
}
