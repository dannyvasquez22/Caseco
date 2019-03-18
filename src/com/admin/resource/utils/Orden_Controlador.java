package com.admin.resource.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("UnusedAssignment")
public class Orden_Controlador {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void listArticulo(JTable tabla, String cad, String tienda) {
        List lista = null;
        lista = Orden_Consultas.listArticulos(cad, tienda);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
    
    public static void listArticuloE(JTable tabla, String cad, String tienda) {
        List lista = null;
        lista = Orden_Consultas.listArticulos(cad, tienda);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
        
    public static void listClienteN(JTable tabla, String cad) {
        Date fechaMY = null, fechaMY1 = null;
        String fechaNac = "", fechaCre = "";
        List lista = null;
        lista = Orden_Consultas.listClienteN(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);   
            if (String.valueOf(fila[3]).equals("0")) {
                fila[3] = "";
            }
            if (String.valueOf(fila[3]).equals("1")) {
                fila[3] = "F";
            }
            if (String.valueOf(fila[3]).equals("2")) {
                fila[3] = "M";
            }
            
            String fecha = String.valueOf(fila[4]);
            if (!fecha.equals("")) {
                try {
                    fechaMY = sdf2.parse(fecha);
                    fechaNac = sdf.format(fechaMY);
                } catch (ParseException ex) {}
                fila[4] = fechaNac;
            }
            
            String fechaC = String.valueOf(fila[8]);
            try {
                fechaMY1 = sdf2.parse(fechaC);
                fechaCre = sdf.format(fechaMY1);
            } catch (ParseException ex) {}
            fila[8] = fechaCre;
            tb.addRow(fila);
        }
    }
    
    public static void listClienteJ(JTable tabla, String cad) {
        Date fechaMY1 = null;
        String fechaCre = "";
        List lista = null;
        lista = Orden_Consultas.listClienteJ(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            String fechaC = String.valueOf(fila[6]);
            try {
                fechaMY1 = sdf2.parse(fechaC);
                fechaCre = sdf.format(fechaMY1);
            } catch (ParseException ex) {}
            fila[6] = fechaCre;
            
            tb.addRow(fila);
        }
    }
    
    public static void listClienteEN(JTable tabla, String cad) {
        Date fechaMY = null, fechaMY1 = null;
        String fechaNac = "", fechaCre = "";
        List lista = null;
        lista = Orden_Consultas.listClienteEN(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);      
            if (String.valueOf(fila[3]).equals("1")) {
                fila[3] = "F";
            }
            if (String.valueOf(fila[3]).equals("2")) {
                fila[3] = "M";
            }
            
            String fecha = String.valueOf(fila[4]);
            if (!fecha.equals("")) {
                try {
                    fechaMY = sdf2.parse(fecha);
                    fechaNac = sdf.format(fechaMY);
                } catch (ParseException ex) {}
                fila[4] = fechaNac;
            }
            
            String fechaC = String.valueOf(fila[8]);
            try {
                fechaMY1 = sdf2.parse(fechaC);
                fechaCre = sdf.format(fechaMY1);
            } catch (ParseException ex) {}
            fila[8] = fechaCre;
            tb.addRow(fila);
        }
    }
    
    public static void listClienteEJ(JTable tabla, String cad) {
        Date fechaMY1 = null;
        String fechaCre = "";
        List lista = null;
        lista = Orden_Consultas.listClienteEJ(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            String fechaC = String.valueOf(fila[6]);
            try {
                fechaMY1 = sdf2.parse(fechaC);
                fechaCre = sdf.format(fechaMY1);
            } catch (ParseException ex) {}
            fila[6] = fechaCre;
            
            tb.addRow(fila);
        }
    }
    
    public static void listProve(JTable tabla, String cad) {
        List lista = null;
        lista = Orden_Consultas.listProve(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
    
    public static void listEmpleado(JTable tabla, String cad, String carg) {
        Date fechaMY1 = null;
        String fechaCre = "";
        List lista = null;
        lista = Orden_Consultas.listEmpleado(cad,carg);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            if (String.valueOf(fila[3]).equals("1")) {
                fila[3] = "F";
            }
            if (String.valueOf(fila[3]).equals("2")) {
                fila[3] = "M";
            }
            
            String fechaC = String.valueOf(fila[6]);
            try {
                fechaMY1 = sdf2.parse(fechaC);
                fechaCre = sdf.format(fechaMY1);
            } catch (ParseException ex) {}
            fila[6] = fechaCre;
            
            tb.addRow(fila);
        }
    }   
    
    public static void listEProve(JTable tabla, String cad) {
        List lista = null;
        lista = Orden_Consultas.listEProve(cad);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            tb.addRow(fila);
        }
    }
    
    public static void listEEmpleado(JTable tabla, String cad, String carg) {
        Date fechaMY1 = null;
        String fechaCre = "";
        List lista = null;
        lista = Orden_Consultas.listEEmpleado(cad,carg);
        for (int i = 1; i < lista.size(); i++) {
            DefaultTableModel tb = (DefaultTableModel)tabla.getModel();
            Object[]fila = (Object[])lista.get(i);
            if (String.valueOf(fila[3]).equals("1")) {
                fila[3] = "F";
            }
            if (String.valueOf(fila[3]).equals("2")) {
                fila[3] = "M";
            }
            
            String fechaC = String.valueOf(fila[6]);
            try {
                fechaMY1 = sdf2.parse(fechaC);
                fechaCre = sdf.format(fechaMY1);
            } catch (ParseException ex) {}
            fila[6] = fechaCre;
            
            tb.addRow(fila);
        }
    }               
    
}
