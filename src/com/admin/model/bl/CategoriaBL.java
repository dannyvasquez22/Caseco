package com.admin.model.bl;

import com.admin.model.dao.CategoriaDAO;
import com.admin.model.dto.CategoriaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class CategoriaBL {
    private static CategoriaBL instance = null;
    
    private CategoriaBL() {
    
    }
    
    public static CategoriaBL getInstance() {
        if (instance == null) {
            instance = new CategoriaBL();
        }
        return instance;
    }
    
    public boolean insert(CategoriaDTO almacen) throws SQLException {
        return CategoriaDAO.getInstance().insert(almacen);
    }
    
    public boolean update(CategoriaDTO almacen, String nombreAnterior) throws SQLException {
        return CategoriaDAO.getInstance().updateExceptional(almacen, nombreAnterior);
    }
    
    public boolean delete(CategoriaDTO almacen) throws SQLException {
        return CategoriaDAO.getInstance().delete(almacen);
    }
    
    public ArrayList<CategoriaDTO> getAllPagination(String nombre, int pagina, int registrosPagina, int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getByAllPagination(nombre, pagina, registrosPagina, modeStatus);
    }
    
    public CategoriaDTO getById(String codigo, int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getById(codigo, modeStatus);
    }
    
    public int count(String codigo, int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getElementChild(codigo, modeStatus);
    }
    
    public ArrayList<String> listNamesByCombo(int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getNamesByCombo(modeStatus);
    }
    
    public int totalRow() throws SQLException {
        return CategoriaDAO.getInstance().totalRows();
    }
}
