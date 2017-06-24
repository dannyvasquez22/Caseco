package com.admin.entity.interfaces;

import com.admin.entity.dto.ProformaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IProforma {

    ProformaDTO getById(int id);
    ArrayList<ProformaDTO> getByAll();
    boolean updateProforma();
    boolean insertProforma();
    
}
