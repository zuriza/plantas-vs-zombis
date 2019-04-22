/*
 * Tablero donde se almacena el estado del juego.
 * 
 * 
 */
package plantsvszombies;

/**
 *
 * @author Miguel
 */
public class Tablero {
    private final Posicion tablero[][];//Array donde se guardan los objetos
    private String linea_arriba;//String que almacena la linea superior del tablero
    private final int x;//Anchura del tablero
    private final int y;//Altura del tablero
    private int nZombies;//Numero de zombies por salir
    public Tablero(int x,int y){
        tablero= new Posicion[x][y];
        this.x=x;
        this.y=y;
        this.LlenarTablero();
        this.CrearLineaArriba(x);
        
        
    }
    private void LlenarTablero(){//Llena el tablero de posiciones
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablero[i][j]=new Posicion(i,j);
            }
        }
    }
    private void CrearLineaArriba(int x){//Crea la linea superior
        linea_arriba="|";
        for (int i = 0; i < x; i++) {
            linea_arriba+="------";
        }
        linea_arriba+="|";
    }
    public void ImprimirTabliero(){//Imprime el tablero
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
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
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
    public void InsertarVacio(int x, int y){
        tablero[x][y]=new Posicion(x,y);
    }
    public Posicion getTablero(int x,int y){
        
        return tablero[x][y];
    }
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
