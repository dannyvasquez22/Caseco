package com.admin.view.employee;

import com.admin.entity.bl.CargoBL;
import com.admin.entity.bl.DetalleCargoBL;
import com.admin.entity.bl.DireccionBL;
import com.admin.entity.bl.EmpleadoBL;
import com.admin.entity.bl.ObservacionBL;
import com.admin.entity.bl.TelefonoBL;
import com.admin.entity.dto.CargoDTO;
import com.admin.entity.dto.DetalleCargoDTO;
import com.admin.entity.dto.DireccionDTO;
import com.admin.entity.dto.EmpleadoDTO;
import com.admin.entity.dto.ObservacionDTO;
import com.admin.entity.dto.TelefonoDTO;
import com.admin.resource.utils.Browser;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ValidateForms;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Empleados_CRUDPadreFrame extends javax.swing.JDialog {
    private DefaultTableModel modeloTelefono, modeloObservacion;
    static ArrayList<String> nombreCargo = new ArrayList<>();
    private EmpleadoDTO empleado = null;
    private TelefonoDTO telefono = null;
    private ObservacionDTO observacion = null;
    private Empleados_Cargo empc = null;
    private static DetalleCargoDTO detalleCargo = null;
    private static DireccionDTO direccion = null;    
    private String []registroTelefono;
    private String []registroObservacion;
    public String codigoEmpleado = "";
    private String browser, url;
    private String fechaNacimiento = "1111-11-11", fechaInicio = "", fechaFin = "1111-11-11", textdni = "-", 
                textdire = "-", textmail = "-", textsueldo = "0.00";
    public int crudModificar = 0; // 0 -> crea empleado desde cero y 1 -> realiza CRUD, cuando ya se creo al empleado.;
    private int sex = 0;
    private int pregunta;
    private int filaTelefono, filaObservacion;
    private boolean esRepetido = false;
    private boolean result = false;
    final static Logger logger = Logger.getLogger(Empleados_CRUDPadreFrame.class);

    public Empleados_CRUDPadreFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        chooserObservacion.setDateFormat(Global.FORMAT_DATE_CLIENT);
        chooserFechaNacimiento.setDateFormat(Global.FORMAT_DATE_CLIENT);
        chooserFechaInicio.setDateFormat(Global.FORMAT_DATE_CLIENT);
        chooserFechaFin.setDateFormat(Global.FORMAT_DATE_CLIENT);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setTitle("Gestión de Empleados");
        txtCodigo.requestFocus();
        try {
            listarCargosBox();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        modelos();
    }
    
    private void modelos() {
        modeloTelefono = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
            }};
        String[] titulos = {"TELEFONÍA", "TIPO TELEFONÍA", "NÚMERO"};
        modeloTelefono.setColumnIdentifiers(titulos);
        tblTelefono.setModel(modeloTelefono);
        ConfigTables.headerTables(tblTelefono);
        ConfigTables.sizeModelCellphone(tblTelefono);

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
        
    public static void listarDetalleCargo(String empleado, String cargo) throws SQLException {
        detalleCargo = null;
        detalleCargo = DetalleCargoBL.getInstance().getByCodigoByCargo(empleado, cargo);
        if (detalleCargo != null) {
            txtSueldo.setText(String.valueOf(detalleCargo.getSueldo()));
            txtFechaInicio.setText(detalleCargo.getFechaInicio());
            txtFechaFin.setText(detalleCargo.getFechaFin());
        }
    }

    public static void listarCargosBox() throws SQLException {
        nombreCargo = CargoBL.getInstance().listAllByCombo(1);
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (String nombre : nombreCargo) {
            modelo.addElement(nombre);            
        }
        boxCargos.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonGroupSexo = new javax.swing.ButtonGroup();
        Pestañas = new javax.swing.JTabbedPane();
        tabComplementarios = new javax.swing.JPanel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new Folder.DJCTextFieldWithoutPop();
        btnEmail = new javax.swing.JButton();
        lblFechaNacimiento = new javax.swing.JLabel();
        chooserFechaNacimiento = new datechooser.beans.DateChooserCombo();
        txtFechaNacimiento = new Folder.DJCTextFieldWithoutPop();
        lblCargo = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblSueldo = new javax.swing.JLabel();
        txtFechaInicio = new Folder.DJCTextFieldWithoutPop();
        chooserFechaInicio = new datechooser.beans.DateChooserCombo();
        txtSueldo = new Folder.DJCTextFieldWithoutPop();
        lblSimboloSueldo = new javax.swing.JLabel();
        panelUbicacion = new javax.swing.JPanel();
        lblProvincia = new javax.swing.JLabel();
        lblDistrito = new javax.swing.JLabel();
        txtProvincia = new Folder.DJCTextFieldWithoutPop();
        lblDepartamento = new javax.swing.JLabel();
        txtDistrito = new Folder.DJCTextFieldWithoutPop();
        boxDepartamento = new javax.swing.JComboBox();
        boxCargos = new javax.swing.JComboBox();
        lblFechaFin = new javax.swing.JLabel();
        txtFechaFin = new Folder.DJCTextFieldWithoutPop();
        chooserFechaFin = new datechooser.beans.DateChooserCombo();
        lblMensaje = new javax.swing.JLabel();
        btnNuevoCargo = new javax.swing.JButton();
        tabTelefonia = new javax.swing.JPanel();
        lblTelefonia = new javax.swing.JLabel();
        btnSeleccionMovil = new javax.swing.JButton();
        boxTipoTelefonia = new javax.swing.JComboBox();
        boxTelefono = new javax.swing.JComboBox();
        txtNumero = new Folder.DJCTextFieldWithoutPop();
        lblTipoTelefonia = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        btnModificarMovil = new javax.swing.JButton();
        btnAgregarMovil = new javax.swing.JButton();
        btnEliminarMovil = new javax.swing.JButton();
        scrollTelefono = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        tabObservaciones = new javax.swing.JPanel();
        btnAgregarObservacion = new javax.swing.JButton();
        lblFechaObservacion = new javax.swing.JLabel();
        chooserObservacion = new datechooser.beans.DateChooserCombo();
        scrollTblObservacion = new javax.swing.JScrollPane();
        tblObservacion = new javax.swing.JTable();
        btnEliminarObservacion = new javax.swing.JButton();
        txtFechaObservacion = new Folder.DJCTextFieldWithoutPop();
        btnModificarObservacion = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        scrollTextObservacion = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextArea();
        btnSeleccionObservacion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        rbtnFemenino = new javax.swing.JRadioButton();
        rbtnMasculino = new javax.swing.JRadioButton();
        txtDNI = new Folder.DJCTextFieldWithoutPop();
        lblCodigo = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        txtCodigo = new Folder.DJCTextFieldWithoutPop();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Pestañas.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N

        lblDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDireccion.setText("Dirección :");

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("Escribir aquí la dirección del empleado.");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEmail.setText("Email :");

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtEmail.setPlaceholder("Ejm: mi-correo@hotmail.com");

        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/email.png"))); // NOI18N
        btnEmail.setToolTipText("Botón para verificar e-mail.");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        lblFechaNacimiento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaNacimiento.setText("Fecha Nacimiento:");

        chooserFechaNacimiento.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaNacimiento.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaNacimientoOnCommit(evt);
            }
        });

        txtFechaNacimiento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaNacimiento.setPlaceholder("dd/mm/aaaa");

        lblCargo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCargo.setText("(*) Cargo:");

        lblFechaInicio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaInicio.setText("(*) Fecha Inicio Trabajo:");

        lblSueldo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblSueldo.setText("Sueldo:");

        txtFechaInicio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaInicio.setPlaceholder("dd/mm/aaaa");

        chooserFechaInicio.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaInicio.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaInicioOnCommit(evt);
            }
        });

        txtSueldo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtSueldo.setPlaceholder("0.00");

        lblSimboloSueldo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblSimboloSueldo.setText("S/.");

        panelUbicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ubicación Terrestre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 11))); // NOI18N

        lblProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblProvincia.setText("Provincia :");

        lblDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDistrito.setText("Distrito:");

        txtProvincia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtProvincia.setPlaceholder("Escribir aquí la provincia donde reside el empleado.");
        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });

        lblDepartamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDepartamento.setText("Departamento: ");

        txtDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDistrito.setPlaceholder("Escribir aquí el distrito donde reside el empleado.");

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
            .addGroup(panelUbicacionLayout.createSequentialGroup()
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUbicacionLayout.createSequentialGroup()
                        .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProvincia)
                            .addComponent(lblDistrito))
                        .addGap(30, 30, 30))
                    .addComponent(lblDepartamento, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelUbicacionLayout.setVerticalGroup(
            panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUbicacionLayout.createSequentialGroup()
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(boxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDistrito)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        boxCargos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblFechaFin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaFin.setText("Fecha Fin Trabajo:");

        txtFechaFin.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaFin.setPlaceholder("dd/mm/aaaa");

        chooserFechaFin.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserFechaFin.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaFinOnCommit(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMensaje.setText("NOTA: En Ubicación Terrestre, los campos son opcionales; sin embargo si llena uno deberá completar los demás.");

        btnNuevoCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/nuevito.png"))); // NOI18N
        btnNuevoCargo.setToolTipText("Botón para crear un nuevo cargo.");
        btnNuevoCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabComplementariosLayout = new javax.swing.GroupLayout(tabComplementarios);
        tabComplementarios.setLayout(tabComplementariosLayout);
        tabComplementariosLayout.setHorizontalGroup(
            tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(tabComplementariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                        .addComponent(lblDireccion)
                        .addGap(53, 53, 53)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabComplementariosLayout.createSequentialGroup()
                                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCargo)
                                    .addComponent(lblEmail))
                                .addGap(54, 54, 54)
                                .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuevoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabComplementariosLayout.createSequentialGroup()
                                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                                        .addComponent(lblFechaNacimiento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(chooserFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabComplementariosLayout.createSequentialGroup()
                                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabComplementariosLayout.createSequentialGroup()
                                        .addComponent(lblSueldo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSimboloSueldo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFechaFin)
                                        .addComponent(lblFechaInicio)))
                                .addGap(18, 18, 18)
                                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtSueldo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                            .addComponent(txtFechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                        .addComponent(lblMensaje)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabComplementariosLayout.setVerticalGroup(
            tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabComplementariosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooserFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFechaNacimiento)
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEmail))
                            .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCargo)
                                .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabComplementariosLayout.createSequentialGroup()
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFechaInicio)
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chooserFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFechaFin)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSueldo)
                            .addComponent(lblSimboloSueldo)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje)
                .addContainerGap())
        );

        Pestañas.addTab("Datos Complementarios         ", tabComplementarios);

        lblTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTelefonia.setText("Telefonía:");

        btnSeleccionMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSeleccionMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnSeleccionMovil.setText("Quitar selección");
        btnSeleccionMovil.setToolTipText("Botón par aquitar la selección del teléfono seleccionado.");
        btnSeleccionMovil.setEnabled(false);
        btnSeleccionMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionMovilActionPerformed(evt);
            }
        });

        boxTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTipoTelefonia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "POSTAPGO", "PREPAGO" }));
        boxTipoTelefonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoTelefoniaActionPerformed(evt);
            }
        });

        boxTelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        boxTelefono.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "CLARO", "MOVISTAR", "ENTEL", "BITEL" }));
        boxTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTelefonoActionPerformed(evt);
            }
        });

        txtNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        lblTipoTelefonia.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTipoTelefonia.setText("Tipo:");

        lblNumero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNumero.setText("(*) Número:");

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
            tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(tabTelefoniaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTelefoniaLayout.createSequentialGroup()
                        .addComponent(lblTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblTipoTelefonia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTelefoniaLayout.createSequentialGroup()
                        .addComponent(btnAgregarMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTelefoniaLayout.createSequentialGroup()
                        .addComponent(scrollTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabTelefoniaLayout.setVerticalGroup(
            tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTelefoniaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonia)
                    .addComponent(lblTipoTelefonia)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipoTelefonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabTelefoniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarMovil)
                    .addComponent(btnModificarMovil)
                    .addComponent(btnAgregarMovil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        Pestañas.addTab("Telefonía                                       ", tabTelefonia);

        btnAgregarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregarObservacion.setText("Agregar");
        btnAgregarObservacion.setToolTipText("Botón para agregar una nueva observación.");
        btnAgregarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarObservacionActionPerformed(evt);
            }
        });

        lblFechaObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblFechaObservacion.setText("(*) Fecha:");

        chooserObservacion.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        chooserObservacion.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserObservacionOnCommit(evt);
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

        btnEliminarObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminarObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminarObservacion.setText("Eliminar");
        btnEliminarObservacion.setToolTipText("Botón para eliminar la observación seleccionada.");
        btnEliminarObservacion.setEnabled(false);
        btnEliminarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarObservacionActionPerformed(evt);
            }
        });

        txtFechaObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtFechaObservacion.setPlaceholder("dd/mm/aaaa");

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

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("(*) Descripción:");

        textDescripcion.setColumns(20);
        textDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        textDescripcion.setRows(5);
        scrollTextObservacion.setViewportView(textDescripcion);

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

        javax.swing.GroupLayout tabObservacionesLayout = new javax.swing.GroupLayout(tabObservaciones);
        tabObservaciones.setLayout(tabObservacionesLayout);
        tabObservacionesLayout.setHorizontalGroup(
            tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabObservacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTblObservacion)
                    .addGroup(tabObservacionesLayout.createSequentialGroup()
                        .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion)
                            .addComponent(lblFechaObservacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabObservacionesLayout.createSequentialGroup()
                                .addComponent(txtFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 438, Short.MAX_VALUE))
                            .addComponent(scrollTextObservacion)))
                    .addGroup(tabObservacionesLayout.createSequentialGroup()
                        .addComponent(btnAgregarObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabObservacionesLayout.setVerticalGroup(
            tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabObservacionesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaObservacion))
                    .addComponent(chooserObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTextObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabObservacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarObservacion)
                    .addComponent(btnModificarObservacion)
                    .addComponent(btnEliminarObservacion)
                    .addComponent(btnSeleccionObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        Pestañas.addTab("Observaciones                             ", tabObservaciones);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de registro de empleados.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrabar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Save.png"))); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.setToolTipText("Botón para grabar un nuevo empleado.");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el empleado requerido.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("NUEVO EMPLEADO");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre :");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí los nombres del empleado.");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        botonGroupSexo.add(rbtnFemenino);
        rbtnFemenino.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rbtnFemenino.setText("Femenino");

        botonGroupSexo.add(rbtnMasculino);
        rbtnMasculino.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        rbtnMasculino.setText("Masculino");

        txtDNI.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDNI.setPlaceholder("Sólo 8 dígitos.");
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCodigo.setText("(*) Código:");

        lblGenero.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblGenero.setText("(*) Género :");

        lblDni.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDni.setText("DNI:");

        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAviso)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addGap(19, 19, 19)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(lblDni)
                                .addGap(10, 10, 10)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(lblGenero)
                                .addGap(6, 6, 6)
                                .addComponent(rbtnMasculino)
                                .addGap(0, 0, 0)
                                .addComponent(rbtnFemenino))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(10, 10, 10)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Pestañas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addGap(2, 2, 2)
                .addComponent(lblTitulo)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblCodigo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblDni))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblGenero))
                    .addComponent(rbtnMasculino)
                    .addComponent(rbtnFemenino))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblNombre))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrabar)
                    .addComponent(btnModificar))
                .addGap(9, 9, 9)
                .addComponent(Pestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        ValidateForms.soloLetras(txtNombre);
        ValidateForms.cantCaracteres(txtNombre, 49);
    }//GEN-LAST:event_txtNombreKeyPressed

    void limpiarCampos() {
        boxCargos.setSelectedItem("");
        txtCodigo.requestFocus();
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        txtSueldo.setText("");
        txtEmail.setText("");
        botonGroupSexo.clearSelection();
        tblTelefono.setModel(new DefaultTableModel());
        tblObservacion.setModel(new DefaultTableModel());
        boxDepartamento.setSelectedItem(null);
        boxCargos.setSelectedItem(null);
        txtProvincia.setText("");
        txtDistrito.setText("");
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    boolean esEmpleadoRepetido(String codigo) throws SQLException{
        empleado = null;
        empleado = EmpleadoBL.getInstance().search(codigo);
        return empleado != null;
    }
    
    private void inicializarVariables() {
        empleado = null;
        detalleCargo = null;
        direccion = null;
        telefono = null;
        observacion = null;
        esRepetido = false;
        result = false;
        fechaNacimiento = "1111-11-11";
        fechaInicio = "";
        fechaFin = "1111-11-11";
        textdni = "-";
        textdire = "-";
        textmail = "-";
        textsueldo = "0.00";
        sex = 0;
        registroTelefono = new String[3];
        registroTelefono[0] = "";
        registroTelefono[1] = "";
        registroTelefono[2] = "";
        registroObservacion = new String[2];
        registroObservacion[0] = "";
        registroObservacion[1] = "";
    }
    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        inicializarVariables();
        if (txtCodigo.getText().equals("") || txtNombre.getText().equals("") || (!rbtnMasculino.isSelected() && !rbtnFemenino.isSelected())
                || txtFechaInicio.getText().equals("") || boxCargos.getSelectedItem() == null) {
            Messages.messageAlert();
        } else {
            try {
                esRepetido = esEmpleadoRepetido(txtCodigo.getText());
                if (esRepetido == false) {
                    if (!txtDNI.getText().equals("")) {       textdni = txtDNI.getText();         }
                    if (!txtDireccion.getText().equals("")) { textdire = txtDireccion.getText();  }
                    if (!txtEmail.getText().equals("")) {     textmail = txtEmail.getText();      }
                    if (!txtSueldo.getText().equals("")) {    textsueldo = txtSueldo.getText();   }
                    
                    try {
                        if (!txtFechaNacimiento.getText().equals("")) {
                            fechaNacimiento = Global.formatSQL(txtFechaNacimiento.getText());
                        }
                        fechaInicio = Global.formatSQL(txtFechaInicio.getText());
                        if (!txtFechaFin.getText().equals("")) {
                            fechaFin = Global.formatSQL(txtFechaFin.getText());
                        }
                    } catch (ParseException ex) {  }
                    if (rbtnMasculino.isSelected()) { sex = 2;  }
                    if (rbtnFemenino.isSelected()) {  sex = 1;  }

                    empleado = new EmpleadoDTO(
                            txtCodigo.getText(), 
                            textdni,
                            txtNombre.getText(), 
                            sex,                          
                            textdire, 
                            textmail, 
                            fechaNacimiento,
                            1
                    );

                    result = EmpleadoBL.getInstance().insert(empleado);
                    if (!result)    Messages.messageError("Error en datos de empleado.");
                    detalleCargo = new DetalleCargoDTO(                        
                            fechaInicio, 
                            fechaFin, 
                            Float.parseFloat(textsueldo), 
                            new EmpleadoDTO(txtCodigo.getText()), 
                            new CargoDTO(boxCargos.getSelectedItem().toString())
                    );

                    result = DetalleCargoBL.getInstance().insert(detalleCargo);
                    if (!result)    Messages.messageError("Error en datos del detalle de cargo.");
                    if (!boxDepartamento.getSelectedItem().toString().equals("") && 
                            !txtProvincia.getText().equals("") && !txtDistrito.getText().equals("")) {
                        direccion = new DireccionDTO(
                                        boxDepartamento.getSelectedItem().toString(),
                                        txtProvincia.getText(),
                                        txtDistrito.getText(),
                                        "EMPLEADO",
                                        txtCodigo.getText()
                                );

                        result = DireccionBL.getInstance().insert(direccion);
                        if (!result)    Messages.messageAlert("Error en datos de direccion.");
                    }

                    result = DireccionBL.getInstance().insert(direccion);
                    if (!result)    Messages.messageError("Error en datos de direccion.");
                    
                    String telef, tiptelef;
                    for (int cnt1 = 0; cnt1 < tblTelefono.getRowCount(); cnt1++) {
                            telefono = null;
                            telef = null;
                            tiptelef = null;
                            if(!tblTelefono.getValueAt(cnt1, 0).toString().equals("")) telef = tblTelefono.getValueAt(cnt1, 0).toString();
                            if(!tblTelefono.getValueAt(cnt1, 1).toString().equals("")) tiptelef = tblTelefono.getValueAt(cnt1, 1).toString();
                            telefono = new TelefonoDTO(
                                    telef,
                                    tiptelef,
                                    tblTelefono.getValueAt(cnt1, 2).toString(),
                                    "EMPLEADO",
                                    txtCodigo.getText()
                            );
                            result = TelefonoBL.getInstance().insert(telefono);
                            if (!result)    Messages.messageError("Error en datos de telefono.");
                    }
                    for (int cnt1 = 0; cnt1 < tblObservacion.getRowCount(); cnt1++) {
                        observacion = null;
                        observacion = new ObservacionDTO(
                            Global.formatSQL(tblObservacion.getValueAt(cnt1, 0).toString()),
                            tblObservacion.getValueAt(cnt1, 1).toString(),
                            "EMPLEADO",
                            codigoEmpleado
                        );
                        result = ObservacionBL.getInstance().insert(observacion);
                        if (!result)    Messages.messageError("Error en datos de observacion.");
                    }
                    limpiarCampos();
                    Messages.messageInsert();
                } else {    Messages.messageRepeat();        }
            } catch (SQLException | ParseException ex) {
                Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void chooserFechaNacimientoOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaNacimientoOnCommit
        txtFechaNacimiento.setText(chooserFechaNacimiento.getText());
    }//GEN-LAST:event_chooserFechaNacimientoOnCommit

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        browser = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        url = "https://login.live.com/login.srf?wa=wsignin1.0&ct=1428133927&rver=6.1.6206.0&sa=1&ntprob=-1&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fmail.live.com%2F%3Fowa%3D1%26owasuffix%3Dowa%252f&id=64855&snsc=1&cbcxt=mail";
        Browser.openURL(url);
        try {
            String[] cmdarray = {browser, url};
            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception ex) {   
            Messages.messageError("Error: " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.warn(ex);
        }
    }//GEN-LAST:event_btnEmailActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        txtNombre.requestFocus();
    }//GEN-LAST:event_txtDNIActionPerformed

    private void chooserFechaInicioOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaInicioOnCommit
        txtFechaInicio.setText(chooserFechaInicio.getText());
    }//GEN-LAST:event_chooserFechaInicioOnCommit

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
                if (boxTelefono.getSelectedItem() != null) {     registroTelefono[0] = boxTelefono.getSelectedItem().toString();     }
                if (boxTipoTelefonia.getSelectedItem() != null) {registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                registroTelefono[2] = txtNumero.getText();                              
                for (int i = 0; i < tblTelefono.getColumnCount(); i++) {
                    modeloTelefono.setValueAt(registroTelefono[i], filaTelefono, i);
                }
                Messages.messageUpdate();
                ActivaTelefono();
            }
        }
    }//GEN-LAST:event_btnModificarMovilActionPerformed

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
                if (boxTelefono.getSelectedItem() != null) {      registroTelefono[0] = boxTelefono.getSelectedItem().toString();     }
                if (boxTipoTelefonia.getSelectedItem() != null) { registroTelefono[1] = boxTipoTelefonia.getSelectedItem().toString(); }
                registroTelefono[2] = txtNumero.getText();
                Messages.messageInsert();
                modeloTelefono.addRow(registroTelefono);
                tblTelefono.setModel(modeloTelefono);
                ActivaTelefono();
            }
        }
    }//GEN-LAST:event_btnAgregarMovilActionPerformed

    private void btnEliminarMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovilActionPerformed
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            Messages.messageDelete();
            ActivaTelefono();
            modeloTelefono.removeRow(filaTelefono);
        }
    }//GEN-LAST:event_btnEliminarMovilActionPerformed

    private void tblTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonoMouseClicked
        tblTelefono.setRowSelectionAllowed(true);
        filaTelefono = tblTelefono.getSelectedRow();
        if (tblTelefono.getValueAt(filaTelefono, 0) != null) {
            boxTelefono.setSelectedItem(tblTelefono.getValueAt(filaTelefono, 0).toString());
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

    private void tblObservacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObservacionMouseClicked
        tblObservacion.setRowSelectionAllowed(true);
        filaObservacion = tblObservacion.getSelectedRow();
        txtFechaObservacion.setText(tblObservacion.getValueAt(filaObservacion, 0).toString());
        textDescripcion.setText(tblObservacion.getValueAt(filaObservacion, 1).toString());        

        btnAgregarObservacion.setEnabled(false);
        btnModificarObservacion.setEnabled(true);
        btnEliminarObservacion.setEnabled(true);
        btnSeleccionObservacion.setEnabled(true);
    }//GEN-LAST:event_tblObservacionMouseClicked

    private void btnEliminarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarObservacionActionPerformed
        pregunta = Messages.messageDeactive();
        if (0 == pregunta) {
            Messages.messageDelete();
            modeloObservacion.removeRow(filaObservacion);
            ActivaObservacion();
        }
    }//GEN-LAST:event_btnEliminarObservacionActionPerformed

    private void btnModificarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarObservacionActionPerformed
        inicializarVariables();
        if (textDescripcion.getText().equals("") || txtFechaObservacion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            registroObservacion[0] = txtFechaObservacion.getText();
            registroObservacion[1] = textDescripcion.getText();
            for (int i = 0; i < tblObservacion.getColumnCount(); i++) {
                modeloObservacion.setValueAt(registroObservacion[i], filaObservacion, i);
            }
            Messages.messageUpdate();
            ActivaObservacion(); 
        }
    }//GEN-LAST:event_btnModificarObservacionActionPerformed

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

    private void chooserObservacionOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserObservacionOnCommit
        txtFechaObservacion.setText(chooserObservacion.getText());
    }//GEN-LAST:event_chooserObservacionOnCommit

    private void chooserFechaFinOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_chooserFechaFinOnCommit
        txtFechaFin.setText(chooserFechaFin.getText());
    }//GEN-LAST:event_chooserFechaFinOnCommit

    void ActivaTelefono() {
        tblTelefono.setRowSelectionAllowed(false);
        boxTelefono.setSelectedItem(null);
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void boxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDepartamentoActionPerformed
        txtProvincia.requestFocus();
    }//GEN-LAST:event_boxDepartamentoActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        txtDistrito.requestFocus();
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void boxTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTelefonoActionPerformed
        boxTipoTelefonia.requestFocus();
    }//GEN-LAST:event_boxTelefonoActionPerformed

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

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        txtDNI.requestFocus();
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnNuevoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCargoActionPerformed
        empc = new Empleados_Cargo(this, true);
        empc.isFrame = 1;
        empc.setVisible(true);
    }//GEN-LAST:event_btnNuevoCargoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleados_CRUDPadreFrame dialog = new Empleados_CRUDPadreFrame(new javax.swing.JFrame(), true);
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
    public javax.swing.ButtonGroup botonGroupSexo;
    public static javax.swing.JComboBox boxCargos;
    public static javax.swing.JComboBox boxDepartamento;
    public static javax.swing.JComboBox boxTelefono;
    public static javax.swing.JComboBox boxTipoTelefonia;
    public static javax.swing.JButton btnAgregarMovil;
    public static javax.swing.JButton btnAgregarObservacion;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminarMovil;
    public static javax.swing.JButton btnEliminarObservacion;
    private javax.swing.JButton btnEmail;
    public javax.swing.JButton btnGrabar;
    public javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnModificarMovil;
    public static javax.swing.JButton btnModificarObservacion;
    private javax.swing.JButton btnNuevoCargo;
    private javax.swing.JButton btnSeleccionMovil;
    private javax.swing.JButton btnSeleccionObservacion;
    public static datechooser.beans.DateChooserCombo chooserFechaFin;
    public static datechooser.beans.DateChooserCombo chooserFechaInicio;
    public static datechooser.beans.DateChooserCombo chooserFechaNacimiento;
    public static datechooser.beans.DateChooserCombo chooserObservacion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDistrito;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaObservacion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSimboloSueldo;
    private javax.swing.JLabel lblSueldo;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTipoTelefonia;
    public javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelUbicacion;
    public javax.swing.JRadioButton rbtnFemenino;
    public javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JScrollPane scrollTblObservacion;
    private javax.swing.JScrollPane scrollTelefono;
    private javax.swing.JScrollPane scrollTextObservacion;
    private javax.swing.JPanel tabComplementarios;
    private javax.swing.JPanel tabObservaciones;
    private javax.swing.JPanel tabTelefonia;
    public static javax.swing.JTable tblObservacion;
    public static javax.swing.JTable tblTelefono;
    public static javax.swing.JTextArea textDescripcion;
    public Folder.DJCTextFieldWithoutPop txtCodigo;
    public Folder.DJCTextFieldWithoutPop txtDNI;
    public Folder.DJCTextFieldWithoutPop txtDireccion;
    public static Folder.DJCTextFieldWithoutPop txtDistrito;
    public Folder.DJCTextFieldWithoutPop txtEmail;
    public static Folder.DJCTextFieldWithoutPop txtFechaFin;
    public static Folder.DJCTextFieldWithoutPop txtFechaInicio;
    public Folder.DJCTextFieldWithoutPop txtFechaNacimiento;
    public static Folder.DJCTextFieldWithoutPop txtFechaObservacion;
    public Folder.DJCTextFieldWithoutPop txtNombre;
    public static Folder.DJCTextFieldWithoutPop txtNumero;
    public static Folder.DJCTextFieldWithoutPop txtProvincia;
    public static Folder.DJCTextFieldWithoutPop txtSueldo;
    // End of variables declaration//GEN-END:variables
}
