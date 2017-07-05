package com.admin.model.interfaces;

import com.admin.model.dto.PagoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IPago {

    PagoDTO getById(int id);
    ArrayList<PagoDTO> getByAll();
    boolean updatePago();
    boolean insertPago();
    
}
