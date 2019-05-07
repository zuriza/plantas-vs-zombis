
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
/**
 * Denominamos esta clase específica de planta que hereda de planta
 */
public class Girasol extends Planta{
    /** el coste de la producción de un girasol
     * 
     */
    static int coste=20;
    /** especificamos las variables del contructor gracias a la herencia de planta
     * 
     * @param x
     * @param y 
     */
    public Girasol(int x,int y){
        super(x,y);
        this.setComportamiento("Crea 20 soles cada 2 turnos");
        this.setVidas(1);
        this.impresion="G("+this.getVidas()+")";
        this.setDaño(0);
        this.setFrecuencia(2);
    }
    /** método para ganar soles segun la frecuencia de los girasoles
     * 
     * @return 
     */
    public int genSoles(){
        int a = this.getFrecuencia();
        a--;
        if (a==0){
            a+=2;
            this.setFrecuencia(a);
            return 20;
        }else{
            this.setFrecuencia(a);
            return 0;
        }
        
    }
    /** para sobreescribir el tablero segun el estado del lanzaguisantes
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "G("+this.getVidas()+")";
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
