package com.admin.model.dao;

import com.admin.model.dto.CategoriaDTO;
import com.admin.model.interfaces.ICategoria;
import com.admin.model.interfaces.ICRUD;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Constantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/** * @author DANNY VASQUEZ RAFAEL */

public class CategoriaDAO implements ICRUD<CategoriaDTO>, ICategoria {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static CategoriaDAO instance = null;
    private CategoriaDTO categoria = null;
    private ArrayList<CategoriaDTO> listCategoria = null;
    private int value = Constantes.I_NUM_CERO;
    private final String q_getAll = "SELECT cate_nombre, cate_descripcion FROM categoria";
    private final String q_count = "SELECT COUNT(prod_codigo) AS total FROM producto WHERE cate_nombre = ?";
    private final String q_delete = "DELETE FROM categoria WHERE cate_nombre = ?";
    private final String q_create = "INSERT INTO categoria (cate_nombre, cate_descripcion) VALUES (?, ?)";
    private final String q_update = "UPDATE categoria SET cate_nombre = ?, cate_descripcion = ? WHERE cate_nombre = ?";
    private final String q_paginate = "SELECT SQL_CALC_FOUND_ROWS cate_nombre, cate_descripcion FROM categoria ORDER BY cate_nombre LIMIT ?, ?";
    private final String q_likeName = "SELECT cate_nombre, cate_descripcion FROM categoria WHERE cate_nombre LIKE ? ORDER BY cate_nombre";

    private CategoriaDAO() {
    
    }
    
    public static CategoriaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaDAO();
        }
        return instance;
    }    
    
    @Override
    public CategoriaDTO findByPk(String nombre) throws SQLException {
        return getAll(Constantes.I_NUM_DOS).stream().filter(acc -> acc.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<CategoriaDTO> getAllByPagination(String nombre, int pagina, int registrosPagina, int modeStatus) throws SQLException {
        listCategoria = new ArrayList<>();
        categoria = null;
        if (nombre.equals(Constantes.S_EMPTY)) {
            if (pagina > Constantes.I_NUM_NEG_UNO && registrosPagina > Constantes.I_NUM_NEG_UNO) {
                ps = dbInstance.getConnection().prepareStatement(q_paginate);
                ps.setInt(Constantes.I_NUM_UNO, pagina);
                ps.setInt(Constantes.I_NUM_DOS, registrosPagina);
            } else {
                return new ArrayList<>(getAll(Constantes.I_NUM_DOS).stream().sorted(Comparator.comparing(CategoriaDTO::getNombre)).collect(Collectors.toList()));
            }
        } else {
            ps = dbInstance.getConnection().prepareStatement(q_likeName);
            ps.setString(Constantes.I_NUM_UNO, nombre + "%");
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
    public boolean update(CategoriaDTO categoria, String nombreAnterior) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_update);
        ps.setString(Constantes.I_NUM_UNO, categoria.getNombre());
        ps.setString(Constantes.I_NUM_DOS, categoria.getDescripcion());
        ps.setString(Constantes.I_NUM_TRES, nombreAnterior);
        value = ps.executeUpdate();
        ps.close();
        
        return value > Constantes.I_NUM_CERO;
    }

    @Override
    public boolean create(CategoriaDTO categoria) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_create);
        ps.setString(Constantes.I_NUM_UNO, categoria.getNombre());
        ps.setString(Constantes.I_NUM_DOS, categoria.getDescripcion());
        value = ps.executeUpdate();
        ps.close();
        
        return value > Constantes.I_NUM_CERO;
    }

    @Override
    public boolean delete(CategoriaDTO categoria) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_delete);
        ps.setString(Constantes.I_NUM_UNO, categoria.getNombre());
        value = ps.executeUpdate();
        ps.close();
        return value > Constantes.I_NUM_CERO;
    }

    @Override
    public int getCountProductsRel(String nombre) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_count);
        ps.setString(Constantes.I_NUM_UNO, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    public ArrayList<String> getNamesByCombo(int modeStatus) throws SQLException {
        return new ArrayList<>(getAll(modeStatus).stream().map(CategoriaDTO::getNombre).sorted().collect(Collectors.toList()));
    }

    public int totalRows() throws SQLException {
        return dbInstance.totalRows();
    }

    @Override
    public ArrayList<CategoriaDTO> getAll(int modeStatus) throws SQLException {
        listCategoria = new ArrayList<>();
        categoria = null;
        ps = dbInstance.getConnection().prepareStatement(q_getAll);
        rs = ps.executeQuery();
        while(rs.next()){
            categoria = new CategoriaDTO(
                    rs.getString("cate_nombre"), 
                    rs.getString("cate_descripcion"));
            listCategoria.add(categoria);
        }
        ps.close();
        rs.close();
                
        return listCategoria;
    }

    @Override
    public boolean update(CategoriaDTO object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CategoriaDTO t, int status) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaDTO findByPk(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
