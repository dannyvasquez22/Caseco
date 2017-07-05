package com.admin.model.interfaces;

import com.admin.model.dto.GuiaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGuia {

    GuiaDTO getById(int id);
    ArrayList<GuiaDTO> getByAll();
    boolean updateGuia();
    boolean insertGuia();
    
}
