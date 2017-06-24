package com.admin.entity.bl;

import com.admin.entity.dao.ObservacionDAO;
import com.admin.entity.dto.ObservacionDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ObservacionBL {
    private static ObservacionBL instance = null;
    
    private ObservacionBL() {
    
    }
    
    public static ObservacionBL getInstance() {
        if (instance == null) {
            instance = new ObservacionBL();
        }
        return instance;
    }
    
    public ArrayList<ObservacionDTO> listReference(String tipo, String codigo) throws SQLException {
        return ObservacionDAO.getInstance().getByReference(tipo, codigo);
    }
    
    public boolean insert(ObservacionDTO observacion) throws SQLException {
        return ObservacionDAO.getInstance().insertObservacion(observacion);
    }
    
    public boolean update(ObservacionDTO observacion) throws SQLException {
        return ObservacionDAO.getInstance().updateObservacion(observacion);
    }
    
    public boolean delete(ObservacionDTO observacion) throws SQLException {
        return ObservacionDAO.getInstance().deleteObservacion(observacion);
    }
}
