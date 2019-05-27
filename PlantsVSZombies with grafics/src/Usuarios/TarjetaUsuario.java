/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Miguel Y Ricardo
 * 
 */
/**
 * 
 * Crea la ventana de ficha usuario y muestra información
 */
public class TarjetaUsuario extends JFrame{
    private final Usuario user;
    private JLabel nomb,dni,pts,p_gan,p_jug;
    
    public TarjetaUsuario(Usuario user){
        this.user=user;
        this.componentes();
        super.setVisible(true);
        super.setLayout(null);
        super.setSize(350, 300);
        super.setLocation(500,500);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setTitle("Targeta de usuario de "+user.getNombre());
        super.setResizable(false); 
        super.add(nomb);
        super.add(dni);
        super.add(pts);
        super.add(p_gan);
        super.add(p_jug);
    }
    private void componentes(){
        nomb=new JLabel();
        nomb.setBounds(30, 30, 100, 20);
        nomb.setText(user.getNombre());
        dni=new JLabel();
        pts=new JLabel();
        p_gan=new JLabel();
        p_jug=new JLabel();
        dni.setBounds(30, 70, 100, 20);
        dni.setText(user.getDNI());
        pts.setBounds(30, 110, 500, 20);
        pts.setText("Puntos: "+ user.getPts());
        p_gan.setBounds(30, 150, 200, 20);
        p_gan.setText("Ha ganado "+user.getP_ganadas()+" partidas.");
        p_jug.setBounds(30, 190, 200, 20);
        p_jug.setText("Ha jugado "+ user.getP_jugadas()+" partidas.");
        
        
    }
}
