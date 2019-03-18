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
    private int articulosRelacionados = 0;
    
    private int paginaEspecifica = -1;
    private int operacionPagina = -1;
    private int totalRegistros = 0; // Total totalRegistros
    private int pagina = -1;
    private int totalPaginas = -1;
    private int registroXPagina = -1;
    private int paginaVerInicio = 0;
    private int paginaVerFin = 0;
    
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
        
        this.view_categoria.boxRegistroXPagina.addActionListener(this);
        this.view_categoria.txtPagina.addActionListener(this);
        this.view_categoria.btnAnterior.addActionListener(this);
        this.view_categoria.btnFinAnterior.addActionListener(this);
        this.view_categoria.btnSiguiente.addActionListener(this);
        this.view_categoria.btnFinSiguiente.addActionListener(this);
        
        this.view_categoria.tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        this.view_categoria.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
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
        pagina = Integer.parseInt(view_categoria.txtPagina.getText());
        registroXPagina = Integer.parseInt((String) view_categoria.boxRegistroXPagina.getSelectedItem());
        if (pagina == 1) {
            listCategoria = CategoriaBL.getInstance().getAllPagination("",  0, registroXPagina, 2);
        } else {
            listCategoria = CategoriaBL.getInstance().getAllPagination("",  (pagina * registroXPagina) - registroXPagina, registroXPagina, 2);
        }
        view_categoria.tblCategoria.setModel(new TCategoria(listCategoria));
        ConfigTables.headerTables(view_categoria.tblCategoria);
        ConfigTables.sizeCategory(view_categoria.tblCategoria);
        componentesPaginacion();       
    }
    
    private void componentesPaginacion() {
        try {
            totalRegistros = CategoriaBL.getInstance().totalRow();
            if (pagina == 1) {
                view_categoria.lblTotalRegistros.setText("Mostrando de 1 al " + view_categoria.tblCategoria.getRowCount() + " de " + totalRegistros + " registros.");
            } else {
                paginaVerInicio = (((pagina - 1) * registroXPagina) + 1);
                paginaVerFin = paginaVerInicio + (view_categoria.tblCategoria.getRowCount() - 1);
                view_categoria.lblTotalRegistros.setText("Mostrando de " + paginaVerInicio + " al " + paginaVerFin + " de " + totalRegistros + " registros.");
            }
            if (registroXPagina >= totalRegistros) {
                ActivaPaginacion(4);
                pagina = 1;
                totalPaginas = 1;
            } else {
                totalPaginas = (int) Math.ceil(Double.valueOf(totalRegistros) / Double.valueOf(registroXPagina));
                
                if (pagina == 1) {
                    ActivaPaginacion(1);
                } else if (pagina == totalPaginas) {
                    ActivaPaginacion(3);
                } else {
                    ActivaPaginacion(2);
                }                
            }
            view_categoria.lblPagina.setText("Página " + pagina + " de " + totalPaginas);
        } catch (SQLException ex) {
            logger.error(ex);
        }
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
        articulosRelacionados = 0;
    }
    
    private void accionEliminar() {
        inicializarVariables();
        pregunta = Messages.messageDeactive();
        if (pregunta == 0) {
            try {
                articulosRelacionados = CategoriaBL.getInstance().count(view_categoria.tblCategoria.getValueAt(filaCategoria, 0).toString(), 2);
                if (articulosRelacionados == 0) {
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
    
    private void ActivaPaginacion(int modo) {
        switch (modo) {
            case 1:
                view_categoria.btnAnterior.setEnabled(false);
                view_categoria.btnFinAnterior.setEnabled(false);
                view_categoria.btnSiguiente.setEnabled(true);
                view_categoria.btnFinSiguiente.setEnabled(true);
                view_categoria.txtPagina.setEditable(true);
                break;
            case 2:
                view_categoria.btnAnterior.setEnabled(true);
                view_categoria.btnFinAnterior.setEnabled(true);
                view_categoria.btnSiguiente.setEnabled(true);
                view_categoria.btnFinSiguiente.setEnabled(true);
                view_categoria.txtPagina.setEditable(true);
                break;
            case 3:
                view_categoria.btnAnterior.setEnabled(true);
                view_categoria.btnFinAnterior.setEnabled(true);
                view_categoria.btnSiguiente.setEnabled(false);
                view_categoria.btnFinSiguiente.setEnabled(false);
                view_categoria.txtPagina.setEditable(true);
                break;
            default:
                view_categoria.btnAnterior.setEnabled(false);
                view_categoria.btnFinAnterior.setEnabled(false);
                view_categoria.btnSiguiente.setEnabled(false);
                view_categoria.btnFinSiguiente.setEnabled(false);
                view_categoria.txtPagina.setEditable(false);
                break;
        }
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
        } else if (ae.getSource() == view_categoria.boxRegistroXPagina) {
            try {
                pagina = 1;
                view_categoria.txtPagina.setText(String.valueOf(pagina));
                listarCategorias();
            } catch (SQLException ex) {
                logger.error(ex);
            }
        } else if (ae.getSource() == view_categoria.btnAnterior) {
            try {
                operacionPagina = Integer.parseInt(view_categoria.txtPagina.getText()) - 1;
                if (1 == operacionPagina && totalPaginas > 1) {
                    ActivaPaginacion(1);
                } else if (1 >= operacionPagina && totalPaginas > 1) {
                    ActivaPaginacion(2);
                }
                view_categoria.txtPagina.setText(String.valueOf(operacionPagina));
                listarCategorias();
            } catch (SQLException ex) {
                logger.error(ex);
            }
        } else if (ae.getSource() == view_categoria.btnFinAnterior) {
            try {
                pagina = 1;
                view_categoria.txtPagina.setText(String.valueOf(pagina));
                listarCategorias();
            } catch (SQLException ex) {
                logger.error(ex);
            }
        } else if (ae.getSource() == view_categoria.btnSiguiente) {
            try {
                operacionPagina = Integer.parseInt(view_categoria.txtPagina.getText()) + 1;
                if (totalPaginas == operacionPagina && totalPaginas > 1) {
                    ActivaPaginacion(1);
                } else if (totalPaginas >= operacionPagina && totalPaginas > 1) {
                    ActivaPaginacion(2);
                }
                view_categoria.txtPagina.setText(String.valueOf(operacionPagina));
                listarCategorias();
            } catch (SQLException ex) {
                logger.error(ex);
            }
        } else if (ae.getSource() == view_categoria.btnFinSiguiente) {
            try {
                pagina = totalPaginas;
                view_categoria.txtPagina.setText(String.valueOf(pagina));
                listarCategorias();
            } catch (SQLException ex) {
                logger.error(ex);
            }
        } else if (ae.getSource() == view_categoria.txtPagina) {
            try {
                paginaEspecifica = Integer.parseInt(view_categoria.txtPagina.getText());
                if (paginaEspecifica < 1) {
                    pagina = 1;
                } else if (paginaEspecifica > totalPaginas) {
                    pagina = totalPaginas;                    
                } else {
                    pagina = paginaEspecifica;
                }
                view_categoria.txtPagina.setText(String.valueOf(pagina));
                try {
                    listarCategorias();
                } catch (SQLException ex) {
                    logger.error(ex);
                }
            } catch (NumberFormatException ex) {
                Messages.messageError("Por favor solo escriba números, y de preferencia que se encuentren en el rango de páginas totales.");
                logger.warn(ex);
            }
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
