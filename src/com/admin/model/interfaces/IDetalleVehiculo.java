package com.admin.model.interfaces;

import com.admin.model.dto.DetalleVehiculoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleVehiculo {

    DetalleVehiculoDTO getById(int id);
    ArrayList<DetalleVehiculoDTO> getByAll();
    boolean updateDetalleVehiculo();
    boolean insertDetalleVehiculo();
    
}
