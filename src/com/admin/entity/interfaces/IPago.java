package com.admin.entity.interfaces;

import com.admin.entity.dto.PagoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IPago {

    PagoDTO getById(int id);
    ArrayList<PagoDTO> getByAll();
    boolean updatePago();
    boolean insertPago();
    
}
