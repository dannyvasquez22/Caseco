package com.admin.model.bl;

import com.admin.model.dao.MarcaDAO;
import com.admin.model.dto.MarcaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class MarcaBL {
    private static MarcaBL instance = null;
    
    private MarcaBL() {
    
    }
    
    public static MarcaBL getInstance() {
        if (instance == null) {
            instance = new MarcaBL();
        }
        return instance;
    }
        
    public ArrayList<MarcaDTO> listAll(String nombre) throws SQLException {
        return MarcaDAO.getInstance().getAll(nombre);
    }
    
    public MarcaDTO getById(String nombre) throws SQLException {
        return MarcaDAO.getInstance().getById(nombre);
    }
    
    public boolean insert(MarcaDTO marca) throws SQLException {
        return MarcaDAO.getInstance().insertMarca(marca);
    }
    
    public boolean update(MarcaDTO marca, String nombreAnterior) throws SQLException {
        return MarcaDAO.getInstance().updateMarca(marca, nombreAnterior);
    }
    
    public boolean delete(MarcaDTO marca) throws SQLException {
        return MarcaDAO.getInstance().deleteMarca(marca);
    }
    
    public int count(String nombre) throws SQLException {
        return MarcaDAO.getInstance().getElementChild(nombre);
    }
}
