package com.admin.entity.interfaces;

import com.admin.entity.dto.TelefonoDTO;
import com.admin.entity.pojo.TelefonoEmpleadoTratarP;
import com.admin.entity.pojo.TelefonoVendedorP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface ITelefono {

    public TelefonoDTO getById(int id) throws SQLException;
    public ArrayList<TelefonoDTO> getByReference(String tipoReferencia, String codigoReferencia) throws SQLException;
    public ArrayList<TelefonoDTO> getByAll() throws SQLException;
    public boolean updateTelefono(TelefonoDTO telefono) throws SQLException;
    public boolean insertTelefono(TelefonoDTO telefono) throws SQLException;
    public boolean deleteTelefono(TelefonoDTO telefono) throws SQLException;
    
    // metodo empleadopara listar telefonos con formato de los empleados a tratar de los clientes
    public ArrayList<TelefonoEmpleadoTratarP> getByEmployeeTry(String tipoReferencia, String codigoReferencia) throws SQLException;
    
    // metodo empleado para listar telefonos con formato de los vendedores de los proveedores
    public ArrayList<TelefonoVendedorP> getBySellerProvider(String tipoReferencia, String codigoReferencia) throws SQLException;
    
}
