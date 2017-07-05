package com.admin.model.interfaces;

import com.admin.model.dto.BoletaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IBoleta {
    
    BoletaDTO getById(int id);    
    ArrayList<BoletaDTO> getByAll();
    boolean updateBoleta();
    boolean insertBoleta();
    
}
