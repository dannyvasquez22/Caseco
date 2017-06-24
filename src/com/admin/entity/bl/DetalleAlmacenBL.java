package com.admin.entity.bl;

import com.admin.entity.dao.DetalleAlmacenDAO;
import com.admin.entity.dto.DetalleAlmacenDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleAlmacenBL {
    private static DetalleAlmacenBL instance = null;
    
    private DetalleAlmacenBL() {
    
    }
    
    public static DetalleAlmacenBL getInstance() {
        if (instance == null) {
           instance = new DetalleAlmacenBL();
        }
        return instance;
    }
    
    public ArrayList<DetalleAlmacenDTO> listAllByProduct(int codigo) throws SQLException {
        return DetalleAlmacenDAO.getInstance().getAllByProduct(codigo);
    }
    
    public boolean insert(DetalleAlmacenDTO detalle) throws SQLException {
        return DetalleAlmacenDAO.getInstance().insert(detalle);
    }
    
    public boolean update(DetalleAlmacenDTO detalle) throws SQLException {
        return DetalleAlmacenDAO.getInstance().update(detalle);
    }
    
    public boolean delete(DetalleAlmacenDTO detalle) throws SQLException {
        return DetalleAlmacenDAO.getInstance().delete(detalle);
    }
}
