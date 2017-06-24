package com.admin.entity.interfaces;

import com.admin.entity.dto.DetallePreventaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetallePreventa {

    DetallePreventaDTO getById(int id);
    ArrayList<DetallePreventaDTO> getByAll();
    boolean updateDetallePreventa();
    boolean insertDetallePreventa();
    
}
