/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nur_z
 */
public class imprimir extends JFrame {
    private static JLabel soles;
    private static JLabel turnos;
    
  public static void imprimir(String nsoles, String nturnos) {     
       turnos.setText(nturnos);
       turnos.getText();
       soles.setText(nsoles);
       soles.getText();
 }
 
}
