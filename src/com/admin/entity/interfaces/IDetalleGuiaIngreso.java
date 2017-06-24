package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleGuiaIngresoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleGuiaIngreso {

    DetalleGuiaIngresoDTO getById(int id);
    ArrayList<DetalleGuiaIngresoDTO> getByAll();
    boolean updateDetalleGuiaIngreso();
    boolean insertDetalleGuiaIngreso();
    
}
