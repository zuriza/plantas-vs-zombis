
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 * 
 */
/**
 * Hacemos una clase abstraca de la cual extiende de posicion. Esta clase va a denominar variables que van a ser
 * usadas para heredarse
 */
public abstract class Planta extends Posicion{

    /**método get
     * @return the vidas
     * 
     * 
     */
    
    public final int getVidas() {
        return vidas;
    }

    /**método set
     * @param vidas the vidas to set
     */
    public final void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**método get
     * @return the comportamiento
     */
    public final String getComportamiento() {
        return comportamiento;
    }

    /**método set
     * @param comportamiento the comportamiento to set
     */
    public final void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    


    /** método get
     * @return the frecuencia
     */
    public final int getFrecuencia() {
        return frecuencia;
    }

    /**método set
     * @param frecuencia the frecuencia to set
     */
    public final void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**método get
     * @return the daño
     */
    public final int getDaño() {
        return daño;
    }
    /**
     * para saber cuanto daño recibe
     * @param daño 
     */
    public void takeDaño(int daño){
        vidas-=daño;
    }
    /** método set
     * @param daño the daño to set
     */
    public final void setDaño(int daño) {
        this.daño = daño;
    }
    /** la variable que indica la vida*/
    private int vidas;
    /** indica que el funcionamiento de cada planta*/
    private String comportamiento;
    /** la frecuencia de ataque */
    private int frecuencia;
    /** el daño que provoca cada golpe */
    private int daño;
    /** posición de una planta
     * 
     * @param x
     * @param y 
     */
    public Planta(int x, int y){
        super(x,y);
    }
    
}
