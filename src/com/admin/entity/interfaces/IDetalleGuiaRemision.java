package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleGuiaRemisionDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleGuiaRemision {

    DetalleGuiaRemisionDTO getById(int id);
    ArrayList<DetalleGuiaRemisionDTO> getByAll();
    boolean updateDetalleGuiaRemision();
    boolean insertDetalleGuiaRemision();
    
}
