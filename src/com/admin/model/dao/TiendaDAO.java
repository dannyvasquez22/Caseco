package com.admin.model.dao;

import com.admin.model.dto.TiendaDTO;
import com.admin.model.interfaces.ITienda;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaDAO implements ITienda {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static TiendaDAO instance = null;
    private TiendaDTO tienda = null;
    private ArrayList<TiendaDTO> listTienda = null;
    private ArrayList<String> namesCombo = null;
    private int value = 0;

    private TiendaDAO() {
    
    }
    
    public static TiendaDAO getInstance() {
        if (instance == null) {
            instance = new TiendaDAO();
        }
        return instance;
    }

    @Override
    public TiendaDTO getById(int id) throws SQLException {
        tienda = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT tienda_codigo AS codigo, tienda_ruc AS ruc, tienda_razonSocial AS razonSocial, tienda_direccion AS direccion, tienda_observacion AS observacion FROM tienda WHERE tienda_codigo = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            tienda = new TiendaDTO(
                    rs.getInt("codigo"),
                    rs.getString("ruc"),
                    rs.getString("razonSocial"),
                    rs.getString("direccion"),
                    rs.getString("observacion")
            );
        }
        rs.close();
        ps.close();
        
        return tienda;
    }

    @Override
    public ArrayList<TiendaDTO> getAll() throws SQLException {
        listTienda = new ArrayList<>();
        tienda = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT tienda_codigo AS codigo, tienda_ruc AS ruc, tienda_razonSocial AS razonSocial, tienda_direccion AS direccion, tienda_observacion AS observacion FROM tienda");
        rs = ps.executeQuery();
        while (rs.next()) {
            tienda = new TiendaDTO(
                    rs.getInt("codigo"),
                    rs.getString("ruc"),
                    rs.getString("razonSocial"),
                    rs.getString("direccion"),
                    rs.getString("observacion")
            );
            listTienda.add(tienda);
        }
        rs.close();
        ps.close();
        
        return listTienda;
    }

    @Override
    public boolean updateTienda(TiendaDTO tienda) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE tienda SET tienda_ruc = ?, tienda_razonSocial = ?, tienda_direccion = ?, tienda_observacion = ? WHERE tienda_codigo = ?");
        ps.setString(1, tienda.getRuc());
        ps.setString(2, tienda.getRazonSocial());
        ps.setString(3, tienda.getDireccion());
        ps.setString(4, tienda.getObservacion());
        ps.setInt(5, tienda.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertTienda(TiendaDTO tienda) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO tienda (tienda_ruc, tienda_razonSocial, tienda_direccion, tienda_observacion) VALUES (?, ?, ?, ?)");
        ps.setString(1, tienda.getRuc());
        ps.setString(2, tienda.getRazonSocial());
        ps.setString(3, tienda.getDireccion());
        ps.setString(4, tienda.getObservacion());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean deleteTienda(TiendaDTO tienda) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM tienda WHERE tienda_codigo = ?");
        ps.setInt(1, tienda.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public int getElementChild(int id, int modo) throws SQLException {
        value = 0;
        if (modo == 0) {
            ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(dettien_codigo) AS total FROM detalle_tienda WHERE tienda_codigo = ?");
        } else {
            ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(tienprod_codigo) AS total FROM tienda_producto WHERE tienda_codigo = ?");
        }
        ps.setInt(1, id);
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
        namesCombo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT tienda_razonSocial AS razonSocial FROM tienda");
        rs = ps.executeQuery();
        while (rs.next()) {
            namesCombo.add(rs.getString("razonSocial"));
        }
        rs.close();
        ps.close();
        
        return namesCombo;
    }

    @Override
    public TiendaDTO getByRazon(String razonSocial) throws SQLException {
        tienda = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT tienda_codigo FROM tienda WHERE tienda_razonSocial = ?");
        ps.setString(1, razonSocial);
        rs = ps.executeQuery();
        while (rs.next()) {
            tienda = new TiendaDTO(rs.getInt("tienda_codigo"));
        }
        rs.close();
        ps.close();
        
        return tienda;
    }
    
}
