package com.admin.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL
 * @param <T> */

public interface IGeneric<T> {
    
    public boolean insert(T object) throws SQLException;
    public boolean update(T object) throws SQLException;    
    public boolean delete(T object) throws SQLException;
    
    // Se considera INT el estado, debido a que podran ser 3 valores, 0 inactivos, 1 activos y 2 todos
    // Si no es necesario, se validara en la implementacion y sobrescritura del metodo.
    public T getById(int id, int modeStatus) throws SQLException;
    public T getById(String id, int modeStatus) throws SQLException;
    public T getByName(String name, int modeStatus) throws SQLException;
    public ArrayList<T> getByAllPagination(String name, int page, int register, int modeStatus) throws SQLException;
    public ArrayList<T> getByAll(int modeStatus) throws SQLException;    
    
}
