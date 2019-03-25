package com.admin.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/*** * @author DANNY
 * @param <T> Objecet param */
public interface ICRUD<T> {

    public boolean create(T t) throws SQLException;
    
    //Cuando el objeto no tiene el atributo estado, el valor del parámetro puede ser cualquier número (0 eliminado - inactivo / 1 activo)
    public ArrayList<T> getAll(int status) throws SQLException;
    
    public boolean update(T t) throws SQLException;
    public boolean update(T t, String pk) throws SQLException; // Cuando el PK es varchar
    public boolean update(T t, int status) throws SQLException; // Eliminación lógica
    
    public boolean delete(T t) throws SQLException; // Eliminación física
    
    public T findByPk(int pk) throws SQLException;
    public T findByPk(String pk) throws SQLException;
    
    public ArrayList<T> getAllByPagination(String name, int page, int registers, int status) throws SQLException;
}
