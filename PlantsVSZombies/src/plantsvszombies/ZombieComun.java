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
public class ZombieComun extends Zombies{
    public ZombieComun(int x, int y){
        super(x,y);
        this.setDaño(1);//Daño por turno la la planta que tiene delante
        this.setComportamiento("Avanza y come plantas");
        this.setVelocidad(2);//Cada cuantos turnos avanza una casilla
        this.setVida(5);//Puntos de vida que tiene
        
    }
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
    @Override
    public String toString(){
        return "Z("+this.getVida()+")";
    }
    public void takeDaño(int daño){
        this.setVida(this.getVida()-daño);
    }
    
    
    
}
