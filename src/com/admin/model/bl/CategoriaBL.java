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
        return CategoriaDAO.getInstance().insertCategoria(almacen);
    }
    
    public boolean update(CategoriaDTO almacen, String nombreAnterior) throws SQLException {
        return CategoriaDAO.getInstance().updateCategoria(almacen, nombreAnterior);
    }
    
    public boolean delete(CategoriaDTO almacen) throws SQLException {
        return CategoriaDAO.getInstance().deleteCategoria(almacen);
    }
    
    public ArrayList<CategoriaDTO> getAll(String nombre, int pagina, int registrosPagina) throws SQLException {
        return CategoriaDAO.getInstance().getByAll(nombre, pagina, registrosPagina);
    }
    
    public CategoriaDTO getById(String codigo) throws SQLException {
        return CategoriaDAO.getInstance().getById(codigo);
    }
    
    public int count(String codigo) throws SQLException {
        return CategoriaDAO.getInstance().getElementChild(codigo);
    }
    
    public ArrayList<String> listNamesByCombo() throws SQLException {
        return CategoriaDAO.getInstance().getNamesByCombo();
    }
    
    public int totalRow() throws SQLException {
        return CategoriaDAO.getInstance().totalRows();
    }
}
