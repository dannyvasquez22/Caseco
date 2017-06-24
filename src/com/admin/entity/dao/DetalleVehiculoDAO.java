package com.admin.entity.dao;

import com.admin.entity.dto.DetalleVehiculoDTO;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleVehiculoDAO {

    DetalleVehiculoDTO getById(int id){ 
        
        DetalleVehiculoDTO detalleVehiculo = null;
        
        return detalleVehiculo;
    }
    
    ArrayList<DetalleVehiculoDTO> getByAll(){
        
        
        ArrayList<DetalleVehiculoDTO> detalleVehiculos = new ArrayList<>();
        
        
        return detalleVehiculos;
    }
    
    boolean updateDetalleVehiculo(){
        boolean estateOperation = true;
        
        return estateOperation;
        
    }
    
    boolean insertDetalleVehiculo(){
        boolean estateOperation = true;
        
        return estateOperation;
    }    
}
