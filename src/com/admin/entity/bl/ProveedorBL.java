package com.admin.entity.bl;

import com.admin.entity.dao.ProveedorDAO;
import com.admin.entity.dto.ProveedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProveedorBL {
    private static ProveedorBL instance = null;
    
    private ProveedorBL() {
    
    }
    
    public static ProveedorBL getInstance() {
        if (instance == null) {
            instance = new ProveedorBL();
        }
        return instance;
    }
    
    public ArrayList<ProveedorDTO> listAllByStatus(String []params) throws SQLException {
        return ProveedorDAO.getInstance().getAllByStatus(params);
    }
    
    public ProveedorDTO getById(String nombre) throws SQLException {
        return ProveedorDAO.getInstance().getById(nombre);
    }
    
    public boolean delete(ProveedorDTO proveedor, int status) throws SQLException {
        return ProveedorDAO.getInstance().delete(proveedor, status);
    }
    
    public boolean insert(ProveedorDTO proveedor) throws SQLException {
        return ProveedorDAO.getInstance().insert(proveedor);
    }
    
    public boolean update(ProveedorDTO proveedor, String nombreAnterior) throws SQLException {
        return ProveedorDAO.getInstance().update(proveedor, nombreAnterior);
    }
}
