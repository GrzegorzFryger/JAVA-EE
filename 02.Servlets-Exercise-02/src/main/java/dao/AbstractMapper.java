package dao;

import model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hsqldb.result.ResultConstants.RETURN_GENERATED_KEYS;

public abstract class AbstractMapper<T extends Entity> {

    protected Connection connection;
    private Map<Long, T> loadedMap;

    protected AbstractMapper(Connection connection) {


        this.connection = connection;
        loadedMap = new HashMap<>();

    }


    abstract protected String findStatement();

    abstract protected String findStatementAll();

    abstract protected String insertStatement();

    abstract protected String updateStatement();

    abstract protected String removeStatement();


    abstract protected void parametrizeInsertStatement(PreparedStatement statement, T entity) throws SQLException;

    abstract protected void parametrizeUpdateStatement(PreparedStatement statement, T entity) throws SQLException;

    abstract protected T doLoad(ResultSet rs) throws SQLException;


    public T getOne(Long id) {

        T result = loadedMap.get(id);

        if (result != null) {
            return result;
        }

        PreparedStatement findStatement = null;

        try {
            findStatement = connection.prepareStatement(findStatement());
            findStatement.setLong(1, id);
            ResultSet rs = findStatement.executeQuery(); //
            rs.next();

            result = load(rs);
            return result;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public List<T> getAll() {
        List<T> results = new ArrayList();

        PreparedStatement findStatement = null;

        try {
            findStatement = connection.prepareStatement(findStatementAll());

            ResultSet rs = findStatement.executeQuery();

            while (rs.next()) {
                T result = load(rs);

                results.add(result);
            }
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteOne(Long id) {

        PreparedStatement removeStatement = null;
        try {
            removeStatement = connection.prepareStatement(removeStatement());

            removeStatement.setLong(1, id);

            removeStatement.executeUpdate();

            clearMap(id);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void persistAdd(T entity)  {

        PreparedStatement addStatement = null;

        try {
            addStatement = connection.prepareStatement(insertStatement(), RETURN_GENERATED_KEYS);

            parametrizeInsertStatement(addStatement, entity);

            addStatement.executeUpdate();

            ResultSet generatedKeys = addStatement.getGeneratedKeys();
            generatedKeys.next();

            entity.setId(generatedKeys.getLong(1));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void persistUpdate(T entity) {
        PreparedStatement updateStatement = null;
        try {

            updateStatement = connection.prepareStatement(updateStatement());

            parametrizeUpdateStatement(updateStatement, entity);

            updateStatement.executeUpdate();

            clearMap(entity.getId());



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected T load(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        if (loadedMap.containsKey(id)) {
            return loadedMap.get(id);
        }

        T result = doLoad(rs);
        loadedMap.put(id, result);
        return result;
    }

    protected void clearMap(Long id) {
        if (loadedMap.containsKey(id)) {
            loadedMap.remove(id);
        }

    }


}

