package com.admin.model.bl;

import com.admin.model.dao.DetalleTiendaDAO;
import com.admin.model.dto.DetalleTiendaDTO;
import com.admin.model.pojo.TiendaAlmacenP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleTiendaBL {
    private static DetalleTiendaBL instance = null;
    
    private DetalleTiendaBL() {
    
    }
    
    public static DetalleTiendaBL getInstance() {
        if (instance == null) {
           instance = new DetalleTiendaBL();
        }
        return instance;
    }
        
    public boolean update(DetalleTiendaDTO detalle) throws SQLException {
        return DetalleTiendaDAO.getInstance().updateDetalleTienda(detalle);
    }
    
    public boolean insert(DetalleTiendaDTO detalle) throws SQLException {
        return DetalleTiendaDAO.getInstance().insertDetalleTienda(detalle);
    }
    
    public boolean delete(DetalleTiendaDTO detalle) throws SQLException {
        return DetalleTiendaDAO.getInstance().deleteDetalleTienda(detalle);
    }
    
    public ArrayList<TiendaAlmacenP> listAllDetail(int codigo) throws SQLException {
        return DetalleTiendaDAO.getInstance().getAllDetail(codigo);
    }
    
    public DetalleTiendaDTO getByAlmacenByTienda(int almacen, int tienda) throws SQLException {
        return DetalleTiendaDAO.getInstance().getByAlmacenByTienda(almacen, tienda);
    }
}
