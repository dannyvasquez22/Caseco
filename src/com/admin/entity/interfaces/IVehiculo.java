package com.admin.entity.interfaces;

import com.admin.entity.dto.VehiculoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IVehiculo {

    public VehiculoDTO getById(String placa) throws SQLException;
    public ArrayList<VehiculoDTO> getByAllByStatus(int status) throws SQLException;
    public boolean updateVehiculo(VehiculoDTO vehiculo, String placaAnterior) throws SQLException;
    public boolean insertVehiculo(VehiculoDTO vehiculo) throws SQLException;
    public boolean deleteVehiculo(VehiculoDTO vehiculo, int status) throws SQLException;
    
}
