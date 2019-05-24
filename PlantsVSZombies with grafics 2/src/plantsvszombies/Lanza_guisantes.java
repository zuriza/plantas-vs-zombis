
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
/**
 * Denominamos esta clase específica de planta que hereda de planta
 */
public class Lanza_guisantes extends Planta{
    /** el coste de la producción de una lanzaguisantes
     * 
     */
    static int coste=50;
    /** especificamos las variables del contructor gracias a la herencia de planta
     * 
     * @param x
     * @param y 
     */
    public Lanza_guisantes(int x,int y){
        super(x,y);
        this.setComportamiento("Lanza guiantes golpeando al primer enemigo de "
                + "su linea");
        this.setVidas(3);
        this.impresion="L("+this.getVidas()+")";
      
        this.setDaño(1);
        this.setFrecuencia(1);
    }
    /** para sobreescribir el tablero segun el estado del lanzaguisantes
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "L("+this.getVidas()+")";
    }
        /** para sobreescribir el tablero segun el estado del lanzaguisantes
         * 
         * @param daño 
         */
    @Override
    public void takeDaño(int daño){
        this.setVidas(this.getVidas()-daño);
    }
}
