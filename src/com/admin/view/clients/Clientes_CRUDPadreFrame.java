package com.admin.view.clients;

import com.admin.entity.bl.ClienteBL;
import com.admin.entity.bl.CuentaBancariaBL;
import com.admin.entity.bl.DireccionBL;
import com.admin.entity.bl.EmpleadoTratarBL;
import com.admin.entity.bl.ObservacionBL;
import com.admin.entity.bl.TelefonoBL;
import com.admin.entity.dto.ClienteDTO;
import com.admin.entity.dto.CuentaBancariaDTO;
import com.admin.entity.dto.DireccionDTO;
import com.admin.entity.dto.EmpleadoTratarDTO;
import com.admin.entity.dto.ObservacionDTO;
import com.admin.entity.dto.TelefonoDTO;
import com.admin.entity.pojo.TelefonoEmpleadoTratarP;
import com.admin.resource.utils.Browser;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Clientes_CRUDPadreFrame extends javax.swing.JDialog {
    static DefaultTableModel modeloTelefono, modeloCuenta, modeloEmpleado, modeloObservacion, modeloTelfEmpleado;
    private final String fechaCreacion;
    int filaTelefono, filaEmpleadoTratar, filaTelefonoEmpleado, filaObservacion, filaCuenta, codigoEmpleado;
    public static int crudModificar = 0; // 0 -> crea cliente desde cero y 1 -> realiza CRUD, cuando ya se creo al cliente.
    private boolean esRepetido = false;
    private boolean result = false;
    public static String codigoCliente;
    private EmpleadoTratarDTO empleadoTratar = null;
    private CuentaBancariaDTO cuenta = null;
    private ClienteDTO cliente = null;
    private TelefonoDTO telefono = null;
    private ObservacionDTO observacion = null;
    private static DireccionDTO direccion = null;
    private String textdire = "-", textllegada = "-", textemail = "-", fechaNacimiento = "1111-11-11", codigoEmp, recaudo, emplDni;
    private boolean telefonoIncluido = false; // valor para determinar si el intermediario a elminar tiene telefono agregados.
    private int eliminaTelefonoIncluido;
    private int sex = 0;
    private int codEmpleado = 0;
    private int pregunta;
    private String []registroTelefono;
    private String []registroCuenta;
    private String []registroObservacion;
    private String []registroEmpleado;
    private String []registroTelefonoEmpleado;
    private String browser, url;
    final static Logger logger = Logger.getLogger(Clientes_CRUDPadreFrame.class);

    public Clientes_CRUDPadreFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Gestión de Clientes");
        Inicio();
        verificarComboTipoCliente();
        fechaCreacion = Global.CALENDARY.get(Global.CALENDARY.YEAR) + "-" + (Global.CALENDARY.get(Global.CALENDARY.MONTH) + 1) + "-" + Global.CALENDARY.get(Global.CALENDARY.DATE);
        chooserFechaCliente.setDateFormat(Global.FORMAT_DATE_CLIENT);
        chooserFechaObservacion.setDateFormat(Global.FORMAT_DATE_CLIENT);
    }

    private void Inicio() {
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

        modeloEmpleado = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
            }};
        String[] titulos1 = {"DNI", "NOMBRES"};
        modeloEmpleado.setColumnIdentifiers(titulos1);
        tblIntermediario.setModel(modeloEmpleado);
        ConfigTables.headerTables(tblIntermediario);
        ConfigTables.sizeModelEmployeeTry(tblIntermediario);

        modeloTelfEmpleado = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
            }};
        String[] tit = {"NOMBRE REF.", "TELEFONÍA", "TIPO TELEFONÍA", "NÚMERO"};
        modeloTelfEmpleado.setColumnIdentifiers(tit);
        tblMovilIntermediario.setModel(modeloTelfEmpleado);
        ConfigTables.headerTables(tblMovilIntermediario);
        ConfigTables.sizeModelCellphoneEmployeeTry(tblMovilIntermediario);

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGenero = new javax.swing.ButtonGroup();
        btnGrabar = new javax.swing.JButton();
        Pestañas = new javax.swing.JTabbedPane();
        tabUbicacion = new javax.swing.JPanel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new Folder.DJCTextFieldWithoutPop();
        btnEmail = new javax.swing.JButton();
        panelUbicacion = new javax.swing.JPanel();
        lblDistrito = new javax.swing.JLabel();
        lblProvincia = new javax.swing.JLabel();
        txtDistrito = new Folder.DJCTextFieldWithoutPop();
        txtProvincia = new Folder.DJCTextFieldWithoutPop();
        lblDepartamento = new javax.swing.JLabel();
        boxDepartamento = new javax.swing.JComboBox();
        txtLlegada = new Folder.DJCTextFieldWithoutPop();
        lblLlegada = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        tabTelefonia = new javax.swing.JPanel();
        lblTelefonia = new javax.swing.JLabel();
        lblTipoTelefonia = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new Folder.DJCTextFieldWithoutPop();
        boxTipoTelefonia = new javax.swing.JComboBox();
        boxTelefonia = new javax.swing.JComboBox();
        btnSeleccionMovil = new javax.swing.JButton();
        btnModificarMovil = new javax.swing.JButton();
        btnAgregarMovil = new javax.swing.JButton();
        btnEliminarMovil = new javax.swing.JButton();
        scrollTelefono = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        tabCuentaBancaria = new javax.swing.JPanel();
        lblNumeroCuenta = new javax.swing.JLabel();
        lblMoneda = new javax.swing.JLabel();
        lblCodEmpresa = new javax.swing.JLabel();
        lblBanco = new javax.swing.JLabel();
        lblRecaudo = new javax.swing.JLabel();
        txtCuenta = new Folder.DJCTextFieldWithoutPop();
        boxMonedas = new javax.swing.JComboBox();
        txtCodEmpresa = new Folder.DJCTextFieldWithoutPop();
        txtBanco = new Folder.DJCTextFieldWithoutPop();
        txtRecaudo = new Folder.DJCTextFieldWithoutPop();
        btnAgregarCuenta = new javax.swing.JButton();
        btnModificarCuenta = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnSeleccionCuenta = new javax.swing.JButton();
        scrollCuenta = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        tabIntermediario = new javax.swing.JPanel();
        lblIntermediarios = new javax.swing.JLabel();
        lblDniIntermediario = new javax.swing.JLabel();
        txtDniIntermediario = new Folder.DJCTextFieldWithoutPop();
        lblNombreIntermediario = new javax.swing.JLabel();
        txtNombreIntermediario = new Folder.DJCTextFieldWithoutPop();
        btnAgregarIntermediario = new javax.swing.JButton();
        btnModificarIntermediario = new javax.swing.JButton();
        btnEliminarIntermediario = new javax.swing.JButton();
        btnSeleccionIntermediario = new javax.swing.JButton();
        scrollIntermediario = new javax.swing.JScrollPane();
        tblIntermediario = new javax.swing.JTable();
        lblMovilIntermediario = new javax.swing.JLabel();
        lblReferencia = new javax.swing.JLabel();
        boxReferencia = new javax.swing.JComboBox();
        lblTelefoniaIntermediario = new javax.swing.JLabel();
        boxTelefoniaIntermediario = new javax.swing.JComboBox();
        lblTipoTelefoniaIntermediario = new javax.swing.JLabel();
        boxTipoTelefoniaIntermediario = new javax.swing.JComboBox();
        lblNumeroIntermediario = new javax.swing.JLabel();
        txtNumeroIntermediario = new Folder.DJCTextFieldWithoutPop();
        btnAgregarMovilIntermediario = new javax.swing.JButton();
        btnModificarMovilIntermediario = new javax.swing.JButton();
        btnEliminarMovilIntermediario = new javax.swing.JButton();
        btnSeleccionMovilIntermediario = new javax.swing.JButton();
        scrollMovilIntermediario = new javax.swing.JScrollPane();
        tblMovilIntermediario = new javax.swing.JTable();
        tabObservacion = new javax.swing.JPanel();
        lblFechaObservacion = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtFechaObservacion = new Folder.DJCTextFieldWithoutPop();
        chooserFechaObservacion = new datechooser.beans.DateChooserCombo();
        scrollTextObservacion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        btnAgregarObservacion = new javax.swing.JButton();
        btnModificarObservacion = new javax.swing.JButton();
        btnSeleccionObservacion = new javax.swing.JButton();
        btnEliminarObservacion = new javax.swing.JButton();
        scrollTblObservacion = new javax.swing.JScrollPane();
        tblObservacion = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        panelBoleta = new javax.swing.JPanel();
        txtDni = new Folder.DJCTextFieldWithoutPop();
        lblDni = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        txtFechaNacimiento = new Folder.DJCTextFieldWithoutPop();
        chooserFechaCliente = new datechooser.beans.DateChooserCombo();
        lblFechaNacimiento = new javax.swing.JLabel();
        rbtnMasculino = new javax.swing.JRadioButton();
        lblGenero = new javax.swing.JLabel();
        rbtnFemenino = new javax.swing.JRadioButton();
        panelFactura = new javax.swing.JPanel();
        lblRuc = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        txtRuc = new Folder.DJCTextFieldWithoutPop();
        txtRazonSocial = new Folder.DJCTextFieldWithoutPop();
        btnVerificaRuc = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        boxTipoCliente = new Folder.DMJCComboBox();
        lblTipoCliente = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Save.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Botón para grabar un nuevo cliente.");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        Pestañas.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        lblDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDireccion.setText("Dirección :");

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("Escribir aquí la dirección del cliente.");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmail.setText("E - mail :");

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtEmail.setPlaceholder("Escribir aquí la dirección electrónica del cliente.");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/email.png"))); // NOI18N
        btnEmail.setToolTipText("Botón para abrir correo electrónico.");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        panelUbicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ubicación terrestre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        lblDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDistrito.setText("Distrito:");

        lblProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProvincia.setText("Provincia :");

        txtDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDistrito.setPlaceholder("Escribir aquí el distrito donde reside el cliente.");
        txtDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDistritoActionPerformed(evt);
            }
        });

        txtProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProvincia.setPlaceholder("Escribir aquí la provincia donde reside el cliente.");
        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });

        lblDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDepartamento.setText("Departamento: ");

        boxDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Amazonas", "Ancash", "Apurimac", "Arequipa", "Ayacucho", "Cajamarca", "Callao", "Cuzco", "Huancavelica", "Huanuco", "Ica", "Junin", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna", "Tumbes", "Ucayali" }));
        boxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDepartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUbicacionLayout = new javax.swing.GroupLayout(panelUbicacion);
        panelUbicacion.setLayout(panelUbicacionLayout);
        panelUbicacionLayout.setHorizontalGroup(
            panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelUbicacionLayout.createSequentialGroup()
                            .addComponent(lblProvincia)
                            .addGap(34, 34, 34))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUbicacionLayout.createSequentialGroup()
                            .addComponent(lblDepartamento)
                            .addGap(18, 18, 18)))
                    .addGroup(panelUbicacionLayout.createSequentialGroup()
                        .addComponent(lblDistrito)
                        .addGap(63, 63, 63)))
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelUbicacionLayout.setVerticalGroup(
            panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbicacionLayout.createSequentialGroup()
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(boxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistrito)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        txtLlegada.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtLlegada.setPlaceholder("Escribir aquí el punto de llegada del pedido del cliente.");

        lblLlegada.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblLlegada.setText("Punto de Llegada:");

        lblNota.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNota.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblNota.setText("NOTA: En Ubicación Terrestre, los campos son opcionales; sin embargo si llena uno se deberá completar los demas.");
        lblNota.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout tabUbicacionLayout = new javax.swing.GroupLayout(tabUbicacion);
        tabUbicacion.setLayout(tabUbicacionLayout);
        tabUbicacionLayout.setHorizontalGroup(
            tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabUbicacionLayout.createSequentialGroup()
                        .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNota)
                            .addGroup(tabUbicacionLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabUbicacionLayout.createSequentialGroup()
                                        .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDireccion)
                                            .addComponent(lblEmail))
                                        .addGap(59, 59, 59)
                                        .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(tabUbicacionLayout.createSequentialGroup()
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEmail))
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(tabUbicacionLayout.createSequentialGroup()
                                        .addComponent(lblLlegada)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addComponent(panelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabUbicacionLayout.setVerticalGroup(
            tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabUbicacionLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion))
                .addGap(18, 18, 18)
                .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmail))
                    .addComponent(btnEmail))
                .addGap(18, 18, 18)
                .addGroup(tabUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLlegada))
                .addGap(27, 27, 27)
                .addComponent(panelUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(lblNota, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Pestañas.addTab("Ubicación           ", tabUbicacion);

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("(*) Número:");

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

        btnAgregarMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarMovil.setText("Agregar");
        btnAgregarMovil.setToolTipText("Botón para agregar un nuevo teléfono.");
        btnAgregarMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMovilActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout tabTelefoniaLayout = new javax.swing.GroupLayout(tabTelefonia);
        tabTelefonia.setLayout(tabTelefoniaLayout);
        tabTelefoniaLayout.setHorizontalGroup(
            tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTelefoniaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTelefoniaLayout.createSequentialGroup()
                        .addComponent(btnAgregarMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTelefoniaLayout.createSequentialGroup()
                        .addComponent(lblTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(lblTipoTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(tabTelefoniaLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(scrollTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabTelefoniaLayout.setVerticalGroup(
            tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTelefoniaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoTelefonia)
                        .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumero)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelefonia)
                        .addComponent(boxTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarMovil)
                    .addComponent(btnModificarMovil)
                    .addComponent(btnEliminarMovil)
                    .addComponent(btnSeleccionMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        Pestañas.addTab("Telefonía             ", tabTelefonia);

        lblNumeroCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumeroCuenta.setText("(*)  #Cuenta:");

        lblMoneda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMoneda.setText("(*) Moneda:");

        lblCodEmpresa.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodEmpresa.setText("Cód . Empresa:");

        lblBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblBanco.setText("(*) Entidad Bancaria:");

        lblRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRecaudo.setText("Recaudo:");

        txtCuenta.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
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

        txtBanco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBanco.setPlaceholder("Escribir aquí el nombre de la entidad bancaria.");
        txtBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBancoActionPerformed(evt);
            }
        });

        txtRecaudo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRecaudo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecaudoKeyPressed(evt);
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

        btnEliminarCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarCuenta.setText("Eliminar");
        btnEliminarCuenta.setToolTipText("Botón para eliminar la cuetna bancaria seleccionada.");
        btnEliminarCuenta.setEnabled(false);
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        btnSeleccionCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionCuenta.setText("Quitar selección");
        btnSeleccionCuenta.setToolTipText("Botón para quitar la selección de la cuenta bancaria seleccionada.");
        btnSeleccionCuenta.setEnabled(false);
        btnSeleccionCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionCuentaActionPerformed(evt);
            }
        });

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
        scrollCuenta.setViewportView(tblCuenta);

        javax.swing.GroupLayout tabCuentaBancariaLayout = new javax.swing.GroupLayout(tabCuentaBancaria);
        tabCuentaBancaria.setLayout(tabCuentaBancariaLayout);
        tabCuentaBancariaLayout.setHorizontalGroup(
            tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCuentaBancariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabCuentaBancariaLayout.createSequentialGroup()
                            .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblBanco)
                                .addComponent(lblNumeroCuenta))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(tabCuentaBancariaLayout.createSequentialGroup()
                                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(lblMoneda)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(boxMonedas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txtBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCodEmpresa)
                                .addComponent(lblRecaudo))
                            .addGap(15, 15, 15)
                            .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCuentaBancariaLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnModificarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSeleccionCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        tabCuentaBancariaLayout.setVerticalGroup(
            tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCuentaBancariaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoneda)
                    .addComponent(lblNumeroCuenta)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxMonedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodEmpresa)
                    .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecaudo)
                    .addComponent(txtRecaudo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBanco)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabCuentaBancariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCuenta)
                    .addComponent(btnModificarCuenta)
                    .addComponent(btnEliminarCuenta)
                    .addComponent(btnSeleccionCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        Pestañas.addTab("Cuentas bancarias            ", tabCuentaBancaria);

        lblIntermediarios.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblIntermediarios.setText("Intermediarios:");

        lblDniIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDniIntermediario.setText("DNI: ");

        txtDniIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDniIntermediario.setPlaceholder("Sólo 8 dítigos.");
        txtDniIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniIntermediarioActionPerformed(evt);
            }
        });

        lblNombreIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombreIntermediario.setText("(*) Nombres:");

        txtNombreIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombreIntermediario.setPlaceholder("Escribir aquí los nombres del intermediario.");
        txtNombreIntermediario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreIntermediarioKeyPressed(evt);
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

        lblMovilIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMovilIntermediario.setText("Ubicación móvil de Intermediarios:");

        lblReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblReferencia.setText("Referencia:");

        boxReferencia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxReferenciaActionPerformed(evt);
            }
        });

        lblTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefoniaIntermediario.setText("Telefonía:");

        boxTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CLARO", "MOVISTAR", "ENTEL", "BITEL" }));
        boxTelefoniaIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTelefoniaIntermediarioActionPerformed(evt);
            }
        });

        lblTipoTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefoniaIntermediario.setText("Tipo:");

        boxTipoTelefoniaIntermediario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefoniaIntermediario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "POSTPAGO", "PREPAGO" }));
        boxTipoTelefoniaIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoTelefoniaIntermediarioActionPerformed(evt);
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

        btnAgregarMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarMovilIntermediario.setText("Agregar");
        btnAgregarMovilIntermediario.setToolTipText("Botón para agregar un nuevo teléfono de intermediario.");
        btnAgregarMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMovilIntermediarioActionPerformed(evt);
            }
        });

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

        btnSeleccionMovilIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionMovilIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionMovilIntermediario.setText("Quitar selección");
        btnSeleccionMovilIntermediario.setToolTipText("Botón para quitar la selección del teléfono seleccionado de itnermediario.");
        btnSeleccionMovilIntermediario.setEnabled(false);
        btnSeleccionMovilIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionMovilIntermediarioActionPerformed(evt);
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
        scrollMovilIntermediario.setViewportView(tblMovilIntermediario);

        javax.swing.GroupLayout tabIntermediarioLayout = new javax.swing.GroupLayout(tabIntermediario);
        tabIntermediario.setLayout(tabIntermediarioLayout);
        tabIntermediarioLayout.setHorizontalGroup(
            tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabIntermediarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabIntermediarioLayout.createSequentialGroup()
                        .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabIntermediarioLayout.createSequentialGroup()
                                .addComponent(btnAgregarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                            .addComponent(lblIntermediarios)
                            .addGroup(tabIntermediarioLayout.createSequentialGroup()
                                .addComponent(lblDniIntermediario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreIntermediario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabIntermediarioLayout.createSequentialGroup()
                                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefoniaIntermediario)
                                    .addComponent(lblReferencia))
                                .addGap(14, 14, 14)
                                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabIntermediarioLayout.createSequentialGroup()
                                        .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTipoTelefoniaIntermediario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(lblNumeroIntermediario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(boxReferencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabIntermediarioLayout.createSequentialGroup()
                                .addComponent(btnAgregarMovilIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollMovilIntermediario))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabIntermediarioLayout.createSequentialGroup()
                        .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollIntermediario)
                            .addGroup(tabIntermediarioLayout.createSequentialGroup()
                                .addComponent(lblMovilIntermediario)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        tabIntermediarioLayout.setVerticalGroup(
            tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabIntermediarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIntermediarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDniIntermediario)
                    .addComponent(txtDniIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreIntermediario)
                    .addComponent(txtNombreIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarIntermediario)
                    .addComponent(btnModificarIntermediario)
                    .addComponent(btnEliminarIntermediario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblMovilIntermediario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefoniaIntermediario)
                    .addComponent(boxTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoTelefoniaIntermediario)
                    .addComponent(boxTipoTelefoniaIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroIntermediario)
                    .addComponent(txtNumeroIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabIntermediarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarMovilIntermediario)
                    .addComponent(btnModificarMovilIntermediario)
                    .addComponent(btnEliminarMovilIntermediario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMovilIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pestañas.addTab("Intermediarios             ", tabIntermediario);

        lblFechaObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaObservacion.setText("(*) Fecha:");

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("(*) Descripción:");

        txtFechaObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaObservacion.setPlaceholder("dd/mm/aaaa");
        txtFechaObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaObservacionActionPerformed(evt);
            }
        });

        chooserFechaObservacion.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaObservacionOnCommit(evt);
            }
        });

        textDescripcion.setColumns(20);
        textDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textDescripcion.setRows(5);
        scrollTextObservacion.setViewportView(textDescripcion);

        btnAgregarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarObservacion.setText("Agregar");
        btnAgregarObservacion.setToolTipText("Botón para agregar una nueva observación.");
        btnAgregarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarObservacionActionPerformed(evt);
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

        btnEliminarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarObservacion.setText("Eliminar");
        btnEliminarObservacion.setToolTipText("Botón para eliminar al observación seleccionada.");
        btnEliminarObservacion.setEnabled(false);
        btnEliminarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarObservacionActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout tabObservacionLayout = new javax.swing.GroupLayout(tabObservacion);
        tabObservacion.setLayout(tabObservacionLayout);
        tabObservacionLayout.setHorizontalGroup(
            tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabObservacionLayout.createSequentialGroup()
                        .addComponent(btnAgregarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabObservacionLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblFechaObservacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabObservacionLayout.createSequentialGroup()
                                .addComponent(txtFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scrollTextObservacion))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabObservacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        tabObservacionLayout.setVerticalGroup(
            tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabObservacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaObservacion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooserFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion)
                    .addComponent(scrollTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarObservacion)
                    .addGroup(tabObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarObservacion)
                        .addComponent(btnModificarObservacion)
                        .addComponent(btnSeleccionObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        Pestañas.addTab("Observaciones           ", tabObservacion);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de registro de clientes.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el cliente.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtDni.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDni.setPlaceholder("Sólo 8 dígitos.");

        lblDni.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDni.setText("(*) Dni:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre del cliente.");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        txtFechaNacimiento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaNacimiento.setPlaceholder("dd/mm/aaaa");

        chooserFechaCliente.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaCliente.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaClienteOnCommit(evt);
            }
        });

        lblFechaNacimiento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaNacimiento.setText("Fecha Nac.:");

        btnGroupGenero.add(rbtnMasculino);
        rbtnMasculino.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rbtnMasculino.setText("Masculino");

        lblGenero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblGenero.setText("Género:");

        btnGroupGenero.add(rbtnFemenino);
        rbtnFemenino.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rbtnFemenino.setText("Femenino");

        javax.swing.GroupLayout panelBoletaLayout = new javax.swing.GroupLayout(panelBoleta);
        panelBoleta.setLayout(panelBoletaLayout);
        panelBoletaLayout.setHorizontalGroup(
            panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoletaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoletaLayout.createSequentialGroup()
                        .addComponent(lblDni)
                        .addGap(33, 33, 33)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBoletaLayout.createSequentialGroup()
                        .addComponent(lblFechaNacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooserFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoletaLayout.createSequentialGroup()
                        .addComponent(rbtnMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFemenino)
                        .addContainerGap(330, Short.MAX_VALUE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBoletaLayout.setVerticalGroup(
            panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoletaLayout.createSequentialGroup()
                .addGroup(panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooserFechaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaNacimiento)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnFemenino)
                        .addComponent(rbtnMasculino)
                        .addComponent(lblGenero))))
        );

        lblRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRuc.setText("(*) Ruc:");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRazonSocial.setText("(*) Razón Social:");

        txtRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRuc.setPlaceholder("Sólo 12 dígitos.");
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });

        txtRazonSocial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRazonSocial.setPlaceholder("Escribir aquí la razón social del cliente.");

        btnVerificaRuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnVerificaRuc.setToolTipText("Botón para verificar existencia del ruc.");
        btnVerificaRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificaRucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFacturaLayout = new javax.swing.GroupLayout(panelFactura);
        panelFactura.setLayout(panelFacturaLayout);
        panelFacturaLayout.setHorizontalGroup(
            panelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRuc)
                .addGap(27, 27, 27)
                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerificaRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRazonSocial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        panelFacturaLayout.setVerticalGroup(
            panelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVerificaRuc, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblRuc)
                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblRazonSocial)
                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("NUEVO CLIENTE");

        boxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clientes (Boletas)", "Clientes (Facturas)" }));
        boxTipoCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boxTipoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoClienteItemStateChanged(evt);
            }
        });

        lblTipoCliente.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTipoCliente.setText("Tipo :");

        lblEstado.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(457, 457, 457)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pestañas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(panelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblTipoCliente)
                                .addGap(35, 35, 35)
                                .addComponent(boxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAviso))
                        .addGap(18, 18, 18)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoCliente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean esClienteBoletaRepetido(String dni, String nombres, int codigo) throws SQLException {
        cliente = null;
        cliente = ClienteBL.getInstance().getRepeatBoleta(dni, nombres, codigo);
        return cliente != null;
    }
    
    private boolean esClienteFacturaRepetido(String ruc, String razon, int codigo) throws SQLException {        
        cliente = null;
        cliente = ClienteBL.getInstance().getRepeatFactura(ruc, razon, codigo);
        return cliente != null;
    }
    
    private void inicializarVariables() {
        cliente = null;
        direccion = null;
        telefono = null;
        observacion = null;
        cuenta = null;
        empleadoTratar = null;
        esRepetido = false;
        result = false;
        telefonoIncluido = false;
        codigoCliente = "";
        codEmpleado = 0;
        sex = 0;
        textdire = "-";
        textllegada = "-";
        textemail = "-";
        fechaNacimiento = "1111-11-11";
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
        registroEmpleado = new String[2];
        registroEmpleado[0] = "-";
        registroEmpleado[1] = "";
        registroTelefonoEmpleado = new String[4];
        registroTelefonoEmpleado[0] = "";
        registroTelefonoEmpleado[1] = "";
        registroTelefonoEmpleado[2] = "";
        registroTelefonoEmpleado[3] = "";
        registroObservacion = new String[2];
        registroObservacion[0] = "";       
        registroObservacion[1] = "";       
    }
    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        inicializarVariables();
        if (!txtDireccion.getText().equals("")) {         textdire = txtDireccion.getText();    }
        if (!txtLlegada.getText().equals("")) {           textllegada = txtLlegada.getText();   }
        if (!txtEmail.getText().equals("")) {             textemail = txtEmail.getText();       }

        if (panelFactura.isVisible()) {
            if (txtRuc.getText().equals("") || txtRazonSocial.getText().equals("")) {
                Messages.messageAlert();
            } else {
                try {
                    esRepetido = esClienteFacturaRepetido(txtRuc.getText(), txtRazonSocial.getText(), 0);
                    if (esRepetido == false) {
                        cliente = new ClienteDTO(
                                txtRuc.getText(),
                                txtRazonSocial.getText(),
                                textdire,
                                textllegada,
                                textemail,
                                fechaCreacion
                        );
                        result = ClienteBL.getInstance().insert(cliente);
                        if (!result) Messages.messageError("Error al insertar cliente factura.");
                        
                        cliente = null;
                        cliente = ClienteBL.getInstance().getByDniOrRuc(txtRuc.getText(), 0);
                        codigoCliente = String.valueOf(cliente.getCodigo());
                    } else {      Messages.messageRepeat();      }
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }
        } else {
            if (txtDni.getText().equals("") || txtNombre.getText().equals("")) {
                Messages.messageAlert();
            } else {
                try {
                    esRepetido = esClienteBoletaRepetido(txtDni.getText(), txtNombre.getText(), 0);
                    
                    if (esRepetido == false) {
                        if (!txtFechaNacimiento.getText().equals("")) {
                            try {
                                fechaNacimiento = Global.formatSQL(txtFechaNacimiento.getText());
                            } catch (ParseException ex) {
                                Messages.messageError("Error: " + ex.toString());
                                logger.error(ex);
                            }
                        }
                        if (rbtnMasculino.isSelected()) { sex = 2; }
                        if (rbtnFemenino.isSelected()) {  sex = 1; }
                        
                        cliente = new ClienteDTO(
                                txtDni.getText(),
                                txtNombre.getText(),
                                String.valueOf(sex),
                                fechaNacimiento,
                                textdire,
                                textllegada,
                                textemail,
                                fechaCreacion
                        );
                        result = ClienteBL.getInstance().insert(cliente);
                        if (!result) Messages.messageError("Error al insertar cliente boleta.");
                        
                        cliente = null;
                        cliente = ClienteBL.getInstance().getByDniOrRuc(txtDni.getText(), 1);
                        codigoCliente = String.valueOf(cliente.getCodigo());
                    } else {        Messages.messageRepeat();          }
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }
        }

        if (esRepetido == false) {
            String telef, tiptelef;
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
                            "CLIENTE",
                            codigoCliente
                    );
                    result = TelefonoBL.getInstance().insert(telefono);
                    if (!result)    Messages.messageAlert("Error en datos de telefono.");
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }
            
            if ((!boxDepartamento.getSelectedItem().toString().equals("") || boxDepartamento.getSelectedItem() == null) && 
                    !txtProvincia.getText().equals("") && !txtDistrito.getText().equals("")) {
                try {
                    direccion = new DireccionDTO(
                            boxDepartamento.getSelectedItem().toString(),
                            txtProvincia.getText(),
                            txtDistrito.getText(),
                            "CLIENTE",
                            codigoCliente
                    );
                    
                    result = DireccionBL.getInstance().insert(direccion);
                    if (!result)    Messages.messageAlert("Error en datos de direccion.");
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }
            
            for (int cnt1 = 0; cnt1 < tblCuenta.getRowCount(); cnt1++) {
                try {
                    codigoEmp = "-"; recaudo = "-";
                    if (tblCuenta.getValueAt(cnt1, 3) != null) {      codigoEmp = tblCuenta.getValueAt(cnt1, 3).toString();   }
                    if (tblCuenta.getValueAt(cnt1, 4) != null) {      recaudo = tblCuenta.getValueAt(cnt1, 4).toString();   }
                    cuenta = new CuentaBancariaDTO(
                            tblCuenta.getValueAt(cnt1, 0).toString(),
                            tblCuenta.getValueAt(cnt1, 1).toString(),
                            tblCuenta.getValueAt(cnt1, 2).toString(),
                            codigoEmp,
                            recaudo,
                            "CLIENTE",
                            codigoCliente
                    );
                    
                    result = CuentaBancariaBL.getInstance().insert(cuenta);
                    if (!result)        Messages.messageError("Error al insertas cuentas bancarias.");
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }

            for (int z = 0; z < tblIntermediario.getRowCount(); z++) {
                try {
                    emplDni = "-";
                    if (tblIntermediario.getValueAt(z, 0) != null) {       emplDni = tblIntermediario.getValueAt(z, 0).toString();     }
                    empleadoTratar = new EmpleadoTratarDTO(
                            emplDni,
                            tblIntermediario.getValueAt(z, 1).toString(),
                            new ClienteDTO(Integer.parseInt(codigoCliente))
                    );
                    result = EmpleadoTratarBL.getInstance().insert(empleadoTratar);
                    if (!result) Messages.messageError("Error en insertar intermediarios.");
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            }

            
            for (int zz = 0; zz < tblMovilIntermediario.getRowCount(); zz++) {
                codEmpleado = 0;
                try {
                    for (int aa = 0; aa < tblIntermediario.getRowCount(); aa++) {
                        if ((tblMovilIntermediario.getValueAt(zz, 0).toString()).equals(tblIntermediario.getValueAt(aa, 1).toString())) {
                            try {
                                codEmpleado = EmpleadoTratarBL.getInstance().listByDniByNombres(tblIntermediario.getValueAt(aa, 0).toString(),
                                        tblIntermediario.getValueAt(aa, 1).toString());
                            } catch (SQLException ex) {
                                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                                logger.error(ex);
                            }break;
                        }
                    }

                    telefono = new TelefonoDTO(
                            tblMovilIntermediario.getValueAt(zz, 1).toString(),
                            tblMovilIntermediario.getValueAt(zz, 2).toString(),
                            tblMovilIntermediario.getValueAt(zz, 3).toString(),
                            "EMPLEADO_TRATAR",
                            String.valueOf(codEmpleado)
                    );

                    result = TelefonoBL.getInstance().insert(telefono);
                    if (!result) Messages.messageError("Error en insertar telefono de intermediarios.");
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
                            "CLIENTE",
                            codigoCliente
                    );
                    result = ObservacionBL.getInstance().insert(observacion);
                    if (!result)    Messages.messageAlert("Error en datos de observacion.");
                } catch (ParseException | SQLException ex) {
                    logger.error(ex);
                }
            }
            if (!codigoCliente.equals("")) {
                Messages.messageInsert();
                limpiarCampos(); 
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    public static void limpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(0);
        }
    }

    void limpiarCampos() {
        boxTipoCliente.setSelectedItem("");
        txtRuc.setText("");
        txtNombre.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtDni.setText("");
        txtFechaNacimiento.setText("");
        txtEmail.setText("");
        btnGroupGenero.clearSelection();
        boxDepartamento.setSelectedItem(null);
        txtProvincia.setText("");
        txtDistrito.setText("");
        txtLlegada.setText("");
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");
        boxTelefonia.setSelectedItem(null);
        boxTelefoniaIntermediario.setSelectedItem(null);
        boxTipoTelefoniaIntermediario.setSelectedItem(null);
        txtNumeroIntermediario.setText("");
        boxTipoTelefonia.setSelectedItem(null);
        txtNumero.setText("");
        textDescripcion.setText("");
        txtFechaObservacion.setText("");
        boxReferencia.removeAllItems();
        vacearTablas();
    }

    public static void vacearTablas() {
        limpiarTabla(tblTelefono, modeloTelefono);
        limpiarTabla(tblObservacion, modeloObservacion);
        limpiarTabla(tblIntermediario, modeloEmpleado);
        limpiarTabla(tblMovilIntermediario, modeloTelfEmpleado);
        limpiarTabla(tblCuenta, modeloCuenta);
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
    }//GEN-LAST:event_btnModificarActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chooserFechaClienteOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaClienteOnCommit
        txtFechaNacimiento.setText(chooserFechaCliente.getText());
    }//GEN-LAST:event_chooserFechaClienteOnCommit

    private void btnEliminarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilActionPerformed
        result = false;
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            Messages.messageDelete();
            ActivaTelefono();
            modeloTelefono.removeRow(filaTelefono);
        }
    }//GEN-LAST:event_btnEliminarMovilActionPerformed

    private void btnAgregarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMovilActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {
            for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 2).toString())) {
                    esRepetido = true;
                }
            }          
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                Messages.messageInsert();
                if (boxTelefonia.getSelectedItem() != null) {     registroTelefono[0] = boxTelefonia.getSelectedItem().toString();     }
                if (boxTipoTelefonia.getSelectedItem() != null) { registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                registroTelefono[2] = txtNumero.getText();
                modeloTelefono.addRow(registroTelefono);
                tblTelefono.setModel(modeloTelefono);
                ActivaTelefono();
            }
        }
    }//GEN-LAST:event_btnAgregarMovilActionPerformed

    private void btnModificarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMovilActionPerformed
        inicializarVariables();
        if (txtNumero.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblTelefono.getValueAt(filaTelefono, 2).toString().equals(txtNumero.getText())) {
                for (int cont = 0; cont < tblTelefono.getRowCount(); cont++) {
                    if (txtNumero.getText().equals(tblTelefono.getValueAt(cont, 2).toString())) {
                        esRepetido = true;
                    }
                }
            }                  
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                if (boxTelefonia.getSelectedItem() != null) {     registroTelefono[0] = boxTelefonia.getSelectedItem().toString();     }
                if (boxTipoTelefonia.getSelectedItem() != null) { registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                registroTelefono[2] = txtNumero.getText(); 
                
                Messages.messageUpdate();                  
                for (int i = 0; i < tblTelefono.getColumnCount(); i++) {
                    modeloTelefono.setValueAt(registroTelefono[i], filaTelefono, i);
                }
            }
        }
    }//GEN-LAST:event_btnModificarMovilActionPerformed

    private void tblTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonoMouseClicked
        tblTelefono.setRowSelectionAllowed(true);
        filaTelefono = tblTelefono.getSelectedRow();
        if (tblTelefono.getValueAt(filaTelefono, 0) != null) {
            boxTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 0).toString());
        }
        if (tblTelefono.getValueAt(filaTelefono, 1) != null) {
            boxTipoTelefonia.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 1).toString());
        }
        txtNumero.setText(tblTelefono.getValueAt(filaTelefono, 2).toString());

        btnAgregarMovil.setEnabled(false);
        btnModificarMovil.setEnabled(true);
        btnEliminarMovil.setEnabled(true);
        btnSeleccionMovil.setEnabled(true);
    }//GEN-LAST:event_tblTelefonoMouseClicked

    public static void cargarComboReferencia() {
        boxReferencia.addItem(txtNombreIntermediario.getText());
        txtDniIntermediario.setText("");
        txtNombreIntermediario.setText("");        
    }

    private void btnAgregarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIntermediarioActionPerformed
        inicializarVariables();
        if (txtNombreIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!txtDniIntermediario.getText().equals("")) {    registroEmpleado[0] = txtDniIntermediario.getText();   }
            registroEmpleado[1] = txtNombreIntermediario.getText();
            
            for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                if (!registroEmpleado[0].equals("-")) {
                    if (registroEmpleado[0].equals(tblIntermediario.getValueAt(cont, 0).toString()) &&
                            registroEmpleado[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                } else {
                    if (registroEmpleado[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                cargarComboReferencia();
                Messages.messageInsert();
                ActivaEmpleadoTratar();                    
                modeloEmpleado.addRow(registroEmpleado);
                tblIntermediario.setModel(modeloEmpleado);     
            }
        }
    }//GEN-LAST:event_btnAgregarIntermediarioActionPerformed

    private void tblIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIntermediarioMouseClicked
        tblIntermediario.setRowSelectionAllowed(true);
        filaEmpleadoTratar = tblIntermediario.getSelectedRow();
        if (tblIntermediario.getValueAt(filaEmpleadoTratar, 0) == null) {     txtDniIntermediario.setText("-");   }
        else{       txtDniIntermediario.setText(tblIntermediario.getValueAt(filaEmpleadoTratar, 0).toString());   }
        txtNombreIntermediario.setText(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString());

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
            if (!txtDniIntermediario.getText().equals("")) {        registroEmpleado[0] = txtDniIntermediario.getText();     }
            registroEmpleado[1] = txtNombreIntermediario.getText();
            
            for (int cont = 0; cont < tblIntermediario.getRowCount(); cont++) {
                if (!registroEmpleado[0].equals("-")) {
                    if (registroEmpleado[0].equals(tblIntermediario.getValueAt(cont, 0).toString()) &&
                            registroEmpleado[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                } else {
                    if (registroEmpleado[1].equals(tblIntermediario.getValueAt(cont, 1).toString())) {
                        esRepetido = true;
                    }
                }
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                Messages.messageUpdate();
                boxReferencia.removeItem(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString());                    
                boxReferencia.addItem(registroEmpleado[1]);     
                ActivaEmpleadoTratar();
                for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                    if (tblMovilIntermediario.getValueAt(co, 0).toString().equals(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString())) {
                        modeloTelfEmpleado.setValueAt(registroEmpleado[1], co, 0);
                    }
                }
                for (int i = 0; i < tblIntermediario.getColumnCount(); i++) {
                    modeloEmpleado.setValueAt(registroEmpleado[i], filaEmpleadoTratar, i);
                }  
            }
        }
    }//GEN-LAST:event_btnModificarIntermediarioActionPerformed

    private void btnEliminarIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIntermediarioActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                if (tblMovilIntermediario.getValueAt(co, 0).toString().equals(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString())) {
                    telefonoIncluido = true;
                }
            }         

            if (telefonoIncluido == true) {
                eliminaTelefonoIncluido = Messages.messageConfirmation("El intermediario tiene teléfono(s) almacenado(s), si continua se eliminara el intermediario junto con sus teléfonos.");
                if (0 == eliminaTelefonoIncluido) {
                    Messages.messageDelete();
                    ActivaEmpleadoTratar();
                    for (int co = 0; co < tblMovilIntermediario.getRowCount(); co++) {
                        if (tblMovilIntermediario.getValueAt(co, 0).toString().equals(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString())) {
                            modeloTelfEmpleado.removeRow(co);
                            co--;
                        }
                    }
                    boxReferencia.removeItem(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString());
                    modeloEmpleado.removeRow(filaEmpleadoTratar);
                } else {        Messages.messageAlert("El intermediario no se elimino.");            }
            } else {
                Messages.messageDelete();
                ActivaEmpleadoTratar();
                boxReferencia.removeItem(tblIntermediario.getValueAt(filaEmpleadoTratar, 1).toString());
                modeloEmpleado.removeRow(filaEmpleadoTratar);
            }
        }
    }//GEN-LAST:event_btnEliminarIntermediarioActionPerformed

    private void tblObservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObservacionMouseClicked
        tblObservacion.setRowSelectionAllowed(true);
        filaObservacion = tblObservacion.getSelectedRow();
        textDescripcion.setText(tblObservacion.getValueAt(filaObservacion, 1).toString());
        txtFechaObservacion.setText(tblObservacion.getValueAt(filaObservacion, 0).toString());

        btnAgregarObservacion.setEnabled(false);
        btnModificarObservacion.setEnabled(true);
        btnEliminarObservacion.setEnabled(true);
        btnSeleccionObservacion.setEnabled(true);
    }//GEN-LAST:event_tblObservacionMouseClicked

    private void chooserFechaObservacionOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaObservacionOnCommit
        txtFechaObservacion.setText(chooserFechaObservacion.getText());
    }//GEN-LAST:event_chooserFechaObservacionOnCommit

    private void btnModificarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem() == null || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                       registroTelefonoEmpleado[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       registroTelefonoEmpleado[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   registroTelefonoEmpleado[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
                                                   registroTelefonoEmpleado[3] = txtNumeroIntermediario.getText();
            
            if (!tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 3).toString().equals(registroTelefonoEmpleado[3])) {
                for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                    if (registroTelefonoEmpleado[3].equals(tblMovilIntermediario.getValueAt(cont, 3).toString())) {
                        esRepetido = true;
                    }
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                Messages.messageInsert();                    
                ActivaTelefonoEmpleado();
                for (int i = 0; i < tblMovilIntermediario.getColumnCount(); i++) {
                    modeloTelfEmpleado.setValueAt(registroTelefonoEmpleado[i], filaTelefonoEmpleado, i);
                }
            }
        }
    }//GEN-LAST:event_btnModificarMovilIntermediarioActionPerformed

    private void btnAgregarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMovilIntermediarioActionPerformed
        inicializarVariables();
        if (boxReferencia.getSelectedItem() == null || txtNumeroIntermediario.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                       registroTelefonoEmpleado[0] = boxReferencia.getSelectedItem().toString();
            if (boxTelefoniaIntermediario.getSelectedItem() != null) {       registroTelefonoEmpleado[1] = boxTelefoniaIntermediario.getSelectedItem().toString();       }
            if (boxTipoTelefoniaIntermediario.getSelectedItem() != null) {   registroTelefonoEmpleado[2] = boxTipoTelefoniaIntermediario.getSelectedItem().toString();   }
                                                   registroTelefonoEmpleado[3] = txtNumeroIntermediario.getText();
            
            for (int cont = 0; cont < tblMovilIntermediario.getRowCount(); cont++) {
                if (registroTelefonoEmpleado[3].equals(tblMovilIntermediario.getValueAt(cont, 3).toString())) {
                    esRepetido = true;
                }
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                Messages.messageInsert();                    
                tblMovilIntermediario.setModel(modeloTelfEmpleado);
                ActivaTelefonoEmpleado();
                modeloTelfEmpleado.addRow(registroTelefonoEmpleado);
            }
        }
    }//GEN-LAST:event_btnAgregarMovilIntermediarioActionPerformed

    private void btnEliminarMovilIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilIntermediarioActionPerformed
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            Messages.messageDelete();
            modeloTelfEmpleado.removeRow(filaTelefonoEmpleado);
            ActivaTelefonoEmpleado();
        }
    }//GEN-LAST:event_btnEliminarMovilIntermediarioActionPerformed

    private void tblMovilIntermediarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovilIntermediarioMouseClicked
        tblMovilIntermediario.setRowSelectionAllowed(true);
        filaTelefonoEmpleado = tblMovilIntermediario.getSelectedRow();
        boxReferencia.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 0).toString());
        if (tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 1) == null) {
            boxTelefoniaIntermediario.setSelectedItem(null);
        } else {
            boxTelefoniaIntermediario.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 1).toString());
        }
        if (tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 2) == null) {
            boxTipoTelefoniaIntermediario.setSelectedItem(null);
        } else {
            boxTipoTelefoniaIntermediario.setSelectedItem(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 2).toString());
        }
        txtNumeroIntermediario.setText(tblMovilIntermediario.getValueAt(filaTelefonoEmpleado, 3).toString());

        btnAgregarMovilIntermediario.setEnabled(false);
        btnModificarMovilIntermediario.setEnabled(true);
        btnEliminarMovilIntermediario.setEnabled(true);
        btnSeleccionMovilIntermediario.setEnabled(true);
    }//GEN-LAST:event_tblMovilIntermediarioMouseClicked

    private void btnAgregarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarObservacionActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFechaObservacion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            Messages.messageInsert();
            registroObservacion[0] = txtFechaObservacion.getText();
            registroObservacion[1] = textDescripcion.getText();
            modeloObservacion.addRow(registroObservacion);
            tblObservacion.setModel(modeloObservacion);  
            ActivaObservacion();    
        }
    }//GEN-LAST:event_btnAgregarObservacionActionPerformed

    private void btnModificarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarObservacionActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFechaObservacion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            Messages.messageUpdate();                
            registroObservacion[0] = txtFechaObservacion.getText();
            registroObservacion[1] = textDescripcion.getText();
            for (int i = 0; i < tblObservacion.getColumnCount(); i++) {
                modeloObservacion.setValueAt(registroObservacion[i], filaObservacion, i);
            } 
            ActivaObservacion();   
        }
    }//GEN-LAST:event_btnModificarObservacionActionPerformed

    private void btnEliminarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarObservacionActionPerformed
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            Messages.messageDelete();
            modeloObservacion.removeRow(filaObservacion);
            ActivaObservacion();
        }
    }//GEN-LAST:event_btnEliminarObservacionActionPerformed

    private void btnAgregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCuentaActionPerformed
        inicializarVariables();
        if (txtCuenta.getText().equals("") || boxMonedas.getSelectedItem().toString().equals("") || txtBanco.getText().equals("")) {
            Messages.messageAlert();
        } else {
                                                    registroCuenta[0] = txtCuenta.getText();
                                                    registroCuenta[1] = boxMonedas.getSelectedItem().toString();
                                                    registroCuenta[2] = txtBanco.getText();
            if (!txtCodEmpresa.getText().equals("")) {  registroCuenta[3] = txtCodEmpresa.getText();   }
            if (!txtRecaudo.getText().equals("")) {     registroCuenta[4] = txtRecaudo.getText();      }
            
            for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                if (txtCuenta.getText().equals(tblCuenta.getValueAt(cont, 0).toString())) {
                    esRepetido = true;
                }
            }
            
            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {               
                Messages.messageInsert();                    
                ActivaCuenta();
                modeloCuenta.addRow(registroCuenta);
                tblCuenta.setModel(modeloCuenta);
            }
        }
    }//GEN-LAST:event_btnAgregarCuentaActionPerformed

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
            
            if (!registroCuenta[0].equals(tblCuenta.getValueAt(filaCuenta, 0).toString())) {
                for (int cont = 0; cont < tblCuenta.getRowCount(); cont++) {
                    if (registroCuenta[0].equals(tblCuenta.getValueAt(cont, 0).toString())) {
                        esRepetido = true;
                    }
                }
            }

            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {                 
                Messages.messageUpdate();                    
                ActivaCuenta();
                for (int i = 0; i < tblCuenta.getColumnCount(); i++) {
                    modeloCuenta.setValueAt(registroCuenta[i], filaCuenta, i);
                }
            }
        }
    }//GEN-LAST:event_btnModificarCuentaActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            Messages.messageDelete();                
            ActivaCuenta();
            modeloCuenta.removeRow(filaCuenta);
        }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void tblCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentaMouseClicked
        tblCuenta.setRowSelectionAllowed(true);
        filaCuenta = tblCuenta.getSelectedRow();
        txtCuenta.setText(tblCuenta.getValueAt(filaCuenta, 0).toString());
        boxMonedas.setSelectedItem(tblCuenta.getValueAt(filaCuenta, 1).toString());
        txtBanco.setText(tblCuenta.getValueAt(filaCuenta, 2).toString());
        if (tblCuenta.getValueAt(filaCuenta, 3) == null) { txtCodEmpresa.setText("-");         }
        else{   txtCodEmpresa.setText(tblCuenta.getValueAt(filaCuenta, 3).toString());    }

        if (tblCuenta.getValueAt(filaCuenta, 4) == null) { txtRecaudo.setText("-");         }
        else{   txtRecaudo.setText(tblCuenta.getValueAt(filaCuenta, 4).toString());    }
        btnAgregarCuenta.setEnabled(false);
        btnModificarCuenta.setEnabled(true);
        btnEliminarCuenta.setEnabled(true);
        btnSeleccionCuenta.setEnabled(true);
    }//GEN-LAST:event_tblCuentaMouseClicked

    void ActivaCuenta() {
        tblCuenta.setRowSelectionAllowed(false);
        txtCuenta.requestFocus();
        txtCuenta.setText("");
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


    private void txtFechaObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaObservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaObservacionActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = "https://login.live.com/login.srf?wa=wsignin1.0&ct=1428133927&rver=6.1.6206.0&sa=1&ntprob=-1&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fmail.live.com%2F%3Fowa%3D1%26owasuffix%3Dowa%252f&id=64855&snsc=1&cbcxt=mail";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
             Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {      }
    }//GEN-LAST:event_btnEmailActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        crudModificar = 0;
    }//GEN-LAST:event_formWindowClosing

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtDni.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        txtRazonSocial.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        boxDepartamento.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void boxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDepartamentoActionPerformed
        txtProvincia.requestFocus();
    }//GEN-LAST:event_boxDepartamentoActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        txtDistrito.requestFocus();
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void txtDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDistritoActionPerformed
        txtLlegada.requestFocus();
    }//GEN-LAST:event_txtDistritoActionPerformed

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

    private void txtNombreIntermediarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreIntermediarioKeyPressed
        if (btnAgregarIntermediario.isEnabled()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                btnAgregarIntermediario.doClick();
            }
        }
    }//GEN-LAST:event_txtNombreIntermediarioKeyPressed

    private void boxReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxReferenciaActionPerformed
        boxTelefoniaIntermediario.requestFocus();
    }//GEN-LAST:event_boxReferenciaActionPerformed

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

    private void boxTipoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTipoClienteItemStateChanged
        verificarComboTipoCliente();
    }//GEN-LAST:event_boxTipoClienteItemStateChanged

    private void verificarComboTipoCliente() {
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Boletas)")) {
            panelBoleta.setVisible(true);
            panelBoleta.setEnabled(true);
            panelFactura.setVisible(false);
        }
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Facturas)")) {
            panelBoleta.setVisible(false);
            panelFactura.setVisible(true);
            panelFactura.setEnabled(true);
        }
    }
    
    private void btnVerificaRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaRucActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {      }
    }//GEN-LAST:event_btnVerificaRucActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes_CRUDPadreFrame dialog = new Clientes_CRUDPadreFrame(new javax.swing.JFrame(), true);
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
    private javax.swing.JTabbedPane Pestañas;
    public static javax.swing.JComboBox boxDepartamento;
    public static javax.swing.JComboBox boxMonedas;
    public static javax.swing.JComboBox boxReferencia;
    public static javax.swing.JComboBox boxTelefonia;
    public static javax.swing.JComboBox boxTelefoniaIntermediario;
    public Folder.DMJCComboBox boxTipoCliente;
    public static javax.swing.JComboBox boxTipoTelefonia;
    public static javax.swing.JComboBox boxTipoTelefoniaIntermediario;
    public static javax.swing.JButton btnAgregarCuenta;
    public static javax.swing.JButton btnAgregarIntermediario;
    public static javax.swing.JButton btnAgregarMovil;
    public static javax.swing.JButton btnAgregarMovilIntermediario;
    public static javax.swing.JButton btnAgregarObservacion;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminarCuenta;
    public static javax.swing.JButton btnEliminarIntermediario;
    public static javax.swing.JButton btnEliminarMovil;
    public static javax.swing.JButton btnEliminarMovilIntermediario;
    public static javax.swing.JButton btnEliminarObservacion;
    private javax.swing.JButton btnEmail;
    public javax.swing.JButton btnGrabar;
    private javax.swing.ButtonGroup btnGroupGenero;
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
    public static datechooser.beans.DateChooserCombo chooserFechaCliente;
    public static datechooser.beans.DateChooserCombo chooserFechaObservacion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblCodEmpresa;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDniIntermediario;
    private javax.swing.JLabel lblEmail;
    public static javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaObservacion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIntermediarios;
    private javax.swing.JLabel lblLlegada;
    private javax.swing.JLabel lblMoneda;
    private javax.swing.JLabel lblMovilIntermediario;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreIntermediario;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblNumeroCuenta;
    private javax.swing.JLabel lblNumeroIntermediario;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRecaudo;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTelefoniaIntermediario;
    private javax.swing.JLabel lblTipoCliente;
    private javax.swing.JLabel lblTipoTelefonia;
    private javax.swing.JLabel lblTipoTelefoniaIntermediario;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JPanel panelBoleta;
    public javax.swing.JPanel panelFactura;
    private javax.swing.JPanel panelUbicacion;
    public javax.swing.JRadioButton rbtnFemenino;
    public javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JScrollPane scrollCuenta;
    private javax.swing.JScrollPane scrollIntermediario;
    private javax.swing.JScrollPane scrollMovilIntermediario;
    private javax.swing.JScrollPane scrollTblObservacion;
    private javax.swing.JScrollPane scrollTelefono;
    private javax.swing.JScrollPane scrollTextObservacion;
    private javax.swing.JPanel tabCuentaBancaria;
    private javax.swing.JPanel tabIntermediario;
    private javax.swing.JPanel tabObservacion;
    private javax.swing.JPanel tabTelefonia;
    private javax.swing.JPanel tabUbicacion;
    public static javax.swing.JTable tblCuenta;
    public static javax.swing.JTable tblIntermediario;
    public static javax.swing.JTable tblMovilIntermediario;
    public static javax.swing.JTable tblObservacion;
    public static javax.swing.JTable tblTelefono;
    public static javax.swing.JTextArea textDescripcion;
    public static Folder.DJCTextFieldWithoutPop txtBanco;
    private Folder.DJCTextFieldWithoutPop txtCodEmpresa;
    public static Folder.DJCTextFieldWithoutPop txtCuenta;
    public Folder.DJCTextFieldWithoutPop txtDireccion;
    public static Folder.DJCTextFieldWithoutPop txtDistrito;
    public Folder.DJCTextFieldWithoutPop txtDni;
    private static Folder.DJCTextFieldWithoutPop txtDniIntermediario;
    public Folder.DJCTextFieldWithoutPop txtEmail;
    public Folder.DJCTextFieldWithoutPop txtFechaNacimiento;
    public static Folder.DJCTextFieldWithoutPop txtFechaObservacion;
    public Folder.DJCTextFieldWithoutPop txtLlegada;
    public Folder.DJCTextFieldWithoutPop txtNombre;
    private static Folder.DJCTextFieldWithoutPop txtNombreIntermediario;
    public static Folder.DJCTextFieldWithoutPop txtNumero;
    public static Folder.DJCTextFieldWithoutPop txtNumeroIntermediario;
    public static Folder.DJCTextFieldWithoutPop txtProvincia;
    public Folder.DJCTextFieldWithoutPop txtRazonSocial;
    private Folder.DJCTextFieldWithoutPop txtRecaudo;
    public Folder.DJCTextFieldWithoutPop txtRuc;
    // End of variables declaration//GEN-END:variables
}
