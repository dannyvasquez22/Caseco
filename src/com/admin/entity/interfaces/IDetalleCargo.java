package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleCargoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleCargo {

    public DetalleCargoDTO getById(int id) throws SQLException;
    public DetalleCargoDTO getByCodigoByCargo(String codigo, String cargo) throws SQLException;
    public ArrayList<DetalleCargoDTO> getByAll() throws SQLException;
    public boolean updateDetalleCargo(DetalleCargoDTO detalleCargo) throws SQLException;
    public boolean insertDetalleCargo(DetalleCargoDTO detalleCargo) throws SQLException;    
    
}
