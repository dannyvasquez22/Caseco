package com.admin.model.interfaces;

import com.admin.model.dto.UsuarioDTO;
import com.admin.model.pojo.AccesoUsuarioP;
import com.admin.model.pojo.ConectadoUsuarioP;
import com.admin.model.pojo.EmpleadoP;
import com.admin.model.pojo.ListaCrudUsuarioP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IUsuario {
    
    public UsuarioDTO getById(String usuario) throws SQLException;
    public UsuarioDTO authenticate(String usuario) throws SQLException;
    public ArrayList<UsuarioDTO> getByAll() throws SQLException;
    public boolean updateUsuario(UsuarioDTO usuario, String cuenta, String contraseña, int modo) throws SQLException;
    public boolean insertUsuario(UsuarioDTO usuario) throws SQLException;
    public boolean deleteUsuario(UsuarioDTO usuario, int status) throws SQLException;
    public boolean changeConnection(UsuarioDTO usuario, int connection) throws SQLException;
    
    // listar accesos de usuario
    public ArrayList<AccesoUsuarioP> getAccesoUsuarioByFilter(String []params) throws SQLException;
    
    // listar conexiones de usuario
    public ArrayList<ConectadoUsuarioP> getConexionUsuarioByFilter(String []params) throws SQLException;
    
    // listar usuarios en su interfaz de crud
    public ArrayList<ListaCrudUsuarioP> getUsuarioByStatus(int status) throws SQLException;
        
}
