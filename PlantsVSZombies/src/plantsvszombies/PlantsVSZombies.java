
package plantsvszombies;

import java.util.Scanner;

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
         *  Variable que será introducida por teclado e inicializamos una variable partida como falsa para
         *  cuando esta sea cambiada a true
         */
        Scanner entrada=new Scanner(System.in);
        boolean partida_empezada=false;
        /**
         * Hacemos un while para comparar las ordenes de teclado con la variable enum
         */
        while(true){
            /**
             * iniciamos un try para capturar los diferentes tipos de error que pueden llegar ocurrir 
             */
           try{
            String mensage= entrada.nextLine();
            String[] a=mensage.split(" ");
        
            /**
             *  si la variable por scanner es igual al ".toString" iniciará el programa cuando sea N o se saldrá
             *  si es S o mostrará los comandos de ayuda con AYUDA. Si se escribe otra cosa que no sea algunas
             *  de las anteriores se capturará el error con los catch
             */       
            if (a[0].equalsIgnoreCase(ordenes.S.toString())){
                
                break;   
                
            }else if(a[0].equalsIgnoreCase(ordenes.N.toString())){
                try{
                    
                int x=Integer.parseInt(a[1]);
                
                int y=Integer.parseInt(a[2]);
                
                Dificultad diff=new Dificultad(a[3]);
                
                if(diff.getValido()==true){
                    Tablero tablero=new Tablero(x,y);
                    Partida partida= new Partida(tablero,diff);
                }
                }catch(StringIndexOutOfBoundsException c){
                    System.out.println("Orden no valida");
                 
                }catch(ArrayIndexOutOfBoundsException d){
                    System.out.println("Orden no valida");
                }catch(NumberFormatException e){
                    System.out.println("Orden no valida");
                }
            }else if(a[0].equalsIgnoreCase(ordenes.AYUDA.toString())){
                System.out.println("Nueva partida: N <x> <y> <dificultad>\n"
                        + "Salir: S \n ");
            }else{
                System.out.print("Orden no valida\n <AYUDA> para ver los comandos"
                        + " posibles");
            }  
           }catch(StringIndexOutOfBoundsException b){
               System.out.println("Orden no valida");
           }
        }              
    }
    
}
