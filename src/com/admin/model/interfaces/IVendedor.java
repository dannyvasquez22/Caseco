package com.admin.model.interfaces;

import com.admin.model.dto.VendedorDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IVendedor {

    public VendedorDTO getById(int id) throws SQLException;
    public ArrayList<VendedorDTO> getAll(String proveedor) throws SQLException;
    public ArrayList<String> getNamesByCombo(String proveedor) throws SQLException;
    public int getByDniByNombresByCodigo(String dni, String nombres, String codigoEmp) throws SQLException;
    public boolean update(VendedorDTO vendedor) throws SQLException;
    public boolean insert(VendedorDTO vendedor) throws SQLException;
    public boolean delete(VendedorDTO vendedor) throws SQLException;

}
