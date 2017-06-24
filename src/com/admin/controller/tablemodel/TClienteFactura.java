package com.admin.controller.tablemodel;

import com.admin.entity.dto.ClienteDTO;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** * @author DANNY VASQUEZ RAFAEL */

public class TClienteFactura  extends AbstractTableModel {
    private ArrayList<ClienteDTO> cliente = null;
    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    private final String []titulos = {"CODIGO", "RUC", "RAZON SOCIAL", "DIRECCION", "PUNTO LLEGADA", "E-MAIL", "ESTADO", "FECHA CREACION"};
    
    public TClienteFactura(ArrayList<ClienteDTO> arrayList) {
       cliente = arrayList;
       
    }
    
    @Override
    public int getRowCount() {
        return cliente.size();
    }

    @Override
    public int getColumnCount() {
       return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.cliente.get(rowIndex).getCodigo();
            case 1: return this.cliente.get(rowIndex).getRuc();
            case 2: return this.cliente.get(rowIndex).getRazonSocial();
            case 3: return this.cliente.get(rowIndex).getDireccion();                       
            case 4: return this.cliente.get(rowIndex).getPuntoLlegada();
            case 5: return this.cliente.get(rowIndex).getEmail();
            case 6: return this.cliente.get(rowIndex).getEstado();
            case 7: return this.cliente.get(rowIndex).getFechaCreacion();
            default: return this.cliente.get(rowIndex);
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
            case 0: cliente.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue))); break;
            case 1: cliente.get(rowIndex).setRuc(String.valueOf(aValue)); break;
            case 2: cliente.get(rowIndex).setRazonSocial(String.valueOf(aValue)); break;
            case 3: cliente.get(rowIndex).setDireccion(String.valueOf(aValue)); break;
            case 4: cliente.get(rowIndex).setPuntoLlegada(String.valueOf(aValue)); break;
            case 5: cliente.get(rowIndex).setEmail(String.valueOf(aValue)); break;            
            case 6: cliente.get(rowIndex).setEstado(String.valueOf(aValue)); break;
            case 7: cliente.get(rowIndex).setFechaCreacion(String.valueOf(aValue)); break;
        }
    }
}

