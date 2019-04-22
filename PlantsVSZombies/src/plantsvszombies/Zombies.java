/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

/**
 *
 * @author Miguel
 */
public abstract class Zombies extends Posicion{
    public Zombies (int x, int y){
        super(x,y);
    }
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
    private int vida;
    private int daño;
    private String comportamiento;
    private int velocidad;
    
    
}
