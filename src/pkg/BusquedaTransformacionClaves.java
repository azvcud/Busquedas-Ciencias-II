/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amirz
 */
public class BusquedaTransformacionClaves implements Busqueda {

    @Override
    public ArrayList<Producto> buscar(ArrayList<Producto> listaProductos, int opcion, Object atributo) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        Producto productoSeleccionado;
        boolean productoExistente = true;
        
        int indice = hashAtributo(atributo, opcion, listaProductos.size());
        int inicio = indice;
        
        do {
            productoSeleccionado = listaProductos.get(indice);
            if(indice == (listaProductos.size() - 1)) { indice = 0; }
            else                                      { indice = indice + 1; }
            if(inicio == indice)                      { productoExistente = false; break; }
        } while(comparar(productoSeleccionado, opcion, atributo) == false);
       
        if(productoExistente) { productosEncontrados.add(productoSeleccionado); }
        
        return productosEncontrados;
    }
    
    private int hashAtributo(Object atributo, int opcion, int magnitud) {
        return switch (opcion) {
            case 1, 4 -> ((int)atributo) % magnitud;
            case 2 -> Math.abs(atributo.hashCode()) % magnitud;
            default -> -1;
        };
    }
    
    private boolean comparar(Producto productoSeleccionado, int opcion, Object atributo) {
        return switch (opcion) {
            case 1 -> productoSeleccionado.getId() == ((int)atributo);
            case 2 -> productoSeleccionado.getNombre().equals((String)atributo);
            case 4 -> productoSeleccionado.getPrecio() == ((int) atributo);
            default -> false;
        };
    }
}
