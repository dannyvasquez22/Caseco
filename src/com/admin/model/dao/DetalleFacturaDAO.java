package com.admin.model.dao;

import com.admin.model.dto.DetalleFacturaDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleFacturaDAO {

    DetalleFacturaDTO getById(int id){ 
        
        DetalleFacturaDTO detalleFactura = null;
        
        return detalleFactura;
    }
    
    ArrayList<DetalleFacturaDTO> getByAll(){
        
        
        ArrayList<DetalleFacturaDTO> detalleFacturas = new ArrayList<>();
        
        
        return detalleFacturas;
    }
    
    boolean updateDetalleFactura(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertDetalleFactura(){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
