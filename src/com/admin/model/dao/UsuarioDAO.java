package com.admin.model.dao;

import com.admin.model.dto.CargoDTO;
import com.admin.model.dto.DetalleCargoDTO;
import com.admin.model.dto.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.admin.model.interfaces.IUsuario;
import com.admin.model.pojo.AccesoUsuarioP;
import com.admin.model.pojo.ConectadoUsuarioP;
import com.admin.model.pojo.ListaCrudUsuarioP;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Encript;
import java.sql.CallableStatement;
import java.sql.Types;

/** * @author DANNY VASQUEZ RAFAEL */

public class UsuarioDAO implements IUsuario {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private CallableStatement call = null;
    private static UsuarioDAO instance = null;
    private UsuarioDTO usuario = null;
    private AccesoUsuarioP userAccessDTO = null;
    private ArrayList<AccesoUsuarioP> userAccessList = null;
    private ConectadoUsuarioP connectedUsersDTO = null;
    private ArrayList<ConectadoUsuarioP> connectedUsersList = null;
    private ListaCrudUsuarioP listCrudDTO = null;
    private ArrayList<ListaCrudUsuarioP> listCrudList = null;    
    private String pass = "";
    private int value = 0;

    public UsuarioDAO() {
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }        
        return instance;
    }
        
    @Override
    public UsuarioDTO getById(String cuenta) throws SQLException{         
        usuario = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT usu_cuenta, usu_contraseña, usu_ipReferencia, "
                + "usu_estadoConexion, usu_estado, detcarg_codigo FROM usuario WHERE usu_cuenta = ?");
        ps.setString(1, cuenta);
        rs = ps.executeQuery();
        while(rs.next()){
            usuario = new UsuarioDTO(rs.getString("usu_cuenta"), rs.getString("usu_contraseña"), rs.getString("usu_ipReferencia"), rs.getInt("usu_estadoConexion"), rs.getInt("usu_estado"), new DetalleCargoDTO(rs.getInt("detcarg_codigo")));
        }
        ps.close();
        rs.close();        
        
        return usuario;
    }

    @Override
    public boolean updateUsuario(UsuarioDTO usuario, String cuenta, String contraseña, int modo) throws SQLException {
        value = 0;
        if (modo == 0) {
            if (contraseña == null) { // Cambiar usuario
                ps = dbInstance.getConnection().prepareStatement("UPDATE usuario SET usu_cuenta = ? WHERE usu_cuenta = ? AND usu_contraseña = ?");
                ps.setString(1, cuenta);
                ps.setString(2, usuario.getCuenta());
                ps.setString(3, usuario.getContraseña());
            } else { // Cambiar contraseña
                ps = dbInstance.getConnection().prepareStatement("UPDATE usuario SET usu_contraseña = ? WHERE usu_cuenta = ?");
                pass = Encript.Encriptar(contraseña);
                ps.setString(1, pass);
                ps.setString(2, usuario.getCuenta());
            } 
        } else { // Cambiar otros atributos
            ps = dbInstance.getConnection().prepareStatement("UPDATE usuario SET usu_cuenta = ?, usu_ipReferencia = ? WHERE usu_cuenta = ?");
            ps.setString(1, cuenta);
            ps.setString(2, contraseña); // actua como ip
            ps.setString(3, usuario.getCuenta());
        }
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public boolean insertUsuario(UsuarioDTO usuario) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO usuario (usu_cuenta, usu_contraseña, usu_ipReferencia, detcarg_codigo) VALUES (?, ?, ?, ?)");
        ps.setString(1, usuario.getCuenta());
        pass = Encript.Encriptar(usuario.getContraseña());
        //String pass1 = Encript.getStringMessageDigest(usuario.getContraseña(), Encript.MD5);
        ps.setString(2, pass);
        ps.setString(3, usuario.getIpReferencia());
        ps.setInt(4, usuario.getDetalleCargo().getCodigo());
        
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public boolean deleteUsuario(UsuarioDTO usuario, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE usuario SET usu_estado = ? WHERE usu_cuenta = ?");
        ps.setInt(1, status);
        ps.setString(2, usuario.getCuenta());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public UsuarioDTO authenticate(String user) throws SQLException {      
        usuario = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT usu_contraseña, carg_nombre FROM usuario INNER JOIN detalle_cargo ON" +
            " usuario.detcarg_codigo = detalle_cargo.detcarg_codigo WHERE usu_cuenta = ? AND usu_estado = 1");
        ps.setString(1, user);
        rs = ps.executeQuery();
        while(rs.next()){
            usuario = new UsuarioDTO(user, rs.getString("usu_contraseña"), new DetalleCargoDTO(new CargoDTO(rs.getString("carg_nombre"))));
        }
        ps.close();
        rs.close();
        
        return usuario;
    }

    @Override
    public ArrayList<UsuarioDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean changeConnection(UsuarioDTO usuario, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE usuario SET usu_estadoConexion = ? WHERE usu_cuenta = ?");
        ps.setInt(1, status);
        ps.setString(2, usuario.getCuenta());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }
    
    @Override
    public ArrayList<AccesoUsuarioP> getAccesoUsuarioByFilter(String []elementsQuery) throws SQLException{
        userAccessList = new ArrayList<>();
        userAccessDTO = null;
        call = dbInstance.getConnection().prepareCall("{CALL sp_listarUsuarios(?, ?, ?, NULL, 0)}");
        if (elementsQuery[0] == null) {
            call.setNull(1, Types.VARCHAR);
        } else {
            call.setString(1, elementsQuery[0]); 
        }
        if (elementsQuery[1] == null) {
            call.setNull(2, Types.VARCHAR); 
        } else{
            call.setString(2, elementsQuery[1]);
        }
        if (elementsQuery[2] == null) {
            call.setNull(3, Types.VARCHAR); 
        } else{
            call.setString(3, elementsQuery[2]);
        }        
        rs = call.executeQuery();
        while(rs.next()){
            userAccessDTO = new AccesoUsuarioP(
                    rs.getString("nombres"), 
                    rs.getString("cuenta"),
                    rs.getString("fecha"), 
                    rs.getString("horaInicio"), 
                    rs.getString("horaFin"));
            userAccessList.add(userAccessDTO);
        }
        rs.close();
        call.close();
        
        return userAccessList;
    }
    
    @Override
    public ArrayList<ConectadoUsuarioP> getConexionUsuarioByFilter(String []elementsQuery) throws SQLException{
        connectedUsersList = new ArrayList<>();
        connectedUsersDTO = null;
        call = dbInstance.getConnection().prepareCall("{CALL sp_listarUsuarios(?, ?, ?, ?, 1)}");
        if (elementsQuery[0] == null) {
            call.setNull(1, Types.VARCHAR);
        } else {
            call.setString(1, elementsQuery[0]); 
        }
        if (elementsQuery[1] == null) {
            call.setNull(2, Types.VARCHAR); 
        } else{
            call.setString(2, elementsQuery[1]);
        }
        if (elementsQuery[2] == null) {
            call.setNull(3, Types.VARCHAR); 
        } else{
            call.setString(3, elementsQuery[2]);
        }
        if (elementsQuery[3] == null) {
            call.setNull(4, Types.VARCHAR);
        } else {
            call.setInt(4, Integer.parseInt(elementsQuery[3]));
        }
        rs = call.executeQuery();
        while(rs.next()){
            connectedUsersDTO = new ConectadoUsuarioP(
                    rs.getString("nombres"), 
                    rs.getString("cuenta"),
                    rs.getString("cargo"), 
                    rs.getString("estado"), 
                    rs.getString("ip"));
            connectedUsersList.add(connectedUsersDTO);
        }
        rs.close();
        call.close();
                
        return connectedUsersList;
    }
    
    @Override
    public ArrayList<ListaCrudUsuarioP> getUsuarioByStatus(int status) throws SQLException{
        listCrudList = new ArrayList<>();
        listCrudDTO = null;
        call = dbInstance.getConnection().prepareCall("{CALL sp_listarUsuarios(NULL, NULL, NULL, ?, 2)}");
        if (status < 0) {
            call.setNull(1, Types.INTEGER);
        } else {
            call.setInt(1, status);
        }        
        rs = call.executeQuery();
        while(rs.next()){
            listCrudDTO = new ListaCrudUsuarioP(
                    rs.getString("codigo"),
                    rs.getString("nombres"), 
                    rs.getString("cargo"), 
                    rs.getString("cuenta"),                    
                    rs.getString("estado"), 
                    rs.getString("ip"));
            listCrudList.add(listCrudDTO);
        }
        rs.close();
        call.close();
                
        return listCrudList;
    }            
}
