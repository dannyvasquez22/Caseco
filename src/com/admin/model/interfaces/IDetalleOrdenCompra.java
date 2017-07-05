package com.admin.model.interfaces;

import com.admin.model.dto.DetalleOrdenCompraDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleOrdenCompra {

    DetalleOrdenCompraDTO getById(int id);
    ArrayList<DetalleOrdenCompraDTO> getByAll();
    boolean updateDetalleOrdenCompra();
    boolean insertDetalleOrdenCompra();
    
}
