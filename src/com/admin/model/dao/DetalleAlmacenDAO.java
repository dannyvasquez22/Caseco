package com.admin.model.dao;

import com.admin.model.dto.DetalleAlmacenDTO;
import com.admin.model.interfaces.IDetalleAlmacen;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleAlmacenDAO implements IDetalleAlmacen {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private DetalleAlmacenDTO detalleAlmacen = null;
    private ArrayList<DetalleAlmacenDTO> listDetalleAlmacen = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static DetalleAlmacenDAO instance = null;

    private DetalleAlmacenDAO() {
    }

    public static DetalleAlmacenDAO getInstance() {
        if (instance == null) {
            instance = new DetalleAlmacenDAO();
        }
        return instance;
    }

    @Override
    public DetalleAlmacenDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleAlmacenDTO> getAllByProduct(int codigo) throws SQLException {
        listDetalleAlmacen = new ArrayList<>();
        return listDetalleAlmacen;
    }

    @Override
    public boolean update(DetalleAlmacenDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_almacen SET detalm_stockActual = ?, detalm_stockCritico = ?, dettien_codigo = ?, prod_codigo = ? WHERE detalm_codigo = ?");
        ps.setDouble(1, detalle.getStockActual());
        ps.setDouble(2, detalle.getStockCritico());
        ps.setInt(3, detalle.getDetalleTienda().getCodigo());
        ps.setInt(4, detalle.getProducto().getCodigo());
        ps.setInt(5, detalle.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(DetalleAlmacenDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO detalle_almacen (detalm_stockActual, detalm_stockCritico, dettien_codigo, prod_codigo) VALUES (?, ?, ?, ?)");
        ps.setDouble(1, detalle.getStockActual());
        ps.setDouble(2, detalle.getStockCritico());
        ps.setInt(3, detalle.getDetalleTienda().getCodigo());
        ps.setInt(4, detalle.getProducto().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(DetalleAlmacenDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_almacen SET detalm_estadoStock = 0 WHERE detalm_codigo = ?");
        ps.setInt(1, detalle.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        return value > 0;
    }

}
