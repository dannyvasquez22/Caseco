package com.admin.entity.dao;

import com.admin.entity.dto.CargoDTO;
import com.admin.entity.interfaces.ICargo;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class CargoDAO implements ICargo {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private CallableStatement call = null;
    private ArrayList<CargoDTO> cargos = null;
    private CargoDTO cargo = null;
    private static CargoDAO instance = null;
    ArrayList<String> nombresCargo = null;
    private int value = 0;

    private CargoDAO() {
    
    }
    
    public static CargoDAO getInstance() {
        if (instance == null) {
            instance = new CargoDAO();
        }
        return instance;
    }
    
    @Override
    public CargoDTO getById(String nombre) throws SQLException{
        cargo = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT carg_nombre AS nombre, carg_descripcion AS descripcion, DATE_FORMAT(carg_fechaCreacion, '%d/%m/%Y') AS creacion, "
                    + "carg_sueldoMin AS minimo, carg_sueldoMax AS maximo, IF(carg_estado = 1, 'Activo', 'Inactivo') AS estado FROM cargo WHERE carg_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while(rs.next()){
            cargo = new CargoDTO(
                    rs.getString("nombre"), 
                    rs.getString("descripcion"), 
                    rs.getString("creacion"), 
                    rs.getFloat("minimo"), 
                    rs.getFloat("maximo"), 
                    rs.getString("estado"));
        }
        ps.close();
        rs.close();
        
        return cargo;
    }
    
    @Override
    public ArrayList<CargoDTO> getByAllByStatus(int modoEstado) throws SQLException{     
        cargos = new ArrayList<>();
        cargo = null;
        if (modoEstado == 0) {
            ps = dbInstance.getConnection().prepareStatement("SELECT carg_nombre AS nombre, carg_descripcion AS descripcion, DATE_FORMAT(carg_fechaCreacion, '%d/%m/%Y') AS creacion, "
                    + "carg_sueldoMin AS minimo, carg_sueldoMax AS maximo, IF(carg_estado = 1, 'Activo', 'Inactivo') AS estado FROM cargo WHERE carg_estado = 0 ORDER BY carg_nombre");
        } else {
            if (modoEstado == 1) {
                ps = dbInstance.getConnection().prepareStatement("SELECT carg_nombre AS nombre, carg_descripcion AS descripcion, DATE_FORMAT(carg_fechaCreacion, '%d/%m/%Y') AS creacion, "
                    + "carg_sueldoMin AS minimo, carg_sueldoMax AS maximo, IF(carg_estado = 1, 'Activo', 'Inactivo') AS estado FROM cargo WHERE carg_estado = 1 ORDER BY carg_nombre");
            } else {
                ps = dbInstance.getConnection().prepareStatement("SELECT carg_nombre AS nombre, carg_descripcion AS descripcion, DATE_FORMAT(carg_fechaCreacion, '%d/%m/%Y') AS creacion, "
                    + "carg_sueldoMin AS minimo, carg_sueldoMax AS maximo, IF(carg_estado = 1, 'Activo', 'Inactivo') AS estado FROM cargo ORDER BY carg_nombre");
            }
        }
        rs = ps.executeQuery();
        while(rs.next()){
            cargo = new CargoDTO(
                    rs.getString("nombre"), 
                    rs.getString("descripcion"), 
                    rs.getString("creacion"), 
                    rs.getFloat("minimo"), 
                    rs.getFloat("maximo"), 
                    rs.getString("estado"));
            cargos.add(cargo);
        }
        ps.close();
        rs.close();
        
        return cargos;
    }
    
    @Override
    public boolean update(CargoDTO cargo, String nombreAnterior) throws SQLException{
        value = 0;       
        ps = dbInstance.getConnection().prepareStatement("UPDATE cargo SET carg_nombre = ?, carg_descripcion = ?, carg_sueldoMin = ?, carg_sueldoMax = ? WHERE carg_nombre = ?");      
        ps.setString(1, cargo.getNombre());
        ps.setString(2, cargo.getDescripcion());
        ps.setFloat(3, cargo.getSueldoMin());
        ps.setFloat(4, cargo.getSueldoMax());
        ps.setString(5, nombreAnterior);        
        value = ps.executeUpdate();        
        ps.close();        
        
        return value > 0;
    }
    
    @Override
    public boolean insert(CargoDTO cargo) throws SQLException{
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO cargo (carg_nombre, carg_descripcion, carg_fechaCreacion, carg_sueldoMin, carg_sueldoMax, carg_estado) VALUES (?,?,?,?,?,?)");
        ps.setString(1, cargo.getNombre());
        ps.setString(2, cargo.getDescripcion());
        ps.setString(3, cargo.getFechaCreacion());
        ps.setFloat(4, cargo.getSueldoMin());
        ps.setFloat(5, cargo.getSueldoMax());
        ps.setString(6, cargo.getEstado());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }
    
    @Override
    public boolean delete(CargoDTO cargo, int status) throws SQLException{
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE cargo SET carg_estado = ? WHERE carg_nombre = ?");
        ps.setInt(1, status);
        ps.setString(2, cargo.getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public ArrayList<String> getAllByCombo(int estado) throws SQLException {
        nombresCargo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT carg_nombre FROM cargo WHERE carg_estado = ?");
        ps.setInt(1, estado);
        rs = ps.executeQuery();
        while(rs.next()){
            nombresCargo.add(rs.getString("carg_nombre"));
        }        
        rs.close();
        ps.close();
        
        return nombresCargo;
    }

    @Override
    public int countElemntChild(String nombre) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(detcarg_codigo) AS elementos FROM detalle_cargo WHERE carg_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("elementos");
        }
        rs.close();
        ps.close();
        
        return value;
    }

}
