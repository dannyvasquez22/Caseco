package com.admin.view.products;

import com.admin.controller.tablemodel.TDetalleProveedor;
import com.admin.controller.tablemodel.TProveedor;
import com.admin.model.bl.DetalleProveedorBL;
import com.admin.model.bl.ProveedorBL;
import com.admin.model.dto.DetalleProveedorDTO;
import com.admin.model.dto.ProveedorDTO;
import com.admin.resource.utils.Browser;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;

public class Productos_CRUDProveedor extends javax.swing.JDialog {
    public int filaProveedor = -1, isFrame = 0;
    private static ArrayList<ProveedorDTO> listProveedor = null;
    private static ArrayList<DetalleProveedorDTO> listDetalleProveedor = null;
    private ProveedorDTO proveedor = null;
    private DetalleProveedorDTO detalleProveedor = null;
    private String fechaInicioProveedor;
    private String fechaFinProveedor;
    private static String[] array;
    private boolean esRepetido = false;
    private boolean result = false;
    private String fechadetprovemysql, textdir = "-", textweb = "-", textmail = "-", telef, tiptelef, codigoEmp, recaudo, vdni, vcod, browser, url;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Productos_CRUDProveedor.class);

    public Productos_CRUDProveedor(java.awt.Dialog parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Lista de Proveedores");
        txtBuscarNombre.requestFocus();
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
        panelVista.setVisible(false);
        panelRegistro.setVisible(false);
    }
    
    public static void verificarParametros() {
        array = new String[3];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        if (!txtBuscarNombre.getText().equals("")) array[0] = txtNombre.getText();
        if (!txtBuscarRuc.getText().equals("")) array[1] = txtRuc.getText();
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            array[2] = null;
        } else {
            if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                array[2] = "1";
            } else {
                array[2] = "0";
            }
        }
        try {
            listarProveedores(array);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public static void listarProveedores(String []array) throws SQLException {
        listProveedor = new ArrayList<>();
        listProveedor = ProveedorBL.getInstance().listAllByStatus(array);
        tblProveedor.setModel(new TProveedor(listProveedor));
        ConfigTables.headerTables(tblProveedor);
        ConfigTables.sizeProvide(tblProveedor);
    }

    void mostrarTiempo(String nom) {
        listDetalleProveedor = new ArrayList<>();
        try {
            listDetalleProveedor = DetalleProveedorBL.getInstance().getByProveedor(nom);
            tblTiempoTrabajo.setModel(new TDetalleProveedor(listDetalleProveedor));
            ConfigTables.headerTables(tblTiempoTrabajo);
            ConfigTables.sizeTimeProvider(tblTiempoTrabajo);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        panelVista = new javax.swing.JPanel();
        scrollTiempo = new javax.swing.JScrollPane();
        tblTiempoTrabajo = new javax.swing.JTable();
        lblAviso = new javax.swing.JLabel();
        btnTiempoActivo = new javax.swing.JButton();
        panelRegistro = new javax.swing.JPanel();
        btnWeb = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        lblRuc = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        btnEmail = new javax.swing.JButton();
        txtRuc = new Folder.DJCTextFieldWithoutPop();
        txtEmail = new Folder.DJCTextFieldWithoutPop();
        txtWeb = new Folder.DJCTextFieldWithoutPop();
        lblWeb = new javax.swing.JLabel();
        btnRuc = new javax.swing.JButton();
        panelBusqueda = new javax.swing.JPanel();
        txtBuscarNombre = new Folder.DJCTextFieldWithoutPop();
        lblBuscarNombre = new javax.swing.JLabel();
        lblBuscarRuc = new javax.swing.JLabel();
        txtBuscarRuc = new Folder.DJCTextFieldWithoutPop();
        lblEstado = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        scrollProveedor = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnCancel = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();
        btnAgrega = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 24)); // NOI18N
        lblTitulo.setText("BUSQUEDA Y GESTION RAPIDA DE PROVEEDORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 0, 0);
        getContentPane().add(lblTitulo, gridBagConstraints);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de gestión rápida de proveedores.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 39, 0, 10);
        getContentPane().add(btnCancelar, gridBagConstraints);

        tblTiempoTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollTiempo.setViewportView(tblTiempoTrabajo);

        javax.swing.GroupLayout panelVistaLayout = new javax.swing.GroupLayout(panelVista);
        panelVista.setLayout(panelVistaLayout);
        panelVistaLayout.setHorizontalGroup(
            panelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelVistaLayout.setVerticalGroup(
            panelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 337;
        gridBagConstraints.ipady = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 59, 11, 0);
        getContentPane().add(panelVista, gridBagConstraints);

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(lblAviso, gridBagConstraints);

        btnTiempoActivo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnTiempoActivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bper.png"))); // NOI18N
        btnTiempoActivo.setText("Tiempo de Trabajo");
        btnTiempoActivo.setEnabled(false);
        btnTiempoActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiempoActivoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 39, 0, 10);
        getContentPane().add(btnTiempoActivo, gridBagConstraints);

        panelRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11))); // NOI18N

        btnWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnWeb.setToolTipText("Botón para ingresar a la página del proveedor.");
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmail.setText("Email:");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        lblDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("Escribir aquí la dirección del proveedor.");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRuc.setText("RUC:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre del proveedor.");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/email.png"))); // NOI18N
        btnEmail.setToolTipText("Botón para enviar un email.");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        txtRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRuc.setPlaceholder("Sólo 12 dígitos.");
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtEmail.setPlaceholder("Ejm: mi-correo@hotmail.com");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtWeb.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtWeb.setPlaceholder("Ejm: www.mi-pagina.com");

        lblWeb.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblWeb.setText("Web:");

        btnRuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnRuc.setToolTipText("Botón para verificar existencia de ruc.");
        btnRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblRuc))
                .addGap(8, 8, 8)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(lblWeb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRegistroLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblEmail)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRuc)))
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblWeb)))
                            .addComponent(btnRuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnWeb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 219;
        gridBagConstraints.ipady = -7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        getContentPane().add(panelRegistro, gridBagConstraints);

        panelBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11))); // NOI18N

        txtBuscarNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBuscarNombre.setPlaceholder("Escribir el nombre del proveedor a buscar.");
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyReleased(evt);
            }
        });

        lblBuscarNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBuscarNombre.setText("Nombre:");

        lblBuscarRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBuscarRuc.setText("Ruc:");

        txtBuscarRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBuscarRuc.setPlaceholder("Escribir el ruc a buscar.");
        txtBuscarRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarRucKeyReleased(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEstado.setText("Estado:");

        lblTodos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
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

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblBuscarRuc)
                .addGap(30, 30, 30)
                .addComponent(txtBuscarRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEstado)
                .addGap(40, 40, 40)
                .addComponent(lblTodos)
                .addGap(35, 35, 35)
                .addComponent(lblActivos)
                .addGap(31, 31, 31)
                .addComponent(lblInactivos)
                .addContainerGap())
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarNombre)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarRuc)
                    .addComponent(txtBuscarRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.ipadx = 499;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(panelBusqueda, gridBagConstraints);

        tblProveedor.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProveedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProveedor.getTableHeader().setReorderingAllowed(false);
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        scrollProveedor.setViewportView(tblProveedor);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1082;
        gridBagConstraints.ipady = 164;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 10);
        getContentPane().add(scrollProveedor, gridBagConstraints);

        btnCancel.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnCancel.setText("Cancelar Seleccion");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 54, 0, 10);
        getContentPane().add(btnCancel, gridBagConstraints);

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setToolTipText("Salir");
        btnDesactivar.setEnabled(false);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 67, 0, 0);
        getContentPane().add(btnDesactivar, gridBagConstraints);

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.setToolTipText("Salir");
        btnActivar.setEnabled(false);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 56, 0, 0);
        getContentPane().add(btnActivar, gridBagConstraints);

        btnModifica.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModifica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModifica.setText("Modificar");
        btnModifica.setToolTipText("Modificar");
        btnModifica.setEnabled(false);
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 64, 0, 0);
        getContentPane().add(btnModifica, gridBagConstraints);

        btnAgrega.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/docs.png"))); // NOI18N
        btnAgrega.setText("Nuevo");
        btnAgrega.setToolTipText("Grabar");
        btnAgrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 20, 0, 0);
        getContentPane().add(btnAgrega, gridBagConstraints);

        btnSeleccionar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/OK.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 0, 0);
        getContentPane().add(btnSeleccionar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtBuscarNombreKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        proveedor = null;
        detalleProveedor = null;
        fechadetprovemysql = Global.CALENDARY.get(Global.CALENDARY.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
        textdir = "-";
        textweb = "-";
        textmail = "-";
    }
    
    private void btnAgregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaActionPerformed
        ImageIcon nuevo = new ImageIcon("src/com/admin/resource/images/docs.png");
        ImageIcon agrega = new ImageIcon("src/com/admin/resource/images/Create.png");
        if (btnAgrega.getText().equals("Nuevo")) {
            txtRuc.requestFocus();
            btnCancel.setEnabled(true);
            btnAgrega.setText("Agregar");
            btnAgrega.setIcon(agrega);
            panelRegistro.setVisible(true);
        } else {
            inicializarVariables();
            if (!txtDireccion.getText().equals("")) {  textdir = txtDireccion.getText();    }
            if (!txtWeb.getText().equals("")) {        textweb = txtWeb.getText();          }
            if (!txtEmail.getText().equals("")) {      textmail = txtEmail.getText();       }

            if (txtRuc.getText().equals("") || txtNombre.getText().equals("")) {
                Messages.messageAlert();
            } else {
                esRepetido = esRepetidoProveedor(txtNombre.getText());
                if (esRepetido == false) {
                    try {
                        proveedor = new ProveedorDTO(
                                txtNombre.getText(),
                                txtRuc.getText(),
                                textdir,
                                textweb,
                                textmail
                        );
                        result = ProveedorBL.getInstance().insert(proveedor);
                        if(!result) Messages.messageError("Error al insertar proveedor");
                        
                        detalleProveedor = new DetalleProveedorDTO(
                                fechadetprovemysql,
                                fechadetprovemysql,
                                new ProveedorDTO(txtNombre.getText())
                        );
                        result = DetalleProveedorBL.getInstance().insert(detalleProveedor);
                        if(!result) Messages.messageError("Error al insertar detalle de proveedor");
                        else Messages.messageInsert();
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregaActionPerformed

    void ActivaProve() {
        txtRuc.setText("");
        txtRuc.requestFocus();
        txtNombre.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtWeb.setText("");
        btnAgrega.setEnabled(true);
        btnModifica.setEnabled(false);
        btnDesactivar.setEnabled(false);
        btnCancel.setEnabled(false);
    }

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        inicializarVariables();
        try {
            detalleProveedor = new DetalleProveedorDTO(
                    fechaFinProveedor,
                    new ProveedorDTO(tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 0).toString())
            );
            DetalleProveedorBL.getInstance().update(detalleProveedor);
            eliminaProveedor(tblProveedor.getSelectedRow(), 0);            
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = "https://login.live.com/login.srf?wa=wsignin1.0&ct=1428133927&rver=6.1.6206.0&sa=1&ntprob=-1&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fmail.live.com%2F%3Fowa%3D1%26owasuffix%3Dowa%252f&id=64855&snsc=1&cbcxt=mail";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {      }
    }//GEN-LAST:event_btnEmailActionPerformed

    boolean esRepetidoProveedor(String nombreProve) {
        proveedor = null;
        try {
            proveedor = ProveedorBL.getInstance().getById(nombreProve);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        return proveedor != null;
    }
    
    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        inicializarVariables();
        if (txtRuc.getText().equals("") || txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtNombre.getText().equals(tblProveedor.getValueAt(filaProveedor, 0).toString())) {
                esRepetido = esRepetidoProveedor(txtNombre.getText()); 
            }
            if (esRepetido) {
                Messages.messageRepeat();
            } else {
                if (!txtDireccion.getText().equals("")) {         textdir = txtDireccion.getText();}
                if (!txtWeb.getText().equals("")) {               textweb = txtWeb.getText();       }
                if (!txtEmail.getText().equals("")) {             textmail = txtEmail.getText();}
                
                try {
                    proveedor = new ProveedorDTO(
                            txtNombre.getText(),
                            txtRuc.getText(),
                            textdir,
                            textweb,
                            textmail
                    );
                    result = ProveedorBL.getInstance().update(proveedor, tblProveedor.getValueAt(filaProveedor, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificaActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtWeb.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRucActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {      }
    }//GEN-LAST:event_btnRucActionPerformed

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = txtWeb.getText().trim();
        Browser.openURL("https://"+url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {      }
    }//GEN-LAST:event_btnWebActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        txtNombre.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        //validarCampos.soloNumeros(txtRuc);
        //validarCampos.cantCaracteres(txtRuc, 10);
    }//GEN-LAST:event_txtRucKeyPressed

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        tblProveedor.setRowSelectionAllowed(true);
        filaProveedor = tblProveedor.getSelectedRow();
        txtNombre.setText(tblProveedor.getValueAt(filaProveedor,0).toString());
        txtRuc.setText(tblProveedor.getValueAt(filaProveedor,1).toString());
        txtDireccion.setText(tblProveedor.getValueAt(filaProveedor, 2).toString());
        txtEmail.setText(tblProveedor.getValueAt(filaProveedor,3).toString());
        txtWeb.setText(tblProveedor.getValueAt(filaProveedor, 4).toString());
        panelRegistro.setVisible(true);
        txtRuc.requestFocus();
        panelVista.setVisible(false);
        btnTiempoActivo.setEnabled(true);
        btnAgrega.setEnabled(false);
        btnModifica.setEnabled(true);
        btnDesactivar.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        ImageIcon nuevo = new ImageIcon("src/com/admin/resource/images/docs.png");
        panelVista.setVisible(false);
        btnTiempoActivo.setEnabled(false);
        tblProveedor.setRowSelectionAllowed(false);
        btnAgrega.setText("Nuevo");
        btnAgrega.setIcon(nuevo);
        panelRegistro.setVisible(false);
        ActivaProve();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnTiempoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiempoActivoActionPerformed
        panelVista.setVisible(true);
        mostrarTiempo(tblProveedor.getValueAt(filaProveedor, 0).toString());
    }//GEN-LAST:event_btnTiempoActivoActionPerformed

    private void txtBuscarRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarRucKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtBuscarRucKeyReleased

    public void eliminaProveedor(int fila, int status) throws SQLException {
        inicializarVariables();
        if (fila < 0) {
            Messages.messageSelected();
        } else {
            proveedor = new ProveedorDTO(tblProveedor.getValueAt(fila, 0).toString());
            if (status == 0) {
                pregunta = Messages.messageDeactive();
                if (pregunta == 0) {
                    
                    result = ProveedorBL.getInstance().delete(proveedor, status);
                    if (result) {
                        Messages.messageDelete();
                        verificarParametros();
                    } else {     Messages.messageErrorDelete();       }
                }
            } else {
                pregunta = Messages.messageActive();
                if (pregunta == 0) {
                    result = ProveedorBL.getInstance().delete(proveedor, status);
                    if (result) {
                        Messages.messageUnDelete();
                        verificarParametros();
                    } else {     Messages.messageErrorUnDelete();       }
                }
            }
        }
    }
    
    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        inicializarVariables();
        try {
            detalleProveedor = new DetalleProveedorDTO(
                    fechaInicioProveedor,
                    new ProveedorDTO(tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 0).toString())
            );
            DetalleProveedorBL.getInstance().insert(detalleProveedor);
            eliminaProveedor(tblProveedor.getSelectedRow(), 1);    
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void lblTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTodosMouseClicked
        lblTodos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblTodos.setForeground(Color.blue);
        lblActivos.setForeground(Color.black);
        lblInactivos.setForeground(Color.black);        
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
        }
    }//GEN-LAST:event_lblTodosMouseExited

    private void lblActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActivosMouseClicked
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
        lblActivos.setForeground(Color.blue);
        lblInactivos.setForeground(Color.black);
        lblTodos.setForeground(Color.black);    
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (filaProveedor >= 0) {
            if (tblProveedor.getValueAt(filaProveedor, 5).toString().equals("Inactivo")) {
                Messages.messageAlert("No puedes seleccionar un proveedor desactivado, debes activarlo nuevamente.");
            } else {
                if (isFrame == 1) {
                    Productos_CRUDPadreDialog.txtProveedor.setText(tblProveedor.getValueAt(filaProveedor, 0).toString());
                } else {
                    Productos_CRUDPadreFrame.txtProveedor.setText(tblProveedor.getValueAt(filaProveedor, 0).toString());
                }
                this.dispose();
            }        
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Productos_CRUDProveedor dialog = new Productos_CRUDProveedor(new javax.swing.JDialog(), true);
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
    public static javax.swing.JButton btnAgrega;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEmail;
    public static javax.swing.JButton btnModifica;
    private javax.swing.JButton btnRuc;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnTiempoActivo;
    private javax.swing.JButton btnWeb;
    private static javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBuscarNombre;
    private javax.swing.JLabel lblBuscarRuc;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private static javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTitulo;
    private static javax.swing.JLabel lblTodos;
    private javax.swing.JLabel lblWeb;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JPanel panelVista;
    private javax.swing.JScrollPane scrollProveedor;
    private javax.swing.JScrollPane scrollTiempo;
    public static javax.swing.JTable tblProveedor;
    private javax.swing.JTable tblTiempoTrabajo;
    private static Folder.DJCTextFieldWithoutPop txtBuscarNombre;
    private static Folder.DJCTextFieldWithoutPop txtBuscarRuc;
    public static Folder.DJCTextFieldWithoutPop txtDireccion;
    public static Folder.DJCTextFieldWithoutPop txtEmail;
    public static Folder.DJCTextFieldWithoutPop txtNombre;
    public static Folder.DJCTextFieldWithoutPop txtRuc;
    public static Folder.DJCTextFieldWithoutPop txtWeb;
    // End of variables declaration//GEN-END:variables
}
