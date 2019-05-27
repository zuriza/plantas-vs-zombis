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
 * @author Miguel Y Ricardo
 * 
 */
/**
 * 
 * Escribir las puntuaciones
 */
public abstract class  Escritura {
    
    public static void escribirHash(HashMap hash) throws FileNotFoundException, IOException{
        
        ObjectOutputStream canal;
        FileOutputStream file= new FileOutputStream("hashmap.ser");
        canal = new ObjectOutputStream(file);
        canal.writeObject(hash);
        file.close();
        canal.close();
        
    }
}
