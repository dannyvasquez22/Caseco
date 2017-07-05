package com.admin.model.dao;

import com.admin.model.dto.GastosDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class GastosDAO {

    GastosDTO getById(int id){ 
        
        GastosDTO gastos = null;
        
        return gastos;
    }
    
    ArrayList<GastosDTO> getByAll(){
        
        
        ArrayList<GastosDTO> gastos = new ArrayList<>();
        
        
        return gastos;
    }
    
    boolean updateGastos(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertGastos(){
        boolean estateOperation = true;
        
        return estateOperation;
    }     
}
