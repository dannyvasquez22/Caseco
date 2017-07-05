package com.admin.model.interfaces;

import com.admin.model.dto.FacturaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IFactura {

    FacturaDTO getById(int id);
    ArrayList<FacturaDTO> getByAll();
    boolean updateFactura();
    boolean insertFactura();
    
}
