package com.admin.controller.units;

import com.admin.controller.tablemodel.TVehiculo;
import com.admin.model.bl.VehiculoBL;
import com.admin.model.dto.VehiculoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.Vehiculos;
import com.admin.view.units.Vehiculos_Observacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CVehiculos extends MouseAdapter implements ActionListener {
    private ArrayList<VehiculoDTO> listVehiculo;
    private VehiculoDTO vehiculo;
    private boolean esRepetido = false;
    private int filaVehiculo = -1;
    private boolean result = false;
    private int estado = 1;
    private final Vehiculos view_vehiculo;
    private Vehiculos_Observacion view_observacion;    
    private CVehiculos_Observacion controller_observacion;    
    private float kmt, gln;
    private int pregunta;
    final static Logger logger = Logger.getLogger(CVehiculos.class);
    
    public CVehiculos (Vehiculos view) {
        this.view_vehiculo = view;
        this.view_vehiculo.btnAgregar.addActionListener(this);
        this.view_vehiculo.btnModificar.addActionListener(this);
        this.view_vehiculo.btnActivar.addActionListener(this);
        this.view_vehiculo.btnDesactivar.addActionListener(this);
        this.view_vehiculo.btnObservaciones.addActionListener(this);
        this.view_vehiculo.btnQuitarSeleccion.addActionListener(this);
        this.view_vehiculo.btnCancelar.addActionListener(this);
        this.view_vehiculo.txtPlaca.addActionListener(this);
        this.view_vehiculo.txtMarca.addActionListener(this);
        this.view_vehiculo.txtGalonaje.addActionListener(this);
        this.view_vehiculo.txtKilometraje.addActionListener(this);
        this.view_vehiculo.txtCertificado.addActionListener(this);
        this.view_vehiculo.lblTodos.addMouseListener(this);
        this.view_vehiculo.lblActivos.addMouseListener(this);
        this.view_vehiculo.lblInactivos.addMouseListener(this);
        this.view_vehiculo.tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });
    }
    
    public void iniciar () {
        view_vehiculo.setIconImage(Global.ICON_IMAGE);
        view_vehiculo.setCursor(Global.CURSOR);
        view_vehiculo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        view_vehiculo.setResizable(false);
        view_vehiculo.setTitle("Listado de Vehículos");
        view_vehiculo.lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        view_vehiculo.lblActivos.setForeground(Color.blue); 
        verificarParametros();
    }
    
    private void verificarParametros() {
        if (view_vehiculo.lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            estado = 2;
        } else {
            if (view_vehiculo.lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                estado = 1;
            } else {
                estado = 0;
            }
        }
        ActivaVehiculo();
        try {
            listarVehiculos(estado);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void listarVehiculos(int status) throws SQLException {
        listVehiculo = new ArrayList<>();
        listVehiculo = VehiculoBL.getInstance().getAll(status);
        view_vehiculo.tblVehiculos.setModel(new TVehiculo(listVehiculo));
        ConfigTables.headerTables(view_vehiculo.tblVehiculos);
        ConfigTables.sizeVehicle(view_vehiculo.tblVehiculos);
    }
    
    private boolean esVehiculoRepetido (String nPlaca) {
        inicializarVariables();
        try {
            vehiculo = VehiculoBL.getInstance().getById(nPlaca);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        return vehiculo != null;
    }

    private void inicializarVariables() {
        esRepetido = false;
        vehiculo = null;
        result = false;
        kmt = 0;
        gln = 0;
    }
    
    private void ActivaVehiculo() {
        view_vehiculo.tblVehiculos.setRowSelectionAllowed(false);
        view_vehiculo.txtPlaca.requestFocus();
        view_vehiculo.txtPlaca.setText("");
        view_vehiculo.txtCertificado.setText("");
        view_vehiculo.txtMarca.setText("");
        view_vehiculo.txtKilometraje.setText("");
        view_vehiculo.txtGalonaje.setText("");
        view_vehiculo.btnAgregar.setEnabled(true);
        view_vehiculo.btnModificar.setEnabled(false);
        view_vehiculo.btnActivar.setEnabled(false);
        view_vehiculo.btnDesactivar.setEnabled(false);
        view_vehiculo.btnObservaciones.setEnabled(false);
        view_vehiculo.btnQuitarSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_vehiculo.btnAgregar) {
            inicializarVariables();
            if (!view_vehiculo.txtKilometraje.getText().equals("")) {        kmt = Float.parseFloat(view_vehiculo.txtKilometraje.getText());      }
            if (!view_vehiculo.txtGalonaje.getText().equals("")) {     gln = Float.parseFloat(view_vehiculo.txtGalonaje.getText());   }

            if (view_vehiculo.txtPlaca.getText().equals("") || view_vehiculo.txtCertificado.getText().equals("") || view_vehiculo.txtMarca.getText().equals("")) {
                Messages.messageAlert();
            } else {
                esRepetido = esVehiculoRepetido(view_vehiculo.txtPlaca.getText());
                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        vehiculo = new VehiculoDTO(
                                view_vehiculo.txtPlaca.getText(),
                                view_vehiculo.txtCertificado.getText(),
                                view_vehiculo.txtMarca.getText(),
                                kmt,
                                gln,
                                "1"
                        );
                        result = VehiculoBL.getInstance().insert(vehiculo);
                        if (result) {
                            Messages.messageInsert();
                            ActivaVehiculo();
                            verificarParametros();
                        } else {      Messages.messageErrorInsert();          }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_vehiculo.btnModificar) {
            inicializarVariables();
            if (!view_vehiculo.txtKilometraje.getText().equals("")) {        kmt = Float.parseFloat(view_vehiculo.txtKilometraje.getText());      }
            if (!view_vehiculo.txtGalonaje.getText().equals("")) {     gln = Float.parseFloat(view_vehiculo.txtGalonaje.getText());   }

            if (view_vehiculo.txtPlaca.getText().equals("") || view_vehiculo.txtCertificado.getText().equals("") || view_vehiculo.txtMarca.getText().equals("")) {
                Messages.messageAlert();
            } else {
                if (!view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 0).toString().equals(view_vehiculo.txtPlaca.getText())) {
                    esRepetido = esVehiculoRepetido(view_vehiculo.txtPlaca.getText());
                }

                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        vehiculo = new VehiculoDTO(
                                view_vehiculo.txtPlaca.getText(),
                                view_vehiculo.txtCertificado.getText(),
                                view_vehiculo.txtMarca.getText(),
                                kmt,
                                gln
                        );
                        result = VehiculoBL.getInstance().update(vehiculo, view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 0).toString());
                        if (result) {
                            Messages.messageUpdate();
                            ActivaVehiculo();
                            verificarParametros();
                        } else {      Messages.messageErrorUpdate();         }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_vehiculo.btnActivar) {
            pregunta = Messages.messageActive();
            inicializarVariables();
            if (pregunta == 0) {
                try {
                    vehiculo = new VehiculoDTO(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 0).toString());
                    result = VehiculoBL.getInstance().delete(vehiculo, 1);
                    if (result) {
                        Messages.messageUnDelete();
                        ActivaVehiculo();
                        verificarParametros();
                    } else {     Messages.messageErrorUnDelete();         }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_vehiculo.btnDesactivar) {
            pregunta = Messages.messageDeactive();
            inicializarVariables();
            if (pregunta == 0) {
                try {
                    vehiculo = new VehiculoDTO(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 0).toString());
                    result = VehiculoBL.getInstance().delete(vehiculo, 0);
                    if (result) {
                        Messages.messageDelete();
                        ActivaVehiculo();
                        verificarParametros();
                    } else {     Messages.messageErrorDelete();         }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_vehiculo.btnObservaciones) {
            view_observacion = new Vehiculos_Observacion(view_vehiculo, true);
            controller_observacion = new CVehiculos_Observacion(
                                        view_observacion, 
                                        view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 0).toString(),
                                        view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 2).toString(),
                                        view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 5).toString()
                                    );
            controller_observacion.iniciar();
            view_observacion.setVisible(true);
        } else if (ae.getSource() == view_vehiculo.btnQuitarSeleccion) {
            ActivaVehiculo();
        } else if (ae.getSource() == view_vehiculo.btnCancelar) {
            view_vehiculo.dispose();
        } else if (ae.getSource() == view_vehiculo.txtPlaca) {
            view_vehiculo.txtMarca.requestFocus();
        } else if (ae.getSource() == view_vehiculo.txtMarca) {
            view_vehiculo.txtCertificado.requestFocus();
        } else if (ae.getSource() == view_vehiculo.txtGalonaje) {
            view_vehiculo.txtMarca.requestFocus();
        } else if (ae.getSource() == view_vehiculo.txtKilometraje) {
            view_vehiculo.txtGalonaje.requestFocus();
        } else if (ae.getSource() == view_vehiculo.txtCertificado) {
            view_vehiculo.txtKilometraje.requestFocus();
        }
    }

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {                                          
        view_vehiculo.tblVehiculos.setRowSelectionAllowed(true);
        view_vehiculo.btnModificar.setEnabled(true);
        view_vehiculo.btnQuitarSeleccion.setEnabled(true);
        view_vehiculo.btnAgregar.setEnabled(false);
        view_vehiculo.btnObservaciones.setEnabled(true);

        filaVehiculo = view_vehiculo.tblVehiculos.getSelectedRow();
        view_vehiculo.txtPlaca.setText(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 0).toString());
        view_vehiculo.txtCertificado.setText(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 1).toString());
        view_vehiculo.txtMarca.setText(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 2).toString());
        view_vehiculo.txtKilometraje.setText(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 3).toString());
        view_vehiculo.txtGalonaje.setText(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 4).toString());
        if(view_vehiculo.tblVehiculos.getValueAt(filaVehiculo, 5).toString().equals("Activo")) {
            view_vehiculo.btnActivar.setEnabled(false);
            view_vehiculo.btnDesactivar.setEnabled(true);
        } else {
            view_vehiculo.btnActivar.setEnabled(true);
            view_vehiculo.btnDesactivar.setEnabled(false);
        }
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == view_vehiculo.lblTodos) {
            view_vehiculo.lblTodos.setFont(new Font("Verdana", Font.BOLD, 12));
            view_vehiculo.lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_vehiculo.lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_vehiculo.lblTodos.setForeground(Color.blue);
            view_vehiculo.lblActivos.setForeground(Color.black);
            view_vehiculo.lblInactivos.setForeground(Color.black);        
            verificarParametros();
        } else if (evt.getSource() == view_vehiculo.lblActivos) {
            view_vehiculo.lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
            view_vehiculo.lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_vehiculo.lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_vehiculo.lblActivos.setForeground(Color.blue);
            view_vehiculo.lblInactivos.setForeground(Color.black);
            view_vehiculo.lblTodos.setForeground(Color.black);
            verificarParametros();
        } else if (evt.getSource() == view_vehiculo.lblInactivos) {
            view_vehiculo.lblInactivos.setFont(new Font("Verdana", Font.BOLD, 12));
            view_vehiculo.lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_vehiculo.lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_vehiculo.lblInactivos.setForeground(Color.blue);
            view_vehiculo.lblTodos.setForeground(Color.black);
            view_vehiculo.lblActivos.setForeground(Color.black);
            verificarParametros();
        }
    }
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == view_vehiculo.lblTodos) {
            view_vehiculo.lblTodos.setForeground(Color.blue);
        } else if (evt.getSource() == view_vehiculo.lblActivos) {
            view_vehiculo.lblActivos.setForeground(Color.blue);
        } else if (evt.getSource() == view_vehiculo.lblInactivos) {
            view_vehiculo.lblInactivos.setForeground(Color.blue);
        }
    }
    
    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == view_vehiculo.lblTodos) {
            if (view_vehiculo.lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                view_vehiculo.lblTodos.setForeground(Color.blue);
            } else {
                view_vehiculo.lblTodos.setForeground(Color.black);
            }
        } else if (evt.getSource() == view_vehiculo.lblActivos) {
            if (view_vehiculo.lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                view_vehiculo.lblActivos.setForeground(Color.blue);
            } else {
                view_vehiculo.lblActivos.setForeground(Color.black);
            }
        } else if (evt.getSource() == view_vehiculo.lblInactivos) {
            if (view_vehiculo.lblInactivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                view_vehiculo.lblInactivos.setForeground(Color.blue);
            } else {
                view_vehiculo.lblInactivos.setForeground(Color.black);
            }
        }
    }
}
