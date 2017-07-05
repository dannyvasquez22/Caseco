package com.admin.view.units;

import com.admin.controller.tablemodel.TTienda;
import com.admin.model.bl.TiendaBL;
import com.admin.model.dto.TiendaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Tiendas extends javax.swing.JDialog {
    private ArrayList<TiendaDTO> listTiendas;
    private TiendaDTO tienda;
    private int filaTienda;
    private boolean esRepetido = false;
    private boolean result = false;
    private String observ = "-";
    private int total = 0;
    private int pregunta;
    final static Logger logger = Logger.getLogger(Tiendas.class);

    public Tiendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        setResizable(false);
        setTitle("Listado de Tiendas");
        try {
            listarTiendas();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void listarTiendas() throws SQLException {
        listTiendas = new ArrayList<>();
        listTiendas = TiendaBL.getInstance().getAll();
        tblTienda.setModel(new TTienda(listTiendas));
        ConfigTables.headerTables(tblTienda);
        ConfigTables.sizeStore(tblTienda);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtRuc = new Folder.DJCTextFieldWithoutPop();
        btnEliminar = new javax.swing.JButton();
        txtRazonSocial = new Folder.DJCTextFieldWithoutPop();
        btnAgregar = new javax.swing.JButton();
        lblRuc = new javax.swing.JLabel();
        btnQuitarSeleccion = new javax.swing.JButton();
        lblDireccion = new javax.swing.JLabel();
        lblObservacion = new javax.swing.JLabel();
        txtDireccion = new Folder.DJCTextFieldWithoutPop();
        scrollObservacion = new javax.swing.JScrollPane();
        textObservacion = new javax.swing.JTextArea();
        scrollTienda = new javax.swing.JScrollPane();
        tblTienda = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnAlmacenes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de tiendas.");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("TIENDAS");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblRazonSocial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRazonSocial.setText("(*) Razon Social:");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar la tienda seleccionada.");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRuc.setPlaceholder("Sólo 12 dígitos.");

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar la tienda seleccionada.");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtRazonSocial.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtRazonSocial.setPlaceholder("Escribir aquí la razón social de la Tienda.");

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva tienda.");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblRuc.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRuc.setText("(*) Ruc:");

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la selección de la tienda seleccionada.");
        btnQuitarSeleccion.setEnabled(false);
        btnQuitarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarSeleccionActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDireccion.setText("(*) Dirección:");

        lblObservacion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblObservacion.setText("Observación:");

        txtDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDireccion.setPlaceholder("Escribir aquí la dirección de la Tienda.");

        textObservacion.setColumns(20);
        textObservacion.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        textObservacion.setRows(5);
        scrollObservacion.setViewportView(textObservacion);

        scrollTienda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        tblTienda.setAutoCreateRowSorter(true);
        tblTienda.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblTienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTienda.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTienda.getTableHeader().setReorderingAllowed(false);
        tblTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiendaMouseClicked(evt);
            }
        });
        scrollTienda.setViewportView(tblTienda);

        btnAlmacenes.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAlmacenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Find.png"))); // NOI18N
        btnAlmacenes.setText("Almacenes");
        btnAlmacenes.setToolTipText("Botón para visualizar los almacenes de la tienda seleccionada.");
        btnAlmacenes.setEnabled(false);
        btnAlmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(lblRuc)
                            .addComponent(lblObservacion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollObservacion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRazonSocial)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTienda))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuc)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRazonSocial)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservacion)
                    .addComponent(scrollObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitarSeleccion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnModificar)
                        .addComponent(btnEliminar))
                    .addComponent(btnAlmacenes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblAviso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiendaMouseClicked
        tblTienda.setRowSelectionAllowed(true);
        filaTienda = tblTienda.getSelectedRow();
        txtRuc.setText(tblTienda.getValueAt(filaTienda, 1).toString());
        txtRazonSocial.setText(tblTienda.getValueAt(filaTienda, 2).toString());
        txtDireccion.setText(tblTienda.getValueAt(filaTienda, 3).toString());
        if (tblTienda.getValueAt(filaTienda, 4) != null) {
            textObservacion.setText(tblTienda.getValueAt(filaTienda, 4).toString());
        }

        btnAlmacenes.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnQuitarSeleccion.setEnabled(true);
    }//GEN-LAST:event_tblTiendaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private boolean esTiendaRepetida(String rucTienda, String razonTienda) {
        for (int i = 0; i < tblTienda.getRowCount(); i++) {
            if (rucTienda.equals(tblTienda.getValueAt(i, 1).toString()) ||
                    razonTienda.equals(tblTienda.getValueAt(i, 2).toString())) {
                return true;
            }
        }
        return false;
    }

    private void inicializarVariables() {
        esRepetido = false;
        tienda = null;
        result = false;
        observ = "-";
        total = 0;
    }
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        inicializarVariables();
        if (!textObservacion.getText().equals("")) {   observ = textObservacion.getText();       }

        if (txtRuc.getText().equals("") || txtRazonSocial.getText().equals("") || txtDireccion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!tblTienda.getValueAt(filaTienda, 1).toString().equals(txtRuc.getText()) || !tblTienda.getValueAt(filaTienda, 2).toString().equals(txtRazonSocial.getText())) {
                esRepetido = esTiendaRepetida(txtRuc.getText(), txtRazonSocial.getText());
            }

            if (esRepetido == true) {
               Messages.messageRepeat();
            } else {
                try {
                    tienda = new TiendaDTO(
                            Integer.parseInt(tblTienda.getValueAt(filaTienda, 0).toString()),
                            txtRuc.getText(),
                            txtRazonSocial.getText(),
                            txtDireccion.getText(),
                            observ
                    );
                    result = TiendaBL.getInstance().update(tienda);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaTienda();
                        listarTiendas();
                    } else {       Messages.messageErrorUpdate();}
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                total = TiendaBL.getInstance().count(Integer.parseInt(tblTienda.getValueAt(filaTienda, 0).toString()), 0);
                if (total == 0) {
                    total = TiendaBL.getInstance().count(Integer.parseInt(tblTienda.getValueAt(filaTienda, 0).toString()), 1);
                    if (total == 0) {
                        tienda = new TiendaDTO(Integer.parseInt(tblTienda.getValueAt(filaTienda, 0).toString()));
                        result = TiendaBL.getInstance().delete(tienda);
                        if (result) {
                            Messages.messageDelete();
                            ActivaTienda();
                            listarTiendas();
                        } else {      Messages.messageErrorDelete();          }                        
                    } else {    Messages.messageError("Exite una relación con algun Almacén, no se puede eliminar en este momento.");        }
                } else {     Messages.messageError("Exite una relación con algun Artículo, no se puede eliminar en este momento.");       }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                logger.error(ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        inicializarVariables();
        if (!textObservacion.getText().equals("")) {   observ = textObservacion.getText();       }

        if (txtRuc.getText().equals("") || txtRazonSocial.getText().equals("") || txtDireccion.getText().equals("")) {
            Messages.messageAlert();
        } else {
            esRepetido = esTiendaRepetida(txtRuc.getText(), txtRazonSocial.getText());

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    tienda = new TiendaDTO(
                            txtRuc.getText(),
                            txtRazonSocial.getText(),
                            txtDireccion.getText(),
                            observ
                    );
                    result = TiendaBL.getInstance().insert(tienda);
                    if (result) {
                        Messages.messageInsert();
                        ActivaTienda();
                        listarTiendas();
                    } else {       Messages.messageErrorInsert();         }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
                    logger.error(ex);
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarSeleccionActionPerformed
        ActivaTienda();
    }//GEN-LAST:event_btnQuitarSeleccionActionPerformed

    private void btnAlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenesActionPerformed
        TiendasAlmacen tal = new TiendasAlmacen(this, true);
        tal.lblTituloRazonSocial.setText(tblTienda.getValueAt(filaTienda, 2).toString());
        tal.codigoTienda = Integer.parseInt(tblTienda.getValueAt(filaTienda, 0).toString());
        try {
            tal.listarTiendaAlmacen(Integer.parseInt(tblTienda.getValueAt(filaTienda, 0).toString()));
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + evt.getActionCommand());
            logger.error(ex);
        }
        tal.setVisible(true);
    }//GEN-LAST:event_btnAlmacenesActionPerformed

    void ActivaTienda() {
        tblTienda.setRowSelectionAllowed(false);
        txtRuc.requestFocus();
        txtRuc.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        textObservacion.setText("");
        btnAgregar.setEnabled(true);
        btnAlmacenes.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnQuitarSeleccion.setEnabled(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tiendas dialog = new Tiendas(new javax.swing.JFrame(),true);
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
    public static javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlmacenes;
    private javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitarSeleccion;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblObservacion;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollObservacion;
    private javax.swing.JScrollPane scrollTienda;
    private javax.swing.JTable tblTienda;
    private javax.swing.JTextArea textObservacion;
    private Folder.DJCTextFieldWithoutPop txtDireccion;
    public static Folder.DJCTextFieldWithoutPop txtRazonSocial;
    private Folder.DJCTextFieldWithoutPop txtRuc;
    // End of variables declaration//GEN-END:variables
}
