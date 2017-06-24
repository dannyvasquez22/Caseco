package com.admin.resource.utils;

//package Utils;
//
//import Model.DatosTipoComp;
//import java.util.ArrayList;
//import javax.swing.table.AbstractTableModel;
//
//public class TModelTipComp extends AbstractTableModel {
//    private final ArrayList<DatosTipoComp> comprobante;
//    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class, 
//                                   String.class, String.class, String.class, String.class, String.class, String.class, 
//                                   Integer.class, Integer.class};
//    private final String[] titulos = {"Codigo", "Serie", "Numero", "Ide. Cliente", "Cliente", "Direccion", "Fecha Emision", "Hora", 
//                                        "Fecha Entrega", "Total", "Can.", "Ent.", "Vendedor", "Cajero"};
//    
//    public TModelTipComp(ArrayList<DatosTipoComp> comps) {
//       comprobante = comps;
//    }
//    
//    @Override
//    public int getRowCount() {
//        return comprobante.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//       return 14;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 0: return this.comprobante.get(rowIndex).getCodigo();
//            case 1: return this.comprobante.get(rowIndex).getSerie();
//            case 2: return this.comprobante.get(rowIndex).getNumero();
//            case 3: return this.comprobante.get(rowIndex).getIdeClie();
//            case 4: return this.comprobante.get(rowIndex).getNomClie();
//            case 5: return this.comprobante.get(rowIndex).getDireccion();    
//            case 6: return this.comprobante.get(rowIndex).getFechaEmi();
//            case 7: return this.comprobante.get(rowIndex).getHora();
//            case 8: return this.comprobante.get(rowIndex).getFechaEnt();
//            case 9: return this.comprobante.get(rowIndex).getTotal();
//            case 10: return this.comprobante.get(rowIndex).getEstCan();
//            case 11: return this.comprobante.get(rowIndex).getEstEnt();
//            case 12: return this.comprobante.get(rowIndex).getVendedor();
//            case 13: return this.comprobante.get(rowIndex).getCajero();
//            default: return this.comprobante.get(rowIndex);
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
//            case 0: comprobante.get(rowIndex).setCodigo(Integer.parseInt(String.valueOf(aValue)));break;
//            case 1: comprobante.get(rowIndex).setSerie(String.valueOf(aValue));break;
//            case 2: comprobante.get(rowIndex).setNumero(String.valueOf(aValue));break;
//            case 3: comprobante.get(rowIndex).setIdeClie(String.valueOf(aValue));break;
//            case 4: comprobante.get(rowIndex).setNomClie(String.valueOf(aValue));break; 
//            case 5: comprobante.get(rowIndex).setDireccion(String.valueOf(aValue));break; 
//            case 6: comprobante.get(rowIndex).setFechaEmi(String.valueOf(aValue));break;
//            case 7: comprobante.get(rowIndex).setHora(String.valueOf(aValue));break;
//            case 8: comprobante.get(rowIndex).setFechaEnt(String.valueOf(aValue));break;   
//            case 9: comprobante.get(rowIndex).setTotal(String.valueOf(aValue));break;
//            case 10: comprobante.get(rowIndex).setEstCan(String.valueOf(aValue));break;
//            case 11: comprobante.get(rowIndex).setEstEnt(String.valueOf(aValue));break;
//            case 12: comprobante.get(rowIndex).setVendedor(Integer.parseInt(String.valueOf(aValue)));break;
//            case 13: comprobante.get(rowIndex).setCajero(Integer.parseInt(String.valueOf(aValue)));break;
//        }
//    }
//}
