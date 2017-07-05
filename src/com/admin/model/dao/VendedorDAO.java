package com.admin.model.dao;

import com.admin.model.dto.VendedorDTO;
import com.admin.model.interfaces.IVendedor;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class VendedorDAO implements IVendedor {
    private final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private ArrayList<VendedorDTO> listVendedor = null;
    private VendedorDTO vendedor = null;
    private ArrayList<String> namesCombo = null;
    private static VendedorDAO instance = null;
    private int value = 0;
    
    private VendedorDAO() {
    
    }
    
    public static VendedorDAO getInstance() {
        if (instance == null) {
            instance = new VendedorDAO();
        }
        return instance;
    }

    @Override
    public VendedorDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VendedorDTO> getAll(String proveedor) throws SQLException {
        listVendedor = new ArrayList<>();
        vendedor = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT vend_codigo AS codigo, vend_dni AS dni, vend_nombreApellidos AS nombres, vend_codPro AS codpro FROM vendedor WHERE prove_nombre = ?");
        ps.setString(1, proveedor);
        rs = ps.executeQuery();
        while (rs.next()) {
            vendedor = new VendedorDTO(
                    rs.getInt("codigo"),
                    rs.getString("dni"),
                    rs.getString("nombres"),
                    rs.getString("codpro")
            );
            listVendedor.add(vendedor);
        }
        rs.close();
        ps.close();
        
        return listVendedor;
    }

    @Override
    public ArrayList<String> getNamesByCombo(String proveedor) throws SQLException {
        namesCombo = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT vend_nombreApellidos AS nombres FROM vendedor WHERE prove_nombre = ?");
        ps.setString(1, proveedor);
        rs = ps.executeQuery();
        while (rs.next()) {
            namesCombo.add(rs.getString("nombres"));
        }
        rs.close();
        ps.close();
        
        return namesCombo;
    }

    @Override
    public int getByDniByNombresByCodigo(String dni, String nombres, String codigoEmp) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT vend_codigo AS codigo FROM vendedor WHERE vend_dni = ? AND vend_nombreApellidos = ? AND vend_codPro = ?");
        ps.setString(1, dni);
        ps.setString(2, nombres);
        ps.setString(3, codigoEmp);
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("codigo");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public boolean update(VendedorDTO vendedor) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE vendedor SET vend_dni = ?, vend_nombreApellidos = ?, vend_codPro = ? WHERE vend_codigo = ?");
        ps.setString(1, vendedor.getDni());
        ps.setString(2, vendedor.getNombreApellidos());
        ps.setString(3, vendedor.getCodPro());
        ps.setInt(4, vendedor.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(VendedorDTO vendedor) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO vendedor (vend_dni, vend_nombreApellidos, vend_codPro, prove_nombre) VALUES (?, ?, ?, ?)");
        ps.setString(1, vendedor.getDni());
        ps.setString(2, vendedor.getNombreApellidos());
        ps.setString(3, vendedor.getCodPro());
        ps.setString(4, vendedor.getProveedor().getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(VendedorDTO vendedor) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM vendedor WHERE vend_codigo = ?");
        ps.setInt(1, vendedor.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

}
