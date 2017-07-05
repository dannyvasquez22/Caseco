package com.admin.model.dao;

import com.admin.model.dto.DireccionDTO;
import com.admin.model.interfaces.IDireccion;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class DireccionDAO implements IDireccion {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private DireccionDTO direccion = null;
    private static DireccionDAO instance = null;
    private int value = 0;
    
    private DireccionDAO() {
        
    }
    
    public static DireccionDAO getInstance() {
        if (instance == null) {
            instance = new DireccionDAO();
        }
        return instance;
    }

    @Override
    public DireccionDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DireccionDTO getByCodigoByCargo(String tipoReferencia, String codigoReferencia) throws SQLException {
        direccion = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT dire_codigo AS codigo, dire_departamento AS departamento, dire_provincia AS provincia, dire_distrito AS distrito FROM direccion WHERE tipo_referencia = ? AND codigo_referencia = ?");
        ps.setString(1, tipoReferencia);
        ps.setString(2, codigoReferencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            direccion = new DireccionDTO(
                    rs.getInt("codigo"),
                    rs.getString("departamento"),
                    rs.getString("provincia"),
                    rs.getString("distrito")
            );
        }
        rs.close();
        ps.close();
        
        return direccion;
    }

    @Override
    public ArrayList<DireccionDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateDireccion(DireccionDTO direccion) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE direccion SET dire_departamento = ?, dire_provincia = ?, dire_distrito = ? WHERE tipo_referencia = ? AND codigo_referencia = ?");
        ps.setString(1, direccion.getDepartamento());
        ps.setString(2, direccion.getProvincia());
        ps.setString(3, direccion.getDistrito());
        ps.setString(4, direccion.getTipoReferencia());
        ps.setString(5, direccion.getCodigoReferencia());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertDireccion(DireccionDTO direccion) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO direccion(dire_departamento, dire_provincia, dire_distrito, tipo_referencia, codigo_referencia) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, direccion.getDepartamento());
        ps.setString(2, direccion.getProvincia());
        ps.setString(3, direccion.getDistrito());
        ps.setString(4, direccion.getTipoReferencia());
        ps.setString(5, direccion.getCodigoReferencia());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean deleteDireccion(DireccionDTO direccion) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DireccionDTO getByTipo(String tipoReferencia, String codigoReferencia) throws SQLException {
        direccion = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT dire_codigo AS codigo FROM direccion WHERE tipo_referencia = ? AND codigo_referencia = ?");
        ps.setString(1, tipoReferencia);
        ps.setString(2, codigoReferencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            direccion = new DireccionDTO(rs.getInt("codigo"));
        }
        rs.close();
        ps.close();
        
        return direccion;
    }

}
