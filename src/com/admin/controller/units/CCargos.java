package com.admin.controller.units;

import com.admin.controller.tablemodel.TCargo;
import com.admin.model.bl.CargoBL;
import com.admin.model.dto.CargoDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.Cargos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CCargos extends MouseAdapter implements ActionListener {
    private ArrayList<CargoDTO> listCargos = new ArrayList<>();
    private CargoDTO cargo = null;
    private int estado = 1;
    private String fechaCreacion;
    private final Cargos view_cargo;
    private int filaCargo = -1;
    private boolean esRepetido = false;
    private boolean result = false;
    private int total = 0;
    private int pregunta;
    final static Logger logger = Logger.getLogger(CCargos.class);
    private String textdesc = "-", textmin = "0.00", textmax = "0.00";

    public CCargos (Cargos view) {
        this.view_cargo = view;
        this.view_cargo.btnAgregar.addActionListener(this);
        this.view_cargo.btnModificar.addActionListener(this);
        this.view_cargo.btnActivar.addActionListener(this);
        this.view_cargo.btnDesactivar.addActionListener(this);
        this.view_cargo.btnSeleccion.addActionListener(this);
        this.view_cargo.txtNombre.addActionListener(this);
        this.view_cargo.txtDescripcion.addActionListener(this);
        this.view_cargo.txtMinimo.addActionListener(this);
        this.view_cargo.txtMaximo.addActionListener(this);
        this.view_cargo.btnCancelar.addActionListener(this);
        this.view_cargo.lblTodos.addMouseListener(this);
        this.view_cargo.lblActivos.addMouseListener(this);
        this.view_cargo.lblInactivos.addMouseListener(this);
        this.view_cargo.tblCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargosMouseClicked(evt);
            }
        });
        this.view_cargo.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                view_cargo.dispose();
            }
        });
    }
    
    public void iniciar() {
        view_cargo.setIconImage(Global.ICON_IMAGE);
        view_cargo.setCursor(Global.CURSOR);
        view_cargo.setResizable(false);
        view_cargo.setTitle("Listado de Cargos de Empleados");
        view_cargo.lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
        view_cargo.lblActivos.setForeground(Color.blue); 
        fechaCreacion = Global.CALENDARY.get(Calendar.YEAR) + "-" + (Global.CALENDARY.get(Calendar.MONTH) + 1) + "-" + Global.CALENDARY.get(Calendar.DATE);
        verificarParametros();        
        view_cargo.txtNombre.requestFocus();
    }
    
    private void verificarParametros() {
        if (view_cargo.lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
            estado = 2;
        } else {
            if (view_cargo.lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                estado = 1;
            } else {
                estado = 0;
            }
        }
        try {
            listarCargos(estado);
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    public void listarCargos(int estado) throws SQLException {
        listCargos.clear();
        listCargos = CargoBL.getInstance().listAllByStatus(estado);
        view_cargo.tblCargos.setModel(new TCargo(listCargos));
        ConfigTables.headerTables(view_cargo.tblCargos);
        ConfigTables.sizeTypes(view_cargo.tblCargos);
    }
    
    private boolean esCargoRepetido(String nombre) throws SQLException{
        cargo = CargoBL.getInstance().listByName(nombre);
        return cargo != null;
    }
    
    private void inicializarVariables() {
        cargo = null;
        esRepetido = false;
        result = false;
        textdesc = "-"; 
        textmin = "0.00"; 
        textmax = "0.00";
        total = 0;
    }
    
    private void ActivaCargo() {
        view_cargo.tblCargos.setRowSelectionAllowed(false);
        view_cargo.txtNombre.requestFocus();
        view_cargo.txtNombre.setText("");
        view_cargo.txtDescripcion.setText("");
        view_cargo.txtMinimo.setText("");
        view_cargo.txtMaximo.setText("");
        view_cargo.btnAgregar.setEnabled(true);
        view_cargo.btnModificar.setEnabled(false);
        view_cargo.btnActivar.setEnabled(false);
        view_cargo.btnDesactivar.setEnabled(false);
        view_cargo.btnSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_cargo.btnAgregar) {
            inicializarVariables();
            if (!view_cargo.txtDescripcion.getText().equals("")) {         textdesc = view_cargo.txtDescripcion.getText();       }
            if (!view_cargo.txtMinimo.getText().equals("")) {              textmin = view_cargo.txtMinimo.getText();      }
            if (!view_cargo.txtMaximo.getText().equals("")) {              textmax = view_cargo.txtMaximo.getText();      }

            if (view_cargo.txtNombre.getText().equals("")) {
                Messages.messageAlert();
            } else {
                try {
                    esRepetido = esCargoRepetido(view_cargo.txtNombre.getText());
                    if (esRepetido == true) {
                        Messages.messageRepeat();
                    } else {
                        cargo = new CargoDTO(
                                view_cargo.txtNombre.getText(),
                                textdesc, 
                                fechaCreacion,
                                Float.parseFloat(textmin), 
                                Float.parseFloat(textmax),
                                1
                        );

                        result = CargoBL.getInstance().create(cargo);
                        if (result) {
                            Messages.messageInsert();
                            ActivaCargo();
                            verificarParametros();
                        } else {
                            Messages.messageErrorInsert();
                        }
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_cargo.btnModificar) {
            inicializarVariables();
            if (!view_cargo.txtDescripcion.getText().equals("")) {         textdesc = view_cargo.txtDescripcion.getText();       }
            if (!view_cargo.txtMinimo.getText().equals("")) {              textmin = view_cargo.txtMinimo.getText();      }
            if (!view_cargo.txtMaximo.getText().equals("")) {              textmax = view_cargo.txtMaximo.getText();      }

            if (!view_cargo.tblCargos.getValueAt(filaCargo, 0).toString().equals(view_cargo.txtNombre.getText())) {
                try {
                    esRepetido = esCargoRepetido(view_cargo.txtNombre.getText());
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
                    logger.error(ex);
                }
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    cargo = new CargoDTO(
                            view_cargo.txtNombre.getText(),
                            textdesc,
                            fechaCreacion,
                            Float.parseFloat(textmin),
                            Float.parseFloat(textmax),
                            1
                    );

                    result = CargoBL.getInstance().update(cargo, view_cargo.tblCargos.getValueAt(filaCargo, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaCargo();
                        verificarParametros();
                    } else {
                        Messages.messageErrorUpdate();
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_cargo.btnActivar) {
            inicializarVariables();
            if (Messages.messageDeactive() == 0) {
                try {
                    cargo = new CargoDTO(
                            view_cargo.tblCargos.getValueAt(filaCargo, 0).toString()
                    );
                    result = CargoBL.getInstance().delete(cargo, 1);
                    if (result) {
                        Messages.messageUnDelete();
                        ActivaCargo();
                        verificarParametros();
                    } else {     Messages.messageErrorUnDelete();       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_cargo.btnDesactivar) {
            inicializarVariables();
            pregunta = Messages.messageDeactive();
            if (pregunta == 0) {
                try {
                    total = CargoBL.getInstance().count(view_cargo.tblCargos.getValueAt(filaCargo, 0).toString());
                    if (total == 0 ) {
                        cargo = new CargoDTO(
                                view_cargo.tblCargos.getValueAt(filaCargo, 0).toString()
                        );
                        result = CargoBL.getInstance().delete(cargo, 0);
                        if (result) {
                            Messages.messageDelete();
                            ActivaCargo();
                            verificarParametros();
                        } else {     Messages.messageErrorDelete();       }
                    } else {
                        Messages.messageAlert("Cargo relacionado a Empleado(s), no se puede eliminar en este momento.");
                    }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_cargo.btnSeleccion) {
            ActivaCargo();
        } else if (ae.getSource() == view_cargo.txtNombre) {
            view_cargo.txtDescripcion.requestFocus();
        } else if (ae.getSource() == view_cargo.txtDescripcion) {
            view_cargo.txtMinimo.requestFocus();
        } else if (ae.getSource() == view_cargo.txtMinimo) {
            view_cargo.txtMaximo.requestFocus();
        } else if (ae.getSource() == view_cargo.txtMaximo) {
            
        } else if (ae.getSource() == view_cargo.btnCancelar) {
            view_cargo.dispose();
        }
    }
    
    private void tblCargosMouseClicked(java.awt.event.MouseEvent evt) {                                       
        view_cargo.tblCargos.setRowSelectionAllowed(true);
        view_cargo.btnModificar.setEnabled(true);        
        view_cargo.btnSeleccion.setEnabled(true);
        view_cargo.btnAgregar.setEnabled(false);

        filaCargo = view_cargo.tblCargos.getSelectedRow();
        
        view_cargo.txtNombre.setText(view_cargo.tblCargos.getValueAt(filaCargo, 0).toString());
        if (view_cargo.tblCargos.getValueAt(filaCargo, 0) == null) {    view_cargo.txtDescripcion.setText("-");         }
        else{    view_cargo.txtDescripcion.setText(view_cargo.tblCargos.getValueAt(filaCargo, 1).toString());      }

        if (view_cargo.tblCargos.getValueAt(filaCargo, 2) == null) {    view_cargo.txtMinimo.setText("0.00");    }
        else{   view_cargo.txtMinimo.setText(view_cargo.tblCargos.getValueAt(filaCargo, 2).toString());     }

        if (view_cargo.tblCargos.getValueAt(filaCargo, 3) == null) {     view_cargo.txtMaximo.setText("0.00");   }
        else{   view_cargo.txtMaximo.setText(view_cargo.tblCargos.getValueAt(filaCargo, 3).toString());     }
        
        if (view_cargo.tblCargos.getValueAt(filaCargo, 5).equals("Activo")) {
            view_cargo.btnDesactivar.setEnabled(true);
        } else { 
            view_cargo.btnActivar.setEnabled(true);
        }
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == view_cargo.lblTodos) {
            view_cargo.lblTodos.setFont(new Font("Verdana", Font.BOLD, 12));
            view_cargo.lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_cargo.lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_cargo.lblTodos.setForeground(Color.blue);
            view_cargo.lblActivos.setForeground(Color.black);
            view_cargo.lblInactivos.setForeground(Color.black);        
            verificarParametros();
        } else if (evt.getSource() == view_cargo.lblActivos) {
            view_cargo.lblActivos.setFont(new Font("Verdana", Font.BOLD, 12));
            view_cargo.lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_cargo.lblInactivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_cargo.lblActivos.setForeground(Color.blue);
            view_cargo.lblInactivos.setForeground(Color.black);
            view_cargo.lblTodos.setForeground(Color.black);
            verificarParametros();
        } else if (evt.getSource() == view_cargo.lblInactivos) {
            view_cargo.lblInactivos.setFont(new Font("Verdana", Font.BOLD, 12));
            view_cargo.lblActivos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_cargo.lblTodos.setFont(new Font("Verdana", Font.PLAIN, 11));
            view_cargo.lblInactivos.setForeground(Color.blue);
            view_cargo.lblTodos.setForeground(Color.black);
            view_cargo.lblActivos.setForeground(Color.black);
            verificarParametros();
        }
    }
    
    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == view_cargo.lblTodos) {
            view_cargo.lblTodos.setForeground(Color.blue);
        } else if (evt.getSource() == view_cargo.lblActivos) {
            view_cargo.lblActivos.setForeground(Color.blue);
        } else if (evt.getSource() == view_cargo.lblTodos) {
            view_cargo.lblInactivos.setForeground(Color.blue);
        }
    }
    
    @Override
    public void mouseExited(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == view_cargo.lblTodos) {
            if (view_cargo.lblTodos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                view_cargo.lblTodos.setForeground(Color.blue);
            } else {
                view_cargo.lblTodos.setForeground(Color.black);
            }
        } else if (evt.getSource() == view_cargo.lblActivos) {
            if (view_cargo.lblActivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                view_cargo.lblActivos.setForeground(Color.blue);
            } else {
                view_cargo.lblActivos.setForeground(Color.black);
            }
        } else if (evt.getSource() == view_cargo.lblInactivos) {
            if (view_cargo.lblInactivos.getFont().equals(new Font("Verdana", Font.BOLD, 12))) {
                view_cargo.lblInactivos.setForeground(Color.blue);
            } else {
                view_cargo.lblInactivos.setForeground(Color.black);
            }
        }
    }
}
