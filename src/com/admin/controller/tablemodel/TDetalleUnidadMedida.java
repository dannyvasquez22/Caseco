package com.admin.controller.tablemodel;

import com.admin.entity.dto.DetalleUnidadMedidaDTO;
import com.admin.entity.dto.UnidadMedidaDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TDetalleUnidadMedida  extends AbstractTableModel {
    private ArrayList<DetalleUnidadMedidaDTO> detalles = null;
    private final Class[] tiposColumn = {Integer.class, String.class, Double.class, Double.class, Double.class, String.class};
    private final String []titulos = {"CÓDIGO", "UNIDAD DE MEDIDA", "PRECIO MENOR", "PRECIO MAYOR", "PRECIO FERRETERIA", "PRINCIPAL"};
    
    public TDetalleUnidadMedida(ArrayList<DetalleUnidadMedidaDTO> arrayList) {
       detalles = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return detalles.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.detalles.get(rowIndex).getCodigo();
            case 1: return this.detalles.get(rowIndex).getUnidadMedida().getNombre();
            case 2: return this.detalles.get(rowIndex).getPrecioMenor();
            case 3: return this.detalles.get(rowIndex).getPrecioMayor();
            case 4: return this.detalles.get(rowIndex).getPrecioEspecial();
            case 5: return this.detalles.get(rowIndex).getEstadoPrincipal();
            default: return this.detalles.get(rowIndex);
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
            case 0: detalles.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: detalles.get(rowIndex).setUnidadMedida(new UnidadMedidaDTO(String.valueOf(aValue))); break;
            case 2: detalles.get(rowIndex).setPrecioMenor(Double.parseDouble(String.valueOf(aValue))); break;
            case 3: detalles.get(rowIndex).setPrecioMayor(Double.parseDouble(String.valueOf(aValue))); break;
            case 4: detalles.get(rowIndex).setPrecioEspecial(Double.parseDouble(String.valueOf(aValue))); break;
            case 5: detalles.get(rowIndex).setEstadoPrincipal(String.valueOf(aValue)); break;
        }
    }
}

