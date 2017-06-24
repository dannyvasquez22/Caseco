package com.admin.entity.dao;

import com.admin.entity.dto.EmpleadoDTO;
import com.admin.entity.interfaces.IEmpleado;
import com.admin.entity.pojo.EmpleadoP;
import com.admin.entity.pojo.LicenciaP;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class EmpleadoDAO implements IEmpleado {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private CallableStatement call = null;
    private EmpleadoP employeeUsers = null;
    private LicenciaP licencia = null;
    private EmpleadoDTO empleado = null;
    private ArrayList<EmpleadoP> employeeUsersList = null;
    private ArrayList<LicenciaP> driverList = null;
    private static EmpleadoDAO instance = null;
    private int value = 0;
    
    private EmpleadoDAO() {
    
    }
    
    public static EmpleadoDAO getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAO();
        }
        return instance;
    }

    @Override
    public EmpleadoDTO getById(String codigo) throws SQLException {
        empleado = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT empl_codigo AS codigo FROM empleado WHERE empl_codigo = ?");
        ps.setString(1, codigo);
        rs = ps.executeQuery();
        while (rs.next()) {
            empleado = new EmpleadoDTO(rs.getString("codigo"));
        }
        rs.close();
        ps.close();
        
        return empleado;
    }

    @Override
    public ArrayList<EmpleadoDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean deleteEmpleado(EmpleadoDTO empleado, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE empleado SET empl_estado = ? WHERE empl_codigo = ?");
        ps.setInt(1, status);
        ps.setString(2, empleado.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }
    
    @Override
    public boolean updateEmpleado(EmpleadoDTO empleado, String codigoAnterior) throws SQLException {
        value = 0 ;
        ps = dbInstance.getConnection().prepareStatement("UPDATE empleado SET empl_codigo = ?, empl_nombreApellidos = ?, empl_sexo = ?, empl_dni = ?, empl_direccion = ?, empl_fechaNacimiento = ?, empl_email = ? WHERE empl_codigo = ?");
        ps.setString(1, empleado.getCodigo());
        ps.setString(2, empleado.getNombreApellidos());
        ps.setInt(3, empleado.getSexo());
        ps.setString(4, empleado.getDni());
        ps.setString(5, empleado.getDireccion());
        ps.setString(6, empleado.getFechaNacimiento());
        ps.setString(7, empleado.getEmail());
        ps.setString(8, codigoAnterior);
//        System.out.println(ps);
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertEmpleado(EmpleadoDTO empleado) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO empleado (empl_codigo, empl_nombreApellidos, empl_sexo, empl_dni, empl_direccion, empl_email, empl_fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, empleado.getCodigo());
        ps.setString(2, empleado.getNombreApellidos());
        ps.setInt(3, empleado.getSexo());
        ps.setString(4, empleado.getDni());
        ps.setString(5, empleado.getDireccion());
        ps.setString(6, empleado.getEmail());
        ps.setString(7, empleado.getFechaNacimiento());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public ArrayList<EmpleadoP> getEmpleadoCargo(String[] params, int modo) throws SQLException {
        employeeUsersList = new ArrayList<>();
        employeeUsers = null;
        if (modo == 0) {
            call = dbInstance.getConnection().prepareCall("{CALL sp_listarEmpleados(NULL, NULL, NULL, NULL, NULL, NULL, 0)}");
        } else {
            if (modo == 1) {
                call = dbInstance.getConnection().prepareCall("{CALL sp_listarEmpleados(?, ?, ?, ?, ?, ?, 1)}");
                if (params[0] == null) {
                    call.setNull(1, Types.VARCHAR);
                } else {
                    call.setString(1, params[0]);
                }
                if (params[1] == null) {
                    call.setNull(2, Types.VARCHAR);
                } else {
                    call.setString(2, params[1]);
                }
                if (params[2] == null) {
                    call.setNull(3, Types.VARCHAR);
                } else {
                    call.setString(3, params[2]);
                }
                if (params[3] == null) {
                    call.setNull(4, Types.VARCHAR);
                } else {
                    call.setString(4, params[3]);
                }
                if (params[4] == null) {
                    call.setNull(5, Types.VARCHAR);
                } else {
                    call.setString(5, params[4]);
                }
                if (params[5] == null) {
                    call.setNull(6, Types.INTEGER);
                } else {
                    call.setInt(6, Integer.parseInt(params[5]));
                }
            } else {
                call = dbInstance.getConnection().prepareCall("{CALL sp_listarEmpleados(NULL, NULL, NULL, NULL, NULL, NULL, 2)}");
            }
        }
        rs = call.executeQuery();
        while(rs.next()){
            employeeUsers = new EmpleadoP(
                    rs.getString("codigo"), 
                    rs.getString("dni"),
                    rs.getString("nombres"), 
                    rs.getString("cargo"), 
                    rs.getString("sexo"),                      
                    rs.getString("direccion"),
                    rs.getString("email"), 
                    rs.getString("fechaNacimiento"), 
                    rs.getString("estado"));
            employeeUsersList.add(employeeUsers);
        }
        rs.close();
        call.close();
                
        return employeeUsersList;
    }

    @Override
    public ArrayList<LicenciaP> getByDriver() throws SQLException {
        driverList = new ArrayList<>();
        licencia = null;
        call = dbInstance.getConnection().prepareCall("{CALL sp_listarEmpleados(NULL, NULL, NULL, NULL, NULL, NULL, 3)}");
        rs = call.executeQuery();
        while (rs.next()) {
            licencia = new LicenciaP(
                    rs.getInt("codigo"),
                    rs.getString("numero"),
                    rs.getString("clase"),
                    rs.getString("categoria"),
                    rs.getString("expedicion"),
                    rs.getString("revalidacion"),
                    rs.getString("descripcion"),
                    rs.getString("nombres")
            );
            driverList.add(licencia);
        }
        rs.close();
        call.close();
        
        return driverList;
    }

}
