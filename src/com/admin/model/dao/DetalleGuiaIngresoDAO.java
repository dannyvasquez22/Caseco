package com.admin.model.dao;

import com.admin.model.dto.DetalleGuiaIngresoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleGuiaIngresoDAO {

    DetalleGuiaIngresoDTO getById(int id){ 
        
        DetalleGuiaIngresoDTO detalleGuiaIngreso = null;
        
        return detalleGuiaIngreso;
    }
    
    ArrayList<DetalleGuiaIngresoDTO> getByAll(){
        
        
        ArrayList<DetalleGuiaIngresoDTO> detalleGuiaIngresos = new ArrayList<>();
        
        
        return detalleGuiaIngresos;
    }
    
    boolean updateDetalleGuiaIngreso(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertDetalleGuiaIngreso(){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
