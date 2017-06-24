package com.admin.entity.dao;

import com.admin.entity.dto.DetalleProveedorDTO;
import com.admin.entity.interfaces.IDetalleProveedor;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleProveedorDAO implements IDetalleProveedor {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private CallableStatement call = null;
    private static DetalleProveedorDAO instance = null;
    private ArrayList<DetalleProveedorDTO> listDetalleProveedor = null;
    private DetalleProveedorDTO detalleProveedor = null;
    private int value = 0;

    public DetalleProveedorDAO() {
    }

    public static DetalleProveedorDAO getInstance() {
        if (instance == null) {
            instance = new DetalleProveedorDAO();
        }        
        return instance;
    }

    @Override
    public DetalleProveedorDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleProveedorDTO> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleProveedorDTO> getByProveedor(String nombre) throws SQLException {
        listDetalleProveedor = new ArrayList<>();
        detalleProveedor = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT detprove_codigo AS codigo, DATE_FORMAT(detprove_fechaInicio, '%d/%m/%Y') AS fechaInicio, IF(detprove_fechaFin = '1111-11-11', '', DATE_FORMAT(detprove_fechaFin, '%d/%m/%Y')) AS fechaFin FROM detalle_proveedor WHERE prove_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            detalleProveedor = new DetalleProveedorDTO(
                    rs.getInt("codigo"),
                    rs.getString("fechaInicio"),
                    rs.getString("fechaFin")
            );
            listDetalleProveedor.add(detalleProveedor);
        }
        rs.close();
        ps.close();
        
        return listDetalleProveedor;
    }

    @Override
    public boolean update(DetalleProveedorDTO detalleProveedor) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_proveedor SET detprove_fechaFin = ? WHERE prove_nombre = ? AND detprove_fechaFin = '1111-11-11'");
        ps.setString(1, detalleProveedor.getFechaFin());
        ps.setString(2, detalleProveedor.getProveedor().getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(DetalleProveedorDTO detalleProveedor) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO detalle_proveedor (detprove_fechaInicio, prove_nombre) VALUES (?, ?)");
        ps.setString(1, detalleProveedor.getFechaInicio());
        ps.setString(2, detalleProveedor.getProveedor().getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(DetalleProveedorDTO detalleProveedor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
