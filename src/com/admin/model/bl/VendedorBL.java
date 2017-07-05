package com.admin.model.bl;

import com.admin.model.dao.VendedorDAO;
import com.admin.model.dto.VendedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class VendedorBL {
    private static VendedorBL instance = null;
    
    private VendedorBL() {
    
    }
    
    public static VendedorBL getInstance() {
        if (instance == null) {
            instance = new VendedorBL();
        }
        return instance;
    }
    
    public ArrayList<VendedorDTO> listAll(String nombre) throws SQLException {
        return VendedorDAO.getInstance().getAll(nombre);
    }
    
    public ArrayList<String> listNameByCombo(String nombre) throws SQLException {
        return VendedorDAO.getInstance().getNamesByCombo(nombre);
    }
    
    public boolean insert(VendedorDTO vendedor) throws SQLException {
        return VendedorDAO.getInstance().insert(vendedor);
    }
    
    public boolean update(VendedorDTO vendedor) throws SQLException {
        return VendedorDAO.getInstance().update(vendedor);
    }
    
    public boolean delete(VendedorDTO vendedor) throws SQLException {
        return VendedorDAO.getInstance().delete(vendedor);
    }
    
    public int getByDniByNombresByCodigo(String dni, String nombre, String codEmp) throws SQLException {
        return VendedorDAO.getInstance().getByDniByNombresByCodigo(dni, nombre, codEmp);
    }
}
