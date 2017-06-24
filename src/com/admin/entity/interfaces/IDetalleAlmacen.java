package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleAlmacenDTO;
import java.sql.SQLException;
import java.util.ArrayList;


/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleAlmacen {

    public DetalleAlmacenDTO getById(int id) throws SQLException;
    public ArrayList<DetalleAlmacenDTO> getAllByProduct(int codigo) throws SQLException;
    public boolean update(DetalleAlmacenDTO detalle) throws SQLException;
    public boolean insert(DetalleAlmacenDTO detalle) throws SQLException;
    public boolean delete(DetalleAlmacenDTO detalle) throws SQLException;
    
}
