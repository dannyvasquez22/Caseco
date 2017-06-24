package com.admin.entity.interfaces;

import com.admin.entity.dto.RegistroPagosDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IRegistroPagos {

    RegistroPagosDTO getById(int id);
    ArrayList<RegistroPagosDTO> getByAll();
    boolean updateRegistroPagos();
    boolean insertRegistroPagos();
    
}
