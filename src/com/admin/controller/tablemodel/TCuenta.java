package com.admin.controller.tablemodel;

import com.admin.model.dto.CuentaBancariaDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TCuenta  extends AbstractTableModel {
    private ArrayList<CuentaBancariaDTO> cuentas = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CÓDIGO", "N° CUENTA", "MONEDA", "BANCO", "CÓD. EMPRESA", "RECAUDO"};
    
    public TCuenta(ArrayList<CuentaBancariaDTO> arrayList) {
       cuentas = arrayList;
    }
    
    @Override
    public int getRowCount() {
        return cuentas.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.cuentas.get(rowIndex).getCodigo();
            case 1: return this.cuentas.get(rowIndex).getNumero();
            case 2: return this.cuentas.get(rowIndex).getMoneda();
            case 3: return this.cuentas.get(rowIndex).getEntidadBancaria();
            case 4: return this.cuentas.get(rowIndex).getCodigoEmp();
            case 5: return this.cuentas.get(rowIndex).getRecaudo();
            default: return this.cuentas.get(rowIndex);
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
            case 0: cuentas.get(rowIndex).setCodigo(Integer.parseInt((String) aValue)); break;
            case 1: cuentas.get(rowIndex).setNumero(String.valueOf(aValue)); break;           
            case 2: cuentas.get(rowIndex).setMoneda(String.valueOf(aValue)); break;
            case 3: cuentas.get(rowIndex).setEntidadBancaria(String.valueOf(aValue)); break; 
            case 4: cuentas.get(rowIndex).setCodigoEmp(String.valueOf(aValue)); break;
            case 5: cuentas.get(rowIndex).setRecaudo(String.valueOf(aValue)); break;
        }
    }
}

