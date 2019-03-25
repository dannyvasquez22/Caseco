package com.admin.model.interfaces;

import java.sql.SQLException;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICargo {
    
    public int countElemntChild(String nombre) throws SQLException;
}
