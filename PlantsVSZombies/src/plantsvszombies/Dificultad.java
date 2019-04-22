/*
 * Clase para definir los parametros del juego dependiendo de su dificultad
 */
package plantsvszombies;

/**
 *
 * @author Miguel
 */
public class Dificultad {

    public static enum dificultad{FACIL,MEDIA,ALTA,IMPOSIBLE,INCOMPATIBLE};
    private final dificultad diff;
    private final int nTurnos;//Numero de turnos que dura la partida
    private int nZombies;// Numero de zombies que aparecen durante la partida
    private int tSinZomb;// Numero de turnos de preparacion hasta que aparecen zombies
    private final boolean valido;// Variable para saber si la dificultad recogida es valida
    public Dificultad(String dif){
        nTurnos=30;
        if (dif.equalsIgnoreCase(dificultad.FACIL.toString())){
            nZombies=5;
            tSinZomb=10;
            diff=dificultad.FACIL;
            valido=true;
        }else if(dif.equalsIgnoreCase(dificultad.MEDIA.toString())){
            nZombies=15;
            tSinZomb=7;
            diff=dificultad.MEDIA;
            valido=true;
        }else if(dif.equalsIgnoreCase(dificultad.ALTA.toString())){
            nZombies=25;
            tSinZomb=5;
            diff=dificultad.ALTA;
            valido=true;
        }else if(dif.equalsIgnoreCase(dificultad.IMPOSIBLE.toString())){
            nZombies=50;
            tSinZomb=5;
            diff=dificultad.IMPOSIBLE;
            valido=true;
        }else{
            System.out.println("No es una dificultad valida");
            diff=dificultad.INCOMPATIBLE;
            valido=false;
        }
    }
    public int getNZombies(){
        return nZombies;
    }
    public int getNTurnos(){
        return nTurnos;
    }
    public int getTurnosSinZombies(){
        return tSinZomb;
    }
    public boolean getValido(){
        return valido;
    }
    public dificultad getDiff(){
        return diff;
    }

}
