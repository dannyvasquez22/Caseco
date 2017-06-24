package com.admin.entity.bl;

import com.admin.entity.dao.DetalleUnidadMedidaDAO;
import com.admin.entity.dto.DetalleUnidadMedidaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleUnidadMedidaBL {
    private static DetalleUnidadMedidaBL instance = null;
    
    private DetalleUnidadMedidaBL() {
    
    }
    
    public static DetalleUnidadMedidaBL getInstance() {
        if (instance == null) {
            instance = new DetalleUnidadMedidaBL();
        }
        return instance;
    }
        
    public ArrayList<DetalleUnidadMedidaDTO> listAllByProduct(int codigoProducto) throws SQLException {
        return DetalleUnidadMedidaDAO.getInstance().getAllByProduct(codigoProducto);
    }
    
    public boolean insert(DetalleUnidadMedidaDTO detalle) throws SQLException {
        return DetalleUnidadMedidaDAO.getInstance().insert(detalle);
    }
    
    public boolean update(DetalleUnidadMedidaDTO detalle) throws SQLException {
        return DetalleUnidadMedidaDAO.getInstance().update(detalle);
    }
    
    public boolean delete(DetalleUnidadMedidaDTO detalle) throws SQLException {
        return DetalleUnidadMedidaDAO.getInstance().delete(detalle);
    }
}
