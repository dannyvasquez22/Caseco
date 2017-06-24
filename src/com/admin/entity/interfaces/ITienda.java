package com.admin.entity.interfaces;

import com.admin.entity.dto.TiendaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ITienda {

    public TiendaDTO getById(int id) throws SQLException;
    public TiendaDTO getByRazon(String razonSocial) throws SQLException;
    public ArrayList<TiendaDTO> getAll() throws SQLException;
    public ArrayList<String> getNamesByCombo() throws SQLException;
    public int getElementChild(int id, int modo) throws SQLException;
    public boolean updateTienda(TiendaDTO tienda) throws SQLException;
    public boolean insertTienda(TiendaDTO tienda) throws SQLException;
    public boolean deleteTienda(TiendaDTO tienda) throws SQLException;
    
}
