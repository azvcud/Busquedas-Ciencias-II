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
public class TiendaProductos {
    private ArrayList<Producto> productosAplicacion;
    private Busqueda estrategiaBusqueda;
    private Ordenamiento estrategiaOrdenamiento;
    
    public TiendaProductos() {
        this.productosAplicacion = new ArrayList<>();
        this.estrategiaBusqueda = null;
        this.estrategiaOrdenamiento = null;
    }
    
    public void ordenarProductos(int opcion) {
        setProductosAplicacion(estrategiaOrdenamiento.ordenar(productosAplicacion, opcion));
    }

    public String buscarProductos(int opcion, Object atributo) {
        return enlistar(estrategiaBusqueda.buscar(
                productosAplicacion,
                opcion,
                atributo
        ));
    }
    
    @Override
    public String toString() {
        return enlistar(productosAplicacion);
    }
    
    private String enlistar(ArrayList<Producto> listaProductos) {
        String lista = "";
        
        for(int i = 0; i < listaProductos.size(); i++) {
            lista = lista + listaProductos.get(i).toString();
        }
        
        return lista;
    }

    public void setProductosAplicacion(ArrayList<Producto> productosAplicacion) {
        this.productosAplicacion = productosAplicacion;
    }

    public void setEstrategiaBusqueda(Busqueda estrategiaBusqueda) {
        this.estrategiaBusqueda = estrategiaBusqueda;
    }

    public void setEstrategiaOrdenamiento(Ordenamiento estrategiaOrdenamiento) {
        this.estrategiaOrdenamiento = estrategiaOrdenamiento;
    }

    public ArrayList<Producto> getProductosAplicacion() {
        return productosAplicacion;
    }
    
    public void insertarProducto(Producto producto) {
        productosAplicacion.add(producto);
    }
    
    public void eliminarProducto(int clave) {
        productosAplicacion.removeAll(estrategiaBusqueda.buscar(
                productosAplicacion,
                1,
                clave
        ));
    }
    
    public void eliminarProductos(int opcion, Object atributo) {
        productosAplicacion.removeAll(estrategiaBusqueda.buscar(
                productosAplicacion,
                opcion,
                atributo
        ));
    }
}
