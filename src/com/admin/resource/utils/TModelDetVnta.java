package com.admin.resource.utils;

//package Utils;
//
//import Model.DetalleVenta;
//import java.util.ArrayList;
//import javax.swing.table.AbstractTableModel;
//
//public class TModelDetVnta extends AbstractTableModel {
//    private final ArrayList<DetalleVenta> products;
//    private final Class[] tiposColumn = {Integer.class, String.class, String.class, String.class, String.class, String.class,
//                                            String.class};
//    private final String[] titulos = {"Cod. Producto", "Und. Medida", "Descripcion del Producto", "Cantidad", "Cant. Entregada", 
//                                        "P. Unitario", "Importe"};
//    
//    public TModelDetVnta(ArrayList<DetalleVenta> prods) {
//       products = prods;
//    }
//    
//    public void addProducto(DetalleVenta prod) {
//        products.add(prod);
//        fireTableDataChanged();
//    }
//    
//    public void removerProducto(int rowIndex) {
//        products.remove(rowIndex);
//        fireTableDataChanged();
//    }
//        
//    @Override
//    public int getRowCount() {
//        return products.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//       return 7;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch (columnIndex) {
//            case 0: return this.products.get(rowIndex).getCodProd();
//            case 1: return this.products.get(rowIndex).getUndMed();
//            case 2: return this.products.get(rowIndex).getDesProd();
//            case 3: return this.products.get(rowIndex).getCantidad();
//            case 4: return this.products.get(rowIndex).getCantEnt();
//            case 5: return this.products.get(rowIndex).getpUnitario();
//            case 6: return this.products.get(rowIndex).getImporte();    
//            default: return this.products.get(rowIndex);
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
//        super.setValueAt(aValue, rowIndex, columnIndex);
//        switch (columnIndex) {
//            case 0: products.get(rowIndex).setCodProd(Integer.parseInt(String.valueOf(aValue)));break;    
//            case 1: products.get(rowIndex).setUndMed(String.valueOf(aValue));break;
//            case 2: products.get(rowIndex).setDesProd(String.valueOf(aValue));break;
//            case 3: products.get(rowIndex).setCantidad(String.valueOf(aValue));break; 
//            case 4: products.get(rowIndex).setCantEnt(String.valueOf(aValue));break;
//            case 5: products.get(rowIndex).setpUnitario(String.valueOf(aValue));break;
//            case 6: products.get(rowIndex).setImporte(String.valueOf(aValue));break;
//        }
//    }
//}
