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
public class Girasol extends Planta{
    static int coste=20;
    public Girasol(int x,int y){
        super(x,y);
        this.setComportamiento("Crea 20 soles cada 2 turnos");
        this.setVidas(1);
        this.impresion="G("+this.getVidas()+")";
        this.setDaño(0);
        this.setFrecuencia(2);
    }
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
    @Override
    public String toString(){
        return "G("+this.getVidas()+")";
    }
    @Override
    public void takeDaño(int daño){
        this.setVidas(this.getVidas()-daño);
    }
}
