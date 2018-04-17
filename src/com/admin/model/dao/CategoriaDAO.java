package com.admin.model.dao;

import com.admin.model.dto.CategoriaDTO;
import com.admin.model.interfaces.ICategoria;
import com.admin.model.interfaces.IGeneric;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class CategoriaDAO implements ICategoria, IGeneric<CategoriaDTO> {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static CategoriaDAO instance = null;
    private CategoriaDTO categoria = null;
    private ArrayList<CategoriaDTO> listCategoria = null;
    private ArrayList<String> listNamesCombo = null;
    private int value = 0;

    private CategoriaDAO() {
    
    }
    
    public static CategoriaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaDAO();
        }
        return instance;
    }    
    
    @Override
    public CategoriaDTO getById(String nombre, int modeStatus) throws SQLException {
        categoria = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT cate_nombre, cate_descripcion FROM categoria WHERE cate_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            categoria = new CategoriaDTO(
                    rs.getString("cate_nombre"),
                    rs.getString("cate_descripcion")
            );
        }
        rs.close();
        ps.close();
        
        return categoria;
    }

    @Override
    public ArrayList<CategoriaDTO> getByAllPagination(String nombre, int pagina, int registrosPagina, int modeStatus) throws SQLException {
        listCategoria = new ArrayList<>();
        categoria = null;
        if (nombre.equals("")) {
            ps = dbInstance.getConnection().prepareStatement("SELECT cate_nombre, cate_descripcion FROM categoria ORDER BY cate_nombre");
            if (pagina > -1 && registrosPagina > -1) {
                ps = dbInstance.getConnection().prepareStatement("SELECT SQL_CALC_FOUND_ROWS cate_nombre, cate_descripcion FROM categoria ORDER BY cate_nombre LIMIT ?, ?");
                ps.setInt(1, pagina);
                ps.setInt(2, registrosPagina);
            }
        } else {
            ps = dbInstance.getConnection().prepareStatement("SELECT cate_nombre, cate_descripcion FROM categoria WHERE cate_nombre LIKE ? ORDER BY cate_nombre");
            ps.setString(1, nombre + "%");
        }
        rs = ps.executeQuery();
        while(rs.next()){
            categoria = new CategoriaDTO(
                    rs.getString("cate_nombre"), 
                    rs.getString("cate_descripcion"));
            listCategoria.add(categoria);
        }
        rs.close();
        ps.close();
        
        return listCategoria;
    }

    @Override
    public boolean updateExceptional(CategoriaDTO categoria, String nombreAnterior) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE categoria SET cate_nombre = ?, cate_descripcion = ? WHERE cate_nombre = ?");
        ps.setString(1, categoria.getNombre());
        ps.setString(2, categoria.getDescripcion());
        ps.setString(3, nombreAnterior);
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(CategoriaDTO categoria) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO categoria (cate_nombre, cate_descripcion) VALUES (?, ?)");
        ps.setString(1, categoria.getNombre());
        ps.setString(2, categoria.getDescripcion());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(CategoriaDTO categoria) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM categoria WHERE cate_nombre = ?");
        ps.setString(1, categoria.getNombre());
        value = ps.executeUpdate();
        ps.close();
        return value > 0;
    }

    @Override
    public int getElementChild(String nombre, int modeStatus) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(prod_codigo) AS total FROM producto WHERE cate_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public ArrayList<String> getNamesByCombo(int modeStatus) throws SQLException {
        listNamesCombo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT cate_nombre AS nombre FROM categoria ORDER BY cate_nombre");
        rs = ps.executeQuery();
        while (rs.next()) {
            listNamesCombo.add(rs.getString("nombre"));
        }
        rs.close();
        ps.close();
        
        return listNamesCombo;
    }

    public int totalRows() throws SQLException {
        return dbInstance.totalRows();
    }

    @Override
    public boolean update(CategoriaDTO object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaDTO getById(int id, int modeStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaDTO getByName(String name, int modeStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CategoriaDTO> getByAll(int modeStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
