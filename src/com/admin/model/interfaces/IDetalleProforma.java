package com.admin.model.interfaces;

import com.admin.model.dto.DetalleProformaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleProforma {

    DetalleProformaDTO getById(int id);
    ArrayList<DetalleProformaDTO> getByAll();
    boolean updateDetalleProforma();
    boolean insertDetalleProforma();
    
}
