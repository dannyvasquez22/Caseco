package com.admin.entity.dao;

import com.admin.entity.dto.ProveedorDTO;
import com.admin.entity.interfaces.IProveedor;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProveedorDAO implements IProveedor {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private CallableStatement call = null;
    private static ProveedorDAO instance = null;
    private ArrayList<ProveedorDTO> listProveedor = null;
    private ProveedorDTO proveedor = null;
    private int value = 0;

    public ProveedorDAO() {
    }

    public static ProveedorDAO getInstance() {
        if (instance == null) {
            instance = new ProveedorDAO();
        }        
        return instance;
    }

    @Override
    public ProveedorDTO getById(String nombre) throws SQLException {
        proveedor = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT prove_nombre AS nombre FROM proveedor WHERE prove_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            proveedor = new ProveedorDTO(rs.getString("nombre"));
        }
        rs.close();
        ps.close();
        
        return proveedor;
    }

    @Override
    public ArrayList<ProveedorDTO> getAllByStatus(String []params) throws SQLException {
        listProveedor = new ArrayList<>();
        proveedor = null;
        ps = dbInstance.getConnection().prepareStatement("{CALL sp_listarProveedores(?, ?, ?)}");
        if (params[0] == null) {
            ps.setNull(1, Types.VARCHAR);
        } else {
            ps.setString(1, params[0]);
        }
        if (params[1] == null) {
            ps.setNull(2, Types.VARCHAR);
        } else {
            ps.setString(2, params[1]);
        }
        if (params[2] == null) {
            ps.setNull(3, Types.INTEGER);
        } else {
            ps.setString(3, params[2]);
        }
//        System.out.println(ps);
        rs = ps.executeQuery();
        while (rs.next()) {
            proveedor = new ProveedorDTO(
                    rs.getString("nombre"),
                    rs.getString("ruc"),
                    rs.getString("direccion"),
                    rs.getString("web"),
                    rs.getString("email"),
                    rs.getString("estado")
            );
            listProveedor.add(proveedor);
        }
        rs.close();
        ps.close();
        
        return listProveedor;
    }

    @Override
    public boolean update(ProveedorDTO proveedor, String nombreAnterior) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE proveedor SET prove_nombre = ?, prove_ruc = ?, prove_direccion = ?, prove_sitioWeb = ?, prove_email = ? WHERE prove_nombre = ?");
        ps.setString(1, proveedor.getNombre());
        ps.setString(2, proveedor.getRuc());
        ps.setString(3, proveedor.getDireccion());
        ps.setString(4, proveedor.getSitioWeb());
        ps.setString(5, proveedor.getEmail());
        ps.setString(6, nombreAnterior);
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(ProveedorDTO proveedor) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO proveedor (prove_nombre, prove_ruc, prove_direccion, prove_sitioWeb, prove_email) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, proveedor.getNombre());
        ps.setString(2, proveedor.getRuc());
        ps.setString(3, proveedor.getDireccion());
        ps.setString(4, proveedor.getSitioWeb());
        ps.setString(5, proveedor.getEmail());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(ProveedorDTO proveedor, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE proveedor SET prove_estado = ? WHERE prove_nombre = ?");
        ps.setInt(1, status);
        ps.setString(2, proveedor.getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }
    
}
