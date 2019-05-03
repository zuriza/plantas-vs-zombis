/*
 * Denominamos esta clase específica de planta que hereda de planta
 */
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
public class Girasol extends Planta{
    static int coste=20;// el coste de la producción de un girasol
    // especificamos las variables del contructor gracias a la herencia de planta
    public Girasol(int x,int y){
        super(x,y);
        this.setComportamiento("Crea 20 soles cada 2 turnos");
        this.setVidas(1);
        this.impresion="G("+this.getVidas()+")";
        this.setDaño(0);
        this.setFrecuencia(2);
    }
    // método para ganar soles segun la frecuencia de los girasoles
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
    // para sobreescribir el tablero segun el estado del lanzaguisantes
    @Override
    public String toString(){
        return "G("+this.getVidas()+")";
    }
    @Override
    public void takeDaño(int daño){
        this.setVidas(this.getVidas()-daño);
    }
}
