package com.admin.view.products;

import com.admin.controller.tablemodel.TTiendaProducto;
import com.admin.model.bl.TiendaProductoBL;
import com.admin.model.dto.TiendaProductoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Productos_TiempoTrabajo extends javax.swing.JDialog {
    private static ArrayList<TiendaProductoDTO> listTiendaProducto = null;
    final static Logger logger = Logger.getLogger(Productos_TiempoTrabajo.class);

    public Productos_TiempoTrabajo(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Tiempo de Trabajo entre Producto y Tienda");
    }

    public static void listarTiempoProducto(int codigoProducto, String razonSocial) {
        listTiendaProducto = new ArrayList<>();
        try {
            listTiendaProducto = TiendaProductoBL.getInstance().listAll(codigoProducto, razonSocial);
            tblTiempoProductos.setModel(new TTiendaProducto(listTiendaProducto));
            ConfigTables.headerTables(tblTiempoProductos);
            ConfigTables.sizeTimeProduct(tblTiempoProductos);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        scrollProductos = new javax.swing.JScrollPane();
        tblTiempoProductos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        lblProducto = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        lblProductoOrigen = new javax.swing.JLabel();
        lblTiendaOrigen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 22)); // NOI18N
        lblTitulo.setText("TIEMPO DE TRABAJO ARTICULO -  TIENDA");

        tblTiempoProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollProductos.setViewportView(tblTiempoProductos);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de tiempo de trabajo de productos.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblProducto.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProducto.setText("Producto:");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRazonSocial.setText("Razón Social Venta:");

        lblProductoOrigen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblProductoOrigen.setText("jLabel4");

        lblTiendaOrigen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTiendaOrigen.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollProductos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRazonSocial)
                            .addComponent(lblProducto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTiendaOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProductoOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(lblProductoOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazonSocial)
                    .addComponent(lblTiendaOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_TiempoTrabajo dialog = new Productos_TiempoTrabajo(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel lblProducto;
    public javax.swing.JLabel lblProductoOrigen;
    private javax.swing.JLabel lblRazonSocial;
    public javax.swing.JLabel lblTiendaOrigen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollProductos;
    private static javax.swing.JTable tblTiempoProductos;
    // End of variables declaration//GEN-END:variables
}
