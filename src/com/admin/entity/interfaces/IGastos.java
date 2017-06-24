package com.admin.entity.interfaces;

import com.admin.entity.dto.GastosDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGastos {

    GastosDTO getById(int id);    
    ArrayList<GastosDTO> getByAll();
    boolean updateGastos();
    boolean insertGastos();
    
}
