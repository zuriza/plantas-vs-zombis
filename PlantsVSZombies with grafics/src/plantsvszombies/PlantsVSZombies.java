
package plantsvszombies;

import java.util.HashSet;
import java.util.Scanner;
import Usuarios.*;
import java.io.*;
import java.util.HashMap;
/**
 *
 * @author Miguel y Ricardo
 */
/** inicio del programa
 * 
 */
public class PlantsVSZombies {
    /**
     * iniciamos 2 variables de tipo enum para reducir los errores del programa y para
     * denominar las dificultades y ordenes que tendrá el programa
     */
    enum dificultad{FACIL,MEDIA,ALTA,IMPOSIBLE};
    enum ordenes{N,S,AYUDA};
    
    /**El procedimiento main donde ejecutará todas nuestras ordenes
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        /**
         * Hashmap para guardar los usuarios
         */
        HashMap <String,Usuario> usuarios=new HashMap();
        Usuario user=new Usuario("","");
        File datos_usuarios=new File("usuarios.txt");
        try{
        if(datos_usuarios.exists()){
            System.out.println(" existe");
            ObjectInputStream canal= new ObjectInputStream(new FileInputStream("usuarios.txt"));
            
            usuarios=(HashMap)canal.readObject();
            
            canal.close();
        }else{
              System.out.println("no existe");
              Escritura.escribirHash(usuarios);
        }
        }catch(IOException | ClassNotFoundException e){
                
                }
        SelectUser seleccion= new SelectUser(usuarios);
            }  
}
