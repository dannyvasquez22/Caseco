package com.admin.controller.units;

import com.admin.controller.tablemodel.TUnidadMedida;
import com.admin.model.bl.UnidadMedidaBL;
import com.admin.model.dto.UnidadMedidaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ValidateForms;
import com.admin.view.units.UnidadesMedida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CUnidadesMedida implements ActionListener {
    private ArrayList<UnidadMedidaDTO> listUnidades;
    private UnidadMedidaDTO unidad;
    private int filaUnidad = -1;
    private boolean esRepetido = false;
    private boolean result = false;
    private String desc = "-";
    private int total = 0;
    private int pregunta;
    private final UnidadesMedida view_unidad;
    final static Logger logger = Logger.getLogger(CUnidadesMedida.class);

    public CUnidadesMedida (UnidadesMedida view) {
        this.view_unidad = view;
        this.view_unidad.btnAgregar.addActionListener(this);
        this.view_unidad.btnModificar.addActionListener(this);
        this.view_unidad.btnEliminar.addActionListener(this);
        this.view_unidad.btnQuitarSeleccion.addActionListener(this);
        this.view_unidad.btnCancelar.addActionListener(this);
        this.view_unidad.txtNombre.addActionListener(this);
        this.view_unidad.txtValorRef.addActionListener(this);
        this.view_unidad.txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ValidateForms.soloMayus(view_unidad.txtNombre);
            }
        });
        this.view_unidad.tblUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUnidadesMouseClicked(evt);
            }
        });
        this.view_unidad.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                view_unidad.dispose();
            }
        });
    }
    
    public void iniciar() {
        view_unidad.setIconImage(Global.ICON_IMAGE);
        view_unidad.setCursor(Global.CURSOR);
        view_unidad.setResizable(false);
        view_unidad.setTitle("Listado de Unidades de Medida");
        try {
            listarUnidades();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        ValidateForms.soloMayus(view_unidad.txtNombre);
    }
    
    private void listarUnidades() throws SQLException {
        listUnidades = new ArrayList<>();
        listUnidades = UnidadMedidaBL.getInstance().listAll("");
        view_unidad.tblUnidades.setModel(new TUnidadMedida(listUnidades));
        ConfigTables.headerTables(view_unidad.tblUnidades);
        ConfigTables.sizeUnitMeasure(view_unidad.tblUnidades);
    }
    
    private boolean esUnidadRepetida (String unidad) {
        for (int i = 0; i < view_unidad.tblUnidades.getRowCount(); i++) {
            if (unidad.equals(view_unidad.tblUnidades.getValueAt(i, 0).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        unidad = null;
        result = false;
        desc = "-";
        total = 0;
    }
    
    void ActivaUnidad() {
        view_unidad.tblUnidades.setRowSelectionAllowed(false);
        view_unidad.txtNombre.setText("");
        view_unidad.txtNombre.requestFocus();
        view_unidad.txtValorRef.setText("");
        view_unidad.txtDescripcion.setText("");
        view_unidad.btnAgregar.setEnabled(true);
        view_unidad.btnModificar.setEnabled(false);
        view_unidad.btnEliminar.setEnabled(false);
        view_unidad.btnQuitarSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_unidad.btnAgregar) {
            inicializarVariables();
            if (!view_unidad.txtDescripcion.getText().equals("")) {  desc = view_unidad.txtDescripcion.getText();  }

            if (view_unidad.txtNombre.getText().equals("") || view_unidad.txtValorRef.getText().equals("")) {
                Messages.messageAlert();
            } else {
                esRepetido = esUnidadRepetida(view_unidad.txtNombre.getText());

                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        unidad = new UnidadMedidaDTO(
                                view_unidad.txtNombre.getText(),
                                Float.parseFloat(view_unidad.txtValorRef.getText()),
                                desc
                        );
                        result = UnidadMedidaBL.getInstance().insert(unidad);
                        if (result) {
                            Messages.messageInsert();
                            ActivaUnidad();
                            listarUnidades();
                        } else {       Messages.messageErrorInsert();         }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_unidad.btnModificar) {
            inicializarVariables();
            if (!view_unidad.txtDescripcion.getText().equals("")) {  desc = view_unidad.txtDescripcion.getText();  }

            if (view_unidad.txtNombre.getText().equals("") || view_unidad.txtValorRef.getText().equals("")) {
                Messages.messageAlert();
            } else {
                if (!view_unidad.tblUnidades.getValueAt(filaUnidad, 0).toString().equals(view_unidad.txtNombre.getText())) {
                    esRepetido = esUnidadRepetida(view_unidad.txtNombre.getText());
                }

                if (esRepetido == true) {
                   Messages.messageRepeat();
                } else {
                    try {
                        unidad = new UnidadMedidaDTO(
                                view_unidad.txtNombre.getText(),
                                Float.parseFloat(view_unidad.txtValorRef.getText()),
                                desc
                        );
                        result = UnidadMedidaBL.getInstance().update(unidad, view_unidad.tblUnidades.getValueAt(filaUnidad, 0).toString());
                        if (result) {
                            Messages.messageUpdate();
                            ActivaUnidad();
                            listarUnidades();
                        } else {      Messages.messageErrorUpdate();          }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_unidad.btnEliminar) {
            pregunta = Messages.messageDeactive();
            inicializarVariables();
            if (pregunta == 0) {
                try {
                    total = UnidadMedidaBL.getInstance().count(view_unidad.tblUnidades.getValueAt(filaUnidad, 0).toString());
                    if (total == 0) {
                        unidad = new UnidadMedidaDTO(
                                view_unidad.tblUnidades.getValueAt(filaUnidad, 0).toString()
                        );
                        result = UnidadMedidaBL.getInstance().delete(unidad);
                        if (result) {
                            Messages.messageDelete();
                            ActivaUnidad();
                            listarUnidades();
                        } else {     Messages.messageErrorDelete();       }
                    } else {     Messages.messageError("Existe relación de artículo(s) con esta Unidad, no se puede eliminar en este momento.");       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_unidad.btnQuitarSeleccion) {
            ActivaUnidad();
        } else if (ae.getSource() == view_unidad.btnCancelar) {
            view_unidad.dispose();
        } else if (ae.getSource() == view_unidad.txtNombre) {
            view_unidad.txtValorRef.requestFocus();
        } else if (ae.getSource() == view_unidad.txtValorRef) {
            view_unidad.txtDescripcion.requestFocus();
        }
    }
    
    private void tblUnidadesMouseClicked(java.awt.event.MouseEvent evt) {                                         
        view_unidad.tblUnidades.setRowSelectionAllowed(true);
        filaUnidad = view_unidad.tblUnidades.getSelectedRow();
        view_unidad.txtNombre.setText(view_unidad.tblUnidades.getValueAt(filaUnidad, 0).toString());
        view_unidad.txtValorRef.setText(view_unidad.tblUnidades.getValueAt(filaUnidad, 1).toString());
        if (view_unidad.tblUnidades.getValueAt(filaUnidad, 2) != null) {
            view_unidad.txtDescripcion.setText(view_unidad.tblUnidades.getValueAt(filaUnidad, 2).toString());  }

        view_unidad.btnAgregar.setEnabled(false);
        view_unidad.btnModificar.setEnabled(true);
        view_unidad.btnEliminar.setEnabled(true);
        view_unidad.btnQuitarSeleccion.setEnabled(true);
    } 
}
