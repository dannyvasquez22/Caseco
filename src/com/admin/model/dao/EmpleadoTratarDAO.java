package com.admin.model.dao;

import com.admin.model.dto.EmpleadoTratarDTO;
import com.admin.model.interfaces.IEmpleadoTratar;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoTratarDAO implements IEmpleadoTratar {
    private final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private ArrayList<EmpleadoTratarDTO> listEmpleado = null;
    private EmpleadoTratarDTO empleado = null;
    private ArrayList<String> namesCombo = null;
    private static EmpleadoTratarDAO instance = null;
    private int value = 0;
    
    private EmpleadoTratarDAO() {
    
    }
    
    public static EmpleadoTratarDAO getInstance() {
        if (instance == null) {
            instance = new EmpleadoTratarDAO();
        }
        return instance;
    }

    @Override
    public EmpleadoTratarDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EmpleadoTratarDTO> getAll(int codigo) throws SQLException {
        empleado = null;
        listEmpleado = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT empltra_codigo AS codigo, empltra_dni AS dni, empltra_nomApe AS nombres FROM empleado_tratar WHERE clie_codigo = ?");
        ps.setInt(1, codigo);
        rs = ps.executeQuery();
        while(rs.next()) {
            empleado = new EmpleadoTratarDTO(
                    rs.getInt("codigo"),
                    rs.getString("dni"),
                    rs.getString("nombres")
            );
            listEmpleado.add(empleado);
        }
        rs.close();
        ps.close();
        return listEmpleado;
    }

    @Override
    public boolean update(EmpleadoTratarDTO empleado) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE empleado_tratar SET empltra_dni = ?, empltra_nomApe = ? WHERE empltra_codigo = ?");
        ps.setString(1, empleado.getDni());
        ps.setString(2, empleado.getNombresApellidos());
        ps.setInt(3, empleado.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(EmpleadoTratarDTO empleado) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO empleado_tratar (empltra_dni, empltra_nomApe, clie_codigo) VALUES (?, ?, ?)");
        ps.setString(1, empleado.getDni());
        ps.setString(2, empleado.getNombresApellidos());
        ps.setInt(3, empleado.getCliente().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(EmpleadoTratarDTO empleado) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM empleado_tratar WHERE empltra_codigo = ?");
        ps.setInt(1, empleado.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public ArrayList<String> getNamesByCombo(int codigo) throws SQLException {
        namesCombo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT empltra_nomApe AS nombres FROM empleado_tratar WHERE clie_codigo = ?");
        ps.setInt(1, codigo);
        rs = ps.executeQuery();
        while (rs.next()) {
            namesCombo.add(rs.getString("nombres"));
        }
        rs.close();
        ps.close();
        
        return namesCombo;
    }

    @Override
    public int getByDniByNombres(String dni, String nombres) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT empltra_codigo AS codigo FROM empleado_tratar WHERE empltra_dni = ? AND empltra_nomApe = ?");
        ps.setString(1, dni);
        ps.setString(2, nombres);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("codigo");
        }
        rs.close();
        ps.close();
        return value;
    }
    
    
}
