/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Miguel Y Ricardo
 * 
 */
/**
 * 
 * Donde se crea la ventana de Ranking
 */
public class Ranking extends JFrame{
    ArrayList<Usuario> usuarios_ord;
    public Ranking(HashMap usuarios){

        usuarios_ord= new ArrayList(usuarios.values());
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(350, 600);
        super.setLocation(500,500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Ranking");
        super.setResizable(false);
        this.componentes();
    }
    private void componentes(){
        Collections.sort(usuarios_ord, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario p1, Usuario p2) {
		return (new Integer(p1.getPts()).compareTo((p2.getPts())));
            }
        });
        for (int i = 0; i <usuarios_ord.size(); i++) {
            JLabel label= new JLabel();
            label.setText(usuarios_ord.get(i).toString());
            label.setBounds(30, (i*30)+20, 300, 20);
            super.add(label);
            
        }
    }
    
}
