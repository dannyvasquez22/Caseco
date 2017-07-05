package com.admin.model.bl;

import com.admin.model.dao.DetalleProveedorDAO;
import com.admin.model.dto.DetalleProveedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleProveedorBL {
    private static DetalleProveedorBL instance = null;
    
    private DetalleProveedorBL() {
    
    }
    
    public static DetalleProveedorBL getInstance() {
        if (instance == null) {
            instance = new DetalleProveedorBL();
        }
        return instance;
    }
    
    public ArrayList<DetalleProveedorDTO> getByProveedor(String nombre) throws SQLException {
        return DetalleProveedorDAO.getInstance().getByProveedor(nombre);
    }
    
    public boolean insert(DetalleProveedorDTO detalleProveedor) throws SQLException {
        return DetalleProveedorDAO.getInstance().insert(detalleProveedor);
    }
    
    public boolean update(DetalleProveedorDTO detalleProveedor) throws SQLException {
        return DetalleProveedorDAO.getInstance().update(detalleProveedor);
    }
    
    public boolean delete(DetalleProveedorDTO detalleProveedor) throws SQLException {
        return DetalleProveedorDAO.getInstance().delete(detalleProveedor);
    }
}
