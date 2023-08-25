/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amirz
 */
public class Control implements ActionListener {

    private Vista vista;
    private Modelo modelo;
    private int estadoItem;
    private int listaBusqueda;
    private int listaColumna;

    public Control(Vista vista, Modelo modelo) {
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
        
        setEstadoItem(this.vista.ventanaInicio.selectorColumna.getSelectedIndex());
        setListaBusqueda(this.vista.ventanaGestion.cbBusqueda.getSelectedIndex());
        setListaColumna(this.vista.ventanaGestion.cbColumna.getSelectedIndex());
        
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
        
        if(e.getSource() == this.vista.ventanaGestion.cbBusqueda) {
            switch((String)this.vista.ventanaGestion.cbBusqueda.getSelectedItem()) {
                case "Secuencial" -> setListaBusqueda(1);
                case "Binaria" -> setListaBusqueda(2);
                case "Transformación por claves" -> setListaBusqueda(3);
                default -> setListaBusqueda(4);
            }
            
            modelo.cambiarEstrategiaBusqueda(getListaBusqueda());
        }
        
        if(e.getSource() == this.vista.ventanaGestion.cbColumna) {
            switch((String)this.vista.ventanaGestion.cbColumna.getSelectedItem()) {
                case "ID" -> setListaColumna(1);
                case "Nombre" -> setListaColumna(2);
                case "Descripción" -> setListaColumna(3);
                case "Precio" -> setListaColumna(4);
                default -> setListaColumna(0);
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
            switch (getEstadoItem()) {
                case -1 -> vista.mensajeError("No se ha seleccionado ordenamiento");
                case 3 -> vista.mensajeError("No existe soporte de Hashing para la columna seleccionada.");
                default -> {
                    modelo.cambiarEstrategiaOrdenamiento(2, getEstadoItem());
                    cargarProductos();
                }
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
                else { 
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
        
        if(e.getSource() == this.vista.ventanaGestion.btnBuscar) {
            
            if(getListaBusqueda() == -1 || getListaColumna() == -1) {
                vista.mensajeError("No se ha seleccionado búsqueda o columna");
            }
            else {
                this.vista.ventanaGestion.tablaBusqueda.setModel(cargarTablaBusqueda(
                        this.vista.ventanaGestion.tfValor.getText()
                ));
            }
        }
    }

    public DefaultTableModel cargarTablaBusqueda(String valor) {
        String[] nombresColumnas = {"ID", "Nombre", "Descripción", "Precio"};
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);
        
        for(Producto producto: modelo.buscarProductos(getListaColumna(), valor)) {
                    modeloTabla.addRow(new Object[]{
                        producto.getId(), 
                        producto.getNombre(),
                        producto.getDescripcion(),
                        producto.getPrecio()
                    });
        }
        
        return modeloTabla;
    }
    
    public int getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(int estadoItem) {
        this.estadoItem = estadoItem;
    }

    public int getListaBusqueda() {
        return listaBusqueda;
    }

    public void setListaBusqueda(int listaBusqueda) {
        this.listaBusqueda = listaBusqueda;
    }

    public int getListaColumna() {
        return listaColumna;
    }

    public void setListaColumna(int listaColumna) {
        this.listaColumna = listaColumna;
    }
}
