package com.admin.entity.bl;

import com.admin.entity.dao.TiendaProductoDAO;
import com.admin.entity.dto.TiendaProductoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaProductoBL {
    private static TiendaProductoBL instance = null;
    
    private TiendaProductoBL() {
    
    }
    
    public static TiendaProductoBL getInstance() {
        if (instance == null) {
            instance = new TiendaProductoBL();
        }
        return instance;
    }
    
    public ArrayList<TiendaProductoDTO> listAll(int codigoProducto, String razonSocial) throws SQLException {
        return TiendaProductoDAO.getInstance().getAll(codigoProducto, razonSocial);
    }
    
    public boolean insert(TiendaProductoDTO tiendaProducto) throws SQLException {
        return TiendaProductoDAO.getInstance().insert(tiendaProducto);
    }
    
    public boolean update(TiendaProductoDTO tiendaProducto) throws SQLException {
        return TiendaProductoDAO.getInstance().update(tiendaProducto);
    }
    
    public boolean delete(TiendaProductoDTO tiendaProducto) throws SQLException {
        return TiendaProductoDAO.getInstance().delete(tiendaProducto);
    }
}
