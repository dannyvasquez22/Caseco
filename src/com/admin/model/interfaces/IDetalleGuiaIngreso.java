package com.admin.model.interfaces;

import com.admin.model.dto.DetalleGuiaIngresoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleGuiaIngreso {

    DetalleGuiaIngresoDTO getById(int id);
    ArrayList<DetalleGuiaIngresoDTO> getByAll();
    boolean updateDetalleGuiaIngreso();
    boolean insertDetalleGuiaIngreso();
    
}
