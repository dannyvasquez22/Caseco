package com.admin.view.employee;

import com.admin.controller.tablemodel.TEmpleadoUsuario;
import com.admin.entity.bl.CargoBL;
import com.admin.entity.bl.EmpleadoBL;
import com.admin.entity.dto.EmpleadoDTO;
import com.admin.entity.pojo.EmpleadoP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Empleado extends javax.swing.JDialog {
    private static ArrayList<String> nombreCargo;
    private static ArrayList<EmpleadoP> listEmpleados;
    private EmpleadoDTO empleado = null;
    public static String[] array;
    private boolean result = false;
    private Empleados_CRUDPadreDialog nuevos = null;
    private Empleados_CRUDPadreDialog vend = null;
    private Empleados_Telefono temp = null;
    private Empleados_Direccion dir = null;
    private Empleados_Observacion info = null;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Empleado.class);

    public Empleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Empleados");
        try {
            listarCargosBox();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
        //combobox con autocompletado
        //AutocompleteDecorator.decorator(combo);
    }
    
    public static void verificarParametros() {
        array = new String[6];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        array[3] = null;
        array[4] = null;
        if (!txtCodigo.getText().equals(""))                        array[0] = txtCodigo.getText();
        if (!txtDni.getText().equals(""))                           array[1] = txtDni.getText();
        if (!txtNombre.getText().equals(""))                        array[2] = txtNombre.getText();
        if (!boxCargos.getSelectedItem().toString().equals(""))     array[3] = boxCargos.getSelectedItem().toString();
        if (!txtDireccion.getText().equals(""))                     array[4] = txtDireccion.getText();
        if (lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            array[5] = null;
        } else {
            if (lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                array[5] = "1";
            } else {
                array[5] = "0";
            }
        }
        try {
            listarEmpleados(array);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void listarCargosBox() throws SQLException {
        nombreCargo = new ArrayList<>();
        nombreCargo = CargoBL.getInstance().listAllByCombo(1);
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (String nombre : nombreCargo) {
            modelo.addElement(nombre);           
        }
        boxCargos.setModel(modelo);
    }
    
    public static void listarEmpleados(String []array) throws SQLException{
        listEmpleados = new ArrayList<>();
        listEmpleados.clear();
        listEmpleados = EmpleadoBL.getInstance().listEmpleadoCargo(array, 1);
        tblEmpleados.setModel(new TEmpleadoUsuario(listEmpleados));
        ConfigTables.headerTables(tblEmpleados);
        ConfigTables.sizeEmployee(tblEmpleados);
    }

    public static void limpiarTablas(JTable tabla, DefaultTableModel model) {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            model.removeRow(0);
        }
    }

    public void modificarEmpleado(int fila) {
        if (fila >= 0) {
            nuevos = new Empleados_CRUDPadreDialog(this, true);
            nuevos.lblTitulo.setText("MODIFICACION DE EMPLEADOS");
            nuevos.codigoEmpleado = (tblEmpleados.getValueAt(fila, 0).toString());
            nuevos.txtCodigo.setText(tblEmpleados.getValueAt(fila, 0).toString());
            if (!tblEmpleados.getValueAt(fila, 1).toString().equals("-")) {
                nuevos.txtDNI.setText(tblEmpleados.getValueAt(fila, 1).toString());
            }
            nuevos.txtNombre.setText(tblEmpleados.getValueAt(fila, 2).toString());
            nuevos.boxCargos.setSelectedItem(tblEmpleados.getValueAt(fila, 3).toString());
            if ((tblEmpleados.getValueAt(fila, 4).toString()).equals("M")) {
                nuevos.rbtnMasculino.setSelected(true);
            }
            if ((tblEmpleados.getValueAt(fila, 4).toString()).equals("F")) {
                nuevos.rbtnFemenino.setSelected(true);
            }
            if ((tblEmpleados.getValueAt(fila, 4).toString()).equals("")) {
                nuevos.botonGroupSexo.clearSelection();
            }
            nuevos.txtDireccion.setText(tblEmpleados.getValueAt(fila, 5).toString());
            if (tblEmpleados.getValueAt(fila, 6) != null) {
                nuevos.txtEmail.setText(tblEmpleados.getValueAt(fila, 6).toString()); }
            nuevos.txtFechaNacimiento.setText(tblEmpleados.getValueAt(fila, 7).toString());
            if (tblEmpleados.getValueAt(fila, 8).toString().equals("Activo")) {
                nuevos.lblEstado.setText("Activo");
                nuevos.lblEstado.setForeground(Color.blue);
            } else {
                nuevos.lblEstado.setText("Inactivo");
                nuevos.lblEstado.setForeground(Color.red);
            }
            
            try {
                nuevos.listarDirecciones("EMPLEADO", tblEmpleados.getValueAt(fila, 0).toString());
                nuevos.listarDetalleCargo(tblEmpleados.getValueAt(fila, 0).toString(), tblEmpleados.getValueAt(fila, 3).toString());
                nuevos.listarTelefonos("EMPLEADO", tblEmpleados.getValueAt(fila, 0).toString());
                nuevos.listarObservaciones("EMPLEADO", tblEmpleados.getValueAt(fila, 0).toString());
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                logger.warn(ex);
            }

            nuevos.btnGrabar.setEnabled(false);
            nuevos.btnModificar.setEnabled(true);
            nuevos.crudModificar = 1;
            nuevos.setVisible(true);
        } else {   Messages.messageSelected();        }
    }

    private void inicializarVariables() {
        empleado = null;
        result = false;
    }
    
    private void eliminarEmpleado(int fila, int status) throws SQLException {
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            empleado = new EmpleadoDTO(tblEmpleados.getValueAt(fila, 0).toString());
            if (empleado != null) {
                result = EmpleadoBL.getInstance().delete(empleado, status);
                if (result) {
                    if (status == 0) {
                        Messages.messageDelete();
                    } else {
                        Messages.messageUnDelete();
                    }
                    verificarParametros();
                    btnMovil.setEnabled(false);
                    btnUbicacion.setEnabled(false);
                    btnObservacion.setEnabled(false);
                } else {    Messages.messageErrorDelete();     }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        itemPopupModificar = new javax.swing.JMenuItem();
        itemPopupEliminar = new javax.swing.JMenuItem();
        panelBotonesCRUD = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new Folder.DJCTextFieldWithoutPop();
        lblAtajos = new javax.swing.JLabel();
        scrollEmpleado = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnMovil = new javax.swing.JButton();
        btnUbicacion = new javax.swing.JButton();
        btnObservacion = new javax.swing.JButton();
        boxCargos = new Folder.DMJCComboBox();
        lblCargo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        lblDni = new javax.swing.JLabel();
        txtDni = new Folder.DJCTextFieldWithoutPop();
        lblEstado = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        menuBarEmpleados = new javax.swing.JMenuBar();
        menuAccesoRapido = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemDesactivar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemOrdenarCodigo = new javax.swing.JMenuItem();
        itemOrdenarNombre = new javax.swing.JMenuItem();
        itemOrdenarDireccion = new javax.swing.JMenuItem();

        itemPopupModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        itemPopupModificar.setText("Modificar Empleado");
        itemPopupModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupModificarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupModificar);

        itemPopupEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        itemPopupEliminar.setText("Eliminar Empleado");
        itemPopupEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupEliminarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNuevo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 51));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_add.png"))); // NOI18N
        btnNuevo.setText("Nuevo - F1");
        btnNuevo.setToolTipText("Botón para crear un nuevo empleado.");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 102, 51));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_edit.png"))); // NOI18N
        btnModificar.setText("Modificar - Ctrl + M");
        btnModificar.setToolTipText("Botón para modificar el empleado seleccionado.");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnDesactivar.setForeground(new java.awt.Color(0, 102, 51));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_delete.png"))); // NOI18N
        btnDesactivar.setText("Desactivar - Ctrl + D");
        btnDesactivar.setToolTipText("Botón para eliminar el empleado seleccionado.");
        btnDesactivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesactivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 102, 51));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/page_refresh.png"))); // NOI18N
        btnActualizar.setText("Actualizar - F5");
        btnActualizar.setToolTipText("Botón para actualizar la lista de empleados.");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/door_out32.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Botón para cerrar ventana de empleados.");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActivar.setForeground(new java.awt.Color(0, 102, 51));
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group.png"))); // NOI18N
        btnActivar.setText("Activar - Ctrl + A");
        btnActivar.setToolTipText("Botón para crear un nuevo empleado.");
        btnActivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesCRUDLayout = new javax.swing.GroupLayout(panelBotonesCRUD);
        panelBotonesCRUD.setLayout(panelBotonesCRUDLayout);
        panelBotonesCRUDLayout.setHorizontalGroup(
            panelBotonesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesCRUDLayout.createSequentialGroup()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBotonesCRUDLayout.setVerticalGroup(
            panelBotonesCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblCodigo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblCodigo.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        lblAtajos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAtajos.setForeground(new java.awt.Color(0, 102, 51));
        lblAtajos.setText("Nuevo: F1                                                                        Modificar : Ctrl + M                                                                               Borrar : Ctrl + B                                                                      Actualizar: F5");

        scrollEmpleado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblEmpleados.setAutoCreateRowSorter(true);
        tblEmpleados.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblEmpleados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblEmpleados.setComponentPopupMenu(popupMenu);
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        scrollEmpleado.setViewportView(tblEmpleados);

        btnMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/phone_speaker-16.png"))); // NOI18N
        btnMovil.setText("Ver Ubicación Móvil");
        btnMovil.setToolTipText("Botón para visualizar la ubicación móvil del empleado seleccionado.");
        btnMovil.setEnabled(false);
        btnMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovilActionPerformed(evt);
            }
        });

        btnUbicacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/mp.png"))); // NOI18N
        btnUbicacion.setText("Ver Ubicación Terrestre");
        btnUbicacion.setToolTipText("Botón para visualizar la ubicación terrestre del empleado seleccionado.");
        btnUbicacion.setEnabled(false);
        btnUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbicacionActionPerformed(evt);
            }
        });

        btnObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/e36-16.png"))); // NOI18N
        btnObservacion.setText("Ver Observaciones");
        btnObservacion.setToolTipText("Botón para visualizar las observacion hechas al empelado seleccionado.");
        btnObservacion.setEnabled(false);
        btnObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionActionPerformed(evt);
            }
        });

        boxCargos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boxCargos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxCargosItemStateChanged(evt);
            }
        });

        lblCargo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCargo.setText("Cargo :");

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblNombre.setText("Nombre:");

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblDni.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDni.setText("DNI:");

        txtDni.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblEstado.setText("Estado:");

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

        menuAccesoRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/fast.png"))); // NOI18N
        menuAccesoRapido.setText("Acceso Rápido");
        menuAccesoRapido.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N

        itemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemNuevo);

        itemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        itemModificar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        itemModificar.setText("Modificar");
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemModificar);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        jMenuItem1.setText("Activar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(jMenuItem1);

        itemDesactivar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        itemDesactivar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        itemDesactivar.setText("Desactivar");
        itemDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDesactivarActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemDesactivar);
        menuAccesoRapido.add(jSeparator1);

        itemOrdenarCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemOrdenarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        itemOrdenarCodigo.setText("Ordenar por Código");
        itemOrdenarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarCodigoActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemOrdenarCodigo);

        itemOrdenarNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemOrdenarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        itemOrdenarNombre.setText("Ordenar por Nombre");
        itemOrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarNombreActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemOrdenarNombre);

        itemOrdenarDireccion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemOrdenarDireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        itemOrdenarDireccion.setText("Ordenar por Dirección");
        itemOrdenarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarDireccionActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemOrdenarDireccion);

        menuBarEmpleados.add(menuAccesoRapido);

        setJMenuBar(menuBarEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAtajos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollEmpleado)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211)
                        .addComponent(btnUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblCargo)
                            .addComponent(lblNombre))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelBotonesCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(195, 195, 195)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion)
                                    .addComponent(lblDni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(lblEstado)
                                        .addGap(29, 29, 29)
                                        .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(lblInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29))
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCargo))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBotonesCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMovil)
                    .addComponent(btnObservacion)
                    .addComponent(btnUbicacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAtajos))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        vend = new Empleados_CRUDPadreDialog(this, true);
        vend.txtCodigo.requestFocus();
        vend.crudModificar = 0;
        vend.setVisible(true);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        modificarEmpleado(tblEmpleados.getSelectedRow());
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDesactivarActionPerformed
        try {
            eliminarEmpleado(tblEmpleados.getSelectedRow(), 0);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemDesactivarActionPerformed

    private void itemOrdenarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarCodigoActionPerformed
//        limpiarTablas(tblEmpleado, modeloEmpleado);
//        Orden_Controlador.listEmpleado(tblEmpleado, "empleado.empl_codigo", cargo);
    }//GEN-LAST:event_itemOrdenarCodigoActionPerformed

    private void itemOrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarNombreActionPerformed
//        limpiarTablas(tblEmpleado, modeloEmpleado);
//        Orden_Controlador.listEmpleado(tblEmpleado, "empleado.empl_nombreApellidos", cargo);
    }//GEN-LAST:event_itemOrdenarNombreActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        vend = new Empleados_CRUDPadreDialog(this, true);
        vend.txtCodigo.requestFocus();
        vend.crudModificar = 0;
        vend.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarEmpleado(tblEmpleados.getSelectedRow());
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        try {
            eliminarEmpleado(tblEmpleados.getSelectedRow(), 0);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        verificarParametros();
        btnMovil.setEnabled(false);
        btnUbicacion.setEnabled(false);
        btnObservacion.setEnabled(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        btnMovil.setEnabled(true);
        btnUbicacion.setEnabled(true);
        btnObservacion.setEnabled(true);        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void itemPopupEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupEliminarActionPerformed
        try {
            eliminarEmpleado(tblEmpleados.getSelectedRow(), 0);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemPopupEliminarActionPerformed

    private void itemPopupModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupModificarActionPerformed
        modificarEmpleado(tblEmpleados.getSelectedRow());
    }//GEN-LAST:event_itemPopupModificarActionPerformed

    private void itemOrdenarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarDireccionActionPerformed
//        limpiarTablas(tblEmpleados, modeloEmpleado);
//        Orden_Controlador.listEmpleado(tblEmpleado, "empleado.empl_direccion", cargo);
    }//GEN-LAST:event_itemOrdenarDireccionActionPerformed

    private void btnMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovilActionPerformed
        abrirTelefonos(tblEmpleados.getSelectedRow());
    }//GEN-LAST:event_btnMovilActionPerformed

    public void abrirTelefonos(int fila) {
        temp = new Empleados_Telefono(this, true);
        temp.codigoEmpleado = tblEmpleados.getValueAt(fila, 0).toString();
        temp.lblEmpleadoOrigen.setText(tblEmpleados.getValueAt(fila, 2).toString());
        try {
            temp.listarTelefonos("EMPLEADO", tblEmpleados.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        temp.setVisible(true);
    }

    private void btnUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbicacionActionPerformed
        abrirDireccion(tblEmpleados.getSelectedRow());
    }//GEN-LAST:event_btnUbicacionActionPerformed

    public void abrirDireccion(int fila) {
        dir = new Empleados_Direccion(this, true);
        dir.codigoEmpleado = tblEmpleados.getValueAt(fila, 0).toString();
        dir.lblEmpleadoOrigen.setText(tblEmpleados.getValueAt(fila, 2).toString());
        try {
            dir.listarDirecciones("EMPLEADO", tblEmpleados.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        dir.setVisible(true);
    }

    private void btnObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionActionPerformed
        abrirObs(tblEmpleados.getSelectedRow());
    }//GEN-LAST:event_btnObservacionActionPerformed

    public void abrirObs(int fila) {
        info = new Empleados_Observacion(this, true);
        info.codigoEmpleado = tblEmpleados.getValueAt(fila, 0).toString();
        info.lblEmpleadoOrigen.setText(tblEmpleados.getValueAt(fila, 2).toString());
        try {
            info.listarObservaciones("EMPLEADO", tblEmpleados.getValueAt(fila, 0).toString());
        } catch (SQLException ex) { 
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        info.setVisible(true);
    }
    
    private void boxCargosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxCargosItemStateChanged
        verificarParametros();
        btnMovil.setEnabled(false);
        btnUbicacion.setEnabled(false);
        btnObservacion.setEnabled(false);
    }//GEN-LAST:event_boxCargosItemStateChanged

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        verificarParametros();
    }//GEN-LAST:event_txtDniKeyReleased

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

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        try {
            eliminarEmpleado(tblEmpleados.getSelectedRow(), 1);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            eliminarEmpleado(tblEmpleados.getSelectedRow(), 1);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleado dialog = new Empleado(new javax.swing.JFrame(), true);
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
    public static Folder.DMJCComboBox boxCargos;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMovil;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnObservacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUbicacion;
    private javax.swing.JMenuItem itemDesactivar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemOrdenarCodigo;
    private javax.swing.JMenuItem itemOrdenarDireccion;
    private javax.swing.JMenuItem itemOrdenarNombre;
    private javax.swing.JMenuItem itemPopupEliminar;
    private javax.swing.JMenuItem itemPopupModificar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private static javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAtajos;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblNombre;
    private static javax.swing.JLabel lblTodos;
    private javax.swing.JMenu menuAccesoRapido;
    private javax.swing.JMenuBar menuBarEmpleados;
    private javax.swing.JPanel panelBotonesCRUD;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JScrollPane scrollEmpleado;
    public static javax.swing.JTable tblEmpleados;
    public static Folder.DJCTextFieldWithoutPop txtCodigo;
    public static Folder.DJCTextFieldWithoutPop txtDireccion;
    public static Folder.DJCTextFieldWithoutPop txtDni;
    public static Folder.DJCTextFieldWithoutPop txtNombre;
    // End of variables declaration//GEN-END:variables
}
