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
public class ZombieDeportista extends Zombies {
    public ZombieDeportista(int x, int y){
        super(x,y);
        this.setDaño(1);//Daño por turno la la planta que tiene delante
        this.setComportamiento("Avanza y come plantas"); // su comportamiento
        this.setVelocidad(3);//Cada cuantos turnos avanza una casilla
        this.setVida(2);//Puntos de vida que tiene
        this.impresion="D("+this.getVida()+")"; // esto será lo q se imprima dentro tablero 
        
    }
    /** método que hacen que avance los zombis
     * 
     * @return 
     */
    public boolean Avanzar(){
        int velocidad=this.getVelocidad();
        velocidad--;
        if(velocidad==0){
            this.setVelocidad(3);
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
        return "D("+this.getVida()+")";
    }
      /** para ir actualizando la vida cada turno
       * 
       * @param daño 
       */
    public void takeDaño(int daño){
        this.setVida(this.getVida()-daño);
}
}