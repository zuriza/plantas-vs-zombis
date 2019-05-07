
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
/**
 * descripcion del movimiento y stats de un zombie
 */
public class ZombieComun extends Zombies{
    /** especificamos las variables del contructor gracias a la herencia
     * 
     * @param x
     * @param y 
     */
    public ZombieComun(int x, int y){
        super(x,y);
        this.setDaño(1);//Daño por turno la la planta que tiene delante
        this.setComportamiento("Avanza y come plantas"); // su comportamiento
        this.setVelocidad(2);//Cada cuantos turnos avanza una casilla
        this.setVida(5);//Puntos de vida que tiene
        this.impresion="Z("+this.getVida()+")"; // esto será lo q se imprima dentro tablero 
        
    }
    /** método que hacen que avance los zombis
     * 
     * @return 
     */
    public boolean Avanzar(){
        int velocidad=this.getVelocidad();
        velocidad--;
        if(velocidad==0){
            this.setVelocidad(2);
            return true;
        }else{
            this.setVelocidad(velocidad);
            return false;
        }
    }
    /** para ir actualizando la vida cada turno
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "Z("+this.getVida()+")";
    }
      /** para ir actualizando la vida cada turno
       * 
       * @param daño 
       */
    public void takeDaño(int daño){
        this.setVida(this.getVida()-daño);
    }
    
    
    
}
