/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Miguel Y Ricardo
 * 
 */
/**
 * 
 * la ventana donde puede registrarte o logearte
 */

public class SelectUser extends JFrame{
    JButton boton1, boton2;
    JTextField txt1,txt2,txt3;
    JLabel label1,label2,label3;
    Usuario user;
    HashMap<String,Usuario> usuarios;
    public SelectUser(HashMap users){
        
        this.componentes();
        
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(350, 600);
        super.setLocation(500,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("Selecciona una opcion");
        super.setResizable(false);
        super.add(boton1);
        super.add(boton2);
        super.add(txt1);
        super.add(txt2);
        super.add(txt3);
        super.add(label1);
        super.add(label2);
        super.add(label3);
        usuarios=users;
        
        
    }
    private void componentes(){
        boton1=new JButton();
        boton2=new JButton();
        txt1=new JTextField();
        txt2=new JTextField();
        txt3=new JTextField();
        label1=new JLabel();
        label2=new JLabel();
        label3=new JLabel();
        boton1.setBounds(75, 50, 200, 50);
        boton1.setText("Nuevo Usuario");
        boton2.setBounds(75, 300, 200, 50);
        boton2.setText("Usuario existente");
        txt1.setBounds(50, 150, 250, 30);
        label1.setText("Nombre");
        label1.setBounds(150, 120, 100, 30);
        txt2.setBounds(50, 200, 250, 30);
        label2.setText("DNI");
        label2.setBounds(160, 175, 100, 30);
        txt3.setBounds(50, 400, 250, 30);
        label3.setText("DNI");
        label3.setBounds(160, 360, 100, 30);
        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                user=new Usuario(txt1.getText(),txt2.getText());
                if(!(usuarios.containsKey(user.getDNI()))){
                   usuarios.put(user.getDNI(), user);
                   new Inicio(user,usuarios);
                   dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario ya existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(usuarios.containsKey(txt3.getText())){
                    
                    Inicio inicio = new Inicio(usuarios.get(txt3.getText()),usuarios);
                   dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario no existente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

       
        
    }
  
    
}
