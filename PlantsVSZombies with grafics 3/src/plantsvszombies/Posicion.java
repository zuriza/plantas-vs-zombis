
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
/**
 * Clase principal para crear el tablero
 * 
 * 
 */
public class Posicion {
    
    /** crea una posición X 
     * 
     */
    private int x;
    /** crea una posicion Y 
     * 
     */
    private int y;
    String impresion="    ";
    /** contructor de la posiciones */
    public Posicion(int x, int y){
        this.x=x;
        this.y=y;
    }
    /**  método get 
     * 
     * @return 
     */
    public int getX(){
        return x;
    }
    /**
     * método get
     * @return 
     */
      /**
     * 
     * @return 
     */
    public int getY(){
        return y;
    }
    /**
     * método set
     * @param x 
     */
    public void setX(int x){
        this.x=x;
    }
    /**
     * método set
     * @param y 
     */
    public void setY(int y){
        this.y=y;
    }
    /** Creamos un toString para returnar el valor de impresión cuando lo llamemos
     * @return  */
    @Override
    public String toString(){
        return impresion;
    }
}
