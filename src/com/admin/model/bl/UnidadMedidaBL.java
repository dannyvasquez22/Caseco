package com.admin.model.bl;

import com.admin.model.dao.UnidadMedidaDAO;
import com.admin.model.dto.UnidadMedidaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class UnidadMedidaBL {
    private static UnidadMedidaBL instance = null;
    
    private UnidadMedidaBL() {
    
    }
    
    public static UnidadMedidaBL getInstance() {
        if (instance == null) {
            instance = new UnidadMedidaBL();
        }
        return instance;
    }
        
    public ArrayList<UnidadMedidaDTO> listAll(String nombre) throws SQLException {
        return UnidadMedidaDAO.getInstance().getAll(nombre);
    }
    
    public UnidadMedidaDTO getById(String nombre) throws SQLException {
        return UnidadMedidaDAO.getInstance().getById(nombre);
    }
    
    public boolean insert(UnidadMedidaDTO unidad) throws SQLException {
        return UnidadMedidaDAO.getInstance().insertUnidadMedida(unidad);
    }
    
    public boolean update(UnidadMedidaDTO unidad, String nombreAnterior) throws SQLException {
        return UnidadMedidaDAO.getInstance().updateUnidadMedida(unidad, nombreAnterior);
    }
    
    public boolean delete(UnidadMedidaDTO unidad) throws SQLException {
        return UnidadMedidaDAO.getInstance().deleteUnidadMedida(unidad);
    }
    
    public int count(String nombre) throws SQLException {
        return UnidadMedidaDAO.getInstance().getElementChild(nombre);
    }
    
    public ArrayList<String> listNamesByCombo() throws SQLException {
        return UnidadMedidaDAO.getInstance().getNamesByCombo();
    }
}
