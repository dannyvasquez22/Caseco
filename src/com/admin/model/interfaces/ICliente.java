package com.admin.model.interfaces;

import com.admin.model.dto.ClienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICliente {

    public ClienteDTO getById(int id) throws SQLException;
    public ClienteDTO getRepeatByFactura(String ruc, String razon, int codigo) throws SQLException;
    public ClienteDTO getByDniOrRuc(String dniruc, int modo) throws SQLException;
    public ClienteDTO getRepeatByBoleta(String dni, String nombres, int codigo) throws SQLException;
    public ArrayList<ClienteDTO> getAllBoleta(String []params) throws SQLException;
    public ArrayList<ClienteDTO> getAllFactura(String []params) throws SQLException;
    public boolean update(ClienteDTO cliente) throws SQLException;
    public boolean insert(ClienteDTO cliente) throws SQLException;
    public boolean delete(ClienteDTO cliente, int status) throws SQLException;
    
}
