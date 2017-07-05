package com.admin.model.bl;

import com.admin.model.dao.DetalleCargoDAO;
import com.admin.model.dto.DetalleCargoDTO;
import java.sql.SQLException;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleCargoBL {
    private static DetalleCargoBL instance = null;
    
    private DetalleCargoBL() {
    
    }
    
    public static DetalleCargoBL getInstance() {
        if (instance == null) {
           instance = new DetalleCargoBL();
        }
        return instance;
    }
    
    public DetalleCargoDTO getByCodigoByCargo(String codigo, String cargo) throws SQLException {
        return DetalleCargoDAO.getInstance().getByCodigoByCargo(codigo, cargo);
    }
    
    public boolean update(DetalleCargoDTO detalleCargo) throws SQLException {
        return DetalleCargoDAO.getInstance().updateDetalleCargo(detalleCargo);
    }
    
    public boolean insert(DetalleCargoDTO detalleCargo) throws SQLException {
        return DetalleCargoDAO.getInstance().insertDetalleCargo(detalleCargo);
    }
    
}
