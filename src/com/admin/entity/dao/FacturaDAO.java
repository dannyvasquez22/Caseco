package com.admin.entity.dao;

import com.admin.entity.dto.FacturaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class FacturaDAO {

    FacturaDTO getById(int id){ 
        
        FacturaDTO factura = null;
        
        return factura;
    }
    
    ArrayList<FacturaDTO> getByAll(){
        
        
        ArrayList<FacturaDTO> facturas = new ArrayList<>();
        
        
        return facturas;
    }
    
    boolean updateFactura(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertFactura(){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
