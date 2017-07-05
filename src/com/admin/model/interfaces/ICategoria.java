package com.admin.model.interfaces;

import com.admin.model.dto.CategoriaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICategoria {

    public CategoriaDTO getById(String nombre) throws SQLException;
    public int getElementChild(String nombre) throws SQLException;
    public ArrayList<CategoriaDTO> getByAll(String nombre) throws SQLException;
    public ArrayList<String> getNamesByCombo() throws SQLException;
    public boolean updateCategoria(CategoriaDTO categoria, String nombreAnterior) throws SQLException;
    public boolean insertCategoria(CategoriaDTO categoria) throws SQLException;
    public boolean deleteCategoria(CategoriaDTO categoria) throws SQLException;
    
}
