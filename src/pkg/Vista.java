/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author amirz
 */
public class Vista {
    public VentanaPrincipal ventanaInicio;
    public VentanaInsertar ventanaFormulario;
    public VentanaBusquedaEliminacion ventanaGestion;
    
    public Vista() {
        ventanaInicio = new VentanaPrincipal();
        ventanaFormulario = new VentanaInsertar();
        ventanaGestion = new VentanaBusquedaEliminacion();
    }    
}
