package com.admin.model.dao;

import com.admin.model.dto.TelefonoDTO;
import com.admin.model.interfaces.ITelefono;
import com.admin.model.pojo.TelefonoEmpleadoTratarP;
import com.admin.model.pojo.TelefonoVendedorP;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class TelefonoDAO implements ITelefono {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;  
    private CallableStatement call = null;
    private TelefonoDTO telefono = null;
    private TelefonoEmpleadoTratarP telefonoEmpleado = null;
    private TelefonoVendedorP telefonoVendedor = null;
    private ArrayList<TelefonoDTO> listTelefono = null;
    private ArrayList<TelefonoEmpleadoTratarP> listTelefonoEmpleado = null;
    private ArrayList<TelefonoVendedorP> listTelefonoVendedor = null;
    private static TelefonoDAO instance = null;
    private static int value = 0;
    
    private TelefonoDAO() {
        
    }
    
    public static TelefonoDAO getInstance() {
        if (instance == null) {
            instance = new TelefonoDAO();
        }
        return instance;
    }
    
    @Override
    public TelefonoDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TelefonoDTO> getByReference(String tipoReferencia, String codigoReferencia) throws SQLException {
        listTelefono = new ArrayList<>();
        telefono = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT tele_codigo, tele_telefonia, tele_tipo, tele_numero, tipo_referencia, codigo_referencia FROM telefono WHERE tipo_referencia = ? AND codigo_referencia = ?");
        ps.setString(1, tipoReferencia);
        ps.setString(2, codigoReferencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            telefono = new TelefonoDTO(
                            rs.getInt("tele_codigo"),
                            rs.getString("tele_telefonia"),
                            rs.getString("tele_tipo"),
                            rs.getString("tele_numero"),
                            rs.getString("tipo_referencia"),
                            rs.getString("codigo_referencia")
                        );
            listTelefono.add(telefono);
        }
        rs.close();
        ps.close();
       
        return listTelefono;
    }

    @Override
    public ArrayList<TelefonoDTO> getByAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTelefono(TelefonoDTO telefono) throws SQLException {
        value = 0;
        if (telefono.getCodigoReferencia() == null) {
            ps = dbInstance.getConnection().prepareStatement("UPDATE telefono SET tele_numero = ?, tele_tipo = ?, tele_telefonia = ? WHERE tele_codigo = ?");
        } else {
            ps = dbInstance.getConnection().prepareStatement("UPDATE telefono SET tele_numero = ?, tele_tipo = ?, tele_telefonia = ?, codigo_referencia = ? WHERE tele_codigo = ? AND tipo_referencia = 'EMPLEADO_TRATAR'");
        }
        ps.setString(1, telefono.getNumero());
        if (telefono.getTipoTelefonia() == null || telefono.getTipoTelefonia().equals("")) {
            ps.setNull(2, Types.VARCHAR);
        } else {
            ps.setString(2, telefono.getTipoTelefonia());
        }
        if (telefono.getTelefonia() == null || telefono.getTelefonia().equals("")) {
            ps.setNull(3, Types.VARCHAR);
        } else {
            ps.setString(3, telefono.getTelefonia());
        }
        ps.setInt(4, telefono.getCodigo());
        if (telefono.getCodigoReferencia() != null) {
            ps.setString(4, telefono.getCodigoReferencia());
            ps.setInt(5, telefono.getCodigo());
        }
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public boolean insertTelefono(TelefonoDTO telefono) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO telefono (tele_numero, tele_tipo, tele_telefonia, tipo_referencia, codigo_referencia) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, telefono.getNumero());
        if (telefono.getTipoTelefonia() == null || telefono.getTipoTelefonia().equals("")) {
            ps.setNull(2, Types.VARCHAR);
        } else {
            ps.setString(2, telefono.getTipoTelefonia());
        }
        if (telefono.getTelefonia() == null || telefono.getTelefonia().equals("")) {
            ps.setNull(3, Types.VARCHAR);
        } else {
            ps.setString(3, telefono.getTelefonia());
        }
        ps.setString(4, telefono.getTipoReferencia());
        ps.setString(5, telefono.getCodigoReferencia());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public boolean deleteTelefono(TelefonoDTO telefono) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("DELETE FROM telefono WHERE tele_codigo = ?");
        ps.setInt(1, telefono.getCodigo());
        value = ps.executeUpdate();
        ps.close();
        
        return (value > 0);
    }

    @Override
    public ArrayList<TelefonoEmpleadoTratarP> getByEmployeeTry(String tipoReferencia, String codigoReferencia) throws SQLException {
        listTelefonoEmpleado = new ArrayList<>();
        telefonoEmpleado = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT te.tele_codigo AS codigo, et.empltra_nomApe AS nombres, te.tele_telefonia AS telefonia, "
                + "te.tele_tipo AS tipoTelefonia, te.tele_numero AS numero, te.tipo_referencia AS tipoReferencia, te.codigo_referencia AS codigoReferencia "
                + "FROM telefono AS te, empleado_tratar AS et WHERE te.tipo_referencia = ? AND et.clie_codigo = ? AND te.codigo_referencia = et.empltra_codigo");
        ps.setString(1, tipoReferencia);
        ps.setString(2, codigoReferencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            telefonoEmpleado = new TelefonoEmpleadoTratarP(
                            rs.getInt("codigo"),
                            rs.getString("nombres"),
                            rs.getString("numero"),
                            rs.getString("tipoTelefonia"),
                            rs.getString("telefonia"),
                            rs.getString("tipoReferencia"),
                            rs.getString("codigoReferencia")
                        );
            listTelefonoEmpleado.add(telefonoEmpleado);
        }
        rs.close();
        ps.close();
       
        return listTelefonoEmpleado;
    }

    @Override
    public ArrayList<TelefonoVendedorP> getBySellerProvider(String tipoReferencia, String codigoReferencia) throws SQLException {
        listTelefonoVendedor = new ArrayList<>();
        telefonoEmpleado = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT te.tele_codigo AS codigo, ve.vend_nombreApellidos AS nombres, te.tele_telefonia AS telefonia, "
                + "te.tele_tipo AS tipoTelefonia, te.tele_numero AS numero, te.tipo_referencia AS tipoReferencia, te.codigo_referencia AS codigoReferencia "
                + "FROM telefono AS te, vendedor AS ve WHERE te.tipo_referencia = ? AND ve.prove_nombre = ? AND te.codigo_referencia = ve.vend_codigo");
        ps.setString(1, tipoReferencia);
        ps.setString(2, codigoReferencia);
        rs = ps.executeQuery();
        while(rs.next()) {
            telefonoVendedor = new TelefonoVendedorP(
                            rs.getInt("codigo"),
                            rs.getString("nombres"),
                            rs.getString("numero"),
                            rs.getString("tipoTelefonia"),
                            rs.getString("telefonia"),
                            rs.getString("tipoReferencia"),
                            rs.getString("codigoReferencia")
                        );
            listTelefonoVendedor.add(telefonoVendedor);
        }
        rs.close();
        ps.close();
       
        return listTelefonoVendedor;
    }

}
