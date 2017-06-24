package com.admin.entity.dao;

import com.admin.entity.dto.OperacionStockDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class OperacionStockDAO {

    OperacionStockDTO getById(int id){ 
        
        OperacionStockDTO operacionStock = null;
        
        return operacionStock;
    }
    
    ArrayList<OperacionStockDTO> getByAll(){
        
        
        ArrayList<OperacionStockDTO> operacionesStock = new ArrayList<>();
        
        
        return operacionesStock;
    }
    
    boolean updateOperacionStock(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertOperacionStock(){
        boolean estateOperation = true;
        
        return estateOperation;
    }     
}
