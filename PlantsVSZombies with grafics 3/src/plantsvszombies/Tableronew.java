/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author ricardo
 */
public class Tableronew extends JFrame{
     private int soles;
     private int turnos;
     JLabel panel1= new JLabel();
     public int plantas;
     int dibujo = -275 ;
     int dibujo2 = -250 ;
     int dibujo3 = 140 ;
      int i;
      int j;
     JLabel imprimir [][] = new JLabel [20][20];
     private final Posicion tablero[][]= new Posicion [7][7];
     private String linea_arriba;
     int r = 0;
     
     // el contador inicial de x es 145
     private int espaciox = 70;
     // el contador inicial de y es 77
     private int espacioy = 50;
     public Tableronew(int soles, int turnos,int planta,int x , int y) { 
         plantas =planta;
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
       this.inicializador(soles, turnos, planta, x, y);
        
     }
     


    /**
     * @param args the command line arguments
     */
    private void inicializador(int soles, int turnos,int planta,int x , int y) {
        dispose();
        setSize(800, 600);
        add(new ClasePanel ( soles,turnos, planta, x , y));
        ImageIcon image = new ImageIcon("src/imagenes/lanzaguisantes2.png");
        setIconImage(image.getImage());
        setLayout(null);
        setTitle("Juego");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    
    
 }
 
 // JLabel que agrega un texto
 private JLabel verJLabel() {
  // Se crea el objeto JLabel
  JLabel ejemplo = new JLabel();
  ejemplo.setSize(1000,600);
  linea_arriba="|";
  for (int j = 0; j < 7; j++) {
        linea_arriba += "----------|";
 
  }
    
          
  ejemplo.setText(linea_arriba);
  // Le damos una ubicación dentro del Frame
  ejemplo.setBounds(140,dibujo, 600, 600);
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
  ejemplo2.setBounds(dibujo3,dibujo2, 600, 600);
  // Le asignamos un tipo de Tipografía
  ejemplo2.setFont(new Font("Arial", 0, 18));
  
 
  return ejemplo2;
 }
    private JLabel imprimir_soles (String soles){
        JLabel ejemplo2 = new JLabel();
        ejemplo2.setText("SOLES:"+soles);
        ejemplo2.setBounds(25,-250, 600, 600);
        ejemplo2.setFont(new Font("Arial", 0, 13));
        return ejemplo2;
 }
    private JLabel imprimir_turnos (String turnos){
        JLabel ejemplo1 = new JLabel();
        ejemplo1.setText("Turno:"+turnos);
        ejemplo1.setBounds(25,-225, 600, 600);
        ejemplo1.setFont(new Font("Arial", 0, 13));
        return ejemplo1;
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
 plantas=-1;
  return imprimir[i][j];
 }
private JLabel caracubo(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/caracubo.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 plantas=-1;
  return imprimir[i][j];
 }
  private JLabel zombi(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/zombi2.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 plantas=-1;
  return imprimir[i][j];
 } private JLabel Deportista(int i, int j,int x, int y) {
 
  // Se crea el objeto JLabel
  imprimir[i][j] = new JLabel(new ImageIcon("src/imagenes/Deportista.png"));
  // Le damos una ubicación dentro del Frame
  imprimir[i][j].setBounds (x,y,50,50);
 plantas=-1;
  return imprimir[i][j];
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


 


   

    

