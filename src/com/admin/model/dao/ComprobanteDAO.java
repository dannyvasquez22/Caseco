package com.admin.model.dao;

import com.admin.model.dto.ComprobanteDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ComprobanteDAO {

    ComprobanteDTO getById(int id){ 
        
        ComprobanteDTO comprobante = null;
        
        return comprobante;
    }
    
    ArrayList<ComprobanteDTO> getByAll(){
        
        
        ArrayList<ComprobanteDTO> comprobantes = new ArrayList<>();
        
        
        return comprobantes;
    }
    
    boolean updateComprobante(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertComprobante(){
        boolean estateOperation = true;
        
        return estateOperation;
    }     
}
