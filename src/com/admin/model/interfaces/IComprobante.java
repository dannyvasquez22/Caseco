package com.admin.model.interfaces;

import com.admin.model.dto.ComprobanteDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IComprobante {

    ComprobanteDTO getById(int id);
    ArrayList<ComprobanteDTO> getByAll();
    boolean updateComprobante();
    boolean insertComprobante();
    
}
