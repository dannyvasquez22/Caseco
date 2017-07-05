package com.admin.controller.tablemodel;

import com.admin.model.pojo.LicenciaP;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TConductor  extends AbstractTableModel {
    private ArrayList<LicenciaP> conductor = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CODIGO", "NÚMERO", "CLASE", "CATEGORÍA", "FECHA EXPEDICIÓN", "FECHA REVALIDACIÓN", "DESCRIPCIÓN", "NOMBRES"};
    
    public TConductor(ArrayList<LicenciaP> arrayList) {
       conductor = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return conductor.size();
    }

    @Override
    public int getColumnCount() {
       return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.conductor.get(rowIndex).getCodigo();
            case 1: return this.conductor.get(rowIndex).getNumero();
            case 2: return this.conductor.get(rowIndex).getClase();
            case 3: return this.conductor.get(rowIndex).getCategoria();                       
            case 4: return this.conductor.get(rowIndex).getFechaExpedicion();
            case 5: return this.conductor.get(rowIndex).getFechaRevalidacion();
            case 6: return this.conductor.get(rowIndex).getDescripcion();
            case 7: return this.conductor.get(rowIndex).getNombresApellidos();
            default: return this.conductor.get(rowIndex);
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
            case 0: conductor.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: conductor.get(rowIndex).setNumero(String.valueOf(aValue)); break;
            case 2: conductor.get(rowIndex).setClase(String.valueOf(aValue)); break;
            case 3: conductor.get(rowIndex).setCategoria(String.valueOf(aValue)); break;
            case 4: conductor.get(rowIndex).setFechaExpedicion(String.valueOf(aValue)); break;
            case 5: conductor.get(rowIndex).setFechaRevalidacion(String.valueOf(aValue)); break;            
            case 6: conductor.get(rowIndex).setDescripcion(String.valueOf(aValue)); break;
            case 7: conductor.get(rowIndex).setNombresApellidos(String.valueOf(aValue)); break;
        }
    }
}

