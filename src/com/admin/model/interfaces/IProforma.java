package com.admin.model.interfaces;

import com.admin.model.dto.ProformaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IProforma {

    ProformaDTO getById(int id);
    ArrayList<ProformaDTO> getByAll();
    boolean updateProforma();
    boolean insertProforma();
    
}
