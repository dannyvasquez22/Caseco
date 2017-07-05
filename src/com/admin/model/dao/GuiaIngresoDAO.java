package com.admin.model.dao;

import com.admin.model.dto.GuiaIngresoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class GuiaIngresoDAO {

    GuiaIngresoDTO getById(int id){ 
        
        GuiaIngresoDTO guiaIngreso = null;
        
        return guiaIngreso;
    }
    
    ArrayList<GuiaIngresoDTO> getByAll(){
        
        
        ArrayList<GuiaIngresoDTO> guiaIngresos = new ArrayList<>();
        
        
        return guiaIngresos;
    }
    
    boolean updateGuiaIngreso(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertGuiaIngreso(){
        boolean estateOperation = true;
        
        return estateOperation;
    }     
}
