package com.admin.model.interfaces;

import com.admin.model.dto.DireccionDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDireccion {

    public DireccionDTO getById(int id) throws SQLException;
    public DireccionDTO getByTipo(String tipoReferencia, String codigoReferencia) throws SQLException;
    public DireccionDTO getByCodigoByCargo(String tipoReferencia, String codigoReferencia) throws SQLException;
    public ArrayList<DireccionDTO> getByAll() throws SQLException;
    public boolean updateDireccion(DireccionDTO direccion) throws SQLException;
    public boolean insertDireccion(DireccionDTO direccion) throws SQLException;
    public boolean deleteDireccion(DireccionDTO direccion) throws SQLException;
    
}
