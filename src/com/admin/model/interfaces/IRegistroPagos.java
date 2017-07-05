package com.admin.model.interfaces;

import com.admin.model.dto.RegistroPagosDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IRegistroPagos {

    RegistroPagosDTO getById(int id);
    ArrayList<RegistroPagosDTO> getByAll();
    boolean updateRegistroPagos();
    boolean insertRegistroPagos();
    
}
