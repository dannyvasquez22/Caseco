package com.admin.controller.units;

import com.admin.controller.tablemodel.TObservacion;
import com.admin.model.bl.ObservacionBL;
import com.admin.model.dto.ObservacionDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.Vehiculos_Observacion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CVehiculos_Observacion implements ActionListener {
    public static ArrayList<ObservacionDTO> listObservaciones;
    private ObservacionDTO observacion;
    private int filaObservacion = -1;
    public final String codigoVehiculo;
    public final String origenVehiculo;
    public final String estadoVehiculo;
    private boolean result = false;
    private int pregunta;
    private final Vehiculos_Observacion view_observacion;
    final static Logger logger = Logger.getLogger(CVehiculos_Observacion.class);
    
    public CVehiculos_Observacion (Vehiculos_Observacion view, String codigo, String origen, String estado) {
        this.view_observacion = view;
        this.codigoVehiculo = codigo;
        this.origenVehiculo = origen;
        this.estadoVehiculo = estado;
        this.view_observacion.btnAgregar.addActionListener(this);
        this.view_observacion.btnModificar.addActionListener(this);
        this.view_observacion.btnEliminar.addActionListener(this);
        this.view_observacion.btnQuitarSeleccion.addActionListener(this);
        this.view_observacion.btnCancelar.addActionListener(this);
        this.view_observacion.tblObservacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblObservacionMouseClicked(evt);
            }
        });
        this.view_observacion.chooserFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                chooserFechaOnCommit(evt);
            }
        });
    }
    
    public void iniciar() {
        view_observacion.chooserFecha.setDateFormat(Global.FORMAT_DATE_CLIENT);
        view_observacion.setIconImage(Global.ICON_IMAGE);
        view_observacion.setCursor(Global.CURSOR);
        view_observacion.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        view_observacion.setResizable(false);
        view_observacion.setTitle("Observaciones del Vehículo"); 
        view_observacion.lblVehiculoOrigen.setText(origenVehiculo);
        view_observacion.lblEstado.setText(estadoVehiculo);
        if (estadoVehiculo.equals("Activo")) {
            view_observacion.lblEstado.setForeground(Color.blue); 
        } else {
            view_observacion.lblEstado.setForeground(Color.red); 
        }
        try {
            listarObservaciones("VEHICULO", codigoVehiculo);
        } catch (SQLException ex) { 
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void listarObservaciones(String tipoReferencia, String referencia) throws SQLException {
        listObservaciones = new ArrayList<>();
        listObservaciones = ObservacionBL.getInstance().listReference(tipoReferencia, referencia);
        view_observacion.tblObservacion.setModel(new TObservacion(listObservaciones));
        ConfigTables.headerTables(view_observacion.tblObservacion);
        ConfigTables.sizeObservation(view_observacion.tblObservacion);
    }
    
    private void ActivaObservacion() {
        view_observacion.tblObservacion.setRowSelectionAllowed(false);
        view_observacion.textDescripcion.requestFocus();
        view_observacion.textDescripcion.setText("");
        view_observacion.txtFecha.setText("");
        view_observacion.btnAgregar.setEnabled(true);
        view_observacion.btnModificar.setEnabled(false);
        view_observacion.btnEliminar.setEnabled(false);
        view_observacion.btnQuitarSeleccion.setEnabled(false);
    }

    private void inicializarVariables() {
        observacion = null;
        result = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_observacion.btnAgregar) {
            inicializarVariables();
            if (view_observacion.textDescripcion.getText().equals("") || view_observacion.txtFecha.getText().equals("")) {
                Messages.messageAlert();
            } else {
                try {
                    observacion = new ObservacionDTO(
                            Global.formatSQL(view_observacion.txtFecha.getText()),
                            view_observacion.textDescripcion.getText(),
                            "VEHICULO",
                            codigoVehiculo
                    );

                    result = ObservacionBL.getInstance().insert(observacion);
                    if (result) {                        
                        Messages.messageInsert();
                        ActivaObservacion();
                        listarObservaciones("VEHICULO", codigoVehiculo);
                    } else {      Messages.messageErrorInsert();      }
                } catch (SQLException | ParseException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_observacion.btnModificar) {
            inicializarVariables();
            if (view_observacion.textDescripcion.getText().equals("") || view_observacion.txtFecha.getText().equals("")) {
                Messages.messageAlert();
            } else {
                try {
                    observacion = new ObservacionDTO(
                            Integer.parseInt(view_observacion.tblObservacion.getValueAt(filaObservacion, 0).toString()),
                            Global.formatSQL(view_observacion.txtFecha.getText()),
                            view_observacion.textDescripcion.getText()
                    );

                    result = ObservacionBL.getInstance().update(observacion);
                    if (result) {                        
                        Messages.messageUpdate();
                        ActivaObservacion();
                        listarObservaciones("VEHICULO", codigoVehiculo);
                    } else {       Messages.messageErrorUpdate();       }
                } catch (SQLException | ParseException ex) {
                    Messages.messageError("Error: " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_observacion.btnEliminar) {
            inicializarVariables();
            pregunta = Messages.messageDeactive();
            if (0 == pregunta) {
                try {
                    observacion = new ObservacionDTO(
                            Integer.parseInt(view_observacion.tblObservacion.getValueAt(filaObservacion, 0).toString())
                    );

                    result = ObservacionBL.getInstance().delete(observacion);
                    if (result) {                        
                        Messages.messageUpdate();
                        ActivaObservacion();
                        listarObservaciones("VEHICULO", codigoVehiculo);
                    } else {     Messages.messageErrorUpdate();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_observacion.btnQuitarSeleccion) {
            ActivaObservacion();
        } else if (ae.getSource() == view_observacion.btnCancelar) {
            view_observacion.dispose();
        }
    }

    private void tblObservacionMouseClicked(java.awt.event.MouseEvent evt) {                                            
        view_observacion.tblObservacion.setRowSelectionAllowed(true);
        filaObservacion = view_observacion.tblObservacion.getSelectedRow();
        view_observacion.txtFecha.setText(view_observacion.tblObservacion.getValueAt(filaObservacion, 1).toString());
        view_observacion.textDescripcion.setText(view_observacion.tblObservacion.getValueAt(filaObservacion, 2).toString());

        view_observacion.btnAgregar.setEnabled(false);
        view_observacion.btnModificar.setEnabled(true);
        view_observacion.btnEliminar.setEnabled(true);
        view_observacion.btnQuitarSeleccion.setEnabled(true);
    }
    
    private void chooserFechaOnCommit(datechooser.events.CommitEvent evt) {                                      
        view_observacion.txtFecha.setText(view_observacion.chooserFecha.getText());
    }
}
