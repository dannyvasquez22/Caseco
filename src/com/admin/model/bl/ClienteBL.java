package com.admin.model.bl;

import com.admin.model.dao.ClienteDAO;
import com.admin.model.dto.ClienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ClienteBL {
    private static ClienteBL instance = null;
    
    private ClienteBL() {
    
    }
    
    public static ClienteBL getInstance() {
        if (instance == null) {
            instance = new ClienteBL();
        }
        return instance;
    }
    
    public boolean insert(ClienteDTO cliente) throws SQLException {
        return ClienteDAO.getInstance().insert(cliente);
    }
    
    public boolean update(ClienteDTO cliente) throws SQLException {
        return ClienteDAO.getInstance().update(cliente);
    }
    
    public boolean delete(ClienteDTO cliente, int status) throws SQLException {
        return ClienteDAO.getInstance().delete(cliente, status);
    }
    
    public ArrayList<ClienteDTO> listAllBoleta(String []params) throws SQLException {
        return ClienteDAO.getInstance().getAllBoleta(params);
    }
    
    public ArrayList<ClienteDTO> listAllFactura(String []params) throws SQLException {
        return ClienteDAO.getInstance().getAllFactura(params);
    }
    
    public ClienteDTO getRepeatFactura(String ruc, String razon, int codigo) throws SQLException {
        return ClienteDAO.getInstance().getRepeatByFactura(ruc, razon, codigo);
    }
    
    public ClienteDTO getRepeatBoleta(String dni, String nombres, int codigo) throws SQLException {
        return ClienteDAO.getInstance().getRepeatByBoleta(dni, nombres, codigo);
    }
    
    public ClienteDTO getByDniOrRuc(String dniruc, int modo) throws SQLException {
        return ClienteDAO.getInstance().getByDniOrRuc(dniruc, modo);
    }
    
}
