package com.admin.view.employee;

import com.admin.controller.tablemodel.TEmpleadoUsuario;
import com.admin.model.bl.DetalleCargoBL;
import com.admin.model.bl.EmpleadoBL;
import com.admin.model.dto.DetalleCargoDTO;
import com.admin.model.pojo.EmpleadoP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Empleados_BuscaChofer extends javax.swing.JDialog {
    private static ArrayList<EmpleadoP> listEmpleados = new ArrayList<>();
    private DetalleCargoDTO detalleCargo = null;
    private String []array = new String[5];
    private int filaConductor = -1;
    final static Logger logger = Logger.getLogger(Empleados_BuscaChofer.class);

    public Empleados_BuscaChofer(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Conductores");
        try {
            listarEmpleados();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void listarEmpleados() throws SQLException{
        listEmpleados.clear();
        listEmpleados = EmpleadoBL.getInstance().listEmpleadoCargo(array, 2);
        tblChofer.setModel(new TEmpleadoUsuario(listEmpleados));
        ConfigTables.headerTables(tblChofer);
        ConfigTables.sizeEmployeeUser(tblChofer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollChofer = new javax.swing.JScrollPane();
        tblChofer = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnCancelar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblChofer.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblChofer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblChofer.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblChofer.getTableHeader().setReorderingAllowed(false);
        tblChofer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChoferMouseClicked(evt);
            }
        });
        scrollChofer.setViewportView(tblChofer);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de choferes.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblMensaje.setText("Para seleccionar un elemento debe presionar doble-click sobre el mismo.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        lblTitulo.setText("REFERENTE: CARGO -> 'CHOFER'  o   'CONDUCTOR'");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollChofer)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMensaje)
                        .addGap(0, 261, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollChofer, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje)
                .addGap(1, 1, 1)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblChoferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChoferMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                filaConductor = tblChofer.getSelectedRow();
                String codigo = tblChofer.getValueAt(filaConductor, 0).toString();
                String cargo = tblChofer.getValueAt(filaConductor, 3).toString();
                detalleCargo = DetalleCargoBL.getInstance().getByCodigoByCargo(codigo, cargo);
                if (detalleCargo != null) {
                    Empleados_Choferes.detalleCargo = String.valueOf(detalleCargo.getCodigo());
                }
                Empleados_Choferes.txtChofer.setText(tblChofer.getValueAt(filaConductor, 2).toString());
                dispose();
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_tblChoferMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados_BuscaChofer dialog = new Empleados_BuscaChofer(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollChofer;
    private javax.swing.JTable tblChofer;
    // End of variables declaration//GEN-END:variables
}
