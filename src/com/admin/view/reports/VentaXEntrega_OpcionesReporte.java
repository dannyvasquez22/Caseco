package com.admin.view.reports;

import com.admin.resource.utils.Global;
import java.util.Calendar;
import java.util.Date;

public class VentaXEntrega_OpcionesReporte extends javax.swing.JDialog {

    public VentaXEntrega_OpcionesReporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        this.setTitle("Selección de Comprobante");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblSeleccion = new javax.swing.JLabel();
        btnVentaBoleta = new javax.swing.JButton();
        btnVentaFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSeleccion.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblSeleccion.setText("Seleccione una opción:");

        btnVentaBoleta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnVentaBoleta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnVentaBoleta.setText("Ventas por Boleta");
        btnVentaBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaBoletaActionPerformed(evt);
            }
        });

        btnVentaFactura.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnVentaFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnVentaFactura.setText("Ventas por Factura");
        btnVentaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnVentaBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnVentaFactura, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSeleccion)))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSeleccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnVentaBoleta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentaFactura)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnVentaBoleta, btnVentaFactura});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVentaBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaBoletaActionPerformed
        dispose();
//        Date fech = Acceso.cal.getTime();
//        Acceso.cal.setTime(fech);
//        Acceso.cal.add(Calendar.DATE, 1);
//        fech = Acceso.cal.getTime();
//        String fechaEntrega = Acceso.sdf2.format(fech);
//        String filejasper = System.getProperty("user.dir") + "/Reportes/BoletasXEntregar.jrxml";
        //Acceso.cc.EjecutarReportar(fechaEntrega,filejasper);
        //con.EjecutarReportar(fechaEntrega,"src\\Reportes\\BoletasXEntregar.jrxml");
    }//GEN-LAST:event_btnVentaBoletaActionPerformed

    private void btnVentaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaFacturaActionPerformed
        dispose();
//        Date fech1 = Acceso.cal.getTime();
//        Acceso.cal.setTime(fech1);
//        Acceso.cal.add(Calendar.DATE, 1);
//        fech1 = Acceso.cal.getTime();
//        String fechaEntrega1 = Acceso.sdf2.format(fech1);
//        String filejasper = System.getProperty("user.dir") + "/Reportes/FacturasXEntregar.jrxml";
        //Acceso.cc.EjecutarReportar(fechaEntrega1,filejasper);
        //con.EjecutarReportar(fechaEntrega1,"src\\Reportes\\FacturasXEntregar.jrxml");
    }//GEN-LAST:event_btnVentaFacturaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentaXEntrega_OpcionesReporte dialog = new VentaXEntrega_OpcionesReporte(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVentaBoleta;
    private javax.swing.JButton btnVentaFactura;
    private javax.swing.JLabel lblSeleccion;
    // End of variables declaration//GEN-END:variables
}
