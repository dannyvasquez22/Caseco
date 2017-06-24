package com.admin.view.clients;

import com.admin.entity.bl.DireccionBL;
import com.admin.entity.dto.DireccionDTO;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Clientes_Direccion extends javax.swing.JDialog {
    private static DireccionDTO direccion = null;
    public String codigoCliente;
    private boolean result = false;
    final static Logger logger = Logger.getLogger(Clientes_Direccion.class);

    public Clientes_Direccion(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Ubicación Terrestre de Clientes");
    }
    
    private void inicializarVariables() {
        direccion = null;
        result = false;
    }

    public static void listarDirecciones(String tipoReferencia, String referencia) throws SQLException {
        direccion = null;
        direccion = DireccionBL.getInstance().listDirecciones(tipoReferencia, referencia);
        if (direccion != null) {
            boxDepartamento.setSelectedItem(direccion.getDepartamento());
            txtProvincia.setText(direccion.getProvincia());
            txtDistrito.setText(direccion.getDistrito());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblClienteOrigen = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        boxDepartamento = new javax.swing.JComboBox();
        lblProvincia = new javax.swing.JLabel();
        txtProvincia = new Folder.DJCTextFieldWithoutPop();
        lblDistrito = new javax.swing.JLabel();
        txtDistrito = new Folder.DJCTextFieldWithoutPop();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCliente.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblCliente.setText("Cliente:");

        lblClienteOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblClienteOrigen.setText(".");

        lblDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDepartamento.setText("(*) Departamento: ");

        boxDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cuzco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali" }));

        lblProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProvincia.setText("(*) Provincia :");

        txtProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDistrito.setText("(*) Distrito:");

        txtDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar la ubicación terrestre.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar al ubicación terrestre.");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de ubicación terrestre.");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCliente)
                        .addGap(37, 37, 37)
                        .addComponent(lblClienteOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProvincia)
                                    .addComponent(lblDepartamento)
                                    .addComponent(lblDistrito))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boxDepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(lblClienteOrigen))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(boxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistrito)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
   
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (boxDepartamento.getSelectedItem() == null && txtProvincia.getText().equals("") && txtDistrito.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                direccion = DireccionBL.getInstance().getByTipo("CLIENTE", codigoCliente);
                if (direccion == null) {
                    direccion = new DireccionDTO(
                            boxDepartamento.getSelectedItem().toString(),
                            txtProvincia.getText(),
                            txtDistrito.getText(),
                            "CLIENTE",
                            codigoCliente
                    );

                    result = DireccionBL.getInstance().insert(direccion);
                    if (!result)    Messages.messageAlert("Error en datos de direccion.");
                    dispose();
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (boxDepartamento.getSelectedItem() == null && txtProvincia.getText().equals("") && txtDistrito.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                direccion = DireccionBL.getInstance().getByTipo("CLIENTE", codigoCliente);
                if (direccion == null) {
                    direccion = new DireccionDTO(
                            boxDepartamento.getSelectedItem().toString(),
                            txtProvincia.getText(),
                            txtDistrito.getText(),
                            "CLIENTE",
                            codigoCliente
                    );

                    result = DireccionBL.getInstance().update(direccion);
                    if (!result)    Messages.messageAlert("Error en datos de direccion.");
                    dispose();
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes_Direccion dialog = new Clientes_Direccion(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox boxDepartamento;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCliente;
    public javax.swing.JLabel lblClienteOrigen;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblProvincia;
    public static Folder.DJCTextFieldWithoutPop txtDistrito;
    public static Folder.DJCTextFieldWithoutPop txtProvincia;
    // End of variables declaration//GEN-END:variables
}
