package com.admin.view.reports;

import com.admin.resource.utils.Global;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class VentaXFecha_OpcionesReporte extends javax.swing.JDialog {
//    Statement SELECTBoleta = Acceso.cn.createStatement(), SELECTProducto = Acceso.cn.createStatement();
    ResultSet producto, boleta;
    int correcto = 0, tipo;
    public static int codigoDP;
//    String buscar, tipoBuscar, periodo, fechaDesde, fechaHasta, 
//            fecha = Acceso.sdf.format(Acceso.cal.getTime()), 
//            fechasdf2 = Acceso.sdf2.format(Acceso.cal.getTime()), 
//            fechaBusca1="", fechaBusca2 = "";    
    boolean bandera = true;

    public VentaXFecha_OpcionesReporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Venta por Fecha");
//        chooserFechaDesde.setDateFormat(Acceso.sdf);
//        chooserFechaHasta.setDateFormat(Acceso.sdf);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
//        txtFechaHasta.setText(fecha);
//        fechaBusca2 = fechasdf2;
//        Date fech = Acceso.sdf.parse(fecha);
//        Acceso.cal.setTime(fech);
//        Acceso.cal.add(Calendar.DATE, -1);
//        fech = Acceso.cal.getTime();
//        txtFechaHasta.setText(fecha);
//        String fech2 = Acceso.sdf.format(fech);
//        String fech3 = Acceso.sdf2.format(fech);
//        txtFechaDesde.setText(fech2);
//        fechaBusca1 = fech3;
        DesactivarFechas();
        DesactivarAño();
        escogerAños();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new Folder.DJCTextFieldWithoutPop();
        lblPeriodo = new javax.swing.JLabel();
        boxPeriodo = new javax.swing.JComboBox();
        btnReporte = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new Folder.DJCTextFieldWithoutPop();
        boxAño = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblDesde = new javax.swing.JLabel();
        txtFechaDesde = new Folder.DJCTextFieldWithoutPop();
        chooserFechaDesde = new datechooser.beans.DateChooserCombo();
        checkHasta = new javax.swing.JCheckBox();
        txtFechaHasta = new Folder.DJCTextFieldWithoutPop();
        chooserFechaHasta = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblPeriodo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPeriodo.setText("Período:");

        boxPeriodo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Escoger Periodo---", "Del Año", "Personalizado" }));
        boxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPeriodoActionPerformed(evt);
            }
        });

        btnReporte.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnReporte.setText("Generar Reporte");
        btnReporte.setToolTipText("Botón para generar el reporte requerido.");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("Nombre: ");

        lblMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMarca.setText("Marca:");

        txtMarca.setEditable(false);
        txtMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        boxAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAñoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de reporte.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("REPORTE POR FECHA");

        lblDesde.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDesde.setText("Desde: ");

        txtFechaDesde.setEditable(false);
        txtFechaDesde.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaDesde.setPlaceholder("dd/mm/aaaa");

        chooserFechaDesde.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaDesde.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaDesdeOnCommit(evt);
            }
        });

        checkHasta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        checkHasta.setText("Hasta");
        checkHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHastaActionPerformed(evt);
            }
        });

        txtFechaHasta.setEditable(false);
        txtFechaHasta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaHasta.setPlaceholder("dd/mm/aaaa");

        chooserFechaHasta.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        try {
            chooserFechaHasta.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2015, 0, 26),
                new java.util.GregorianCalendar(2015, 0, 26))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    chooserFechaHasta.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            chooserFechaHastaOnCommit(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblMarca)
                    .addGap(18, 18, 18)
                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblPeriodo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(boxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(boxAño, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblDesde)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chooserFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(checkHasta)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chooserFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblTitulo)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnReporte)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(lblTitulo)
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnBuscar)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblMarca)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chooserFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxAño)
                            .addComponent(lblDesde)
                            .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPeriodo)
                            .addComponent(checkHasta)
                            .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(22, 22, 22))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(chooserFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(12, 12, 12))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ActivarAño() {
        boxAño.setEnabled(true);
    }

    private void DesactivarAño() {
        boxAño.setEnabled(false);
    }

    public void ActivarFechas() {
        chooserFechaDesde.setEnabled(true);
        chooserFechaHasta.setEnabled(true);
    }

    private void DesactivarFechas() {
        chooserFechaDesde.setEnabled(false);
        chooserFechaHasta.setEnabled(false);
        checkHasta.setEnabled(false);
        checkHasta.setSelected(false);
    }

    private void boxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPeriodoActionPerformed
//        if (boxPeriodo.getSelectedItem() == "---Escoger Periodo---") {
//            DesactivarFechas();
//            DesactivarAño();
//        } else {
//            if (boxPeriodo.getSelectedItem() == "Del Año") {
//                ActivarAño();
//                DesactivarFechas();
//                tipo = 1;
//            } else {
//                DesactivarAño();
//                ActivarFechas();
//                fechaBusca2 = fechasdf2;
//                tipo = 2;
//            }
//        }
    }//GEN-LAST:event_boxPeriodoActionPerformed

    private void escogerAños() {
//        int añoMenor = 0, añoMayor = 0;
//        String sql1 = "SELECT MIN(YEAR(boleta.bot_fecha)), MAX(YEAR(boleta.bot_fecha)) FROM boleta";
//        try {
//            Statement st = Acceso.cn.createStatement();
//            ResultSet rs = st.executeQuery(sql1);
//            while (rs.next()) {
//                añoMenor = rs.getInt(1);
//                añoMayor = rs.getInt(2);
//            }
//            st.close();
//            rs.close();
//        } catch (SQLException ex) {}
//        if (añoMenor != añoMayor) {
//            while (añoMenor <= añoMayor) {
//                boxAño.addItem(añoMenor);
//                añoMenor++;
//            }
//        } else {
//            boxAño.addItem(añoMenor);
//        }
    }

    private void chooserFechaHastaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaHastaOnCommit
//        txtFechaHasta.setText(chooserFechaHasta.getText());
//        String fechaAux1 = txtFechaHasta.getText();
//        try {
//            Date fecha3 = Acceso.sdf.parse(fechaAux1);
//            fechaBusca2 = Acceso.sdf2.format(fecha3);
//        } catch (ParseException ex) {}
    }//GEN-LAST:event_chooserFechaHastaOnCommit

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
//        if ("Personalizado".equals(boxPeriodo.getSelectedItem().toString())) {
//            if (checkHasta.isSelected()) {
//                try {
//                    Date fechita = Acceso.sdf2.parse(fechaBusca1);
//                    Date fechon = Acceso.sdf2.parse(fechaBusca2);
//                    Acceso.cal.add(Calendar.DATE,2);
//                    //System.out.println(fechon + "\t" + Acceso.cal.getTime());
//                    if (fechon.before(Acceso.cal.getTime())) {
//                        bandera = true;
//                        if (fechita.before(fechon)) {
//                            bandera = true;
//                        } else{
//                            bandera = false;
//                            Mensajes.mensajeError("Error en las fechas seleccionadas.");
//                        }
//                    } else{
//                        bandera = false;
//                        Mensajes.mensajeError("Error en las fechas seleccionadas.");
//                    }
//                } catch (ParseException ex) {}
//            } else {
//                bandera = true;
//            }
//        } else {
//            if ("---Escoger Periodo---".equals(boxPeriodo.getSelectedItem().toString())) {
//                bandera = false;
//                Mensajes.mensajeInformacion("Escoger Período.");
//            } else {
//                bandera = true;
//            }
//        }
//        if (bandera == true) {
//           if (tipo == 1) {
//                System.out.println(codigoDP);
//                System.out.println(fechaBusca1);
//                System.out.println(fechaBusca2);
//                String[] titulos = {"Mes", "Unidad Medida", "Cantidad", "Sub-Total"};
//                String consulta = "SELECT MONTH(boleta.bot_fecha) AS Mes, detalle_undmedida.undmed_nombre AS Unidad,"
//                        + " SUM(detalle_boleta.detbot_cantidad * unidad_medida.undmed_valorReferencia) AS Cantidad,"
//                        + " SUM(detalle_boleta.detbot_cantidad * detalle_boleta.detbot_precioUnt) AS SubTotal FROM"
//                        + " detalle_boleta, boleta,detalle_tienda,tienda,detalle_undmedida,unidad_medida WHERE detalle_boleta.prod_codigo = '" + codigoDP + "' AND"
//                        + " boleta.bot_estado = 1 AND tienda.tienda_codigo = '" + Productos_Reporte.tienda + "' AND detalle_undmedida.detundmed_estPrincipal = 1 AND"
//                        + " detalle_boleta.prod_codigo = detalle_undmedida.prod_codigo AND detalle_boleta.detbot_undMedida = unidad_medida.undmed_nombre AND"
//                        + " detalle_boleta.bot_codigo = boleta.bot_codigo AND boleta.dettien_codigo = detalle_tienda.dettien_codigo AND"
//                        + " detalle_tienda.tienda_codigo = tienda.tienda_codigo and boleta.bot_fecha BETWEEN '" + fechaBusca1 + "' AND '" + fechaBusca2 + "' ORDER BY Mes ASC";
//                String consulta2 = "SELECT MONTH(factura.fact_fecha) AS Mes, detalle_undmedida.undmed_nombre AS Unidad,"
//                        + " SUM(detalle_factura.detfact_cantidad * unidad_medida.undmed_valorReferencia) AS Cantidad,"
//                        + " SUM(detalle_factura.detfact_cantidad * detalle_factura.detfact_precioUnt) AS SubTotal FROM"
//                        + " detalle_factura,factura, detalle_tienda, tienda, detalle_undmedida, unidad_medida WHERE detalle_factura.prod_codigo = '" + codigoDP + "' AND"
//                        + " factura.fact_estado = 1 AND tienda.tienda_codigo = '" + Productos_Reporte.tienda + "' AND detalle_undmedida.detundmed_estPrincipal = 1 AND"
//                        + " detalle_factura.prod_codigo = detalle_undmedida.prod_codigo AND detalle_factura.detfact_undMedida = unidad_medida.undmed_nombre AND"
//                        + " detalle_factura.fact_codigo = factura.fact_codigo AND factura.dettien_codigo = detalle_tienda.dettien_codigo AND"
//                        + " detalle_tienda.tienda_codigo = tienda.tienda_codigo AND factura.fact_fecha BETWEEN '" + fechaBusca1 + "' AND '" + fechaBusca2 + "' ORDER BY Mes ASC";
//                String consulta3 = "SELECT MONTH(ticket.tick_fecha) AS Mes, detalle_undmedida.undmed_nombre AS Unidad,"
//                        + " SUM(detalle_ticket.detick_cantidad * unidad_medida.undmed_valorReferencia) AS Cantidad,"
//                        + " SUM(detalle_ticket.detick_cantidad * detalle_ticket.detick_precioUnt) AS SubTotal FROM"
//                        + " detalle_ticket, ticket, detalle_tienda, tienda, detalle_undmedida, unidad_medida WHERE detalle_ticket.prod_codigo = '" + codigoDP + "' AND"
//                        + " ticket.tick_estado = 1 AND tienda.tienda_codigo = '" + Productos_Reporte.tienda + "' AND detalle_undmedida.detundmed_estPrincipal = 1 AND"
//                        + " detalle_ticket.prod_codigo = detalle_undmedida.prod_codigo AND detalle_ticket.detick_undMedida = unidad_medida.undmed_nombre AND"
//                        + " detalle_ticket.tick_codigo = ticket.tick_codigo AND ticket.dettien_codigo = detalle_tienda.dettien_codigo AND"
//                        + " detalle_tienda.tienda_codigo = tienda.tienda_codigo AND ticket.tick_fecha BETWEEN '" + fechaBusca1 + "' AND '" + fechaBusca2 + "' ORDER BY Mes ASC";
//                ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Venta Año.xls", consulta, consulta2, consulta3);
//                ex.reportePorFecha(Productos_Reporte.nombreTienda);
//                ex.abrir();      //ticket.tick detalle_ticket.detick
//           }
//           if (tipo == 2) {
//                String[] titulos = {"Serie", "Numero", "Hora", "Total"};
//                String consulta = "SELECT boleta.bot_serie, boleta.bot_numero, boleta.bot_hora, boleta.bot_total FROM boleta boleta WHERE bot_estado = 1 AND "
//                        + "bot_fecha = '"+fechaBusca1+"'";
//                String consulta2 = "SELECT factura.fact_serie, factura.fact_numero, factura.fact_hora, factura.fact_total FROM factura factura WHERE fact_estado = 1 AND "
//                        + "fact_fecha = '"+fechaBusca1+"'";
//                String consulta3 = "SELECT ticket.tick_serie, ticket.tick_numero, ticket.tick_hora, ticket.tick_total FROM ticket ticket WHERE ticket.tick_estado = 1 AND "
//                        + "ticket.tick_fecha = '"+fechaBusca1+"'";
//                ExportarExcelReporte ex = new ExportarExcelReporte(titulos,"C:/Users/ALMACEN1/Desktop/Reportes/Venta Dia X.xls", consulta, consulta2, consulta3);
//                ex.reporteVenta();
//                ex.abrir();
//           }
//           if (tipo == 3) {
//                String[] titulos = {"Mes", "Unidad Medida", "Cantidad", "Sub-Total"};
//                String consulta = "SELECT MONTH(boleta.bot_fecha) AS Mes,detalle_undmedida.undmed_nombre AS Unidad,"
//                        + " SUM(detalle_boleta.detbot_cantidad * unidad_medida.undmed_valorReferencia) AS Cantidad,"
//                        + " SUM(detalle_boleta.detbot_cantidad * detalle_boleta.detbot_precioUnt) AS SubTotal FROM"
//                        + " detalle_boleta, boleta,detalle_tienda, tienda,detalle_undmedida, unidad_medida WHERE detalle_boleta.prod_codigo = '" + codigoDP + "' AND"
//                        + " boleta.bot_estado = 1 AND tienda.tienda_codigo = '" + Productos_Reporte.tienda + "' AND detalle_undmedida.detundmed_estPrincipal = 1 AND"
//                        + " detalle_boleta.prod_codigo = detalle_undmedida.prod_codigo AND detalle_boleta.detbot_undMedida = unidad_medida.undmed_nombre AND"
//                        + " detalle_boleta.bot_codigo = boleta.bot_codigo AND boleta.dettien_codigo = detalle_tienda.dettien_codigo AND"
//                        + " detalle_tienda.tienda_codigo = tienda.tienda_codigo AND boleta.bot_fecha BETWEEN '" + fechaBusca1 + "' AND '" + fechaBusca2 + "' ORDER BY Mes ASC";
//                String consulta2 = "SELECT MONTH(factura.fact_fecha) AS Mes, detalle_undmedida.undmed_nombre AS Unidad,"
//                        + " SUM(detalle_factura.detfact_cantidad * unidad_medida.undmed_valorReferencia) AS Cantidad,"
//                        + " SUM(detalle_factura.detfact_cantidad * detalle_factura.detfact_precioUnt) AS SubTotal FROM"
//                        + " detalle_factura, factura, detalle_tienda, tienda, detalle_undmedida, unidad_medida WHERE detalle_factura.prod_codigo = '" + codigoDP + "' AND"
//                        + " factura.fact_estado = 1 AND tienda.tienda_codigo = '" + Productos_Reporte.tienda + "' AND detalle_undmedida.detundmed_estPrincipal = 1 AND"
//                        + " detalle_factura.prod_codigo = detalle_undmedida.prod_codigo AND detalle_factura.detfact_undMedida = unidad_medida.undmed_nombre AND"
//                        + " detalle_factura.fact_codigo = factura.fact_codigo AND factura.dettien_codigo = detalle_tienda.dettien_codigo AND"
//                        + " detalle_tienda.tienda_codigo = tienda.tienda_codigo AND factura.fact_fecha BETWEEN '" + fechaBusca1 + "' AND '" + fechaBusca2 + "' ORDER BY Mes ASC";
//                String consulta3 = "SELECT MONTH(ticket.tick_fecha) AS Mes, detalle_undmedida.undmed_nombre AS Unidad,"
//                        + " SUM(detalle_ticket.detick_cantidad * unidad_medida.undmed_valorReferencia) AS Cantidad,"
//                        + " SUM(detalle_ticket.detick_cantidad * detalle_ticket.detick_precioUnt) AS SubTotal FROM"
//                        + " detalle_ticket, ticket, detalle_tienda, tienda, detalle_undmedida, unidad_medida WHERE detalle_ticket.prod_codigo = '" + codigoDP + "' AND"
//                        + " ticket.tick_estado = 1 AND tienda.tienda_codigo = '" + Productos_Reporte.tienda + "' AND detalle_undmedida.detundmed_estPrincipal = 1 AND"
//                        + " detalle_ticket.prod_codigo = detalle_undmedida.prod_codigo AND detalle_ticket.detick_undMedida = unidad_medida.undmed_nombre AND"
//                        + " detalle_ticket.tick_codigo = ticket.tick_codigo AND ticket.dettien_codigo = detalle_tienda.dettien_codigo AND"
//                        + " detalle_tienda.tienda_codigo = tienda.tienda_codigo AND ticket.tick_fecha BETWEEN '" + fechaBusca1 + "' AND '" + fechaBusca2 + "' ORDER BY Mes ASC";
//                ExportarExcelReporte ex = new ExportarExcelReporte(titulos,"C:/Users/ALMACEN1/Desktop/Reportes/Venta Año P.xls", consulta, consulta2, consulta3);
//                ex.reportePorFecha(Productos_Reporte.nombreTienda);
//                ex.abrir();
//           }
//        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//        new Productos_Reporte(this, true).setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void boxAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAñoActionPerformed
//        String año = boxAño.getSelectedItem().toString();
//        fechaBusca1 = año + "-01-01";
//        fechaBusca2 = año + "-12-31";
    }//GEN-LAST:event_boxAñoActionPerformed

    private void chooserFechaDesdeOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaDesdeOnCommit
//        txtFechaDesde.setText(chooserFechaDesde.getText());
//        String fechaAux = txtFechaDesde.getText();
//        try {
//            Date fecha2 = Acceso.sdf.parse(fechaAux);
//            fechaBusca1 = Acceso.sdf2.format(fecha2);
//        } catch (ParseException ex) {}
    }//GEN-LAST:event_chooserFechaDesdeOnCommit

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void checkHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHastaActionPerformed
        if (checkHasta.isSelected() == true) {
            chooserFechaHasta.setEnabled(true);
            tipo = 3;
        } else {
            chooserFechaHasta.setEnabled(false);
            tipo = 2;
        }
    }//GEN-LAST:event_checkHastaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentaXFecha_OpcionesReporte dialog = new VentaXFecha_OpcionesReporte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxAño;
    private javax.swing.JComboBox boxPeriodo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JCheckBox checkHasta;
    private datechooser.beans.DateChooserCombo chooserFechaDesde;
    public static datechooser.beans.DateChooserCombo chooserFechaHasta;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTitulo;
    private Folder.DJCTextFieldWithoutPop txtFechaDesde;
    private Folder.DJCTextFieldWithoutPop txtFechaHasta;
    public static Folder.DJCTextFieldWithoutPop txtMarca;
    public static Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
