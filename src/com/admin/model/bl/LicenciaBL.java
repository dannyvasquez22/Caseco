package com.admin.model.bl;

import com.admin.model.dao.LicenciaDAO;
import com.admin.model.dto.LicenciaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class LicenciaBL {
    private static LicenciaBL instance = null;
    
    private LicenciaBL() {
    
    }
    
    public static LicenciaBL getInstance() {
        if (instance == null) {
            instance = new LicenciaBL();
        }
        return instance;
    }
    
    public ArrayList<LicenciaDTO> listDriver() throws SQLException {
        return LicenciaDAO.getInstance().getByAll();
    }
    
    public boolean insert(LicenciaDTO licencia) throws SQLException {
        return LicenciaDAO.getInstance().insertLicencia(licencia);
    }
    
    public boolean update(LicenciaDTO licencia, int modo) throws SQLException {
        return LicenciaDAO.getInstance().updateLicencia(licencia, modo);
    }
    
    public boolean delete(LicenciaDTO licencia) throws SQLException {
        return LicenciaDAO.getInstance().deleteLicencia(licencia);
    }
    
}
