package com.admin.entity.interfaces;

import com.admin.entity.dto.EmpleadoDTO;
import com.admin.entity.pojo.EmpleadoP;
import com.admin.entity.pojo.LicenciaP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IEmpleado {

    public EmpleadoDTO getById(String codigo) throws SQLException;
    public ArrayList<EmpleadoDTO> getByAll() throws SQLException;
    public boolean updateEmpleado(EmpleadoDTO empleado, String codigoAnterior) throws SQLException;
    public boolean insertEmpleado(EmpleadoDTO empleado) throws SQLException;
    public boolean deleteEmpleado(EmpleadoDTO empleado, int status) throws SQLException;
    
    // listar empleados para el crud de usuarios
    public ArrayList<EmpleadoP> getEmpleadoCargo(String []params, int modo) throws SQLException;
    
    // listar empleados tipo conductor o chofer en el crud de choferes
    public ArrayList<LicenciaP> getByDriver() throws SQLException;
    
}
