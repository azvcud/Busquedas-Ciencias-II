/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

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
        
        this.vista.ventanaFormulario.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.vista.ventanaGestion.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        setEstadoItem(this.vista.ventanaInicio.selectorColumna.getSelectedIndex());
        
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
            if(getEstadoItem() == -1) {
                vista.mensajeError("No se ha seleccionado ordenamiento");
            } else {
                modelo.cambiarEstrategiaOrdenamiento(1, getEstadoItem());
                cargarProductos();
            }
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnOrdenamientoHash) {
            if(getEstadoItem() == -1) {
                vista.mensajeError("No se ha seleccionado ordenamiento");
            } else if(getEstadoItem() == 3) {
                vista.mensajeError("No existe soporte de Hashing para la columna seleccionada.");
            } else {
                modelo.cambiarEstrategiaOrdenamiento(2, getEstadoItem());
                cargarProductos();
            }
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnInsertar) {
            this.vista.ventanaFormulario.setVisible(true);
        }
        
        if(e.getSource() == this.vista.ventanaInicio.btnBuscarEliminar) {
            this.vista.ventanaGestion.setVisible(true);
        }
        
        if(e.getSource() == this.vista.ventanaFormulario.btnInsertar) {            
            try {
                int precio = Integer.parseInt(this.vista.ventanaFormulario.campoPrecio.getText());
                String nombre = this.vista.ventanaFormulario.campoNombre.getText();
                String descripcion = this.vista.ventanaFormulario.campoDescripcion.getText();
                
                if(nombre.isBlank() || descripcion.isBlank()) { vista.mensajeError("Algún campo está vacío."); }
                else{ 
                    modelo.insertarProducto(nombre, descripcion, precio); 
                    
                    this.vista.ventanaFormulario.setVisible(false);
            
                    this.vista.ventanaFormulario.campoDescripcion.setText("");
                    this.vista.ventanaFormulario.campoNombre.setText("");
                    this.vista.ventanaFormulario.campoPrecio.setText("");
                    cargarProductos();
                }
            } catch (NumberFormatException nfe) {
                vista.mensajeError("El precio ingresado es inválido.");
            }
        }
        
        
    }

    public int getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(int estadoItem) {
        this.estadoItem = estadoItem;
    }
}
