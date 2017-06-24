package com.admin.entity.bl;

import com.admin.entity.dao.ProductoDAO;
import com.admin.entity.dto.ProductoDTO;
import com.admin.entity.pojo.ProductoAlmacenP;
import java.sql.SQLException;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProductoBL {
    private static ProductoBL instance = null;
    
    private ProductoBL() {
    
    }
    
    public static ProductoBL getInstance() {
        if (instance == null) {
            instance = new ProductoBL();
        }
        return instance;
    }
    
    public ArrayList<ProductoDTO> listAllByParams(String []params) throws SQLException {
        return ProductoDAO.getInstance().getAllByParams(params);
    }
    
    public ArrayList<ProductoDTO> listCodeBar(String []params) throws SQLException {
        return ProductoDAO.getInstance().getCodeBarParams(params);
    }
    
    public ArrayList<ProductoAlmacenP> listByWarehouse(int codigoProducto, String tienda) throws SQLException {
        return ProductoDAO.getInstance().getByWarehouse(codigoProducto, tienda);
    }
    
    public ArrayList<ProductoAlmacenP> listByStock(String []params) throws SQLException {
        return ProductoDAO.getInstance().getByStock(params);
    }
    
    public boolean insert(ProductoDTO producto) throws SQLException {
        return ProductoDAO.getInstance().insert(producto);
    }
    
    public boolean update(ProductoDTO producto) throws SQLException {
        return ProductoDAO.getInstance().update(producto);
    }
    
    public boolean delete(ProductoDTO producto, int status) throws SQLException {
        return ProductoDAO.getInstance().delete(producto, status);
    }
    
    public ProductoDTO listRepeat(String nombreProducto, String marca) throws SQLException {
        return ProductoDAO.getInstance().getRepeat(nombreProducto, marca);
    }
    
    public int lastId() throws SQLException {
        return ProductoDAO.getInstance().lastId();
    }
    
    public int stockLimit() throws SQLException {
        return ProductoDAO.getInstance().stockLimit();
    }
}

