package com.admin.view.users;

import com.admin.controller.tablemodel.TConectadoUsuario;
import com.admin.entity.bl.UsuarioBL;
import com.admin.entity.pojo.ConectadoUsuarioP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class ConectadoUsuario extends javax.swing.JDialog {
    private static ArrayList<ConectadoUsuarioP> listConectados = null;
    private String []array = null;
    final static Logger logger = Logger.getLogger(ConectadoUsuario.class);
    
    public ConectadoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        this.setTitle("Conexiones de Usuarios");
        lblConectados.setFont(new Font("Verdana", Font.BOLD, 12));
        lblConectados.setForeground(Color.blue);
        verificarParametros();
    }

    private void verificarParametros() {
        array = new String[4];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        if (!txtCargo.getText().equals(""))     array[0] = txtCargo.getText();
        if (!txtNombre.getText().equals(""))    array[1] = txtNombre.getText();
        if (!txtCuenta.getText().equals(""))    array[2] = txtCuenta.getText();
        
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            array[3] = null;
        } else {
            if (lblConectados.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                array[3] = "1";
            } else {
                array[3] = "0";
            }
        }
        try {
            listarUsuariosConectados(array);
        } catch (SQLException ex) {
            Messages.messageAlert("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void listarUsuariosConectados(String []params) throws SQLException {
        listConectados = new ArrayList<>();
        listConectados = UsuarioBL.getInstance().listConexionUsuarioByFilter(params);
        tblConectados.setModel(new TConectadoUsuario(listConectados));
        ConfigTables.headerTables(tblConectados);
        ConfigTables.sizeConnectionUser(tblConectados);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        scrollConectados = new javax.swing.JScrollPane();
        tblConectados = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblCuenta = new javax.swing.JLabel();
        txtCuenta = new Folder.DJCTextFieldWithoutPop();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new Folder.DJCTextFieldWithoutPop();
        lblCargo1 = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblConectados = new javax.swing.JLabel();
        lblDesconectados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre.");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        tblConectados.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblConectados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblConectados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblConectados.getTableHeader().setReorderingAllowed(false);
        scrollConectados.setViewportView(tblConectados);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de conectados.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("CONEXIONES DE USUARIOS");

        lblCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCuenta.setText("Cuenta: ");

        txtCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCuenta.setPlaceholder("Escribir aquí la cuenta.");
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCuentaKeyReleased(evt);
            }
        });

        lblCargo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCargo.setText("Cargo:  ");

        txtCargo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCargo.setPlaceholder("Escribir aquí el cargo.");
        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCargoKeyReleased(evt);
            }
        });

        lblCargo1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCargo1.setText("Estado:  ");

        lblTodos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTodos.setText("Todos");
        lblTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTodosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTodosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTodosMouseExited(evt);
            }
        });

        lblConectados.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblConectados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConectados.setText("Conectados");
        lblConectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConectadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConectadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConectadosMouseExited(evt);
            }
        });

        lblDesconectados.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDesconectados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesconectados.setText("Desconectados");
        lblDesconectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesconectadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDesconectadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDesconectadosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollConectados)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCargo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCargo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblConectados, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDesconectados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo1)
                    .addComponent(lblTodos)
                    .addComponent(lblConectados)
                    .addComponent(lblDesconectados))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuenta)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollConectados, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCuentaKeyReleased

    private void txtCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCargoKeyReleased

    private void lblTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseClicked
        lblTodos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblConectados.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblDesconectados.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setForeground(Color.blue);
        lblConectados.setForeground(Color.black);
        lblDesconectados.setForeground(Color.black);
        verificarParametros();
    }//GEN-LAST:event_lblTodosMouseClicked

    private void lblTodosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseEntered
        lblTodos.setForeground(Color.blue);
    }//GEN-LAST:event_lblTodosMouseEntered

    private void lblTodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseExited
//        if (!lblTodos.getForeground().equals(Color.blue)) {
//            lblTodos.setForeground(Color.black);
//        }
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblTodos.setForeground(Color.blue);
        } else {
            lblTodos.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblTodosMouseExited

    private void lblConectadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConectadosMouseClicked
        lblConectados.setFont(new Font("Verdana", Font.BOLD, 12));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblDesconectados.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblConectados.setForeground(Color.blue);
        lblDesconectados.setForeground(Color.black);
        lblTodos.setForeground(Color.black);        
        verificarParametros();
    }//GEN-LAST:event_lblConectadosMouseClicked

    private void lblConectadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConectadosMouseEntered
        lblConectados.setForeground(Color.blue);
    }//GEN-LAST:event_lblConectadosMouseEntered

    private void lblConectadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConectadosMouseExited
        if (lblConectados.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblConectados.setForeground(Color.blue);
        } else {
            lblConectados.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblConectadosMouseExited

    private void lblDesconectadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesconectadosMouseClicked
        lblDesconectados.setFont(new Font("Verdana", Font.BOLD, 12));
        lblConectados.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblDesconectados.setForeground(Color.blue);
        lblTodos.setForeground(Color.black);
        lblConectados.setForeground(Color.black);        
        verificarParametros();
    }//GEN-LAST:event_lblDesconectadosMouseClicked

    private void lblDesconectadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesconectadosMouseEntered
        lblDesconectados.setForeground(Color.blue);
    }//GEN-LAST:event_lblDesconectadosMouseEntered

    private void lblDesconectadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesconectadosMouseExited
        if (lblDesconectados.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblDesconectados.setForeground(Color.blue);
        } else {
            lblDesconectados.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblDesconectadosMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConectadoUsuario dialog = new ConectadoUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargo1;
    private javax.swing.JLabel lblConectados;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDesconectados;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JScrollPane scrollConectados;
    public static javax.swing.JTable tblConectados;
    public static Folder.DJCTextFieldWithoutPop txtCargo;
    public static Folder.DJCTextFieldWithoutPop txtCuenta;
    public static Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
