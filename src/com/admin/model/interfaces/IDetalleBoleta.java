package com.admin.model.interfaces;

import com.admin.model.dto.DetalleBoletaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleBoleta {

    DetalleBoletaDTO getById(int id);
    ArrayList<DetalleBoletaDTO> getByAll();
    boolean updateDetalleBoleta();
    boolean insertDetalleBoleta();
    
}
