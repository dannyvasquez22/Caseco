package com.admin.model.interfaces;

import java.sql.SQLException;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICategoria {

    public int getCountProductsRel(String nombre) throws SQLException;    
}
