package com.admin.view.reports;

import com.admin.resource.utils.Global;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.ImageIcon;

public class VentaXMes_OpcionesReporte extends javax.swing.JDialog {
//    Statement selectBoleta = Acceso.cn.createStatement(), selectProducto = Acceso.cn.createStatement();
    ResultSet producto, boleta, tipo;
    int correcto = 0, mesCon = 0;
//    String buscar, tipoBuscar, periodo, fechaDesde, fechaHasta,
//            fecha = Acceso.sdf.format(Acceso.cal.getTime()),
//            fechasdf2 = Acceso.sdf2.format(Acceso.cal.getTime()),
//            fechaBusca1="", fechaBusca2="";
    public static int codigoDP;
    boolean bandera = true;

    public VentaXMes_OpcionesReporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Venta por Mes");
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        escogerAños();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReporte = new javax.swing.JButton();
        panelTiempo = new javax.swing.JPanel();
        boxAño = new javax.swing.JComboBox();
        lblTiempo = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox();
        panelComprobante = new javax.swing.JPanel();
        lblComprobante = new javax.swing.JLabel();
        boxComprobante = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnReporte.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
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
        boxAño.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Escoger Año--" }));
        boxAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAñoActionPerformed(evt);
            }
        });

        lblTiempo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTiempo.setText("Mes y Año:");

        boxMes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "---Escoger Mes---", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
        boxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTiempoLayout = new javax.swing.GroupLayout(panelTiempo);
        panelTiempo.setLayout(panelTiempoLayout);
        panelTiempoLayout.setHorizontalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiempoLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblTiempo)
                .addGap(27, 27, 27)
                .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxAño, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTiempoLayout.setVerticalGroup(
            panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTiempoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTiempo)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxAño, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelTiempoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxAño, boxMes});

        panelComprobante.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblComprobante.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblComprobante.setText("Comprobante:");

        boxComprobante.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Escoger Comprobante--", "Factura", "Boleta", "Ticket" }));
        boxComprobante.setMinimumSize(new java.awt.Dimension(101, 20));
        boxComprobante.setPreferredSize(new java.awt.Dimension(101, 20));

        javax.swing.GroupLayout panelComprobanteLayout = new javax.swing.GroupLayout(panelComprobante);
        panelComprobante.setLayout(panelComprobanteLayout);
        panelComprobanteLayout.setHorizontalGroup(
            panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprobanteLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblComprobante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxComprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelComprobanteLayout.setVerticalGroup(
            panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprobanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar venanta de reporte.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnReporte))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void boxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesActionPerformed
        String mes = boxMes.getSelectedItem().toString();
        if (!"--Escoger Mes--".equals(mes)) {
            if ("Enero".equals(mes)) {       mesCon = 1;            }
            if ("Febrero".equals(mes)) {     mesCon = 2;            }
            if ("Marzo".equals(mes)) {       mesCon = 3;            }
            if ("Abril".equals(mes)) {       mesCon = 4;            }
            if ("Mayo".equals(mes)) {        mesCon = 5;            }
            if ("Junio".equals(mes)) {       mesCon = 6;            }
            if ("Julio".equals(mes)) {       mesCon = 7;            }
            if ("Agosto".equals(mes)) {      mesCon = 8;            }
            if ("Setiembre".equals(mes)) {   mesCon = 9;            }
            if ("Octubre".equals(mes)) {     mesCon = 10;           }
            if ("Noviembre".equals(mes)) {   mesCon = 11;           }
            if ("Diciembre".equals(mes)) {   mesCon = 12;           }
        }
    }//GEN-LAST:event_boxMesActionPerformed

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

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
//        if (!"--Escoger Mes--".equals(boxMes.getSelectedItem().toString()) && !"--Escoger Año--".equals(boxAño.getSelectedItem().toString())
//                && !"--Escoger Comprobante--".equals(boxComprobante.getSelectedItem().toString())) {
//            if ("Factura".equals(boxComprobante.getSelectedItem().toString())) {
//                String[] titulos = {"Serie", "Numero", "RUC", "Razón Social", "Fecha", "Hora", "IGV", "Sub-Total", "Importe"};
//                String consulta = "SELECT factura.fact_serie, factura.fact_numero, cliente.clie_ruc, cliente.clie_razonSocial, factura.fact_fecha, factura.fact_hora,"
//                        + " factura.fact_total*0.18 AS IGV, factura.fact_total - (factura.fact_total * 0.18) AS 'Sub-Total', factura.fact_total FROM factura, cliente WHERE"
//                        + " factura.clie_codigo = cliente.clie_codigo AND MONTH(factura.fact_fecha) = '" + mesCon + "' AND"
//                        + " YEAR(factura.fact_fecha) = '" + boxAño.getSelectedItem().toString() + "' AND factura.fact_estado = 1;";
//                ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Reporte Mes Factura.xls", consulta);
//                ex.reportePorMes("Factura");
//                ex.abrir();
//            } else {
//                if ("Boleta".equals(boxComprobante.getSelectedItem().toString())) {
//                    String[] titulos = {"Serie", "Numero", "Cliente", "Fecha", "Hora", "Sub-Total"};
//                    String consulta = "SELECT bot_serie, bot_numero, bot_nomClie, bot_fecha, bot_hora, bot_total FROM boleta WHERE MONTH(bot_fecha) = '" + mesCon + "' AND"
//                            + " YEAR(bot_fecha) = '" + boxAño.getSelectedItem().toString() + "' AND bot_estado = 1;";
//                    ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Reporte Mes Boleta.xls", consulta);
//                    ex.reportePorMes("Boleta");
//                    ex.abrir();
//                } else {
//                    String[] titulos = {"Serie", "Numero", "Cliente", "Fecha", "Hora", "Sub-Total"};
//                    String consulta = "SELECT tick_serie, tick_numero, tick_nomClie, tick_fecha, tick_hora, tick_total FROM ticket WHERE MONTH(tick_fecha) = '" + mesCon + "' AND"
//                            + " YEAR(tick_fecha) = '"+boxAño.getSelectedItem().toString()+"' AND tick_estado = 1;";
//                    ExportarExcelReporte ex = new ExportarExcelReporte(titulos, "C:/Users/ALMACEN1/Desktop/Reportes/Reporte Mes Boleta.xls", consulta);
//                    ex.reportePorMes("Ticket");
//                    ex.abrir();
//                }
//            }
//        } else {
//            Mensajes.mensajeInformacion("Porfavor escoger correctamente la fecha");
//        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void boxAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAñoActionPerformed

    }//GEN-LAST:event_boxAñoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentaXMes_OpcionesReporte dialog = new VentaXMes_OpcionesReporte(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox boxComprobante;
    private javax.swing.JComboBox boxMes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel lblComprobante;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JPanel panelComprobante;
    private javax.swing.JPanel panelTiempo;
    // End of variables declaration//GEN-END:variables
}
