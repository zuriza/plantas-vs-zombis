/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ricardo
 */
public class Tableronew extends JFrame{


     private final Posicion tablero[][];
     private String linea_arriba;
     int dibujo = -275 ;
     int dibujo2 = -250 ;
     int dibujo3 = 140 ;
     // el contador inicial de x es 145
     private int espaciox = 70;
     // el contador inicial de y es 77
     private int espacioy = 50;
    public Tableronew() {
     tablero= new Posicion [7][7];
      for (int i = 0; i < 7; i++) {
          dibujo +=50;
          add(verJLabel());
      }
       for (int z = 0; z< 8; z++) {
            
            for (int d = 0; d < 6; d++) {
            dibujo2 +=50;
            add(verJLabel2());
      }
            dibujo3 +=65;
            dibujo2 =-250;
       }

        inicializador();
     
 }

    /**
     * @param args the command line arguments
     */
    private void inicializador() {
    setSize(800, 600);
    setLayout(null);
    setTitle("Mi ventana");
    setLocationRelativeTo(null);
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 }
 
 // JLabel que agrega un texto
 private JLabel verJLabel() {
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel();
  linea_arriba="|";
  for (int j = 0; j < 7; j++) {
        linea_arriba += "----------|";
 
  }
    
          
  ejemplo.setText(linea_arriba);
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds(140, dibujo, 600, 600);
  // Le asignamos un tipo de Tipografía
  ejemplo.setFont(new Font("Arial", 0, 18));
  
 
  return ejemplo;
 }
 private JLabel verJLabel2() {
  // Se crea el objeto JLabel
  JLabel ejemplo2 = new JLabel();
  linea_arriba="|";
      
  ejemplo2.setText(linea_arriba);
  // Le damos una ubicación dentro del Frame
  ejemplo2.setBounds(dibujo3, dibujo2, 600, 600);
  // Le asignamos un tipo de Tipografía
  ejemplo2.setFont(new Font("Arial", 0, 18));
  
 
  return ejemplo2;
 }
 

     /**
     * @return the espaciox
     */
    public int getEspaciox() {
        return espaciox;
    }

    /**
     * @param espaciox the espaciox to set
     */
    public void setEspaciox(int espaciox) {
        this.espaciox = espaciox;
    }

    /**
     * @return the espacioy
     */
    public int getEspacioy() {
        return espacioy;
    }

    /**
     * @param espacioy the espacioy to set
     */
    public void setEspacioy(int espacioy) {
        this.espacioy = espacioy;
    }
        
    }


 


   

    

