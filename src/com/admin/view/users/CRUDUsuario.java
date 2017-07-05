package com.admin.view.users;

import com.admin.controller.tablemodel.TUsuario;
import com.admin.model.bl.DetalleCargoBL;
import com.admin.model.bl.UsuarioBL;
import com.admin.model.dto.DetalleCargoDTO;
import com.admin.model.dto.UsuarioDTO;
import com.admin.model.pojo.ListaCrudUsuarioP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class CRUDUsuario extends javax.swing.JDialog {
    private static ArrayList<ListaCrudUsuarioP> listUsuarios = new ArrayList<>();
    private UsuarioDTO usuario = null;
    private DetalleCargoDTO detalle = null;
    private boolean esRepetido = false;
    private static int inactivos = 1;
    private static int filaUsuario = -1;
    private static boolean result = false;
    private String ip = "127.0.0.1";
    private int pregunta;
    final static Logger logger = Logger.getLogger(CRUDUsuario.class);

    public CRUDUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Gestión de Usuarios");        
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
    }

    private void verificarParametros() {
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            inactivos = -1;
        } else {
            if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                inactivos = 1;
            } else {
                inactivos = 0;
            }
        }
        try {
            listarUsuarios(inactivos);
        } catch (SQLException ex) {
            Messages.messageAlert("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void listarUsuarios(int param) throws SQLException{
        listUsuarios.clear();
        listUsuarios = UsuarioBL.getInstance().listUsuarioByStatus(param);
        tblUsuarios.setModel(new TUsuario(listUsuarios));
        ConfigTables.headerTables(tblUsuarios);
        ConfigTables.sizeListCrudUsuario(tblUsuarios);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        scrollUsuarios = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        lblContraseña = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtUsuario = new Folder.DJCTextFieldWithoutPop();
        lblUsuario = new javax.swing.JLabel();
        txtNombreEmpleado = new Folder.DJCTextFieldWithoutPop();
        txtIP = new Folder.DJCTextFieldWithoutPop();
        lblIp = new javax.swing.JLabel();
        btnDesactivar = new javax.swing.JButton();
        psPassword = new javax.swing.JPasswordField();
        lblCodigo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtCodigoEmpleado = new Folder.DJCTextFieldWithoutPop();
        lblCargoEmpleado = new javax.swing.JLabel();
        txtCargo = new Folder.DJCTextFieldWithoutPop();
        btnCancelar = new javax.swing.JButton();
        btnSeleccion = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        btnActivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo usuario.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el usuario seleccionado.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        tblUsuarios.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        scrollUsuarios.setViewportView(tblUsuarios);

        lblContraseña.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblContraseña.setText("(*) Contraseña :");

        txtUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblUsuario.setText("(*) Usuario :");

        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        txtIP.setText("192.168.1.1");
        txtIP.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIPActionPerformed(evt);
            }
        });

        lblIp.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblIp.setText("(*) IP : ");

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setToolTipText("Botón para eliminar el usuario seleccionado.");
        btnDesactivar.setEnabled(false);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        psPassword.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodigo.setText("Código :");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar Empleado");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("Nombre :");

        txtCodigoEmpleado.setEditable(false);
        txtCodigoEmpleado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblCargoEmpleado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCargoEmpleado.setText("Cargo :");

        txtCargo.setEditable(false);
        txtCargo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de usuarios.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSeleccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccion.setText("Quitar selección");
        btnSeleccion.setToolTipText("Botón para quitar la selección del usuario seleccionado.");
        btnSeleccion.setEnabled(false);
        btnSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("LISTA DE USUARIOS");

        lblFiltro.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro listado: ");

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

        lblActivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActivos.setText("Activos");
        lblActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActivosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblActivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblActivosMouseExited(evt);
            }
        });

        lblInactivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblInactivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInactivos.setText("Inactivos");
        lblInactivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInactivosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInactivosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInactivosMouseExited(evt);
            }
        });

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.setToolTipText("Botón para eliminar el usuario seleccionado.");
        btnActivar.setEnabled(false);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(283, 283, 283))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCargoEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(lblFiltro)
                        .addGap(18, 18, 18)
                        .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollUsuarios, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(4, 4, 4)
                        .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre)
                        .addGap(24, 24, 24)
                        .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addGap(1, 1, 1)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBuscar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCodigo)
                                .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(3, 3, 3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombre)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargoEmpleado)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña)
                    .addComponent(psPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIp)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregar)
                    .addComponent(btnDesactivar)
                    .addComponent(btnSeleccion)
                    .addComponent(btnActivar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblFiltro)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    boolean esUsuarioRepetido(String cuenta) throws SQLException{
        usuario = UsuarioBL.getInstance().search(cuenta);
        return (usuario != null);
    }
    
    private void inicializarVariables(){
        esRepetido = false;
        detalle = null;
        usuario = null;
        result = false;
        ip = "127.0.0.1";
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (txtUsuario.getText().equals("") || psPassword.getText().equals("") || txtIP.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                esRepetido = esUsuarioRepetido(txtUsuario.getText());
                if (esRepetido == false) {
                    detalle = DetalleCargoBL.getInstance().getByCodigoByCargo(txtCodigoEmpleado.getText(), txtCargo.getText());
                    
                    if (detalle != null) {
                        usuario = new UsuarioDTO(
                                        txtUsuario.getText(), 
                                        psPassword.getText(), 
                                        txtIP.getText(), 
                                        detalle);
                        result = UsuarioBL.getInstance().insert(usuario);
                        if (result) {
                            Messages.messageInsert();
                            ActivaUsuario();
                            verificarParametros();
                        } else { Messages.messageErrorInsert(); }
                    }
                } else {    Messages.messageRepeat();    }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (txtUsuario.getText().equals("") || txtIP.getText().equals("")) {
            Messages.messageAlert();
        } else {
            try {
                if (!tblUsuarios.getValueAt(filaUsuario, 2).toString().equals(txtUsuario.getText())) {
                    esRepetido = esUsuarioRepetido(txtUsuario.getText());
                }
                if (esRepetido == false) {
                    usuario = new UsuarioDTO(tblUsuarios.getValueAt(filaUsuario, 2).toString());
                    if (!txtIP.getText().equals("")) {
                        ip = txtIP.getText();
                    }
                    result = UsuarioBL.getInstance().update(usuario, txtUsuario.getText(), ip, 1);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaUsuario();
                        verificarParametros();
                    } else { Messages.messageErrorUpdate();  }
                } else {      Messages.messageRepeat();         }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        tblUsuarios.setRowSelectionAllowed(true);
        filaUsuario = tblUsuarios.getSelectedRow();
        txtCodigoEmpleado.setText(tblUsuarios.getValueAt(filaUsuario, 0).toString());
        txtNombreEmpleado.setText(tblUsuarios.getValueAt(filaUsuario, 1).toString());
        txtCargo.setText(tblUsuarios.getValueAt(filaUsuario, 3).toString());
        txtUsuario.setText(tblUsuarios.getValueAt(filaUsuario, 2).toString());
        txtIP.setText(tblUsuarios.getValueAt(filaUsuario, 5).toString());

        if (tblUsuarios.getValueAt(filaUsuario, 4).toString().equals("Activo")) {
            btnDesactivar.setEnabled(true);
            btnActivar.setEnabled(false);
        } else {
            btnActivar.setEnabled(true);
            btnDesactivar.setEnabled(false);
        }
        
        btnModificar.setEnabled(true);       
        btnSeleccion.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnAgregar.setEnabled(false);
        psPassword.setEditable(false);
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                usuario = new UsuarioDTO(tblUsuarios.getValueAt(filaUsuario, 2).toString());
                result = UsuarioBL.getInstance().delete(usuario, 0);
                if (result) {
                    Messages.messageDelete();
                    ActivaUsuario();
                    verificarParametros();
                } else {    Messages.messageErrorDelete();     }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new EmpleadoUsuario(this,true).setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    void ActivaUsuario() {
        tblUsuarios.setRowSelectionAllowed(false);
        txtCodigoEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtCargo.setText("");
        txtUsuario.setText("");
        psPassword.setText("");
        btnModificar.setEnabled(false);
        btnDesactivar.setEnabled(false);
        btnActivar.setEnabled(false);
        btnSeleccion.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnAgregar.setEnabled(true);
    }

    private void btnSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionActionPerformed
        ActivaUsuario();
        psPassword.setEditable(true);
    }//GEN-LAST:event_btnSeleccionActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        psPassword.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIPActionPerformed
        txtIP.requestFocus();
    }//GEN-LAST:event_txtIPActionPerformed

    private void lblTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseClicked
        lblTodos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setForeground(Color.blue);
        lblActivos.setForeground(Color.black);
        lblInactivos.setForeground(Color.black);
        psPassword.setEditable(true);
        verificarParametros();
    }//GEN-LAST:event_lblTodosMouseClicked

    private void lblTodosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseEntered
        lblTodos.setForeground(Color.blue);
    }//GEN-LAST:event_lblTodosMouseEntered

    private void lblTodosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseExited
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblTodos.setForeground(Color.blue);
        } else {
            lblTodos.setForeground(Color.black);
        }    }//GEN-LAST:event_lblTodosMouseExited

    private void lblActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseClicked
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblActivos.setForeground(Color.blue);
        lblInactivos.setForeground(Color.black);
        lblTodos.setForeground(Color.black);        
        psPassword.setEditable(true);
        verificarParametros();
    }//GEN-LAST:event_lblActivosMouseClicked

    private void lblActivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseEntered
        lblActivos.setForeground(Color.blue);
    }//GEN-LAST:event_lblActivosMouseEntered

    private void lblActivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseExited
        if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblActivos.setForeground(Color.blue);
        } else {
            lblActivos.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblActivosMouseExited

    private void lblInactivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivosMouseClicked
        lblInactivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setForeground(Color.blue);
        lblTodos.setForeground(Color.black);
        lblActivos.setForeground(Color.black);        
        psPassword.setEditable(true);
        verificarParametros();
    }//GEN-LAST:event_lblInactivosMouseClicked

    private void lblInactivosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivosMouseEntered
        lblInactivos.setForeground(Color.blue);
    }//GEN-LAST:event_lblInactivosMouseEntered

    private void lblInactivosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInactivosMouseExited
        if (lblInactivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            lblInactivos.setForeground(Color.blue);
        } else {
            lblInactivos.setForeground(Color.black);
        }
    }//GEN-LAST:event_lblInactivosMouseExited

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        usuario = null;
        result = false;
        pregunta = Messages.messageActive();
        if (pregunta == 0) {
            try {
                usuario = new UsuarioDTO(tblUsuarios.getValueAt(filaUsuario, 2).toString());
                result = UsuarioBL.getInstance().delete(usuario, 1);
                if (result) {
                    Messages.messageUnDelete();
                    ActivaUsuario();
                    verificarParametros();
                } else {    Messages.messageErrorUnDelete();    }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CRUDUsuario dialog = new CRUDUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccion;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCargoEmpleado;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblIp;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JLabel lblUsuario;
    public static javax.swing.JPasswordField psPassword;
    private javax.swing.JScrollPane scrollUsuarios;
    public static javax.swing.JTable tblUsuarios;
    public static Folder.DJCTextFieldWithoutPop txtCargo;
    public static Folder.DJCTextFieldWithoutPop txtCodigoEmpleado;
    public static Folder.DJCTextFieldWithoutPop txtIP;
    public static Folder.DJCTextFieldWithoutPop txtNombreEmpleado;
    public static Folder.DJCTextFieldWithoutPop txtUsuario;
    // End of variables declaration//GEN-END:variables
}
