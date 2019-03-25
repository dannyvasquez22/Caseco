package com.admin.model.dao;

import com.admin.model.dto.AccesoDTO;
import com.admin.model.dto.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Global;
import com.admin.model.interfaces.ICRUD;
import com.admin.resource.utils.Constantes;

/** * @author DANNY VASQUEZ RAFAEL */

public class AccesoDAO implements ICRUD<AccesoDTO> {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private AccesoDTO acceso = null;
    private ArrayList<AccesoDTO> accesos = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static AccesoDAO instance = null;
    private final String q_getAll = "SELECT acc_codigo, acc_fecha, acc_horaInicio, acc_horaFin, usu_cuenta FROM acceso";
    private final String q_update = "UPDATE acceso SET acc_fecha = COALESCE(?, acc_fecha), acc_horaInicio = COALESCE(?, acc_horaInicio), acc_horaFin = COALESCE(?, acc_horaFin), usu_cuenta = COALESCE(?, usu_cuenta) WHERE acc_codigo = ?";
    private final String q_create = "INSERT INTO acceso (acc_fecha, acc_horaInicio, acc_horaFin, usu_cuenta) VALUES (?, ?, ?, ?)";
    private final String q_delete = "DELETE FROM acceso WHERE acc_codigo = ?";

    private AccesoDAO() {
    }

    public static AccesoDAO getInstance() {
        if (instance == null) {
            instance = new AccesoDAO();
        }
        return instance;
    }
    
    @Override
    public AccesoDTO findByPk(int codigo) throws SQLException{
        return getAll(Constantes.I_NUM_DOS).stream().filter(acc -> acc.getCodigo() == codigo).findFirst().orElse(null);
    }
    
    @Override
    public ArrayList<AccesoDTO> getAll(int status) throws SQLException{
        accesos = new ArrayList<>();
        acceso = null;
        ps = dbInstance.getConnection().prepareStatement(q_getAll);
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
    public boolean update(AccesoDTO acceso) throws SQLException{
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_update);
        ps.setInt(Constantes.I_NUM_CINCO, acceso.getCodigo());        
        if(acceso.getFecha() != null) { 
            ps.setString(Constantes.I_NUM_DOS, Global.FORMAT_DATE_SQL.format(acceso.getFecha()));
        } else { 
            ps.setNull(Constantes.I_NUM_DOS, Types.DATE);
        }        
        if(acceso.getHoraInicio() != null) { 
            ps.setTime(Constantes.I_NUM_TRES, acceso.getHoraInicio());
        } else { 
            ps.setNull(Constantes.I_NUM_TRES, Types.TIME);
        }        
        if(acceso.getHoraFin() != null) { 
            ps.setTime(Constantes.I_NUM_CUATRO, acceso.getHoraFin());
        } else { 
            ps.setNull(Constantes.I_NUM_CUATRO, Types.TIME);
        }        
        ps.setString(Constantes.I_NUM_CINCO, acceso.getUsuario().getCuenta());        
        value = ps.executeUpdate();
        ps.close();   
        
        return (value > Constantes.I_NUM_CERO);        
    }
    
    @Override
    public boolean create(AccesoDTO acceso) throws SQLException{
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_create);
        ps.setString(Constantes.I_NUM_UNO, Global.FORMAT_DATE_SQL.format(acceso.getFecha()));
        ps.setTime(Constantes.I_NUM_DOS, acceso.getHoraInicio());
        ps.setTime(Constantes.I_NUM_TRES, acceso.getHoraFin());
        ps.setString(Constantes.I_NUM_CUATRO, acceso.getUsuario().getCuenta());        
        value = ps.executeUpdate();
        ps.close();
        
        return (value > Constantes.I_NUM_CERO);
    }
    
    @Override
    public boolean delete(AccesoDTO acceso) throws SQLException{
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_delete);
        ps.setInt(Constantes.I_NUM_UNO, acceso.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > Constantes.I_NUM_CERO);
    }

    @Override
    public boolean update(AccesoDTO t, String pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(AccesoDTO t, int status) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccesoDTO findByPk(String pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AccesoDTO> getAllByPagination(String name, int page, int registers, int modeStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
