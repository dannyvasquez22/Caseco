package com.admin.model.interfaces;

import com.admin.model.dto.ProveedorProductoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IProveedorProducto {

    public ProveedorProductoDTO getById(int id) throws SQLException;
    public ArrayList<ProveedorProductoDTO> getByIdProducto(int id) throws SQLException;
    public ArrayList<ProveedorProductoDTO> getByAll() throws SQLException;
    public boolean update(ProveedorProductoDTO detalle) throws SQLException;
    public boolean insert(ProveedorProductoDTO detalle) throws SQLException;
    public boolean delete(ProveedorProductoDTO detalle) throws SQLException;
    
}
