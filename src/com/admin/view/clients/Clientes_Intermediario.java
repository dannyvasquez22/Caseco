package com.admin.view.clients;

import com.admin.controller.tablemodel.TEmpleadoTratar;
import com.admin.controller.tablemodel.TTelefonoEmpleadoTratar;
import com.admin.model.bl.EmpleadoTratarBL;
import com.admin.model.bl.TelefonoBL;
import com.admin.model.dto.ClienteDTO;
import com.admin.model.dto.EmpleadoTratarDTO;
import com.admin.model.dto.TelefonoDTO;
import com.admin.model.pojo.TelefonoEmpleadoTratarP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.apache.log4j.Logger;

public class Clientes_Intermediario extends javax.swing.JDialog {
    private static ArrayList<TelefonoEmpleadoTratarP> listTelefonosEmpleados = new ArrayList<>();
    private static ArrayList<EmpleadoTratarDTO> listEmpleadosTrato = new ArrayList<>();
    private EmpleadoTratarDTO empleadoTratar = null;
    private TelefonoDTO telefono = null;
    private int filaEmpleadoTratar, filaTelefonoEmpleado, codigoEmpleado;
    private static ArrayList<String> nombreReferencia;
    public static String codigoCliente;
    private boolean esRepetido = false;
    private boolean result = false;    
    private boolean telefonoIncluido = false; // valor para determinar si el intermediario a elminar tiene telefono agregados.
    private int eliminaTelefonoIncluido;
    private int pregunta;
    private int codEmpleado;
    private String []registroIntermediario;
    private String []registroTelefonoIntermediario;
    final static Logger logger = Logger.getLogger(Clientes_Intermediario.class);

    public Clientes_Intermediario(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Intermediarios de Clientes para Factura");
    }

    public static void listarEmpleadosTratar(String tipoReferencia, String referencia) throws SQLException {
        listEmpleadosTrato.clear();
        listEmpleadosTrato = EmpleadoTratarBL.getInstance().listAll(Integer.parseInt(referencia));
        tblIntermediario.setModel(new TEmpleadoTratar(listEmpleadosTrato));
        ConfigTables.headerTables(tblIntermediario);
        ConfigTables.sizeEmployeeTry(tblIntermediario);
        
        listarMovilEmpleados("EMPLEADO_TRATAR", referencia);        
    }
    
    public static void listarMovilEmpleados(String tipoReferencia, String referencia) throws SQLException {
        cargarComboReferencia();
        listTelefonosEmpleados.clear();
        listTelefonosEmpleados = TelefonoBL.getInstance().listEmployeeTry(tipoReferencia, referencia);
        tblMovilIntermediario.setModel(new TTelefonoEmpleadoTratar(listTelefonosEmpleados));
        ConfigTables.headerTables(tblMovilIntermediario);
        ConfigTables.sizeCellphoneEmployeeTry(tblMovilIntermediario);
    }
    
    public static void cargarComboReferencia() {
        nombreReferencia = new ArrayList<>();
        try {
            nombreReferencia = EmpleadoTratarBL.getInstance().listNameByCombo(Integer.parseInt(codigoCliente));
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (String nombre : nombreReferencia) {
            modelo.addElement(nombre);
        } 
        boxReferencia.setModel(modelo);
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarIntermediario = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtDniIntermediario = new Folder.DJCTextFieldWithoutPop();
        lblClienteOrigen = new javax.swing.JLabel();
        scrollTelefonoIntermediario = new javax.swing.JScrollPane();
        tblMovilIntermediario = new javax.swing.JTable();
        boxTelefoniaIntermediario = new javax.swing.JComboBox();
        lblCliente = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        boxTipoTelefoniaIntermediario = new javax.swing.JComboBox();
        lblReferencia = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        txtNombreIntermediario = new Folder.DJCTextFieldWithoutPop();
        btnEliminarMovilIntermediario = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTelefonia = new javax.swing.JLabel();
        btnModificarIntermediario = new javax.swing.JButton();
        lblTipoTelefonia = new javax.swing.JLabel();
        btnEliminarIntermediario = new javax.swing.JButton();
        scrollIntermediario = new javax.swing.JScrollPane();
        tblIntermediario = new javax.swing.JTable();
        btnAgregarMovilIntermediario = new javax.swing.JButton();
        boxReferencia = new javax.swing.JComboBox();
        txtNumeroIntermediario = new Folder.DJCTextFieldWithoutPop();
        btnModificarMovilIntermediario = new javax.swing.JButton();
        btnSeleccionIntermediario = new javax.swing.JButton();
        lblMovilIntermediario = new javax.swing.JLabel();
        btnSeleccionMovilIntermediario = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblIntermediarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarIntermediario.setText("Agregar");
        btnAgregarIntermediario.setToolTipText("Botón para agregar un nuevo intermediario.");
        btnAgregarIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIntermediarioActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombres:");

        txtDniIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDniIntermediario.setPlaceholder("Sólo 8 dígitos.");

        lblClienteOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblClienteOrigen.setText(".");

        tblMovilIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblMovilIntermediario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblMovilIntermediario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblMovilIntermediario.getTableHeader().setReorderingAllowed(false);
        tblMovilIntermediario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMovilIntermediarioMouseClicked(evt);
            }
        });
        scrollTelefonoIntermediario.setViewportView(tblMovilIntermediario);

        boxTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Claro", "Movistar", "Entel", "Bitel" }));

        lblCliente.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblCliente.setText("Cliente:");

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("(*) Número:");

        boxTipoTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Postpago", "Prepago" }));

        lblReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblReferencia.setText("(*) Referencia:");

        lblDni.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDni.setText("DNI: ");

        txtNombreIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombreIntermediario.setPlaceholder("Escribir aquí los nombres del intermediario.");

        btnEliminarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarMovilIntermediario.setText("Eliminar");
        btnEliminarMovilIntermediario.setToolTipText("Botón para eliminar el teléfono seleccionado de intermediario.");
        btnEliminarMovilIntermediario.setEnabled(false);
        btnEliminarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovilIntermediarioActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de intermediarios.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

        btnModificarIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarIntermediario.setText("Modificar");
        btnModificarIntermediario.setToolTipText("Botón para modificar el intermediario seleccionado.");
        btnModificarIntermediario.setEnabled(false);
        btnModificarIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarIntermediarioActionPerformed(evt);
            }
        });

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        btnEliminarIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarIntermediario.setText("Eliminar");
        btnEliminarIntermediario.setToolTipText("Botón para eliminar el intermediario seleccionado.");
        btnEliminarIntermediario.setEnabled(false);
        btnEliminarIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIntermediarioActionPerformed(evt);
            }
        });

        tblIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblIntermediario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblIntermediario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblIntermediario.getTableHeader().setReorderingAllowed(false);
        tblIntermediario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIntermediarioMouseClicked(evt);
            }
        });
        scrollIntermediario.setViewportView(tblIntermediario);

        btnAgregarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarMovilIntermediario.setText("Agregar");
        btnAgregarMovilIntermediario.setToolTipText("Botón para agregar un nuevo teléfono de intermediario.");
        btnAgregarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMovilIntermediarioActionPerformed(evt);
            }
        });

        boxReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        txtNumeroIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnModificarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarMovilIntermediario.setText("Modificar");
        btnModificarMovilIntermediario.setToolTipText("Botón para modificar el teléfono seleccionado de itnermediario.");
        btnModificarMovilIntermediario.setEnabled(false);
        btnModificarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMovilIntermediarioActionPerformed(evt);
            }
        });

        btnSeleccionIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionIntermediario.setText("Quitar selección");
        btnSeleccionIntermediario.setToolTipText("Botón para quitar la seleción del intermediario seleccionado.");
        btnSeleccionIntermediario.setEnabled(false);
        btnSeleccionIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionIntermediarioActionPerformed(evt);
            }
        });

        lblMovilIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMovilIntermediario.setText("Ubicación móvil de Intermediarios:");

        btnSeleccionMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionMovilIntermediario.setText("Quitar selección");
        btnSeleccionMovilIntermediario.setToolTipText("Botón para quitar la selección del teléfono seleccionado de intermediario.");
        btnSeleccionMovilIntermediario.setEnabled(false);
        btnSeleccionMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionMovilIntermediarioActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblIntermediarios.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblIntermediarios.setText("Intermediarios:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTelefonoIntermediario)
                    .addComponent(scrollIntermediario)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(10, 10, 10)
                                .addComponent(lblClienteOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblIntermediarios)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(btnModificarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(btnEliminarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnSeleccionIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMovilIntermediario)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblReferencia)
                                .addGap(4, 4, 4)
                                .addComponent(boxReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefonia)
                                .addGap(34, 34, 34)
                                .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(lblTipoTelefonia)
                                .addGap(4, 4, 4)
                                .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(lblNumero)
                                .addGap(10, 10, 10)
                                .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAviso)
                                .addGap(418, 418, 418)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregarMovilIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblClienteOrigen)))
                .addGap(6, 6, 6)
                .addComponent(lblIntermediarios)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDni)
                            .addComponent(lblNombre))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarIntermediario)
                    .addComponent(btnModificarIntermediario)
                    .addComponent(btnEliminarIntermediario)
                    .addComponent(btnSeleccionIntermediario))
                .addGap(6, 6, 6)
                .addComponent(scrollIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblMovilIntermediario)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblReferencia))
                    .addComponent(boxReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefonia)
                            .addComponent(lblTipoTelefonia)
                            .addComponent(lblNumero))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarMovilIntermediario)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarMovilIntermediario)
                        .addComponent(btnSeleccionMovilIntermediario)
                        .addComponent(btnModificarMovilIntermediario)))
                .addGap(6, 6, 6)
                .addComponent(scrollTelefonoIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        empleadoTratar = null;
        telefono = null;
        telefonoIncluido = false;
        codEmpleado = 0;
        registroIntermediario = new String [2];
        registroIntermediario[0] = "-";
        registroIntermediario[1] = "";
        registroTelefonoIntermediario = new String[4];
        registroTelefonoIntermediario[0] = "";
        registroTelefonoIntermediario[1] = "";
        registroTelefonoIntermediario[2] = "";
        registroTelefonoIntermediario[3] = "";
    }
    
    private void btnAgregarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIntermediarioActionPerformed
        inicializarVariables();
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {     registroIntermediario[0] = txtDniIntermediario.getText();   }
            registroIntermediario[1] = txtNombreIntermediario.getText();
            
            for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                if (!registroIntermediario[0].equals("-")) {
                    if (registroIntermediario[0].equals(tblIntermediario.getValueAt(cont, 1).toString()) &&
                            registroIntermediario[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                        esRepetido = true;
                    }
                } else {
                    if (registroIntermediario[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {               
                try {
                    empleadoTratar = new EmpleadoTratarDTO(
                            registroIntermediario[0],
                            registroIntermediario[1],
                            new ClienteDTO(Integer.parseInt(codigoCliente))
                    );
                    result = EmpleadoTratarBL.getInstance().insert(empleadoTratar);
                    if (result) {
                        Messages.messageInsert();
                        cargarComboReferencia();
                        ActivaEmpleadoTratar();
                        listarEmpleadosTratar("CLIENTE", codigoCliente);
                    } else {
                        Messages.messageErrorInsert();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarIntermediarioActionPerformed

    private void tblMovilIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovilIntermediarioMouseClicked
        
    }//GEN-LAST:event_tblMovilIntermediarioMouseClicked

    private void btnEliminarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                telefono = new TelefonoDTO(
                        Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 0).toString())
                );
                result = TelefonoBL.getInstance().delete(telefono);
                if (result) {
                    Messages.messageDelete();
                    ActivaTelefonoEmpleado();
                    listarMovilEmpleados("EMPLEADO_TRATAR", codigoCliente);
                } else {
                    Messages.messageErrorDelete();
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarMovilIntermediarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarIntermediarioActionPerformed
        inicializarVariables();
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {         registroIntermediario[0] = txtDniIntermediario.getText();     }
            registroIntermediario[1] = txtNombreIntermediario.getText();
            
            for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                if (!registroIntermediario[0].equals("-")) {
                    if (registroIntermediario[0].equals(tblIntermediario.getValueAt(cont, 1).toString()) &&
                            registroIntermediario[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                        esRepetido = true;
                    }
                } else {
                    if (registroIntermediario[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    empleadoTratar = new EmpleadoTratarDTO(
                            Integer.parseInt(tblIntermediario.getValueAt(filaEmpleadoTratar ,0).toString()),
                            registroIntermediario[0],
                            registroIntermediario[1]
                    );
                    result = EmpleadoTratarBL.getInstance().update(empleadoTratar);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaEmpleadoTratar();
                        listarEmpleadosTratar("CLIENTE", codigoCliente);
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarIntermediarioActionPerformed

    private void btnEliminarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                    if (tblMovilIntermediario.getValueAt(co, 1).toString().equals(tblIntermediario.getValueAt(filaEmpleadoTratar, 2).toString())) {
                        telefonoIncluido = true;
                    }
                }

                if (telefonoIncluido == true) {
                    eliminaTelefonoIncluido = Messages.messageConfirmation("El intermediario tiene teléfono(s) almacenado(s), si continua se eliminara el intermediario junto con sus teléfonos.");
                    if (0 == eliminaTelefonoIncluido) {
                        empleadoTratar = new EmpleadoTratarDTO(Integer.parseInt(tblIntermediario.getValueAt(filaEmpleadoTratar, 0).toString()));
                        result = EmpleadoTratarBL.getInstance().delete(empleadoTratar);
                        if (result) {
                            Messages.messageDelete();
                            ActivaEmpleadoTratar();
                            listarEmpleadosTratar("CLIENTE", codigoCliente);
                        } else {
                            Messages.messageErrorDelete();
                        }
                    } else {
                        Messages.messageAlert("El intermediario no se elimino.");
                    }
                } else {
                    empleadoTratar = new EmpleadoTratarDTO(Integer.parseInt(tblIntermediario.getValueAt(filaEmpleadoTratar, 0).toString()));
                    result = EmpleadoTratarBL.getInstance().delete(empleadoTratar);
                    if (result) {
                        Messages.messageDelete();
                        ActivaEmpleadoTratar();
                        listarEmpleadosTratar("CLIENTE", codigoCliente);
                    } else {
                        Messages.messageErrorDelete();
                    }
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarIntermediarioActionPerformed

    private void tblIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIntermediarioMouseClicked
        tblIntermediario.setRowSelectionAllowed(true);
        filaEmpleadoTratar = tblIntermediario.getSelectedRow();
        if (tblIntermediario.getValueAt(filaEmpleadoTratar, 1) == null) {     txtDniIntermediario.setText("-");   }
        else{       txtDniIntermediario.setText(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString());   }
        txtNombreIntermediario.setText(tblIntermediario.getValueAt(filaEmpleadoTratar, 2).toString());
        btnAgregarIntermediario.setEnabled(false);
        btnModificarIntermediario.setEnabled(true);
        btnEliminarIntermediario.setEnabled(true);
        btnSeleccionIntermediario.setEnabled(true);
    }//GEN-LAST:event_tblIntermediarioMouseClicked

    private void btnAgregarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem().toString().equals("") || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroTelefonoIntermediario[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       registroTelefonoIntermediario[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   registroTelefonoIntermediario[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
                                                   registroTelefonoIntermediario[3] = txtNumeroIntermediario.getText();
            
            for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                if (registroTelefonoIntermediario[3].equals(tblMovilIntermediario.getValueAt(cont, 4).toString())) {
                    esRepetido = true;
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                        if ((boxReferencia.getSelectedItem().toString()).equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                            try {
                                codEmpleado = EmpleadoTratarBL.getInstance().listByDniByNombres(tblIntermediario.getValueAt(cont, 1).toString(),
                                        tblIntermediario.getValueAt(cont, 2).toString());
                            } catch (SQLException ex) {
                                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                                logger.error(ex);
                            }break;
                        }
                    }

                    telefono = new TelefonoDTO(
                            registroTelefonoIntermediario[1],
                            registroTelefonoIntermediario[2],
                            registroTelefonoIntermediario[3],
                            "EMPLEADO_TRATAR",
                            String.valueOf(codEmpleado)
                    );

                    result = TelefonoBL.getInstance().insert(telefono);
                    if (result) {
                        Messages.messageInsert();
                        ActivaTelefonoEmpleado();
                        listarMovilEmpleados("EMPLEADO_TRATAR", codigoCliente);
                    } else {
                        Messages.messageErrorInsert();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarMovilIntermediarioActionPerformed

    private void btnModificarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (txtNumeroIntermediario.getText().equals("") || boxReferencia.getSelectedItem().toString().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 4).toString().equals(registroTelefonoIntermediario[3])) {
                for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                    if (registroTelefonoIntermediario[3].equals(tblMovilIntermediario.getValueAt(cont, 4).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                registroTelefonoIntermediario[0] = boxReferencia.getSelectedItem().toString();
                if (boxTelefoniaIntermediario.getSelectedItem() != null) {       registroTelefonoIntermediario[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
                if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   registroTelefonoIntermediario[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
                                                   registroTelefonoIntermediario[3] = txtNumeroIntermediario.getText();
                
                try {
                    if (!registroTelefonoIntermediario[0].equals(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 1).toString())) {
                        for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                            if ((boxReferencia.getSelectedItem().toString()).equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                                try {
                                    codEmpleado = EmpleadoTratarBL.getInstance().listByDniByNombres(tblIntermediario.getValueAt(cont, 1).toString(),
                                            tblIntermediario.getValueAt(cont, 2).toString());
                                } catch (SQLException ex) {
                                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                                    logger.error(ex);
                                }break;
                            }                                
                        }
                        telefono = new TelefonoDTO(
                                Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 0).toString()),
                                registroTelefonoIntermediario[1],
                                registroTelefonoIntermediario[2],
                                registroTelefonoIntermediario[3],
                                "EMPLEADO_TRATAR",
                                String.valueOf(codEmpleado)
                        );
                    } else {                        
                        telefono = new TelefonoDTO(
                                    Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 0).toString()),
                                    registroTelefonoIntermediario[1],
                                    registroTelefonoIntermediario[2],
                                    registroTelefonoIntermediario[3]
                        );
                    }

                    result = TelefonoBL.getInstance().update(telefono);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaTelefonoEmpleado();
                        listarMovilEmpleados("EMPLEADO_TRATAR", codigoCliente);
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarMovilIntermediarioActionPerformed

    void ActivaEmpleadoTratar() {
        tblIntermediario.setRowSelectionAllowed(false);
        txtDniIntermediario.requestFocus();
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");
        btnAgregarIntermediario.setEnabled(true);
        btnModificarIntermediario.setEnabled(false);
        btnEliminarIntermediario.setEnabled(false);
        btnSeleccionIntermediario.setEnabled(false);
    }

    private void btnSeleccionIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionIntermediarioActionPerformed
        ActivaEmpleadoTratar();
    }//GEN-LAST:event_btnSeleccionIntermediarioActionPerformed

    void ActivaTelefonoEmpleado() {
        tblMovilIntermediario.setRowSelectionAllowed(false);
        boxReferencia.setSelectedItem(null);
        boxTelefoniaIntermediario.setSelectedItem(null);
        boxTipoTelefoniaIntermediario.setSelectedItem(null);
        txtNumeroIntermediario.setText("");
        btnAgregarMovilIntermediario.setEnabled(true);
        btnModificarMovilIntermediario.setEnabled(false);
        btnEliminarMovilIntermediario.setEnabled(false);
        btnSeleccionMovilIntermediario.setEnabled(false);
    }

    private void btnSeleccionMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionMovilIntermediarioActionPerformed
        ActivaTelefonoEmpleado();
    }//GEN-LAST:event_btnSeleccionMovilIntermediarioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes_Intermediario dialog = new Clientes_Intermediario(new javax.swing.JDialog(), true);
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
    public static javax.swing.JComboBox boxReferencia;
    public static javax.swing.JComboBox boxTelefoniaIntermediario;
    public static javax.swing.JComboBox boxTipoTelefoniaIntermediario;
    public static javax.swing.JButton btnAgregarIntermediario;
    public static javax.swing.JButton btnAgregarMovilIntermediario;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminarIntermediario;
    public static javax.swing.JButton btnEliminarMovilIntermediario;
    public static javax.swing.JButton btnModificarIntermediario;
    public static javax.swing.JButton btnModificarMovilIntermediario;
    private javax.swing.JButton btnSeleccionIntermediario;
    private javax.swing.JButton btnSeleccionMovilIntermediario;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCliente;
    public javax.swing.JLabel lblClienteOrigen;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblIntermediarios;
    private javax.swing.JLabel lblMovilIntermediario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JScrollPane scrollIntermediario;
    private javax.swing.JScrollPane scrollTelefonoIntermediario;
    public static javax.swing.JTable tblIntermediario;
    public static javax.swing.JTable tblMovilIntermediario;
    private static Folder.DJCTextFieldWithoutPop txtDniIntermediario;
    private static Folder.DJCTextFieldWithoutPop txtNombreIntermediario;
    public static Folder.DJCTextFieldWithoutPop txtNumeroIntermediario;
    // End of variables declaration//GEN-END:variables
}
