/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pkg;

/**
 *
 * @author amirz
 */
public interface ObservadorControl {
    public void notificar(String accion, String valor);
    public int obtenerEstado(String accion);
}
