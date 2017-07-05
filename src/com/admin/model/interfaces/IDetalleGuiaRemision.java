package com.admin.model.interfaces;

import com.admin.model.dto.DetalleGuiaRemisionDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleGuiaRemision {

    DetalleGuiaRemisionDTO getById(int id);
    ArrayList<DetalleGuiaRemisionDTO> getByAll();
    boolean updateDetalleGuiaRemision();
    boolean insertDetalleGuiaRemision();
    
}
