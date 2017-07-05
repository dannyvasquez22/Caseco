package com.admin.controller.tablemodel;

import com.admin.model.dto.CategoriaDTO;
import com.admin.model.dto.MarcaDTO;
import com.admin.model.dto.ProductoDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TProducto  extends AbstractTableModel {
    private ArrayList<ProductoDTO> productos = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, Float.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "NOMBRE", "CÓDIGO DE BARRA", "MARCA", "PESO", "CATEGORIA", "ESTADO"};
    
    public TProducto(ArrayList<ProductoDTO> arrayList) {
       productos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
       return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.productos.get(rowIndex).getCodigo();
            case 1: return this.productos.get(rowIndex).getNombre();
            case 2: return this.productos.get(rowIndex).getCodBarra();
            case 3: return this.productos.get(rowIndex).getMarca().getNombre();
            case 4: return this.productos.get(rowIndex).getPeso();
            case 5: return this.productos.get(rowIndex).getCategoria().getNombre();
            case 6: return this.productos.get(rowIndex).getEstado();
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
            case 0: productos.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: productos.get(rowIndex).setNombre(String.valueOf(aValue)); break;
            case 2: productos.get(rowIndex).setCodBarra(String.valueOf(aValue)); break;
            case 3: productos.get(rowIndex).setMarca(new MarcaDTO(String.valueOf(aValue))); break;
            case 4: productos.get(rowIndex).setPeso(Float.parseFloat(String.valueOf(aValue))); break; 
            case 5: productos.get(rowIndex).setCategoria(new CategoriaDTO(String.valueOf(aValue))); break;
            case 6: productos.get(rowIndex).setEstado(String.valueOf(aValue)); break;
        }
    }
}

