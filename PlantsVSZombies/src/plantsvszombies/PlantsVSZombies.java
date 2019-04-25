
package plantsvszombies;

import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class PlantsVSZombies {
    enum dificultad{FACIL,MEDIA,ALTA,IMPOSIBLE};
    enum ordenes{N,S,AYUDA};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        boolean partida_empezada=false;
        while(true){
           try{
            String mensage= entrada.nextLine();
            String[] a=mensage.split(" ");
        
                   
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
