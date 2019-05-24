/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantsvszombies;

/**
 *
 * @author Nur_z
 */
public class Nuez extends Planta {
        /** el coste de la producción de una lanzaguisantes
     * 
     */
    static int coste=50;
    /** especificamos las variables del contructor gracias a la herencia de planta
     * 
     * @param x
     * @param y 
     */
    public Nuez(int x,int y){
        super(x,y);
        this.setComportamiento("Nuez que es capaz de resistir los golpes ");
        this.setVidas(10);
        this.impresion="N("+this.getVidas()+")";
      
        this.setDaño(0);
        this.setFrecuencia(0);
    }
    /** para sobreescribir el tablero segun el estado del lanzaguisantes
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "N("+this.getVidas()+")";
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

    

