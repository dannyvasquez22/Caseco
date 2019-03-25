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
    
    public boolean create(CategoriaDTO almacen) throws SQLException {
        return CategoriaDAO.getInstance().create(almacen);
    }
    
    public boolean update(CategoriaDTO almacen, String nombreAnterior) throws SQLException {
        return CategoriaDAO.getInstance().update(almacen, nombreAnterior);
    }
    
    public boolean delete(CategoriaDTO almacen) throws SQLException {
        return CategoriaDAO.getInstance().delete(almacen);
    }
    
    public ArrayList<CategoriaDTO> getAllPagination(String nombre, int pagina, int registrosPagina, int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getAllByPagination(nombre, pagina, registrosPagina, modeStatus);
    }
    
    public CategoriaDTO getById(String codigo, int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().findByPk(codigo);
    }
    
    public int count(String codigo, int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getCountProductsRel(codigo);
    }
    
    public ArrayList<String> listNamesByCombo(int modeStatus) throws SQLException {
        return CategoriaDAO.getInstance().getNamesByCombo(modeStatus);
    }
    
    public int totalRow() throws SQLException {
        return CategoriaDAO.getInstance().totalRows();
    }
}
