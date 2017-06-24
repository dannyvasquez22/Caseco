package com.admin.entity.bl;

import com.admin.entity.dao.CuentaBancariaDAO;
import com.admin.entity.dto.CuentaBancariaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class CuentaBancariaBL {
    private static CuentaBancariaBL instance = null;
    
    private CuentaBancariaBL() {
    
    }
    
    public static CuentaBancariaBL getInstance() {
        if (instance == null) {
            instance = new CuentaBancariaBL();
        }
        return instance;
    }
    
    public boolean insert(CuentaBancariaDTO cuenta) throws SQLException {
        return CuentaBancariaDAO.getInstance().insert(cuenta);
    }
    
    public boolean update(CuentaBancariaDTO cuenta) throws SQLException {
        return CuentaBancariaDAO.getInstance().update(cuenta);
    }
    
    public boolean delete(CuentaBancariaDTO cuenta) throws SQLException {
        return CuentaBancariaDAO.getInstance().delete(cuenta);
    }
    
    public ArrayList<CuentaBancariaDTO> listAll(String tipoReferencia, String codigoReferencia) throws SQLException {
        return CuentaBancariaDAO.getInstance().getAll(tipoReferencia, codigoReferencia);
    }
}
