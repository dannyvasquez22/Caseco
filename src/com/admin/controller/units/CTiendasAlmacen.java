package com.admin.controller.units;

import com.admin.controller.tablemodel.TTiendaAlmacen;
import com.admin.model.bl.AlmacenBL;
import com.admin.model.bl.DetalleTiendaBL;
import com.admin.model.dto.AlmacenDTO;
import com.admin.model.dto.DetalleTiendaDTO;
import com.admin.model.dto.TiendaDTO;
import com.admin.model.pojo.TiendaAlmacenP;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.TiendasAlmacen;
import com.admin.view.units.TiendasAlmacen_Telefono;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CTiendasAlmacen implements ActionListener {
    private DetalleTiendaDTO detalleTienda;
    private AlmacenDTO almacen;
    private static ArrayList<TiendaAlmacenP> listDetalle;
    private static DefaultComboBoxModel modeloCombo;
    private static ArrayList<String> namesCombo;
    private int filaTablaAlmacen;
    private boolean esRepetido = false;
    private boolean result = false;
    public int codigoTienda;
    private int pregunta;
    private String fechaFinDetalle;
    private TiendasAlmacen_Telefono view_telefono;
    private CTiendasAlmacen_Telefono controller_telefono;
    private final TiendasAlmacen view_almacen;
    private final String tituloTienda;
    static Logger logger = Logger.getLogger(CTiendasAlmacen.class);
    
    public CTiendasAlmacen (TiendasAlmacen view, int codigo, String titulo) {
        this.view_almacen = view;
        this.codigoTienda = codigo;
        this.tituloTienda = titulo;
        this.view_almacen.btnAgregar.addActionListener(this);
        this.view_almacen.btnModificar.addActionListener(this);
        this.view_almacen.btnEliminar.addActionListener(this);
        this.view_almacen.btnQuitarSeleccion.addActionListener(this);
        this.view_almacen.btnCancelar.addActionListener(this);
        this.view_almacen.btnTelefonoLugar.addActionListener(this);
        this.view_almacen.tblLugarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLugarVentaMouseClicked(evt);
            }
        });
        this.view_almacen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                view_almacen.dispose();
            }
        });
    }
    
    public void iniciar () {
        view_almacen.setIconImage(Global.ICON_IMAGE);
        view_almacen.setCursor(Global.CURSOR);
        view_almacen.setResizable(false);
        view_almacen.setTitle("Listado de Puntos de Venta");
        try {
            cargarAlmacenBox();
            listarTiendaAlmacen(codigoTienda);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        view_almacen.lblTituloRazonSocial.setText(tituloTienda);
        try {
            listarTiendaAlmacen(codigoTienda);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void cargarAlmacenBox() throws SQLException {
        namesCombo = new ArrayList<>();
        modeloCombo = new DefaultComboBoxModel();
        namesCombo = AlmacenBL.getInstance().listNamesCombo();
        namesCombo.forEach(modeloCombo::addElement);
        view_almacen.boxLugarVenta.setModel(modeloCombo);        
    }
    
    private void listarTiendaAlmacen(int codigo) throws SQLException {
        listDetalle = new ArrayList<>();
        listDetalle = DetalleTiendaBL.getInstance().listAllDetail(codigo);
        view_almacen.tblLugarVenta.setModel(new TTiendaAlmacen(listDetalle));
        ConfigTables.headerTables(view_almacen.tblLugarVenta);
        ConfigTables.SizeStoreWarehouse(view_almacen.tblLugarVenta);
    }
    
    private void ActivaLugar() {
        view_almacen.tblLugarVenta.setRowSelectionAllowed(false);
        view_almacen.boxLugarVenta.setSelectedItem(null);
        view_almacen.btnAgregar.setEnabled(true);
        view_almacen.btnModificar.setEnabled(false);
        view_almacen.btnEliminar.setEnabled(false);
        view_almacen.btnQuitarSeleccion.setEnabled(false);
        view_almacen.btnTelefonoLugar.setEnabled(false);
    }
    
    private boolean esRepetido(String tiendaAlmacen) {
        for (int cont = 0; cont < view_almacen.tblLugarVenta.getRowCount(); cont++) {
            if (tiendaAlmacen.equals(view_almacen.tblLugarVenta.getValueAt(cont, 3).toString()) &&
             ("").equals(view_almacen.tblLugarVenta.getValueAt(cont, 2).toString())) {
                return true;
            }
        }
        return false;
    }

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        almacen = null;
        detalleTienda = null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_almacen.btnAgregar) {
            inicializarVariables();
            Global.CALENDARY = Calendar.getInstance();
            fechaFinDetalle = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);

            esRepetido = esRepetido(view_almacen.boxLugarVenta.getSelectedItem().toString());
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    almacen = AlmacenBL.getInstance().getByName(view_almacen.boxLugarVenta.getSelectedItem().toString());

                    detalleTienda = new DetalleTiendaDTO(
                            fechaFinDetalle,
                            new TiendaDTO(codigoTienda),
                            almacen
                    );
                    result = DetalleTiendaBL.getInstance().insert(detalleTienda);
                    if (result) {
                        Messages.messageInsert();
                        ActivaLugar();
                        listarTiendaAlmacen(codigoTienda);
                    } else {       Messages.messageErrorInsert();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_almacen.btnModificar) {
            inicializarVariables();
            if (!view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen, 3).toString().equals(view_almacen.boxLugarVenta.getSelectedItem().toString())) {
                esRepetido = esRepetido(view_almacen.boxLugarVenta.getSelectedItem().toString());
            }
            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    almacen = AlmacenBL.getInstance().getByName(view_almacen.boxLugarVenta.getSelectedItem().toString());

                    detalleTienda = new DetalleTiendaDTO(
                            Integer.parseInt(view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString()),
                            fechaFinDetalle,
                            new TiendaDTO(codigoTienda),
                            almacen
                    );
                    result = DetalleTiendaBL.getInstance().update(detalleTienda);
                    if (result) {
                        Messages.messageUpdate();
                        ActivaLugar();
                        listarTiendaAlmacen(codigoTienda);
                    } else {       Messages.messageErrorUpdate();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_almacen.btnEliminar) {
            inicializarVariables();
            Global.CALENDARY = Calendar.getInstance();
            fechaFinDetalle = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
            pregunta = Messages.messageDeactive();
            if (0 == pregunta) {
                try {
                    detalleTienda = new DetalleTiendaDTO(
                            Integer.parseInt(view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString()),
                            fechaFinDetalle
                    );
                    result = DetalleTiendaBL.getInstance().delete(detalleTienda);
                    if (result) {
                        Messages.messageDelete();
                        ActivaLugar();
                        listarTiendaAlmacen(codigoTienda);
                    } else {       Messages.messageErrorDelete();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_almacen.btnQuitarSeleccion) {
            ActivaLugar();
        } else if (ae.getSource() == view_almacen.btnCancelar) {
            view_almacen.dispose();
        } else if (ae.getSource() == view_almacen.btnTelefonoLugar) {
            view_telefono  = new TiendasAlmacen_Telefono(view_almacen, true);
            controller_telefono = new CTiendasAlmacen_Telefono(
                    view_telefono,
                    view_almacen.lblTituloRazonSocial.getText(),
                    view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen, 3).toString(),                    
                    view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen, 0).toString()                    
            );
            controller_telefono.iniciar();
            view_telefono.setVisible(true);
        }
    }
    
    private void tblLugarVentaMouseClicked(java.awt.event.MouseEvent evt) {                                           
        view_almacen.tblLugarVenta.setRowSelectionAllowed(true);
        view_almacen.btnAgregar.setEnabled(false);
        view_almacen.btnModificar.setEnabled(true);
        view_almacen.btnEliminar.setEnabled(true);
        view_almacen.btnQuitarSeleccion.setEnabled(true);
        view_almacen.btnTelefonoLugar.setEnabled(true);
        filaTablaAlmacen = view_almacen.tblLugarVenta.getSelectedRow();
        if (!view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen,2).toString().equals("")) {
            view_almacen.btnModificar.setEnabled(false);
            view_almacen.btnEliminar.setEnabled(false);
        }
        view_almacen.boxLugarVenta.setSelectedItem(view_almacen.tblLugarVenta.getValueAt(filaTablaAlmacen, 3).toString());
    }
}
