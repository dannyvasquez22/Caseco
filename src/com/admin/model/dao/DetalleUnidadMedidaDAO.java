package com.admin.model.dao;

import com.admin.model.dto.DetalleUnidadMedidaDTO;
import com.admin.model.dto.UnidadMedidaDTO;
import com.admin.model.interfaces.IDetalleUnidadMedida;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleUnidadMedidaDAO implements IDetalleUnidadMedida {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private DetalleUnidadMedidaDTO detalle = null;
    private ArrayList<DetalleUnidadMedidaDTO> listDetalle = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static DetalleUnidadMedidaDAO instance = null;

    private DetalleUnidadMedidaDAO() {
    }

    public static DetalleUnidadMedidaDAO getInstance() {
        if (instance == null) {
            instance = new DetalleUnidadMedidaDAO();
        }
        return instance;
    }

    @Override
    public DetalleUnidadMedidaDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleUnidadMedidaDTO> getAllByProduct(int codigoProducto) throws SQLException {
        listDetalle = new ArrayList<>();
        detalle = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT detundmed_codigo AS codigo, undmed_nombre AS nombre, detundmed_precioMenor AS precioMenor, detundmed_precioMayor AS precioMayor, detundmed_precioEspecial AS precioEspecial, IF(detundmed_estPrincipal = 1, 'SI', 'NO') AS principal FROM detalle_undmedida WHERE prod_codigo = ?");
        ps.setInt(1, codigoProducto);
        rs = ps.executeQuery();
        while(rs.next()) {
            detalle = new DetalleUnidadMedidaDTO(
                    rs.getInt("codigo"),
                    new UnidadMedidaDTO(rs.getString("nombre")),
                    rs.getDouble("precioMenor"),
                    rs.getDouble("precioMayor"),
                    rs.getDouble("precioEspecial"),
                    rs.getString("principal")
            );
            listDetalle.add(detalle);
        }
        rs.close();
        ps.close();
        
        return listDetalle;
    }

    @Override
    public boolean update(DetalleUnidadMedidaDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_undmedida SET undmed_nombre = ?, detundmed_precioMenor = ?, detundmed_precioMayor = ?, detundmed_precioEspecial = ?, detundmed_estPrincipal = ? WHERE detundmed_codigo = ?");
        ps.setString(1, detalle.getUnidadMedida().getNombre());
        ps.setDouble(2, detalle.getPrecioMenor());
        ps.setDouble(3, detalle.getPrecioMayor());
        ps.setDouble(4, detalle.getPrecioEspecial());
        ps.setString(5, detalle.getEstadoPrincipal());
        ps.setInt(6, detalle.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(DetalleUnidadMedidaDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO detalle_undmedida (undmed_nombre, detundmed_precioMenor, detundmed_precioMayor, detundmed_precioEspecial, detundmed_estPrincipal, prod_codigo) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setString(1, detalle.getUnidadMedida().getNombre());
        ps.setDouble(2, detalle.getPrecioMenor());
        ps.setDouble(3, detalle.getPrecioMayor());
        ps.setDouble(4, detalle.getPrecioEspecial());
        ps.setString(5, detalle.getEstadoPrincipal());
        ps.setInt(6, detalle.getProducto().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(DetalleUnidadMedidaDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM detalle_undmedida WHERE detundmed_codigo = ?");
        ps.setInt(1, detalle.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }
}
