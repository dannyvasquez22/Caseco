package com.admin.entity.dao;

import com.admin.entity.dto.DetalleCargoDTO;
import com.admin.entity.dto.LicenciaDTO;
import com.admin.entity.interfaces.ILicencia;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class LicenciaDAO implements ILicencia {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private static LicenciaDAO instance = null;
    private LicenciaDTO licencia = null;
    private ArrayList<LicenciaDTO> listLicencia = null;
    private int value = 0;

    private LicenciaDAO() {
    
    }
    
    public static LicenciaDAO getInstance() {
        if (instance == null) {
            instance = new LicenciaDAO();
        }
        return instance;
    }

    @Override
    public LicenciaDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LicenciaDTO> getByAll() throws SQLException {
        licencia = null;
        listLicencia = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT li.lic_codigo AS codigo, li.lic_numero AS numero, li.lic_clase AS clase, li.lic_categoria AS categoria, DATE_FORMAT(li.lic_fechaExpedicion, '%d/%m/%Y') AS expedicion, IF(li.lic_fechaRevalidacion = '1111-11-11', '', DATE_FORMAT(li.lic_fechaRevalidacion, '%d/%m/%Y')) AS revalidacion, li.lic_descripcion AS descripcion, li.detcarg_codigo AS detalle FROM licencia AS li");
        rs = ps.executeQuery();
        while (rs.next()) {
            licencia = new LicenciaDTO(
                    rs.getInt("codigo"),
                    rs.getString("numero"),
                    rs.getString("clase"),
                    rs.getString("categoria"),
                    rs.getString("expedicion"),
                    rs.getString("revalidacion"),
                    rs.getString("descripcion"),
                    new DetalleCargoDTO(rs.getInt("detalle"))
            );
            listLicencia.add(licencia);
        }
        rs.close();
        ps.close();
        
        return listLicencia;
    }

    @Override
    public boolean updateLicencia(LicenciaDTO licencia, int modo) throws SQLException {
        value = 0;
        if (modo == 0) { 
            ps = dbInstance.getConnection().prepareStatement("UPDATE licencia SET lic_numero = ?, lic_clase = ?, lic_categoria = ?, lic_fechaExpedicion = ?, lic_fechaRevalidacion = ?, lic_descripcion = ?, detcarg_codigo = ? WHERE lic_codigo = ?");
            ps.setString(1, licencia.getNumero());
            ps.setString(2, licencia.getClase());
            ps.setString(3, licencia.getCategoria());
            ps.setString(4, licencia.getFechaExpedicion());
            ps.setString(5, licencia.getFechaRevalidacion());
            ps.setString(6, licencia.getDescripcion());
            ps.setInt(7, licencia.getDetalleCargo().getCodigo());
            ps.setInt(8, licencia.getCodigo());
        } else {
            ps = dbInstance.getConnection().prepareStatement("UPDATE licencia SET lic_numero = ?, lic_clase = ?, lic_categoria = ?, lic_fechaExpedicion = ?, lic_fechaRevalidacion = ?, lic_descripcion = ? WHERE lic_codigo = ?");
            ps.setString(1, licencia.getNumero());
            ps.setString(2, licencia.getClase());
            ps.setString(3, licencia.getCategoria());
            ps.setString(4, licencia.getFechaExpedicion());
            ps.setString(5, licencia.getFechaRevalidacion());
            ps.setString(6, licencia.getDescripcion());
            ps.setInt(7, licencia.getCodigo());
        }
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertLicencia(LicenciaDTO licencia) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO licencia (lic_numero, lic_clase, lic_categoria, lic_fechaExpedicion, lic_fechaRevalidacion, lic_descripcion, detcarg_codigo) VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, licencia.getNumero());
        ps.setString(2, licencia.getClase());
        ps.setString(3, licencia.getCategoria());
        ps.setString(4, licencia.getFechaExpedicion());
        ps.setString(5, licencia.getFechaRevalidacion());
        ps.setString(6, licencia.getDescripcion());
        ps.setInt(7, licencia.getDetalleCargo().getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value  > 0;
    }

    @Override
    public boolean deleteLicencia(LicenciaDTO licencia) throws SQLException {
        value = 0;
        ps =dbInstance.getConnection().prepareStatement("DELETE FROM licencia WHERE lic_codigo = ?");
        ps.setInt(1 , licencia.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

}
