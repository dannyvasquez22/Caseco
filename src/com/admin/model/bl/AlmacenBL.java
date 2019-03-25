package com.admin.model.bl;

import com.admin.model.dao.AlmacenDAO;
import com.admin.model.dto.AlmacenDTO;
import com.admin.resource.utils.Constantes;
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
    
    public boolean create(AlmacenDTO almacen) throws SQLException {
        return AlmacenDAO.getInstance().create(almacen);
    }
    
    public boolean update(AlmacenDTO almacen) throws SQLException {
        return AlmacenDAO.getInstance().update(almacen);
    }
    
    public boolean delete(AlmacenDTO almacen) throws SQLException {
        return AlmacenDAO.getInstance().delete(almacen);
    }
    
    public ArrayList<AlmacenDTO> getAll() throws SQLException {
        return AlmacenDAO.getInstance().getAll(Constantes.I_NUM_DOS);
    }
    
    public AlmacenDTO getById(int codigo) throws SQLException {
        return AlmacenDAO.getInstance().findByPk(codigo);
//        return (AlmacenDTO) AlmacenDAO.getInstance().getAll().stream().filter((alm) -> alm.getCodigo() == codigo);
    }
    
    public AlmacenDTO getByName(String name) throws SQLException {
        return AlmacenDAO.getInstance().findByName(name);
    }
    
    public int count(int codigo) throws SQLException {
        return AlmacenDAO.getInstance().getElementChild(codigo);
    }
    
    public ArrayList<String> listNamesCombo() throws SQLException {
        return AlmacenDAO.getInstance().getNameByCombo();
    }
    
    public ArrayList<String> listNamesByStoreCombo(String tiendarazonSocial)throws SQLException {
        return AlmacenDAO.getInstance().getNamesByStoreCombo(tiendarazonSocial);
    }
}
