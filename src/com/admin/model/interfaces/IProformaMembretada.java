package com.admin.model.interfaces;

import com.admin.model.dto.ProformaMembretadaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IProformaMembretada {

    ProformaMembretadaDTO getById(int id);
    ArrayList<ProformaMembretadaDTO> getByAll();
    boolean updateProformaMembretada();
    boolean insertProformaMembretada();
    
}
