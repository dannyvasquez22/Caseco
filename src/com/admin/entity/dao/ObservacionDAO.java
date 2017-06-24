package com.admin.entity.dao;

import com.admin.entity.dto.ObservacionDTO;
import com.admin.entity.interfaces.IObservacion;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ObservacionDAO implements IObservacion {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private ObservacionDTO observacion = null;
    private ArrayList<ObservacionDTO> listObservacion = null;
    private static ObservacionDAO instance = null;
    private int value = 0;
    
    private ObservacionDAO() {
        
    }
    
    public static ObservacionDAO getInstance() {
        if (instance == null) {
            instance = new ObservacionDAO();
        }
        return instance;
    }

    @Override
    public ObservacionDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ObservacionDTO> getByReference(String tipoReferencia, String codigoReferencia) throws SQLException {
        listObservacion = new ArrayList<>();
        observacion = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT obs_codigo, DATE_FORMAT(obs_fecha, '%d/%m/%Y') AS fecha, obs_descripcion, tipo_referencia, codigo_referencia FROM observaciones WHERE tipo_referencia = ? AND codigo_referencia = ?");
        ps.setString(1, tipoReferencia);
        ps.setString(2, codigoReferencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            observacion = new ObservacionDTO(
                            rs.getInt("obs_codigo"),
                            rs.getString("fecha"),
                            rs.getString("obs_descripcion"),
                            rs.getString("tipo_referencia"),
                            rs.getString("codigo_referencia")
                        );
            listObservacion.add(observacion);
        }
        rs.close();
        ps.close();
        
        return listObservacion;
    }

    @Override
    public ArrayList<ObservacionDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateObservacion(ObservacionDTO observacion) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE observaciones SET obs_fecha = ?, obs_descripcion = ? WHERE obs_codigo = ?");
        ps.setString(1, observacion.getFecha());
        ps.setString(2, observacion.getDescripcion());
        ps.setInt(3, observacion.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public boolean insertObservacion(ObservacionDTO observacion) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO observaciones (obs_fecha, obs_descripcion, tipo_referencia, codigo_referencia) VALUES (?, ?, ?, ?)");
        ps.setString(1, observacion.getFecha());
        ps.setString(2, observacion.getDescripcion());
        ps.setString(3, observacion.getTipoReferencia());
        ps.setString(4, observacion.getCodigoReferencia());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public boolean deleteObservacion(ObservacionDTO observacion) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM observaciones WHERE obs_codigo = ?");
        ps.setInt(1, observacion.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

}
