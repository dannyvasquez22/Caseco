package com.admin.model.interfaces;

import com.admin.model.dto.TransportistaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ITransportista {

    TransportistaDTO getById(int id);
    ArrayList<TransportistaDTO> getByAll();
    boolean updateTransportista();
    boolean insertTransportista();
    
}
