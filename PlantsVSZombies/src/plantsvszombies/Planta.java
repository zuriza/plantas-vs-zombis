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
public abstract class Planta extends Posicion{

    /**
     * @return the vidas
     */
    public final int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public final void setVidas(int vidas) {
        this.vidas = vidas;
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
     * @return the frecuencia
     */
    public final int getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public final void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * @return the daño
     */
    public final int getDaño() {
        return daño;
    }
    public void takeDaño(int daño){
        vidas-=daño;
    }
    /**
     * @param daño the daño to set
     */
    public final void setDaño(int daño) {
        this.daño = daño;
    }
    private int vidas;
    private String comportamiento;
    private int frecuencia;
    private int daño;
    public Planta(int x, int y){
        super(x,y);
    }
    
}
