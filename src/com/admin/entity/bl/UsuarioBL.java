package com.admin.entity.bl;

import com.admin.entity.dao.UsuarioDAO;
import com.admin.entity.dto.UsuarioDTO;
import com.admin.entity.pojo.AccesoUsuarioP;
import com.admin.entity.pojo.ConectadoUsuarioP;
import com.admin.entity.pojo.ListaCrudUsuarioP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class UsuarioBL {

    private static UsuarioBL instance = null;

    private UsuarioBL() {

    }

    public static UsuarioBL getInstance() {
        if (instance == null) {
            instance = new UsuarioBL();
        }
        return instance;
    }

    public boolean insert(UsuarioDTO acceso) throws SQLException {
        return UsuarioDAO.getInstance().insertUsuario(acceso);
    }

    public boolean delete(UsuarioDTO usuario, int status) throws SQLException {
        return UsuarioDAO.getInstance().deleteUsuario(usuario, status);
    }

    public boolean update(UsuarioDTO usuario, String cuenta, String contraseña, int modo) throws SQLException {
        return UsuarioDAO.getInstance().updateUsuario(usuario, cuenta, contraseña, modo);
    }

    public ArrayList<UsuarioDTO> listAll() throws SQLException {
        return UsuarioDAO.getInstance().getByAll();
    }

    public UsuarioDTO search(String cuenta) throws SQLException {
        return UsuarioDAO.getInstance().getById(cuenta);
    }
       
    public UsuarioDTO authenticate(String user) throws SQLException {
        return UsuarioDAO.getInstance().authenticate(user);
    }
    
    public boolean changeConnection(UsuarioDTO usuario, int connection) throws SQLException {
        return UsuarioDAO.getInstance().changeConnection(usuario, connection);
    }
    
    //listar accesos de usuarios
    public ArrayList<AccesoUsuarioP> listAccesoUsuarioByFilter(String []params) throws SQLException {
        return UsuarioDAO.getInstance().getAccesoUsuarioByFilter(params);
    }
    
    // listar conexiones de usuarios
    public ArrayList<ConectadoUsuarioP> listConexionUsuarioByFilter(String []params) throws SQLException {
        return UsuarioDAO.getInstance().getConexionUsuarioByFilter(params);
    }
    
    // listar usuarios en su lista de crud
    public ArrayList<ListaCrudUsuarioP> listUsuarioByStatus(int params) throws SQLException {
        return UsuarioDAO.getInstance().getUsuarioByStatus(params);
    }

}
