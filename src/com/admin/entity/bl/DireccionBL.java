package com.admin.entity.bl;

import com.admin.entity.dao.DireccionDAO;
import com.admin.entity.dto.DireccionDTO;
import java.sql.SQLException;

/** * @author DANNY VASQUEZ RAFAEL */

public class DireccionBL {
    private static DireccionBL instance = null;
    
    private DireccionBL() {
    
    }
    
    public static DireccionBL getInstance() {
        if (instance == null) {
            instance = new DireccionBL();
        }
        return instance;
    }
    
    public DireccionDTO listDirecciones(String tipo, String codigo) throws SQLException {
        return DireccionDAO.getInstance().getByCodigoByCargo(tipo, codigo);
    }
    
    public DireccionDTO getByTipo(String tipoReferencia, String codigoReferencia) throws SQLException {
        return DireccionDAO.getInstance().getByTipo(tipoReferencia, codigoReferencia);
    }
    
    public boolean update(DireccionDTO direccion) throws SQLException {
        return DireccionDAO.getInstance().updateDireccion(direccion);
    }
    
    public boolean insert(DireccionDTO direccion) throws SQLException {
        return DireccionDAO.getInstance().insertDireccion(direccion);
    }
}
