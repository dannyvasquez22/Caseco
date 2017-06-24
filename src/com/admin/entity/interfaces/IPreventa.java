package com.admin.entity.interfaces;

import com.admin.entity.dto.PreventaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IPreventa {

    PreventaDTO getById(int id);
    ArrayList<PreventaDTO> getByAll();
    boolean updatePreventa();
    boolean insertPreventa();
    
}
