/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 *@author Miguel Y Ricardo
 * 
 */
/**
 * 
 * Intento de dibujar el juego graficamente
 */
public class PartidaGrafica extends JFrame{
    
    JLabel planta;
    JLabel zombie;
    ArrayList<Zombies> zomb;
    ArrayList<Planta> plts;
    
    public PartidaGrafica(ArrayList<Zombies> zomb,ArrayList<Planta> plts){ 
        this.zomb=zomb;
        this.plts=plts;
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(700, 700);
        super.setLocation(250,250);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Juego");
        super.setResizable(false);
        this.render(zomb, plts);
        super.add(planta);
        super.add(zombie);
        
        }
    public void render(ArrayList<Zombies> zomb,ArrayList<Planta> plts){
        if(plts.isEmpty()){
            planta=new JLabel("");
            planta.setBounds(0, 0, 0, 0);
        }
        if(zomb.isEmpty()){
            zombie=new JLabel("");
            zombie.setBounds(0, 0, 0, 0);
        }
        for (int i= 0;i<plts.size();i++) {
            planta= new JLabel(plts.get(i).impresion);
            planta.setBounds(plts.get(i).getX()*50+10, plts.get(i).getY()*50+10, 50, 50);
            planta.setVisible(true);
            
            
        }
        for (int i=0;i<zomb.size();i++) {
            zombie= new JLabel(zomb.get(i).impresion);
            zombie.setBounds(zomb.get(i).getX()*50+10, zomb.get(i).getY()*50+10, 30, 30);
            zombie.setVisible(true);
            this.add(zombie);
        }        
    }
}