package com.admin.controller.units;

import com.admin.controller.tablemodel.TMarca;
import com.admin.model.bl.MarcaBL;
import com.admin.model.dto.MarcaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.resource.utils.ValidateForms;
import com.admin.view.units.Marcas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CMarcas implements ActionListener {
    private ArrayList<MarcaDTO> listMarcas;
    private MarcaDTO marca = null;
    private int filaMarca = -1;
    private boolean esRepetido = false;
    private boolean result = false;
    private String desc = "-";
    private int pregunta;
    private int total = 0;
    private final Marcas view_marca;
    final static Logger logger = Logger.getLogger(CMarcas.class);

    public CMarcas (Marcas view) {
        this.view_marca = view;
        this.view_marca.btnAgregar.addActionListener(this);
        this.view_marca.btnModificar.addActionListener(this);
        this.view_marca.btnEliminar.addActionListener(this);
        this.view_marca.btnQuitarSeleccion.addActionListener(this);
        this.view_marca.btnAceptar.addActionListener(this);
        this.view_marca.txtNombre.addActionListener(this);        
        this.view_marca.txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ValidateForms.soloMayus(view_marca.txtNombre);
            }
        });
        this.view_marca.tblMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMarcaMouseClicked(evt);
            }
        });
    }
    
    public void iniciar () {
        view_marca.setIconImage(Global.ICON_IMAGE);
        view_marca.setCursor(Global.CURSOR);
        view_marca.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        view_marca.setResizable(false);
        view_marca.setTitle("Listado de Marcas");
        try {
            listarMarcas();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
        ValidateForms.soloMayus(view_marca.txtNombre);
    }
    
    private void listarMarcas() throws SQLException {
        listMarcas = new ArrayList<>();
        listMarcas = MarcaBL.getInstance().listAll("");
        view_marca.tblMarca.setModel(new TMarca(listMarcas));
        ConfigTables.headerTables(view_marca.tblMarca);
        ConfigTables.sizeMark(view_marca.tblMarca);
    }
    
    private boolean esMarcaRepetida(String nombreMarca) {
        for (int i = 0; i < view_marca.tblMarca.getRowCount(); i++) {
            if (nombreMarca.equals(view_marca.tblMarca.getValueAt(i, 0).toString())) {
                return true;
            }
        }
        return false;
    }

    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        marca = null;
        desc = "-";
        total = 0;
    }
    
    void ActivaMarca() {
        view_marca.tblMarca.setRowSelectionAllowed(false);
        view_marca.txtNombre.setText("");
        view_marca.txtNombre.requestFocus();
        view_marca.txtDescripcion.setText("");
        view_marca.btnAgregar.setEnabled(true);
        view_marca.btnModificar.setEnabled(false);
        view_marca.btnEliminar.setEnabled(false);
        view_marca.btnQuitarSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_marca.btnAgregar) {
            inicializarVariables();
            if (!view_marca.txtDescripcion.getText().equals("")) { desc = view_marca.txtDescripcion.getText();  }

            if (view_marca.txtNombre.getText().equals("")) {
                Messages.messageAlert();
            } else {
                esRepetido = esMarcaRepetida(view_marca.txtNombre.getText());

                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        marca = new MarcaDTO(
                                view_marca.txtNombre.getText(),
                                desc
                        );
                        result = MarcaBL.getInstance().insert(marca);
                        if (result) {
                                Messages.messageInsert();
                                ActivaMarca();
                                listarMarcas();
                        } else {     Messages.messageErrorInsert();       }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_marca.btnModificar) {
            inicializarVariables();
            if (!view_marca.txtDescripcion.getText().equals("")) { desc = view_marca.txtDescripcion.getText();  }

            if (view_marca.txtNombre.getText().equals("")) {
                Messages.messageAlert();
            } else {
                if (!view_marca.tblMarca.getValueAt(filaMarca, 0).toString().equals(view_marca.txtNombre.getText())) {
                    esRepetido = esMarcaRepetida(view_marca.txtNombre.getText());
                }

                if (esRepetido == true) {
                   Messages.messageRepeat();
                } else {
                    try {
                        marca = new MarcaDTO(
                                view_marca.txtNombre.getText(),
                                desc
                        );
                        result = MarcaBL.getInstance().update(marca, view_marca.tblMarca.getValueAt(filaMarca, 0).toString());
                        if (result) {
                            Messages.messageUpdate();
                            ActivaMarca();
                            listarMarcas();
                        } else {      Messages.messageErrorUpdate();      }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_marca.btnEliminar) {
            pregunta = Messages.messageDeactive();
            inicializarVariables();
            if (pregunta == 0) {
                try {
                    total = MarcaBL.getInstance().count(view_marca.tblMarca.getValueAt(filaMarca, 0).toString());
                    if (total == 0) {
                        marca = new MarcaDTO(
                                view_marca.tblMarca.getValueAt(filaMarca, 0).toString()
                        );
                        result = MarcaBL.getInstance().delete(marca);
                        if (result) {
                            Messages.messageDelete();
                            ActivaMarca();
                            listarMarcas();
                        } else {       Messages.messageErrorDelete();        }                    
                    } else {     Messages.messageError("Existen artículo(s) con esta marca, no se puede eliminar en este momento.");       }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_marca.btnQuitarSeleccion) {
            ActivaMarca();
        } else if (ae.getSource() == view_marca.btnAceptar) {
            view_marca.dispose();
        } else if (ae.getSource() == view_marca.txtNombre) {
            view_marca.txtDescripcion.requestFocus();
        }
    }
    
    private void tblMarcaMouseClicked(java.awt.event.MouseEvent evt) {                                      
        view_marca.tblMarca.setRowSelectionAllowed(true);
        filaMarca = view_marca.tblMarca.getSelectedRow();
        view_marca.txtNombre.setText(view_marca.tblMarca.getValueAt(filaMarca, 0).toString());
        view_marca.txtDescripcion.setText(view_marca.tblMarca.getValueAt(filaMarca, 1).toString());

        view_marca.btnAgregar.setEnabled(false);
        view_marca.btnModificar.setEnabled(true);
        view_marca.btnEliminar.setEnabled(true);
        view_marca.btnQuitarSeleccion.setEnabled(true);
    }
}
