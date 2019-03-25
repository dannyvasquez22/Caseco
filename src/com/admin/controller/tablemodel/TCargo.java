package com.admin.controller.tablemodel;

import com.admin.model.dto.CargoDTO;
import com.admin.resource.utils.Constantes;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TCargo extends AbstractTableModel {
    private ArrayList<CargoDTO> cargos = null;
    private final Class[] tiposColumn = {String.class, String.class, Float.class, Float.class, String.class, String.class};
    private final String []titulos = {"NOMBRE", "DESCRIPCIÓN", "SUELDO MÍN.", "SUELDO MÁX.", "FECHA CREACIÓN", "ESTADO"};
    
    public TCargo(ArrayList<CargoDTO> arrayList) {
       cargos = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return cargos.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.cargos.get(rowIndex).getNombre();
            case 1: return this.cargos.get(rowIndex).getDescripcion();
            case 2: return this.cargos.get(rowIndex).getSueldoMin();
            case 3: return this.cargos.get(rowIndex).getSueldoMax();
            case 4: return this.cargos.get(rowIndex).getFechaCreacion();
            case 5: return this.cargos.get(rowIndex).getEstado() == Constantes.I_NUM_UNO ? Constantes.S_ACTIVO : Constantes.S_INACTIVO;
            default: return this.cargos.get(rowIndex);
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
            case 0: cargos.get(rowIndex).setNombre(String.valueOf(aValue)); break;
            case 1: cargos.get(rowIndex).setDescripcion(String.valueOf(aValue)); break;           
            case 2: cargos.get(rowIndex).setSueldoMin(Float.parseFloat(String.valueOf(aValue))); break;
            case 3: cargos.get(rowIndex).setSueldoMax(Float.parseFloat(String.valueOf(aValue))); break; 
            case 4: cargos.get(rowIndex).setFechaCreacion(String.valueOf(aValue)); break;
            case 5: cargos.get(rowIndex).setEstado(Integer.parseInt(String.valueOf(aValue))); break;
        }
    }
}

