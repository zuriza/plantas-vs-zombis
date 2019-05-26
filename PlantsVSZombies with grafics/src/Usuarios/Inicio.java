/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class Inicio extends JFrame{
        Usuario user;
        HashMap usuarios;
        JButton btnIni,btnTgt,btnLista;
       
    public Inicio(Usuario user,HashMap users){
        this.user=user;
        this.usuarios=users;
        this.componentes();
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(350, 400);
        super.setLocation(500,500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Inicio");
        super.setResizable(false);
        super.add(btnIni);
        super.add(btnTgt);
        super.add(btnLista);
        
    }
    private void componentes(){
     btnIni=new JButton();
     btnTgt=new JButton();
     btnLista=new JButton();
     btnIni.setBounds(75, 50, 200, 50);
     btnIni.setText("Iniciar partida");
     btnTgt.setBounds(75, 150, 200, 50);
     btnTgt.setText("Ficha usuario");
     btnLista.setBounds(75, 250, 200, 50);
     btnLista.setText("Ranking");
     btnTgt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TargetaUsuario tar=new TargetaUsuario(user);
            }
        });
     btnLista.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Ranking rkng= new Ranking(usuarios);
            }
        });
     
     
    }
    
}
