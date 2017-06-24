package com.admin.controller.tablemodel;

import com.admin.entity.pojo.ProductoAlmacenP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TProductoAlmacenDynamic  extends AbstractTableModel {
    private ArrayList<ProductoAlmacenP> productos = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, Float.class, Float.class};
    private final String []titulos = {"CÓDIGO", "NOMBRE", "MARCA", "STOCK", "STOCK CRITICO"};
    
    public TProductoAlmacenDynamic(ArrayList<ProductoAlmacenP> arrayList) {
       productos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.productos.get(rowIndex).getCodigo();
            case 1: return this.productos.get(rowIndex).getRazonSocial();
            case 2: return this.productos.get(rowIndex).getAlmacenNombre();
            case 3: return this.productos.get(rowIndex).getStockActual();
            case 4: return this.productos.get(rowIndex).getStockCritico();
            default: return this.productos.get(rowIndex);
        }
    }
   
    @Override
    public Class getColumnClass(int columnIndex) {
        return tiposColumn[columnIndex];
    } 
    
    @Override
    public String getColumnName(int valorColumn) {
        return titulos[valorColumn];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, rowIndex);
        switch (columnIndex) {
            case 0: productos.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: productos.get(rowIndex).setRazonSocial(String.valueOf(aValue)); break;
            case 2: productos.get(rowIndex).setAlmacenNombre(String.valueOf(aValue)); break;
            case 3: productos.get(rowIndex).setStockActual(Float.parseFloat(String.valueOf(aValue))); break;
            case 4: productos.get(rowIndex).setStockCritico(Float.parseFloat(String.valueOf(aValue))); break;
        }
    }
}

