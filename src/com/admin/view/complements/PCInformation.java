package com.admin.view.complements;

import com.admin.resource.utils.Global;

/** * @author DANNY VASQUEZ RAFAEL */

public class PCInformation extends javax.swing.JDialog {

    public PCInformation(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setResizable(false);
        setIconImage(Global.ICON_IMAGE);
        setCursor(Global.CURSOR);
        this.setTitle("Información de Arquitectura");

        lblQueComputadora.setText(System.getenv("COMPUTERNAME"));
        lblQueUsuario.setText(System.getProperty("user.name"));
        textProcesador.setText(System.getenv("PROCESSOR_IDENTIFIER"));
        lblQueSO.setText(System.getProperty("os.name"));
        lblQueJava.setText(System.getProperty("java.version"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInformacion = new javax.swing.JPanel();
        lblComputadora = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblProcesador = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        lblJava = new javax.swing.JLabel();
        lblQueComputadora = new javax.swing.JLabel();
        lblQueUsuario = new javax.swing.JLabel();
        lblQueSO = new javax.swing.JLabel();
        lblQueJava = new javax.swing.JLabel();
        scrollProcesador = new javax.swing.JScrollPane();
        textProcesador = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del Sistema");

        panelInformacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblComputadora.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblComputadora.setText("Computadora :");

        lblUsuario.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblUsuario.setText("Usuario :");

        lblProcesador.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblProcesador.setText("Procesador :");

        lblSO.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblSO.setText("S.O. :");

        lblJava.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblJava.setText("Versión de Java :");

        lblQueComputadora.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblQueComputadora.setText("jLabel6");

        lblQueUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblQueUsuario.setText("jLabel7");

        lblQueSO.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblQueSO.setText("jLabel9");

        lblQueJava.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblQueJava.setText("jLabel10");

        textProcesador.setEditable(false);
        textProcesador.setColumns(20);
        textProcesador.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        textProcesador.setRows(5);
        scrollProcesador.setViewportView(textProcesador);

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComputadora)
                    .addComponent(lblUsuario)
                    .addComponent(lblProcesador)
                    .addComponent(lblSO)
                    .addComponent(lblJava))
                .addGap(18, 18, 18)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblQueComputadora, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(lblQueUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollProcesador)
                    .addComponent(lblQueSO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQueJava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComputadora)
                    .addComponent(lblQueComputadora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblQueUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(scrollProcesador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblProcesador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(lblSO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJava))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(lblQueSO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQueJava)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PCInformation dialog = new PCInformation(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblComputadora;
    private javax.swing.JLabel lblJava;
    private javax.swing.JLabel lblProcesador;
    private javax.swing.JLabel lblQueComputadora;
    private javax.swing.JLabel lblQueJava;
    private javax.swing.JLabel lblQueSO;
    private javax.swing.JLabel lblQueUsuario;
    private javax.swing.JLabel lblSO;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JScrollPane scrollProcesador;
    private javax.swing.JTextArea textProcesador;
    // End of variables declaration//GEN-END:variables
}
