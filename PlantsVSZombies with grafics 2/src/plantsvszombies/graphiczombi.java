/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nur_z
 */
public class graphiczombi extends JFrame{
    public graphiczombi (){
        add(caracubo());
        add(zombi());
        add(Deportista());
    }
               
    private JLabel caracubo() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/caracubo.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (215,77,50,50);
 
  return ejemplo;
 }
  private JLabel zombi() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/zombi2.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (275,77,50,50);
 
  return ejemplo;
 } private JLabel Deportista() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/Deportista.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (345,77,50,50);
 
  return ejemplo;
 }
}
