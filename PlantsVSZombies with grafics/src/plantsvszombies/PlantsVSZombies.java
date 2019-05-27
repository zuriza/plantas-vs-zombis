
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
        File datos_usuarios=new File("hashmap.ser");
        
        if(datos_usuarios.exists()){
            try
        {
            FileInputStream file = new FileInputStream("hashmap.ser");
            ObjectInputStream input = new ObjectInputStream(file);
            usuarios = (HashMap) input.readObject();
            input.close();
            file.close();
        }catch(IOException ioe)
            {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
         c.printStackTrace();
        }
        }else{
            
               try {
            FileOutputStream file = new FileOutputStream("hashmap.ser");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(usuarios);
            output.close();
            file.close();
            System.out.printf("Guardado en hashmap.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        }
       
        SelectUser seleccion= new SelectUser(usuarios);
            }  
}
