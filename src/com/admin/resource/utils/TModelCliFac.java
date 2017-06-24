package com.admin.resource.utils;

//package Utils;
//
//import Model.ClienteFactura;
//import java.util.ArrayList;
//import javax.swing.table.AbstractTableModel;
//
//public class TModelCliFac extends AbstractTableModel {
//    private final ArrayList<ClienteFactura> clientes;
//    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class};
//    private final String[] titulos = {"Codigo", "R.U.C", "Razon Social", "Direccion", "Punto Llegada", "Email"};
//    
//    public TModelCliFac(ArrayList<ClienteFactura> clies) {
//       clientes = clies;
//    }
//    
//    @Override
//    public int getRowCount() {
//        return clientes.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//       return 6;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 0: return this.clientes.get(rowIndex).getCodigo();
//            case 1: return this.clientes.get(rowIndex).getRuc();
//            case 2: return this.clientes.get(rowIndex).getRazonSocial();
//            case 3: return this.clientes.get(rowIndex).getDireccion();
//            case 4: return this.clientes.get(rowIndex).getPuntoLlegada();    
//            case 5: return this.clientes.get(rowIndex).getEmail();
//            default: return this.clientes.get(rowIndex);
//        }
//    }
//   
//    @Override
//    public Class getColumnClass(int columnIndex) {
//        return tiposColumn[columnIndex];
//    } 
//    
//    @Override
//    public String getColumnName(int valorColumn) {
//        return titulos[valorColumn];
//    }
//    
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return false;
//    }
//    
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        super.setValueAt(aValue, rowIndex, rowIndex);
//        switch (columnIndex) {
//            case 0: clientes.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue)));break;
//            case 1: clientes.get(rowIndex).setRuc(String.valueOf(aValue));break;
//            case 2: clientes.get(rowIndex).setRazonSocial(String.valueOf(aValue));break;
//            case 3: clientes.get(rowIndex).setDireccion(String.valueOf(aValue));break;
//            case 4: clientes.get(rowIndex).setPuntoLlegada(String.valueOf(aValue));break;
//            case 5: clientes.get(rowIndex).setEmail(String.valueOf(aValue));break;
//        }
//    }
//}