package com.admin.model.dao;

import com.admin.model.dto.VehiculoDTO;
import com.admin.model.interfaces.IVehiculo;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class VehiculoDAO implements IVehiculo {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static VehiculoDAO instance = null;
    private VehiculoDTO vehiculo = null;
    private ArrayList<VehiculoDTO> listVehiculo = null;
    private int value = 0;

    private VehiculoDAO() {
    
    }
    
    public static VehiculoDAO getInstance() {
        if (instance == null) {
            instance = new VehiculoDAO();
        }
        return instance;
    }

    @Override
    public VehiculoDTO getById(String placa) throws SQLException {
        vehiculo = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT vehi_numPlaca AS placa, vehiculo_numCertiInscrip AS certificacion, vehi_marca AS marca, vehi_kilometraje AS km, vehi_galonaje AS gl, IF(vehi_estado = 1, 'Activo', 'Inactivo') AS estado FROM vehiculo WHERE vehi_numPlaca = ?");
        ps.setString(1, placa);
        rs = ps.executeQuery();
        while (rs.next()) {
            vehiculo = new VehiculoDTO(
                    rs.getString("placa"),
                    rs.getString("certificacion"),
                    rs.getString("marca"),
                    rs.getFloat("km"),
                    rs.getFloat("gl"),
                    rs.getString("estado")
            );
        }
        rs.close();
        ps.close();
        
        return vehiculo;
    }

    @Override
    public ArrayList<VehiculoDTO> getByAllByStatus(int status) throws SQLException {
        listVehiculo = new ArrayList<>();
        vehiculo = null;
        if (status > 1) {
            ps = dbInstance.getConnection().prepareStatement("SELECT vehi_numPlaca AS placa, vehiculo_numCertiInscrip AS certificacion, vehi_marca AS marca, vehi_kilometraje AS km, vehi_galonaje AS gl, IF(vehi_estado = 1, 'Activo', 'Inactivo') AS estado FROM vehiculo");
        } else {
            ps = dbInstance.getConnection().prepareStatement("SELECT vehi_numPlaca AS placa, vehiculo_numCertiInscrip AS certificacion, vehi_marca AS marca, vehi_kilometraje AS km, vehi_galonaje AS gl, IF(vehi_estado = 1, 'Activo', 'Inactivo') AS estado FROM vehiculo WHERE vehi_estado = ?");
            ps.setInt(1, status);
        }        
        rs = ps.executeQuery();
        while (rs.next()) {
            vehiculo = new VehiculoDTO(
                    rs.getString("placa"),
                    rs.getString("certificacion"),
                    rs.getString("marca"),
                    rs.getFloat("km"),
                    rs.getFloat("gl"),
                    rs.getString("estado")
            );
            listVehiculo.add(vehiculo);
        }
        rs.close();
        ps.close();
        
        return listVehiculo;
    }

    @Override
    public boolean updateVehiculo(VehiculoDTO vehiculo, String placaAnterior) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE vehiculo SET vehi_numPlaca = ?, vehiculo_numCertiInscrip = ?, vehi_marca = ?, vehi_kilometraje = ?, vehi_galonaje = ? WHERE vehi_numPlaca = ?");
        ps.setString(1, vehiculo.getNumeroPlaca());
        ps.setString(2, vehiculo.getNumeroCertificacion());
        ps.setString(3, vehiculo.getMarca());
        ps.setFloat(4, vehiculo.getKilometraje());
        ps.setFloat(5, vehiculo.getGalonaje());
        ps.setString(6, placaAnterior);
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insertVehiculo(VehiculoDTO vehiculo) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO vehiculo (vehi_numPlaca, vehiculo_numCertiInscrip, vehi_marca, vehi_kilometraje, vehi_galonaje) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, vehiculo.getNumeroPlaca());
        ps.setString(2, vehiculo.getNumeroCertificacion());
        ps.setString(3, vehiculo.getMarca());
        ps.setFloat(4, vehiculo.getKilometraje());
        ps.setFloat(5, vehiculo.getGalonaje());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean deleteVehiculo(VehiculoDTO vehiculo, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE vehiculo SET vehi_estado = ? WHERE vehi_numPlaca = ?");
        ps.setInt(1, status);
        ps.setString(2, vehiculo.getNumeroPlaca());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

}
