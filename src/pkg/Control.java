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
    
    private ObservadorControl estadoInicio;
    private ObservadorControl estadoBusquedaEliminacion;

    public Control(Vista vista, Modelo modelo) {
        estadoInicio = new EstadoVentanaPrincipal();
        estadoBusquedaEliminacion = new EstadoVentanaBusquedaEliminacion();
        
        this.vista = vista;
        this.modelo = modelo;

        this.vista.ventanaInicio.btnBuscarEliminar.addActionListener(this);
        this.vista.ventanaInicio.btnInsertar.addActionListener(this);
        this.vista.ventanaInicio.btnOrdenamientoBurst.addActionListener(this);
        this.vista.ventanaInicio.btnOrdenamientoHash.addActionListener(this);
        this.vista.ventanaInicio.cbColumnaOrdenar.addActionListener(this);
        
        this.vista.ventanaInsertar.btnInsertar.addActionListener(this);
        
        this.vista.ventanaBusquedaEliminacion.btnBuscar.addActionListener(this);
        this.vista.ventanaBusquedaEliminacion.btnEliminar.addActionListener(this);
        this.vista.ventanaBusquedaEliminacion.cbBusqueda.addActionListener(this);
        this.vista.ventanaBusquedaEliminacion.cbColumnaBuscar.addActionListener(this);
    }
    
    public void iniciar() {
        vista.ventanaInicio.setLocationRelativeTo(null);
        
        vista.ventanaInsertar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vista.ventanaBusquedaEliminacion.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(modelo.enviarListaProductos()));
        vista.ventanaInicio.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.ventanaInicio.cbColumnaOrdenar) { cbColumnaOrdenar(); }
        if(e.getSource() == vista.ventanaInicio.btnOrdenamientoBurst) { btnOrdenamientoBurst(); }
        if(e.getSource() == vista.ventanaInicio.btnOrdenamientoHash) { btnOrdenamientoHash(); }
        if(e.getSource() == vista.ventanaInicio.btnInsertar) { vista.ventanaInsertar.setVisible(true); }
        if(e.getSource() == vista.ventanaInicio.btnBuscarEliminar) { vista.ventanaBusquedaEliminacion.setVisible(true); }
        
        if(e.getSource() == vista.ventanaBusquedaEliminacion.cbBusqueda) { cbBusqueda(); }
        if(e.getSource() == vista.ventanaBusquedaEliminacion.cbColumnaBuscar) { cbColumnaBuscar(); }
        if(e.getSource() == vista.ventanaBusquedaEliminacion.btnBuscar) { btnBuscar(); }
        if(e.getSource() == vista.ventanaBusquedaEliminacion.btnEliminar) { btnEliminar(); }
        
        if(e.getSource() == vista.ventanaInsertar.btnInsertar) { btnInsertar(); }
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
    
    private void cbColumnaOrdenar() {
        String columnaSeleccionada = (String) vista.ventanaInicio.cbColumnaOrdenar.getSelectedItem();      
        estadoInicio.notificarCambio("Columna", columnaSeleccionada);
    }
    
    
    private void cbBusqueda() {
        String itemSeleccionado = (String) vista.ventanaBusquedaEliminacion.cbBusqueda.getSelectedItem();
        
        estadoBusquedaEliminacion.notificarCambio("Busqueda", itemSeleccionado);
        modelo.cambiarEstrategiaBusqueda(estadoBusquedaEliminacion.obtenerEstado("Busqueda"));
    }
    
    
    private void cbColumnaBuscar() {
        String columnaSeleccionada = (String) vista.ventanaBusquedaEliminacion.cbColumnaBuscar.getSelectedItem();
        estadoBusquedaEliminacion.notificarCambio("Columna", columnaSeleccionada);
    }
    
    
    private void btnOrdenamientoBurst() {
        if(estadoInicio.obtenerEstado("Columna") == -1) {
            vista.mensajeError("No se ha seleccionado ordenamiento");
        } else {
            modelo.cambiarEstrategiaOrdenamiento(1, estadoInicio.obtenerEstado("Columna"));
            estadoInicio.notificarCambio("Ordenamiento", "BurstSort");
            
            vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                modelo.enviarListaProductos()
            ));
        }
    }
    
    
    private void btnOrdenamientoHash() {
        switch (estadoInicio.obtenerEstado("Columna")) {
            case -1 -> vista.mensajeError("No se ha seleccionado ordenamiento");
            case 3 -> vista.mensajeError("No existe soporte de Hashing para la columna seleccionada.");
            default -> {
                modelo.cambiarEstrategiaOrdenamiento(2, estadoInicio.obtenerEstado("Columna"));
                estadoInicio.notificarCambio("Ordenamiento", "Tabla Hash");
                
                vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                    modelo.enviarListaProductos()
                ));
            }
        }
    }
    
    
    private void btnInsertar() {
        try {
            int precio = Integer.parseInt(vista.ventanaInsertar.campoPrecio.getText());
            String nombre = vista.ventanaInsertar.campoNombre.getText();
            String descripcion = vista.ventanaInsertar.campoDescripcion.getText();
            
            boolean camposVacios = nombre.isBlank() || descripcion.isBlank();
                
            if(camposVacios) { vista.mensajeError("Algún campo está vacío."); }
            else 
            { 
                modelo.insertarProducto(nombre, descripcion, precio);          
                vista.ventanaInsertar.dispose();
                limpiarVentanaInsertar();
            
                vista.ventanaInicio.tablaProductos.setModel(cargarTablaBusqueda(
                    modelo.enviarListaProductos()));
            }
        } catch (NumberFormatException nfe) {
            vista.mensajeError("El precio ingresado es inválido.");
        }
    }
    
    
    private void btnBuscar() {
        boolean seleccionesVacias = 
                estadoBusquedaEliminacion.obtenerEstado("Busqueda") == -1 || 
                estadoBusquedaEliminacion.obtenerEstado("Columna") == -1;
        
        boolean validarBinaria = 
                estadoBusquedaEliminacion.obtenerEstado("Busqueda") == 2 && 
                estadoInicio.obtenerEstado("Ordenamiento") != 1;
        
        boolean validarTransformacionClaves = 
                estadoBusquedaEliminacion.obtenerEstado("Busqueda") == 3 &&
                estadoInicio.obtenerEstado("Ordenamiento") != 2;
        
        
        boolean valorEnBlanco = vista.ventanaBusquedaEliminacion.tfValor.getText().isBlank();
     
        if(seleccionesVacias)                  { vista.mensajeError("No se ha seleccionado búsqueda o columna"); }    
        else if(valorEnBlanco)                 { vista.mensajeError("No se ha digitado valor a buscar"); }
        else if(validarBinaria)                { vista.mensajeError("Para usar búsqueda binaria, primero ordene con BurstSort."); }
        else if(validarTransformacionClaves)   { vista.mensajeError("Para usar búsqueda por transformación de claves, primero ordene con Tabla Hash"); }
        else 
        {
            vista.ventanaBusquedaEliminacion.tablaBusqueda.setModel(
                cargarTablaBusqueda(modelo.buscarProductos(
                    estadoBusquedaEliminacion.obtenerEstado("Columna"), 
                    vista.ventanaBusquedaEliminacion.tfValor.getText())
                )
            );
        }
    }
    
    
    private void btnEliminar() {
        int[] filaSeleccionada = vista.ventanaBusquedaEliminacion.tablaBusqueda.getSelectedRows();
        
        String claveSeleccionada;
        DefaultTableModel auxiliar;
        
        if(filaSeleccionada.length == 1) 
        {
            claveSeleccionada = Integer.toString((int) vista.ventanaBusquedaEliminacion.tablaBusqueda.getValueAt(
                filaSeleccionada[0], 
                0
            ));
            
            modelo.eliminarProducto(claveSeleccionada);
            auxiliar = (DefaultTableModel) vista.ventanaBusquedaEliminacion.tablaBusqueda.getModel();
            auxiliar.removeRow(0);
        }
        else 
        {
            modelo.eliminarProductos(
                estadoBusquedaEliminacion.obtenerEstado("Columna"), 
                (String) vista.ventanaBusquedaEliminacion.tfValor.getText()
            );
            
            auxiliar = (DefaultTableModel) vista.ventanaBusquedaEliminacion.tablaBusqueda.getModel();
            for(int i = 0; i < filaSeleccionada.length; i++) {
                auxiliar.removeRow(0);
            }
        }
        
        vista.ventanaBusquedaEliminacion.tablaBusqueda.setModel(auxiliar);
        vista.ventanaInicio.tablaProductos.setModel(
            cargarTablaBusqueda(modelo.enviarListaProductos())
        );
    }
    
    private void limpiarVentanaInsertar() {
        vista.ventanaInsertar.campoDescripcion.setText("");
        vista.ventanaInsertar.campoNombre.setText("");
        vista.ventanaInsertar.campoPrecio.setText("");
    }
}
