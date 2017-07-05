package com.admin.model.bl;

import com.admin.model.dao.VehiculoDAO;
import com.admin.model.dto.VehiculoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class VehiculoBL {
    private static VehiculoBL instance = null;
    
    private VehiculoBL() {
    
    }
    
    public static VehiculoBL getInstance() {
        if (instance == null) {
            instance = new VehiculoBL();
        }
        return instance;
    }
        
    public ArrayList<VehiculoDTO> getAll(int status) throws SQLException {
        return VehiculoDAO.getInstance().getByAllByStatus(status);
    }
    
    public VehiculoDTO getById(String placa) throws SQLException {
        return VehiculoDAO.getInstance().getById(placa);
    }
    
    public boolean insert(VehiculoDTO vehiculo) throws SQLException {
        return VehiculoDAO.getInstance().insertVehiculo(vehiculo);
    }
    
    public boolean update(VehiculoDTO vehiculo, String placaAnterior) throws SQLException {
        return VehiculoDAO.getInstance().updateVehiculo(vehiculo, placaAnterior);
    }
    
    public boolean delete(VehiculoDTO vehiculo, int status) throws SQLException {
        return VehiculoDAO.getInstance().deleteVehiculo(vehiculo, status);
    }
}
