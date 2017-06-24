package com.admin.entity.interfaces;

import com.admin.entity.dto.ComprobanteDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IComprobante {

    ComprobanteDTO getById(int id);
    ArrayList<ComprobanteDTO> getByAll();
    boolean updateComprobante();
    boolean insertComprobante();
    
}
