package com.admin.entity.dao;

import com.admin.entity.dto.UnidadMedidaDTO;
import com.admin.entity.interfaces.IUnidadMedida;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class UnidadMedidaDAO implements IUnidadMedida {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static UnidadMedidaDAO instance = null;
    private UnidadMedidaDTO unidad = null;
    private ArrayList<UnidadMedidaDTO> listUnidad = null;
    private ArrayList<String> listNamesUnidad = null;
    private int value = 0;

    private UnidadMedidaDAO() {
    
    }
    
    public static UnidadMedidaDAO getInstance() {
        if (instance == null) {
            instance = new UnidadMedidaDAO();
        }
        return instance;
    }

    @Override
    public UnidadMedidaDTO getById(String nombre) throws SQLException {
        unidad = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT undmed_nombre AS nombre , undmed_valorReferencia AS valor, undmed_descripcion AS descripcion FROM unidad_medida WHERE undmed_nombre = ? ORDER BY undmed_nombre");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            unidad = new UnidadMedidaDTO(
                    rs.getString("nombre"),
                    rs.getFloat("valor"),
                    rs.getString("descripcion")
            );
        }
        rs.close();
        ps.close();
        
        return unidad;
    }

    @Override
    public ArrayList<UnidadMedidaDTO> getAll(String nombre) throws SQLException {
        listUnidad = new ArrayList<>();
        unidad = null;
        if (nombre.equals("")) {
            ps = dbInstance.getConnection().prepareStatement("SELECT undmed_nombre AS nombre , undmed_valorReferencia AS valor, undmed_descripcion AS descripcion FROM unidad_medida ORDER BY undmed_nombre");
        } else {
            ps = dbInstance.getConnection().prepareStatement("SELECT undmed_nombre AS nombre , undmed_valorReferencia AS valor, undmed_descripcion AS descripcion FROM unidad_medida WHERE undmed_nombre LIKE ? ORDER BY undmed_nombre");
            ps.setString(1, nombre + "%");
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            unidad = new UnidadMedidaDTO(
                    rs.getString("nombre"),
                    rs.getFloat("valor"),
                    rs.getString("descripcion")
            );
            listUnidad.add(unidad);
        }
        rs.close();
        ps.close();
        
        return listUnidad;
    }

    @Override
    public boolean updateUnidadMedida(UnidadMedidaDTO unidad, String nombreAnterior) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE unidad_medida SET undmed_nombre = ?, undmed_valorReferencia = ?, undmed_descripcion = ? WHERE undmed_nombre = ?");
        ps.setString(1, unidad.getNombre());
        ps.setFloat(2, unidad.getValorReferencia());
        ps.setString(3, unidad.getDescripcion());
        ps.setString(4, nombreAnterior);
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertUnidadMedida(UnidadMedidaDTO unidad) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO unidad_medida (undmed_nombre, undmed_valorReferencia, undmed_descripcion) VALUES (?, ?, ?)");
        ps.setString(1, unidad.getNombre());
        ps.setFloat(2, unidad.getValorReferencia());
        ps.setString(3, unidad.getDescripcion());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean deleteUnidadMedida(UnidadMedidaDTO unidad) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM unidad_medida WHERE undmed_nombre = ?");
        ps.setString(1, unidad.getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public int getElementChild(String nombre) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(detundmed_codigo) AS total FROM detalle_undmedida WHERE undmed_nombre = ?");
        ps.setString(1, nombre);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public ArrayList<String> getNamesByCombo() throws SQLException {
        listNamesUnidad = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT undmed_nombre AS nombre FROM unidad_medida ORDER BY undmed_nombre");
        rs = ps.executeQuery();
        while (rs.next()) {
            listNamesUnidad.add(rs.getString("nombre"));
        }
        rs.close();
        ps.close();
        
        return listNamesUnidad;
    }

}
