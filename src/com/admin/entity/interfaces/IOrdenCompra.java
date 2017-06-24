package com.admin.entity.interfaces;

import com.admin.entity.dto.OrdenCompraDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IOrdenCompra {

    OrdenCompraDTO getById(int id);
    ArrayList<OrdenCompraDTO> getByAll();
    boolean updateOrdenCompra();
    boolean insertOrdenCompra();
    
}
