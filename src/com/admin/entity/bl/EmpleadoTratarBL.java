package com.admin.entity.bl;

import com.admin.entity.dao.EmpleadoTratarDAO;
import com.admin.entity.dto.EmpleadoTratarDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoTratarBL {
    private static EmpleadoTratarBL instance = null;
    
    private EmpleadoTratarBL() {
    
    }
    
    public static EmpleadoTratarBL getInstance() {
        if (instance == null) {
            instance = new EmpleadoTratarBL();
        }
        return instance;
    }
    
    public ArrayList<EmpleadoTratarDTO> listAll(int codigoCliente) throws SQLException {
        return EmpleadoTratarDAO.getInstance().getAll(codigoCliente);
    }
    
    public boolean insert(EmpleadoTratarDTO empleado) throws SQLException {
        return EmpleadoTratarDAO.getInstance().insert(empleado);
    }
    
    public boolean update(EmpleadoTratarDTO empleado) throws SQLException {
        return EmpleadoTratarDAO.getInstance().update(empleado);
    }
    
    public boolean delete(EmpleadoTratarDTO empleado) throws SQLException {
        return EmpleadoTratarDAO.getInstance().delete(empleado);
    }
    
    public ArrayList<String> listNameByCombo(int codigoCliente) throws SQLException {
        return EmpleadoTratarDAO.getInstance().getNamesByCombo(codigoCliente);
    }
    
    public int listByDniByNombres(String dni, String nombres) throws SQLException {
        return EmpleadoTratarDAO.getInstance().getByDniByNombres(dni, nombres);
    }
}
