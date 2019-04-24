/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class PlantsVSZombies {
    enum dificultad{FACIL,MEDIA,ALTA,IMPOSIBLE};
    enum ordenes{N,S,AYUDA{
    @Override
    public String toString(){
        return "A";
    }}};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        boolean partida_empezada=false;
        while(true){
           
            String mensage= entrada.nextLine();
            String tipo_orden=mensage.substring(0, 1);
            if (tipo_orden.equalsIgnoreCase(ordenes.S.toString())){
                
                break;   
                
            }else if(tipo_orden.equalsIgnoreCase(ordenes.N.toString())){
                
                int x=Integer.parseInt(mensage.substring(2, 3));
                
                int y=Integer.parseInt(mensage.substring(4,5));
                
                Dificultad diff=new Dificultad(mensage.substring(6));
                
                if(diff.getValido()==true){
                    Tablero tablero=new Tablero(x,y);
                    Partida partida= new Partida(tablero,diff);
                }
            }else if(tipo_orden.equalsIgnoreCase(ordenes.AYUDA.toString())){
                System.out.println("Nueva partida: N <x> <y> <dificultad>\n"
                        + "Salir: S \n ");
            }else{
                System.out.print("Orden no valida\n <AYUDA> para ver los comandos"
                        + " posibles");
            }           
        }              
    }
    
}
