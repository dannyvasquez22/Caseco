package com.admin.resource.utils;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/** * @author DANNY VASQUEZ RAFAEL */

public class ConfigTables {
    
    static TableColumn col = null;
    static DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
    static DefaultTableCellRenderer izquierda = new DefaultTableCellRenderer();
    static DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();

    //Alineamientos de texto
    public static void alineamientos() {
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        izquierda.setHorizontalAlignment(SwingConstants.LEFT);
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    
    //Cabeceras de tablas
    public static void headerTables(JTable table) {
        JTableHeader jtableHeader = table.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        table.setTableHeader(  jtableHeader );
    }
    
    public static void sizeUserAccess(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(290);        col.setMaxWidth(440);        col.setMinWidth(290);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(180);        col.setMaxWidth(250);       col.setMinWidth(180);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);        col.setMaxWidth(180);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);        col.setMaxWidth(180);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);        col.setMaxWidth(180);       col.setMinWidth(100);
       
        table.getColumnModel().getColumn(0).setCellRenderer(izquierda);
        table.getColumnModel().getColumn(1).setCellRenderer(izquierda);
        table.getColumnModel().getColumn(2).setCellRenderer(centro);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
    }
    
    public static void sizeConnectionUser(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(300);        col.setMaxWidth(435);        col.setMinWidth(300);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(170);       col.setMaxWidth(290);       col.setMinWidth(170);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(180);       col.setMaxWidth(290);       col.setMinWidth(180);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(125);       col.setMaxWidth(200);       col.setMinWidth(125);
        
        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(130);       col.setMaxWidth(200);       col.setMinWidth(130);
        
        table.getColumnModel().getColumn(3).setCellRenderer(new MyRenderActive());
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
    }
    
    public static void sizeListCrudUsuario(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(90);        col.setMaxWidth(150);        col.setMinWidth(90);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(390);      col.setMaxWidth(490);       col.setMinWidth(390);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(160);      col.setMaxWidth(260);       col.setMinWidth(160);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(170);      col.setMaxWidth(230);       col.setMinWidth(170);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(110);      col.setMaxWidth(200);       col.setMinWidth(110);
        
        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(110);      col.setMaxWidth(200);       col.setMinWidth(110);

        table.getColumnModel().getColumn(0).setCellRenderer(izquierda);
        table.getColumnModel().getColumn(4).setCellRenderer(new MyRenderActive());
        table.getColumnModel().getColumn(5).setCellRenderer(centro);
    }
    
    public static void sizeEmployeeUser(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(70);       col.setMaxWidth(80);       col.setMinWidth(70);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);       col.setMaxWidth(180);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(350);      col.setMaxWidth(490);      col.setMinWidth(350);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(160);      col.setMaxWidth(220);      col.setMinWidth(160);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(65);       col.setMaxWidth(65);       col.setMinWidth(65);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(280);      col.setMaxWidth(100);      col.setMinWidth(280);

        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(235);      col.setMaxWidth(399);      col.setMinWidth(235);

        col = table.getColumnModel().getColumn(7);
        col.setPreferredWidth(100);      col.setMaxWidth(395);      col.setMinWidth(100);

        col = table.getColumnModel().getColumn(8);
        col.setPreferredWidth(100);      col.setMaxWidth(80);       col.setMinWidth(100);

        table.getColumnModel().getColumn(0).setCellRenderer(centro);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(7).setCellRenderer(centro);
        table.getColumnModel().getColumn(8).setCellRenderer(new MyRenderActive());
    }
    
    public static void sizeEmployee(JTable table) {
        alineamientos();
         
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(100);       col.setMaxWidth(180);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(95);       col.setMaxWidth(100);      col.setMinWidth(95);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(350);      col.setMaxWidth(420);      col.setMinWidth(350);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(110);       col.setMaxWidth(180);      col.setMinWidth(110);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(90);      col.setMaxWidth(100);      col.setMinWidth(90);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(340);      col.setMaxWidth(390);      col.setMinWidth(340);

        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(240);      col.setMaxWidth(310);      col.setMinWidth(240);
        
        col = table.getColumnModel().getColumn(7);
        col.setPreferredWidth(100);       col.setMaxWidth(135);      col.setMinWidth(100);
        
        col = table.getColumnModel().getColumn(8);
        col.setPreferredWidth(120);      col.setMaxWidth(150);      col.setMinWidth(120);

        table.getColumnModel().getColumn(0).setCellRenderer(centro);
        table.getColumnModel().getColumn(1).setCellRenderer(centro);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(7).setCellRenderer(centro);
        table.getColumnModel().getColumn(8).setCellRenderer(new MyRenderActive());
    }    
    
    public static void sizeCellphone(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(300);       col.setMaxWidth(320);       col.setMinWidth(300);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(200);       col.setMaxWidth(250);       col.setMinWidth(200);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(180);       col.setMaxWidth(210);       col.setMinWidth(180);
        
        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
    }
    
    public static void sizeModelCellphone(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(300);       col.setMaxWidth(310);       col.setMinWidth(300);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(200);       col.setMaxWidth(250);       col.setMinWidth(200);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(190);       col.setMaxWidth(220);       col.setMinWidth(190);

        table.getColumnModel().getColumn(2).setCellRenderer(centro);
    }

    public static void sizeObservation(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(110);       col.setMaxWidth(205);       col.setMinWidth(110);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(580);       col.setMaxWidth(640);       col.setMinWidth(580);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        
        table.getColumnModel().getColumn(1).setCellRenderer(centro);
    }
    
    public static void sizeModelObservation(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(110);       col.setMaxWidth(205);       col.setMinWidth(110);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(580);       col.setMaxWidth(640);       col.setMinWidth(580);
        

        table.getColumnModel().getColumn(0).setCellRenderer(centro);
    }
    
    public static void sizeDriver(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);       col.setMaxWidth(0);       col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);      col.setMaxWidth(200);      col.setMinWidth(100);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);      col.setMaxWidth(200);      col.setMinWidth(100);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);      col.setMaxWidth(200);      col.setMinWidth(100);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(140);      col.setMaxWidth(214);      col.setMinWidth(140);
        
        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(165);      col.setMaxWidth(234);      col.setMinWidth(165);

        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(250);      col.setMaxWidth(380);      col.setMinWidth(250);

        col = table.getColumnModel().getColumn(7);
        col.setPreferredWidth(300);      col.setMaxWidth(350);      col.setMinWidth(300);

        table.getColumnModel().getColumn(2).setCellRenderer(centro);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(5).setCellRenderer(centro);
    }
    
    public static void sizeTypes(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(200);       col.setMaxWidth(255);       col.setMinWidth(200);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(225);       col.setMaxWidth(280);       col.setMinWidth(225);
        
        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);       col.setMaxWidth(200);       col.setMinWidth(100);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(110);       col.setMaxWidth(190);       col.setMinWidth(110);
        
        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(130);       col.setMaxWidth(210);       col.setMinWidth(130);
        
        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(130);       col.setMaxWidth(210);       col.setMinWidth(130);

        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(5).setCellRenderer(new MyRenderActive());
    }
    
    public static void sizeWarehouse(JTable table) {
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);        col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(300);      col.setMaxWidth(370);     col.setMinWidth(300);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(425);      col.setMaxWidth(485);     col.setMinWidth(425);
    }
    
    public static void sizeCategory(JTable table) {
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(230);      col.setMaxWidth(280);       col.setMinWidth(230);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(380);      col.setMaxWidth(425);       col.setMinWidth(380);
    }
    
    public static void sizeMark(JTable table) {
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(250);       col.setMaxWidth(280);       col.setMinWidth(250);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(355);       col.setMaxWidth(445);       col.setMinWidth(355);
    }
    
    public static void sizeUnitMeasure(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(230);       col.setMaxWidth(290);       col.setMinWidth(230);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(160);       col.setMaxWidth(230);       col.setMinWidth(160);
        
        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(333);       col.setMaxWidth(383);       col.setMinWidth(333);

        table.getColumnModel().getColumn(1).setCellRenderer(derecha);
    }
    
    public static void sizeStore(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);        col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);        col.setMaxWidth(100);        col.setMinWidth(100);
        
        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(335);        col.setMaxWidth(435);        col.setMinWidth(335);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(335);        col.setMaxWidth(435);        col.setMinWidth(335);
        
        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(335);        col.setMaxWidth(435);        col.setMinWidth(335);

        table.getColumnModel().getColumn(1).setCellRenderer(centro);
    }
    
    public static void sizeVehicle(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(160);       col.setMaxWidth(215);       col.setMinWidth(160);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(202);       col.setMaxWidth(262);       col.setMinWidth(202);
        
        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(340);       col.setMaxWidth(366);       col.setMinWidth(340);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);       col.setMaxWidth(180);       col.setMinWidth(100);
        
        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(90);        col.setMaxWidth(180);       col.setMinWidth(90);
        
        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(100);        col.setMaxWidth(180);       col.setMinWidth(100);

        table.getColumnModel().getColumn(0).setCellRenderer(centro);
        table.getColumnModel().getColumn(1).setCellRenderer(centro);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(5).setCellRenderer(new MyRenderActive());
    }
    
    public static void SizeStoreWarehouse(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);        col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(160);      col.setMaxWidth(260);     col.setMinWidth(160);
        
        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(160);      col.setMaxWidth(260);     col.setMinWidth(160);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(412);      col.setMaxWidth(478);     col.setMinWidth(412);

        table.getColumnModel().getColumn(1).setCellRenderer(centro);
        table.getColumnModel().getColumn(2).setCellRenderer(centro);
    }
    
    public static void sizeClientBoleta(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);          col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(85);         col.setMaxWidth(100);      col.setMinWidth(85);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(360);        col.setMaxWidth(410);      col.setMinWidth(360);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(75);         col.setMaxWidth(175);      col.setMinWidth(75);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(95);         col.setMaxWidth(185);      col.setMinWidth(95);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(440);        col.setMaxWidth(540);      col.setMinWidth(440);

        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(370);        col.setMaxWidth(470);      col.setMinWidth(370);

        col = table.getColumnModel().getColumn(7);
        col.setPreferredWidth(220);        col.setMaxWidth(310);      col.setMinWidth(220);

        col = table.getColumnModel().getColumn(8);
        col.setPreferredWidth(100);        col.setMaxWidth(200);      col.setMinWidth(100);
        
        col = table.getColumnModel().getColumn(9);
        col.setPreferredWidth(120);        col.setMaxWidth(200);      col.setMinWidth(120);

        table.getColumnModel().getColumn(1).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(8).setCellRenderer(new MyRenderActive());
        table.getColumnModel().getColumn(9).setCellRenderer(centro);
    }
    
    public static void sizeClientFactura(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(95);           col.setMaxWidth(100);      col.setMinWidth(95);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(360);          col.setMaxWidth(420);      col.setMinWidth(360);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(440);          col.setMaxWidth(540);      col.setMinWidth(440);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(370);          col.setMaxWidth(470);      col.setMinWidth(370);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(220);          col.setMaxWidth(300);      col.setMinWidth(220);

        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(100);          col.setMaxWidth(200);      col.setMinWidth(100);
        
        col = table.getColumnModel().getColumn(7);
        col.setPreferredWidth(120);          col.setMaxWidth(200);      col.setMinWidth(120);

        table.getColumnModel().getColumn(1).setCellRenderer(derecha);
        table.getColumnModel().getColumn(6).setCellRenderer(new MyRenderActive());
        table.getColumnModel().getColumn(7).setCellRenderer(centro);
    }
    
    public static void sizeAccount(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(130);      col.setMaxWidth(230);      col.setMinWidth(130);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(110);      col.setMaxWidth(220);      col.setMinWidth(110);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(240);      col.setMaxWidth(300);      col.setMinWidth(240);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(170);      col.setMaxWidth(300);      col.setMinWidth(170);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(170);      col.setMaxWidth(300);      col.setMinWidth(170);

        table.getColumnModel().getColumn(4).setCellRenderer(centro);
        table.getColumnModel().getColumn(5).setCellRenderer(centro);
    }
    
    public static void sizeModelAccount(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(130);      col.setMaxWidth(230);      col.setMinWidth(130);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(110);      col.setMaxWidth(220);      col.setMinWidth(110);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(240);      col.setMaxWidth(300);      col.setMinWidth(240);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(170);      col.setMaxWidth(300);      col.setMinWidth(170);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(170);      col.setMaxWidth(300);      col.setMinWidth(170);

        table.getColumnModel().getColumn(3).setCellRenderer(centro);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
    }
    
    public static void sizeEmployeeTry(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(140);      col.setMaxWidth(230);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(667);      col.setMaxWidth(930);      col.setMinWidth(667);

        table.getColumnModel().getColumn(1).setCellRenderer(centro);
    }
    
    public static void sizeModelEmployeeTry(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(140);      col.setMaxWidth(230);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(667);      col.setMaxWidth(930);      col.setMinWidth(667);

        table.getColumnModel().getColumn(0).setCellRenderer(centro);
    }
    
    public static void sizeCellphoneEmployeeTry(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(380);       col.setMaxWidth(435);       col.setMinWidth(380);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(140);       col.setMaxWidth(195);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(140);       col.setMaxWidth(195);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(130);       col.setMaxWidth(190);      col.setMinWidth(130);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
    }
    
    public static void sizeModelCellphoneEmployeeTry(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(380);       col.setMaxWidth(435);       col.setMinWidth(380);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(140);       col.setMaxWidth(195);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(140);       col.setMaxWidth(195);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(130);       col.setMaxWidth(190);      col.setMinWidth(130);
        
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
    }
    
    public static void sizeProvide(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(450);       col.setMaxWidth(500);       col.setMinWidth(450);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(95);        col.setMaxWidth(185);       col.setMinWidth(95);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(360);       col.setMaxWidth(560);       col.setMinWidth(360);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(210);       col.setMaxWidth(310);       col.setMinWidth(210);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(200);       col.setMaxWidth(300);       col.setMinWidth(200);
        
        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(100);       col.setMaxWidth(120);       col.setMinWidth(100);

        table.getColumnModel().getColumn(1).setCellRenderer(centro);
        table.getColumnModel().getColumn(5).setCellRenderer(new MyRenderActive());
    }
    
    public static void sizeTimeProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        table.getColumnModel().getColumn(1).setCellRenderer(centro);
        table.getColumnModel().getColumn(2).setCellRenderer(centro);
    }
    
    public static void sizeSellerProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(120);      col.setMaxWidth(190);       col.setMinWidth(120);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(410);      col.setMaxWidth(447);       col.setMinWidth(410);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(170);      col.setMaxWidth(230);       col.setMinWidth(170);

        table.getColumnModel().getColumn(1).setCellRenderer(centro);
        table.getColumnModel().getColumn(3).setCellRenderer(centro);
    }
    
    public static void sizeModelSellerProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(120);      col.setMaxWidth(190);       col.setMinWidth(120);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(410);      col.setMaxWidth(447);       col.setMinWidth(410);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(170);      col.setMaxWidth(230);       col.setMinWidth(170);

        table.getColumnModel().getColumn(0).setCellRenderer(centro);
        table.getColumnModel().getColumn(2).setCellRenderer(centro);
    }

    public static void sizeCellphoneSellerProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(333);        col.setMaxWidth(393);       col.setMinWidth(333);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(125);        col.setMaxWidth(195);       col.setMinWidth(125);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(135);        col.setMaxWidth(195);       col.setMinWidth(135);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(110);        col.setMaxWidth(190);       col.setMinWidth(110);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
    }
    
    public static void sizeModelCellphoneSellerProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(333);        col.setMaxWidth(393);       col.setMinWidth(333);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(125);        col.setMaxWidth(195);       col.setMinWidth(125);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(135);        col.setMaxWidth(195);       col.setMinWidth(135);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(110);        col.setMaxWidth(190);       col.setMinWidth(110);

        table.getColumnModel().getColumn(3).setCellRenderer(centro);
    }
    
    
    public static void sizeProduct(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(95);     col.setMaxWidth(100);      col.setMinWidth(95);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(545);    col.setMaxWidth(585);      col.setMinWidth(545);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(300);    col.setMaxWidth(390);      col.setMinWidth(300);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);    col.setMaxWidth(135);      col.setMinWidth(100);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(220);    col.setMaxWidth(280);      col.setMinWidth(220);
        
        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(100);    col.setMaxWidth(130);      col.setMinWidth(100);

        table.getColumnModel().getColumn(0).setCellRenderer(derecha);
        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(6).setCellRenderer(new MyRenderActive());
    }
    
    public static void sizeProductCodeBar(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(95);     col.setMaxWidth(100);      col.setMinWidth(95);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(545);    col.setMaxWidth(585);      col.setMinWidth(545);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(170);    col.setMaxWidth(190);      col.setMinWidth(170);
        
        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(300);    col.setMaxWidth(390);      col.setMinWidth(300);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

        col = table.getColumnModel().getColumn(5);
       col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(100);    col.setMaxWidth(130);      col.setMinWidth(100);

        table.getColumnModel().getColumn(0).setCellRenderer(derecha);
        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(6).setCellRenderer(new MyRenderActive());
    }
    
    public static void sizeUnitMeasureProduct(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(255);        col.setMaxWidth(390);      col.setMinWidth(255);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(115);        col.setMaxWidth(160);      col.setMinWidth(115);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(115);        col.setMaxWidth(160);      col.setMinWidth(115);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(140);        col.setMaxWidth(160);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(86);         col.setMaxWidth(90);       col.setMinWidth(86);

        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(derecha);
        table.getColumnModel().getColumn(5).setCellRenderer(centro);
    }
    
    public static void sizeModelUnitMeasureProduct(JTable table) {
        alineamientos();
                
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(255);        col.setMaxWidth(390);      col.setMinWidth(255);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(115);        col.setMaxWidth(160);      col.setMinWidth(115);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(115);        col.setMaxWidth(160);      col.setMinWidth(115);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(140);        col.setMaxWidth(160);      col.setMinWidth(140);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(86);         col.setMaxWidth(90);       col.setMinWidth(86);

        table.getColumnModel().getColumn(1).setCellRenderer(derecha);
        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(centro);
    }
    
    public static void sizeStoreWarehouseProduct(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(0);            col.setMaxWidth(0);        col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(260);       col.setMaxWidth(316);       col.setMinWidth(260);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(115);       col.setMaxWidth(115);       col.setMinWidth(115);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(115);       col.setMaxWidth(115);       col.setMinWidth(115);

        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(derecha);
    }
    
    public static void sizeProductStockDynamic(JTable table) {
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(110);        col.setMaxWidth(150);       col.setMinWidth(110);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(435);        col.setMaxWidth(485);       col.setMinWidth(435);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(270);        col.setMaxWidth(345);       col.setMinWidth(270);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(150);        col.setMaxWidth(205);       col.setMinWidth(150);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(150);        col.setMaxWidth(205);       col.setMinWidth(150);
        
        table.getColumnModel().getColumn(0).setCellRenderer( new MyRenderStock() );
        table.getColumnModel().getColumn(1).setCellRenderer( new MyRenderStock() );
        table.getColumnModel().getColumn(2).setCellRenderer( new MyRenderStock() );
        table.getColumnModel().getColumn(3).setCellRenderer( new MyRenderStock() );
        table.getColumnModel().getColumn(4).setCellRenderer( new MyRenderStock() );
    }
    
    public static void sizeTimeProduct(JTable table) {
        alineamientos();
        
        table.getColumnModel().getColumn(0).setCellRenderer(centro);
        table.getColumnModel().getColumn(1).setCellRenderer(centro);
    }
    
    public static void sizeProductProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);        col.setMaxWidth(0);         col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(395);       col.setMaxWidth(550);      col.setMinWidth(395);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);      col.setMaxWidth(150);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);      col.setMaxWidth(100);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);      col.setMaxWidth(100);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(100);      col.setMaxWidth(100);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(6);
        col.setPreferredWidth(220);      col.setMaxWidth(200);       col.setMinWidth(220);

        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(derecha);
        table.getColumnModel().getColumn(5).setCellRenderer(derecha);
    }
    
    public static void sizeModelProductProvider(JTable table) {
        alineamientos();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(395);       col.setMaxWidth(550);      col.setMinWidth(395);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);      col.setMaxWidth(150);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(100);      col.setMaxWidth(100);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(100);      col.setMaxWidth(100);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(100);      col.setMaxWidth(100);       col.setMinWidth(100);

        col = table.getColumnModel().getColumn(5);
        col.setPreferredWidth(220);      col.setMaxWidth(200);       col.setMinWidth(220);

        table.getColumnModel().getColumn(1).setCellRenderer(derecha);
        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(derecha);
    }
    
    public static void sizeStockProduct(JTable table) {
        alineamientos ();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(0);        col.setMaxWidth(0);         col.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(185);      col.setMaxWidth(250);       col.setMinWidth(185);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(145);      col.setMaxWidth(200);       col.setMinWidth(145);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(110);      col.setMaxWidth(150);       col.setMinWidth(110);

        col = table.getColumnModel().getColumn(4);
        col.setPreferredWidth(115);      col.setMaxWidth(150);       col.setMinWidth(115);

        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(derecha);
    }
    
    public static void sizeModelStockProduct(JTable table) {
        alineamientos ();
        
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(185);      col.setMaxWidth(250);       col.setMinWidth(185);

        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(145);      col.setMaxWidth(200);       col.setMinWidth(145);

        col = table.getColumnModel().getColumn(2);
        col.setPreferredWidth(110);      col.setMaxWidth(150);       col.setMinWidth(110);

        col = table.getColumnModel().getColumn(3);
        col.setPreferredWidth(115);      col.setMaxWidth(150);       col.setMinWidth(115);

        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
    }
}
