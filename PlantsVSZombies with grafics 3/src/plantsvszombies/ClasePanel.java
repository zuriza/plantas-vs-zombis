/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nur_z
 */

public class ClasePanel extends JPanel{
     int dibujo = -275 ;
     int dibujo2 = -250 ;
     int dibujo3 = 140 ;
     JLabel imprimir [][] = new JLabel [20][20];
     int i;
     int j;
     private String linea_arriba;
    public ClasePanel(int soles, int turnos,int planta,int x , int y) {
     String nsoles = Double.toString(soles);
     String nturnos = Double.toString(turnos);
       add(imprimir_soles(nsoles));
       add(imprimir_turnos(nturnos)); 
       if (planta<0){
       }else if (planta==0){
           add(cereza(i,j,x,y));
           i++;
       }else if (planta==1){
           add(nuez(i,j,x,y));
           i++;
       }else if (planta==2){
           add(lanzaguisantes(i,j,x,y));
           i++;
       }else if (planta==3){
           add(Girasol(i,j,x,y));
           i++;
       }else if (planta==4){
           add(caracubo(i,j,x,y));
           i++;
       }else if (planta==5){
           add(zombi(i,j,x,y));
           i++;
       }else if (planta==6){
           add(Deportista(i,j,x,y));
           i++;
       }
       if (i == 10){
           j++;
       }
       planta=-1;
    inicializador();
 }
 
 private void inicializador() {
  setBounds(50, 50 , 600, 600);
  setVisible(true);
 }
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
      ejemplo.setFont(new Font("Arial", 0, 20));
  
 
  return ejemplo;
 }
 private JLabel imprimir_soles (String soles){
     JLabel ejemplo = new JLabel();
        ejemplo.setText("SOLES:"+soles);
        ejemplo.setBounds(25,-250, 600, 600);
        ejemplo.setFont(new Font("Arial", 0, 13));
        return ejemplo;
 }
    private JLabel imprimir_turnos (String turnos){
        JLabel ejemplo = new JLabel();
        ejemplo.setText("Turno:"+turnos);
        ejemplo.setBounds(25,-225, 600, 600);
        ejemplo.setFont(new Font("Arial", 0, 13));
        return ejemplo;
    }
     private JLabel lanzaguisantes(int i, int j,int x, int y) {

  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/lanzaguisantes2.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 }
 
 private JLabel Girasol(int i,int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/girasol.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 }
   private JLabel cereza(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j]= new JLabel(new ImageIcon("src/imagenes/cereza.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 }
      private JLabel nuez(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/Nuez.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 }
private JLabel caracubo(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/caracubo.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 }
  private JLabel zombi(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/zombi2.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 } private JLabel Deportista(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/Deportista.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 
  return imprimir[i][j];
 }
 /* Jlabel del panel */
    
    
}
