package com.admin.view.provider;

import com.admin.controller.tablemodel.TDetalleProveedor;
import com.admin.controller.tablemodel.TProveedor;
import com.admin.model.bl.DetalleProveedorBL;
import com.admin.model.bl.ProveedorBL;
import com.admin.model.dto.DetalleProveedorDTO;
import com.admin.model.dto.ProveedorDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.ExportJTableExcel;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

public class Proveedores extends javax.swing.JDialog {
    private static ArrayList<ProveedorDTO> listProveedor = null;
    private static ArrayList<DetalleProveedorDTO> listDetalleProveedor = null;
    private ProveedorDTO proveedor = null;
    private DetalleProveedorDTO detalleProveedor = null;
    private boolean result = false;
    private String fechaInicioProveedor;
    private String fechaFinProveedor;
    private static String[] array;
    private int pregunta;
    private int filaProveedor = -1;
    private Proveedores_CRUDPadreDialog nuevos;
    private Proveedores_Observacion obsprove;
    private Proveedores_Intermediario info;
    private Proveedores_CuentaB cuentita;
    private Proveedores_Telefono telfprove;
    final static Logger logger = Logger.getLogger(Proveedores.class);

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Proveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        panelTiempoTrabajo.setVisible(false);
        setTitle("Lista de Proveedores");
        lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        lblActivos.setForeground(Color.blue);
        verificarParametros();
        ActivaBoton(false);
    }

    public static void limpiarTablas(JTable tabla,DefaultTableModel model) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(0);
        }
    }    
    
    public static void verificarParametros() {
        array = new String[3];
        array[0] = null;
        array[1] = null;
        array[2] = null;
        if (!txtNombre.getText().equals("")) array[0] = txtNombre.getText();
        if (!txtRuc.getText().equals("")) array[1] = txtRuc.getText();
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
    
    private void modificarProveedor(int fila) {       
        try {
            nuevos = new Proveedores_CRUDPadreDialog(this, true);
            nuevos.lblTitulo.setText("MODIFICACION DE PROVEEDORES");
            nuevos.nombreProveedor = tblProveedor.getValueAt(fila, 0).toString();
            nuevos.txtNombre.setText(tblProveedor.getValueAt(fila, 0).toString());
            nuevos.txtRuc.setText(tblProveedor.getValueAt(fila, 1).toString());
            if (tblProveedor.getValueAt(fila, 2) == null) {  nuevos.txtDireccion.setText("");
            } else {                                  nuevos.txtDireccion.setText(tblProveedor.getValueAt(fila, 2).toString());  }
            if (tblProveedor.getValueAt(fila, 3) == null) {  nuevos.txtWeb.setText("");
            } else {                                  nuevos.txtWeb.setText(tblProveedor.getValueAt(fila, 3).toString());        }
            if (tblProveedor.getValueAt(fila, 4) == null) {  nuevos.txtEmail.setText("");
            } else {                                  nuevos.txtEmail.setText(tblProveedor.getValueAt(fila, 4).toString());      }
            nuevos.crudModificar = 1;
            nuevos.listarTelefonos("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
            nuevos.listarCuentas("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
            nuevos.listarObservaciones("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
            nuevos.listarVendedores("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());                
            nuevos.btnGrabar.setEnabled(false);
            nuevos.btnModificar.setEnabled(true);
            nuevos.setVisible(true);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void eliminaProveedor(int fila, int status) throws SQLException {
        result = false;
        proveedor = null;
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
                if (result) {
                    Messages.messageUnDelete();
                    verificarParametros();
                } else {     Messages.messageErrorUnDelete();       }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        itemPopupModificar = new javax.swing.JMenuItem();
        itemPopupDesactivar = new javax.swing.JMenuItem();
        itemPopupActivar = new javax.swing.JMenuItem();
        panelBotonesCRUD = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelTiempoTrabajo = new javax.swing.JPanel();
        scrollTiempoTrabajo = new javax.swing.JScrollPane();
        tblTiempoTrabajo = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        scrollProveedor = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnMovil = new javax.swing.JButton();
        btnCuentaBancaria = new javax.swing.JButton();
        btnIntermediario = new javax.swing.JButton();
        btnObservacion = new javax.swing.JButton();
        btnTiempoTrabajo = new javax.swing.JButton();
        lblAtajos = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        txtRuc = new Folder.DJCTextFieldWithoutPop();
        lblEstado = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();
        menuBarProveedores = new javax.swing.JMenuBar();
        menuAccesoRapido = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemOrdenarNombre = new javax.swing.JMenuItem();
        itemOrdenarRuc = new javax.swing.JMenuItem();
        menuExcel = new javax.swing.JMenu();
        itemExcelExportar = new javax.swing.JMenuItem();

        itemPopupModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        itemPopupModificar.setText("Modificar Proveedor");
        itemPopupModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupModificarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupModificar);

        itemPopupDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        itemPopupDesactivar.setText("Eliminar Proveedor");
        itemPopupDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupDesactivarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupDesactivar);

        itemPopupActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        itemPopupActivar.setText("Eliminar Proveedor");
        itemPopupActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPopupActivarActionPerformed(evt);
            }
        });
        popupMenu.add(itemPopupActivar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBotonesCRUD.setLayout(new java.awt.GridLayout(1, 6));

        btnNuevo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 51));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/group_add.png"))); // NOI18N
        btnNuevo.setText("Nuevo - F1");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        btnModificar.setText("Modificar - Ctrl + M");
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
        btnActivar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActivar.setPreferredSize(new java.awt.Dimension(135, 59));
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
        btnDesactivar.setText("Desactivar - Ctrl+D");
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
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setPreferredSize(new java.awt.Dimension(118, 59));
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
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotonesCRUD.add(btnSalir);

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
        scrollTiempoTrabajo.setViewportView(tblTiempoTrabajo);

        javax.swing.GroupLayout panelTiempoTrabajoLayout = new javax.swing.GroupLayout(panelTiempoTrabajo);
        panelTiempoTrabajo.setLayout(panelTiempoTrabajoLayout);
        panelTiempoTrabajoLayout.setHorizontalGroup(
            panelTiempoTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTiempoTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        panelTiempoTrabajoLayout.setVerticalGroup(
            panelTiempoTrabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTiempoTrabajo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );

        lblNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblNombre.setText("Nombre: ");

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        tblProveedor.setAutoCreateRowSorter(true);
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
        tblProveedor.setComponentPopupMenu(popupMenu);
        tblProveedor.getTableHeader().setReorderingAllowed(false);
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        scrollProveedor.setViewportView(tblProveedor);

        btnMovil.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnMovil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/phone_speaker-16.png"))); // NOI18N
        btnMovil.setText("Ver Ubicación Móvil");
        btnMovil.setEnabled(false);
        btnMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovilActionPerformed(evt);
            }
        });

        btnCuentaBancaria.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCuentaBancaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/mp.png"))); // NOI18N
        btnCuentaBancaria.setText("Ver Cuentas Bancarias");
        btnCuentaBancaria.setEnabled(false);
        btnCuentaBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaBancariaActionPerformed(evt);
            }
        });

        btnIntermediario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnIntermediario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/inter.png"))); // NOI18N
        btnIntermediario.setText("Ver Intermediarios");
        btnIntermediario.setEnabled(false);
        btnIntermediario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIntermediarioActionPerformed(evt);
            }
        });

        btnObservacion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnObservacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/e36-16.png"))); // NOI18N
        btnObservacion.setText("Ver Observaciones");
        btnObservacion.setEnabled(false);
        btnObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObservacionActionPerformed(evt);
            }
        });

        btnTiempoTrabajo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnTiempoTrabajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/bper.png"))); // NOI18N
        btnTiempoTrabajo.setText("Ver Tiempo de Trabajo");
        btnTiempoTrabajo.setEnabled(false);
        btnTiempoTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiempoTrabajoActionPerformed(evt);
            }
        });

        lblAtajos.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAtajos.setForeground(new java.awt.Color(0, 102, 51));
        lblAtajos.setText("Nuevo: F1                                                                              Modificar : Ctrl + M                                                                     Borrar : Ctrl + B                                                                              Actualizar: F5");

        lblRuc.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblRuc.setText("Ruc:");

        txtRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRucKeyReleased(evt);
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
        menuAccesoRapido.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

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

        itemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        itemEliminar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        itemEliminar.setText("Desactivar");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemEliminar);
        menuAccesoRapido.add(jSeparator1);

        itemOrdenarNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemOrdenarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        itemOrdenarNombre.setText("Ordenar por Nombre");
        itemOrdenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarNombreActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemOrdenarNombre);

        itemOrdenarRuc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemOrdenarRuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        itemOrdenarRuc.setText("Ordenar por RUC");
        itemOrdenarRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenarRucActionPerformed(evt);
            }
        });
        menuAccesoRapido.add(itemOrdenarRuc);

        menuBarProveedores.add(menuAccesoRapido);

        menuExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/excel.png"))); // NOI18N
        menuExcel.setText("Microsoft Excel");
        menuExcel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        itemExcelExportar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        itemExcelExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/dtb.png"))); // NOI18N
        itemExcelExportar.setText("Exportar");
        itemExcelExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExcelExportarActionPerformed(evt);
            }
        });
        menuExcel.add(itemExcelExportar);

        menuBarProveedores.add(menuExcel);

        setJMenuBar(menuBarProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProveedor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCuentaBancaria, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTiempoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBotonesCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelTiempoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblRuc)
                        .addGap(18, 18, 18)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblEstado)
                        .addGap(29, 29, 29)
                        .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(lblAtajos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1283, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotonesCRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTiempoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRuc)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMovil)
                    .addComponent(btnObservacion)
                    .addComponent(btnCuentaBancaria)
                    .addComponent(btnIntermediario)
                    .addComponent(btnTiempoTrabajo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtajos))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        nuevos = new Proveedores_CRUDPadreDialog(this, true);
        nuevos.txtRuc.requestFocus();
        nuevos.setVisible(true);
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
        if (filaProveedor >= 0) {
            modificarProveedor(filaProveedor);
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_itemModificarActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        if (filaProveedor >= 0) {
            fechaFinProveedor = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            try {
                detalleProveedor = new DetalleProveedorDTO(
                        fechaFinProveedor,
                        new ProveedorDTO(tblProveedor.getValueAt(filaProveedor, 0).toString())
                );
                DetalleProveedorBL.getInstance().update(detalleProveedor);
                eliminaProveedor(filaProveedor, 0);            
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_itemEliminarActionPerformed

    private void itemOrdenarRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarRucActionPerformed
//        limpiarTablas(tblProveedor, modeloProveedor);
//        Orden_Controlador.listProve(tblProveedor, "prove_ruc");
    }//GEN-LAST:event_itemOrdenarRucActionPerformed

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        filaProveedor = tblProveedor.getSelectedRow();
        ActivaBoton(true);
        panelTiempoTrabajo.setVisible(false);
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarParametros();
        ActivaBoton(false);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevos = new Proveedores_CRUDPadreDialog(this, true);
        nuevos.txtRuc.requestFocus();
        nuevos.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (filaProveedor >= 0) {
            modificarProveedor(filaProveedor);
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        if (filaProveedor >= 0) {
            fechaFinProveedor = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            try {
                detalleProveedor = new DetalleProveedorDTO(
                        fechaFinProveedor,
                        new ProveedorDTO(tblProveedor.getValueAt(filaProveedor, 0).toString())
                );
                DetalleProveedorBL.getInstance().update(detalleProveedor);
                eliminaProveedor(filaProveedor, 0);            
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        verificarParametros();
        ActivaBoton(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void ActivaBoton(boolean x) {
        btnMovil.setEnabled(x);
        btnCuentaBancaria.setEnabled(x);
        btnIntermediario.setEnabled(x);
        btnObservacion.setEnabled(x);
        btnTiempoTrabajo.setEnabled(x);
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void itemPopupDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupDesactivarActionPerformed
        if (filaProveedor >= 0) {
            fechaFinProveedor = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            try {
                detalleProveedor = new DetalleProveedorDTO(
                        fechaFinProveedor,
                        new ProveedorDTO(tblProveedor.getValueAt(filaProveedor, 0).toString())
                );
                DetalleProveedorBL.getInstance().update(detalleProveedor);
                eliminaProveedor(filaProveedor, 0);            
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_itemPopupDesactivarActionPerformed

    private void itemPopupModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupModificarActionPerformed
        modificarProveedor(filaProveedor);
    }//GEN-LAST:event_itemPopupModificarActionPerformed

    private void itemOrdenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenarNombreActionPerformed
//        limpiarTablas(tblProveedor, modeloProveedor);
//        Orden_Controlador.listProve(tblProveedor, "prove_nombre");
    }//GEN-LAST:event_itemOrdenarNombreActionPerformed

    private void btnMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovilActionPerformed
        if (filaProveedor >= 0) {
            abrirTelefonos(filaProveedor);
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnMovilActionPerformed

    private void abrirTelefonos(int fila) {
        telfprove = new Proveedores_Telefono(this, true);
        telfprove.codigoProveedor = tblProveedor.getValueAt(fila, 0).toString();
        telfprove.lblProveedorOrigen.setText(tblProveedor.getValueAt(fila, 0).toString());
        try {
            telfprove.listarTelefonos("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        telfprove.setVisible(true);
    }

    private void btnCuentaBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaBancariaActionPerformed
        if (filaProveedor >= 0) {
            abrirCuentas(filaProveedor);
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnCuentaBancariaActionPerformed

    private void abrirCuentas(int fila) {
        cuentita = new Proveedores_CuentaB(new javax.swing.JDialog(), true);
        cuentita.codigoProveedor = tblProveedor.getValueAt(fila, 0).toString();
        cuentita.lblProveedorOrigen.setText(tblProveedor.getValueAt(fila, 0).toString());
        try {
            cuentita.listarCuentas("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        cuentita.setVisible(true);
    }

    private void btnIntermediarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntermediarioActionPerformed
        if (filaProveedor >= 0) {
            abrirIntermediarios(filaProveedor);
        } else {
            Messages.messageSelected();
        }        
    }//GEN-LAST:event_btnIntermediarioActionPerformed

    private void abrirIntermediarios(int fila) {
        info = new Proveedores_Intermediario(new javax.swing.JDialog(), true);
        info.nombreProveedor = tblProveedor.getValueAt(fila, 0).toString();
        info.lblProveedorOrigen.setText(tblProveedor.getValueAt(fila, 0).toString());
        try {
            info.listarVendedores("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        info.setVisible(true);
    }

    private void btnObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObservacionActionPerformed
        if (filaProveedor >= 0) {
            abrirObservaciones(filaProveedor);
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnObservacionActionPerformed

    private void abrirObservaciones(int fila) {
        obsprove = new Proveedores_Observacion(new javax.swing.JDialog(), true);
        obsprove.codigoProveedor = tblProveedor.getValueAt(fila, 0).toString();
        obsprove.lblProveedorOrigen.setText(tblProveedor.getValueAt(fila, 0).toString());
        try {
            obsprove.listarObservaciones("PROVEEDOR", tblProveedor.getValueAt(fila, 0).toString());
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        obsprove.setVisible(true);
    }

    private void mostrarTiempo(String nom) {
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

    private void btnTiempoTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiempoTrabajoActionPerformed
        if (filaProveedor >= 0) {
            panelTiempoTrabajo.setVisible(true);
            mostrarTiempo(tblProveedor.getValueAt(filaProveedor, 0).toString()); 
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnTiempoTrabajoActionPerformed

    private void itemExcelExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExcelExportarActionPerformed
        if (tblProveedor.getRowCount() == 0) {
            Messages.messageAlert("Sin elementos.");
        } else {
            try {
                List<JTable> tb = new ArrayList<>();
                tb.add(tblProveedor);
                ExportJTableExcel excellExporter = new ExportJTableExcel(tb, new File("C:/Users/ALMACEN1/Desktop/Reportes/REGISTRO DE PROVEEDORES.xls"));
                if (excellExporter.Export()) {
                    Messages.messageOK("Transferencia completa.");
                }
                llamaExcel();
            } catch (Exception e) {  }
        }
    }//GEN-LAST:event_itemExcelExportarActionPerformed

    private void txtRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyReleased
        verificarParametros();
        ActivaBoton(false);
    }//GEN-LAST:event_txtRucKeyReleased

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
        if (filaProveedor >= 0) {
            fechaInicioProveedor = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            try {
                detalleProveedor = new DetalleProveedorDTO(
                        fechaInicioProveedor,
                        new ProveedorDTO(tblProveedor.getValueAt(filaProveedor, 0).toString())
                );
                DetalleProveedorBL.getInstance().insert(detalleProveedor);
                eliminaProveedor(filaProveedor, 1);    
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       if (filaProveedor >= 0) {
            fechaInicioProveedor = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            try {
                detalleProveedor = new DetalleProveedorDTO(
                        fechaInicioProveedor,
                        new ProveedorDTO(tblProveedor.getValueAt(filaProveedor, 0).toString())
                );
                DetalleProveedorBL.getInstance().insert(detalleProveedor);
                eliminaProveedor(filaProveedor, 1);    
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemPopupActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPopupActivarActionPerformed
        if (filaProveedor >= 0) {
            fechaInicioProveedor = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            try {
                detalleProveedor = new DetalleProveedorDTO(
                        fechaInicioProveedor,
                        new ProveedorDTO(tblProveedor.getValueAt(filaProveedor, 0).toString())
                );
                DetalleProveedorBL.getInstance().insert(detalleProveedor);
                eliminaProveedor(filaProveedor, 1);    
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        } else {
            Messages.messageSelected();
        }
    }//GEN-LAST:event_itemPopupActivarActionPerformed

    public void llamaExcel() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:/Users/ALMACEN1/Desktop/Reportes/REGISTRO DE PROVEEDORES.xls");
        } catch (IOException e) {       System.out.println("No se pudo completar la tarea");        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Proveedores dialog = new Proveedores(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    public static javax.swing.JButton btnCuentaBancaria;
    private javax.swing.JButton btnDesactivar;
    public static javax.swing.JButton btnIntermediario;
    private javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnMovil;
    private javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnObservacion;
    private javax.swing.JButton btnSalir;
    public static javax.swing.JButton btnTiempoTrabajo;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemExcelExportar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemOrdenarNombre;
    private javax.swing.JMenuItem itemOrdenarRuc;
    private javax.swing.JMenuItem itemPopupActivar;
    private javax.swing.JMenuItem itemPopupDesactivar;
    private javax.swing.JMenuItem itemPopupModificar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private static javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAtajos;
    private javax.swing.JLabel lblEstado;
    private static javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRuc;
    private static javax.swing.JLabel lblTodos;
    private javax.swing.JMenu menuAccesoRapido;
    private javax.swing.JMenuBar menuBarProveedores;
    private javax.swing.JMenu menuExcel;
    private javax.swing.JPanel panelBotonesCRUD;
    private javax.swing.JPanel panelTiempoTrabajo;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JScrollPane scrollProveedor;
    private javax.swing.JScrollPane scrollTiempoTrabajo;
    public static javax.swing.JTable tblProveedor;
    private javax.swing.JTable tblTiempoTrabajo;
    public static Folder.DJCTextFieldWithoutPop txtNombre;
    public static Folder.DJCTextFieldWithoutPop txtRuc;
    // End of variables declaration//GEN-END:variables
}
