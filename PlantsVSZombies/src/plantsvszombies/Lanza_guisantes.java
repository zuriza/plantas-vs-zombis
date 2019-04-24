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
public class Lanza_guisantes extends Planta{
    static int coste=50;
    public Lanza_guisantes(int x,int y){
        super(x,y);
        this.setComportamiento("Lanza guiantes golpeando al primer enemigo de "
                + "su linea");
        this.setVidas(3);
        this.impresion="L("+this.getVidas()+")";
      
        this.setDaño(1);
        this.setFrecuencia(1);
    }
    @Override
    public String toString(){
        return "L("+this.getVidas()+")";
    }
    @Override
    public void takeDaño(int daño){
        this.setVidas(this.getVidas()-daño);
    }
}
