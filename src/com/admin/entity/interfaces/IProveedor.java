package com.admin.entity.interfaces;

import com.admin.entity.dto.ProveedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IProveedor {

    public ProveedorDTO getById(String nombre) throws SQLException;
    public ArrayList<ProveedorDTO> getAllByStatus(String []params) throws SQLException;
    public boolean update(ProveedorDTO proveedor, String nombreAnterior) throws SQLException;
    public boolean insert(ProveedorDTO proveedor) throws SQLException;
    public boolean delete(ProveedorDTO proveedor, int estado) throws SQLException;
    
}
