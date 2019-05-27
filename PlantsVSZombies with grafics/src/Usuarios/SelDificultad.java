/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import plantsvszombies.Dificultad;
import plantsvszombies.Partida;
import plantsvszombies.Tablero;

/**
 *
 * @author Usuario
 */
public class SelDificultad extends JFrame{
    HashMap users;
    Usuario usuario;
    JButton btnF,btnM,btnA,btnI;
    public SelDificultad(HashMap usuarios,Usuario user){
        this.usuario=user;
        this.users=usuarios;
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(300, 260);
        super.setLocation(500,500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Seleccione dificultad");
        super.setResizable(false);
        this.componentes();
        super.add(btnF);
        super.add(btnM);
        super.add(btnA);
        super.add(btnI);
    }
    private void componentes(){
        btnF=new JButton("Facil");
        btnM=new JButton("Media");
        btnA=new JButton("Alta");
        btnI=new JButton("Imposible");
        btnF.setBounds(30, 30, 100, 30);
        btnM.setBounds(30, 90, 100, 30);
        btnA.setBounds(30, 150, 100, 30);
        btnI.setBounds(30, 210, 100, 30);
        btnF.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               dispose();
               Dificultad diff= new Dificultad("Baja");
                Tablero tabl= new Tablero(7,7);
                Partida part= new Partida(tabl,diff,usuario,users);
                
           }
        });
         btnM.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
                dispose();
                Dificultad diff= new Dificultad("Media");
                Tablero tabl= new Tablero(7,7);
                Partida part= new Partida(tabl,diff,usuario,users);
              
           }
        });
          btnA.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
                dispose();
                Dificultad diff= new Dificultad("Alta");
                Tablero tabl= new Tablero(7,7);
                Partida part= new Partida(tabl,diff,usuario,users);
               
           }
        });
           btnI.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               dispose();
               Dificultad diff= new Dificultad("Imposible");
                Tablero tabl= new Tablero(7,7);
                Partida part= new Partida(tabl,diff,usuario,users);
                
                
           }
        });
    }
    
}
