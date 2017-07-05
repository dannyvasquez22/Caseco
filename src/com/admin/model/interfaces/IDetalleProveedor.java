package com.admin.model.interfaces;

import com.admin.model.dto.DetalleProveedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IDetalleProveedor {

    public DetalleProveedorDTO getById(int id) throws SQLException;
    public ArrayList<DetalleProveedorDTO> getAll() throws SQLException;
    public ArrayList<DetalleProveedorDTO> getByProveedor(String nombre) throws SQLException;
    public boolean update(DetalleProveedorDTO detalleProveedor) throws SQLException;
    public boolean insert(DetalleProveedorDTO detalleProveedor) throws SQLException;
    public boolean delete(DetalleProveedorDTO detalleProveedor) throws SQLException;
    
}
