
package plantsvszombies;

/**
 *
 * @author Miguel y Ricardo
 */
/**
 * Tablero donde se almacena el estado del juego.
 * 
 * 
 */
public class Tablero {
    /**Array donde se guardan los objetos
     * 
     */
    private final Posicion tablero[][];
    /**String que almacena la linea superior del tablero
     * 
     */
    private String linea_arriba;
    /**Anchura del tablero
     * 
     */
    private final int x;
    /**Altura del tablero
     * 
     */
    private final int y;
    /**Numero de zombies por salir
     * 
     */
    private int nZombies;
    /**Constructor quue se usará para crear el tablero
     * 
     * @param x
     * @param y 
     */
    public Tablero(int x,int y){
        tablero= new Posicion[x][y];
        this.x=x;
        this.y=y;
        this.LlenarTablero();
        this.CrearLineaArriba(x);
        
        
    }
    /**Llena el tablero de posiciones
     * 
     */
    private void LlenarTablero(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablero[i][j]=new Posicion(i,j);
            }
        }
    }
    /**Crea la linea superior
     * 
     * @param x 
     */
    private void CrearLineaArriba(int x){
        linea_arriba="|";
        for (int i = 0; i < x; i++) {
            linea_arriba+="------";
        }
        linea_arriba+="|";
    }
    /**Imprime el tablero
     * 
     */
    public void ImprimirTabliero(){
        System.out.println(linea_arriba);
        for (int i = 0; i < y; i++) {
            System.out.print("| ");
            for (int j = 0; j < x; j++) {
                System.out.print(tablero[j][i].toString());
                System.out.print(" |");
            }
           
        System.out.println();
        System.out.println(linea_arriba);    
        }
    }
    /**método get
     * 
     * @return 
     */
    public int getX(){
        return x;
    }
     /**método get
      * 
      * @return 
      */
    public int getY(){
        return y;
    }
    /** función para imprimir los objetos dentro del tablero e indicar cuando ya está ocupado
     * 
     * @param objeto
     * @return 
     */
    public boolean  InsertarObjeto(Posicion objeto){
        if(tablero[objeto.getX()][objeto.getY()].impresion.equalsIgnoreCase("    ")){
            tablero[objeto.getX()][objeto.getY()]=objeto;
            return true;
        }else{
            System.out.println("Ya existe un"
                    +tablero[objeto.getX()][objeto.getY()].toString()+
                    "en esta posicion");
            return false;
        }
    } 
    /** para convertir un hueco del tablero lleno en vacío
     * 
     * @param x
     * @param y 
     */
    public void InsertarVacio(int x, int y){
        tablero[x][y]=new Posicion(x,y);
    }
      /**método get
       * 
       * @param x
       * @param y
       * @return 
       */
    public Posicion getTablero(int x,int y){
        
        return tablero[x][y];
    }
    /** para saber el numero de zombis 
     * 
     * @return 
     */
    public int nZom_enTablero(){
        int nZom=0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(this.getTablero(i,j).impresion.substring(0, 1).equals("Z")){
                    nZom+=1;
                }
            }
        }
        return nZom;
    }
    
}
