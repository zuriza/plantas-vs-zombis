
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
/**
 * clase abstracta que indica lo básico de un zombie.
 */
public abstract class Zombies extends Posicion{
    /** posición de un zombi
     * 
     * @param x
     * @param y 
     */
    public Zombies (int x, int y){
        super(x,y);
    }
    
    /** método get 
     * @return the vida
     */
    public final int getVida() {
        return vida;
    }

    /**método get 
     * @param vida the vida to set
     */
    public final void setVida(int vida) {
        this.vida = vida;
    }

    /**método get 
     * @return the daño
     */
    public final int getDaño() {
        return daño;
    }

    /**método set 
     * @param daño the daño to set
     */
    public final void setDaño(int daño) {
        this.daño = daño;
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

    /**método get 
     * @return the velocidad
     */
    public final int getVelocidad() {
        return velocidad;
    }

    /**método set 
     * @param velocidad the velocidad to set
     */
    public final void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    /** la vida que tienen los zombis
     * 
     */
    private int vida;
    /** el daño de cada golpe
     * 
     */
    private int daño; 
    private String comportamiento;
    /** la velocidad que se mueve el zombie en cada turno
     * 
     */
    private int velocidad; 
    
    
}
