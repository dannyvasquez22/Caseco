package com.admin.model.bl;

import com.admin.model.dao.EmpleadoDAO;
import com.admin.model.dto.EmpleadoDTO;
import com.admin.model.pojo.EmpleadoP;
import com.admin.model.pojo.LicenciaP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoBL {
    private static EmpleadoBL instance = null;
    
    private EmpleadoBL() {
    
    }
    
    public static EmpleadoBL getInstance() {
        if (instance == null) {
            instance = new EmpleadoBL();
        }
        return instance;
    }
    
    // listar empleados para el crud de usuarios
    public ArrayList<EmpleadoP> listEmpleadoCargo(String []params, int modo) throws SQLException {
        return EmpleadoDAO.getInstance().getEmpleadoCargo(params, modo);
    }
    
    public boolean delete(EmpleadoDTO empleado, int status) throws SQLException {
        return EmpleadoDAO.getInstance().deleteEmpleado(empleado, status);
    }
    
    public boolean update(EmpleadoDTO empleado, String codigoAnterior) throws SQLException {
        return EmpleadoDAO.getInstance().updateEmpleado(empleado, codigoAnterior);
    }
    
    public EmpleadoDTO search(String codigo) throws SQLException {
        return EmpleadoDAO.getInstance().getById(codigo);
    }
    
    public boolean insert(EmpleadoDTO empleado) throws SQLException {
        return EmpleadoDAO.getInstance().insertEmpleado(empleado);
    }
    
    public ArrayList<LicenciaP> listDriver() throws SQLException {
        return EmpleadoDAO.getInstance().getByDriver();
    }
}
