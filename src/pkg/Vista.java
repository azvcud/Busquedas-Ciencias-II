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
public class Vista implements ActionListener {
    private VentanaPrincipal ventanaInicio;
    
    public Vista() {
        ventanaInicio = new VentanaPrincipal();
        
        this.ventanaInicio.btnBuscarEliminar.addActionListener(this);
        this.ventanaInicio.btnInsertar.addActionListener(this);
        this.ventanaInicio.btnOrdenamientoBurst.addActionListener(this);
        this.ventanaInicio.btnOrdenamientoHash.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
