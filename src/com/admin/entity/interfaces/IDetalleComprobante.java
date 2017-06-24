package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleComprobanteDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleComprobante {

    DetalleComprobanteDTO getById(int id);
    ArrayList<DetalleComprobanteDTO> getByAll();
    boolean updateDetalleComprobante();
    boolean insertDetalleComprobante();
    
}
