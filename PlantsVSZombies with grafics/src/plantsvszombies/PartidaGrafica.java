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
 * @author Usuario
 */
public class PartidaGrafica extends JFrame{
    
 
    
    
    public PartidaGrafica(){
        
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(700, 700);
        super.setLocation(250,250);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Juego");
        super.setResizable(false);
        
    }
    public void render(ArrayList<Zombies> zomb,ArrayList<Planta> plts){
        
        for (Planta plt : plts) {
            JLabel planta= new JLabel(plt.impresion);
            planta.setBackground(Color.red);
            planta.setBounds(plt.getX()*50+10, plt.getY()*50+10, 30, 30);
            super.add(planta);
        }
        for (Zombies zom : zomb) {
            JLabel zombie= new JLabel(zom.impresion);
            zombie.setBounds(zom.getX()*50+10, zom.getY()*50+10, 30, 30);
            super.add(zombie);
        }
        
    }
}
