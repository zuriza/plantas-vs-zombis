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
public class Cherry extends Planta {
        /** el coste de la producción de una lanzaguisantes
     * 
     */
    static int coste=50;

    /** especificamos las variables del contructor gracias a la herencia de planta
     * 
     * @param x
     * @param y 
     */
    public Cherry (int x,int y){
        super(x,y);
        this.setComportamiento("Petacereza que tras estar lista explota dañando "+ "todo su alrededor");
        this.setVidas(2);
        this.impresion="P("+this.getVidas()+")";
      
        this.setDaño(10);
        this.setFrecuencia(0);
    }
    /** para sobreescribir el tablero segun el estado del lanzaguisantes
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "P("+this.getVidas()+")";
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

    

