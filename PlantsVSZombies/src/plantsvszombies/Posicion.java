/*
 * Clase principal para crear el tablero
 * 
 * 
 */
package plantsvszombies;

/**
 *
 * @author Miguel
 */
public class Posicion {
    private int x;
    private int y;
    String impresion="    ";
    public Posicion(int x, int y){
        this.x=x;
        this.y=y;
    }
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
    @Override
    public String toString(){
        return impresion;
    }
}
