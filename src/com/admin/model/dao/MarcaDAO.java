package com.admin.model.dao;

import com.admin.model.dto.MarcaDTO;
import com.admin.model.interfaces.IMarca;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class MarcaDAO implements IMarca {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static MarcaDAO instance = null;
    private MarcaDTO marca = null;
    private ArrayList<MarcaDTO> listMarca = null;
    private int value = 0;

    private MarcaDAO() {
    
    }
    
    public static MarcaDAO getInstance() {
        if (instance == null) {
            instance = new MarcaDAO();
        }
        return instance;
    }

    @Override
    public MarcaDTO getById(String nombre) throws SQLException {
        marca = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT marca_nombre AS nombre, marca_descripcion AS descripcion FROM marca WHERE marca_nombre = ? ORDER BY marca_nombre");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            marca = new MarcaDTO(
                    rs.getString("nombre"),
                    rs.getString("descripcion")
            );
        }
        rs.close();
        ps.close();
        
        return marca;
    }

    @Override
    public ArrayList<MarcaDTO> getAll(String nombre) throws SQLException {
        listMarca = new ArrayList<>();
        marca = null;
        if (nombre.equals("")) {
            ps = dbInstance.getConnection().prepareStatement("SELECT marca_nombre AS nombre, marca_descripcion AS descripcion FROM marca ORDER BY marca_nombre");
        } else {
            ps = dbInstance.getConnection().prepareStatement("SELECT marca_nombre AS nombre, marca_descripcion AS descripcion FROM marca WHERE marca_nombre LIKE ? ORDER BY marca_nombre");
            ps.setString(1, nombre + "%");
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            marca = new MarcaDTO(
                    rs.getString("nombre"),
                    rs.getString("descripcion")
            );
            listMarca.add(marca);
        }
        rs.close();
        ps.close();
        
        return listMarca;
    }

    @Override
    public boolean updateMarca(MarcaDTO marca, String marcaAnterior) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE marca SET marca_nombre = ?, marca_descripcion = ? WHERE marca_nombre = ?");
        ps.setString(1, marca.getNombre());
        ps.setString(2, marca.getDescripcion());
        ps.setString(3, marcaAnterior);
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertMarca(MarcaDTO marca) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO marca (marca_nombre, marca_descripcion) VALUES (?, ?)");
        ps.setString(1, marca.getNombre());
        ps.setString(2, marca.getDescripcion());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean deleteMarca(MarcaDTO marca) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM marca WHERE marca_nombre = ?");
        ps.setString(1, marca.getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public int getElementChild(String marca) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(marca_nombre) AS total FROM producto WHERE marca_nombre = ?");
        ps.setString(1, marca);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }
}
