package com.admin.view.provider;

import com.admin.controller.tablemodel.TCuenta;
import com.admin.controller.tablemodel.TObservacion;
import com.admin.controller.tablemodel.TTelefono;
import com.admin.controller.tablemodel.TTelefonoVendedor;
import com.admin.controller.tablemodel.TVendedor;
import com.admin.model.bl.CuentaBancariaBL;
import com.admin.model.bl.DetalleProveedorBL;
import com.admin.model.bl.ObservacionBL;
import com.admin.model.bl.ProveedorBL;
import com.admin.model.bl.TelefonoBL;
import com.admin.model.bl.VendedorBL;
import com.admin.model.dto.CuentaBancariaDTO;
import com.admin.model.dto.DetalleProveedorDTO;
import com.admin.model.dto.ObservacionDTO;
import com.admin.model.dto.ProveedorDTO;
import com.admin.model.dto.TelefonoDTO;
import com.admin.model.dto.VendedorDTO;
import com.admin.model.pojo.TelefonoVendedorP;
import com.admin.resource.utils.Browser;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Proveedores_CRUDPadreDialog extends javax.swing.JDialog {
    private static DefaultTableModel modeloTelefono, modeloCuenta, modeloObservacion, modeloVendedor, modeloTelefonoVendedor;
    private int filaTelefono, filaCuenta, filaVendedor, filaTelefonoVendedor, filaObservacion;
    public static int crudModificar = 0;
    public static String nombreProveedor;
    private boolean esRepetido = false;
    private boolean result = false;
    private static ArrayList<TelefonoDTO> listTelefonos = new ArrayList<>();
    private static ArrayList<VendedorDTO> listVendedores = new ArrayList<>();
    private static TelefonoDTO telefono = null;
    private static ObservacionDTO observacion = null;
    private static CuentaBancariaDTO cuenta = null;
    private static VendedorDTO vendedor = null;
    private static ProveedorDTO proveedor = null;
    private static DetalleProveedorDTO detalleProveedor = null;
    private static ArrayList<TelefonoVendedorP> listTelefonosVendedores = new ArrayList<>();
    private static ArrayList<ObservacionDTO> listObservaciones = new ArrayList<>();
    private static ArrayList<CuentaBancariaDTO> listCuentas = new ArrayList<>();
    private static ArrayList<String> nombreReferencia;
    private String textdir = "-", textweb = "-", textmail = "-", fechadetprovemysql, telef, tiptelef, codEmpresa, recaudo, vdni, vcod;
    private String []registroTelefono;
    private String []registroCuenta;
    private String []registroVendedor;
    private String []registroTelefonoVendedor;
    private String []registroObservacion;
    private String browser , url;
    private int codEmpleado = 0;
    private int pregunta;
    private boolean telefonoIncluido = false; // valor para determinar si el intermediario a elminar tiene telefono agregados.
    private int eliminaTelefonoIncluido;
    final static Logger logger = Logger.getLogger(Proveedores_CRUDPadreDialog.class);

    public Proveedores_CRUDPadreDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        chooserFecha.setDateFormat(Global.FORMAT_DATE_CLIENT);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Gestión de Proveedores");
        txtRuc.requestFocus();
        modeloTablas();
    }

    public static void listarTelefonos(String tipoReferencia, String referencia) throws SQLException {
        listTelefonos.clear();
        listTelefonos = TelefonoBL.getInstance().listReference(tipoReferencia, referencia);
        tblTelefono.setModel(new TTelefono(listTelefonos));
        ConfigTables.headerTables(tblTelefono);
        ConfigTables.sizeCellphone(tblTelefono);
    }
    
    public static void listarObservaciones(String tipoReferencia, String referencia) throws SQLException {
        listObservaciones.clear();
        listObservaciones = ObservacionBL.getInstance().listReference(tipoReferencia, referencia);
        tblObservacion.setModel(new TObservacion(listObservaciones));
        ConfigTables.headerTables(tblObservacion);
        ConfigTables.sizeObservation(tblObservacion);
    }
        
    public static void listarCuentas(String tipoReferencia, String referencia) throws SQLException {
        listCuentas.clear();
        listCuentas = CuentaBancariaBL.getInstance().listAll(tipoReferencia, referencia);
        tblCuenta.setModel(new TCuenta(listCuentas));
        ConfigTables.headerTables(tblCuenta);
        ConfigTables.sizeAccount(tblCuenta);
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
        if (crudModificar == 0) {
            boxReferencia.addItem(txtNombreIntermediario.getText());
        } else {
            nombreReferencia = new ArrayList<>();
            try {
                nombreReferencia = VendedorBL.getInstance().listNameByCombo(nombreProveedor);
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                logger.error(ex);
            }
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            for (String nombre : nombreReferencia) {
                modelo.addElement(nombre);
            } 
            boxReferencia.setModel(modelo);
        }
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");
        txtCodAsignacion.setText("");
    }
    
    private void modeloTablas() {
        if (crudModificar == 0) {
            modeloTelefono = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] titulos = {"TELEFONÍA", "TIPO TELEFONÍA", "NÚMERO"};
            modeloTelefono.setColumnIdentifiers(titulos);
            tblTelefono.setModel(modeloTelefono);
            ConfigTables.headerTables(tblTelefono);
            ConfigTables.sizeModelCellphone(tblTelefono);

            modeloCuenta = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] title = {"N° CUENTA", "MONEDA", "BANCO", "CÓD. EMPRESA", "RECAUDO"};
            modeloCuenta.setColumnIdentifiers(title);
            tblCuenta.setModel(modeloCuenta);
            ConfigTables.headerTables(tblCuenta);
            ConfigTables.sizeModelAccount(tblCuenta);
            
            modeloVendedor = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] titulos2 = {"DNI", "NOMBRES", "CÓD ASIGNADO"};
            modeloVendedor.setColumnIdentifiers(titulos2);
            tblIntermediario.setModel(modeloVendedor);
            ConfigTables.headerTables(tblIntermediario);
            ConfigTables.sizeModelSellerProvider(tblIntermediario);

            modeloTelefonoVendedor = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] tit = {"REFERENCIA", "TELEFONÍA", "TIPO TELEFONÍA", "NÚMERO"};
            modeloTelefonoVendedor.setColumnIdentifiers(tit);
            tblMovilIntermediario.setModel(modeloTelefonoVendedor);
            ConfigTables.headerTables(tblMovilIntermediario);
            ConfigTables.sizeModelCellphoneSellerProvider(tblMovilIntermediario);

            modeloObservacion = new DefaultTableModel() {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                }};
            String[] titulo = {"FECHA", "OBSERVACIÓN"};
            modeloObservacion.setColumnIdentifiers(titulo);
            tblObservacion.setModel(modeloObservacion);
            ConfigTables.headerTables(tblObservacion);
            ConfigTables.sizeModelObservation(tblObservacion);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVerificaRuc = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtRuc = new Folder.DJCTextFieldWithoutPop();
        Pestañas = new org.matrix.BlackTabbedPane();
        panelUbicacionTelefonia = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        btnEmail = new javax.swing.JButton();
        txtEmail = new Folder.DJCTextFieldWithoutPop();
        txtWeb = new Folder.DJCTextFieldWithoutPop();
        lblWeb = new javax.swing.JLabel();
        btnWeb = new javax.swing.JButton();
        lblDireccion = new javax.swing.JLabel();
        lblTipoTelefonia = new javax.swing.JLabel();
        lblTelefonia = new javax.swing.JLabel();
        btnEliminarMovil = new javax.swing.JButton();
        scrollTelefono = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        lblNumero = new javax.swing.JLabel();
        btnAgregarMovil = new javax.swing.JButton();
        btnModificarMovil = new javax.swing.JButton();
        btnSeleccionMovil = new javax.swing.JButton();
        txtNumero = new Folder.DJCTextFieldWithoutPop();
        boxTipoTelefonia = new javax.swing.JComboBox();
        boxTelefonia = new javax.swing.JComboBox();
        lblUbicacionMovil = new javax.swing.JLabel();
        panelCuentaBancaria = new javax.swing.JPanel();
        lblRecaudo = new javax.swing.JLabel();
        lblMoneda = new javax.swing.JLabel();
        scrollCuentaBancaria = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        txtCuenta = new Folder.DJCTextFieldWithoutPop();
        lblCuenta = new javax.swing.JLabel();
        btnEliminarCuenta = new javax.swing.JButton();
        txtBanco = new Folder.DJCTextFieldWithoutPop();
        boxMonedas = new javax.swing.JComboBox();
        txtCodEmpresa = new Folder.DJCTextFieldWithoutPop();
        btnModificarCuenta = new javax.swing.JButton();
        btnSeleccionCuenta = new javax.swing.JButton();
        btnAgregarCuenta = new javax.swing.JButton();
        txtRecaudo = new Folder.DJCTextFieldWithoutPop();
        lblBanco = new javax.swing.JLabel();
        lblCodEmpresa = new javax.swing.JLabel();
        panelIntermediario = new javax.swing.JPanel();
        lblNombresIntermediario = new javax.swing.JLabel();
        btnModificarIntermediario = new javax.swing.JButton();
        lblDni = new javax.swing.JLabel();
        txtNombreIntermediario = new Folder.DJCTextFieldWithoutPop();
        txtCodAsignacion = new Folder.DJCTextFieldWithoutPop();
        btnAgregarIntermediario = new javax.swing.JButton();
        lblCodAsignacion = new javax.swing.JLabel();
        btnEliminarIntermediario = new javax.swing.JButton();
        scrollIntermediario = new javax.swing.JScrollPane();
        tblIntermediario = new javax.swing.JTable();
        txtDniIntermediario = new Folder.DJCTextFieldWithoutPop();
        btnSeleccionIntermediario = new javax.swing.JButton();
        boxTipoTelefoniaIntermediario = new javax.swing.JComboBox();
        lblTelefoniaIntermediario = new javax.swing.JLabel();
        btnModificarMovilIntermediario = new javax.swing.JButton();
        btnSeleccionMovilIntermediario = new javax.swing.JButton();
        lblReferencia = new javax.swing.JLabel();
        lblTipoTelefoniaIntermediario = new javax.swing.JLabel();
        btnEliminarMovilIntermediario = new javax.swing.JButton();
        lblNumeroIntermediario = new javax.swing.JLabel();
        txtNumeroIntermediario = new Folder.DJCTextFieldWithoutPop();
        boxTelefoniaIntermediario = new javax.swing.JComboBox();
        btnAgregarMovilIntermediario = new javax.swing.JButton();
        scrollTelefonoIntermediario = new javax.swing.JScrollPane();
        tblMovilIntermediario = new javax.swing.JTable();
        boxReferencia = new javax.swing.JComboBox();
        lblMovilIntermediario = new javax.swing.JLabel();
        lblIntermediarios = new javax.swing.JLabel();
        panelObservacion = new javax.swing.JPanel();
        btnEliminarObservacion = new javax.swing.JButton();
        btnModificarObservacion = new javax.swing.JButton();
        scrollTextObservacion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        lblDescripcion = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        chooserFecha = new datechooser.beans.DateChooserCombo();
        btnAgregarObservacion = new javax.swing.JButton();
        txtFechaObservacion = new Folder.DJCTextFieldWithoutPop();
        scrollTblObservacion = new javax.swing.JScrollPane();
        tblObservacion = new javax.swing.JTable();
        btnSeleccionObservacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGrabar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Save.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Botón para grabar un nuevo proveedor.");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, -1));

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de registro de proveedores.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 611, 160, -1));

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar al proveedor.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 260, -1));

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");
        getContentPane().add(lblAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 616, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("NUEVO PROVEEDOR");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 14, -1, -1));

        btnVerificaRuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnVerificaRuc.setToolTipText("Agregar");
        btnVerificaRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificaRucActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerificaRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 70, 35, 21));

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 73, -1, -1));

        lblRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRuc.setText("(*) RUC:");
        getContentPane().add(lblRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre del proveedor.");
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 417, 21));

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
        getContentPane().add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 70, 105, 21));

        Pestañas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Pestañas.setTabSelectedColor(new java.awt.Color(0, 153, 0));

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmail.setText("E-mail:");

        txtDireccion.setToolTipText("");
        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("Escribir aquí la dirección del proveedor.");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/email.png"))); // NOI18N
        btnEmail.setToolTipText("Botón para enviar mensaje.");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtEmail.setPlaceholder("Escribir aquí la dirección electrónica del proveedor.");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtWeb.setToolTipText("");
        txtWeb.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtWeb.setPlaceholder("Ejm: www.mipaginaweb.com.pe");

        lblWeb.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblWeb.setText("Web:");

        btnWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnWeb.setToolTipText("Botón para visualizar la web del proveedor.");
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText(" Telefonía:");

        btnEliminarMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarMovil.setText("Eliminar");
        btnEliminarMovil.setToolTipText("Botón para eliminar el teléfono seleccionado.");
        btnEliminarMovil.setEnabled(false);
        btnEliminarMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovilActionPerformed(evt);
            }
        });

        tblTelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTelefono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTelefono.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTelefono.getTableHeader().setReorderingAllowed(false);
        tblTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonoMouseClicked(evt);
            }
        });
        scrollTelefono.setViewportView(tblTelefono);

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("(*) Número:");

        btnAgregarMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarMovil.setText("Agregar");
        btnAgregarMovil.setToolTipText("Botón para agregar un nuevo teléfono.");
        btnAgregarMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMovilActionPerformed(evt);
            }
        });

        btnModificarMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarMovil.setText("Modificar");
        btnModificarMovil.setToolTipText("Botón para modificar el teléfono seleccionado.");
        btnModificarMovil.setEnabled(false);
        btnModificarMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMovilActionPerformed(evt);
            }
        });

        btnSeleccionMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionMovil.setText("Quitar selección");
        btnSeleccionMovil.setToolTipText("Botón para quitar la selección del teléfono seleccionado.");
        btnSeleccionMovil.setEnabled(false);
        btnSeleccionMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionMovilActionPerformed(evt);
            }
        });

        txtNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        boxTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "POSTPAGO", "PREPAGO" }));
        boxTipoTelefonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoTelefoniaActionPerformed(evt);
            }
        });

        boxTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CLARO", "MOVISTAR", "ENTEL", "BITEL" }));
        boxTelefonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTelefoniaActionPerformed(evt);
            }
        });

        lblUbicacionMovil.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblUbicacionMovil.setText("Ubicación Móvil");

        javax.swing.GroupLayout panelUbicacionTelefoniaLayout = new javax.swing.GroupLayout(panelUbicacionTelefonia);
        panelUbicacionTelefonia.setLayout(panelUbicacionTelefoniaLayout);
        panelUbicacionTelefoniaLayout.setHorizontalGroup(
            panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbicacionTelefoniaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbicacionTelefoniaLayout.createSequentialGroup()
                        .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(lblEmail)
                            .addComponent(lblWeb)
                            .addComponent(lblTelefonia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelUbicacionTelefoniaLayout.createSequentialGroup()
                                .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTipoTelefonia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumero)
                                .addGap(20, 20, 20)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelUbicacionTelefoniaLayout.createSequentialGroup()
                                    .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtWeb, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnWeb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelUbicacionTelefoniaLayout.createSequentialGroup()
                        .addComponent(btnAgregarMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelUbicacionTelefoniaLayout.createSequentialGroup()
                        .addComponent(lblUbicacionMovil)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelUbicacionTelefoniaLayout.setVerticalGroup(
            panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbicacionTelefoniaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblWeb)
                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(lblUbicacionMovil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonia)
                    .addComponent(lblTipoTelefonia)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUbicacionTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMovil)
                    .addComponent(btnModificarMovil)
                    .addComponent(btnEliminarMovil)
                    .addComponent(btnSeleccionMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Pestañas.addTab("Ubicación & Telefonía    ", panelUbicacionTelefonia);

        lblRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRecaudo.setText("Recaudo:");

        lblMoneda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMoneda.setText("(*) Moneda:");

        tblCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCuenta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCuenta.getTableHeader().setReorderingAllowed(false);
        tblCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuentaMouseClicked(evt);
            }
        });
        scrollCuentaBancaria.setViewportView(tblCuenta);

        txtCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
            }
        });

        lblCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCuenta.setText("(*) #Cuenta:");

        btnEliminarCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarCuenta.setText("Eliminar");
        btnEliminarCuenta.setToolTipText("Botón para eliminar la cuenta bancaria seleccionada.");
        btnEliminarCuenta.setEnabled(false);
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        txtBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBanco.setPlaceholder("Escribir aquí el nombre de la entidad bancaria.");
        txtBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBancoActionPerformed(evt);
            }
        });

        boxMonedas.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxMonedas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLES", "DOLARES", "EUROS" }));
        boxMonedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMonedasActionPerformed(evt);
            }
        });

        txtCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEmpresaActionPerformed(evt);
            }
        });

        btnModificarCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarCuenta.setText("Modificar");
        btnModificarCuenta.setToolTipText("Botón para modificar la cuenta bancaria seleccionada.");
        btnModificarCuenta.setEnabled(false);
        btnModificarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCuentaActionPerformed(evt);
            }
        });

        btnSeleccionCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionCuenta.setText("Quitar selección");
        btnSeleccionCuenta.setToolTipText("Botón para quitar la selección de la cuetnabancaria seleccionada.");
        btnSeleccionCuenta.setEnabled(false);
        btnSeleccionCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionCuentaActionPerformed(evt);
            }
        });

        btnAgregarCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarCuenta.setText("Agregar");
        btnAgregarCuenta.setToolTipText("Botón para agregar una nueva cuenta bancaria.");
        btnAgregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCuentaActionPerformed(evt);
            }
        });

        txtRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRecaudo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecaudoKeyPressed(evt);
            }
        });

        lblBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBanco.setText("(*) Entidad Bancaria:");

        lblCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodEmpresa.setText("Cód. Empresa:");

        javax.swing.GroupLayout panelCuentaBancariaLayout = new javax.swing.GroupLayout(panelCuentaBancaria);
        panelCuentaBancaria.setLayout(panelCuentaBancariaLayout);
        panelCuentaBancariaLayout.setHorizontalGroup(
            panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaBancariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaBancariaLayout.createSequentialGroup()
                        .addComponent(btnAgregarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollCuentaBancaria)
                    .addGroup(panelCuentaBancariaLayout.createSequentialGroup()
                        .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBanco)
                            .addComponent(lblCuenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCuentaBancariaLayout.createSequentialGroup()
                                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblMoneda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRecaudo)
                            .addComponent(lblCodEmpresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtRecaudo, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelCuentaBancariaLayout.setVerticalGroup(
            panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaBancariaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoneda)
                    .addComponent(lblCuenta)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodEmpresa)
                    .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecaudo)
                    .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBanco)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCuenta)
                    .addComponent(btnModificarCuenta)
                    .addComponent(btnEliminarCuenta)
                    .addComponent(btnSeleccionCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCuentaBancaria, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        Pestañas.addTab("Cuentas bancarias       ", panelCuentaBancaria);

        lblNombresIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombresIntermediario.setText("(*) Nombres:");

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
        txtNombreIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreIntermediarioActionPerformed(evt);
            }
        });

        txtCodAsignacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodAsignacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodAsignacionKeyPressed(evt);
            }
        });

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
        lblCodAsignacion.setText("Código de Asignación:");

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

        txtDniIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDniIntermediario.setPlaceholder("Sólo 8 dígitos.");
        txtDniIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniIntermediarioActionPerformed(evt);
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

        boxTipoTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Postpago", "Prepago" }));
        boxTipoTelefoniaIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoTelefoniaIntermediarioActionPerformed(evt);
            }
        });

        lblTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefoniaIntermediario.setText("Telefonía:");

        btnModificarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarMovilIntermediario.setText("Modificar");
        btnModificarMovilIntermediario.setToolTipText("Botón para modificar el teléfono seleccionado de intermediario.");
        btnModificarMovilIntermediario.setEnabled(false);
        btnModificarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMovilIntermediarioActionPerformed(evt);
            }
        });

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

        lblReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblReferencia.setText("Referencia: ");

        lblTipoTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefoniaIntermediario.setText("Tipo:");

        btnEliminarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarMovilIntermediario.setText("Eliminar");
        btnEliminarMovilIntermediario.setToolTipText("Botón para eliminar el teléfonoseleccionado de intermediario.");
        btnEliminarMovilIntermediario.setEnabled(false);
        btnEliminarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovilIntermediarioActionPerformed(evt);
            }
        });

        lblNumeroIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumeroIntermediario.setText("(*) Número:");

        txtNumeroIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNumeroIntermediario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroIntermediarioKeyPressed(evt);
            }
        });

        boxTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Claro", "Movistar", "Entel", "Bitel" }));
        boxTelefoniaIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTelefoniaIntermediarioActionPerformed(evt);
            }
        });

        btnAgregarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarMovilIntermediario.setText("Agregar");
        btnAgregarMovilIntermediario.setToolTipText("Botón para agregar un nuevo teléfono de intermediario.");
        btnAgregarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMovilIntermediarioActionPerformed(evt);
            }
        });

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

        boxReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxReferenciaActionPerformed(evt);
            }
        });

        lblMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblMovilIntermediario.setText("Ubicación móvil de Intermediarios:");

        lblIntermediarios.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblIntermediarios.setText("Vendedores como Intermediarios:");

        javax.swing.GroupLayout panelIntermediarioLayout = new javax.swing.GroupLayout(panelIntermediario);
        panelIntermediario.setLayout(panelIntermediarioLayout);
        panelIntermediarioLayout.setHorizontalGroup(
            panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIntermediarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIntermediarioLayout.createSequentialGroup()
                        .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIntermediarios)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIntermediarioLayout.createSequentialGroup()
                                .addComponent(btnAgregarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnSeleccionIntermediario))
                    .addComponent(scrollTelefonoIntermediario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollIntermediario)
                    .addGroup(panelIntermediarioLayout.createSequentialGroup()
                        .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombresIntermediario)
                            .addComponent(lblDni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelIntermediarioLayout.createSequentialGroup()
                                .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addComponent(lblCodAsignacion)
                                .addGap(32, 32, 32)
                                .addComponent(txtCodAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelIntermediarioLayout.createSequentialGroup()
                        .addComponent(lblMovilIntermediario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelIntermediarioLayout.createSequentialGroup()
                        .addComponent(lblReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxReferencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIntermediarioLayout.createSequentialGroup()
                        .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelIntermediarioLayout.createSequentialGroup()
                                .addComponent(lblTelefoniaIntermediario)
                                .addGap(18, 18, 18)
                                .addComponent(boxTelefoniaIntermediario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTipoTelefoniaIntermediario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumeroIntermediario)
                                .addGap(18, 18, 18))
                            .addGroup(panelIntermediarioLayout.createSequentialGroup()
                                .addComponent(btnAgregarMovilIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelIntermediarioLayout.setVerticalGroup(
            panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIntermediarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIntermediarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombresIntermediario)
                    .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodAsignacion)
                    .addComponent(txtCodAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarIntermediario)
                    .addComponent(btnModificarIntermediario)
                    .addComponent(btnEliminarIntermediario)
                    .addComponent(btnSeleccionIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMovilIntermediario)
                .addGap(8, 8, 8)
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia)
                    .addComponent(boxReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefoniaIntermediario)
                    .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoTelefoniaIntermediario)
                    .addComponent(lblNumeroIntermediario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMovilIntermediario)
                    .addComponent(btnModificarMovilIntermediario)
                    .addComponent(btnEliminarMovilIntermediario)
                    .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTelefonoIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Pestañas.addTab("Intermediarios        ", panelIntermediario);

        btnEliminarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarObservacion.setText("Eliminar");
        btnEliminarObservacion.setToolTipText("Botón para eliminar la obsrvación seleccionada.");
        btnEliminarObservacion.setEnabled(false);
        btnEliminarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarObservacionActionPerformed(evt);
            }
        });

        btnModificarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificarObservacion.setText("Modificar");
        btnModificarObservacion.setToolTipText("Botón para modificar la observación seleccionada.");
        btnModificarObservacion.setEnabled(false);
        btnModificarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarObservacionActionPerformed(evt);
            }
        });

        textDescripcion.setColumns(20);
        textDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textDescripcion.setRows(5);
        scrollTextObservacion.setViewportView(textDescripcion);

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("(*) Descripción:");

        lblFecha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFecha.setText("(*) Fecha:");

        chooserFecha.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaOnCommit(evt);
            }
        });

        btnAgregarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarObservacion.setText("Agregar");
        btnAgregarObservacion.setToolTipText("Botón para agregar una nueva observación.");
        btnAgregarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarObservacionActionPerformed(evt);
            }
        });

        txtFechaObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaObservacion.setPlaceholder("dd/mm/aaaa");

        tblObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblObservacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblObservacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblObservacion.getTableHeader().setReorderingAllowed(false);
        tblObservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblObservacionMouseClicked(evt);
            }
        });
        scrollTblObservacion.setViewportView(tblObservacion);

        btnSeleccionObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionObservacion.setText("Quitar selección");
        btnSeleccionObservacion.setToolTipText("Botón para quitar la selección de la observación seleccionada.");
        btnSeleccionObservacion.setEnabled(false);
        btnSeleccionObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionObservacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelObservacionLayout = new javax.swing.GroupLayout(panelObservacion);
        panelObservacion.setLayout(panelObservacionLayout);
        panelObservacionLayout.setHorizontalGroup(
            panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTblObservacion)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelObservacionLayout.createSequentialGroup()
                        .addComponent(btnAgregarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnModificarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelObservacionLayout.createSequentialGroup()
                        .addGroup(panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelObservacionLayout.createSequentialGroup()
                                .addComponent(txtFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scrollTextObservacion))))
                .addContainerGap())
        );
        panelObservacionLayout.setVerticalGroup(
            panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObservacionLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(scrollTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarObservacion)
                    .addComponent(btnModificarObservacion)
                    .addComponent(btnEliminarObservacion)
                    .addComponent(btnSeleccionObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Pestañas.addTab("Observaciones          ", panelObservacion);

        getContentPane().add(Pestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, 740, 472));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        telefonoIncluido = false;
        proveedor = null;
        telefono = null;
        cuenta = null;
        vendedor = null;
        observacion = null;
        detalleProveedor = null;
        textdir = "-";
        textweb = "-";
        textmail = "-";
        codEmpleado = 0;
        fechadetprovemysql = Global.CALENDARY.get(Global.CALENDARY.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
        registroTelefono = new String[3];
        registroTelefono[0] = "";
        registroTelefono[1] = "";
        registroTelefono[2] = "";
        registroCuenta = new String[5];
        registroCuenta[0] = "";
        registroCuenta[1] = "";
        registroCuenta[2] = "";
        registroCuenta[3] = "-";
        registroCuenta[4] = "-";
        registroVendedor = new String[3];
        registroVendedor[0] = "-";
        registroVendedor[1] = "";
        registroVendedor[2] = "-";
        registroTelefonoVendedor = new String[4];
        registroTelefonoVendedor[0] = "";
        registroTelefonoVendedor[1] = "";
        registroTelefonoVendedor[2] = "";
        registroTelefonoVendedor[3] = "";
        registroObservacion = new String[2];
        registroObservacion[0] = "";
        registroObservacion[1] = "";
    }
    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        inicializarVariables();        
        if (txtRuc.getText().equals("") || txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            esRepetido = esRepetidoProveedor(txtNombre.getText());
            if (esRepetido == false) {
                if (!txtDireccion.getText().equals("")) {  textdir = txtDireccion.getText();    }
                if (!txtWeb.getText().equals("")) {        textweb = txtWeb.getText();          }
                if (!txtEmail.getText().equals("")) {      textmail = txtEmail.getText();       }
                
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
                    
                    for (int cnt1 = 0; cnt1 < tblTelefono.getRowCount(); cnt1++) {
                        try {
                            telefono = null;
                            telef = null;
                            tiptelef = null;
                            if(!tblTelefono.getValueAt(cnt1, 0).toString().equals("")) telef = tblTelefono.getValueAt(cnt1, 0).toString();
                            if(!tblTelefono.getValueAt(cnt1, 1).toString().equals("")) tiptelef = tblTelefono.getValueAt(cnt1, 1).toString();
                            telefono = new TelefonoDTO(
                                    telef,
                                    tiptelef,
                                    tblTelefono.getValueAt(cnt1, 2).toString(),
                                    "PROVEEDOR",
                                    txtNombre.getText()
                            );
                            result = TelefonoBL.getInstance().insert(telefono);
                            if (!result)    Messages.messageAlert("Error en datos de telefono.");
                        } catch (SQLException ex) {
                            logger.error(ex);
                        }
                    }

                    for (int cnt1 = 0; cnt1 < tblCuenta.getRowCount(); cnt1++) {
                        try {
                            codEmpresa = "-"; recaudo = "-";
                            if (tblCuenta.getValueAt(cnt1, 3) != null) {      codEmpresa = tblCuenta.getValueAt(cnt1, 3).toString();   }
                            if (tblCuenta.getValueAt(cnt1, 4) != null) {      recaudo = tblCuenta.getValueAt(cnt1, 4).toString();   }
                            cuenta = new CuentaBancariaDTO(
                                    tblCuenta.getValueAt(cnt1, 0).toString(),
                                    tblCuenta.getValueAt(cnt1, 1).toString(),
                                    tblCuenta.getValueAt(cnt1, 2).toString(),
                                    codEmpresa,
                                    recaudo,
                                    "PROVEEDOR",
                                    txtNombre.getText()
                            );

                            result = CuentaBancariaBL.getInstance().insert(cuenta);
                            if (!result)        Messages.messageError("Error al insertas cuentas bancarias.");
                        } catch (SQLException ex) {
                            logger.error(ex);
                        }
                    }
                    
                    
                    for (int z = 0; z < tblObservacion.getRowCount(); z++) {
                        try {
                            observacion = null;
                            observacion = new ObservacionDTO(
                                    Global.formatSQL(tblObservacion.getValueAt(z, 0).toString()),
                                    tblObservacion.getValueAt(z, 1).toString(),
                                    "PROVEEDOR",
                                    txtNombre.getText()
                            );
                            result = ObservacionBL.getInstance().insert(observacion);
                            if (!result)    Messages.messageAlert("Error en datos de observacion.");
                        } catch (ParseException | SQLException ex) {
                            logger.error(ex);
                        }
                    }
                    
                    for (int cnt1 = 0; cnt1 < tblIntermediario.getRowCount(); cnt1++) {
                        vdni = "-";
                        vcod = "-";
                        if (tblIntermediario.getValueAt(cnt1, 0) != null) {     vdni = tblIntermediario.getValueAt(cnt1, 0).toString();         }
                        if (tblIntermediario.getValueAt(cnt1, 2) != null) {     vcod = tblIntermediario.getValueAt(cnt1, 2).toString();         }
                        vendedor = new VendedorDTO(
                                vdni,
                                tblIntermediario.getValueAt(cnt1, 1).toString(),
                                vcod,
                                new ProveedorDTO(txtNombre.getText())
                        );
                        result = VendedorBL.getInstance().insert(vendedor);
                        if (!result) Messages.messageError("Error al insertar vendedores");
                    }
                    
                    for (int zz = 0; zz < tblMovilIntermediario.getRowCount(); zz++) {
                        
                        for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                            if ((tblIntermediario.getValueAt(cont, 0).toString()).equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                                try {
                                    codEmpleado = VendedorBL.getInstance().getByDniByNombresByCodigo(tblIntermediario.getValueAt(cont, 0).toString(),
                                            tblIntermediario.getValueAt(cont, 1).toString(),
                                            tblIntermediario.getValueAt(cont, 2).toString());
                                } catch (SQLException ex) {
                                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                                    logger.error(ex);
                                }break;
                            }
                        }
                        telef = null;
                        tiptelef = null;
                        if (!tblMovilIntermediario.getValueAt(zz, 1).toString().equals("")) { telef = tblMovilIntermediario.getValueAt(zz, 1).toString();}
                        if (!tblMovilIntermediario.getValueAt(zz, 2).toString().equals("")) { tiptelef = tblMovilIntermediario.getValueAt(zz, 2).toString();}
                        telefono = new TelefonoDTO(
                                telef,
                                tiptelef,
                                tblMovilIntermediario.getValueAt(zz, 3).toString(),
                                "VENDEDOR",
                                String.valueOf(codEmpleado)
                        );
                        
                        result = TelefonoBL.getInstance().insert(telefono);
                        if (!result) Messages.messageError("Error al insertar telefono de vendedores");
                    }

                    detalleProveedor = new DetalleProveedorDTO(
                            fechadetprovemysql,
                            fechadetprovemysql,
                            new ProveedorDTO(txtNombre.getText())
                    );
                    result = DetalleProveedorBL.getInstance().insert(detalleProveedor);
                    if(!result) Messages.messageError("Error al insertar detalle de proveedor");
                    Messages.messageInsert();
                    limpiarCampos();
                    
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            } else {    Messages.messageRepeat();     }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    public static void limpiarTabla(JTable tabla,DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(0);
        }
    }

    void limpiarCampos() {
        txtNombre.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtWeb.setText("");
        txtEmail.setText("");
        boxTelefonia.setSelectedItem("");
        boxTipoTelefonia.setSelectedItem("");
        txtNumero.setText("");
        txtCuenta.setText("");
        boxMonedas.setSelectedItem("");
        txtCodEmpresa.setText("");
        txtBanco.setText("");
        txtRecaudo.setText("");
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");
        txtCodAsignacion.setText("");
        boxReferencia.removeAllItems();
        boxTelefoniaIntermediario.setSelectedItem("");
        boxTipoTelefoniaIntermediario.setSelectedItem("");
        txtNumeroIntermediario.setText("");
        textDescripcion.setText("");
        txtFechaObservacion.setText("");
        vacearTablas();
    }

    static void vacearTablas() {
        limpiarTabla(tblTelefono, modeloTelefono);
        limpiarTabla(tblCuenta, modeloCuenta);
        limpiarTabla(tblIntermediario, modeloVendedor);
        limpiarTabla(tblMovilIntermediario, modeloTelefonoVendedor);
        limpiarTabla(tblObservacion, modeloObservacion);
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        crudModificar = 0;
        Proveedores.verificarParametros();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (txtRuc.getText().equals("") || txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtNombre.getText().equals(nombreProveedor)) {
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
                    result = ProveedorBL.getInstance().update(proveedor, nombreProveedor);
                    if (result) {
                        Messages.messageUpdate();
                        crudModificar = 0;
                        Proveedores.verificarParametros();
                        dispose();
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = "https://login.live.com/login.srf?wa=wsignin1.0&ct=1428133927&rver=6.1.6206.0&sa=1&ntprob=-1&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fmail.live.com%2F%3Fowa%3D1%26owasuffix%3Dowa%252f&id=64855&snsc=1&cbcxt=mail";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception ex) {  
            Messages.messageAlert("Error al cargar navegador.");
            logger.warn(ex);
        }
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = txtWeb.getText().trim();
        Browser.openURL("https://" + url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception ex) {   
            Messages.messageAlert("Error al cargar navegador.");
            logger.warn(ex);
        }
    }//GEN-LAST:event_btnWebActionPerformed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        //validarCampos.soloNumeros(txtRuc);
        //validarCampos.cantCaracteres(txtRuc, 10);
    }//GEN-LAST:event_txtRucKeyPressed

    private void btnModificarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMovilActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (crudModificar == 0) {
                if (!tblTelefono.getValueAt(filaTelefono, 2).toString().equals(txtNumero.getText())) {
                    for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                        if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 2).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                if (!tblTelefono.getValueAt(filaTelefono, 3).toString().equals(txtNumero.getText())) {
                    for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                        if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 3).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            }                   
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (boxTelefonia.getSelectedItem() != null) {     registroTelefono[0] = boxTelefonia.getSelectedItem().toString();     }
                if (boxTipoTelefonia.getSelectedItem() != null) { registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                registroTelefono[2] = txtNumero.getText();                
                if (crudModificar == 0) {
                    Messages.messageUpdate();                  
                    for (int i = 0; i < tblTelefono.getColumnCount(); i++) {
                        modeloTelefono.setValueAt(registroTelefono[i], filaTelefono, i);
                    }
                } else {
                    try {
                        telefono = new TelefonoDTO(
                                Integer.parseInt(tblTelefono.getValueAt(filaTelefono, 0 ).toString()),
                                registroTelefono[0],
                                registroTelefono[1],
                                txtNumero.getText()
                        );
                        result = TelefonoBL.getInstance().update(telefono);
                        if (result) {
                            Messages.messageUpdate();                            
                            ActivaTelefono();
                            listarTelefonos("PROVEEDOR", nombreProveedor);
                        } else {    Messages.messageErrorUpdate();      }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarMovilActionPerformed

    private void btnAgregarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMovilActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                    if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 2).toString())) {
                        esRepetido = true;
                    }
                }
            } else {
                for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                    if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 3).toString())) {
                        esRepetido = true;
                    }
                }
            }           
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageInsert();
                    if (boxTelefonia.getSelectedItem() != null) {     registroTelefono[0] = boxTelefonia.getSelectedItem().toString();     }
                    if (boxTipoTelefonia.getSelectedItem() != null) { registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                    registroTelefono[2] = txtNumero.getText();
                    modeloTelefono.addRow(registroTelefono);
                    tblTelefono.setModel(modeloTelefono);
                    ActivaTelefono();
                } else {
                    try {
                        telefono = new TelefonoDTO(
                                boxTelefonia.getSelectedItem().toString(),
                                boxTipoTelefonia.getSelectedItem().toString(),
                                txtNumero.getText(),
                                "PROVEEDOR",
                                nombreProveedor
                        );
                        result = TelefonoBL.getInstance().insert(telefono);
                        if (result) {
                            Messages.messageInsert();
                            ActivaTelefono();
                            listarTelefonos("PROVEEDOR", nombreProveedor);                            
                        } else {    Messages.messageErrorInsert();        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarMovilActionPerformed

    private void btnEliminarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                Messages.messageDelete();
                ActivaTelefono();
                modeloTelefono.removeRow(filaTelefono);
            } else {
                try {
                    telefono = new TelefonoDTO(
                            Integer.parseInt(tblTelefono.getValueAt(filaTelefono, 0 ).toString())
                    );
                    result = TelefonoBL.getInstance().delete(telefono);
                    if (result) {
                        Messages.messageDelete();                        
                        ActivaTelefono();
                        listarTelefonos("PROVEEDOR", nombreProveedor);
                    } else {     Messages.messageErrorDelete();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarMovilActionPerformed

    private void tblTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonoMouseClicked
        tblTelefono.setRowSelectionAllowed(true);
        filaTelefono = tblTelefono.getSelectedRow();
        if (crudModificar == 0) {
            if (tblTelefono.getValueAt(filaTelefono, 0) != null) {
                boxTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 0).toString());
            }
            if (tblTelefono.getValueAt(filaTelefono, 1) != null) {
                boxTipoTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 1).toString());
            }
            txtNumero.setText(tblTelefono.getValueAt(filaTelefono, 2).toString());
        } else {
            if (tblTelefono.getValueAt(filaTelefono, 1) != null) {
                boxTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 1).toString());
            }
            if (tblTelefono.getValueAt(filaTelefono, 2) != null) {
                boxTipoTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 2).toString());
            }
            txtNumero.setText(tblTelefono.getValueAt(filaTelefono, 3).toString());
        }
        btnAgregarMovil.setEnabled(false);
        btnModificarMovil.setEnabled(true);
        btnEliminarMovil.setEnabled(true);
        btnSeleccionMovil.setEnabled(true);
    }//GEN-LAST:event_tblTelefonoMouseClicked

    private void tblCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentaMouseClicked
        tblCuenta.setRowSelectionAllowed(true);
        filaCuenta = tblCuenta.getSelectedRow();
        if (crudModificar == 0) {
            txtCuenta.setText(tblCuenta.getValueAt(filaCuenta, 0).toString());
            boxMonedas.setSelectedItem(tblCuenta.getValueAt(filaCuenta, 1).toString());
            txtBanco.setText(tblCuenta.getValueAt(filaCuenta, 2).toString());
            if (tblCuenta.getValueAt(filaCuenta, 3) == null) { txtCodEmpresa.setText("-");         }
            else{   txtCodEmpresa.setText(tblCuenta.getValueAt(filaCuenta, 3).toString());    }

            if (tblCuenta.getValueAt(filaCuenta, 4) == null) { txtRecaudo.setText("-");         }
            else{   txtRecaudo.setText(tblCuenta.getValueAt(filaCuenta, 4).toString());    }
        } else {
            txtCuenta.setText(tblCuenta.getValueAt(filaCuenta, 1).toString());
            boxMonedas.setSelectedItem(tblCuenta.getValueAt(filaCuenta, 2).toString());
            txtBanco.setText(tblCuenta.getValueAt(filaCuenta, 3).toString());
            if (tblCuenta.getValueAt(filaCuenta, 4) == null) { txtCodEmpresa.setText("-");         }
            else{   txtCodEmpresa.setText(tblCuenta.getValueAt(filaCuenta, 4).toString());    }

            if (tblCuenta.getValueAt(filaCuenta, 5) == null) { txtRecaudo.setText("-");         }
            else{   txtRecaudo.setText(tblCuenta.getValueAt(filaCuenta, 5).toString());    }
        }
        btnAgregarCuenta.setEnabled(false);
        btnModificarCuenta.setEnabled(true);
        btnEliminarCuenta.setEnabled(true);
        btnSeleccionCuenta.setEnabled(true);
    }//GEN-LAST:event_tblCuentaMouseClicked

    private void btnModificarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCuentaActionPerformed
        inicializarVariables();
        if (txtCuenta.getText().equals("") || boxMonedas.getSelectedItem().toString().equals("") || txtBanco.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                        registroCuenta[0] = txtCuenta.getText();
                                                        registroCuenta[1] = boxMonedas.getSelectedItem().toString();
                                                        registroCuenta[2] = txtBanco.getText();
            if (!txtCodEmpresa.getText().equals("")) {  registroCuenta[3] = txtCodEmpresa.getText();   }
            if (!txtRecaudo.getText().equals("")) {     registroCuenta[4] = txtRecaudo.getText();      }
            
            if (crudModificar == 0) {
                if (!registroCuenta[0].equals(tblCuenta.getValueAt(filaCuenta, 0).toString())) {
                    for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                        if (registroCuenta[0].equals(tblCuenta.getValueAt(cont, 0).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                if (!registroCuenta[0].equals(tblCuenta.getValueAt(filaCuenta, 1).toString())) {
                    for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                        if (registroCuenta[0].equals(tblCuenta.getValueAt(cont, 1).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            }
            
            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {                    
                    Messages.messageUpdate();                    
                    ActivaCuenta();
                    for (int i = 0; i < tblCuenta.getColumnCount(); i++) {
                        modeloCuenta.setValueAt(registroCuenta[i], filaCuenta, i);
                    }
                } else {
                    try {
                        cuenta = new CuentaBancariaDTO(
                                Integer.parseInt(tblCuenta.getValueAt(filaCuenta, 0).toString()),
                                txtCuenta.getText(),
                                boxMonedas.getSelectedItem().toString(),
                                txtBanco.getText(),
                                registroCuenta[3],
                                registroCuenta[4],
                                "PROVEEDOR",
                                nombreProveedor
                        );
                        
                        result = CuentaBancariaBL.getInstance().update(cuenta);
                        if (result) {
                            Messages.messageUpdate();
                            ActivaCuenta();
                            listarCuentas("PROVEEDOR", nombreProveedor);
                        } else {
                            Messages.messageErrorUpdate();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarCuentaActionPerformed

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        inicializarVariables();
        if (txtCuenta.getText().equals("") || boxMonedas.getSelectedItem().toString().equals("") || txtBanco.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                    if (txtCuenta.getText().equals(tblCuenta.getValueAt(cont, 0).toString())) {
                        esRepetido = true;
                    }
                }
            } else {
                for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                    if (txtCuenta.getText().equals(tblCuenta.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                }
            }
            
            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {
                                                            registroCuenta[0] = txtCuenta.getText();
                                                            registroCuenta[1] = boxMonedas.getSelectedItem().toString();
                                                            registroCuenta[2] = txtBanco.getText();
                if (!txtCodEmpresa.getText().equals("")) {  registroCuenta[3] = txtCodEmpresa.getText();   }
                if (!txtRecaudo.getText().equals("")) {     registroCuenta[4] = txtRecaudo.getText();      }
                
                if (crudModificar == 0) {                    
                    Messages.messageInsert();                    
                    ActivaCuenta();
                    modeloCuenta.addRow(registroCuenta);
                    tblCuenta.setModel(modeloCuenta);
                } else {
                    try {
                        cuenta = new CuentaBancariaDTO(
                                txtCuenta.getText(),
                                boxMonedas.getSelectedItem().toString(),
                                txtBanco.getText(),
                                registroCuenta[3],
                                registroCuenta[4],
                                "PROVEEDOR",
                                nombreProveedor
                        );
                        
                        result = CuentaBancariaBL.getInstance().insert(cuenta);
                        if (result) {
                            Messages.messageInsert();
                            ActivaCuenta();
                            listarCuentas("PROVEEDOR", nombreProveedor);
                        } else {
                            Messages.messageErrorInsert();
                        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                Messages.messageDelete();                
                ActivaCuenta();
                modeloCuenta.removeRow(filaCuenta);
            } else {
                try {
                    cuenta = new CuentaBancariaDTO(
                            Integer.parseInt(tblCuenta.getValueAt(filaCuenta, 0).toString())
                    );
                    result = CuentaBancariaBL.getInstance().delete(cuenta);
                    if (result) {
                        Messages.messageDelete();
                        ActivaCuenta();
                        listarCuentas("PROVEEDOR", nombreProveedor);
                    } else {
                        Messages.messageErrorDelete();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnVerificaRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaRucActionPerformed
        String browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String url = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception ex) {   
            Messages.messageAlert("Error al cargar navegador.");
            logger.warn(ex);
        }
    }//GEN-LAST:event_btnVerificaRucActionPerformed

    private void btnEliminarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                    if (tblMovilIntermediario.getValueAt(co, 0).toString().equals(tblIntermediario.getValueAt(filaVendedor, 1).toString())) {
                        telefonoIncluido = true;
                    }
                }         
                
                if (telefonoIncluido == true) {
                    eliminaTelefonoIncluido = Messages.messageConfirmation("El intermediario tiene teléfono(s) almacenado(s), si continua se eliminara el intermediario junto con sus teléfonos.");
                    if (0 == eliminaTelefonoIncluido) {
                        Messages.messageDelete();
                        ActivaVendedor();
                        for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                            if (tblMovilIntermediario.getValueAt(co, 0).toString().equals(tblIntermediario.getValueAt(filaVendedor, 1).toString())) {
                                modeloTelefonoVendedor.removeRow(co);
                                co--;
                            }
                        }
                        boxReferencia.removeItem(tblIntermediario.getValueAt(filaVendedor, 1).toString());
                        modeloVendedor.removeRow(filaVendedor);
                    } else {        Messages.messageAlert("El intermediario no se elimino.");            }
                } else {
                    Messages.messageDelete();
                    ActivaVendedor();
                    boxReferencia.removeItem(tblIntermediario.getValueAt(filaVendedor, 1).toString());
                    modeloVendedor.removeRow(filaVendedor);
                }
            } else {
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
        }
    }//GEN-LAST:event_btnEliminarIntermediarioActionPerformed

    private void tblIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIntermediarioMouseClicked
        tblIntermediario.setRowSelectionAllowed(true);
        filaVendedor = tblIntermediario.getSelectedRow();
        if (crudModificar == 0) {
            if (tblIntermediario.getValueAt(filaVendedor, 0) == null) {     txtDniIntermediario.setText("-");   }
            else{       txtDniIntermediario.setText(tblIntermediario.getValueAt(filaVendedor, 0).toString());   }
            txtNombreIntermediario.setText(tblIntermediario.getValueAt(filaVendedor, 1).toString());
            if (tblIntermediario.getValueAt(filaVendedor, 2) == null) {    txtCodAsignacion.setText("-");                  }
            else{      txtCodAsignacion.setText(tblIntermediario.getValueAt(filaVendedor, 2).toString());                  }
        } else {
            if (tblIntermediario.getValueAt(filaVendedor, 1) == null) {     txtDniIntermediario.setText("-");   }
            else{       txtDniIntermediario.setText(tblIntermediario.getValueAt(filaVendedor, 1).toString());   }
            txtNombreIntermediario.setText(tblIntermediario.getValueAt(filaVendedor, 2).toString());
            if (tblIntermediario.getValueAt(filaVendedor, 3) == null) {    txtCodAsignacion.setText("-");                  }
            else{      txtCodAsignacion.setText(tblIntermediario.getValueAt(filaVendedor, 3).toString());                  }
        }
        btnAgregarIntermediario.setEnabled(false);
        btnModificarIntermediario.setEnabled(true);
        btnEliminarIntermediario.setEnabled(true);
        btnSeleccionIntermediario.setEnabled(true);
    }//GEN-LAST:event_tblIntermediarioMouseClicked

    private void btnModificarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarIntermediarioActionPerformed
        inicializarVariables();       
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {        registroVendedor[0] = txtDniIntermediario.getText();     }
                                                                    registroVendedor[1] = txtNombreIntermediario.getText();
            if (!txtCodAsignacion.getText().equals("")) {           registroVendedor[2] = txtCodAsignacion.getText(); }
            
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                    if (!registroVendedor[0].equals("-")) {
                        if (registroVendedor[0].equals(tblIntermediario.getValueAt(cont, 0).toString()) &&
                                registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                            esRepetido = true;
                        }
                    } else {
                        if (registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                    if (!registroVendedor[0].equals("-")) {
                        if (registroVendedor[0].equals(tblIntermediario.getValueAt(cont, 1).toString()) &&
                                registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                            esRepetido = true;
                        }
                    } else {
                        if (registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageUpdate();
                    boxReferencia.removeItem(tblIntermediario.getValueAt(filaVendedor, 1).toString());                    
                    boxReferencia.addItem(registroVendedor[1]);     
                    ActivaVendedor();
                    for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                        if (tblMovilIntermediario.getValueAt(co, 0).toString().equals(tblIntermediario.getValueAt(filaVendedor, 1).toString())) {
                            modeloTelefonoVendedor.setValueAt(registroVendedor[1], co, 0);
                        }
                    }
                    for (int i = 0; i < tblIntermediario.getColumnCount(); i++) {
                        modeloVendedor.setValueAt(registroVendedor[i], filaVendedor, i);
                    }                                                        
                } else {
                    try {
                        vendedor = new VendedorDTO(
                                Integer.parseInt(tblIntermediario.getValueAt(filaVendedor ,0).toString()),
                                registroVendedor[0],
                                registroVendedor[1],
                                registroVendedor[2]
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
        }
    }//GEN-LAST:event_btnModificarIntermediarioActionPerformed

    private void btnAgregarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIntermediarioActionPerformed
        inicializarVariables();
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {    registroVendedor[0] = txtDniIntermediario.getText();   }
                                                                registroVendedor[1] = txtNombreIntermediario.getText();
            if (!txtCodAsignacion.getText().equals("")) {       registroVendedor[2] = txtCodAsignacion.getText();       }
            
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                    if (!registroVendedor[0].equals("-")) {
                        if (registroVendedor[0].equals(tblIntermediario.getValueAt(cont, 0).toString()) &&
                                registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                            esRepetido = true;
                        }
                    } else {
                        if (registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                    if (!registroVendedor[0].equals("-")) {
                        if (registroVendedor[0].equals(tblIntermediario.getValueAt(cont, 1).toString()) &&
                                registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                            esRepetido = true;
                        }
                    } else {
                        if (registroVendedor[1].equals(tblIntermediario.getValueAt(cont, 2).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    cargarComboReferencia();
                    Messages.messageInsert();
                    ActivaVendedor();                    
                    modeloVendedor.addRow(registroVendedor);
                    tblIntermediario.setModel(modeloVendedor);                    
                } else {
                    try {
                        vendedor = new VendedorDTO(
                                registroVendedor[0],
                                registroVendedor[1],
                                registroVendedor[2],
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
        }
    }//GEN-LAST:event_btnAgregarIntermediarioActionPerformed

    private void tblMovilIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovilIntermediarioMouseClicked
        tblMovilIntermediario.setRowSelectionAllowed(true);
        filaTelefonoVendedor = tblMovilIntermediario.getSelectedRow();
        if (crudModificar == 0) {
            boxReferencia.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 0).toString());
            if (tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 1) == null) {
                boxTelefoniaIntermediario.setSelectedItem(null);
            } else {
                boxTelefoniaIntermediario.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 1).toString());
            }
            if (tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 2) == null) {
                boxTipoTelefoniaIntermediario.setSelectedItem(null);
            } else {
                boxTipoTelefoniaIntermediario.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 2).toString());
            }
            txtNumeroIntermediario.setText(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 3).toString());
        } else {
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
        }

        btnAgregarMovilIntermediario.setEnabled(false);
        btnModificarMovilIntermediario.setEnabled(true);
        btnEliminarMovilIntermediario.setEnabled(true);
        btnSeleccionMovilIntermediario.setEnabled(true);
    }//GEN-LAST:event_tblMovilIntermediarioMouseClicked

    private void btnEliminarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            if (crudModificar == 0) {
                Messages.messageDelete();
                modeloTelefonoVendedor.removeRow(filaTelefonoVendedor);
                ActivaTelefonoVendedor();
            } else {
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
        }
    }//GEN-LAST:event_btnEliminarMovilIntermediarioActionPerformed

    private void btnAgregarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem() == null || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroTelefonoVendedor[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       registroTelefonoVendedor[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   registroTelefonoVendedor[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
            registroTelefonoVendedor[3] = txtNumeroIntermediario.getText();
            
            if (crudModificar == 0) {
                for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                    if (registroTelefonoVendedor[3].equals(tblMovilIntermediario.getValueAt(cont, 3).toString())) {
                        esRepetido = true;
                    }
                }
            } else {
                for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                    if (registroTelefonoVendedor[3].equals(tblMovilIntermediario.getValueAt(cont, 4).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageInsert();                    
                    tblMovilIntermediario.setModel(modeloTelefonoVendedor);
                    ActivaTelefonoVendedor();
                    modeloTelefonoVendedor.addRow(registroTelefonoVendedor);
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
                                registroTelefonoVendedor[1],
                                registroTelefonoVendedor[2],
                                registroTelefonoVendedor[3],
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
        }
    }//GEN-LAST:event_btnAgregarMovilIntermediarioActionPerformed

    private void btnModificarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem() == null || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroTelefonoVendedor[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       registroTelefonoVendedor[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   registroTelefonoVendedor[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
            registroTelefonoVendedor[3] = txtNumeroIntermediario.getText();
            
            if (crudModificar == 0) {
                if (!tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 3).toString().equals(registroTelefonoVendedor[3])) {
                    for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                        if (registroTelefonoVendedor[3].equals(tblMovilIntermediario.getValueAt(cont, 3).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            } else {
                if (!tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 4).toString().equals(registroTelefonoVendedor[3])) {
                    for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                        if (registroTelefonoVendedor[3].equals(tblMovilIntermediario.getValueAt(cont, 4).toString())) {
                            esRepetido = true;
                        }
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (crudModificar == 0) {
                    Messages.messageInsert();                    
                    ActivaTelefonoVendedor();
                    for (int i = 0; i < tblMovilIntermediario.getColumnCount(); i++) {
                        modeloTelefonoVendedor.setValueAt(registroTelefonoVendedor[i], filaTelefonoVendedor, i);
                    }
                } else {
                    try {
                        if (!registroTelefonoVendedor[0].equals(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 1).toString())) {
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
                                    registroTelefonoVendedor[1],
                                    registroTelefonoVendedor[2],
                                    registroTelefonoVendedor[3],
                                    "VENDEDOR",
                                    String.valueOf(codEmpleado)
                            );
                        } else {                        
                            telefono = new TelefonoDTO(
                                        Integer.parseInt(tblMovilIntermediario.getValueAt(filaTelefonoVendedor, 0).toString()),
                                        registroTelefonoVendedor[1],
                                        registroTelefonoVendedor[2],
                                        registroTelefonoVendedor[3]
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
        }
    }//GEN-LAST:event_btnModificarMovilIntermediarioActionPerformed

    private void tblObservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObservacionMouseClicked
        tblObservacion.setRowSelectionAllowed(true);
        filaObservacion = tblObservacion.getSelectedRow();
        if (crudModificar == 0) {
            textDescripcion.setText(tblObservacion.getValueAt(filaObservacion, 1).toString());
            txtFechaObservacion.setText(tblObservacion.getValueAt(filaObservacion, 0).toString());
        } else {
            textDescripcion.setText(tblObservacion.getValueAt(filaObservacion, 2).toString());
            txtFechaObservacion.setText(tblObservacion.getValueAt(filaObservacion, 1).toString());
        }

        btnAgregarObservacion.setEnabled(false);
        btnModificarObservacion.setEnabled(true);
        btnEliminarObservacion.setEnabled(true);
        btnSeleccionObservacion.setEnabled(true);
    }//GEN-LAST:event_tblObservacionMouseClicked

    private void btnModificarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarObservacionActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFechaObservacion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (crudModificar == 0) {
                Messages.messageUpdate();                
                registroObservacion[0] = txtFechaObservacion.getText();
                registroObservacion[1] = textDescripcion.getText();
                for (int i = 0; i < tblObservacion.getColumnCount(); i++) {
                    modeloObservacion.setValueAt(registroObservacion[i], filaObservacion, i);
                } 
                ActivaObservacion();              
            } else {
                try {
                    observacion = new ObservacionDTO(
                            Integer.parseInt(tblObservacion.getValueAt(filaObservacion, 0).toString()),
                            Global.formatSQL(txtFechaObservacion.getText()),
                            textDescripcion.getText()
                    );
                    
                    result = ObservacionBL.getInstance().update(observacion);
                    if (result) {                        
                        Messages.messageUpdate();
                        ActivaObservacion();
                        listarObservaciones("PROVEEDOR", nombreProveedor);
                    } else {     Messages.messageErrorUpdate();       }
                } catch (SQLException | ParseException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarObservacionActionPerformed

    private void btnEliminarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarObservacionActionPerformed
        inicializarVariables();
        if (0 == Messages.messageDeactive()) {
            if (crudModificar == 0) {
                Messages.messageDelete();
                modeloObservacion.removeRow(filaObservacion);
                ActivaObservacion();
            } else {
                try {
                    observacion = new ObservacionDTO(
                            Integer.parseInt(tblObservacion.getValueAt(filaObservacion, 0).toString())
                    );
                    
                    result = ObservacionBL.getInstance().delete(observacion);
                    if (result) {                        
                        Messages.messageUpdate();
                        ActivaObservacion();
                        listarObservaciones("PROVEEDOR", nombreProveedor);
                    } else {     Messages.messageErrorDelete();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarObservacionActionPerformed

    private void chooserFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaOnCommit
        txtFechaObservacion.setText(chooserFecha.getText());
    }//GEN-LAST:event_chooserFechaOnCommit

    private void btnAgregarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarObservacionActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFechaObservacion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (crudModificar == 0) {
                Messages.messageInsert();
                registroObservacion[0] = txtFechaObservacion.getText();
                registroObservacion[1] = textDescripcion.getText();
                modeloObservacion.addRow(registroObservacion);
                tblObservacion.setModel(modeloObservacion);  
                ActivaObservacion();              
            } else {
                try {
                    observacion = new ObservacionDTO(
                            Global.formatSQL(txtFechaObservacion.getText()),
                            textDescripcion.getText(),
                            "PROVEEDOR",
                            nombreProveedor
                    );
                    
                    result = ObservacionBL.getInstance().insert(observacion);
                    if (result) {                        
                        Messages.messageInsert();
                        ActivaObservacion();
                        listarObservaciones("PROVEEDOR", nombreProveedor);
                    } else {       Messages.messageErrorInsert();           }
                } catch (SQLException | ParseException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarObservacionActionPerformed

    void ActivaCuenta() {
        tblCuenta.setRowSelectionAllowed(false);
        txtCuenta.requestFocus();
        txtCuenta.setText("");
        boxMonedas.setSelectedItem(null);
        txtBanco.setText("");
        txtCodEmpresa.setText("");
        txtRecaudo.setText("");
        btnAgregarCuenta.setEnabled(true);
        btnModificarCuenta.setEnabled(false);
        btnEliminarCuenta.setEnabled(false);
        btnSeleccionCuenta.setEnabled(false);
    }

    private void btnSeleccionCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionCuentaActionPerformed
        ActivaCuenta();
    }//GEN-LAST:event_btnSeleccionCuentaActionPerformed

    void ActivaTelefono() {
        tblTelefono.setRowSelectionAllowed(false);
        boxTelefonia.setSelectedItem(null);
        boxTipoTelefonia.setSelectedItem(null);
        txtNumero.setText("");
        btnAgregarMovil.setEnabled(true);
        btnModificarMovil.setEnabled(false);
        btnEliminarMovil.setEnabled(false);
        btnSeleccionMovil.setEnabled(false);
    }

    private void btnSeleccionMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionMovilActionPerformed
        ActivaTelefono();
    }//GEN-LAST:event_btnSeleccionMovilActionPerformed

    void ActivaObservacion() {
        tblObservacion.setRowSelectionAllowed(false);
        textDescripcion.requestFocus();
        textDescripcion.setText("");
        txtFechaObservacion.setText("");
        btnAgregarObservacion.setEnabled(true);
        btnModificarObservacion.setEnabled(false);
        btnEliminarObservacion.setEnabled(false);
        btnSeleccionObservacion.setEnabled(false);
    }

    private void btnSeleccionObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionObservacionActionPerformed
        ActivaObservacion();
    }//GEN-LAST:event_btnSeleccionObservacionActionPerformed

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        crudModificar = 0;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        txtNombre.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtWeb.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void boxTelefoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTelefoniaActionPerformed
        boxTipoTelefonia.requestFocus();
    }//GEN-LAST:event_boxTelefoniaActionPerformed

    private void boxTipoTelefoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoTelefoniaActionPerformed
        txtNumero.requestFocus();
    }//GEN-LAST:event_boxTipoTelefoniaActionPerformed

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        if (btnAgregarMovil.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarMovil.doClick();
            }
        }
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        boxMonedas.requestFocus();
    }//GEN-LAST:event_txtCuentaActionPerformed

    private void boxMonedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMonedasActionPerformed
        txtCodEmpresa.requestFocus();
    }//GEN-LAST:event_boxMonedasActionPerformed

    private void txtCodEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEmpresaActionPerformed
        txtBanco.requestFocus();
    }//GEN-LAST:event_txtCodEmpresaActionPerformed

    private void txtBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBancoActionPerformed
        txtRecaudo.requestFocus();
    }//GEN-LAST:event_txtBancoActionPerformed

    private void txtRecaudoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecaudoKeyPressed
        if (btnAgregarCuenta.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarCuenta.doClick();
            }
        }
    }//GEN-LAST:event_txtRecaudoKeyPressed

    private void txtDniIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniIntermediarioActionPerformed
        txtNombreIntermediario.requestFocus();
    }//GEN-LAST:event_txtDniIntermediarioActionPerformed

    private void txtNombreIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreIntermediarioActionPerformed
        txtCodAsignacion.requestFocus();
    }//GEN-LAST:event_txtNombreIntermediarioActionPerformed

    private void txtCodAsignacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAsignacionKeyPressed
        if (btnAgregarIntermediario.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarIntermediario.doClick();
            }
        }
    }//GEN-LAST:event_txtCodAsignacionKeyPressed

    private void boxTelefoniaIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTelefoniaIntermediarioActionPerformed
        boxTipoTelefoniaIntermediario.requestFocus();
    }//GEN-LAST:event_boxTelefoniaIntermediarioActionPerformed

    private void boxTipoTelefoniaIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoTelefoniaIntermediarioActionPerformed
        txtNumeroIntermediario.requestFocus();
    }//GEN-LAST:event_boxTipoTelefoniaIntermediarioActionPerformed

    private void txtNumeroIntermediarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroIntermediarioKeyPressed
        if (btnAgregarMovilIntermediario.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarMovilIntermediario.doClick();
            }
        }
    }//GEN-LAST:event_txtNumeroIntermediarioKeyPressed

    private void boxReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxReferenciaActionPerformed
        boxTelefoniaIntermediario.requestFocus();
    }//GEN-LAST:event_boxReferenciaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Proveedores_CRUDPadreDialog dialog = new Proveedores_CRUDPadreDialog(new javax.swing.JDialog(), true);
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
    private org.matrix.BlackTabbedPane Pestañas;
    public static javax.swing.JComboBox boxMonedas;
    public static javax.swing.JComboBox boxReferencia;
    public static javax.swing.JComboBox boxTelefonia;
    public static javax.swing.JComboBox boxTelefoniaIntermediario;
    public static javax.swing.JComboBox boxTipoTelefonia;
    public static javax.swing.JComboBox boxTipoTelefoniaIntermediario;
    public static javax.swing.JButton btnAgregarCuenta;
    public static javax.swing.JButton btnAgregarIntermediario;
    public static javax.swing.JButton btnAgregarMovil;
    public static javax.swing.JButton btnAgregarMovilIntermediario;
    public static javax.swing.JButton btnAgregarObservacion;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminarCuenta;
    public static javax.swing.JButton btnEliminarIntermediario;
    public static javax.swing.JButton btnEliminarMovil;
    public static javax.swing.JButton btnEliminarMovilIntermediario;
    public static javax.swing.JButton btnEliminarObservacion;
    private javax.swing.JButton btnEmail;
    public javax.swing.JButton btnGrabar;
    public javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnModificarCuenta;
    public static javax.swing.JButton btnModificarIntermediario;
    public static javax.swing.JButton btnModificarMovil;
    public static javax.swing.JButton btnModificarMovilIntermediario;
    public static javax.swing.JButton btnModificarObservacion;
    private javax.swing.JButton btnSeleccionCuenta;
    private javax.swing.JButton btnSeleccionIntermediario;
    private javax.swing.JButton btnSeleccionMovil;
    private javax.swing.JButton btnSeleccionMovilIntermediario;
    private javax.swing.JButton btnSeleccionObservacion;
    private javax.swing.JButton btnVerificaRuc;
    private javax.swing.JButton btnWeb;
    public static datechooser.beans.DateChooserCombo chooserFecha;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblCodAsignacion;
    private javax.swing.JLabel lblCodEmpresa;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIntermediarios;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblMovilIntermediario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombresIntermediario;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblNumeroIntermediario;
    private javax.swing.JLabel lblRecaudo;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTelefoniaIntermediario;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JLabel lblTipoTelefoniaIntermediario;
    public javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUbicacionMovil;
    private javax.swing.JLabel lblWeb;
    private javax.swing.JPanel panelCuentaBancaria;
    private javax.swing.JPanel panelIntermediario;
    private javax.swing.JPanel panelObservacion;
    private javax.swing.JPanel panelUbicacionTelefonia;
    private javax.swing.JScrollPane scrollCuentaBancaria;
    private javax.swing.JScrollPane scrollIntermediario;
    private javax.swing.JScrollPane scrollTblObservacion;
    private javax.swing.JScrollPane scrollTelefono;
    private javax.swing.JScrollPane scrollTelefonoIntermediario;
    private javax.swing.JScrollPane scrollTextObservacion;
    public static javax.swing.JTable tblCuenta;
    public static javax.swing.JTable tblIntermediario;
    public static javax.swing.JTable tblMovilIntermediario;
    public static javax.swing.JTable tblObservacion;
    public static javax.swing.JTable tblTelefono;
    public static javax.swing.JTextArea textDescripcion;
    public static Folder.DJCTextFieldWithoutPop txtBanco;
    public static Folder.DJCTextFieldWithoutPop txtCodAsignacion;
    private Folder.DJCTextFieldWithoutPop txtCodEmpresa;
    public static Folder.DJCTextFieldWithoutPop txtCuenta;
    public Folder.DJCTextFieldWithoutPop txtDireccion;
    private static Folder.DJCTextFieldWithoutPop txtDniIntermediario;
    public Folder.DJCTextFieldWithoutPop txtEmail;
    public static Folder.DJCTextFieldWithoutPop txtFechaObservacion;
    public Folder.DJCTextFieldWithoutPop txtNombre;
    private static Folder.DJCTextFieldWithoutPop txtNombreIntermediario;
    public static Folder.DJCTextFieldWithoutPop txtNumero;
    public static Folder.DJCTextFieldWithoutPop txtNumeroIntermediario;
    private Folder.DJCTextFieldWithoutPop txtRecaudo;
    public Folder.DJCTextFieldWithoutPop txtRuc;
    public Folder.DJCTextFieldWithoutPop txtWeb;
    // End of variables declaration//GEN-END:variables
}
