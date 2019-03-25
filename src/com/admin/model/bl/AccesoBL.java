package com.admin.model.bl;

import com.admin.model.dao.AccesoDAO;
import com.admin.model.dto.AccesoDTO;
import com.admin.resource.utils.Constantes;
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

    public boolean create(AccesoDTO acceso) throws SQLException {
        return AccesoDAO.getInstance().create(acceso);
    }

    public boolean delete(AccesoDTO acceso) throws SQLException {
        return AccesoDAO.getInstance().delete(acceso);
    }

    public boolean update(AccesoDTO acceso) throws SQLException {
        return AccesoDAO.getInstance().update(acceso);
    }

    public ArrayList<AccesoDTO> getAll() throws SQLException {
        return AccesoDAO.getInstance().getAll(Constantes.I_NUM_DOS);
    }

    public AccesoDTO findById(int codigo) throws SQLException {
        return AccesoDAO.getInstance().findByPk(codigo);
    }  
    
}
