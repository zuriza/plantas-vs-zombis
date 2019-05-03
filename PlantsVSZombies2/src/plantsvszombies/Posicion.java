/*
 * Clase principal para crear el tablero
 * 
 * 
 */
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
public class Posicion {
    
    private int x;/** crea una posición X */
    private int y;/** crea una posicion Y */
    String impresion="    ";
    /** contructor de la posiciones */
    public Posicion(int x, int y){
        this.x=x;
        this.y=y;
    }
    /** todos los métodos set y get */
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    /** Creamos un toString para returnar el valor de impresión cuando lo llamemos */
    @Override
    public String toString(){
        return impresion;
    }
}
