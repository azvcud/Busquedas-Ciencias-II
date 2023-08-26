/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author amirz
 */
public class LogicaVentanaBusquedaEliminacion implements ObservadorControl {

    private int listaColumna;
    private int listaBusqueda;
    
    public LogicaVentanaBusquedaEliminacion() {
        this.listaBusqueda = -1;
        this.listaColumna = -1;
    }
    
    @Override
    public void notificar(String accion, String valor) {
        switch(accion) {
            case "Busqueda" -> seleccionBusqueda(valor);
            case "Columna" -> seleccionColumna(valor);
            default -> System.out.println("ERROR");
        }
    }
    
    @Override
    public int obtenerEstado(String accion) {
        return switch(accion) {
            case "Busqueda" -> getListaBusqueda();
            case "Columna" -> getListaColumna();
            default -> -1;
        };
    }
    
    private void seleccionBusqueda(String valor) {
        switch(valor) {
            case "Secuencial" -> setListaBusqueda(1);
            case "Binaria" -> setListaBusqueda(2);
            case "Transformación por claves" -> setListaBusqueda(3);
            default -> setListaBusqueda(-1);
        }
    }
    
    private void seleccionColumna(String valor) {
        switch(valor) {
            case "ID" -> setListaColumna(1);
            case "Nombre" -> setListaColumna(2);
            case "Descripción" -> setListaColumna(3);
            case "Precio" -> setListaColumna(4);
            default -> setListaColumna(-1);
        }
    }

    public void setListaColumna(int listaColumna) {
        this.listaColumna = listaColumna;
    }

    public void setListaBusqueda(int listaBusqueda) {
        this.listaBusqueda = listaBusqueda;
    }

    public int getListaColumna() {
        return listaColumna;
    }

    public int getListaBusqueda() {
        return listaBusqueda;
    }
}
