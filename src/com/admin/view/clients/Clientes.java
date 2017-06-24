package com.admin.view.clients;

import com.admin.controller.tablemodel.TClienteBoleta;
import com.admin.controller.tablemodel.TClienteFactura;
import com.admin.entity.bl.ClienteBL;
import com.admin.entity.dto.ClienteDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.ExportJTableExcel;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import org.apache.log4j.Logger;

public class Clientes extends javax.swing.JDialog {
    private static ArrayList<ClienteDTO> listCliente;
    private ClienteDTO cliente;
    private boolean result = false;
    private static String []array;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Clientes.class);
    private Clientes_CRUDPadreDialog nuevos;
    private Clientes_Telefono telf;
    private Clientes_Direccion dir;
    private Clientes_CuentaB cuentita;
    private Clientes_Intermediario info;
    private Clientes_Observacion obsclie;
    
    public Clientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Clientes");
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
    }

    public static void verificarParametros() {
        array = new String[3];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        if (!txt1.getText().equals("")) array[0] = txt1.getText();
        if (!txt2.getText().equals("")) array[1] = txt2.getText();
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
            listarClientes(boxTipoCliente.getSelectedItem().toString(), array);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }
    
    private static void listarClientes(String tipo, String []array) throws SQLException {        
        listCliente = new ArrayList<>();
        if (tipo.equals("Clientes (Boletas)")) {
            lbl1.setText("Dni:");
            lbl2.setText("Nombres:");
            listCliente = ClienteBL.getInstance().listAllBoleta(array);
            tblCliente.setModel(new TClienteBoleta(listCliente));
            ConfigTables.headerTables(tblCliente);
            ConfigTables.sizeClientBoleta(tblCliente);
        } else {
            lbl1.setText("Ruc:");
            lbl2.setText("Razón Social:");
            listCliente = ClienteBL.getInstance().listAllFactura(array);
            tblCliente.setModel(new TClienteFactura(listCliente));
            ConfigTables.headerTables(tblCliente);
            ConfigTables.sizeClientFactura(tblCliente);
        }
    }
    
//    public static void limpiarTablas(JTable tabla, DefaultTableModel model) {
//        int filas = tabla.getRowCount();
//        for (int i = 0; i < filas; i++) {
//            model.removeRow(0);
//        }
//    }    

    private void modClieBoletas(int fila) {
        if (fila >= 0) {
            nuevos = new Clientes_CRUDPadreDialog(new javax.swing.JDialog(),true);
            nuevos.codigoCliente = tblCliente.getValueAt(fila, 0).toString();
            nuevos.lblTitulo.setText("MODIFICACION DE CLIENTES");
            nuevos.txtDni.setText(tblCliente.getValueAt(fila, 1).toString());
            nuevos.txtNombre.setText(tblCliente.getValueAt(fila, 2).toString());
            if (tblCliente.getValueAt(fila, 3).equals("-")) {
                nuevos.rbtnMasculino.setSelected(false);
                nuevos.rbtnFemenino.setSelected(false);
            } else {
                if ((tblCliente.getValueAt(fila, 3).toString()).equals("M"))
                    nuevos.rbtnMasculino.setSelected(true);
                if ((tblCliente.getValueAt(fila, 3).toString()).equals("F"))
                    nuevos.rbtnFemenino.setSelected(true);
            }
            if (tblCliente.getValueAt(fila, 4) != null) {
                nuevos.txtFechaNacimiento.setText(tblCliente.getValueAt(fila, 4).toString());         }
            if (tblCliente.getValueAt(fila, 5) != null) {
                nuevos.txtDireccion.setText(tblCliente.getValueAt(fila, 5).toString());     }
            if (tblCliente.getValueAt(fila, 6) != null) {
                nuevos.txtLlegada.setText(tblCliente.getValueAt(fila, 6).toString());       }
            if (tblCliente.getValueAt(fila, 7) != null) {
                nuevos.txtEmail.setText(tblCliente.getValueAt(fila, 7).toString());         }
            if (tblCliente.getValueAt(fila, 8).toString().equals("Activo")) {
                nuevos.lblEstado.setText("Activo");
                nuevos.lblEstado.setForeground(Color.blue);
            } else {
                nuevos.lblEstado.setText("Inactivo");
                nuevos.lblEstado.setForeground(Color.red);
            }
            try {
                muestraDatosExtra(fila);
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString());
                logger.error(ex);
            }
            nuevos.panelFactura.setVisible(false);
            nuevos.setSize(870, 650);
            nuevos.setVisible(true);
        } else {   
            Messages.messageSelected();
        }
    }

    private void modClieFacturas(int fila) {
        if (fila >= 0) {
            nuevos = new Clientes_CRUDPadreDialog(new javax.swing.JDialog(),true);
            nuevos.codigoCliente = tblCliente.getValueAt(fila, 0).toString();
            nuevos.lblTitulo.setText("MODIFICACION DE CLIENTES");
            nuevos.txtRuc.setText(tblCliente.getValueAt(fila, 1).toString());
            nuevos.txtRazonSocial.setText(tblCliente.getValueAt(fila, 2).toString());
            if (tblCliente.getValueAt(fila, 3) != null) {
                nuevos.txtDireccion.setText(tblCliente.getValueAt(fila, 3).toString()); }
            if (tblCliente.getValueAt(fila, 4) != null) {
                nuevos.txtLlegada.setText(tblCliente.getValueAt(fila, 4).toString());   }
            if (tblCliente.getValueAt(fila, 5) != null) {
                nuevos.txtEmail.setText(tblCliente.getValueAt(fila, 5).toString()); }
            try {
                muestraDatosExtra(fila);
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.toString());
            }
            nuevos.panelBoleta.setVisible(false);
            nuevos.setSize(870, 640);
            nuevos.setVisible(true);
        } else {   
            Messages.messageSelected();
        }
    }
    
    void muestraDatosExtra(int fila) throws SQLException {
        nuevos.crudModificar = 1;
        nuevos.boxTipoCliente.setSelectedItem(boxTipoCliente.getSelectedItem());
        nuevos.listarDirecciones("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        nuevos.listarTelefonos("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        nuevos.listarEmpleadosTratar("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        nuevos.listarCuentas("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        nuevos.listarObservaciones("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        nuevos.btnGrabar.setEnabled(false);
        nuevos.btnModificar.setEnabled(true);        
    }   

    private void inicializarVariables() {
        result = false;
        cliente = null;
    }
    
    public void eliminaCliente(int fila, int status) throws SQLException {
        inicializarVariables();
        if (fila < 0) {
            Messages.messageSelected();
        } else {
            cliente = new ClienteDTO(Integer.parseInt(tblCliente.getValueAt(fila, 0).toString()));
            if (status == 0) {
                pregunta = Messages.messageDeactive();
                if (pregunta == 0) {                    
                    result = ClienteBL.getInstance().delete(cliente, status);
                    if (result) {
                        Messages.messageDelete();
                        verificarParametros();
                    } else {     Messages.messageErrorDelete();       }
                }
            } else {
                pregunta = Messages.messageActive();
                if (pregunta == 0) {
                    result = ClienteBL.getInstance().delete(cliente, status);
                    if (result) {
                        Messages.messageUnDelete();
                        verificarParametros();
                    } else {     Messages.messageErrorUnDelete();       }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu();
        itemModificar = new javax.swing.JMenuItem();
        itemActivar = new javax.swing.JMenuItem();
        itemDesactivar = new javax.swing.JMenuItem();
        btnGroupOrdenar = new javax.swing.ButtonGroup();
        lblAtajos = new javax.swing.JLabel();
        txt1 = new Folder.DJCTextFieldWithoutPop();
        lbl1 = new javax.swing.JLabel();
        panelBotonesCRUD = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        scrollTblCliente = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnObservacion = new javax.swing.JButton();
        btnTelefono = new javax.swing.JButton();
        btnUbicacion = new javax.swing.JButton();
        btnCuenta = new javax.swing.JButton();
        btnIntermediario = new javax.swing.JButton();
        lblTipoCliente = new javax.swing.JLabel();
        boxTipoCliente = new Folder.DMJCComboBox();
        lbl2 = new javax.swing.JLabel();
        txt2 = new Folder.DJCTextFieldWithoutPop();
        lblEstado = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        menuBarClientes = new javax.swing.JMenuBar();
        menuAccesoRapido = new javax.swing.JMenu();
        itemNuevoCliente = new javax.swing.JMenuItem();
        itemModificarCliente = new javax.swing.JMenuItem();
        itemActivarCliente = new javax.swing.JMenuItem();
        itemDesactivarCliente = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemRadioRazonSocial = new javax.swing.JRadioButtonMenuItem();
        itemRadioRuc = new javax.swing.JRadioButtonMenuItem();
        itemRadioNombre = new javax.swing.JRadioButtonMenuItem();
        itemRadioDni = new javax.swing.JRadioButtonMenuItem();
        menuExcel = new javax.swing.JMenu();
        itemExcelExportar = new javax.swing.JMenuItem();

        itemModificar.setText("jMenuItem4");
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        popup.add(itemModificar);

        itemActivar.setText("jMenuItem1");
        itemActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActivarActionPerformed(evt);
            }
        });
        popup.add(itemActivar);

        itemDesactivar.setText("jMenuItem4");
        itemDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDesactivarActionPerformed(evt);
            }
        });
        popup.add(itemDesactivar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAtajos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAtajos.setForeground(new java.awt.Color(0, 102, 0));
        lblAtajos.setText("Nuevo: F1                                                                               Modificar : Ctrl + M                                                                                 Borrar : Ctrl + B                                                                             Actualizar: F5");
        lblAtajos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt1KeyReleased(evt);
            }
        });

        lbl1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl1.setText("Dni:");

        panelBotonesCRUD.setLayout(new java.awt.GridLayout(1, 6));

        btnNuevo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 51));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_add.png"))); // NOI18N
        btnNuevo.setText("Nuevo - F1");
        btnNuevo.setToolTipText("Botón para registrar nuevo cliente.");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMinimumSize(new java.awt.Dimension(83, 59));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 102, 51));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_edit.png"))); // NOI18N
        btnModificar.setText("Modificar - Ctrl + M ");
        btnModificar.setToolTipText("Botón para modificar el cliente seleccionado.");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnModificar);

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActivar.setForeground(new java.awt.Color(0, 102, 51));
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group.png"))); // NOI18N
        btnActivar.setText("Activar - Ctrl + A");
        btnActivar.setToolTipText("Botón para activar el cliente seleccionado.");
        btnActivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnActivar);

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnDesactivar.setForeground(new java.awt.Color(0, 102, 51));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_delete.png"))); // NOI18N
        btnDesactivar.setText("Desactivar - Ctrl + D");
        btnDesactivar.setToolTipText("Botón para desactivar el cliente seleccionado.");
        btnDesactivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesactivar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnDesactivar);

        btnActualizar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 102, 51));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/page_refresh.png"))); // NOI18N
        btnActualizar.setText("Actualizar - F5");
        btnActualizar.setToolTipText("Botón para recargar lista de clientes.");
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnActualizar);

        btnSalir.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 51));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/door_out32.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Botón para cerrar la ventana de clientes.");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnSalir);

        tblCliente.setAutoCreateRowSorter(true);
        tblCliente.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCliente.setToolTipText("");
        tblCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCliente.setComponentPopupMenu(popup);
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        scrollTblCliente.setViewportView(tblCliente);

        btnObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/e36-16.png"))); // NOI18N
        btnObservacion.setText("Ver Observaciones");
        btnObservacion.setToolTipText("Botón para visualizar las observaciones del cliente seleccionado.");
        btnObservacion.setEnabled(false);
        btnObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionActionPerformed(evt);
            }
        });

        btnTelefono.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/phone_speaker-16.png"))); // NOI18N
        btnTelefono.setText("Ver Ubicación Móvil");
        btnTelefono.setToolTipText("Botón para visualizar la ubicación móvil del cliente seleccionado.");
        btnTelefono.setEnabled(false);
        btnTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonoActionPerformed(evt);
            }
        });

        btnUbicacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/mp.png"))); // NOI18N
        btnUbicacion.setText("Ver Ubicación Terrestre");
        btnUbicacion.setToolTipText("Botón para visualizar la ubicación terrestre del cliente seleccionado.");
        btnUbicacion.setEnabled(false);
        btnUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbicacionActionPerformed(evt);
            }
        });

        btnCuenta.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/credit_card-16.png"))); // NOI18N
        btnCuenta.setText("Ver Cuentas Bancarias");
        btnCuenta.setToolTipText("Botón para visualizar las cuentas bancarias del clietne seleccionado.");
        btnCuenta.setEnabled(false);
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        btnIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/inter.png"))); // NOI18N
        btnIntermediario.setText("Ver Intermediarios");
        btnIntermediario.setToolTipText("Botón para visualizar los intermediarios del cliente seleccionado.");
        btnIntermediario.setEnabled(false);
        btnIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntermediarioActionPerformed(evt);
            }
        });

        lblTipoCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblTipoCliente.setText("Tipo:");

        boxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clientes (Boletas)", "Clientes (Facturas)" }));
        boxTipoCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boxTipoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoClienteItemStateChanged(evt);
            }
        });
        boxTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoClienteActionPerformed(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl2.setText("Nombres:");

        txt2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt2KeyReleased(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
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

        lblActivos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
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

        itemNuevoCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevoCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        itemNuevoCliente.setText("Nuevo");
        itemNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoClienteActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemNuevoCliente);

        itemModificarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        itemModificarCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemModificarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        itemModificarCliente.setText("Modificar");
        itemModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarClienteActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemModificarCliente);

        itemActivarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemActivarCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemActivarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        itemActivarCliente.setText("Activar");
        itemActivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActivarClienteActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemActivarCliente);

        itemDesactivarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        itemDesactivarCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemDesactivarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        itemDesactivarCliente.setText("Desactivar");
        itemDesactivarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDesactivarClienteActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemDesactivarCliente);
        menuAccesoRapido.add(jSeparator2);

        btnGroupOrdenar.add(itemRadioRazonSocial);
        itemRadioRazonSocial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemRadioRazonSocial.setText("Ordenar por Razón Social");
        itemRadioRazonSocial.setEnabled(false);
        itemRadioRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRadioRazonSocialActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemRadioRazonSocial);

        btnGroupOrdenar.add(itemRadioRuc);
        itemRadioRuc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemRadioRuc.setText("Ordenar por R.U.C");
        itemRadioRuc.setEnabled(false);
        itemRadioRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRadioRucActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemRadioRuc);

        btnGroupOrdenar.add(itemRadioNombre);
        itemRadioNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemRadioNombre.setText("Ordenar por Nombre");
        itemRadioNombre.setEnabled(false);
        itemRadioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRadioNombreActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemRadioNombre);

        btnGroupOrdenar.add(itemRadioDni);
        itemRadioDni.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemRadioDni.setText("Ordenar por D.N.I");
        itemRadioDni.setEnabled(false);
        itemRadioDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRadioDniActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemRadioDni);

        menuBarClientes.add(menuAccesoRapido);

        menuExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/excel.png"))); // NOI18N
        menuExcel.setText("Microsoft Excel");
        menuExcel.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N

        itemExcelExportar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemExcelExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/dtb.png"))); // NOI18N
        itemExcelExportar.setText("Exportar");
        itemExcelExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExcelExportarActionPerformed(evt);
            }
        });
        menuExcel.add(itemExcelExportar);

        menuBarClientes.add(menuExcel);

        setJMenuBar(menuBarClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAtajos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl1)
                            .addComponent(lblTipoCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxTipoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lblEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelBotonesCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scrollTblCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIntermediario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBotonesCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoCliente)
                            .addComponent(boxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addGap(11, 11, 11)
                .addComponent(scrollTblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTelefono)
                    .addComponent(btnUbicacion)
                    .addComponent(btnObservacion)
                    .addComponent(btnIntermediario)
                    .addComponent(btnCuenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAtajos))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoClienteActionPerformed
        nuevos = new Clientes_CRUDPadreDialog(this, true);
        nuevos.boxTipoCliente.setSelectedItem(boxTipoCliente.getSelectedItem().toString());
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Boletas)")) {
            nuevos.panelFactura.setVisible(false);
            nuevos.panelBoleta.setVisible(true);
        } else {
            nuevos.panelBoleta.setVisible(false);
            nuevos.panelFactura.setVisible(true);
        }
        nuevos.setSize(870, 650);
        nuevos.setVisible(true);
    }//GEN-LAST:event_itemNuevoClienteActionPerformed

    private void itemModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarClienteActionPerformed
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Boletas)")) {
            modClieBoletas(tblCliente.getSelectedRow());
        } else {
            modClieFacturas(tblCliente.getSelectedRow());
        }
    }//GEN-LAST:event_itemModificarClienteActionPerformed

    private void itemDesactivarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDesactivarClienteActionPerformed
        try {
            eliminaCliente(tblCliente.getSelectedRow(), 0);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemDesactivarClienteActionPerformed

    private void itemExcelExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExcelExportarActionPerformed
        try {
            List<JTable> tb = new ArrayList<>();
            tb.add(tblCliente);
            ExportJTableExcel excellExporter = new ExportJTableExcel(tb, new File("C:/Users/ALMACEN1/Desktop/Reportes/CLIENTES.xls"));
            if (excellExporter.Export()) {
                Messages.messageOK("Transferencia exitosa.");
            }
            llamaExcel();
        } catch (Exception ex) {
            Messages.messageAlert("Fue imposible exportar la tabla de clientes.");
            logger.warn(ex);
        }
    }//GEN-LAST:event_itemExcelExportarActionPerformed

    public void llamaExcel() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:/Users/ALMACEN1/Desktop/Reportes/CLIENTES.xls");
        } catch (Exception e) {    }
    }

    private void txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyReleased
        verificarParametros();
        habilitaBotonesExtra(false);
    }//GEN-LAST:event_txt1KeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevos = new Clientes_CRUDPadreDialog(this, true);
        nuevos.crudModificar = 0;
        nuevos.boxTipoCliente.setSelectedItem(boxTipoCliente.getSelectedItem().toString());
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Boletas)")) {
            nuevos.panelFactura.setVisible(false);
            nuevos.panelBoleta.setVisible(true);
        } else {
            nuevos.panelBoleta.setVisible(false);
            nuevos.panelFactura.setVisible(true);
        }
        nuevos.setSize(870, 650);
        nuevos.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Boletas)")) {
            modClieBoletas(tblCliente.getSelectedRow());
        } else {
            modClieFacturas(tblCliente.getSelectedRow());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        try {
            eliminaCliente(tblCliente.getSelectedRow(), 0);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        verificarParametros();
        habilitaBotonesExtra(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    void habilitaBotonesExtra(boolean x) {
        btnTelefono.setEnabled(x);
        btnUbicacion.setEnabled(x);
        btnCuenta.setEnabled(x);
        btnIntermediario.setEnabled(x);
        btnObservacion.setEnabled(x);
    }

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        habilitaBotonesExtra(true);
    }//GEN-LAST:event_tblClienteMouseClicked

    private void itemDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDesactivarActionPerformed
        try {
            eliminaCliente(tblCliente.getSelectedRow(), 1);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemDesactivarActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        if (boxTipoCliente.getSelectedItem().toString().equals("Clientes (Boletas)")) {
            modClieBoletas(tblCliente.getSelectedRow());
        } else {
            modClieFacturas(tblCliente.getSelectedRow());
        }
    }//GEN-LAST:event_itemModificarActionPerformed

    private void btnObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionActionPerformed
        abrirObs(tblCliente.getSelectedRow());
    }//GEN-LAST:event_btnObservacionActionPerformed

    public void abrirObs(int fila) {
        obsclie = new Clientes_Observacion(new javax.swing.JDialog(), true);
        obsclie.codigoCliente = tblCliente.getValueAt(fila, 0).toString();
        obsclie.lblClienteOrigen.setText(tblCliente.getValueAt(fila, 2).toString());
        try {
            obsclie.listarObservaciones("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        } catch (SQLException ex) { 
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        obsclie.setVisible(true);
    }

    private void btnTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefonoActionPerformed
        abrirTelefonos(tblCliente.getSelectedRow());
    }//GEN-LAST:event_btnTelefonoActionPerformed

    public void abrirTelefonos(int fila) {
        telf = new Clientes_Telefono(this, true);
        telf.codigoCliente = tblCliente.getValueAt(fila, 0).toString();
        telf.lblClienteOrigen.setText(tblCliente.getValueAt(fila, 2).toString());
        try {
            telf.listarTelefonos("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        telf.setVisible(true);
    }

    private void btnUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbicacionActionPerformed
        abrirDireccion(tblCliente.getSelectedRow());
    }//GEN-LAST:event_btnUbicacionActionPerformed

    public void abrirDireccion(int fila) {
        dir = new Clientes_Direccion(this, true);
        dir.codigoCliente = tblCliente.getValueAt(fila, 0).toString();
        dir.lblClienteOrigen.setText(tblCliente.getValueAt(fila, 2).toString());
        try {
            dir.listarDirecciones("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        dir.setVisible(true);
    }

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        abrirCuentas(tblCliente.getSelectedRow());
    }//GEN-LAST:event_btnCuentaActionPerformed

    public void abrirCuentas(int fila) {
        cuentita = new Clientes_CuentaB(new javax.swing.JDialog(), true);
        cuentita.codigoCliente = tblCliente.getValueAt(fila, 0).toString();
        cuentita.lblClienteOrigen.setText(tblCliente.getValueAt(fila, 2).toString());
        try {
            cuentita.listarCuentas("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        cuentita.setVisible(true);
    }

    private void btnIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntermediarioActionPerformed
        abrirIntermediarios(tblCliente.getSelectedRow());
    }//GEN-LAST:event_btnIntermediarioActionPerformed

    public void abrirIntermediarios(int fila) {
        info = new Clientes_Intermediario(new javax.swing.JDialog(), true);
        info.codigoCliente=tblCliente.getValueAt(fila, 0).toString();
        info.lblClienteOrigen.setText(tblCliente.getValueAt(fila, 2).toString());
        try {
            info.listarEmpleadosTratar("CLIENTE", tblCliente.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        info.setVisible(true);
    }

    private void boxTipoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTipoClienteItemStateChanged
        verificarParametros();
        habilitaBotonesExtra(false);
    }//GEN-LAST:event_boxTipoClienteItemStateChanged

    private void itemRadioRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRadioRazonSocialActionPerformed
//        limpiarTablas(tblCliente,modeloClieFacturas);
//        Orden_Controlador.listClienteJ(tblCliente, "cliente.clie_razonSocial");
    }//GEN-LAST:event_itemRadioRazonSocialActionPerformed

    private void itemRadioRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRadioRucActionPerformed
//        limpiarTablas(tblCliente,modeloClieFacturas);
//        Orden_Controlador.listClienteJ(tblCliente, "cliente.clie_ruc");
    }//GEN-LAST:event_itemRadioRucActionPerformed

    private void itemRadioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRadioNombreActionPerformed
//        limpiarTablas(tblCliente,modeloClieBoletas);
//        Orden_Controlador.listClienteN(tblCliente, "cliente.clie_nombresApellidos");
    }//GEN-LAST:event_itemRadioNombreActionPerformed

    private void itemRadioDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRadioDniActionPerformed
//        limpiarTablas(tblCliente,modeloClieBoletas);
//        Orden_Controlador.listClienteN(tblCliente, "cliente.clie_dni");
    }//GEN-LAST:event_itemRadioDniActionPerformed

    private void boxTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoClienteActionPerformed
        if (tblCliente.getRowCount() == 0) {
            Messages.messageAlert("Sin elementos");
        }
    }//GEN-LAST:event_boxTipoClienteActionPerformed

    private void txt2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyReleased
        verificarParametros();
        habilitaBotonesExtra(false);
    }//GEN-LAST:event_txt2KeyReleased

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
            eliminaCliente(tblCliente.getSelectedRow(), 1);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void itemActivarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActivarClienteActionPerformed
        try {
            eliminaCliente(tblCliente.getSelectedRow(), 1);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemActivarClienteActionPerformed

    private void itemActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActivarActionPerformed
        try {
            eliminaCliente(tblCliente.getSelectedRow(), 1);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
    }//GEN-LAST:event_itemActivarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clientes dialog = new Clientes(new javax.swing.JFrame(), true);
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
    private static Folder.DMJCComboBox boxTipoCliente;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCuenta;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.ButtonGroup btnGroupOrdenar;
    private javax.swing.JButton btnIntermediario;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnObservacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTelefono;
    private javax.swing.JButton btnUbicacion;
    private javax.swing.JMenuItem itemActivar;
    private javax.swing.JMenuItem itemActivarCliente;
    private javax.swing.JMenuItem itemDesactivar;
    private javax.swing.JMenuItem itemDesactivarCliente;
    private javax.swing.JMenuItem itemExcelExportar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JMenuItem itemModificarCliente;
    private javax.swing.JMenuItem itemNuevoCliente;
    private javax.swing.JRadioButtonMenuItem itemRadioDni;
    private javax.swing.JRadioButtonMenuItem itemRadioNombre;
    private javax.swing.JRadioButtonMenuItem itemRadioRazonSocial;
    private javax.swing.JRadioButtonMenuItem itemRadioRuc;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private static javax.swing.JLabel lbl1;
    private static javax.swing.JLabel lbl2;
    private static javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAtajos;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblTipoCliente;
    private static javax.swing.JLabel lblTodos;
    private javax.swing.JMenu menuAccesoRapido;
    private javax.swing.JMenuBar menuBarClientes;
    private javax.swing.JMenu menuExcel;
    private javax.swing.JPanel panelBotonesCRUD;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JScrollPane scrollTblCliente;
    public static javax.swing.JTable tblCliente;
    private static Folder.DJCTextFieldWithoutPop txt1;
    private static Folder.DJCTextFieldWithoutPop txt2;
    // End of variables declaration//GEN-END:variables
}
