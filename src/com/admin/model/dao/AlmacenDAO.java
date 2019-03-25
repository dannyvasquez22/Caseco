package com.admin.model.dao;

import com.admin.model.dto.AlmacenDTO;
import com.admin.model.interfaces.IAlmacen;
import com.admin.model.interfaces.ICRUD;
import com.admin.resource.utils.Config;
import com.admin.resource.utils.Constantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/** * @author DANNY VASQUEZ RAFAEL */

public class AlmacenDAO implements ICRUD<AlmacenDTO>, IAlmacen {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private static AlmacenDAO instance = null;
    private AlmacenDTO almacen = null;
    private ArrayList<AlmacenDTO> listAlmacen = null;
    private ArrayList<String> namesCombo = null;
    private int value = Constantes.I_NUM_CERO;
    private final String q_getAll = "SELECT alm_codigo, alm_nombre, alm_direccion FROM almacen";
    private final String q_update = "UPDATE almacen SET alm_nombre = ?, alm_direccion = ? WHERE alm_codigo = ?";
    private final String q_create = "INSERT INTO almacen (alm_nombre, alm_direccion) VALUES (?, ?)";
    private final String q_delete = "DELETE FROM almacen WHERE alm_codigo = ?";
    private final String q_getElementChild = "SELECT COALESCE(COUNT(dettien_codigo), 0) AS total FROM detalle_tienda WHERE alm_codigo = ?";
    private final String q_namesByStoreCombo = "SELECT al.alm_nombre AS nombre "
                + "FROM almacen AS al "
                + "INNER JOIN detalle_tienda AS dt ON al.alm_codigo = dt.alm_codigo "
                + "INNER JOIN tienda AS ti ON dt.tienda_codigo = ti.tienda_codigo "
                + "WHERE ti.tienda_razonSocial = ?";

    private AlmacenDAO() {
    
    }
    
    public static AlmacenDAO getInstance() {
        if (instance == null) {
            instance = new AlmacenDAO();
        }
        return instance;
    }     
    
    @Override
    public AlmacenDTO findByPk(int codigo) throws SQLException{ 
        return getAll(Constantes.I_NUM_DOS).stream().filter(alm -> alm.getCodigo() == codigo).findFirst().orElse(null);
    }
    
    public AlmacenDTO findByName(String nombre) throws SQLException {
        return getAll(Constantes.I_NUM_DOS).stream().filter(alm -> alm.getNombre().equals(nombre)).findFirst().orElse(null);
    }
    
    @Override
    public ArrayList<AlmacenDTO> getAll(int status) throws SQLException{   
        listAlmacen = new ArrayList<>();
        almacen = null;
        ps = dbInstance.getConnection().prepareStatement(q_getAll);
        rs = ps.executeQuery();
        while(rs.next()){
            almacen = new AlmacenDTO(rs.getInt("alm_codigo"), rs.getString("alm_nombre"), rs.getString("alm_direccion"));
            listAlmacen.add(almacen);
        }
        ps.close();
        rs.close();
        
        return listAlmacen;
    }
    
    @Override
    public boolean update(AlmacenDTO almacen) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_update);        
        ps.setString(Constantes.I_NUM_UNO, almacen.getNombre());
        ps.setString(Constantes.I_NUM_DOS, almacen.getDireccion());
        ps.setInt(Constantes.I_NUM_TRES, almacen.getCodigo());         
        value = ps.executeUpdate();
        ps.close();          
        
        return value > Constantes.I_NUM_CERO;
    }

    @Override
    public boolean create(AlmacenDTO almacen) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_create);
        ps.setString(Constantes.I_NUM_UNO, almacen.getNombre());
        ps.setString(Constantes.I_NUM_DOS, almacen.getDireccion());
        value = ps.executeUpdate();
        ps.close();          
        
        return value > Constantes.I_NUM_CERO;
    }

    @Override
    public boolean delete(AlmacenDTO almacen) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_delete);
        ps.setInt(Constantes.I_NUM_UNO, almacen.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        rs.close();
        
        return value > Constantes.I_NUM_CERO;
    }

    @Override
    public int getElementChild(int codigo) throws SQLException {
        value = Constantes.I_NUM_CERO;
        ps = dbInstance.getConnection().prepareStatement(q_getElementChild);
        ps.setInt(Constantes.I_NUM_UNO, codigo);
        rs = ps.executeQuery();
        while(rs.next()) {
            value = rs.getInt("total");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    public ArrayList<String> getNameByCombo() throws SQLException {
        return new ArrayList<>(getAll(Constantes.I_NUM_DOS).stream().map(AlmacenDTO::getNombre).sorted().collect(Collectors.toList()));
    }

    @Override
    public ArrayList<String> getNamesByStoreCombo(String tiendaRazonSocial) throws SQLException {
        namesCombo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement(q_namesByStoreCombo);
        ps.setString(1, tiendaRazonSocial);
        rs = ps.executeQuery();
        while (rs.next()) {
            namesCombo.add(rs.getString("nombre"));
        }
        rs.close();
        ps.close();
        
        return namesCombo;
    }

    @Override
    public boolean update(AlmacenDTO t, String pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(AlmacenDTO t, int status) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlmacenDTO findByPk(String pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AlmacenDTO> getAllByPagination(String name, int page, int registers, int modeStatus) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
