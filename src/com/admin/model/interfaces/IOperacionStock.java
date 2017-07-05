package com.admin.model.interfaces;

import com.admin.model.dto.OperacionStockDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IOperacionStock {

    OperacionStockDTO getById(int id);
    ArrayList<OperacionStockDTO> getByAll();
    boolean updateOperacionStock();
    boolean insertOperacionStock();
    
}
