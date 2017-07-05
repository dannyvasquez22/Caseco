package com.admin.controller.units;

import com.admin.controller.tablemodel.TTelefono;
import com.admin.model.bl.TelefonoBL;
import com.admin.model.dto.TelefonoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.TiendasAlmacen_Telefono;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CTiendasAlmacen_Telefono implements ActionListener {
    private static ArrayList<TelefonoDTO> listTelefonos = new ArrayList<>();
    private TelefonoDTO telefono;
    private boolean esRepetido = false;
    private boolean result = false;
    private int filaTelefono;
    public final String codigoAlmacen;    
    public final String razonSocial;    
    public final String lugarVenta;    
    private String []filaTabla;
    private int pregunta;
    private final TiendasAlmacen_Telefono view_telefono;
    static Logger logger = Logger.getLogger(CTiendasAlmacen_Telefono.class);
    
    public CTiendasAlmacen_Telefono (TiendasAlmacen_Telefono view, String razon, String lugar, String codigo) {
        this.view_telefono = view;
        this.razonSocial = razon;
        this.lugarVenta = lugar;
        this.codigoAlmacen = codigo;
        this.view_telefono.btnAgregar.addActionListener(this);
        this.view_telefono.btnModificar.addActionListener(this);
        this.view_telefono.btnEliminar.addActionListener(this);
        this.view_telefono.btnQuitarSeleccion.addActionListener(this);
        this.view_telefono.btnCancelar.addActionListener(this);
        this.view_telefono.tblTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonoMouseClicked(evt);
            }
        });
    }
    
    public void iniciar () {
        view_telefono.setIconImage(Global.ICON_IMAGE);
        view_telefono.setCursor(Global.CURSOR);
        view_telefono.setResizable(false);
        view_telefono.setTitle("Teléfonos de Almacén");
        view_telefono.lblRazonSocialOrigen.setText(razonSocial);
        view_telefono.lblAlmacenOrigen.setText(lugarVenta);
        try {
            listarTelefonos("TIENDA", codigoAlmacen);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }

    private void listarTelefonos(String tipoReferencia, String referencia) throws SQLException {
        listTelefonos.clear();
        listTelefonos = TelefonoBL.getInstance().listReference(tipoReferencia, referencia);
        view_telefono.tblTelefono.setModel(new TTelefono(listTelefonos));
        ConfigTables.headerTables(view_telefono.tblTelefono);
        ConfigTables.sizeCellphone(view_telefono.tblTelefono);
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        telefono = null;
        result = false;
        filaTabla = new String[3];
        filaTabla[0] = "";
        filaTabla[1] = "";
        filaTabla[2] = "";
    }
    
    private void ActivaTelefono() {
        view_telefono.tblTelefono.setRowSelectionAllowed(false);
        view_telefono.boxTelefonia.setSelectedItem(null);
        view_telefono.boxTipoTelefonia.setSelectedItem(null);
        view_telefono.txtNumero.setText("");
        view_telefono.btnAgregar.setEnabled(true);
        view_telefono.btnModificar.setEnabled(false);
        view_telefono.btnEliminar.setEnabled(false);
        view_telefono.btnQuitarSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_telefono.btnAgregar) {
            inicializarVariables();        
            if (view_telefono.txtNumero.getText().equals("")) {
                Messages.messageAlert();
            } else {
                if (view_telefono.boxTelefonia.getSelectedItem() != null) {       filaTabla[0] = view_telefono.boxTelefonia.getSelectedItem().toString();     }
                if (view_telefono.boxTipoTelefonia.getSelectedItem() != null) {   filaTabla[1] = view_telefono.boxTipoTelefonia.getSelectedItem().toString(); }
                                                                    filaTabla[2] = view_telefono.txtNumero.getText();

                for (int cont = 0; cont < view_telefono.tblTelefono.getRowCount(); cont++) {
                    if (view_telefono.txtNumero.getText().equals(view_telefono.tblTelefono.getValueAt(cont, 3).toString())) {
                        esRepetido = true;
                    }
                }
                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        telefono = new TelefonoDTO(
                                filaTabla[0],
                                filaTabla[1],
                                view_telefono.txtNumero.getText(),
                                "TIENDA",
                                codigoAlmacen
                        );
                        result = TelefonoBL.getInstance().insert(telefono);
                        if (result) {
                            Messages.messageInsert();
                            ActivaTelefono();
                            listarTelefonos("TIENDA", codigoAlmacen);                            
                        } else {    Messages.messageErrorInsert();        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_telefono.btnModificar) {
            inicializarVariables();
            if (view_telefono.txtNumero.getText().equals("")) {
                Messages.messageAlert();
            } else {            
                if (view_telefono.boxTelefonia.getSelectedItem() != null) {     filaTabla[0] = view_telefono.boxTelefonia.getSelectedItem().toString();     }
                if (view_telefono.boxTipoTelefonia.getSelectedItem() != null) { filaTabla[1] = view_telefono.boxTipoTelefonia.getSelectedItem().toString(); }
                                                                  filaTabla[2] = view_telefono.txtNumero.getText();

                if (!view_telefono.tblTelefono.getValueAt(filaTelefono, 3).toString().equals(filaTabla[2])) {
                    for (int cont = 0; cont < view_telefono.tblTelefono.getRowCount(); cont++) {
                        if (filaTabla[2].equals(view_telefono.tblTelefono.getValueAt(cont, 3).toString())) {
                            esRepetido = true;
                        }
                    }
                }
                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        telefono = new TelefonoDTO(
                                Integer.parseInt(view_telefono.tblTelefono.getValueAt(filaTelefono, 0).toString()),
                                filaTabla[0],
                                filaTabla[1],
                                view_telefono.txtNumero.getText()
                        );
                        result = TelefonoBL.getInstance().update(telefono);
                        if (result) {
                            Messages.messageUpdate();                            
                            ActivaTelefono();
                            listarTelefonos("TIENDA", codigoAlmacen);
                        } else {    Messages.messageErrorUpdate();      }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_telefono.btnEliminar) {
            inicializarVariables();
            pregunta = Messages.messageDeactive();
            if (0 == pregunta) {
                try {
                    telefono = new TelefonoDTO(
                            Integer.parseInt(view_telefono.tblTelefono.getValueAt(filaTelefono, 0).toString())
                    );
                    result = TelefonoBL.getInstance().delete(telefono);
                    if (result) {
                        Messages.messageDelete();                        
                        ActivaTelefono();
                        listarTelefonos("TIENDA", codigoAlmacen);
                    } else {     Messages.messageErrorDelete();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_telefono.btnQuitarSeleccion) {
            ActivaTelefono();
        } else if (ae.getSource() == view_telefono.btnCancelar) {
            view_telefono.dispose();
        }
    }
    
    private void tblTelefonoMouseClicked(java.awt.event.MouseEvent evt) {                                         
        view_telefono.tblTelefono.setRowSelectionAllowed(true);
        filaTelefono = view_telefono.tblTelefono.getSelectedRow();
        if (view_telefono.tblTelefono.getValueAt(filaTelefono, 1) == null) {
            view_telefono.boxTelefonia.setSelectedItem(null);
        } else {
            view_telefono.boxTelefonia.setSelectedItem(view_telefono.tblTelefono.getValueAt(filaTelefono, 1).toString());
        }
        if (view_telefono.tblTelefono.getValueAt(filaTelefono,2) == null) {
            view_telefono.boxTipoTelefonia.setSelectedItem(null);
        } else {
            view_telefono.boxTipoTelefonia.setSelectedItem(view_telefono.tblTelefono.getValueAt(filaTelefono, 2).toString());
        }
        view_telefono.txtNumero.setText(view_telefono.tblTelefono.getValueAt(filaTelefono, 3).toString());

        view_telefono.btnAgregar.setEnabled(false);
        view_telefono.btnModificar.setEnabled(true);
        view_telefono.btnEliminar.setEnabled(true);
        view_telefono.btnQuitarSeleccion.setEnabled(true);
    }
}
