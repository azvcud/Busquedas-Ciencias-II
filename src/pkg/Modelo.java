/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.util.ArrayList;

/**
 *
 * @author amirz
 */
public class Modelo {
    private TiendaProductos tiendaProductos;
    
    private Ordenamiento hash; 
    private Ordenamiento burstSort;
    private Busqueda secuencial;
    private Busqueda binaria;
    private Busqueda transformacionClaves;
            
    public Modelo() {
        tiendaProductos = new TiendaProductos();
        hash = new TablaHash();
        burstSort = new BurstSort();
        secuencial = new BusquedaSecuencial();
        binaria = new BusquedaBinaria();
        transformacionClaves = new BusquedaTransformacionClaves();
        valoresIniciales();
    }
    
    public void valoresIniciales() {
        Producto producto1 = new Producto("Zumo de Naranja", "Esta vaina es de los dioses.", 4500);
        Producto producto2 = new Producto("Papas BBQ", "El picor es excelente.", 1800);
        Producto producto3 = new Producto("Kilo de carne", "Para invadir Ucrania con todas las de la ley.", 10000);
        Producto producto4 = new Producto("Pluma", "Excelente para escribir.", 24500);
        Producto producto5 = new Producto("Cuaderno 7 materias", "Necesario para el estudio.", 24500);
        Producto producto6 = new Producto("Celular", "Con 4G incluido", 1450000);
        Producto producto7 = new Producto("Televisor 4K", "Imágenes impresionantes.", 85000);
        Producto producto8 = new Producto("Cuaderno 7 materias", "Necesario para el estudio.", 24500);
        Producto producto9 = new Producto("Cuaderno 7 materias", "Necesario para el estudio.", 24500);
        Producto producto10 = new Producto("Cuaderno 7 materias", "Necesario para el estudio.", 24500);
        
        tiendaProductos.insertarProducto(producto1);
        tiendaProductos.insertarProducto(producto2);
        tiendaProductos.insertarProducto(producto3);
        tiendaProductos.insertarProducto(producto4);
        tiendaProductos.insertarProducto(producto5);
        tiendaProductos.insertarProducto(producto6);
        tiendaProductos.insertarProducto(producto7);
        tiendaProductos.insertarProducto(producto8);
        tiendaProductos.insertarProducto(producto9);
        tiendaProductos.insertarProducto(producto10);
    }
    
    
    public void ordenarProductos(int columnaOrden) {
        tiendaProductos.ordenarProductos(columnaOrden);
    }
    
    public ArrayList<Producto> buscarProductos(int opcion, String atributo) {
        return tiendaProductos.buscarProductos(opcion, atributo);
    }
    
    public ArrayList<Producto> enviarListaProductos() {
        return tiendaProductos.getProductosAplicacion();
    }
    
    public void cambiarEstrategiaBusqueda(int columnaOrden) {
        switch(columnaOrden) {
            case 1 -> tiendaProductos.setEstrategiaBusqueda(secuencial);
            case 2 -> tiendaProductos.setEstrategiaBusqueda(binaria);
            case 3 -> tiendaProductos.setEstrategiaBusqueda(transformacionClaves);
            default -> tiendaProductos.setEstrategiaBusqueda(null);
        }
    }
    
    public void cambiarEstrategiaOrdenamiento(int opcion, int columnaOrden) {
        switch(opcion) {
            case 1 -> tiendaProductos.setEstrategiaOrdenamiento(burstSort);
            case 2 -> tiendaProductos.setEstrategiaOrdenamiento(hash);
            default -> tiendaProductos.setEstrategiaOrdenamiento(null);
        }

        ordenarProductos(columnaOrden);
    }
    
    public void insertarProducto(String nombre, String descripcion, int precio) {
       tiendaProductos.insertarProducto(new Producto(nombre, descripcion, precio));
    }
    
    public void eliminarProducto(String clave) {
        tiendaProductos.eliminarProducto(clave);
    }
    
    public void eliminarProductos(int opcion, String atributo) {
        tiendaProductos.eliminarProductos(opcion, atributo);
    }
}
