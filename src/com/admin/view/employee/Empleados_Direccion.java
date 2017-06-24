package com.admin.view.employee;

import com.admin.entity.bl.DireccionBL;
import com.admin.entity.dto.DireccionDTO;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Empleados_Direccion extends javax.swing.JDialog {
    private static DireccionDTO direccion = null;
    public String codigoEmpleado;
    private boolean result = false;
    final static Logger logger = Logger.getLogger(Empleados_Direccion.class);

    public Empleados_Direccion(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Ubicación Terrestre de Trabajadores");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmpleado = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblEmpleadoOrigen = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        txtProvincia = new Folder.DJCTextFieldWithoutPop();
        lblDepartamento = new javax.swing.JLabel();
        boxDepartamento = new javax.swing.JComboBox();
        lblDistrito = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        txtDistrito = new Folder.DJCTextFieldWithoutPop();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEmpleado.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblEmpleado.setText("Empleado:");

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva ubicación.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de ubicación.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblEmpleadoOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmpleadoOrigen.setText(".");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la ubicación requerida.");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        txtProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProvincia.setPlaceholder("Escribir aquí la provincia.");

        lblDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDepartamento.setText("(*) Departamento: ");

        boxDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cuzco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali" }));

        lblDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDistrito.setText("(*) Distrito:");

        lblProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProvincia.setText("(*) Provincia :");

        txtDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDistrito.setPlaceholder("Escribir aquí el distrito.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAviso))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblProvincia)
                                            .addComponent(lblDepartamento)
                                            .addComponent(lblDistrito))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtProvincia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(boxDepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, 209, Short.MAX_VALUE)
                                            .addComponent(txtDistrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmpleadoOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpleado)
                    .addComponent(lblEmpleadoOrigen))
                .addGap(29, 29, 29)
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
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void listarDirecciones(String tipoReferencia, String referencia) throws SQLException {
        direccion = null;
        direccion = DireccionBL.getInstance().listDirecciones(tipoReferencia, referencia);
        if (direccion != null) {
            boxDepartamento.setSelectedItem(direccion.getDepartamento());
            txtProvincia.setText(direccion.getProvincia());
            txtDistrito.setText(direccion.getDistrito());
        }
    }
    
    private void inicializarVariables() {
        direccion = null;
        result = false;
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (boxDepartamento.getSelectedItem() == null && txtProvincia.getText().equals("") && txtDistrito.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                direccion = DireccionBL.getInstance().getByTipo("EMPLEADO", codigoEmpleado);
                if (direccion == null) {
                    direccion = new DireccionDTO(
                            boxDepartamento.getSelectedItem().toString(),
                            txtProvincia.getText(),
                            txtDistrito.getText(),
                            "EMPLEADO",
                            codigoEmpleado
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (boxDepartamento.getSelectedItem() == null && txtProvincia.getText().equals("") && txtDistrito.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                direccion = DireccionBL.getInstance().getByTipo("EMPLEADO", codigoEmpleado);
                if (direccion == null) {
                    direccion = new DireccionDTO(
                            boxDepartamento.getSelectedItem().toString(),
                            txtProvincia.getText(),
                            txtDistrito.getText(),
                            "EMPLEADO",
                            codigoEmpleado
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
                Empleados_Direccion dialog = new Empleados_Direccion(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblEmpleado;
    public javax.swing.JLabel lblEmpleadoOrigen;
    private javax.swing.JLabel lblProvincia;
    public static Folder.DJCTextFieldWithoutPop txtDistrito;
    public static Folder.DJCTextFieldWithoutPop txtProvincia;
    // End of variables declaration//GEN-END:variables
}
