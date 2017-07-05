package com.admin.model.dao;

import com.admin.model.dto.CategoriaDTO;
import com.admin.model.dto.MarcaDTO;
import com.admin.model.dto.ProductoDTO;
import com.admin.model.interfaces.IProducto;
import com.admin.model.pojo.ProductoAlmacenP;
import com.admin.resource.utils.Config;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/** * @author DANNY VASQUEZ RAFAEL */

public class ProductoDAO implements IProducto {
    private static final Config dbInstance = Config.getInstance();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private CallableStatement call = null;
    private ProductoDTO producto = null;
    private ArrayList<ProductoDTO> listProducto = null;
    private ProductoAlmacenP productoAlmacen = null;
    private ArrayList<ProductoAlmacenP> listProductoAlmacen = null;
    private int value = 0;  // variable que indica ejecucion satisfactoria de una consulta a la BD
    private static ProductoDAO instance = null;

    private ProductoDAO() {
    }

    public static ProductoDAO getInstance() {
        if (instance == null) {
            instance = new ProductoDAO();
        }
        return instance;
    }

    @Override
    public ProductoDTO getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> getAllByParams(String[] params) throws SQLException {
        listProducto = new ArrayList<>();
        producto = null;
        ps = dbInstance.getConnection().prepareStatement("{CALL sp_listarProductos(?, ?, ?, ?, ?, ?, ?, 0)}");
        if (params[0] == null) {
            ps.setNull(1, Types.VARCHAR);
        } else {
            ps.setString(1, params[0]);
        }
        if (params[1] == null) {
            ps.setNull(2, Types.VARCHAR);
        } else {
            ps.setString(2, params[1]);
        }
        if (params[2] == null) {
            ps.setNull(3, Types.VARCHAR);
        } else {
            ps.setString(3, params[2]);
        }
        if (params[3] == null) {
            ps.setNull(4, Types.VARCHAR);
        } else {
            ps.setString(4, params[3]);
        }
        if (params[4] == null) {
            ps.setNull(5, Types.VARCHAR);
        } else {
            ps.setString(5, params[4]);
        }
        if (params[5] == null) {
            ps.setNull(6, Types.VARCHAR);
        } else {
            ps.setString(6, params[5]);
        }
        if (params[6] == null) {
            ps.setNull(7, Types.INTEGER);
        } else {
            ps.setInt(7, Integer.parseInt(params[6]));
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            producto = new ProductoDTO(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("codigoBarra"),
                    new MarcaDTO(rs.getString("marca")),
                    rs.getFloat("peso"),
                    new CategoriaDTO(rs.getString("categoria")),
                    rs.getString("estado")
            );
            listProducto.add(producto);
        }
        rs.close();
        ps.close();
        
        return listProducto;
    }

    @Override
    public boolean update(ProductoDTO producto) throws SQLException {
        value = 0;
        if (producto.getCodBarra() == null){
            ps = dbInstance.getConnection().prepareStatement("UPDATE producto SET prod_nombre = ?, marca_nombre = ?, prod_peso = ?, cate_nombre = ? WHERE prod_codigo = ?");
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca().getNombre());
            ps.setFloat(3, producto.getPeso());
            ps.setString(4, producto.getCategoria().getNombre());
            ps.setInt(5, producto.getCodigo());
        } else {
            ps = dbInstance.getConnection().prepareStatement("UPDATE producto SET prod_codBarra = ? WHERE prod_codigo = ?");
            ps.setString(1, producto.getCodBarra());
            ps.setInt(2, producto.getCodigo());
        }
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean insert(ProductoDTO producto) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("INSERT INTO producto (prod_nombre, marca_nombre, prod_peso, cate_nombre) VALUES (?, ?, ?, ?)");
        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getMarca().getNombre());
        ps.setFloat(3, producto.getPeso());
        ps.setString(4, producto.getCategoria().getNombre());
        value = ps.executeUpdate();
        ps.close();
        
        return value > 0;
    }

    @Override
    public boolean delete(ProductoDTO producto, int status) throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("UPDATE producto SET prod_estado = ? WHERE prod_codigo = ?");
        ps.setInt(1, status);
        ps.setInt(2, producto.getCodigo());
        value = ps.executeUpdate();
        ps.close();
                
        return value > 0;
    }

    @Override
    public ArrayList<ProductoAlmacenP> getByWarehouse(int codigoProducto, String nombreTienda) throws SQLException {
        listProductoAlmacen = new ArrayList<>();
        productoAlmacen = null;
        String where = "";
        if (!nombreTienda.equals(""))   where = " AND ti.tienda_razonSocial = ?";
        ps = dbInstance.getConnection().prepareStatement("SELECT "
                + "da.detalm_codigo AS codigo, "
                + "ti.tienda_razonSocial AS razonSocial, "
                + "al.alm_nombre AS almacen, "
                + "da.detalm_stockActual AS stockActual, "
                + "da.detalm_stockCritico AS stockCritico "
                + "FROM detalle_almacen AS da "
                + "INNER JOIN detalle_tienda AS dt ON dt.dettien_codigo = da.dettien_codigo "
                + "INNER JOIN almacen AS al ON al.alm_codigo = dt.alm_codigo "
                + "INNER JOIN tienda AS ti ON dt.tienda_codigo = ti.tienda_codigo "
                + "WHERE da.detalm_estadoStock = 1 AND da.prod_codigo = ?" + where);
        ps.setInt(1, codigoProducto);
        if (!nombreTienda.equals(""))   ps.setString(2, nombreTienda);        
        rs = ps.executeQuery();
        while (rs.next()) {
            productoAlmacen = new ProductoAlmacenP(
                    rs.getInt("codigo"),
                    rs.getString("razonSocial"),
                    rs.getString("almacen"),
                    rs.getFloat("stockActual"),
                    rs.getFloat("stockCritico")
            );
            listProductoAlmacen.add(productoAlmacen);
        }
        rs.close();
        ps.close();
        
        return listProductoAlmacen;
    }

    @Override
    public ProductoDTO getRepeat(String nombreProducto, String marca) throws SQLException {
        producto = null;
        ps = dbInstance.getConnection().prepareStatement("SELECT prod_codigo AS codigo FROM producto WHERE prod_nombre = ? AND marca_nombre = ?");
        ps.setString(1, nombreProducto);
        ps.setString(2, marca);
        rs = ps.executeQuery();
        while (rs.next()) {
            producto = new ProductoDTO(rs.getInt("codigo"));
        }
        rs.close();
        ps.close();
        
        return producto;
    }

    @Override
    public int lastId() throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT LAST_INSERT_ID() AS id");
        rs = ps.executeQuery();
        while(rs.next()) {
            value = rs.getInt("id");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public ArrayList<ProductoDTO> getCodeBarParams(String[] params) throws SQLException {
        listProducto = new ArrayList<>();
        producto = null;
        ps = dbInstance.getConnection().prepareStatement("{CALL sp_listarProductos(?, ?, ?, ?, ?, ?, ?, 1)}");
        if (params[0] == null) {
            ps.setNull(1, Types.VARCHAR);
        } else {
            ps.setString(1, params[0]);
        }
        if (params[1] == null) {
            ps.setNull(2, Types.VARCHAR);
        } else {
            ps.setString(2, params[1]);
        }
        if (params[2] == null) {
            ps.setNull(3, Types.VARCHAR);
        } else {
            ps.setString(3, params[2]);
        }
        if (params[3] == null) {
            ps.setNull(4, Types.VARCHAR);
        } else {
            ps.setString(4, params[3]);
        }
        if (params[4] == null) {
            ps.setNull(5, Types.VARCHAR);
        } else {
            ps.setString(5, params[4]);
        }
        if (params[5] == null) {
            ps.setNull(6, Types.VARCHAR);
        } else {
            ps.setString(6, params[5]);
        }
        if (params[6] == null) {
            ps.setNull(7, Types.INTEGER);
        } else {
            ps.setInt(7, Integer.parseInt(params[6]));
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            producto = new ProductoDTO(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("codigoBarra"),
                    new MarcaDTO(rs.getString("marca")),
                    rs.getFloat("peso"),
                    new CategoriaDTO(rs.getString("categoria")),
                    rs.getString("estado")
            );
            listProducto.add(producto);
        }
        rs.close();
        ps.close();
        
        return listProducto;
    }

    @Override
    public int stockLimit() throws SQLException {
        value = 0;
        ps = dbInstance.getConnection().prepareStatement("SELECT COUNT(producto.prod_codigo) AS 'Cantidad' FROM producto INNER JOIN detalle_almacen ON "
                + "producto.prod_codigo = detalle_almacen.prod_codigo WHERE producto.prod_estado = 1 AND "
                + "(detalle_almacen.detalm_estadoStock = 0 OR ((detalle_almacen.detalm_stockActual/2) <= detalle_almacen.detalm_stockCritico) )");
        rs = ps.executeQuery();
        while (rs.next()) {
            value = rs.getInt("Cantidad");
        }
        rs.close();
        ps.close();
        
        return value;
    }

    @Override
    public ArrayList<ProductoAlmacenP> getByStock(String[] params) throws SQLException {
        listProductoAlmacen = new ArrayList<>();
        ps = dbInstance.getConnection().prepareStatement("{CALL sp_listarProductos(?, ?, ?, NULL, ?, ?, ?, 2)}");
        if (params[0] == null) {
            ps.setNull(1, Types.VARCHAR);
        } else {
            ps.setString(1, params[0]);
        }
        if (params[1] == null) {
            ps.setNull(2, Types.VARCHAR);
        } else {
            ps.setString(2, params[1]);
        }
        if (params[2] == null) {
            ps.setNull(3, Types.VARCHAR);
        } else {
            ps.setString(3, params[2]);
        }
        if (params[3] == null) {
            ps.setNull(4, Types.VARCHAR);
        } else {
            ps.setString(4, params[3]);
        }
        if (params[4] == null) {
            ps.setNull(5, Types.VARCHAR);
        } else {
            ps.setString(5, params[4]);
        }
        if (params[5] == null) {
            ps.setNull(6, Types.INTEGER);
        } else {
            ps.setInt(6, Integer.parseInt(params[5]));
        }
        rs = ps.executeQuery();
        while(rs.next()) {
            productoAlmacen = new ProductoAlmacenP(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("marca"),
                    rs.getFloat("stockActual"),
                    rs.getFloat("stockCritico")
            );
            listProductoAlmacen.add(productoAlmacen);
        }
        rs.close();
        ps.close();
        
        return listProductoAlmacen;
    }

}
