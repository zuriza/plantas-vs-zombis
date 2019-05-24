/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.*;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public abstract class  Escritura {
    
    public static void escribirHash(HashMap hash) throws FileNotFoundException, IOException{
        
        ObjectOutputStream canal = new ObjectOutputStream(new FileOutputStream("usuarios.txt"));
        canal.writeObject(hash);
        canal.close();
        
    }
}
