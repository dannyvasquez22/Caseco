package com.admin.controller.units;

import com.admin.controller.tablemodel.TTienda;
import com.admin.model.bl.TiendaBL;
import com.admin.model.dto.TiendaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.Tiendas;
import com.admin.view.units.TiendasAlmacen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CTiendas implements ActionListener {
    private ArrayList<TiendaDTO> listTiendas;
    private TiendaDTO tienda;
    private int filaTienda;
    private boolean esRepetido = false;
    private boolean result = false;
    private String observ = "-";
    private int total = 0;
    private int pregunta;
    private final Tiendas view_tienda;
    private TiendasAlmacen view_almacen;    
    private CTiendasAlmacen controller_almacen;    
    final static Logger logger = Logger.getLogger(CTiendas.class);
    
    public CTiendas (Tiendas view) {
        this.view_tienda = view;
        this.view_tienda.btnAgregar.addActionListener(this);
        this.view_tienda.btnModificar.addActionListener(this);
        this.view_tienda.btnEliminar.addActionListener(this);
        this.view_tienda.btnQuitarSeleccion.addActionListener(this);
        this.view_tienda.btnAlmacenes.addActionListener(this);
        this.view_tienda.btnCancelar.addActionListener(this);
        this.view_tienda.tblTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiendaMouseClicked(evt);
            }
        });
        this.view_tienda.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                view_tienda.dispose();
            }
        });
    }
    
    public void iniciar () {
        view_tienda.setIconImage(Global.ICON_IMAGE);
        view_tienda.setCursor(Global.CURSOR);
        view_tienda.setResizable(false);
        view_tienda.setTitle("Listado de Tiendas");
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
        view_tienda.tblTienda.setModel(new TTienda(listTiendas));
        ConfigTables.headerTables(view_tienda.tblTienda);
        ConfigTables.sizeStore(view_tienda.tblTienda);
    }
    
    private boolean esTiendaRepetida(String rucTienda, String razonTienda) {
        for (int i = 0; i < view_tienda.tblTienda.getRowCount(); i++) {
            if (rucTienda.equals(view_tienda.tblTienda.getValueAt(i, 1).toString()) ||
                    razonTienda.equals(view_tienda.tblTienda.getValueAt(i, 2).toString())) {
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
    
    private void ActivaTienda() {
        view_tienda.tblTienda.setRowSelectionAllowed(false);
        view_tienda.txtRuc.requestFocus();
        view_tienda.txtRuc.setText("");
        view_tienda.txtRazonSocial.setText("");
        view_tienda.txtDireccion.setText("");
        view_tienda.textObservacion.setText("");
        view_tienda.btnAgregar.setEnabled(true);
        view_tienda.btnAlmacenes.setEnabled(false);
        view_tienda.btnModificar.setEnabled(false);
        view_tienda.btnEliminar.setEnabled(false);
        view_tienda.btnQuitarSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_tienda.btnAgregar) {
            inicializarVariables();
            if (!view_tienda.textObservacion.getText().equals("")) {   observ = view_tienda.textObservacion.getText();       }

            if (view_tienda.txtRuc.getText().equals("") || view_tienda.txtRazonSocial.getText().equals("") || view_tienda.txtDireccion.getText().equals("")) {
                Messages.messageAlert();
            } else {
                esRepetido = esTiendaRepetida(view_tienda.txtRuc.getText(), view_tienda.txtRazonSocial.getText());

                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        tienda = new TiendaDTO(
                                view_tienda.txtRuc.getText(),
                                view_tienda.txtRazonSocial.getText(),
                                view_tienda.txtDireccion.getText(),
                                observ
                        );
                        result = TiendaBL.getInstance().insert(tienda);
                        if (result) {
                            Messages.messageInsert();
                            ActivaTienda();
                            listarTiendas();
                        } else {       Messages.messageErrorInsert();         }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_tienda.btnModificar) {
            inicializarVariables();
            if (!view_tienda.textObservacion.getText().equals("")) {   observ = view_tienda.textObservacion.getText();       }

            if (view_tienda.txtRuc.getText().equals("") || view_tienda.txtRazonSocial.getText().equals("") || view_tienda.txtDireccion.getText().equals("")) {
                Messages.messageAlert();
            } else {
                if (!view_tienda.tblTienda.getValueAt(filaTienda, 1).toString().equals(view_tienda.txtRuc.getText()) || !view_tienda.tblTienda.getValueAt(filaTienda, 2).toString().equals(view_tienda.txtRazonSocial.getText())) {
                    esRepetido = esTiendaRepetida(view_tienda.txtRuc.getText(), view_tienda.txtRazonSocial.getText());
                }

                if (esRepetido == true) {
                   Messages.messageRepeat();
                } else {
                    try {
                        tienda = new TiendaDTO(
                                Integer.parseInt(view_tienda.tblTienda.getValueAt(filaTienda, 0).toString()),
                                view_tienda.txtRuc.getText(),
                                view_tienda.txtRazonSocial.getText(),
                                view_tienda.txtDireccion.getText(),
                                observ
                        );
                        result = TiendaBL.getInstance().update(tienda);
                        if (result) {
                            Messages.messageUpdate();
                            ActivaTienda();
                            listarTiendas();
                        } else {       Messages.messageErrorUpdate();}
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_tienda.btnEliminar) {
            inicializarVariables();
            pregunta = Messages.messageDeactive();
            if (pregunta == 0) {
                try {
                    total = TiendaBL.getInstance().count(Integer.parseInt(view_tienda.tblTienda.getValueAt(filaTienda, 0).toString()), 0);
                    if (total == 0) {
                        total = TiendaBL.getInstance().count(Integer.parseInt(view_tienda.tblTienda.getValueAt(filaTienda, 0).toString()), 1);
                        if (total == 0) {
                            tienda = new TiendaDTO(Integer.parseInt(view_tienda.tblTienda.getValueAt(filaTienda, 0).toString()));
                            result = TiendaBL.getInstance().delete(tienda);
                            if (result) {
                                Messages.messageDelete();
                                ActivaTienda();
                                listarTiendas();
                            } else {      Messages.messageErrorDelete();          }                        
                        } else {    Messages.messageError("Exite una relación con algun Almacén, no se puede eliminar en este momento.");        }
                    } else {     Messages.messageError("Exite una relación con algun Artículo, no se puede eliminar en este momento.");       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_tienda.btnQuitarSeleccion) {
            ActivaTienda();
        } else if (ae.getSource() == view_tienda.btnAlmacenes) {
            view_almacen = new TiendasAlmacen(view_tienda, true);
            controller_almacen = new CTiendasAlmacen(
                    view_almacen,
                    Integer.parseInt(view_tienda.tblTienda.getValueAt(filaTienda, 0).toString()),
                    view_tienda.tblTienda.getValueAt(filaTienda, 2).toString()
            );
            controller_almacen.iniciar();
            view_almacen.setVisible(true);
        } else if (ae.getSource() == view_tienda.btnCancelar) {
            view_tienda.dispose();
        }
    }

    private void tblTiendaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        view_tienda.tblTienda.setRowSelectionAllowed(true);
        filaTienda = view_tienda.tblTienda.getSelectedRow();
        view_tienda.txtRuc.setText(view_tienda.tblTienda.getValueAt(filaTienda, 1).toString());
        view_tienda.txtRazonSocial.setText(view_tienda.tblTienda.getValueAt(filaTienda, 2).toString());
        view_tienda.txtDireccion.setText(view_tienda.tblTienda.getValueAt(filaTienda, 3).toString());
        if (view_tienda.tblTienda.getValueAt(filaTienda, 4) != null) {
            view_tienda.textObservacion.setText(view_tienda.tblTienda.getValueAt(filaTienda, 4).toString());
        }

        view_tienda.btnAlmacenes.setEnabled(true);
        view_tienda.btnAgregar.setEnabled(false);
        view_tienda.btnModificar.setEnabled(true);
        view_tienda.btnEliminar.setEnabled(true);
        view_tienda.btnQuitarSeleccion.setEnabled(true);
    }
}
