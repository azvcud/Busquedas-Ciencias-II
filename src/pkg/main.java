/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg;

/**
 *
 * @author amirz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TiendaProductos app = new TiendaProductos();
        Busqueda secuencial = new BusquedaSecuencial();
        Busqueda binaria = new BusquedaSecuencial();
        Busqueda transformacionClaves = new BusquedaTransformacionClaves();
        Ordenamiento burstSort = new BurstSort();
        
        Producto producto1 = new Producto("Zumo de Naranja", "Esta vaina es de los dioses.", 4500);
        Producto producto2 = new Producto("Papas BBQ", "El picor es excelente.", 1800);
        Producto producto3 = new Producto("Kilo de carne", "Para invadir Ucrania con todas las de la ley.", 10000);
        Producto producto4 = new Producto("Pluma", "Excelente para escribir.", 24500);
        Producto producto5 = new Producto("Cuaderno 7 materias", "Necesario para el estudio.", 24500);
        Producto producto6 = new Producto("Celular", "Con 4G incluido", 1450000);
        
        app.insertarProducto(producto1);
        app.insertarProducto(producto2);
        app.insertarProducto(producto3);
        app.insertarProducto(producto4);
        app.insertarProducto(producto5);
        app.insertarProducto(producto6);
        
        //Probando secuencial
        app.setEstrategiaBusqueda(secuencial);
        //System.out.println(app.toString());
        //System.out.println(app.buscarProductos(4, 24500));
        //app.eliminarProductos(4, 24500);
        
        //Probando BurstSort
        app.setEstrategiaOrdenamiento(burstSort);
        app.ordenarProductos(3);
        System.out.println(app.toString());
        System.out.println(app.buscarProductos(3, "Ucrania"));
        
        //Probando binaria
        app.setEstrategiaBusqueda(binaria);
        System.out.println(app.buscarProductos(2, "Pluma"));
        
        //Probando burstSort
        app.ordenarProductos(4);
        System.out.println(app.toString());
        System.out.println(app.buscarProductos(4, 1450000));
    }
    
}
