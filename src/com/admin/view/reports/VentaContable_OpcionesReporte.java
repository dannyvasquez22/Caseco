package com.admin.view.reports;

import com.admin.resource.utils.ExportExcelReport;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.log4j.Logger;

public class VentaContable_OpcionesReporte extends javax.swing.JDialog {
    private int mesCon = 0;
    private int codDetTien = 0;
    final static Logger logger = Logger.getLogger(VentaContable_OpcionesReporte.class);

    public VentaContable_OpcionesReporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Venta por Mes");
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        escogerAños();

        boxEstablecimiento.removeAllItems();//INICIALIZAMOS COMBOBOX DE ESTABLECIMIENTOS-----
//        try {
//            Statement st = Acceso.cn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT tienda_razonSocial FROM tienda ORDER BY tienda_codigo");
//            while (rs.next()) { boxEstablecimiento.addItem(rs.getString(1)); }
//            st.close();
//            rs.close();
//        } catch (SQLException ex) { 
//            Messages.messageError("Error: " + ex.toString());
//            logger.error(ex);
//        }
    }

    private void escogerAños() {
        int añoMenor = 0, añoMayor = 0;
//        try {
//            Statement st = Acceso.cn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT MIN(YEAR(boleta.bot_fecha)), MAX(YEAR(boleta.bot_fecha)) FROM boleta");
//            while (rs.next()) {
//                añoMenor = rs.getInt(1);
//                añoMayor = rs.getInt(2);
//            }
//            st.close();
//            rs.close();
//        } catch (SQLException ex) {
//            Messages.messageError("Error: " + ex.toString());
//            logger.error(ex);
//        }
//        if (añoMenor != añoMayor) {
//            while (añoMenor <= añoMayor) {
//                boxAño.addItem(añoMenor);
//                añoMenor++;
//            }
//        } else {
//            boxAño.addItem(añoMenor);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReporte = new javax.swing.JButton();
        panelTiempo = new javax.swing.JPanel();
        boxAño = new javax.swing.JComboBox();
        lblMes = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox();
        lblAnio = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblEstablecimiento = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        boxEstablecimiento = new javax.swing.JComboBox();
        boxAlmacenes = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnReporte.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnReporte.setText("Generar Reporte");
        btnReporte.setToolTipText("Botón para generar el reporte requerido.");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        panelTiempo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        boxAño.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------Escoger Año--------" }));

        lblMes.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblMes.setText("Mes :");

        boxMes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------Escoger Mes------", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
        boxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesActionPerformed(evt);
            }
        });

        lblAnio.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAnio.setText("Año :");

        javax.swing.GroupLayout panelTiempoLayout = new javax.swing.GroupLayout(panelTiempo);
        panelTiempo.setLayout(panelTiempoLayout);
        panelTiempoLayout.setHorizontalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxAño, 0, 179, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTiempoLayout.setVerticalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxAño)
                    .addComponent(lblAnio))
                .addContainerGap())
        );

        panelTiempoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxAño, boxMes});

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de reporte.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEstablecimiento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblEstablecimiento.setText("Establecimiento de Venta :");

        lblAlmacen.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAlmacen.setText("Almacén de Venta :");

        boxEstablecimiento.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        boxEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEstablecimientoActionPerformed(evt);
            }
        });

        boxAlmacenes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        boxAlmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAlmacenesActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstablecimiento)
                            .addComponent(lblAlmacen))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxEstablecimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxAlmacenes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelTiempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstablecimiento)
                    .addComponent(boxEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlmacen)
                    .addComponent(boxAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesActionPerformed
        String mes = boxMes.getSelectedItem().toString();
        if (!"--Escoger Mes--".equals(mes)) {
            if ("Enero".equals(mes)) {             mesCon = 1;            }
            if ("Febrero".equals(mes)) {           mesCon = 2;            }
            if ("Marzo".equals(mes)) {             mesCon = 3;            }
            if ("Abril".equals(mes)) {             mesCon = 4;            }
            if ("Mayo".equals(mes)) {              mesCon = 5;            }
            if ("Junio".equals(mes)) {             mesCon = 6;            }
            if ("Julio".equals(mes)) {             mesCon = 7;            }
            if ("Agosto".equals(mes)) {            mesCon = 8;            }
            if ("Setiembre".equals(mes)) {         mesCon = 9;            }
            if ("Octubre".equals(mes)) {           mesCon = 10;           }
            if ("Noviembre".equals(mes)) {         mesCon = 11;           }
            if ("Diciembre".equals(mes)) {         mesCon = 12;           }
        }
    }//GEN-LAST:event_boxMesActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        if (!"--Escoger Mes--".equals(boxMes.getSelectedItem().toString()) && !"--Escoger Año--".equals(boxAño.getSelectedItem().toString())) {
            String[] titulos = {"Nro", "Emisión", "Tipo Comp.", "Serie", "Nro", "Nro Doc", "Razón Social", "Base Imp.Op.Grav.", "IGV", "IMPORTE TOTAL", "ESTADO"};
            String consulta = "SELECT DATE_FORMAT(factura.fact_fecha, '%d/%m/%Y'), factura.fact_serie, factura.fact_numero, cliente.clie_ruc, "
                                + "cliente.clie_razonSocial, factura.fact_total, factura.fact_estado, factura.fact_igv FROM factura, cliente where "
                                + "factura.clie_codigo = cliente.clie_codigo AND MONTH(factura.fact_fecha) = '" + mesCon + "' "
                                + "AND YEAR(factura.fact_fecha) = '" + boxAño.getSelectedItem().toString() + "' AND "
                                + "factura.dettien_codigo = " + codDetTien + " ORDER BY factura.fact_fecha,factura.fact_numero";

            String consulta2 = "SELECT DATE_FORMAT(boleta.bot_fecha, '%d/%m/%Y'), boleta.bot_serie, boleta.bot_numero, cliente.clie_dni, "
                                + "cliente.clie_nombresApellidos, boleta.bot_total, boleta.bot_estado, boleta.bot_igv "
                                + "FROM boleta LEFT JOIN cliente ON boleta.clie_codigo = cliente.clie_codigo WHERE "
                                + "MONTH(boleta.bot_fecha) = '" + mesCon + "' AND YEAR(boleta.bot_fecha) = '" + boxAño.getSelectedItem().toString() + "' "
                                + "AND boleta.dettien_codigo = " + codDetTien + " ORDER BY boleta.bot_fecha,boleta.bot_numero";

            ExportExcelReport ex = new ExportExcelReport(titulos,
                                            "C:/Users/ALMACEN1/Desktop/Reportes/RGVENTAS" + boxAño.getSelectedItem().toString() + mesCon + ".xls",
                                            consulta, consulta2);
            ex.reportePorMesContable();
            ex.abrir();
        } else {
            Messages.messageAlert("Por favor, escoger correctamente la fecha");
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void boxAlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAlmacenesActionPerformed
        if (boxAlmacenes.getItemCount() > 0) { //BUSCAR EL CODIGO DE LA TIENDA-ALMACEN-----
//            try {
//                Statement st = Acceso.cn.createStatement();
//                ResultSet rs = st.executeQuery("SELECT detalle_tienda.dettien_codigo FROM (detalle_tienda INNER JOIN tienda ON "
//                    + "detalle_tienda.tienda_codigo=tienda.tienda_codigo) INNER JOIN almacen ON detalle_tienda.alm_codigo=almacen.alm_codigo WHERE "
//                    + "tienda.tienda_razonSocial = '" + boxEstablecimiento.getSelectedItem().toString() + "' AND "
//                    + "almacen.alm_nombre = '" + boxAlmacenes.getSelectedItem().toString() + "'");
//                while (rs.next()) { codDetTien = rs.getInt(1); }
//                st.close();
//                rs.close();
//            } catch (SQLException ex) { 
//                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
//                logger.error(ex);
//            }
        }
    }//GEN-LAST:event_boxAlmacenesActionPerformed

    private void boxEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstablecimientoActionPerformed
        int codEst = 0;//BUSCAR EL CODIGO DE LA TIENDA-----
//        try {
//            Statement st = Acceso.cn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT tienda_codigo FROM tienda WHERE "
//                + "tienda_razonSocial = '" + boxEstablecimiento.getSelectedItem().toString() + "'");
//            while (rs.next()) { codEst = rs.getInt(1); }
//            st.close();
//            rs.close();
//        } catch (SQLException ex) { 
//            Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
//            logger.error(ex);
//        }

        boxAlmacenes.removeAllItems();//INICIALIZAMOS COMBOBOX DE ALMACENES-----
//        try {
//            Statement st = Acceso.cn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT almacen.alm_nombre FROM detalle_tienda INNER JOIN almacen ON "
//                + "detalle_tienda.alm_codigo = almacen.alm_codigo WHERE tienda_codigo = " + codEst + " ORDER BY almacen.alm_codigo");
//            while (rs.next()) { boxAlmacenes.addItem(rs.getString(1)); }
//            st.close();
//            rs.close();
//        } catch (SQLException ex) { 
//            Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
//            logger.error(ex);
//        }
    }//GEN-LAST:event_boxEstablecimientoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VentaContable_OpcionesReporte dialog = new VentaContable_OpcionesReporte(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxAlmacenes;
    private javax.swing.JComboBox boxAño;
    private javax.swing.JComboBox boxEstablecimiento;
    private javax.swing.JComboBox boxMes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblEstablecimiento;
    private javax.swing.JLabel lblMes;
    private javax.swing.JPanel panelTiempo;
    // End of variables declaration//GEN-END:variables
}
