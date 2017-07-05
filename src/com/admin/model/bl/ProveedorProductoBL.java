package com.admin.model.bl;

import com.admin.model.dao.ProveedorProductoDAO;
import com.admin.model.dto.ProveedorProductoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProveedorProductoBL {
    private static ProveedorProductoBL instance = null;
    
    private ProveedorProductoBL() {
    
    }
    
    public static ProveedorProductoBL getInstance() {
        if (instance == null) {
            instance = new ProveedorProductoBL();
        }
        return instance;
    }
    
    public ArrayList<ProveedorProductoDTO> listAllByProduct(int codigo) throws SQLException {
        return ProveedorProductoDAO.getInstance().getByIdProducto(codigo);
    }
    
    public boolean insert(ProveedorProductoDTO proveedor) throws SQLException {
        return ProveedorProductoDAO.getInstance().insert(proveedor);
    }
    
    public boolean update(ProveedorProductoDTO proveedor) throws SQLException {
        return ProveedorProductoDAO.getInstance().update(proveedor);
    }
    
    public boolean delete(ProveedorProductoDTO proveedor) throws SQLException {
        return ProveedorProductoDAO.getInstance().delete(proveedor);
    }
}
