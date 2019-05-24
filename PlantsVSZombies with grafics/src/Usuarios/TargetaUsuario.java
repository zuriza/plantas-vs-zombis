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
 * @author Usuario
 */
public class TargetaUsuario extends JFrame{
    public TargetaUsuario(Usuario user){
        super.setVisible(true);
        super.setSize(600, 500);
        super.setLocation(1000,1000);
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        super.setTitle("Targeta de usuario de "+user.getNombre());
        
    }
}
class Lamina extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString(TOOL_TIP_TEXT_KEY, WIDTH, WIDTH);
    }
}
