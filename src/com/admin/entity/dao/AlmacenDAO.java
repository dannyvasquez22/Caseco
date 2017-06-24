package com.admin.entity.dao;

import com.admin.entity.dto.AlmacenDTO;
import com.admin.entity.interfaces.IAlmacen;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class AlmacenDAO implements IAlmacen {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static AlmacenDAO instance = null;
    private AlmacenDTO almacen = null;
    private ArrayList<AlmacenDTO> listAlmacen = null;
    private ArrayList<String> namesCombo = null;
    private String name;
    private int value = 0;

    private AlmacenDAO() {
    
    }
    
    public static AlmacenDAO getInstance() {
        if (instance == null) {
            instance = new AlmacenDAO();
        }
        return instance;
    }     
    
    @Override
    public AlmacenDTO getById(int codigo) throws SQLException{ 
        almacen = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT alm_codigo, alm_nombre, alm_direccion FROM almacen WHERE alm_codigo = ?");
        ps.setInt(1, codigo);
        rs = ps.executeQuery();
        while(rs.next()){
            almacen = new AlmacenDTO(rs.getInt("alm_codigo"), rs.getString("alm_nombre"), rs.getString("alm_direccion"));
        }
        ps.close();
        rs.close();
        
        return almacen;
    }
    
    @Override
    public AlmacenDTO getByName(String nombre) throws SQLException {
        almacen = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT alm_codigo, alm_nombre, alm_direccion FROM almacen WHERE alm_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            almacen = new AlmacenDTO(
                    rs.getInt("alm_codigo"),
                    rs.getString("alm_nombre"),
                    rs.getString("alm_direccion")             
            );
        }
        rs.close();
        ps.close();
        
        return almacen;
    }
    
    @Override
    public ArrayList<AlmacenDTO> getByAll() throws SQLException{   
        listAlmacen = new ArrayList<>();
        almacen = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT alm_codigo, alm_nombre, alm_direccion FROM almacen");
        rs = ps.executeQuery();
        while(rs.next()){
            almacen = new AlmacenDTO(rs.getInt("alm_codigo"), rs.getString("alm_nombre"), rs.getString("alm_direccion"));
            listAlmacen.add(almacen);
        }
        ps.close();
        rs.close();
        
        return listAlmacen;
    }
    
    @Override
    public boolean updateAlmacen(AlmacenDTO almacen) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE almacen SET alm_nombre = ?, alm_direccion = ? WHERE alm_codigo = ?");        
        ps.setString(1, almacen.getNombre());
        ps.setString(2, almacen.getDireccion());
        ps.setInt(3, almacen.getCodigo());         
        value = ps.executeUpdate();
        ps.close();          
        
        return value > 0;
    }

    @Override
    public boolean insertAlmacen(AlmacenDTO almacen) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO almacen (alm_nombre, alm_direccion) VALUES (?, ?)");
        ps.setString(1, almacen.getNombre());
        ps.setString(2, almacen.getDireccion());
        value = ps.executeUpdate();
        ps.close();          
        
        return value > 0;
    }

    @Override
    public boolean deleteAlmacen(AlmacenDTO almacen) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM almacen WHERE alm_codigo = ?");
        ps.setInt(1, almacen.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        rs.close();
        
        return value > 0;
    }

    @Override
    public int getElementChild(int codigo) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT COALESCE(COUNT(dettien_codigo), 0) AS total FROM detalle_tienda WHERE alm_codigo = ?");
        ps.setInt(1, codigo);
        rs = ps.executeQuery();
        while(rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public ArrayList<String> getNameByCombo() throws SQLException {
        namesCombo = new ArrayList<>();
        name = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT alm_nombre AS nombre FROM almacen ORDER BY alm_nombre");
        rs = ps.executeQuery();
        while (rs.next()) {
            name = rs.getString("nombre");
            namesCombo.add(name);
        }
        rs.close();
        ps.close();
        
        return namesCombo;
    }

    @Override
    public ArrayList<String> getNameByStoreByCombo(String tiendaRazonSocial) throws SQLException {
        namesCombo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT al.alm_nombre AS nombre "
                + "FROM almacen AS al "
                + "INNER JOIN detalle_tienda AS dt ON al.alm_codigo = dt.alm_codigo "
                + "INNER JOIN tienda AS ti ON dt.tienda_codigo = ti.tienda_codigo "
                + "WHERE ti.tienda_razonSocial = ?");
        ps.setString(1, tiendaRazonSocial);
        rs = ps.executeQuery();
        while (rs.next()) {
            namesCombo.add(rs.getString("nombre"));
        }
        rs.close();
        ps.close();
        
        return namesCombo;
    }
}
