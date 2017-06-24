package com.admin.entity.dao;

import com.admin.entity.dto.CuentaBancariaDTO;
import com.admin.entity.interfaces.ICuentaBancaria;
import com.admin.resource.utils.Config;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class CuentaBancariaDAO implements ICuentaBancaria {
    private final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private ArrayList<CuentaBancariaDTO> listCuenta = null;
    private CuentaBancariaDTO cuenta = null;
    private static CuentaBancariaDAO instance = null;
    private int value = 0;
    
    private CuentaBancariaDAO() {
    
    }
    
    public static CuentaBancariaDAO getInstance() {
        if (instance == null) {
            instance = new CuentaBancariaDAO();
        }
        return instance;
    }

    @Override
    public CuentaBancariaDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CuentaBancariaDTO> getAll(String tipoReferencia, String referencia) throws SQLException {
        listCuenta = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("SELECT cueban_codigo AS codigo, cueban_numero AS numero, cueban_moneda AS moneda, cueban_entidadBancaria AS banco, cueban_codigoEmp AS codigoEmpleado, cueban_recaudo AS recaudo FROM cuenta_bancaria WHERE tipo_referencia = ? AND codigo_referencia = ?");
        ps.setString(1, tipoReferencia);
        ps.setString(2, referencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            cuenta = new CuentaBancariaDTO(
                    rs.getInt("codigo"),
                    rs.getString("numero"),
                    rs.getString("moneda"),
                    rs.getString("banco"),
                    rs.getString("codigoEmpleado"),
                    rs.getString("recaudo")
            );
            listCuenta.add(cuenta);
        }
        rs.close();
        ps.close();
        
        return listCuenta;
    }

    @Override
    public boolean update(CuentaBancariaDTO cuenta) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE cuenta_bancaria SET cueban_numero = ?, cueban_moneda = ?, cueban_entidadBancaria = ?, cueban_codigoEmp = ?, cueban_recaudo = ? WHERE cueban_codigo = ?");
        ps.setString(1, cuenta.getNumero());
        ps.setString(2, cuenta.getMoneda());
        ps.setString(3, cuenta.getEntidadBancaria());
        ps.setString(4, cuenta.getCodigoEmp());
        ps.setString(5, cuenta.getRecaudo());
        ps.setInt(6, cuenta.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(CuentaBancariaDTO cuenta) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO cuenta_bancaria (cueban_numero, cueban_moneda, cueban_entidadBancaria, cueban_codigoEmp, cueban_recaudo, tipo_referencia, codigo_referencia) VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, cuenta.getNumero());
        ps.setString(2, cuenta.getMoneda());
        ps.setString(3, cuenta.getEntidadBancaria());
        ps.setString(4, cuenta.getCodigoEmp());
        ps.setString(5, cuenta.getRecaudo());
        ps.setString(6, cuenta.getTipoReferencia());
        ps.setString(7, cuenta.getCodigoReferencia());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(CuentaBancariaDTO cuenta) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM cuenta_bancaria WHERE cueban_codigo = ?");
        ps.setInt(1, cuenta.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }
    
}
