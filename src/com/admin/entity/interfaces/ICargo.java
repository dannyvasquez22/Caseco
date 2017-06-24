package com.admin.entity.interfaces;

import com.admin.entity.dto.CargoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICargo {
    
    public CargoDTO getById(String nombre) throws SQLException;
    public ArrayList<CargoDTO> getByAllByStatus(int modoEstado) throws SQLException;
    public ArrayList<String> getAllByCombo(int estado) throws SQLException;
    public boolean update(CargoDTO cargo, String nombreAnterior) throws SQLException;
    public boolean insert(CargoDTO cargo) throws SQLException;
    public boolean delete(CargoDTO cargo, int status) throws SQLException;
    public int countElemntChild(String nombre) throws SQLException;
    
}
