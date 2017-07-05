package com.admin.model.interfaces;

import com.admin.model.dto.GastosDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGastos {

    GastosDTO getById(int id);    
    ArrayList<GastosDTO> getByAll();
    boolean updateGastos();
    boolean insertGastos();
    
}
