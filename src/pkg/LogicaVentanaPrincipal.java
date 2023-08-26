/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author amirz
 */
public class LogicaVentanaPrincipal implements ObservadorControl {

    private int listaColumna;
    
    public LogicaVentanaPrincipal() {
        this.listaColumna = -1;
    }
    
    @Override
    public void notificar(String accion, String valor) {
        if("Selector".equals(accion)) { seleccionColumna(valor); }
    }

    @Override
    public int obtenerEstado(String accion) {
        if("Selector".equals(accion))   { return getListaColumna(); }
        else                                    { return -1; }
    }
    
    private void seleccionColumna(String valor) {
        switch(valor) {
            case "ID" -> setListaColumna(1);
            case "Nombre" -> setListaColumna(2);
            case "Descripción" -> setListaColumna(3);
            case "Precio" -> setListaColumna(4);
            default -> setListaColumna(0);
        }
    }

    private int getListaColumna() {
        return listaColumna;
    }

    private void setListaColumna(int listaColumna) {
        this.listaColumna = listaColumna;
    }
}
