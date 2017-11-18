package com.admin.view.units;

import com.admin.resource.utils.RoundedBorder;

/** * @author DANNY VASQUEZ RAFAEL */

public class Categorias extends javax.swing.JDialog {

    public Categorias(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.txtNombre.setBorder(new RoundedBorder(4));
        this.txtDescripcion.setBorder(new RoundedBorder(4));
        this.btnAgregar.setBorder(new RoundedBorder(4));
        this.btnModificar.setBorder(new RoundedBorder(4));
        this.btnEliminar.setBorder(new RoundedBorder(4));
        this.btnCancelarSeleccion.setBorder(new RoundedBorder(4));
        this.btnCancelar.setBorder(new RoundedBorder(4));
        this.boxRegistroXPagina.setBorder(new RoundedBorder(2));
        this.btnFinAnterior.setBorder(new RoundedBorder(3));
        this.btnAnterior.setBorder(new RoundedBorder(3));
        this.btnFinSiguiente.setBorder(new RoundedBorder(3));
        this.btnSiguiente.setBorder(new RoundedBorder(3));
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        scrollCategoria = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnCancelarSeleccion = new javax.swing.JButton();
        txtNombre = new Folder.DJCTextFieldWithoutPop();
        txtDescripcion = new Folder.DJCTextFieldWithoutPop();
        lblNombre = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblPagina = new javax.swing.JLabel();
        lblRegistroXPagina = new javax.swing.JLabel();
        txtPagina = new javax.swing.JTextField();
        btnAnterior = new javax.swing.JButton();
        btnFinAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnFinSiguiente = new javax.swing.JButton();
        boxRegistroXPagina = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de categorías.");

        lblTitulo.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTitulo.setText("CATEGORIAS");

        lblDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar una categoría seleccionada.");
        btnModificar.setEnabled(false);

        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Botón para eliminar una categoría seleccionada.");
        btnEliminar.setEnabled(false);

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar una nueva categoría.");

        tblCategoria.setAutoCreateRowSorter(true);
        tblCategoria.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCategoria.getTableHeader().setReorderingAllowed(false);
        scrollCategoria.setViewportView(tblCategoria);

        btnCancelarSeleccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnCancelarSeleccion.setText("Quitar Selección");
        btnCancelarSeleccion.setToolTipText("Botón para quitar la selección de una categoría seleccionada.");
        btnCancelarSeleccion.setEnabled(false);

        txtNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNombre.setPlaceholder("Escribir aquí el nombre de la categoría.");

        txtDescripcion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtDescripcion.setPlaceholder("Escribir aquí la descripción de la categoría.");

        lblNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblNombre.setText("(*) Nombre:");

        lblTotalRegistros.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTotalRegistros.setText("X registros.");

        lblPagina.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPagina.setText("Página 1 de 6");

        lblRegistroXPagina.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblRegistroXPagina.setText("Registros por página:");

        txtPagina.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        txtPagina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPagina.setText("1");

        btnAnterior.setText("< Anterior");

        btnFinAnterior.setText("<< Inicio");

        btnSiguiente.setText("Siguiente >");

        btnFinSiguiente.setText("Fin >>");

        boxRegistroXPagina.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        boxRegistroXPagina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "25", "50", "75" }));
        boxRegistroXPagina.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAviso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(43, 43, 43)
                                .addComponent(btnFinAnterior)
                                .addGap(6, 6, 6)
                                .addComponent(btnAnterior)
                                .addGap(6, 6, 6)
                                .addComponent(txtPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnSiguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFinSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPagina)
                        .addGap(54, 54, 54)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblRegistroXPagina)
                        .addGap(4, 4, 4)
                        .addComponent(boxRegistroXPagina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNombre)
                        .addGap(10, 10, 10)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblDescripcion)
                        .addGap(10, 10, 10)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCancelarSeleccion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(scrollCategoria)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblRegistroXPagina))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(boxRegistroXPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPagina))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblNombre))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblDescripcion))
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelarSeleccion))
                .addGap(11, 11, 11)
                .addComponent(scrollCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalRegistros)
                    .addComponent(btnFinAnterior)
                    .addComponent(btnAnterior)
                    .addComponent(txtPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSiguiente)
                        .addComponent(btnFinSiguiente)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAviso)
                    .addComponent(btnCancelar))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> boxRegistroXPagina;
    public static javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAnterior;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCancelarSeleccion;
    public static javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnFinAnterior;
    public javax.swing.JButton btnFinSiguiente;
    public static javax.swing.JButton btnModificar;
    public javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblPagina;
    private javax.swing.JLabel lblRegistroXPagina;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JScrollPane scrollCategoria;
    public javax.swing.JTable tblCategoria;
    public static Folder.DJCTextFieldWithoutPop txtDescripcion;
    public Folder.DJCTextFieldWithoutPop txtNombre;
    public javax.swing.JTextField txtPagina;
    // End of variables declaration//GEN-END:variables
}
