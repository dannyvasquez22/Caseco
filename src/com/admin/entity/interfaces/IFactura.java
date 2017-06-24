package com.admin.entity.interfaces;

import com.admin.entity.dto.FacturaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IFactura {

    FacturaDTO getById(int id);
    ArrayList<FacturaDTO> getByAll();
    boolean updateFactura();
    boolean insertFactura();
    
}
