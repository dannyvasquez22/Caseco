package com.admin.model.interfaces;

import com.admin.model.dto.EmpleadoTratarDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IEmpleadoTratar {

    public EmpleadoTratarDTO getById(int id) throws SQLException;
    public ArrayList<EmpleadoTratarDTO> getAll(int codigo) throws SQLException;
    public ArrayList<String> getNamesByCombo(int codigo) throws SQLException;
    public int getByDniByNombres(String dni, String nombres) throws SQLException;
    public boolean update(EmpleadoTratarDTO empleado) throws SQLException;
    public boolean insert(EmpleadoTratarDTO empleado) throws SQLException;
    public boolean delete(EmpleadoTratarDTO empleado) throws SQLException;
    
}
