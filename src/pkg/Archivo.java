/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;


/**
 *
 * @author amirz
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    
    public ArrayList<Producto> cargarArchivos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Producto auxiliar;
        int i = 0;
<<<<<<< Updated upstream
        
        String archivoCSV = "C:\\Users\\amirz\\OneDrive\\Documentos\\GitHub\\Ciencias II - Búsquedas\\Busquedas-Ciencias-II\\datos_ficticios2.csv";
=======
           
        String archivoCSV = "C:\\Users\\amirz\\OneDrive\\Documentos\\GitHub\\Ciencias II - Búsquedas\\Busquedas-Ciencias-II\\datos_ficticios.csv";
>>>>>>> Stashed changes

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoCSV))) {
            String lineaTexto;
            boolean primerLinea = true;  // Para omitir la primera línea (encabezados)
            
<<<<<<< Updated upstream
            while ((lineaTexto = lector.readLine()) != null && i < 7000) {
=======
            while ((lineaTexto = lector.readLine()) != null && i < 5000) {
>>>>>>> Stashed changes
                if (primerLinea) {
                    primerLinea = false;
                    continue;  // Omitir la primera línea (encabezados)
                }
                
                String[] parts = lineaTexto.split(",");
                if (parts.length >= 3) {
                    String producto = parts[0];
                    String descripcion = parts[1];
                    int precio = Integer.parseInt(parts[2]);
                    auxiliar = new Producto(producto, descripcion, precio);
                    listaProductos.add(auxiliar);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return listaProductos;
    }
}
