package com.admin.entity.interfaces;

import com.admin.entity.dto.AccesoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IAcceso {

    public AccesoDTO getById(int codigo) throws SQLException;
    public ArrayList<AccesoDTO> getByAll() throws SQLException;    
    public boolean updateAcceso(AccesoDTO acceso) throws SQLException;
    public boolean insertAcceso(AccesoDTO acceso) throws SQLException;
    public boolean deleteAcceso(AccesoDTO acceso) throws SQLException;
//    public ArrayList<AccesoDTO> getByAccessUser(String []elementsQuery) throws SQLException;

}
