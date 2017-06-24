package com.admin.entity.interfaces;

import com.admin.entity.dto.TiendaProductoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ITiendaProducto {

    public TiendaProductoDTO getById(int id) throws SQLException;
    public ArrayList<TiendaProductoDTO> getAll(int codigoProducto, String razonSocialTienda) throws SQLException;
    public boolean update(TiendaProductoDTO tiendaProducto) throws SQLException;
    public boolean insert(TiendaProductoDTO tiendaProducto) throws SQLException;
    public boolean delete(TiendaProductoDTO tiendaProducto) throws SQLException;
    
}
