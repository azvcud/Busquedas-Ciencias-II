/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amirz
 */
public class Control implements ActionListener {

    private Vista vista;
    private Modelo modelo;
    
    private static final String[] nombresColumnas = {"ID", "Nombre", "Descripción", "Precio"};
    
    private ObservadorControl ventanaPrincipal;
    private ObservadorControl ventanaBusquedaEliminacion;

    public Control(Vista vista, Modelo modelo) {
        ventanaPrincipal = new LogicaVentanaPrincipal();
        ventanaBusquedaEliminacion = new LogicaVentanaBusquedaEliminacion();
        
        this.vista = vista;
        this.modelo = modelo;

        this.vista.ventanaInicio.btnBuscarEliminar.addActionListener(this);
        this.vista.ventanaInicio.btnInsertar.addActionListener(this);
        this.vista.ventanaInicio.btnOrdenamientoBurst.addActionListener(this);
        this.vista.ventanaInicio.btnOrdenamientoHash.addActionListener(this);
        this.vista.ventanaInicio.selectorColumna.addActionListener(this);
        this.vista.ventanaFormulario.btnInsertar.addActionListener(this);
        this.vista.ventanaGestion.btnBuscar.addActionListener(this);
        this.vista.ventanaGestion.btnEliminar.addActionListener(this);
        this.vista.ventanaGestion.cbBusqueda.addActionListener(this);
        this.vista.ventanaGestion.cbColumna.addActionListener(this);
    }
    
    public void iniciar() {
        this.vista.ventanaFormulario.setVisible(false);
        this.vista.ventanaGestion.setVisible(false);
        this.vista.ventanaInicio.setLocationRelativeTo(null);
        
        this.vista.ventanaFormulario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.vista.ventanaGestion.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(modelo.enviarListaProductos()));
        this.vista.ventanaInicio.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.ventanaInicio.selectorColumna) { selectorColumna(); }
        if(e.getSource() == this.vista.ventanaInicio.btnOrdenamientoBurst) { btnOrdenamientoBurst(); }
        if(e.getSource() == this.vista.ventanaInicio.btnOrdenamientoHash) { btnOrdenamientoHash(); }
        if(e.getSource() == this.vista.ventanaInicio.btnInsertar) { this.vista.ventanaFormulario.setVisible(true); }
        if(e.getSource() == this.vista.ventanaInicio.btnBuscarEliminar) { this.vista.ventanaGestion.setVisible(true); }
        
        if(e.getSource() == this.vista.ventanaGestion.cbBusqueda) { cbBusqueda(); }
        if(e.getSource() == this.vista.ventanaGestion.cbColumna) { cbColumna(); }
        if(e.getSource() == this.vista.ventanaGestion.btnBuscar) { btnBuscar(); }
        if(e.getSource() == this.vista.ventanaGestion.btnEliminar) { btnEliminar(); }
        
        if(e.getSource() == this.vista.ventanaFormulario.btnInsertar) { btnInsertar(); }
    }

    private DefaultTableModel cargarTablaBusqueda(ArrayList<Producto> listaProductos) {
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        
        for(Producto producto: listaProductos) {
                    modeloTabla.addRow(new Object[]{
                        producto.getId(), 
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio()
                    });
        }
        
        return modeloTabla;
    }
    
    private void selectorColumna() {
        String columnaSeleccionada = (String) this.vista.ventanaInicio.selectorColumna.getSelectedItem();
        String selector = "Selector";
            
        ventanaPrincipal.notificar(selector, columnaSeleccionada);
    }
    
    
    private void cbBusqueda() {
        String itemSeleccionado = (String) this.vista.ventanaGestion.cbBusqueda.getSelectedItem();
        String busqueda = "Busqueda";
            
        ventanaBusquedaEliminacion.notificar(busqueda, itemSeleccionado);
        modelo.cambiarEstrategiaBusqueda(ventanaBusquedaEliminacion.obtenerEstado(busqueda));
    }
    
    
    private void cbColumna() {
        String columnaSeleccionada = (String) this.vista.ventanaGestion.cbColumna.getSelectedItem();
        String columna = "Columna";
            
        ventanaBusquedaEliminacion.notificar(columna, columnaSeleccionada);
    }
    
    
    private void btnOrdenamientoBurst() {
        if(ventanaPrincipal.obtenerEstado("Selector") == -1) {
            vista.mensajeError("No se ha seleccionado ordenamiento");
        } else {
            modelo.cambiarEstrategiaOrdenamiento(1, ventanaPrincipal.obtenerEstado("Selector"));
            this.vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                    modelo.enviarListaProductos()));
        }
    }
    
    
    private void btnOrdenamientoHash() {
        switch (ventanaPrincipal.obtenerEstado("Selector")) {
            case -1 -> vista.mensajeError("No se ha seleccionado ordenamiento");
            case 3 -> vista.mensajeError("No existe soporte de Hashing para la columna seleccionada.");
            default -> {
                modelo.cambiarEstrategiaOrdenamiento(2, ventanaPrincipal.obtenerEstado("Selector"));
                this.vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                        modelo.enviarListaProductos()));
            }
        }
    }
    
    
    private void btnInsertar() {
        try {
            int precio = Integer.parseInt(this.vista.ventanaFormulario.campoPrecio.getText());
            String nombre = this.vista.ventanaFormulario.campoNombre.getText();
            String descripcion = this.vista.ventanaFormulario.campoDescripcion.getText();
                
            if(nombre.isBlank() || descripcion.isBlank()) { vista.mensajeError("Algún campo está vacío."); }
            else { 
                modelo.insertarProducto(nombre, descripcion, precio); 
         
                this.vista.ventanaFormulario.dispose();
            
                this.vista.ventanaFormulario.campoDescripcion.setText("");
                this.vista.ventanaFormulario.campoNombre.setText("");
                this.vista.ventanaFormulario.campoPrecio.setText("");
                this.vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                    modelo.enviarListaProductos()));
            }
        } catch (NumberFormatException nfe) {
            vista.mensajeError("El precio ingresado es inválido.");
        }
    }
    
    
    private void btnBuscar() {
        if(
            ventanaBusquedaEliminacion.obtenerEstado("Busqueda") == -1 || 
            ventanaBusquedaEliminacion.obtenerEstado("Columna") == -1
        ) 
        { vista.mensajeError("No se ha seleccionado búsqueda o columna"); }
            
        else if(this.vista.ventanaGestion.tfValor.getText().isBlank()) {
            vista.mensajeError("No se ha digitado valor a buscar");
        }
        else {
            this.vista.ventanaGestion.tablaBusqueda.setModel(cargarTablaBusqueda(
                    modelo.buscarProductos(
                            ventanaBusquedaEliminacion.obtenerEstado("Columna"), 
                            this.vista.ventanaGestion.tfValor.getText())
            ));
        }
    }
    
    
    private void btnEliminar() {
        int[] filaSeleccionada = this.vista.ventanaGestion.tablaBusqueda.getSelectedRows();
        
        String claveSeleccionada;
        DefaultTableModel auxiliar;
        
        if(filaSeleccionada.length == 1) {
            claveSeleccionada = Integer.toString((int) this.vista.ventanaGestion.tablaBusqueda.getValueAt(filaSeleccionada[0], 0));
            
            modelo.eliminarProducto(claveSeleccionada);
            auxiliar = (DefaultTableModel) this.vista.ventanaGestion.tablaBusqueda.getModel();
            auxiliar.removeRow(0);
        }
        else {
            modelo.eliminarProductos(
                    ventanaBusquedaEliminacion.obtenerEstado("Columna"), 
                    (String) this.vista.ventanaGestion.tfValor.getText()
            );
            
            auxiliar = (DefaultTableModel) this.vista.ventanaGestion.tablaBusqueda.getModel();
            for(int i = 0; i < filaSeleccionada.length; i++) {
                auxiliar.removeRow(0);
            }
        }
        
        this.vista.ventanaGestion.tablaBusqueda.setModel(auxiliar);
        this.vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                        modelo.enviarListaProductos()
            ));
    }
}
