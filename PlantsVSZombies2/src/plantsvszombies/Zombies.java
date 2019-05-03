/*
 * clase abstracta que indica lo básico de un zombie.
 */
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
public abstract class Zombies extends Posicion{
    public Zombies (int x, int y){
        super(x,y);
    }
    // todos los métodos set y get 
    /**
     * @return the vida
     */
    public final int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public final void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the daño
     */
    public final int getDaño() {
        return daño;
    }

    /**
     * @param daño the daño to set
     */
    public final void setDaño(int daño) {
        this.daño = daño;
    }

    /**
     * @return the comportamiento
     */
    public final String getComportamiento() {
        return comportamiento;
    }

    /**
     * @param comportamiento the comportamiento to set
     */
    public final void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    /**
     * @return the velocidad
     */
    public final int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public final void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    private int vida;// la vida que tienen los zombis
    private int daño; // el daño de cada golpe
    private String comportamiento;
    private int velocidad; // la velocidad que se mueve el zombie en cada turno
    
    
}
