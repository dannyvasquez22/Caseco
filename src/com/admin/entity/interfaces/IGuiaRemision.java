package com.admin.entity.interfaces;

import com.admin.entity.dto.GuiaRemisionDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGuiaRemision {

    GuiaRemisionDTO getById(int id);
    ArrayList<GuiaRemisionDTO> getByAll();
    boolean updateGuiaRemision();
    boolean insertGuiaRemision();
    
}
