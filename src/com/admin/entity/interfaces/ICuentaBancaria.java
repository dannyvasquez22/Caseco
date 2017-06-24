package com.admin.entity.interfaces;

import com.admin.entity.dto.CuentaBancariaDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ICuentaBancaria {
    
    public CuentaBancariaDTO getById(int id) throws SQLException;
    public ArrayList<CuentaBancariaDTO> getAll(String tipoReferencia, String referencia) throws SQLException;
    public boolean update(CuentaBancariaDTO cuenta) throws SQLException;
    public boolean insert(CuentaBancariaDTO cuenta) throws SQLException;
    public boolean delete(CuentaBancariaDTO cuenta) throws SQLException;
    
}
