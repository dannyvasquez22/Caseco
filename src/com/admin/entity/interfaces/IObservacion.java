package com.admin.entity.interfaces;

import com.admin.entity.dto.ObservacionDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IObservacion {

    public ObservacionDTO getById(int id) throws SQLException;
    public ArrayList<ObservacionDTO> getByReference(String tipoReferencia, String codigoReferencia) throws SQLException;
    public ArrayList<ObservacionDTO> getByAll() throws SQLException;
    public boolean updateObservacion(ObservacionDTO observacion) throws SQLException;
    public boolean deleteObservacion(ObservacionDTO observacion) throws SQLException;
    public boolean insertObservacion(ObservacionDTO observacion) throws SQLException;
    
}
