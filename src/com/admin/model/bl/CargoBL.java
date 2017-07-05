package com.admin.model.bl;

import com.admin.model.dao.CargoDAO;
import com.admin.model.dto.CargoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class CargoBL {
    private static CargoBL instance = null;
    
    private CargoBL() {
    
    }
    
    public static CargoBL getInstance() {
        if (instance == null) {
            instance = new CargoBL();
        }
        return instance;
    }
    
    // listar cargos en combos para el listado de empleados
    public ArrayList<String> listAllByCombo(int estado) throws SQLException {
        return CargoDAO.getInstance().getAllByCombo(estado);
    }
    
    public ArrayList<CargoDTO> listAllByStatus(int estado) throws SQLException {
        return CargoDAO.getInstance().getByAllByStatus(estado);
    }
    
    public CargoDTO listByName(String nombre) throws SQLException {
        return CargoDAO.getInstance().getById(nombre);
    }

    public boolean insert(CargoDTO cargo) throws SQLException {
        return CargoDAO.getInstance().insert(cargo);
    }
    
    public boolean update(CargoDTO cargo, String nombreAnterior) throws SQLException {
        return CargoDAO.getInstance().update(cargo, nombreAnterior);
    }
    
    public boolean delete(CargoDTO cargo, int status) throws SQLException {
        return CargoDAO.getInstance().delete(cargo, status);
    }
    
    public int count(String nombre) throws SQLException {
        return CargoDAO.getInstance().countElemntChild(nombre);
    }
    
}
