package com.admin.model.bl;

import com.admin.model.dao.AccesoDAO;
import com.admin.model.dto.AccesoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class AccesoBL {

    private static AccesoBL instance = null;

    private AccesoBL() {

    }

    public static AccesoBL getInstance() {
        if (instance == null) {
            instance = new AccesoBL();
        }
        return instance;
    }

    public boolean insert(AccesoDTO acceso) throws SQLException {
        return AccesoDAO.getInstance().insertAcceso(acceso);
    }

    public boolean delete(AccesoDTO acceso) throws SQLException {
        return AccesoDAO.getInstance().deleteAcceso(acceso);
    }

    public boolean update(AccesoDTO acceso) throws SQLException {
        return AccesoDAO.getInstance().updateAcceso(acceso);
    }

    public ArrayList<AccesoDTO> listAll() throws SQLException {
        return AccesoDAO.getInstance().getByAll();
    }

    public AccesoDTO search(int codigo) throws SQLException {
        return AccesoDAO.getInstance().getById(codigo);
    }  
    
}
