package com.admin.model.interfaces;

import com.admin.model.dto.LicenciaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ILicencia {

    public LicenciaDTO getById(int id) throws SQLException;
    public ArrayList<LicenciaDTO> getByAll() throws SQLException;
    public boolean updateLicencia(LicenciaDTO licencia, int modo) throws SQLException;
    public boolean insertLicencia(LicenciaDTO licencia) throws SQLException;
    public boolean deleteLicencia(LicenciaDTO licencia) throws SQLException;
    
}
