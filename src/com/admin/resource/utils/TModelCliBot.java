package com.admin.resource.utils;

//package Utils;
//
//import Model.ClienteBoleta;
//import java.util.ArrayList;
//import javax.swing.table.AbstractTableModel;
//
//public class TModelCliBot extends AbstractTableModel {
//    private final ArrayList<ClienteBoleta> clientes;
//    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
//    private final String[] titulos = {"Codigo", "D.N.I", "Nombres y Apellidos", "Direccion", "Punto de LLegada", "Email", "Fech Nac", "Sexo"};
//    
//    public TModelCliBot(ArrayList<ClienteBoleta> clies) {
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
//       return 8;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 0: return this.clientes.get(rowIndex).getCodigo();
//            case 1: return this.clientes.get(rowIndex).getDni();
//            case 2: return this.clientes.get(rowIndex).getNomsApes();
//            case 3: return this.clientes.get(rowIndex).getDireccion();
//            case 4: return this.clientes.get(rowIndex).getPuntoLlegada();    
//            case 5: return this.clientes.get(rowIndex).getEmail();
//            case 6: return this.clientes.get(rowIndex).getFechaNac();
//            case 7: return this.clientes.get(rowIndex).getSexo();
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
//            case 1: clientes.get(rowIndex).setDni(String.valueOf(aValue));break;
//            case 2: clientes.get(rowIndex).setNomsApes(String.valueOf(aValue));break;
//            case 3: clientes.get(rowIndex).setDireccion(String.valueOf(aValue));break;
//            case 4: clientes.get(rowIndex).setPuntoLlegada(String.valueOf(aValue));break;    
//            case 5: clientes.get(rowIndex).setEmail(String.valueOf(aValue));break;
//            case 6: clientes.get(rowIndex).setFechaNac(String.valueOf(aValue));break;
//            case 7: clientes.get(rowIndex).setSexo(String.valueOf(aValue));break;
//        }
//    }
//}