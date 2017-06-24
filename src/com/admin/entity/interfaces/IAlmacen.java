package com.admin.entity.interfaces;

import com.admin.entity.dto.AlmacenDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IAlmacen {
    
    public AlmacenDTO getById(int codigo) throws SQLException;
    public AlmacenDTO getByName(String nombre) throws SQLException;
    public ArrayList<AlmacenDTO> getByAll() throws SQLException;
    public int getElementChild(int codigo) throws SQLException;
    public ArrayList<String> getNameByCombo() throws SQLException;
    public ArrayList<String> getNameByStoreByCombo(String tiendaRazonSocial) throws SQLException;
    public boolean updateAlmacen(AlmacenDTO almacen) throws SQLException;
    public boolean insertAlmacen(AlmacenDTO almacen) throws SQLException;
    public boolean deleteAlmacen(AlmacenDTO almacen) throws SQLException;
    
}
