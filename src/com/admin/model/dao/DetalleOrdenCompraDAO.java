package com.admin.model.dao;

import com.admin.model.dto.DetalleOrdenCompraDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleOrdenCompraDAO {

    DetalleOrdenCompraDTO getById(int id){ 
        
        DetalleOrdenCompraDTO detalleOrdenCompra = null;
        
        return detalleOrdenCompra;
    }
    
    ArrayList<DetalleOrdenCompraDTO> getByAll(){
        
        
        ArrayList<DetalleOrdenCompraDTO> detalleOrdenCompras = new ArrayList<>();
        
        
        return detalleOrdenCompras;
    }
    
    boolean updateDetalleOrdenCompra(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertDetalleOrdenCompra(){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
