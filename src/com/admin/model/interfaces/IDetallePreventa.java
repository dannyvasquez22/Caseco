package com.admin.model.interfaces;

import com.admin.model.dto.DetallePreventaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetallePreventa {

    DetallePreventaDTO getById(int id);
    ArrayList<DetallePreventaDTO> getByAll();
    boolean updateDetallePreventa();
    boolean insertDetallePreventa();
    
}
