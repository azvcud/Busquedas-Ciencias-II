package pkg;

/**
 *
 * @author Shiro
 */
public class VentanaBusquedaEliminacion extends javax.swing.JFrame {
    TiendaProductos app = new TiendaProductos();
    
    public VentanaBusquedaEliminacion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBinaria = new javax.swing.JButton();
        btnSecuencial = new javax.swing.JButton();
        btnTransformacion = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        label1 = new java.awt.Label();
        btnAtras = new javax.swing.JButton();
        chkId = new javax.swing.JCheckBox();
        tfParametro = new javax.swing.JTextField();
        chkNombre = new javax.swing.JCheckBox();
        chkDescripcion = new javax.swing.JCheckBox();
        chkPrecio = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taProductoBuscado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelTiempoBusqueda = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Busqueda - Ciencias ll (Buscar o Eliminar Productos)");

        btnBinaria.setText("Busqueda Binaria");
        btnBinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinariaActionPerformed(evt);
            }
        });

        btnSecuencial.setText("Busqueda Secuencial");
        btnSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuencialActionPerformed(evt);
            }
        });

        btnTransformacion.setText("Busqueda Transformación de claves");
        btnTransformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransformacionActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("Busqueda y Eliminación");

        btnAtras.setText("<-");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        chkId.setText("id");
        chkId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIdActionPerformed(evt);
            }
        });

        chkNombre.setText("Nombre");

        chkDescripcion.setText("Descripcion");
        chkDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDescripcionActionPerformed(evt);
            }
        });

        chkPrecio.setText("Precio");

        taProductoBuscado.setColumns(20);
        taProductoBuscado.setRows(5);
        jScrollPane1.setViewportView(taProductoBuscado);

        jLabel1.setText("Producto buscado:");

        jLabel2.setText("Tiempo:");

        labelTiempoBusqueda.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        labelTiempoBusqueda.setText("-");

        jLabel3.setText("Inserte el parametro de busqueda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(labelTiempoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chkNombre)
                                .addComponent(chkDescripcion)
                                .addComponent(chkPrecio)
                                .addComponent(chkId))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBinaria)
                                .addComponent(btnSecuencial)
                                .addComponent(btnTransformacion)
                                .addComponent(btnEliminar)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkPrecio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBinaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSecuencial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTransformacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelTiempoBusqueda))
                .addGap(30, 30, 30))
        );

        getAccessibleContext().setAccessibleName("Ventana");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransformacionActionPerformed
        Busqueda claves = new BusquedaTransformacionClaves();
        int opcion = 0;
        if(chkId.isSelected()){opcion = 1;
        }else if(chkNombre.isSelected()){ opcion = 2;
        }else if(chkPrecio.isSelected()){ opcion = 4;
        }
        Ordenamiento tablaHash = new TablaHash();
        app.setEstrategiaOrdenamiento(tablaHash);
        app.ordenarProductos(opcion);
        app.setEstrategiaBusqueda(claves);
        //taProductoBuscado.setText(app.buscarProductos(opcion, tfParametro.getText()));
        tfParametro.setText("");
    }//GEN-LAST:event_btnTransformacionActionPerformed

    private void chkIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkIdActionPerformed

    private void chkDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkDescripcionActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.app = this.app;
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnBinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinariaActionPerformed
        Busqueda binaria = new BusquedaBinaria();
        int opcion = 0;
        if(chkId.isSelected()){opcion = 1;
        }else if(chkNombre.isSelected()){ opcion = 2;
        }else if(chkPrecio.isSelected()){ opcion = 4;
        }
        Ordenamiento burstSort = new BurstSort();
        app.setEstrategiaOrdenamiento(burstSort);
        app.ordenarProductos(opcion);
        app.setEstrategiaBusqueda(binaria);
        //taProductoBuscado.setText(app.buscarProductos(opcion, tfParametro.getText()));
        tfParametro.setText("");
    }//GEN-LAST:event_btnBinariaActionPerformed

    private void btnSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuencialActionPerformed
        Busqueda secuencial = new BusquedaSecuencial();
        int opcion = 0;
        if(chkId.isSelected()){opcion = 1;
        }else if(chkNombre.isSelected()){ opcion = 2;
        }else if(chkDescripcion.isSelected()){ opcion = 3;
        }else if(chkPrecio.isSelected()){ opcion = 4;
        }
        Ordenamiento burstSort = new BurstSort();
        app.setEstrategiaOrdenamiento(burstSort);
        app.ordenarProductos(opcion);
        app.setEstrategiaBusqueda(secuencial);
        //taProductoBuscado.setText(app.buscarProductos(opcion, tfParametro.getText()));
        tfParametro.setText("");
    }//GEN-LAST:event_btnSecuencialActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Busqueda binaria = new BusquedaBinaria();
        Ordenamiento burstSort = new BurstSort();
        app.setEstrategiaBusqueda(binaria);
        app.setEstrategiaOrdenamiento(burstSort);
        int opcion = 0;
        if(chkId.isSelected()){opcion = 1;
        }else if(chkNombre.isSelected()){ opcion = 2;
        }else if(chkDescripcion.isSelected()){ opcion = 3;
        }else if(chkPrecio.isSelected()){ opcion = 4;
        }
        app.eliminarProductos(opcion, tfParametro.getText());
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBusquedaEliminacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBusquedaEliminacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBusquedaEliminacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBusquedaEliminacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBusquedaEliminacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBinaria;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSecuencial;
    private javax.swing.JButton btnTransformacion;
    private javax.swing.JCheckBox chkDescripcion;
    private javax.swing.JCheckBox chkId;
    private javax.swing.JCheckBox chkNombre;
    private javax.swing.JCheckBox chkPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel labelTiempoBusqueda;
    private javax.swing.JTextArea taProductoBuscado;
    private javax.swing.JTextField tfParametro;
    // End of variables declaration//GEN-END:variables
}
