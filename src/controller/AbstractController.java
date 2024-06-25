/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import domain.Entity;
import java.util.List;

/**
 *
 * @author Gazi
 */
public interface AbstractController<T extends Entity> {

    public abstract void save(T entity) throws Exception;

    public abstract void update(T entity) throws Exception;

    public abstract void delete(T entity) throws Exception;

    public abstract List<T> getAll(T entity) throws Exception;

}
