package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleProformaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleProforma {

    DetalleProformaDTO getById(int id);
    ArrayList<DetalleProformaDTO> getByAll();
    boolean updateDetalleProforma();
    boolean insertDetalleProforma();
    
}
