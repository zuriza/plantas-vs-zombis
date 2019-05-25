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
public class graphicplanta extends JFrame{
    public graphicplanta(){
        add(lanzaguisantes());
        add(Girasol());
        add(cereza());
        add(nuez());
    }
    private JLabel lanzaguisantes() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/lanzaguisantes2.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (145,77,50,50);
 
  return ejemplo;
 }
 
 private JLabel Girasol() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/girasol.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (345,125,50,50);
 
  return ejemplo;
 }
   private JLabel cereza() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/cereza.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (345,177,50,50);
 
  return ejemplo;
 }
      private JLabel nuez() {
 
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel(new ImageIcon("src/imagenes/Nuez.png"));
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds (345,225,50,50);
 
  return ejemplo;
 }
}
