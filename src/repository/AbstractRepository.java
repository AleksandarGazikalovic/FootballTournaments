/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import connection.DBConnection;
import domain.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gazi
 */
public abstract class AbstractRepository<T extends Entity> implements RepositoryInterface<T> {

    private final DBConnection dbConnection;

    public AbstractRepository() {
        this.dbConnection = DBConnection.getInstance();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getById(T entity) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        String query = "SELECT * FROM " + entity.getClassName() + " WHERE " + entity.getWhereCondition();
        boolean signal;
        try {
            st = dbConnection.connection.createStatement();
            rs = st.executeQuery(query);
            signal = rs.next();
            if (signal == true) {
                entity = (T) entity.getNewRecord(rs);
            } else {
                entity = null;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dbConnection.close(null, st, rs);
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Entity entity) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        String query = "SELECT * FROM " + entity.getClassName()+ " " + entity.join();
        List<T> ls = new ArrayList<>();
        try {
            st = dbConnection.connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ls.add((T) entity.getNewRecord(rs));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dbConnection.close(null, st, rs);
        }
        return ls;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findBy(Entity entity, String where) throws SQLException {
        ResultSet rs = null;
        Statement st = null;
        String query = "SELECT * FROM " + entity.getClassName() + " WHERE " + where;
        List<T> ls = new ArrayList<>();
        try {
            st = dbConnection.connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ls.add((T) entity.getNewRecord(rs));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dbConnection.close(null, st, rs);
        }
        return ls;
    }

    @Override
    public Long save(Entity entity) throws SQLException {
        String query = "INSERT INTO " + entity.getClassName() + " VALUES (" + entity.getAtrValue() + ")";
        System.out.println(query);
        return dbConnection.executeUpdate(query);
    }

    @Override
    public Long update(Entity entity) throws SQLException {
        String query = "UPDATE " + entity.getClassName() + " SET " + entity.setAtrValue() + " WHERE "
                + entity.getWhereCondition();
        System.out.println(query);
        return dbConnection.executeUpdate(query);
    }

    @Override
    public Long delete(Entity entity) throws SQLException {
        String query = "DELETE FROM " + entity.getClassName() + " WHERE " + entity.getWhereCondition();
        System.out.println(query);
        return dbConnection.executeUpdate(query);
    }

}
