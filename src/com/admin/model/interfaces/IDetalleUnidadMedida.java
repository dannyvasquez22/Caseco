package com.admin.model.interfaces;

import com.admin.model.dto.DetalleUnidadMedidaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleUnidadMedida {

    public DetalleUnidadMedidaDTO getById(int id) throws SQLException;
    public ArrayList<DetalleUnidadMedidaDTO> getAllByProduct(int codigoProducto) throws SQLException;
    public boolean update(DetalleUnidadMedidaDTO detalle) throws SQLException;
    public boolean insert(DetalleUnidadMedidaDTO detalle) throws SQLException;
    public boolean delete(DetalleUnidadMedidaDTO detalle) throws SQLException;
    
}
