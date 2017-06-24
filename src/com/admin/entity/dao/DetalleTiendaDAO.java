package com.admin.entity.dao;

import com.admin.entity.dto.DetalleTiendaDTO;
import com.admin.entity.interfaces.IDetalleTienda;
import com.admin.entity.pojo.TiendaAlmacenP;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleTiendaDAO implements IDetalleTienda {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static DetalleTiendaDAO instance = null;
    private TiendaAlmacenP detalle = null;
    private ArrayList<TiendaAlmacenP> listDetalle = null;
    private DetalleTiendaDTO detalleTienda = null;
    private ArrayList<DetalleTiendaDTO> listDetalleTienda = null;
    private int value = 0;

    private DetalleTiendaDAO() {
    
    }
    
    public static DetalleTiendaDAO getInstance() {
        if (instance == null) {
            instance = new DetalleTiendaDAO();
        }
        return instance;
    }

    @Override
    public DetalleTiendaDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleTiendaDTO> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDetalleTienda(DetalleTiendaDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_tienda SET alm_codigo = ? WHERE dettien_codigo = ? AND tienda_codigo = ?");
        ps.setInt(1, detalle.getAlmacen().getCodigo());
        ps.setInt(2, detalle.getTienda().getCodigo());
        ps.setInt(3, detalle.getCodigo());        
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertDetalleTienda(DetalleTiendaDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO detalle_tienda (dettien_fechaInicio, tienda_codigo, alm_codigo) VALUES (?, ?, ?)");
        ps.setString(1, detalle.getFechaInicio());
        ps.setInt(2, detalle.getTienda().getCodigo());
        ps.setInt(3, detalle.getAlmacen().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean deleteDetalleTienda(DetalleTiendaDTO detalle) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_tienda SET dettien_fechaFin = ?  WHERE dettien_codigo = ? ");
        ps.setString(1, detalle.getFechaFin());
        ps.setInt(3, detalle.getCodigo());        
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public ArrayList<TiendaAlmacenP> getAllDetail(int codigo) throws SQLException {
        listDetalle = new ArrayList<>();
        detalle = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT detalle_tienda.dettien_codigo AS codigo, "
                + "DATE_FORMAT(detalle_tienda.dettien_fechaInicio, '%d/%m/%Y') AS fechaInicio, "
                + "IF(detalle_tienda.dettien_fechaFin = '1111-11-11', '', DATE_FORMAT(detalle_tienda.dettien_fechaFin, '%d/%m/%Y')) AS fechaFin, "
                + "almacen.alm_nombre AS almacen "
                + "FROM detalle_tienda INNER JOIN almacen ON detalle_tienda.alm_codigo = almacen.alm_codigo "
                + "WHERE detalle_tienda.tienda_codigo = ?");
        ps.setInt(1, codigo);
        rs = ps.executeQuery();
        while (rs.next()) {
            detalle = new TiendaAlmacenP(
                    rs.getInt("codigo"),
                    rs.getString("fechaInicio"),
                    rs.getString("fechaFin"),
                    rs.getString("almacen")
            );
            listDetalle.add(detalle);
        }
        rs.close();
        ps.close();
        
        return listDetalle;
    }

    @Override
    public DetalleTiendaDTO getByAlmacenByTienda(int almacen, int tienda) throws SQLException {
        detalleTienda = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT dettien_codigo AS codigo FROM detalle_tienda WHERE alm_codigo = ? AND tienda_codigo = ?");
        ps.setInt(1, almacen);
        ps.setInt(2, tienda);
        rs = ps.executeQuery();
        while(rs.next()) {
            detalleTienda = new DetalleTiendaDTO(
                    rs.getInt("codigo")
            );
        }
        rs.close();
        ps.close();
        
        return detalleTienda;
    }
    
}
