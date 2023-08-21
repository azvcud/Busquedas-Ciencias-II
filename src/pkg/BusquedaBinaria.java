/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import static java.lang.Math.ceil;
import java.util.ArrayList;

/**
 *
 * @author amirz
 */
public class BusquedaBinaria implements Busqueda {

    @Override
    public ArrayList<Producto> buscar(ArrayList<Producto> listaProductos, int opcion, Object atributo) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        Producto productoSeleccionado = null;
        int izquierda = 0;
        int derecha = listaProductos.size()-1;
        int mitad;
        
        
        while(izquierda != derecha) {
            mitad = (int) ceil((izquierda + derecha)/2);
            productoSeleccionado = listaProductos.get(mitad);
            
            if(compararMayor(productoSeleccionado, opcion, atributo))   { derecha = mitad - 1; }
            else                                                        { izquierda = mitad; }
        }
        
        if(comparar(productoSeleccionado, opcion, atributo)) { 
            productosEncontrados.add(productoSeleccionado); 
            return productosEncontrados;
        }
        
        return null;
    }
    
    private boolean comparar(Producto productoSeleccionado, int opcion, Object atributo) {
        return switch (opcion) {
            case 1 -> productoSeleccionado.getId() == ((int)atributo);
            case 2 -> productoSeleccionado.getNombre().equals((String)atributo);
            case 4 -> productoSeleccionado.getPrecio() == ((float)((int) atributo));
            default -> false;
        };
    }
    
    private boolean compararMayor(Producto productoSeleccionado, int opcion, Object atributo) {
        return switch (opcion) {
            case 1 -> productoSeleccionado.getId() > ((int)atributo);
            case 2 -> (productoSeleccionado.getNombre().compareTo((String)atributo)) > 0;
            case 4 -> productoSeleccionado.getPrecio() > ((float)((int) atributo));
            default -> false;
        };
    }
}
