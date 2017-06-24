package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleBoletaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleBoleta {

    DetalleBoletaDTO getById(int id);
    ArrayList<DetalleBoletaDTO> getByAll();
    boolean updateDetalleBoleta();
    boolean insertDetalleBoleta();
    
}
