package com.admin.model.dao;

import com.admin.model.dto.ProveedorDTO;
import com.admin.model.dto.ProveedorProductoDTO;
import com.admin.model.interfaces.IProveedorProducto;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProveedorProductoDAO implements IProveedorProducto {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private ProveedorProductoDTO proveedorProducto = null;
    private ArrayList<ProveedorProductoDTO> listProveedorProducto = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static ProveedorProductoDAO instance = null;

    private ProveedorProductoDAO() {
    }

    public static ProveedorProductoDAO getInstance() {
        if (instance == null) {
            instance = new ProveedorProductoDAO();
        }
        return instance;
    }

    @Override
    public ProveedorProductoDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProveedorProductoDTO> getByIdProducto(int id) throws SQLException {
        listProveedorProducto = new ArrayList<>();
        proveedorProducto = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT "
                                                        + "proveprod_codigo_codigo AS codigo, "
                                                        + "prove_nombre AS proveedor, "
                                                        + "proveprod_preciocompra AS precioCompra, "
                                                        + "proveprod_flete AS flete, "
                                                        + "proveprod_renta AS renta, "
                                                        + "proveprod_percepcion AS percepcion, "
                                                        + "proveprod_codCatalogo AS catalogo "
                                                        + "FROM proveedor_producto WHERE prod_codigo = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            proveedorProducto = new ProveedorProductoDTO(
                    rs.getInt("codigo"),                    
                    rs.getDouble("precioCompra"),
                    rs.getDouble("flete"),
                    rs.getDouble("renta"),
                    rs.getDouble("percepcion"),
                    rs.getString("catalogo"),
                    new ProveedorDTO(rs.getString("proveedor"))
            );
            listProveedorProducto.add(proveedorProducto);
        }
        rs.close();
        ps.close();
        
        return listProveedorProducto;
    }

    @Override
    public ArrayList<ProveedorProductoDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ProveedorProductoDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE proveedor_producto SET prove_nombre = ?, proveprod_preciocompra = ?, proveprod_flete = ?, proveprod_renta = ?, proveprod_percepcion = ?, proveprod_codCatalogo = ? WHERE proveprod_codigo_codigo = ?");
        ps.setString(1, detalle.getProveedor().getNombre());
        ps.setDouble(2, detalle.getPrecioCompra());
        ps.setDouble(3, detalle.getFlete());
        ps.setDouble(4, detalle.getRenta());
        ps.setDouble(5, detalle.getPercepcion());
        ps.setString(6, detalle.getCodCatalago());
        ps.setInt(7, detalle.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(ProveedorProductoDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO proveedor_producto (prove_nombre, proveprod_preciocompra, proveprod_flete, proveprod_renta, proveprod_percepcion, proveprod_codCatalogo, prod_codigo) VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, detalle.getProveedor().getNombre());
        ps.setDouble(2, detalle.getPrecioCompra());
        ps.setDouble(3, detalle.getFlete());
        ps.setDouble(4, detalle.getRenta());
        ps.setDouble(5, detalle.getPercepcion());
        ps.setString(6, detalle.getCodCatalago());
        ps.setInt(7, detalle.getProducto().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(ProveedorProductoDTO detalle) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
