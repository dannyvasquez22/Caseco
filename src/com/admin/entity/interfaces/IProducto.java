package com.admin.entity.interfaces;

import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.pojo.ProductoAlmacenP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public interface IProducto {

    public ProductoDTO getById(int id) throws SQLException;
    public ProductoDTO getRepeat(String producto, String marca) throws SQLException;
    public ArrayList<ProductoDTO> getAllByParams(String []params) throws SQLException;
    public ArrayList<ProductoDTO> getCodeBarParams(String []params) throws SQLException;
    public boolean update(ProductoDTO producto) throws SQLException;
    public boolean insert(ProductoDTO producto) throws SQLException;
    public boolean delete(ProductoDTO producto, int status) throws SQLException;
    public int lastId() throws SQLException;
    public int stockLimit() throws SQLException;
    public ArrayList<ProductoAlmacenP> getByWarehouse(int codigoProducto, String nombreTienda) throws SQLException;
    public ArrayList<ProductoAlmacenP> getByStock(String []params) throws SQLException;
    
}
