package com.admin.controller.units;

import com.admin.controller.tablemodel.TCategoria;
import com.admin.model.bl.CategoriaBL;
import com.admin.model.dto.CategoriaDTO;
import com.admin.resource.utils.ConfigTables;
import com.admin.resource.utils.Global;
import com.admin.resource.utils.Messages;
import com.admin.view.units.Categorias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** * @author DANNY VASQUEZ RAFAEL */

public class CCategorias implements ActionListener {
    private ArrayList<CategoriaDTO> listCategoria = new ArrayList<>();
    private CategoriaDTO categoria = null;
    private int filaCategoria;
    private boolean esRepetido = false;
    private boolean result = false;
    private String cate_desc = "-";
    private int pregunta;
    private int total = 0;
    private final Categorias view_categoria;
    final static Logger logger = Logger.getLogger(CCategorias.class);

    public CCategorias (Categorias view) {
        this.view_categoria = view;
        this.view_categoria.btnAgregar.addActionListener(this);
        this.view_categoria.btnModificar.addActionListener(this);
        this.view_categoria.btnEliminar.addActionListener(this);
        this.view_categoria.btnCancelarSeleccion.addActionListener(this);
        this.view_categoria.btnCancelar.addActionListener(this);
        this.view_categoria.txtNombre.addActionListener(this);
        this.view_categoria.tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        this.view_categoria.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                view_categoria.dispose();
            }
        });
    }
    
    public void iniciar() {
        view_categoria.setIconImage(Global.ICON_IMAGE);
        view_categoria.setCursor(Global.CURSOR);
        view_categoria.setResizable(false);
        view_categoria.setTitle("Listado de Categorías de Productos");
        try {
            listarCategorias();
        } catch (SQLException ex) {
            logger.error(ex);
        }
        view_categoria.txtNombre.requestFocus();
    }
    
    private void listarCategorias() throws SQLException {
        listCategoria.clear();
        listCategoria = CategoriaBL.getInstance().getAll("");
        view_categoria.tblCategoria.setModel(new TCategoria(listCategoria));
        ConfigTables.headerTables(view_categoria.tblCategoria);
        ConfigTables.sizeCategory(view_categoria.tblCategoria);
    }
    
    private boolean esCategoriaRepetida(String nombreCategoria) {
        for (int i = 0; i < view_categoria.tblCategoria.getRowCount(); i++) {
            if (nombreCategoria.equals(view_categoria.tblCategoria.getValueAt(i,0).toString())) {
                return true;
            }
        }
        return false;
    }
    
    private void inicializarVariables() {
        esRepetido = false;
        result = false;
        categoria = null;
        cate_desc = "-";
        total = 0;
    }
    
    private void accionEliminar() {
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                total = CategoriaBL.getInstance().count(view_categoria.tblCategoria.getValueAt(filaCategoria, 0).toString());
                if (total == 0) {
                    categoria = new CategoriaDTO(
                            view_categoria.tblCategoria.getValueAt(filaCategoria, 0).toString()
                    );
                    result = CategoriaBL.getInstance().delete(categoria);
                    if (result) {
                        Messages.messageDelete();
                        ActivaCategoria();
                        listarCategorias();
                    } else {     Messages.messageErrorDelete();       }
                } else {      Messages.messageError("Existe artículo(s) con esta Categoría, no se puede eliminar en este momento.");          }
            } catch (SQLException ex) {
                Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: Eliminar" );
                logger.error(ex);
            }
        }
    }
    
    private void accionModificar() {
        inicializarVariables();     
        if (view_categoria.txtNombre.getText().equals("")) {
            Messages.messageAlert();
        } else {
            if (!view_categoria.tblCategoria.getValueAt(filaCategoria, 0).toString().equals(view_categoria.txtNombre.getText())) {
                esRepetido = esCategoriaRepetida(view_categoria.txtNombre.getText());
            }

            if (esRepetido == true) {
                Messages.messageRepeat();
            } else {
                try {
                    if (!view_categoria.txtDescripcion.getText().equals("")) {   cate_desc = view_categoria.txtDescripcion.getText();   }
                    categoria = new CategoriaDTO(
                            view_categoria.txtNombre.getText(),
                            cate_desc
                    );
                    result = CategoriaBL.getInstance().update(categoria, view_categoria.tblCategoria.getValueAt(filaCategoria, 0).toString());
                    if (result) {
                        Messages.messageUpdate();
                        ActivaCategoria();
                        listarCategorias();
                    } else {     Messages.messageErrorUpdate();        }
                } catch (SQLException ex) {
                    Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: Modificar");
                    logger.error(ex);
                }
            }
        }
    }
    
    private void ActivaCategoria() {
        view_categoria.tblCategoria.setRowSelectionAllowed(false);
        view_categoria.txtNombre.setText("");
        view_categoria.txtNombre.requestFocus();
        view_categoria.txtDescripcion.setText("");
        view_categoria.btnAgregar.setEnabled(true);
        view_categoria.btnModificar.setEnabled(false);
        view_categoria.btnEliminar.setEnabled(false);
        view_categoria.btnCancelarSeleccion.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view_categoria.btnAgregar) {
            inicializarVariables();
            if (view_categoria.txtNombre.getText().equals("")) {
               Messages.messageAlert();
            } else {
                esRepetido = esCategoriaRepetida(view_categoria.txtNombre.getText());
                if (esRepetido == true) {
                    Messages.messageRepeat();
                } else {
                    try {
                        if (!view_categoria.txtDescripcion.getText().equals("")) {   cate_desc = view_categoria.txtDescripcion.getText();   }
                        categoria = new CategoriaDTO(
                                view_categoria.txtNombre.getText(),
                                cate_desc
                        );

                        result = CategoriaBL.getInstance().insert(categoria);
                        if (result) {
                            Messages.messageInsert();
                            ActivaCategoria();
                            listarCategorias();
                        } else {    Messages.messageErrorInsert();        }
                    } catch (SQLException ex) {
                        Messages.messageError("Error: " + ex.getSQLState() + " - " + ex.toString() + ". Botón: " + ae.getActionCommand());
                        logger.error(ex);
                    }
                }
            }
        } else if (ae.getSource() == view_categoria.btnModificar) {
            accionModificar();
        } else if (ae.getSource() == view_categoria.btnEliminar) {
            accionEliminar();
        } else if (ae.getSource() == view_categoria.btnCancelarSeleccion) {
            ActivaCategoria();
        } else if (ae.getSource() == view_categoria.btnCancelar) {
            view_categoria.dispose();
        } else if (ae.getSource() == view_categoria.txtNombre) {
            view_categoria.txtDescripcion.requestFocus();
        }
    }

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {                                          
        view_categoria.tblCategoria.setRowSelectionAllowed(true);
        filaCategoria = view_categoria.tblCategoria.getSelectedRow();
        view_categoria.txtNombre.setText(view_categoria.tblCategoria.getValueAt(filaCategoria, 0).toString());
        view_categoria.txtDescripcion.setText(view_categoria.tblCategoria.getValueAt(filaCategoria, 1).toString());
        
        view_categoria.btnAgregar.setEnabled(false);
        view_categoria.btnModificar.setEnabled(true);
        view_categoria.btnEliminar.setEnabled(true);
        view_categoria.btnCancelarSeleccion.setEnabled(true);
    }
}
