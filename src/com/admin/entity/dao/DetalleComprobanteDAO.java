package com.admin.entity.dao;

import com.admin.entity.dto.DetalleComprobanteDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleComprobanteDAO {

    DetalleComprobanteDTO getById(int id){ 
        
        DetalleComprobanteDTO detalleComprobante = null;
        
        return detalleComprobante;
    }
    
    ArrayList<DetalleComprobanteDTO> getByAll(){
        
        
        ArrayList<DetalleComprobanteDTO> detalleComprobantes = new ArrayList<>();
        
        
        return detalleComprobantes;
    }
    
    boolean updateDetalleComprobante(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertDetalleComprobante(){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
