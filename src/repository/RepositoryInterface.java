/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain.Entity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gazi
 */
public interface RepositoryInterface<T extends Entity> {

    public Entity getById(Entity entity) throws SQLException;

    public List<T> getAll(T entity) throws SQLException;

    public List<T> findBy(Entity entity, String where) throws SQLException;

    boolean save(Entity entity) throws SQLException;

    boolean update(Entity entity) throws SQLException;

    boolean delete(Entity entity) throws SQLException;
}
