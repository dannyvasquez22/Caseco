package com.admin.controller.tablemodel;

import com.admin.model.dto.ProveedorDTO;
import com.admin.model.dto.ProveedorProductoDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TProveedorProducto  extends AbstractTableModel {
    private ArrayList<ProveedorProductoDTO> proveedorProductos = null;
    private final Class[] tiposColumn = {Integer.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class};
    private final String []titulos = {"CÓDIGO", "PROVEEDOR", "PRECIO COMPRA", "FLETE", "RENTA", "PERCEPCIÓN", "CATALOGO"};
    
    public TProveedorProducto(ArrayList<ProveedorProductoDTO> arrayList) {
       proveedorProductos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return proveedorProductos.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.proveedorProductos.get(rowIndex).getCodigo();
            case 1: return this.proveedorProductos.get(rowIndex).getProveedor().getNombre();
            case 2: return this.proveedorProductos.get(rowIndex).getPrecioCompra();
            case 3: return this.proveedorProductos.get(rowIndex).getFlete();
            case 4: return this.proveedorProductos.get(rowIndex).getRenta();
            case 5: return this.proveedorProductos.get(rowIndex).getPercepcion();
            case 6: return this.proveedorProductos.get(rowIndex).getCodCatalago();
            default: return this.proveedorProductos.get(rowIndex);
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
            case 0: proveedorProductos.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: proveedorProductos.get(rowIndex).setProveedor(new ProveedorDTO(String.valueOf(aValue))); break;
            case 2: proveedorProductos.get(rowIndex).setPercepcion(Double.parseDouble(String.valueOf(aValue))); break;           
            case 3: proveedorProductos.get(rowIndex).setFlete(Double.parseDouble(String.valueOf(aValue))); break;
            case 4: proveedorProductos.get(rowIndex).setRenta(Double.parseDouble(String.valueOf(aValue))); break; 
            case 5: proveedorProductos.get(rowIndex).setPercepcion(Double.parseDouble(String.valueOf(aValue))); break;
            case 6: proveedorProductos.get(rowIndex).setCodCatalago(String.valueOf(aValue)); break;            
        }
    }
}

