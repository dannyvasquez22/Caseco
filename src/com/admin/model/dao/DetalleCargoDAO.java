package com.admin.model.dao;

import com.admin.model.dto.DetalleCargoDTO;
import com.admin.model.interfaces.IDetalleCargo;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DetalleCargoDAO implements IDetalleCargo {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private DetalleCargoDTO detalle = null;
    private static DetalleCargoDAO instance = null;
    private int value = 0;
    
    public DetalleCargoDAO() {
    }

    public static DetalleCargoDAO getInstance() {
        if (instance == null) {
            instance = new DetalleCargoDAO();
        }
        
        return instance;
    }

    @Override
    public DetalleCargoDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleCargoDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDetalleCargo(DetalleCargoDTO detalleCargo) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE detalle_cargo SET detcarg_sueldo = ?, detcarg_fechaInicio = ?, detcarg_fechaFin = ?, carg_nombre = ? WHERE empl_codigo = ?");
        ps.setFloat(1, detalleCargo.getSueldo());
        ps.setString(2, detalleCargo.getFechaInicio());
        ps.setString(3, detalleCargo.getFechaFin());
        ps.setString(4, detalleCargo.getCargo().getNombre());
        ps.setString(5, detalleCargo.getEmpleado().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertDetalleCargo(DetalleCargoDTO detalleCargo) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO detalle_cargo (detcarg_sueldo, detcarg_fechaInicio, detcarg_fechaFin, empl_codigo, carg_nombre) VALUES (?, ?, ?, ?, ?)");
        ps.setFloat(1, detalleCargo.getSueldo());
        ps.setString(2, detalleCargo.getFechaInicio());
        ps.setString(3, detalleCargo.getFechaFin());
        ps.setString(4, detalleCargo.getEmpleado().getCodigo());
        ps.setString(5, detalleCargo.getCargo().getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public DetalleCargoDTO getByCodigoByCargo(String codigo, String cargo) throws SQLException {
        detalle = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT detcarg_codigo AS codigo, detcarg_sueldo AS sueldo, DATE_FORMAT(detcarg_fechaInicio, '%d/%m/%Y') AS inicio, IF(detcarg_fechaFin = '1111-11-11', '', DATE_FORMAT(detcarg_fechaFin, '%d/%m/%Y')) AS fin FROM detalle_cargo WHERE empl_codigo = ? AND carg_nombre = ?");
        ps.setString(1, codigo);
        ps.setString(2, cargo);
        rs = ps.executeQuery();
        while(rs.next()){
            detalle = new DetalleCargoDTO(
                    rs.getInt("codigo"),
                    rs.getFloat("sueldo"),
                    rs.getString("inicio"),
                    rs.getString("fin")
            );
        }
        ps.close();
        rs.close();        
        
        return detalle;
    }

}
