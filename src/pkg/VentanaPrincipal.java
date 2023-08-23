/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg;

/**
 *
 * @author Shiro
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    TiendaProductos app = new TiendaProductos();
    
    public VentanaPrincipal() {
        initComponents();    
        Producto producto1 = new Producto("Zumo de Naranja", "Esta vaina es de los dioses.", 4500);
        Producto producto2 = new Producto("Papas BBQ", "El picor es excelente.", 1800);
        Producto producto3 = new Producto("Kilo de carne", "Para invadir Ucrania con todas las de la ley.", 10000);
        Producto producto4 = new Producto("Pluma", "Excelente para escribir.", 24500);
        Producto producto5 = new Producto("Cuaderno 7 materias", "Necesario para el estudio.", 24500);
        Producto producto6 = new Producto("Celular", "Con 4G incluido", 1450000);
        
        app.insertarProducto(producto1);
        app.insertarProducto(producto2);
        app.insertarProducto(producto3);
        app.insertarProducto(producto4);
        app.insertarProducto(producto5);
        app.insertarProducto(producto6);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaLista = new javax.swing.JTextArea();
        btnBuscarEliminar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnOrdenamientoBurst = new javax.swing.JButton();
        btnOrdenamientoHash = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Busqueda - Ciencias ll");
        setResizable(false);

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("Algoritmos de Busqueda");

        areaLista.setColumns(20);
        areaLista.setRows(5);
        jScrollPane1.setViewportView(areaLista);

        btnBuscarEliminar.setText("Buscar/Eliminar");
        btnBuscarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEliminarActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnOrdenamientoBurst.setText("Ordenamiento BurstSort");
        btnOrdenamientoBurst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenamientoBurstActionPerformed(evt);
            }
        });

        btnOrdenamientoHash.setText("Ordenamiento TablaHash");
        btnOrdenamientoHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenamientoHashActionPerformed(evt);
            }
        });

        jLabel1.setText("Ordenar:");

        jLabel2.setText("Modificar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOrdenamientoBurst)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnBuscarEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnOrdenamientoHash))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrdenamientoBurst)
                    .addComponent(btnOrdenamientoHash)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscarEliminar)
                    .addComponent(btnInsertar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEliminarActionPerformed
        // TODO add your handling code here:
        VentanaBusquedaEliminacion v1 = new VentanaBusquedaEliminacion();
        v1.app = this.app;
        v1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBuscarEliminarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        VentanaInsertar v1 = new VentanaInsertar();
        v1.app = this.app;
        v1.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnOrdenamientoBurstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenamientoBurstActionPerformed
        Ordenamiento burstSort = new BurstSort();
        app.setEstrategiaOrdenamiento(burstSort);
        app.ordenarProductos(4);
        areaLista.setText(app.toString());
    }//GEN-LAST:event_btnOrdenamientoBurstActionPerformed

    private void btnOrdenamientoHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenamientoHashActionPerformed
        Ordenamiento hash = new TablaHash();
        app.setEstrategiaOrdenamiento(hash);
        app.ordenarProductos(4);
        areaLista.setText(app.toString());
    }//GEN-LAST:event_btnOrdenamientoHashActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaLista;
    private javax.swing.JButton btnBuscarEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnOrdenamientoBurst;
    private javax.swing.JButton btnOrdenamientoHash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
