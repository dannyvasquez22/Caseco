package com.admin.model.bl;

import com.admin.model.dao.TiendaDAO;
import com.admin.model.dto.TiendaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class TiendaBL {
    private static TiendaBL instance = null;
    
    private TiendaBL() {
    
    }
    
    public static TiendaBL getInstance() {
        if (instance == null) {
            instance = new TiendaBL();
        }
        return instance;
    }
    
    public boolean insert(TiendaDTO tienda) throws SQLException {
        return TiendaDAO.getInstance().insertTienda(tienda);
    }
    
    public boolean update(TiendaDTO tienda) throws SQLException {
        return TiendaDAO.getInstance().updateTienda(tienda);
    }
    
    public boolean delete(TiendaDTO tienda) throws SQLException {
        return TiendaDAO.getInstance().deleteTienda(tienda);
    }
    
    public ArrayList<TiendaDTO> getAll() throws SQLException {
        return TiendaDAO.getInstance().getAll();
    }
    
    public TiendaDTO getById(int codigo) throws SQLException {
        return TiendaDAO.getInstance().getById(codigo);
    }
    
    public int count(int id, int modo) throws SQLException {
        return TiendaDAO.getInstance().getElementChild(id, modo);
    }
    
    public ArrayList<String> listNamesByCombo() throws SQLException {
        return TiendaDAO.getInstance().getNamesByCombo();
    }
    
    public TiendaDTO getByRazon(String razonSocial) throws SQLException {
        return TiendaDAO.getInstance().getByRazon(razonSocial);
    }
}
