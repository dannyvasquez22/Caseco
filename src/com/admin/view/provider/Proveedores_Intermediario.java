package com.admin.view.provider;

import com.admin.controller.tablemodel.TTelefonoVendedor;
import com.admin.controller.tablemodel.TVendedor;
import com.admin.model.bl.TelefonoBL;
import com.admin.model.bl.VendedorBL;
import com.admin.model.dto.ProveedorDTO;
import com.admin.model.dto.TelefonoDTO;
import com.admin.model.dto.VendedorDTO;
import com.admin.model.pojo.TelefonoVendedorP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.apache.log4j.Logger;

public class Proveedores_Intermediario extends javax.swing.JDialog {
    private static ArrayList<VendedorDTO> listVendedores = new ArrayList<>();
    private static ArrayList<TelefonoVendedorP> listTelefonosVendedores = new ArrayList<>();
    private static TelefonoDTO telefono = null;
    private static VendedorDTO vendedor = null;
    private int filaTelefonoVendedor, filaVendedor;
    private int pregunta;
    private int codEmpleado;
    private String []registroIntermediario;
    private String []registroTelefonoIntermediario;
    public static String nombreProveedor;
    private boolean esRepetido = false;
    private boolean result = false;
    private boolean telefonoIncluido = false; // valor para determinar si el intermediario a elminar tiene telefono agregados.
    private int eliminaTelefonoIncluido;
    private static ArrayList<String> nombreReferencia;
    final static Logger logger = Logger.getLogger(Proveedores_Intermediario.class);

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Proveedores_Intermediario(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Intermediarios por Proveedor");
    }

    public static void listarVendedores(String tipoReferencia, String referencia) throws SQLException {
        listVendedores.clear();
        listVendedores = VendedorBL.getInstance().listAll(referencia);
        tblIntermediario.setModel(new TVendedor(listVendedores));
        ConfigTables.headerTables(tblIntermediario);
        ConfigTables.sizeSellerProvider(tblIntermediario);
        
        listarMovilVendedores("VENDEDOR", referencia);        
    }
    
    public static void listarMovilVendedores(String tipoReferencia, String referencia) throws SQLException {
        cargarComboReferencia();
        listTelefonosVendedores.clear();
        listTelefonosVendedores = TelefonoBL.getInstance().listSellerProvider(tipoReferencia, referencia);
        tblMovilIntermediario.setModel(new TTelefonoVendedor(listTelefonosVendedores));
        ConfigTables.headerTables(tblMovilIntermediario);
        ConfigTables.sizeCellphoneSellerProvider(tblMovilIntermediario);
    }
    
    public static void cargarComboReferencia() {
        nombreReferencia = new ArrayList<>();
        try {
            nombreReferencia = VendedorBL.getInstance().listNameByCombo(nombreProveedor);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        nombreReferencia.forEach((nombre) -> {
            modelo.addElement(nombre);
        }); 
        boxReferencia.setModel(modelo);
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");
        txtCodAsignacion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProveedor = new javax.swing.JLabel();
        lblProveedorOrigen = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        btnModificarIntermediario = new javax.swing.JButton();
        lblDni = new javax.swing.JLabel();
        txtNombreIntermediario = new Folder.DJCTextFieldWithoutPop();
        txtDniIntermediario = new Folder.DJCTextFieldWithoutPop();
        scrollIntermediario = new javax.swing.JScrollPane();
        tblIntermediario = new javax.swing.JTable();
        lblVendedores = new javax.swing.JLabel();
        btnAgregarIntermediario = new javax.swing.JButton();
        lblCodAsignacion = new javax.swing.JLabel();
        txtCodAsignacion = new Folder.DJCTextFieldWithoutPop();
        btnEliminarIntermediario = new javax.swing.JButton();
        btnSeleccionIntermediario = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        scrollMovilIntermediario = new javax.swing.JScrollPane();
        tblMovilIntermediario = new javax.swing.JTable();
        lblTelefonia = new javax.swing.JLabel();
        btnEliminarMovilIntermediario = new javax.swing.JButton();
        boxTipoTelefoniaIntermediario = new javax.swing.JComboBox();
        lblTipoTelefonia = new javax.swing.JLabel();
        btnAgregarMovilIntermediario = new javax.swing.JButton();
        lblReferencia = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumeroIntermediario = new Folder.DJCTextFieldWithoutPop();
        btnSeleccionMovilIntermediario = new javax.swing.JButton();
        boxTelefoniaIntermediario = new javax.swing.JComboBox();
        btnModificarMovilIntermediario = new javax.swing.JButton();
        boxReferencia = new javax.swing.JComboBox();
        lblMovilIntermediario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProveedor.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblProveedor.setText("Proveedor:");

        lblProveedorOrigen.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProveedorOrigen.setText(".");

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de intermediarios.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombres:");

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

        lblDni.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDni.setText("Dni: ");

        txtNombreIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombreIntermediario.setPlaceholder("Escribir aquí los nombres del intermediario.");

        txtDniIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDniIntermediario.setPlaceholder("Sólo 8 dígitos.");

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

        lblVendedores.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblVendedores.setText("Vendedores como Intermediarios:");

        btnAgregarIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarIntermediario.setText("Agregar");
        btnAgregarIntermediario.setToolTipText("Botón para agregar un nuevo intermediario.");
        btnAgregarIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIntermediarioActionPerformed(evt);
            }
        });

        lblCodAsignacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodAsignacion.setText("Codigo Asignación:");

        txtCodAsignacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

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

        btnSeleccionIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionIntermediario.setText("Quitar selección");
        btnSeleccionIntermediario.setToolTipText("Botón para quitar la selección del intermediario seleccionado.");
        btnSeleccionIntermediario.setEnabled(false);
        btnSeleccionIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionIntermediarioActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

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
        scrollMovilIntermediario.setViewportView(tblMovilIntermediario);

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

        btnEliminarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarMovilIntermediario.setText("Eliminar");
        btnEliminarMovilIntermediario.setToolTipText("Botón para eliminar el teléfono seleccionado del intermediario.");
        btnEliminarMovilIntermediario.setEnabled(false);
        btnEliminarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovilIntermediarioActionPerformed(evt);
            }
        });

        boxTipoTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Postpago", "Prepago" }));

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        btnAgregarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarMovilIntermediario.setText("Agregar");
        btnAgregarMovilIntermediario.setToolTipText("Botón para agregar un nuevo teléfono de intermediario.");
        btnAgregarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMovilIntermediarioActionPerformed(evt);
            }
        });

        lblReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblReferencia.setText("Referencia:");

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("(*) Número:");

        txtNumeroIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnSeleccionMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionMovilIntermediario.setText("Quitar selección");
        btnSeleccionMovilIntermediario.setToolTipText("Botón para quitar la selección del teléfono seleccionado del intermediario.");
        btnSeleccionMovilIntermediario.setEnabled(false);
        btnSeleccionMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionMovilIntermediarioActionPerformed(evt);
            }
        });

        boxTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Claro", "Movistar", "Entel", "Bitel" }));

        btnModificarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarMovilIntermediario.setText("Modificar");
        btnModificarMovilIntermediario.setToolTipText("Botón para modificar el teléfono seleccionado del intermediario.");
        btnModificarMovilIntermediario.setEnabled(false);
        btnModificarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMovilIntermediarioActionPerformed(evt);
            }
        });

        boxReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblMovilIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMovilIntermediario.setText("Ubicación móvil de Intermediario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarMovilIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProveedor)
                        .addGap(28, 28, 28)
                        .addComponent(lblProveedorOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollMovilIntermediario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollIntermediario)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblDni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCodAsignacion)
                                .addGap(60, 60, 60)
                                .addComponent(txtCodAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefonia)
                            .addComponent(lblReferencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTipoTelefonia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxReferencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVendedores)
                            .addComponent(lblMovilIntermediario))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProveedor)
                    .addComponent(lblProveedorOrigen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVendedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodAsignacion)
                    .addComponent(txtCodAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarIntermediario)
                    .addComponent(btnModificarIntermediario)
                    .addComponent(btnEliminarIntermediario)
                    .addComponent(btnSeleccionIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblMovilIntermediario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia)
                    .addComponent(boxReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonia)
                    .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoTelefonia)
                    .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMovilIntermediario)
                    .addComponent(btnModificarMovilIntermediario)
                    .addComponent(btnEliminarMovilIntermediario)
                    .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        vendedor = null;
        codEmpleado = 0;
        telefonoIncluido = false;
        registroIntermediario = new String[3];
        registroIntermediario[0] = "-";
        registroIntermediario[1] = "";
        registroIntermediario[2] = "-";
        registroTelefonoIntermediario = new String[4];
        registroTelefonoIntermediario[0] = "";
        registroTelefonoIntermediario[1] = "";
        registroTelefonoIntermediario[2] = "";
        registroTelefonoIntermediario[3] = "";
    }
    
    private void btnModificarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarIntermediarioActionPerformed
        inicializarVariables();
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {        registroIntermediario[0] = txtDniIntermediario.getText();     }
                                                                    registroIntermediario[1] = txtNombreIntermediario.getText();
            if (!txtCodAsignacion.getText().equals("")) {           registroIntermediario[2] = txtCodAsignacion.getText(); }
            
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
                    vendedor = new VendedorDTO(
                            Integer.parseInt(tblIntermediario.getValueAt(filaVendedor ,0).toString()),
                            registroIntermediario[0],
                            registroIntermediario[1],
                            registroIntermediario[2]
                    );
                    result = VendedorBL.getInstance().update(vendedor);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaVendedor();
                        listarVendedores("PROVEEDOR", nombreProveedor);
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

    private void btnModificarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem().toString() == null || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroTelefonoIntermediario[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       
                registroTelefonoIntermediario[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   
                registroTelefonoIntermediario[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
            registroTelefonoIntermediario[3] = txtNumeroIntermediario.getText();
            
            if (!tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 4).toString().equals(registroTelefonoIntermediario[3])) {
                for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                    if (registroTelefonoIntermediario[3].equals(tblMovilIntermediario.getValueAt(cont, 4).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    if (!registroTelefonoIntermediario[0].equals(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 1).toString())) {
                        for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                            if ((boxReferencia.getSelectedItem().toString()).equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                                try {
                                    codEmpleado = VendedorBL.getInstance().getByDniByNombresByCodigo(tblIntermediario.getValueAt(cont, 1).toString(),
                                            tblIntermediario.getValueAt(cont, 2).toString(),
                                            tblIntermediario.getValueAt(cont, 3).toString());
                                } catch (SQLException ex) {
                                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                                    logger.error(ex);
                                }break;
                            }                                
                        }
                        telefono = new TelefonoDTO(
                                Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 0).toString()),
                                registroTelefonoIntermediario[1],
                                registroTelefonoIntermediario[2],
                                registroTelefonoIntermediario[3],
                                "VENDEDOR",
                                String.valueOf(codEmpleado)
                        );
                    } else {                        
                        telefono = new TelefonoDTO(
                                    Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 0).toString()),
                                    registroTelefonoIntermediario[1],
                                    registroTelefonoIntermediario[2],
                                    registroTelefonoIntermediario[3]
                        );
                    }

                    result = TelefonoBL.getInstance().update(telefono);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaTelefonoVendedor();
                        listarMovilVendedores("VENDEDOR", nombreProveedor);
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

    private void tblIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIntermediarioMouseClicked
        tblIntermediario.setRowSelectionAllowed(true);
        filaVendedor = tblIntermediario.getSelectedRow();
        if (tblIntermediario.getValueAt(filaVendedor, 1) == null) {     txtDniIntermediario.setText("-");   }
        else{       txtDniIntermediario.setText(tblIntermediario.getValueAt(filaVendedor, 1).toString());   }
        txtNombreIntermediario.setText(tblIntermediario.getValueAt(filaVendedor, 2).toString());
        if (tblIntermediario.getValueAt(filaVendedor, 3) == null) {    txtCodAsignacion.setText("-");                  }
        else{      txtCodAsignacion.setText(tblIntermediario.getValueAt(filaVendedor, 3).toString());                  }
        btnAgregarIntermediario.setEnabled(false);
        btnModificarIntermediario.setEnabled(true);
        btnEliminarIntermediario.setEnabled(true);
        btnSeleccionIntermediario.setEnabled(true);
    }//GEN-LAST:event_tblIntermediarioMouseClicked

    private void tblMovilIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovilIntermediarioMouseClicked
        tblMovilIntermediario.setRowSelectionAllowed(true);
        filaTelefonoVendedor = tblMovilIntermediario.getSelectedRow();
        boxReferencia.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 1).toString());
        if (tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 2) == null) {
            boxTelefoniaIntermediario.setSelectedItem(null);
        } else {
            boxTelefoniaIntermediario.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 2).toString());
        }
        if (tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 3) == null) {
            boxTipoTelefoniaIntermediario.setSelectedItem(null);
        } else {
            boxTipoTelefoniaIntermediario.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 3).toString());
        }
        txtNumeroIntermediario.setText(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 4).toString());

        btnAgregarMovilIntermediario.setEnabled(false);
        btnModificarMovilIntermediario.setEnabled(true);
        btnEliminarMovilIntermediario.setEnabled(true);
        btnSeleccionMovilIntermediario.setEnabled(true);
    }//GEN-LAST:event_tblMovilIntermediarioMouseClicked

    private void btnEliminarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                telefono = new TelefonoDTO(
                        Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 0).toString())
                );
                result = TelefonoBL.getInstance().delete(telefono);
                if (result) {
                    Messages.messageDelete();
                    ActivaTelefonoVendedor();
                    listarMovilVendedores("VENDEDOR", nombreProveedor);
                } else {
                    Messages.messageErrorDelete();
                }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarMovilIntermediarioActionPerformed

    private void btnAgregarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIntermediarioActionPerformed
        inicializarVariables();
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {    registroIntermediario[0] = txtDniIntermediario.getText();   }
                                                                registroIntermediario[1] = txtNombreIntermediario.getText();
            if (!txtCodAsignacion.getText().equals("")) {       registroIntermediario[2] = txtCodAsignacion.getText();       }
            
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
                    vendedor = new VendedorDTO(
                            registroIntermediario[0],
                            registroIntermediario[1],
                            registroIntermediario[2],
                            new ProveedorDTO(nombreProveedor)
                    );
                    result = VendedorBL.getInstance().insert(vendedor);
                    if (result) {
                        Messages.messageInsert();
                        cargarComboReferencia();
                        ActivaVendedor();
                        listarVendedores("PROVEEDOR", nombreProveedor);
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

    private void btnAgregarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem() == null || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroTelefonoIntermediario[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       
                registroTelefonoIntermediario[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   
                registroTelefonoIntermediario[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
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
                                codEmpleado = VendedorBL.getInstance().getByDniByNombresByCodigo(tblIntermediario.getValueAt(cont, 1).toString(),
                                        tblIntermediario.getValueAt(cont, 2).toString(),
                                        tblIntermediario.getValueAt(cont, 3).toString());
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
                            "VENDEDOR",
                            String.valueOf(codEmpleado)
                    );

                    result = TelefonoBL.getInstance().insert(telefono);
                    if (result) {
                        Messages.messageInsert();
                        ActivaTelefonoVendedor();
                        listarMovilVendedores("VENDEDOR", nombreProveedor);
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

    private void btnEliminarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            try {
                for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                    if (tblMovilIntermediario.getValueAt(co, 1).toString().equals(tblIntermediario.getValueAt(filaVendedor, 2).toString())) {
                        telefonoIncluido = true;
                    }
                }

                if (telefonoIncluido == true) {
                    eliminaTelefonoIncluido = Messages.messageConfirmation("El intermediario tiene teléfono(s) almacenado(s), si continua se eliminara el intermediario junto con sus teléfonos.");
                    if (0 == eliminaTelefonoIncluido) {
                        vendedor = new VendedorDTO(Integer.parseInt(tblIntermediario.getValueAt(filaVendedor, 0).toString()));
                        result = VendedorBL.getInstance().delete(vendedor);
                        if (result) {
                            Messages.messageDelete();
                            ActivaVendedor();
                            listarVendedores("PROVEEDOR", nombreProveedor);
                        } else {
                            Messages.messageErrorDelete();
                        }
                    } else {
                        Messages.messageAlert("El intermediario no se elimino.");
                    }
                } else {
                    vendedor = new VendedorDTO(Integer.parseInt(tblIntermediario.getValueAt(filaVendedor, 0).toString()));
                    result = VendedorBL.getInstance().delete(vendedor);
                    if (result) {
                        Messages.messageDelete();
                        ActivaVendedor();
                        listarVendedores("PROVEEDOR", nombreProveedor);
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

    void ActivaVendedor() {
        tblIntermediario.setRowSelectionAllowed(false);
        txtNombreIntermediario.requestFocus();
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");
        txtCodAsignacion.setText("");
        btnAgregarIntermediario.setEnabled(true);
        btnModificarIntermediario.setEnabled(false);
        btnEliminarIntermediario.setEnabled(false);
        btnSeleccionIntermediario.setEnabled(false);
    }

    private void btnSeleccionIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionIntermediarioActionPerformed
        ActivaVendedor();
    }//GEN-LAST:event_btnSeleccionIntermediarioActionPerformed

    void ActivaTelefonoVendedor() {
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
        ActivaTelefonoVendedor();
    }//GEN-LAST:event_btnSeleccionMovilIntermediarioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Proveedores_Intermediario dialog = new Proveedores_Intermediario(new javax.swing.JDialog(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
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
    private javax.swing.JLabel lblCodAsignacion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblMovilIntermediario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblProveedor;
    public static javax.swing.JLabel lblProveedorOrigen;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JLabel lblVendedores;
    private javax.swing.JScrollPane scrollIntermediario;
    private javax.swing.JScrollPane scrollMovilIntermediario;
    public static javax.swing.JTable tblIntermediario;
    public static javax.swing.JTable tblMovilIntermediario;
    public static Folder.DJCTextFieldWithoutPop txtCodAsignacion;
    private static Folder.DJCTextFieldWithoutPop txtDniIntermediario;
    private static Folder.DJCTextFieldWithoutPop txtNombreIntermediario;
    public static Folder.DJCTextFieldWithoutPop txtNumeroIntermediario;
    // End of variables declaration//GEN-END:variables
}
