package com.admin.model.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY */
public interface IAlmacen {
    
    public int getElementChild(int codigo) throws SQLException;
    public ArrayList<String> getNamesByStoreCombo(String razonSocial) throws SQLException;
}
