package com.admin.model.interfaces;

import com.admin.model.dto.DetalleFacturaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleFactura {

    DetalleFacturaDTO getById(int id);
    ArrayList<DetalleFacturaDTO> getByAll();
    boolean updateDetalleFactura();
    boolean insertDetalleFactura();
    
}
