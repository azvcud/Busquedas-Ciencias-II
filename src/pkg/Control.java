/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author amirz
 */
public class Control {
    private TiendaProductos tiendaProductos;
    private Vista ventanas;
    
    private Ordenamiento hash; 
    private Ordenamiento burstSort;
    private Busqueda secuencial;
    private Busqueda binaria;
    private Busqueda transformacionClaves;
            
    public Control(TiendaProductos tiendaProductos, Vista ventanas) {
        hash = new TablaHash();
        burstSort = new BurstSort();
        secuencial = new BusquedaSecuencial();
        binaria = new BusquedaBinaria();
        transformacionClaves = new BusquedaTransformacionClaves();
        
        this.tiendaProductos = tiendaProductos;
        this.ventanas = ventanas;
    }
    
    public void iniciar() {
        
    }
    
    public void ordenarProductos() {
        int variablePrueba = 1;
        tiendaProductos.ordenarProductos(variablePrueba);
    }
    
    public void buscarProductos() {
        int variablePrueba1 = 1;
        Object variablePrueba2 = 0;
        tiendaProductos.buscarProductos(variablePrueba1, variablePrueba2);
    }
    
    public void cambiarEstrategiaBusqueda() {
        
    }
    
    public void cambiarEstrategiaOrdenamiento() {
        
    }
    
    public void insertarProducto() {
       String nombre = "";
       String descripcion = "falopa";
       int precio = 3324;
       tiendaProductos.insertarProducto(new Producto(nombre, descripcion, precio));
    }
    
    public void eliminarProducto() {
        
    }
}
