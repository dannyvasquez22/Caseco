package com.admin.entity.interfaces;

import com.admin.entity.dto.DetalleOrdenCompraDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleOrdenCompra {

    DetalleOrdenCompraDTO getById(int id);
    ArrayList<DetalleOrdenCompraDTO> getByAll();
    boolean updateDetalleOrdenCompra();
    boolean insertDetalleOrdenCompra();
    
}
