package com.admin.entity.bl;

import com.admin.entity.dao.TelefonoDAO;
import com.admin.entity.dto.TelefonoDTO;
import com.admin.entity.pojo.TelefonoEmpleadoTratarP;
import com.admin.entity.pojo.TelefonoVendedorP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class TelefonoBL {
    private static TelefonoBL instance = null;
    
    private TelefonoBL() {
    
    }
    
    public static TelefonoBL getInstance() {
        if (instance == null) {
            instance = new TelefonoBL();
        }
        return instance;
    }
    
    public ArrayList<TelefonoDTO> listReference(String tipo, String codigo) throws SQLException {
        return TelefonoDAO.getInstance().getByReference(tipo, codigo);
    }
    
    public boolean insert(TelefonoDTO telefono) throws SQLException {
        return TelefonoDAO.getInstance().insertTelefono(telefono);
    }
    
    public boolean update(TelefonoDTO telefono) throws SQLException {
        return TelefonoDAO.getInstance().updateTelefono(telefono);
    }
    
    public boolean delete(TelefonoDTO telefono) throws SQLException {
        return TelefonoDAO.getInstance().deleteTelefono(telefono);
    }
    
    public ArrayList<TelefonoEmpleadoTratarP> listEmployeeTry(String tipo, String codigo) throws SQLException {
        return TelefonoDAO.getInstance().getByEmployeeTry(tipo, codigo);
    }
    
    public ArrayList<TelefonoVendedorP> listSellerProvider(String tipo, String codigo) throws SQLException {
        return TelefonoDAO.getInstance().getBySellerProvider(tipo, codigo);
    }
}
