package com.admin.model.interfaces;

import com.admin.model.dto.PreventaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IPreventa {

    PreventaDTO getById(int id);
    ArrayList<PreventaDTO> getByAll();
    boolean updatePreventa();
    boolean insertPreventa();
    
}
