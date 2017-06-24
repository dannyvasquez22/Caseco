package com.admin.entity.interfaces;

import com.admin.entity.dto.OperacionStockDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IOperacionStock {

    OperacionStockDTO getById(int id);
    ArrayList<OperacionStockDTO> getByAll();
    boolean updateOperacionStock();
    boolean insertOperacionStock();
    
}
