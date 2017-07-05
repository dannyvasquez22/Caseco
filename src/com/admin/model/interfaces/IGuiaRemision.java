package com.admin.model.interfaces;

import com.admin.model.dto.GuiaRemisionDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGuiaRemision {

    GuiaRemisionDTO getById(int id);
    ArrayList<GuiaRemisionDTO> getByAll();
    boolean updateGuiaRemision();
    boolean insertGuiaRemision();
    
}
