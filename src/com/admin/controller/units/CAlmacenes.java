package com.admin.controller.units;

import com.admin.controller.tablemodel.TAlmacen;
import com.admin.model.bl.AlmacenBL;
import com.admin.model.dto.AlmacenDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.Almacenes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CAlmacenes implements ActionListener {
    private ArrayList<AlmacenDTO> listAlmacen = new ArrayList<>();
    private AlmacenDTO almacen = null;
    private int filaAlmacen = -1;
    private boolean esRepetido = false;
    private boolean result = false;
    private int pregunta;
    private int total = 0;
    private final Almacenes view_almacen;
    final static Logger logger = Logger.getLogger(CAlmacenes.class);
    
    public CAlmacenes (Almacenes view) {
        this.view_almacen = view;
        this.view_almacen.btnAgregar.addActionListener(this);
        this.view_almacen.btnModificar.addActionListener(this);
        this.view_almacen.btnEliminar.addActionListener(this);
        this.view_almacen.btnQuitarSeleccion.addActionListener(this);
        this.view_almacen.txtNombre.addActionListener(this);
        this.view_almacen.btnCancelar.addActionListener(this);
        this.view_almacen.tblAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenMouseClicked(evt);
            }
        });
        this.view_almacen.txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });
        this.view_almacen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                view_almacen.dispose();
            }
        });
    }
    
    public void iniciar() {
        view_almacen.setIconImage(Global.ICON_IMAGE);
        view_almacen.setCursor(Global.CURSOR);
        view_almacen.setResizable(false);
        view_almacen.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        view_almacen.setTitle("Listado de Almacénes");
        try {
            listarAlmacenes();
        } catch (SQLException ex) {
            Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString());
            logger.error(ex);
        }
    }
    
    private void listarAlmacenes() throws SQLException {
        listAlmacen.clear();
        listAlmacen = AlmacenBL.getInstance().getAll();
        view_almacen.tblAlmacen.setModel(new TAlmacen(listAlmacen));
        ConfigTables.headerTables(view_almacen.tblAlmacen);
        ConfigTables.sizeWarehouse(view_almacen.tblAlmacen);
    }
    
    private boolean esAlmacenRepetido(String nombreAlmacen) {
        for (int i = 0; i < view_almacen.tblAlmacen.getRowCount(); i++) {
            if (nombreAlmacen.equals(view_almacen.tblAlmacen.getValueAt(i, 1).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        almacen = null;
        total = 0;
    }
    
    private void ActivaAlmacen() {
        view_almacen.tblAlmacen.setRowSelectionAllowed(false);
        view_almacen.txtNombre.setText("");
        view_almacen.txtNombre.requestFocus();
        view_almacen.txtDireccion.setText("");
        view_almacen.btnAgregar.setEnabled(true);
        view_almacen.btnModificar.setEnabled(false);
        view_almacen.btnEliminar.setEnabled(false);
        view_almacen.btnQuitarSeleccion.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {    
        if (ae.getSource() == view_almacen.btnAgregar) {
            inicializarVariables();
            if (view_almacen.txtNombre.getText().equals("") || view_almacen.txtDireccion.getText().equals("")) {
                Messages.messageAlert();
            } else {
                esRepetido = esAlmacenRepetido(view_almacen.txtNombre.getText());

                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        almacen = new AlmacenDTO(
                                view_almacen.txtNombre.getText(),
                                view_almacen.txtDireccion.getText());
                        result = AlmacenBL.getInstance().insert(almacen);
                        if (result){
                            ActivaAlmacen();
                            Messages.messageInsert();
                            listarAlmacenes();
                        } else {    Messages.messageErrorInsert();      }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_almacen.btnModificar) {
            inicializarVariables();
            if (view_almacen.txtNombre.getText().equals("") || view_almacen.txtDireccion.getText().equals("")) {
                Messages.messageAlert();
            } else {
                if (!view_almacen.txtNombre.getText().equals(view_almacen.tblAlmacen.getValueAt(filaAlmacen,1).toString())) {
                    esRepetido = esAlmacenRepetido(view_almacen.txtNombre.getText());
                }
                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        almacen = new AlmacenDTO(
                                Integer.parseInt(view_almacen.tblAlmacen.getValueAt(filaAlmacen, 0).toString()),
                                view_almacen.txtNombre.getText(),
                                view_almacen.txtDireccion.getText()
                        );
                        result = AlmacenBL.getInstance().update(almacen);
                        if (result) {                        
                            Messages.messageUpdate();
                            ActivaAlmacen();
                            listarAlmacenes();
                        } else {    Messages.messageErrorUpdate();      }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_almacen.btnEliminar) {
            inicializarVariables();
            pregunta = Messages.messageDeactive();
            if (pregunta == 0) {
                try {
                    total = AlmacenBL.getInstance().count(Integer.parseInt(view_almacen.tblAlmacen.getValueAt(filaAlmacen, 0).toString()));
                    if (total == 0) {
                        almacen = new AlmacenDTO(
                                Integer.parseInt(view_almacen.tblAlmacen.getValueAt(filaAlmacen, 0).toString())
                        );

                        result = AlmacenBL.getInstance().delete(almacen);
                        if (result) {
                            ActivaAlmacen();
                            Messages.messageDelete();
                            listarAlmacenes();
                        } else {    Messages.messageErrorDelete();        }
                    } else {     Messages.messageError("Almacén relacionado con Artículo(s) y Razón Social (Ventas), no se puede eliminar en este momento.");     }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                    logger.error(ex);
                }
            }
        } else if (ae.getSource() == view_almacen.btnQuitarSeleccion) {
            ActivaAlmacen();
        } else if (ae.getSource() == view_almacen.txtNombre) {
            view_almacen.txtDireccion.requestFocus();
        } else if (ae.getSource() == view_almacen.btnCancelar) {
            view_almacen.dispose();
        }
    }
    
    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {                                        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (view_almacen.btnAgregar.isEnabled()) {
                view_almacen.btnAgregar.doClick();
            } else {
                view_almacen.btnModificar.doClick();
            }
        }
    }
    
    private void tblAlmacenMouseClicked(java.awt.event.MouseEvent evt) {                                        
        view_almacen.tblAlmacen.setRowSelectionAllowed(true);
        filaAlmacen = view_almacen.tblAlmacen.getSelectedRow();
        view_almacen.txtNombre.setText(view_almacen.tblAlmacen.getValueAt(filaAlmacen, 1).toString());
        view_almacen.txtDireccion.setText(view_almacen.tblAlmacen.getValueAt(filaAlmacen, 2).toString());

        view_almacen.btnAgregar.setEnabled(false);
        view_almacen.btnModificar.setEnabled(true);
        view_almacen.btnEliminar.setEnabled(true);
        view_almacen.btnQuitarSeleccion.setEnabled(true);
    }
}
