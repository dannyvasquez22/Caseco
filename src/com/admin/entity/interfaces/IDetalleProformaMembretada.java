package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleProformaMembretadaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleProformaMembretada {

    DetalleProformaMembretadaDTO getById(int id);
    ArrayList<DetalleProformaMembretadaDTO> getByAll();
    boolean updateDetalleProformaMembretada();
    boolean insertDetalleProformaMembretada();
    
}
