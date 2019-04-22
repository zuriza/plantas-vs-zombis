/*
 * Bucle principal donde se ejecuta la partida
 * 
 * 
 */
package plantsvszombies;

import java.util.*;

/**
 *
 * @author Miguel
 */
public class Partida {
    private enum orden{
        L,G,S,AYUDA{
            @Override
            public String toString(){
                return"A";
            }
        },ENTER{
            @Override
            public String toString(){
                return "E";
            }
        }
    }
    private final Dificultad dificultad;
    private final Tablero tablero;
    private final Scanner entrada=new Scanner(System.in);
    private int nZombies;
    private int nTurnos;
    private Random aleatorio=new Random();
    private final int nTurnosConZ;
    private final int nTurnosSinZ;
    private boolean corriendo=true;
    private boolean zombisentablero=true;
    private ArrayList<Posicion> muertos =new ArrayList<>();
    private int soles;//cantidad de soles que quedan
    private boolean lanzagcol; // Miran si ya se ha colocado un girasol o un
    private boolean girasolcol;// lanzaguisantes en este turno.
    private ArrayList<Girasol> girasoles= new ArrayList<>();              //Llevan la cuenta y almacenan 
    private ArrayList<Lanza_guisantes> lanza_guisantes= new ArrayList<>();//los objetos 
    private ArrayList<ZombieComun> zombies= new ArrayList<>();            //que se han colocado en el tablero
    public Partida(Tablero tabl, Dificultad diff){
        soles=50;
        nTurnos=0;
        tablero=tabl;
        dificultad=diff;
        nZombies=diff.getNZombies();
        nTurnosConZ=diff.getNTurnos();
        nTurnosSinZ=diff.getTurnosSinZombies();
        while(corriendo==true){
            nTurnos+=1;
            System.out.println("Soles: "+ soles);
            tablero.ImprimirTabliero();
            System.out.println("Turno: "+ nTurnos + " Quedan "+nZombies+" zombies por salir");
            lanzagcol=false;
            girasolcol=false;
            
            while(true){
                String mensage=entrada.nextLine();
                String ord= mensage.substring(0, 1);
                if (ord.equalsIgnoreCase(orden.ENTER.toString())){
                
                    break;   
                
                }else if(ord.equalsIgnoreCase(orden.L.toString())){  
                    if(lanzagcol==false&&soles>=Lanza_guisantes.coste){
                        soles=soles-Lanza_guisantes.coste;
                        
                        int x=Integer.parseInt(mensage.substring(2, 3));
                
                        int y=Integer.parseInt(mensage.substring(4,5));
                        
                        Lanza_guisantes lanzag= new Lanza_guisantes(x,y);
                        
                        boolean insertado=tablero.InsertarObjeto(lanzag);
                        
                        lanza_guisantes.add(lanzag);
                        if(insertado==true){
                            
                        lanzagcol=true;
                        }
                    }else{
                        System.out.println("No se puede colocar el lanzaguisantes");
                    }   
                
                }else if(ord.equalsIgnoreCase(orden.AYUDA.toString())){
                    
                    System.out.println("Colocar Lanzaguisantes: L <x> <y>\n"
                        +"Colocar girasol: G <x> <y>\n"
                        +"Terminar turno: ENTER\n"
                        + "Salir: S \n ");
                }else if(ord.equalsIgnoreCase(orden.G.toString())){
                   if (girasolcol==false&&soles>Girasol.coste){ 
                        soles= soles-Girasol.coste;
                       
                        int x=Integer.parseInt(mensage.substring(2, 3));
                
                        int y=Integer.parseInt(mensage.substring(4,5));
                        
                        Girasol girasol= new Girasol(x,y);
                        
                        boolean insertado=tablero.InsertarObjeto(girasol);
                        
                        girasoles.add(girasol);
                        if(insertado==true){
                            girasolcol=true;
                        }
                       
                   }else{
                       System.out.println("Ya se ha colocado un girasol este turno");
                   }
                
                }else if(ord.equalsIgnoreCase(orden.S.toString())){
                    corriendo=false;
                    break;
                }else{
                    System.out.print("Orden no valida\n <AYUDA> para ver los comandos"
                        + " posibles");
                    } 
                }
            
            if(nTurnos>nTurnosSinZ&&nZombies>0&&nTurnos<nTurnosConZ){
                switch (dificultad.getDiff()) {
                    case FACIL:
                        int aleatorio4=aleatorio.nextInt(100);
                        if(aleatorio4<24){
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                ,aleatorio.nextInt(tablero.getY()));
                            tablero.InsertarObjeto(zombie1); 
                            zombies.add(zombie1);
                            nZombies-=1;
                        }
                        break;
                    case MEDIA:
                        int aleatorio3=aleatorio.nextInt(100);
                        if (aleatorio3<64){
                           ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                ,aleatorio.nextInt(tablero.getY()));
                            tablero.InsertarObjeto(zombie1);
                            zombies.add(zombie1);
                            nZombies-=1;
                        }
                        break;
                    case ALTA:
                        ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                ,aleatorio.nextInt(tablero.getY()));
                            tablero.InsertarObjeto(zombie1);
                            zombies.add(zombie1);
                            nZombies-=1;
                        break;
                    case IMPOSIBLE:
                        int aleatorio1= aleatorio.nextInt(tablero.getY());
                        int aleatorio2= aleatorio.nextInt(tablero.getY());
                        ZombieComun zombie2=new ZombieComun(tablero.getX()-1
                                ,aleatorio1);
                            tablero.InsertarObjeto(zombie2);
                        while(aleatorio1==aleatorio2){
                            aleatorio2=aleatorio.nextInt(tablero.getY());
                        }
                        ZombieComun zombie3=new ZombieComun(tablero.getX()-1
                                ,aleatorio2);
                            tablero.InsertarObjeto(zombie3);
                        nZombies-=2;
                        break;
                }    
            }
            
            //Empieza aqui el turno
            /*
             * Almacenamiento de soles 
             */
            girasoles.forEach((girasol) -> {
                soles+=girasol.genSoles();
            });
            
            /*
             *Atacan los lanzaguisantes
             */
            for (Lanza_guisantes lanza_guisante : lanza_guisantes) {

                for (int i = 0; i < tablero.getX(); i++) {
                        if(tablero.getTablero(i,lanza_guisante.getY())
                                .impresion.substring(0, 1).equals("Z")){
                                System.out.println("GOLPE");
                                ZombieComun zombie=(ZombieComun) tablero.getTablero(i,lanza_guisante.getY());
                                zombie.takeDaño(1);
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                        }
                    }
       
                
            }
            /*
             *Se mueven o atacan los zombies
             */
            zombies.forEach((zombi) -> {                
                Posicion a=tablero.getTablero(zombi.getX()-1, zombi.getY());
                if (a.impresion.substring(0, 1).equals("G")||
                        a.impresion.substring(0, 1).equals("L")){
                    Planta planta=(Planta)tablero.getTablero(zombi.getX()-1, zombi.getY());
                    planta.takeDaño(1);
                    System.out.println(planta.getVidas());
                    tablero.InsertarVacio(planta.getX(), planta.getY());
                    tablero.InsertarObjeto(planta);
                }else if(a.impresion.substring(0, 1).equals("Z")==false){
                    zombi.setX(zombi.getX()-1);
                    tablero.InsertarObjeto(zombi);
                    tablero.InsertarVacio(zombi.getX()+1, zombi.getY());
                }
            });
            for(Girasol girasol: girasoles){
                if (girasol.getVidas()==0){
                    tablero.InsertarVacio(girasol.getX(), girasol.getY());
                    muertos.add(girasol);
                }
            }
            muertos.forEach((pos) -> {
                girasoles.remove(pos);
            });
            muertos.clear();
            
            for(ZombieComun zombi: zombies){
                if (zombi.getVida()==0){
                    tablero.InsertarVacio(zombi.getX(), zombi.getY());
                    muertos.add(zombi);
                }
            }
            muertos.forEach((pos)->{
                zombies.remove(pos);
            });
            muertos.clear();
            
            for(Lanza_guisantes lanzag: lanza_guisantes){
                if (lanzag.getVidas()==0){
                    tablero.InsertarVacio(lanzag.getX(), lanzag.getY());
                    muertos.add(lanzag);
                }
            }
            muertos.forEach((pos)->{
                lanza_guisantes.remove(pos);
            });
            muertos.clear();
            
            for (int i = 0; i < tablero.getY(); i++) {
                if(tablero.getTablero(0, i).impresion.substring(0,1).
                        equals("Z")){
                    System.out.println("Partida terminada, ZOMBIES ganan.");
                    tablero.ImprimirTabliero();
                    corriendo=false;
                } 
            }
            if((tablero.nZom_enTablero()==0&&nZombies==0)||(tablero.nZom_enTablero()==0&&nTurnos>nTurnosConZ)){
                System.out.println("Partida terminada, JUGADOR gana.");
            }
        }           
    }
}

