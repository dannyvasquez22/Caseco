package com.admin.controller.tablemodel;

import com.admin.model.dto.VehiculoDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TVehiculo  extends AbstractTableModel {
    private ArrayList<VehiculoDTO> vehiculos = null;
    private final Class[] tiposColumn = {String.class, String.class, String.class, Float.class, Float.class, String.class};
    private final String []titulos = {"PLACA", "CERTIFICADO INSCRIPCIÓN", "MARCA", "KILOMETRAJE", "GALONAJE", "ESTADO"};
    
    public TVehiculo(ArrayList<VehiculoDTO> arrayList) {
       vehiculos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return vehiculos.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.vehiculos.get(rowIndex).getNumeroPlaca();
            case 1: return this.vehiculos.get(rowIndex).getNumeroCertificacion();
            case 2: return this.vehiculos.get(rowIndex).getMarca();
            case 3: return this.vehiculos.get(rowIndex).getKilometraje();
            case 4: return this.vehiculos.get(rowIndex).getGalonaje();
            case 5: return this.vehiculos.get(rowIndex).getEstado();
            default: return this.vehiculos.get(rowIndex);
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
            case 0: vehiculos.get(rowIndex).setNumeroPlaca(String.valueOf(aValue)); break;
            case 1: vehiculos.get(rowIndex).setNumeroCertificacion(String.valueOf(aValue)); break;           
            case 2: vehiculos.get(rowIndex).setMarca(String.valueOf(aValue)); break;
            case 3: vehiculos.get(rowIndex).setKilometraje(Float.parseFloat(String.valueOf(aValue))); break; 
            case 4: vehiculos.get(rowIndex).setGalonaje(Float.parseFloat(String.valueOf(aValue))); break;
            case 5: vehiculos.get(rowIndex).setEstado(String.valueOf(aValue)); break;
        }
    }
}

