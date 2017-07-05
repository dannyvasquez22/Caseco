package com.admin.model.bl;

import com.admin.model.dao.AlmacenDAO;
import com.admin.model.dto.AlmacenDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class AlmacenBL {
    private static AlmacenBL instance = null;
    
    private AlmacenBL() {
    
    }
    
    public static AlmacenBL getInstance() {
        if (instance == null) {
            instance = new AlmacenBL();
        }
        return instance;
    }
    
    public boolean insert(AlmacenDTO almacen) throws SQLException {
        return AlmacenDAO.getInstance().insertAlmacen(almacen);
    }
    
    public boolean update(AlmacenDTO almacen) throws SQLException {
        return AlmacenDAO.getInstance().updateAlmacen(almacen);
    }
    
    public boolean delete(AlmacenDTO almacen) throws SQLException {
        return AlmacenDAO.getInstance().deleteAlmacen(almacen);
    }
    
    public ArrayList<AlmacenDTO> getAll() throws SQLException {
        return AlmacenDAO.getInstance().getByAll();
    }
    
    public AlmacenDTO getById(int codigo) throws SQLException {
        return AlmacenDAO.getInstance().getById(codigo);
    }
    
    public AlmacenDTO getByName(String name) throws SQLException {
        return AlmacenDAO.getInstance().getByName(name);
    }
    
    public int count(int codigo) throws SQLException {
        return AlmacenDAO.getInstance().getElementChild(codigo);
    }
    
    public ArrayList<String> listNamesCombo() throws SQLException {
        return AlmacenDAO.getInstance().getNameByCombo();
    }
    
    public ArrayList<String> listNamesByStoreByCombo(String tiendarazonSocial)throws SQLException {
        return AlmacenDAO.getInstance().getNameByStoreByCombo(tiendarazonSocial);
    }
}
