package com.admin.model.interfaces;

import com.admin.model.dto.GuiaIngresoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGuiaIngreso {

    GuiaIngresoDTO getById(int id);
    ArrayList<GuiaIngresoDTO> getByAll();
    boolean updateGuiaIngreso();
    boolean insertGuiaIngreso();
    
}
