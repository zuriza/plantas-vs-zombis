/*
 * Denominamos esta clase específica de planta que hereda de planta
 */
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
public class Lanza_guisantes extends Planta{
    static int coste=50;// el coste de la producción de una lanzaguisantes
    // especificamos las variables del contructor gracias a la herencia de planta
    public Lanza_guisantes(int x,int y){
        super(x,y);
        this.setComportamiento("Lanza guiantes golpeando al primer enemigo de "
                + "su linea");
        this.setVidas(3);
        this.impresion="L("+this.getVidas()+")";
      
        this.setDaño(1);
        this.setFrecuencia(1);
    }
    // para sobreescribir el tablero segun el estado del lanzaguisantes
    @Override
    public String toString(){
        return "L("+this.getVidas()+")";
    }
    @Override
    public void takeDaño(int daño){
        this.setVidas(this.getVidas()-daño);
    }
}
