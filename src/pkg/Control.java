/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author amirz
 */
public class Control implements ActionListener {

    private Vista vista;
    private Modelo modelo;
    private int estadoItem;

    public Control(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.ventanaInicio.btnBuscarEliminar.addActionListener(this);
        this.vista.ventanaInicio.btnInsertar.addActionListener(this);
        this.vista.ventanaInicio.btnOrdenamientoBurst.addActionListener(this);
        this.vista.ventanaInicio.btnOrdenamientoHash.addActionListener(this);
        this.vista.ventanaFormulario.btnInsertar.addActionListener(this);
        this.vista.ventanaGestion.btnBuscar.addActionListener(this);
        this.vista.ventanaGestion.btnEliminar.addActionListener(this);
        this.vista.ventanaInicio.selectorColumna.addActionListener(this);
    }
    
    public void iniciar() {
        this.vista.ventanaFormulario.setVisible(false);
        this.vista.ventanaGestion.setVisible(false);
        this.vista.ventanaInicio.setLocationRelativeTo(null);
        
        cargarProductos();
        this.vista.ventanaInicio.setVisible(true);
    }
    
    public void cargarProductos() {
        String[] nombresColumnas = {"ID", "Nombre", "Descripción", "Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        
        for(Producto producto: modelo.enviarListaProductos()) {
            modeloTabla.addRow(new Object[]{
                producto.getId(), 
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio()
            });
        }
        
        this.vista.ventanaInicio.tablaProductos.setModel(modeloTabla);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.ventanaInicio.selectorColumna) {
            switch((String)this.vista.ventanaInicio.selectorColumna.getSelectedItem()) {
                case "ID" -> setEstadoItem(1);
                case "Nombre" -> setEstadoItem(2);
                case "Descripción" -> setEstadoItem(3);
                case "Precio" -> setEstadoItem(4);
                default -> setEstadoItem(0);
            }
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnOrdenamientoBurst) {
            modelo.cambiarEstrategiaOrdenamiento(1, getEstadoItem());
            cargarProductos();
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnOrdenamientoHash) {
            modelo.cambiarEstrategiaOrdenamiento(2, getEstadoItem());
            cargarProductos();
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnInsertar) {
            this.vista.ventanaInicio.setVisible(false);
            this.vista.ventanaFormulario.setVisible(true);
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnBuscarEliminar) {
            this.vista.ventanaInicio.setVisible(false);
            this.vista.ventanaGestion.setVisible(true);
        }
        
        if(e.getSource() == this.vista.ventanaFormulario.btnInsertar) {
            String nombre = this.vista.ventanaFormulario.campoNombre.getText();
            String descripcion = this.vista.ventanaFormulario.campoDescripcion.getText();
            int precio = Integer.parseInt(this.vista.ventanaFormulario.campoPrecio.getText());
            
            modelo.insertarProducto(nombre, descripcion, precio);
            
            this.vista.ventanaFormulario.setVisible(false);
            this.vista.ventanaInicio.setVisible(true);
            cargarProductos();
        }
        
        
    }

    public int getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(int estadoItem) {
        this.estadoItem = estadoItem;
    }
}
