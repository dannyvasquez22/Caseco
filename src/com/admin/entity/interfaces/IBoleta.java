package com.admin.entity.interfaces;

import com.admin.entity.dto.BoletaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IBoleta {
    
    BoletaDTO getById(int id);    
    ArrayList<BoletaDTO> getByAll();
    boolean updateBoleta();
    boolean insertBoleta();
    
}
