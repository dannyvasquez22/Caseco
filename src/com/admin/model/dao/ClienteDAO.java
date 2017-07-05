package com.admin.model.dao;

import com.admin.model.dto.ClienteDTO;
import com.admin.model.interfaces.ICliente;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ClienteDAO implements ICliente {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private CallableStatement call = null;
    private static ClienteDAO instance = null;
    private ClienteDTO cliente = null;
    private ArrayList<ClienteDTO> listCliente = null;
    private String name;
    private int value = 0;

    private ClienteDAO() {
    
    }
    
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    @Override
    public ClienteDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteDTO getRepeatByFactura(String ruc, String razon, int codigo) throws SQLException {
        cliente = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT clie_codigo AS codigo FROM cliente WHERE (clie_ruc = ? OR clie_razonSocial = ?) AND clie_codigo != ?");
        ps.setString(1, ruc);
        ps.setString(2, razon);
        ps.setInt(3, codigo);
        rs = ps.executeQuery();
        while (rs.next()) {
            cliente = new ClienteDTO(rs.getInt("codigo"));
        }
        rs.close();
        ps.close();
        
        return cliente;
    }

    @Override
    public ClienteDTO getRepeatByBoleta(String dni, String nombres, int codigo) throws SQLException {
        cliente = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT clie_codigo AS codigo FROM cliente WHERE (clie_dni = ? OR clie_nombresApellidos = ?) AND clie_codigo != ?");
        ps.setString(1, dni);
        ps.setString(2, nombres);
        ps.setInt(3, codigo);
        rs = ps.executeQuery();
        while (rs.next()) {
            cliente = new ClienteDTO(rs.getInt("codigo"));
        }
        rs.close();
        ps.close();
        
        return cliente;
    }

    @Override
    public ArrayList<ClienteDTO> getAllBoleta(String []params) throws SQLException {
        cliente = null;
        listCliente = new ArrayList<>();
        call = dbInstance.getConnection().prepareCall("{CALL sp_listarClientes(?, ?, ?, 0)}");
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
            call.setNull(3, Types.INTEGER);
        } else {
            call.setInt(3, Integer.parseInt(params[2]));
        }
        rs = call.executeQuery();
        while (rs.next()) {
            cliente = new ClienteDTO(
                    rs.getInt("codigo"),
                    rs.getString("dni"),
                    rs.getString("nombres"),
                    rs.getString("sexo"),
                    rs.getString("fechaNacimiento"),
                    rs.getString("direccion"),
                    rs.getString("puntoLlegada"),
                    rs.getString("email"),
                    rs.getString("estado"),
                    rs.getString("fechaCreacion")
            );
            listCliente.add(cliente);
        }
        rs.close();
        call.close();
        
        return listCliente;
    }

    @Override
    public ArrayList<ClienteDTO> getAllFactura(String []params) throws SQLException {
        cliente = null;
        listCliente = new ArrayList<>();
        call = dbInstance.getConnection().prepareCall("{CALL sp_listarClientes(?, ?, ?, 1)}");
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
            call.setNull(3, Types.INTEGER);
        } else {
            call.setInt(3, Integer.parseInt(params[2]));
        }
        rs = call.executeQuery();
        while (rs.next()) {
            cliente = new ClienteDTO(
                    rs.getInt("codigo"),
                    rs.getString("ruc"),
                    rs.getString("razon"),
                    rs.getString("direccion"),
                    rs.getString("puntoLlegada"),
                    rs.getString("email"),
                    rs.getString("estado"),
                    rs.getString("fechaCreacion")
            );
            listCliente.add(cliente);
        }
        rs.close();
        call.close();
        
        return listCliente;
    }

    @Override
    public boolean update(ClienteDTO cliente) throws SQLException {
        value = 0;
        if (cliente.getRuc() == null) {
            ps = dbInstance.getConnection().prepareStatement("UPDATE cliente SET clie_dni = ?, clie_nombresApellidos = ?, clie_sexo = ?, clie_fechaNacimiento = ?, clie_direccion = ?, clie_puntoLlegada = ?, clie_email = ? WHERE clie_codigo = ?");
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombreApellidos());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getFechaNacimiento());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getPuntoLlegada());
            ps.setString(7, cliente.getEmail());
            ps.setInt(8, cliente.getCodigo());
        } else {
            ps = dbInstance.getConnection().prepareStatement("UPDATE cliente SET clie_ruc = ?, clie_razonSocial = ?, clie_direccion = ?, clie_puntoLlegada = ?, clie_email = ? WHERE clie_codigo = ?");
            ps.setString(1, cliente.getRuc());
            ps.setString(2, cliente.getRazonSocial());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getPuntoLlegada());
            ps.setString(5, cliente.getEmail());
            ps.setInt(6, cliente.getCodigo());
        }
        value = ps.executeUpdate();
        ps.close();
        return value > 0;
    }

    @Override
    public boolean insert(ClienteDTO cliente) throws SQLException {
        value = 0;
        if (cliente.getRuc() == null) {
            ps = dbInstance.getConnection().prepareStatement("INSERT INTO cliente (clie_dni, clie_nombresApellidos, clie_sexo, clie_fechaNacimiento, clie_direccion, clie_puntoLlegada, clie_email, clie_fechaCreacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombreApellidos());
            ps.setString(3, cliente.getSexo());
            ps.setString(4, cliente.getFechaNacimiento());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getPuntoLlegada());
            ps.setString(7, cliente.getEmail());
            ps.setString(8, cliente.getFechaCreacion());
        } else {
            ps = dbInstance.getConnection().prepareStatement("INSERT INTO cliente (clie_ruc, clie_razonSocial, clie_direccion, clie_puntoLlegada, clie_email, clie_fechaCreacion) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, cliente.getRuc());
            ps.setString(2, cliente.getRazonSocial());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getPuntoLlegada());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getFechaCreacion());
        }
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(ClienteDTO cliente, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE cliente SET clie_estado = ? WHERE clie_codigo = ?");
        ps.setInt(1, status);
        ps.setInt(2, cliente.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public ClienteDTO getByDniOrRuc(String dniruc, int modo) throws SQLException {
        cliente = null;
        if (modo == 0) {
            ps = dbInstance.getConnection().prepareStatement("SELECT clie_codigo FROM cliente WHERE clie_ruc = ?");
        } else {
            ps = dbInstance.getConnection().prepareStatement("SELECT clie_codigo FROM cliente WHERE clie_dni = ?");
        }
        ps.setString(1, dniruc);
        rs = ps.executeQuery();
        while ( rs.next()) {
            cliente = new ClienteDTO(rs.getInt("clie_codigo"));
        }
        rs.close();
        ps.close();
        
        return cliente;
    }

}
