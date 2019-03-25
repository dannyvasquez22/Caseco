package com.admin.model.dao;

import com.admin.model.dto.CargoDTO;
import com.admin.model.interfaces.ICRUD;
import com.admin.model.interfaces.ICargo;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Constantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/** * @author DANNY VASQUEZ RAFAEL */

public class CargoDAO implements ICRUD<CargoDTO>, ICargo {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private ArrayList<CargoDTO> cargos = null;
    private CargoDTO cargo = null;
    private static CargoDAO instance = null;
    private int value = Constantes.I_NUM_CERO;
    private final String q_updateEx = "UPDATE cargo SET carg_nombre = ?, carg_descripcion = ?, carg_sueldoMin = ?, carg_sueldoMax = ? WHERE carg_nombre = ?";
    private final String q_create = "INSERT INTO cargo (carg_nombre, carg_descripcion, carg_fechaCreacion, carg_sueldoMin, carg_sueldoMax, carg_estado) VALUES (?,?,?,?,?,?)";
    private final String q_updateStatus = "UPDATE cargo SET carg_estado = ? WHERE carg_nombre = ?";
    private final String q_count = "SELECT COUNT(detcarg_codigo) AS elementos FROM detalle_cargo WHERE carg_nombre = ?";
    private final String q_getAll = "SELECT carg_nombre AS nombre, carg_descripcion AS descripcion, DATE_FORMAT(carg_fechaCreacion, '%d/%m/%Y') AS creacion, "
            + "carg_sueldoMin AS minimo, carg_sueldoMax AS maximo, carg_estado AS estado FROM cargo";

    private CargoDAO() {
    
    }
    
    public static CargoDAO getInstance() {
        if (instance == null) {
            instance = new CargoDAO();
        }
        return instance;
    }
    
    @Override
    public CargoDTO findByPk(String nombre) throws SQLException{
        return (getAll(Constantes.I_NUM_DOS).stream().filter(mcargo -> mcargo.getNombre().equals(nombre)).findAny().orElse(null));
    }
    
    @Override
    public ArrayList<CargoDTO> getAll(int modoEstado) throws SQLException{     
        cargos = new ArrayList<>();
        cargo = null;
        if (modoEstado > Constantes.I_NUM_UNO) {
            ps = dbInstance.getConnection().prepareStatement(q_getAll + " ORDER BY carg_nombre");
        } else {
            ps = dbInstance.getConnection().prepareStatement(q_getAll + " WHERE carg_estado = ? ORDER BY carg_nombre");
            ps.setInt(Constantes.I_NUM_UNO, modoEstado);
        }
        
        rs = ps.executeQuery();
        while(rs.next()){
            cargo = new CargoDTO(
                    rs.getString("nombre"), 
                    rs.getString("descripcion"), 
                    rs.getString("creacion"), 
                    rs.getFloat("minimo"), 
                    rs.getFloat("maximo"), 
                    rs.getInt("estado"));
            cargos.add(cargo);
        }
        ps.close();
        rs.close();
        
        return cargos;
    }
    
    @Override
    public boolean update(CargoDTO cargo, String nombreAnterior) throws SQLException{
        value = Constantes.I_NUM_CERO;       
        ps = dbInstance.getConnection().prepareStatement(q_updateEx);
        ps.setString(Constantes.I_NUM_UNO, cargo.getNombre());
        ps.setString(Constantes.I_NUM_DOS, cargo.getDescripcion());
        ps.setFloat(Constantes.I_NUM_TRES, cargo.getSueldoMin());
        ps.setFloat(Constantes.I_NUM_CUATRO, cargo.getSueldoMax());
        ps.setString(Constantes.I_NUM_CINCO, nombreAnterior);
        value = ps.executeUpdate();        
        ps.close();        
        
        return value > Constantes.I_NUM_CERO;
    }
    
    @Override
    public boolean create(CargoDTO cargo) throws SQLException{
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_create);
        ps.setString(Constantes.I_NUM_UNO, cargo.getNombre());
        ps.setString(Constantes.I_NUM_DOS, cargo.getDescripcion());
        ps.setString(Constantes.I_NUM_TRES, cargo.getFechaCreacion());
        ps.setFloat(Constantes.I_NUM_CUATRO, cargo.getSueldoMin());
        ps.setFloat(Constantes.I_NUM_CINCO, cargo.getSueldoMax());
        ps.setInt(Constantes.I_NUM_SEIS, cargo.getEstado());
        value = ps.executeUpdate();
        ps.close();
        
        return value > Constantes.I_NUM_CERO;
    }
    
    @Override
    public boolean update(CargoDTO cargo, int status) throws SQLException{
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_updateStatus);
        ps.setInt(Constantes.I_NUM_UNO, status);
        ps.setString(Constantes.I_NUM_DOS, cargo.getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > Constantes.I_NUM_CERO;
    }

    public ArrayList<String> getAllByCombo(int estado) throws SQLException {
        return new ArrayList<>(getAll(estado).stream().map(CargoDTO::getNombre).sorted().collect(Collectors.toList()));
    }

    @Override
    public int countElemntChild(String nombre) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_count);
        ps.setString(Constantes.I_NUM_UNO, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("elementos");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public boolean update(CargoDTO t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(CargoDTO t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CargoDTO findByPk(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CargoDTO> getAllByPagination(String name, int page, int registers, int modeStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
