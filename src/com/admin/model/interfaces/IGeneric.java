package com.admin.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL
 * @param <T> */

public interface IGeneric<T> {
    
    public T getById(String nombre) throws SQLException;
    public ArrayList<T> getByAll(String nombre, int pagina, int registro) throws SQLException;
    public ArrayList<String> getNamesByCombo() throws SQLException;
    public boolean update(T categoria) throws SQLException;
    public boolean insert(T categoria) throws SQLException;
    public boolean delete(T categoria) throws SQLException;
    
}
