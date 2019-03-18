package com.admin.view.units;

public class Vehiculos extends javax.swing.JDialog {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Vehiculos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnObservaciones = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblGalonaje = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        scrollVehiculos = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnActivar = new javax.swing.JButton();
        btnQuitarSeleccion = new javax.swing.JButton();
        txtPlaca = new Folder.DJCTextFieldWithoutPop();
        lblTituloActivos = new javax.swing.JLabel();
        txtMarca = new Folder.DJCTextFieldWithoutPop();
        lblAviso = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtKilometraje = new Folder.DJCTextFieldWithoutPop();
        lblKilometraje = new javax.swing.JLabel();
        txtGalonaje = new Folder.DJCTextFieldWithoutPop();
        lblPlaca = new javax.swing.JLabel();
        lblCertificado = new javax.swing.JLabel();
        txtCertificado = new Folder.DJCTextFieldWithoutPop();
        btnDesactivar = new javax.swing.JButton();
        lblFiltros = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblActivos = new javax.swing.JLabel();
        lblInactivos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Botón para cerrar ventana de vehículos.");

        btnObservaciones.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnObservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/List.png"))); // NOI18N
        btnObservaciones.setText("Observaciones");
        btnObservaciones.setToolTipText("Botón para visualizar observaciones del vehículo seleccionado.");
        btnObservaciones.setEnabled(false);

        btnAgregar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Create.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Botón para agregar un nuevo vehículo.");

        lblGalonaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblGalonaje.setText("Galonaje:");

        btnModificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/Modify.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Botón para modificar el vehículo seleccionado.");
        btnModificar.setEnabled(false);

        tblVehiculos.setAutoCreateRowSorter(true);
        tblVehiculos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVehiculos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblVehiculos.getTableHeader().setReorderingAllowed(false);
        scrollVehiculos.setViewportView(tblVehiculos);

        btnActivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/next.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.setToolTipText("Botón para eliminar el vehículo seleccionado.");
        btnActivar.setEnabled(false);

        btnQuitarSeleccion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnQuitarSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/information.png"))); // NOI18N
        btnQuitarSeleccion.setText("Quitar Selección");
        btnQuitarSeleccion.setToolTipText("Botón para quitar la selección del vehículo seleccionado.");
        btnQuitarSeleccion.setEnabled(false);

        txtPlaca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblTituloActivos.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        lblTituloActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloActivos.setText("VEHICULO DE CARGA PESADA");

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblAviso.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblAviso.setText("(*) Datos obligatorios.");

        lblMarca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblMarca.setText("(*) Marca:");

        txtKilometraje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblKilometraje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblKilometraje.setText("Kilometraje:");

        txtGalonaje.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        lblPlaca.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblPlaca.setText("(*) Placa:");

        lblCertificado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblCertificado.setText("(*) Certificado de Inscripción:  ");

        txtCertificado.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        btnDesactivar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/admin/resource/images/No-entry.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setToolTipText("Botón para eliminar el vehículo seleccionado.");
        btnDesactivar.setEnabled(false);

        lblFiltros.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblFiltros.setText("Filtrar listado: ");

        lblTodos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTodos.setText("Todos");

        lblActivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActivos.setText("Activos");

        lblInactivos.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblInactivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInactivos.setText("Inactivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollVehiculos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarSeleccion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblKilometraje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblGalonaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGalonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCertificado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCertificado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMarca)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(lblFiltros)
                        .addGap(48, 48, 48)
                        .addComponent(lblTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(lblInactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblTituloActivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblAviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloActivos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKilometraje)
                    .addComponent(txtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGalonaje)
                    .addComponent(txtGalonaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCertificado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivar)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitarSeleccion)
                    .addComponent(btnObservaciones)
                    .addComponent(btnDesactivar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(lblFiltros)
                    .addComponent(lblTodos)
                    .addComponent(lblActivos)
                    .addComponent(lblInactivos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnDesactivar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnObservaciones;
    public javax.swing.JButton btnQuitarSeleccion;
    public javax.swing.JLabel lblActivos;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCertificado;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblGalonaje;
    public javax.swing.JLabel lblInactivos;
    private javax.swing.JLabel lblKilometraje;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTituloActivos;
    public javax.swing.JLabel lblTodos;
    private javax.swing.JScrollPane scrollVehiculos;
    public javax.swing.JTable tblVehiculos;
    public Folder.DJCTextFieldWithoutPop txtCertificado;
    public Folder.DJCTextFieldWithoutPop txtGalonaje;
    public Folder.DJCTextFieldWithoutPop txtKilometraje;
    public Folder.DJCTextFieldWithoutPop txtMarca;
    public Folder.DJCTextFieldWithoutPop txtPlaca;
    // End of variables declaration//GEN-END:variables
}
