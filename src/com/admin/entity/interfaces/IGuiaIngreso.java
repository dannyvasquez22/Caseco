package com.admin.entity.interfaces;

import com.admin.entity.dto.GuiaIngresoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IGuiaIngreso {

    GuiaIngresoDTO getById(int id);
    ArrayList<GuiaIngresoDTO> getByAll();
    boolean updateGuiaIngreso();
    boolean insertGuiaIngreso();
    
}
