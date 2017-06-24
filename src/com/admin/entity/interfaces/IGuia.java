package com.admin.entity.interfaces;

import com.admin.entity.dto.GuiaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGuia {

    GuiaDTO getById(int id);
    ArrayList<GuiaDTO> getByAll();
    boolean updateGuia();
    boolean insertGuia();
    
}
