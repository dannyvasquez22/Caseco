package com.admin.model.interfaces;

import com.admin.model.dto.OrdenCompraDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IOrdenCompra {

    OrdenCompraDTO getById(int id);
    ArrayList<OrdenCompraDTO> getByAll();
    boolean updateOrdenCompra();
    boolean insertOrdenCompra();
    
}
