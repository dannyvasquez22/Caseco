package com.admin.model.dao;

import com.admin.model.dto.TiendaProductoDTO;
import com.admin.model.interfaces.ITiendaProducto;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaProductoDAO implements ITiendaProducto {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private CallableStatement call = null;
    private TiendaProductoDTO tiendaProducto = null;
    private ArrayList<TiendaProductoDTO> listTiendaProducto = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static TiendaProductoDAO instance = null;

    private TiendaProductoDAO() {
    }

    public static TiendaProductoDAO getInstance() {
        if (instance == null) {
            instance = new TiendaProductoDAO();
        }
        return instance;
    }

    @Override
    public TiendaProductoDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TiendaProductoDTO> getAll(int codigoProducto, String razonSocialTienda) throws SQLException {
        listTiendaProducto = new ArrayList<>();
        tiendaProducto = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT DATE_FORMAT(tp.tienprod_fechainicio, '%d/%m/%Y') AS fechaInicio, "
                + "IF(tp.tienprod_fechafin = '1111-11-11', '', DATE_FORMAT(tp.tienprod_fechafin, '%d/%m/%Y')) AS fechaFin "
                + "FROM tienda_producto AS tp INNER JOIN tienda AS ti ON tp.tienda_codigo = ti.tienda_codigo WHERE tp.prod_codigo = ? AND ti.tienda_razonSocial = ?");
        ps.setInt(1, codigoProducto);
        ps.setString(2, razonSocialTienda);
        rs = ps.executeQuery();
        while (rs.next()) {
            tiendaProducto = new TiendaProductoDTO(
                    rs.getString("fechaInicio"),
                    rs.getString("fechaFin")
            );
            listTiendaProducto.add(tiendaProducto);
        }
        rs.close();
        ps.close();
        
        return listTiendaProducto;
    }

    @Override
    public boolean update(TiendaProductoDTO tiendaProducto) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE tienda_producto SET tienprod_fechafin = ? WHERE prod_codigo = ? AND tienda_codigo = ? AND tienprod_fechafin = '1111-11-11'");
        ps.setString(1, tiendaProducto.getFechaInicio());
        ps.setInt(2, tiendaProducto.getProducto().getCodigo());
        ps.setInt(3, tiendaProducto.getTienda().getCodigo());        
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(TiendaProductoDTO tiendaProducto) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO tienda_producto (tienprod_fechainicio, tienda_codigo, prod_codigo) VALUES (?, ?, ?)");
        ps.setString(1, tiendaProducto.getFechaInicio());
        ps.setInt(2, tiendaProducto.getTienda().getCodigo());
        ps.setInt(3, tiendaProducto.getProducto().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(TiendaProductoDTO tiendaProducto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
