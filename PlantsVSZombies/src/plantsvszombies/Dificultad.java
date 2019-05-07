
package plantsvszombies;

/**
 *
 * @author Miguel Y Ricardo
 */
/**
 * Clase para definir los parametros del juego dependiendo de su dificultad
 */
public class Dificultad {
    /** los tipos dificultad 
     * 
     */
    public static enum dificultad{FACIL,MEDIA,ALTA,IMPOSIBLE,INCOMPATIBLE}; 
    /** indica la dificultad
     * 
     */
    private final dificultad diff; 
    /**Numero de turnos que dura la partida
     * 
     */
    private final int nTurnos;
    /** Numero de zombies que aparecen durante la partida
     * 
     */
    private int nZombies;
    /** Numero de turnos de preparacion hasta que aparecen zombies
     * 
     */
    private int tSinZomb;
    /** Variable para saber si la dificultad recogida es valida
     * 
     */
    private final boolean valido;
    /** aquí se indica los detalles de cada dificultad
     * 
     * @param dif 
     */
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
    /** método get
     * 
     * @return 
     */
    public int getNZombies(){
        return nZombies;
    }
     /** método get
     * 
     * @return 
     */
    public int getNTurnos(){
        return nTurnos;
    }
     /** método get
     * 
     * @return 
     */
    public int getTurnosSinZombies(){
        return tSinZomb;
    }
     /** método get
     * 
     * @return 
     */
    public boolean getValido(){
        return valido;
    }
     /** método get
     * 
     * @return 
     */
    public dificultad getDiff(){
        return diff;
    }

}
