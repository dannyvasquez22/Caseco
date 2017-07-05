package com.admin.model.dao;

import com.admin.model.dto.AccesoDTO;
import com.admin.model.dto.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import com.admin.model.interfaces.IAcceso;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Global;

/** * @author DANNY VASQUEZ RAFAEL */

public class AccesoDAO implements IAcceso {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private AccesoDTO acceso = null;
    private ArrayList<AccesoDTO> accesos = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static AccesoDAO instance = null;

    private AccesoDAO() {
    }

    public static AccesoDAO getInstance() {
        if (instance == null) {
            instance = new AccesoDAO();
        }
        return instance;
    }
    
    @Override
    public AccesoDTO getById(int codigo) throws SQLException{      
        acceso = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT acc_codigo, acc_fecha, acc_horaInicio, acc_horaFin, usu_cuenta FROM acceso WHERE acc_codigo = ?");
        ps.setInt(1, codigo);
        rs = ps.executeQuery();
        while(rs.next()){
            acceso = new AccesoDTO(rs.getInt("acc_codigo"), 
                                   rs.getDate("acc_fecha"), 
                                   rs.getTime("acc_horaInicio"), 
                                   rs.getTime("acc_horaFin"), 
                                   new UsuarioDTO(rs.getString("usu_cuenta")));
        }
        ps.close();
        rs.close();
        
        return acceso;
    }
    
    @Override
    public ArrayList<AccesoDTO> getByAll() throws SQLException{
        accesos = new ArrayList<>();
        acceso = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT acc_codigo, acc_fecha, acc_horaInicio, acc_horaFin, usu_cuenta FROM acceso");
        rs = ps.executeQuery();
        while(rs.next()){
            acceso = new AccesoDTO(rs.getInt("acc_codigo"), 
                                   rs.getDate("acc_fecha"), 
                                   rs.getTime("acc_horaInicio"), 
                                   rs.getTime("acc_horaFin"), 
                                   new UsuarioDTO(rs.getString("usu_cuenta")));
            accesos.add(acceso);
        }
        ps.close();
        rs.close();
                
        return accesos;
    }
    
    @Override
    public boolean updateAcceso(AccesoDTO acceso) throws SQLException{
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE acceso SET acc_fecha = COALESCE(?, acc_fecha), acc_horaInicio = COALESCE(?, acc_horaInicio), acc_horaFin = COALESCE(?, acc_horaFin), usu_cuenta = COALESCE(?, usu_cuenta) WHERE acc_codigo = ?");
        ps.setInt(5, acceso.getCodigo());        
        if(acceso.getFecha() != null) { 
            ps.setString(2, Global.FORMAT_DATE_SQL.format(acceso.getFecha()));
        } else { 
            ps.setNull(2, Types.DATE);
        }        
        if(acceso.getHoraInicio() != null) { 
            ps.setTime(3, acceso.getHoraInicio());
        } else { 
            ps.setNull(3, Types.TIME);
        }        
        if(acceso.getHoraFin() != null) { 
            ps.setTime(4, acceso.getHoraFin());
        } else { 
            ps.setNull(4, Types.TIME);
        }        
        ps.setString(5, acceso.getUsuario().getCuenta());        
        value = ps.executeUpdate();
        ps.close();   
        
        return (value > 0);        
    }
    
    @Override
    public boolean insertAcceso(AccesoDTO acceso) throws SQLException{
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO acceso (acc_fecha, acc_horaInicio, acc_horaFin, usu_cuenta) VALUES (?, ?, ?, ?)");
        ps.setString(1, Global.FORMAT_DATE_SQL.format(acceso.getFecha()));
        ps.setTime(2, acceso.getHoraInicio());
        ps.setTime(3, acceso.getHoraFin());
        ps.setString(4, acceso.getUsuario().getCuenta());        
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }
    
    @Override
    public boolean deleteAcceso(AccesoDTO acceso) throws SQLException{
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM acceso WHERE acc_codigo = ?");
        ps.setInt(1, acceso.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }
    
}
