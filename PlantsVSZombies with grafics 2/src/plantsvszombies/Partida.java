
package plantsvszombies;

import java.util.*;

/**
 *
 * @author Miguel Y Ricardo
 *
 */
/**
 * Bucle principal donde se ejecuta la partida
 * 
 * 
 */

public class Partida {
    /** creamos variable de tipo enum para que sea más restringida y contenga menos errores*/
    private enum orden{
        L,G,P,N,S,AYUDA,ENTER{
            /** hacemos este override para sobreescribir esta orden y que funcione cuando se pulse enter sin
             *  escribir nada
             */
            @Override
            public String toString(){
                return "";
            }
        }
    }
    /** dificultad que tendrá la partida 
     * 
     */
    private final Dificultad dificultad; 
    
    /** el tablero que verás por pantalla 
     * 
     */
    private final Tablero tablero; 
    
     /** variable que entra por teclado que se utilizará para compararse 
      * 
      */
    private final Scanner entrada=new Scanner(System.in);
    
    /** numeros de zombies 
     * 
     */
    private int nZombies;
    
    /** numeros de turnos 
     * 
     */
    private int nTurnos;
    
    /** numero que se usará para saber si entra un zombi o no 
     * 
     */
    private Random aleatorio=new Random();
    
    /** para saber cuando vienen los zombis 
     * 
     */
    private final int nTurnosConZ;
    
    /** cuando turnos iniciales sin zombis */
    private final int nTurnosSinZ; 
    
    /** para inicializar la partida si se convierte en falsa acaba
     * 
     */
    private boolean corriendo=true; 
    
    private boolean zombisentablero=true;
    /** para rellenar los objetos que mueran en el juego 
     * 
     */
    private ArrayList<Posicion> muertos =new ArrayList<>();
    
    /**cantidad de soles que quedan
     * 
     */
    private int soles;
    
    /** Miran si ya se ha colocado un girasol o un 
     * 
     */
    private boolean lanzagcol; 
    
    /** lanzaguisantes en este turno. 
     * 
     */
    private boolean girasolcol;
    
    /**Llevan la cuenta y almacenan los objetos que se han colocado en el tablero 
     * 
     */
    private boolean petacereza; 
    private boolean nuez; 
    private ArrayList<Girasol> girasoles= new ArrayList<>();
    /**Llevan la cuenta y almacenan los objetos que se han colocado en el tablero 
     * 
     */
    private ArrayList<Lanza_guisantes> lanza_guisantes= new ArrayList<>();
    private ArrayList<Cherry> cherry= new ArrayList<>();
    private ArrayList<Nuez> Nueces= new ArrayList<>();
    /**Llevan la cuenta y almacenan los objetos que se han colocado en el tablero 
     * 
     */
    private ArrayList<ZombieComun> zombies= new ArrayList<>();  
    private ArrayList<ZombieCaracubo> zombies1= new ArrayList<>(); 
    private ArrayList<ZombieDeportista> zombies2= new ArrayList<>(); 
    /**
     * empezamos la partida con un tablero y una dificultad
     * @param tabl
     * @param diff 
     */
    public Partida(Tablero tabl, Dificultad diff){
        /** iniciamos las variables que antes creamos, ya sea con un simple valor o llamando a 
         *  otras funciones
         */
        soles=50;
        nTurnos=0;
        tablero=tabl;
        dificultad=diff;
        nZombies=diff.getNZombies();
        nTurnosConZ=diff.getNTurnos();
        nTurnosSinZ=diff.getTurnosSinZombies();
        /** comparamos la variable corriendo y empieza a imprimir el tablero 
         * 
         */
        while(corriendo==true){
            nTurnos+=1;
            System.out.println("Soles: "+ soles);
            tablero.ImprimirTabliero();
            System.out.println("Turno: "+ nTurnos);
            lanzagcol=false;
            girasolcol=false;
            petacereza=false;
            nuez=false;
            /** una vez que está impreso el tablero pedimos ordenes por teclado
             * 
             */
            while(true){
                String mensage=entrada.nextLine();
                String[] ord= mensage.split(" ");
                /** si es igual a enter se sale
                 * 
                 */
                if (ord[0].equalsIgnoreCase(orden.ENTER.toString())){
                
                    break;   
                /** si es igual a C crea una posicion con un petacereza en la posicion indicada
                 * 
                 */
                }else if(ord[0].equalsIgnoreCase(orden.P.toString())){  
                    /** para capturar un posible error
                     * 
                     */
                    try{
                     /** comparamos que tengas el coste necesarios de soles y se hace llamada a las funciones
                      * para que se imprima en el lugar correcto
                      */
                      
                    if(petacereza==false&&soles>=Cherry.coste){
                        
                        
                        int x=Integer.parseInt(mensage.substring(2, 3));
                        if(x==tablero.getX()-1){
                            throw (new ExcepcionPlanta());
                        }
                        int y=Integer.parseInt(mensage.substring(4,5));
                        
                        Cherry cher= new Cherry(x,y);
                        
                        boolean insertado=tablero.InsertarObjeto(cher);
                        
                        cherry.add(cher);
                        if(insertado==true){
                        soles=soles-Cherry.coste;    
                        petacereza=true;
                        }
                    /** si alguna orden de las anteriores no se cumple se procederá a este else
                     * 
                     */
                    }else{
                        System.out.println("No se puede colocar la petacereza");
                    }
                    /** para capturar el error cuando por teclado no se indique una orden correcta
                     * 
                     */
                    }catch(StringIndexOutOfBoundsException c){
                        System.out.println("Orden no validaº\n"
                                + "Formato: C <x> <y>");
                 
                    }catch(ArrayIndexOutOfBoundsException d){
                        System.out.println("Orden no valida\n"
                                + "Tablero demasiado pequeño");
                    }catch(NumberFormatException e){
                        System.out.println("Orden no valida necesaria posicion");
                    }catch(ExcepcionPlanta a){
                        System.out.println("Orden no valida;\nLas plantas no "
                                + "pueden colocarse en la ultima columna");
                    }  
                /** esto hará que cuando uno no sepa que ordenes poner, le salga por pantalla las instrucciones
                 * 
                 */
                }else if(ord[0].equalsIgnoreCase(orden.N.toString())){  
                    /** para capturar un posible error
                     * 
                     */
                    try{
                     /** comparamos que tengas el coste necesarios de soles y se hace llamada a las funciones
                      * para que se imprima en el lugar correcto
                      */
                      
                    if(nuez==false&&soles>=Nuez.coste){
                        
                        
                        int x=Integer.parseInt(mensage.substring(2, 3));
                        if(x==tablero.getX()-1){
                            throw (new ExcepcionPlanta());
                        }
                        int y=Integer.parseInt(mensage.substring(4,5));
                        
                        Nuez nue= new Nuez(x,y);
                        
                        boolean insertado=tablero.InsertarObjeto(nue);
                        
                        Nueces.add(nue);
                        if(insertado==true){
                        soles=soles-Nuez.coste;    
                        nuez=true;
                        }
                    /** si alguna orden de las anteriores no se cumple se procederá a este else
                     * 
                     */
                    }else{
                        System.out.println("No se puede colocar Nuez");
                    }
                    /** para capturar el error cuando por teclado no se indique una orden correcta
                     * 
                     */
                    }catch(StringIndexOutOfBoundsException c){
                        System.out.println("Orden no validaº\n"
                                + "Formato: N <x> <y>");
                 
                    }catch(ArrayIndexOutOfBoundsException d){
                        System.out.println("Orden no valida\n"
                                + "Tablero demasiado pequeño");
                    }catch(NumberFormatException e){
                        System.out.println("Orden no valida necesaria posicion");
                    }catch(ExcepcionPlanta a){
                        System.out.println("Orden no valida;\nLas plantas no "
                                + "pueden colocarse en la ultima columna");
                    }  
                /** esto hará que cuando uno no sepa que ordenes poner, le salga por pantalla las instrucciones
                 * 
                 */
                }else if(ord[0].equalsIgnoreCase(orden.L.toString())){  
                    /** para capturar un posible error
                     * 
                     */
                    try{
                     /** comparamos que tengas el coste necesarios de soles y se hace llamada a las funciones
                      * para que se imprima en el lugar correcto
                      */
                      
                    if(lanzagcol==false&&soles>=Lanza_guisantes.coste){
                        
                        
                        int x=Integer.parseInt(mensage.substring(2, 3));
                        if(x==tablero.getX()-1){
                            throw (new ExcepcionPlanta());
                        }
                        int y=Integer.parseInt(mensage.substring(4,5));
                        
                        Lanza_guisantes lanzag= new Lanza_guisantes(x,y);
                        
                        boolean insertado=tablero.InsertarObjeto(lanzag);
                        
                        lanza_guisantes.add(lanzag);
                        if(insertado==true){
                        soles=soles-Lanza_guisantes.coste;    
                        lanzagcol=true;
                        }
                    /** si alguna orden de las anteriores no se cumple se procederá a este else
                     * 
                     */
                    }else{
                        System.out.println("No se puede colocar el lanzaguisantes");
                    }
                    /** para capturar el error cuando por teclado no se indique una orden correcta
                     * 
                     */
                    }catch(StringIndexOutOfBoundsException c){
                        System.out.println("Orden no validaº\n"
                                + "Formato: L <x> <y>");
                 
                    }catch(ArrayIndexOutOfBoundsException d){
                        System.out.println("Orden no valida\n"
                                + "Tablero demasiado pequeño");
                    }catch(NumberFormatException e){
                        System.out.println("Orden no valida necesaria posicion");
                    }catch(ExcepcionPlanta a){
                        System.out.println("Orden no valida;\nLas plantas no "
                                + "pueden colocarse en la ultima columna");
                    }  
                /** esto hará que cuando uno no sepa que ordenes poner, le salga por pantalla las instrucciones
                 * 
                 */
                }else if(ord[0].equalsIgnoreCase(orden.AYUDA.toString())){
                    
                    System.out.println("Colocar Lanzaguisantes: L <x> <y>\n"
                        +"Colocar girasol: G <x> <y>\n"
                        +"Colocar Nuez: N <x> <y>\n"
                        +"Colocar Petacereza: C <x> <y>\n"
                        +"Terminar turno: ENTER\n"
                        + "Salir: S \n ");
                /** si es igual a G crea una posicion con un girasol en la posicion indicada
                 * 
                 */
                }else if(ord[0].equalsIgnoreCase(orden.G.toString())){
                    /** para capturar un posible error
                     * 
                     */
                    try{
                        /** comparamos que tengas el coste necesarios de soles y se hace llamada a las funciones
                         * para que se imprima en el lugar correcto
                         */
                        
                        if (girasolcol==false&&soles>Girasol.coste){ 
                            soles= soles-Girasol.coste;
                       
                            int x=Integer.parseInt(mensage.substring(2, 3));
                            if(x==tablero.getX()){
                                throw(new ExcepcionPlanta());
                            }
                            int y=Integer.parseInt(mensage.substring(4,5));
                        
                            Girasol girasol= new Girasol(x,y);
                        
                            boolean insertado=tablero.InsertarObjeto(girasol);
                        
                        girasoles.add(girasol);
                            if(insertado==true){
                                girasolcol=true;
                            }
                       /** si alguna orden de las anteriores no se cumple se procederá a este else
                        * 
                        */
                        }else{
                            System.out.println("Ya se ha colocado un girasol este turno");
                        }
                    /** para aquellos errores que salgan del try sean capturados
                     * 
                     */
                    }catch(StringIndexOutOfBoundsException c){
                        System.out.println("Orden no valida\n"
                                + "Formato: G <x> <y>");
                 
                    }catch(ArrayIndexOutOfBoundsException d){
                        System.out.println("Orden no valida\n"
                                + "Tablero demasiado pequeño");
                    }catch(NumberFormatException e){
                        System.out.println("Orden no valida necesaria posicion");
                    }catch(ExcepcionPlanta a){
                        System.out.println("Orden no valida\n"
                                + "Las plantas no pueden colocarse en la ultima columna");
                    }
                /** para salir del programa
                 * 
                 */ 
                }else if(ord[0].equalsIgnoreCase(orden.S.toString())){
                    corriendo=false;
                    break;
                }else{
                    System.out.print("Orden no valida\n <AYUDA> para ver los comandos"
                        + " posibles");
                    } 
                }
            /** 
             * Aquí indicamos cuantas rondas y zombies hay por tablero, esto dependerá de la dificultad que
             * se indique
             */
            if(nTurnos>nTurnosSinZ&&nZombies>0&&nTurnos<nTurnosConZ){
                switch (dificultad.getDiff()) {
                    case FACIL:
                        int aleatorio4=aleatorio.nextInt(100);
                        int aleatorio9=aleatorio.nextInt(65);
                        if (aleatorio4<24){
                            if (aleatorio9<=21){                         
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                    ,aleatorio.nextInt(tablero.getY()));
                                tablero.InsertarObjeto(zombie1);
                                zombies.add(zombie1);
                                nZombies-=1;
                            }else if (aleatorio9<=43 && aleatorio9 >21){
                            
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                    ,aleatorio.nextInt(tablero.getY()));
                                tablero.InsertarObjeto(zombie1);
                                zombies.add(zombie1);
                                nZombies-=1;
                            }else if (aleatorio9<=65 && aleatorio9 >43){
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                    ,aleatorio.nextInt(tablero.getY()));
                                tablero.InsertarObjeto(zombie1);
                                zombies.add(zombie1);
                                nZombies-=1;
                            }
                        }
                        break;
                    case MEDIA:
                        int aleatorio3=aleatorio.nextInt(100);
                        int aleatorio8=aleatorio.nextInt(65);
                        if (aleatorio3<64){
                            if (aleatorio8<=21){                         
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                    ,aleatorio.nextInt(tablero.getY()));
                                tablero.InsertarObjeto(zombie1);
                                zombies.add(zombie1);
                                nZombies-=1;
                            }else if (aleatorio8<=43 && aleatorio8 >21){
                            
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                    ,aleatorio.nextInt(tablero.getY()));
                                tablero.InsertarObjeto(zombie1);
                                zombies.add(zombie1);
                                nZombies-=1;
                            }else if (aleatorio8<=65 && aleatorio8 >43){
                            ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                    ,aleatorio.nextInt(tablero.getY()));
                                tablero.InsertarObjeto(zombie1);
                                zombies.add(zombie1);
                                nZombies-=1;
                            }
                        }
                        break;
                    case ALTA:
                        int aleatorio5=aleatorio.nextInt(65);
                        if (aleatorio5<=21){
                        ZombieComun zombie1=new ZombieComun(tablero.getX()-1
                                ,aleatorio.nextInt(tablero.getY()));
                            tablero.InsertarObjeto(zombie1);
                            zombies.add(zombie1);
                            nZombies-=1;
                        }else if (aleatorio5<=43 && aleatorio5 >21){
                            ZombieDeportista zombie2=new ZombieDeportista(tablero.getX()-1
                                ,aleatorio.nextInt(tablero.getY()));
                            tablero.InsertarObjeto(zombie2);
                            zombies2.add(zombie2);
                            nZombies-=1;
                        }else if (aleatorio5<=65 && aleatorio5 >43){
                            ZombieCaracubo zombie2=new ZombieCaracubo(tablero.getX()-1
                                ,aleatorio.nextInt(tablero.getY()));
                            tablero.InsertarObjeto(zombie2);
                            zombies1.add(zombie2);
                            nZombies-=1;
                        }
                        break;
                    case IMPOSIBLE:
                        int aleatorio1= aleatorio.nextInt(tablero.getY());
                        int aleatorio2= aleatorio.nextInt(tablero.getY());
                        int aleatorio7=aleatorio.nextInt(65);
                         if (aleatorio7<=21){
                        ZombieComun zombie2=new ZombieComun(tablero.getX()-1
                                ,aleatorio1);
                            tablero.InsertarObjeto(zombie2);
                            zombies.add(zombie2);
                        while(aleatorio1==aleatorio2){
                            aleatorio2=aleatorio.nextInt(tablero.getY());
                        }
                        ZombieComun zombie3=new ZombieComun(tablero.getX()-1
                                ,aleatorio2);
                            tablero.InsertarObjeto(zombie3);
                            zombies.add(zombie3);
                        nZombies-=2;
                         } else if (aleatorio7<=43 && aleatorio7 >21){
                        ZombieDeportista zombie2=new ZombieDeportista(tablero.getX()-1
                                ,aleatorio1);
                            tablero.InsertarObjeto(zombie2);
                            zombies2.add(zombie2);
                        while(aleatorio1==aleatorio2){
                            aleatorio2=aleatorio.nextInt(tablero.getY());
                        }
                        ZombieComun zombie3=new ZombieComun(tablero.getX()-1
                                ,aleatorio2);
                            tablero.InsertarObjeto(zombie3);
                            zombies.add(zombie3);
                        nZombies-=2;
                         }else if (aleatorio7<=65 && aleatorio7 >43){
                        ZombieCaracubo zombie2=new ZombieCaracubo(tablero.getX()-1
                                ,aleatorio1);
                            tablero.InsertarObjeto(zombie2);
                            zombies1.add(zombie2);
                        while(aleatorio1==aleatorio2){
                            aleatorio2=aleatorio.nextInt(tablero.getY());
                        }
                        ZombieComun zombie3=new ZombieComun(tablero.getX()-1
                                ,aleatorio2);
                            tablero.InsertarObjeto(zombie3);
                            zombies.add(zombie3);
                        nZombies-=2;
                         }
                        break;
                }    
            }
            
            /**Empieza aqui el turno
             * 
             */
            /**
             * Almacenamiento de soles 
             */
            girasoles.forEach((girasol) -> {
                soles+=girasol.genSoles();
            });
            
            /**
             *Atacan los lanzaguisantes
             */
            for (Cherry cherrys : cherry) {
                for (int i = (cherrys.getX()-1); i < (cherrys.getX()+1); i++) {
                    for (int j = (cherrys.getY()-1); j < (cherrys.getY()+1); j++){
                        if(tablero.getTablero(i,j).impresion.substring(0, 1).equals("Z") ){
                                System.out.println("GOLPE");
                                ZombieComun zombie=(ZombieComun) tablero.getTablero(i,j);
                                zombie.takeDaño(10);
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                        }else if (tablero.getTablero(i,j).impresion.substring(0, 1).equals("C")){
                            System.out.println("GOLPE");
                                ZombieCaracubo zombie=(ZombieCaracubo) tablero.getTablero(i,j);
                                zombie.takeDaño(10);
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                            
                        }else if (tablero.getTablero(i,j).impresion.substring(0, 1).equals("D")){
                            System.out.println("GOLPE");
                                ZombieDeportista zombie=(ZombieDeportista) tablero.getTablero(i,j);
                                zombie.takeDaño(10);
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                            
                        }
                            
                    }
       
                }
            }
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
                        }else if (tablero.getTablero(i,lanza_guisante.getY())
                                .impresion.substring(0, 1).equals("C")){
                            System.out.println("GOLPE");
                                ZombieCaracubo zombie=(ZombieCaracubo) tablero.getTablero(i,lanza_guisante.getY());
                                zombie.takeDaño(1);
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                        }else if (tablero.getTablero(i,lanza_guisante.getY())
                                .impresion.substring(0, 1).equals("C")) {
                                System.out.println("GOLPE");
                                ZombieDeportista zombie=(ZombieDeportista) tablero.getTablero(i,lanza_guisante.getY());
                                zombie.takeDaño(1);
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                    }
                        
                    }
       
                
            }
            for (Nuez nue : Nueces) {

                for (int i = 0; i < tablero.getX(); i++) {
                        if(tablero.getTablero(i,nue.getY())
                                .impresion.substring(0, 1).equals("Z")){
                                ZombieComun zombie=(ZombieComun) tablero.getTablero(i,nue.getY());
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                        }else if (tablero.getTablero(i,nue.getY())
                                .impresion.substring(0, 1).equals("C")){
                            ZombieCaracubo zombie=(ZombieCaracubo) tablero.getTablero(i,nue.getY());
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                        }else if (tablero.getTablero(i,nue.getY())
                                .impresion.substring(0, 1).equals("D")){
                            ZombieDeportista zombie=(ZombieDeportista) tablero.getTablero(i,nue.getY());
                                tablero.InsertarVacio(zombie.getX(), zombie.getY());
                                tablero.InsertarObjeto(zombie);
                                break;
                        }
                }
            }
            /**
             *Se mueven o atacan los zombies
             */
            zombies.forEach((zombi) -> {                
                Posicion a=tablero.getTablero(zombi.getX()-1, zombi.getY());
                if (a.impresion.substring(0, 1).equals("G")||
                        a.impresion.substring(0, 1).equals("L")||
                        a.impresion.substring(0, 1).equals("P")||
                        a.impresion.substring(0, 1).equals("N")){
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
            zombies1.forEach((zombi) -> {                
                Posicion a=tablero.getTablero(zombi.getX()-1, zombi.getY());
                if (a.impresion.substring(0, 1).equals("G")||
                        a.impresion.substring(0, 1).equals("L")||
                        a.impresion.substring(0, 1).equals("P")||
                        a.impresion.substring(0, 1).equals("N")){
                    Planta planta=(Planta)tablero.getTablero(zombi.getX()-1, zombi.getY());
                    planta.takeDaño(1);
                    System.out.println(planta.getVidas());
                    tablero.InsertarVacio(planta.getX(), planta.getY());
                    tablero.InsertarObjeto(planta);
                }else if(a.impresion.substring(0, 1).equals("C")==false){
                    zombi.setX(zombi.getX()-1);
                    tablero.InsertarObjeto(zombi);
                    tablero.InsertarVacio(zombi.getX()+1, zombi.getY());
                }
            });
            zombies2.forEach((zombi) -> {                
                Posicion a=tablero.getTablero(zombi.getX()-1, zombi.getY());
                if (a.impresion.substring(0, 1).equals("G")||
                        a.impresion.substring(0, 1).equals("L")||
                        a.impresion.substring(0, 1).equals("P")||
                        a.impresion.substring(0, 1).equals("N")){
                    Planta planta=(Planta)tablero.getTablero(zombi.getX()-1, zombi.getY());
                    planta.takeDaño(1);
                    System.out.println(planta.getVidas());
                    tablero.InsertarVacio(planta.getX(), planta.getY());
                    tablero.InsertarObjeto(planta);
                }else if(a.impresion.substring(0, 1).equals("D")==false){
                    zombi.setX(zombi.getX()-1);
                    tablero.InsertarObjeto(zombi);
                    tablero.InsertarVacio(zombi.getX()+1, zombi.getY());
                }
            });
            /** Eliminar los girasoles cuando no tengan vida y se añaden a una arrayList de muertos
             * 
             */
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
              /** Eliminar los zombies cuando no tengan vida y se añaden a una arrayList de muertos
               * 
               */
            for(ZombieComun zombi: zombies){
                if (zombi.getVida()<=0){
                    tablero.InsertarVacio(zombi.getX(), zombi.getY());
                    muertos.add(zombi);
                }
            }
            for(ZombieCaracubo zombi: zombies1){
                if (zombi.getVida()<=0){
                    tablero.InsertarVacio(zombi.getX(), zombi.getY());
                    muertos.add(zombi);
                }
            }
            for(ZombieDeportista zombi: zombies2){
                if (zombi.getVida()<=0){
                    tablero.InsertarVacio(zombi.getX(), zombi.getY());
                    muertos.add(zombi);
                }
            }
            muertos.forEach((pos)->{
                zombies.remove(pos);
            });
            muertos.clear();
            /** Eliminar los lanzaguisantes cuando no tengan vida y se añaden a una arrayList de muertos
             * 
             */
            for(Lanza_guisantes lanzag: lanza_guisantes){
                if (lanzag.getVidas()<=0){
                    tablero.InsertarVacio(lanzag.getX(), lanzag.getY());
                    muertos.add(lanzag);
                }
            }
            muertos.forEach((pos)->{
                lanza_guisantes.remove(pos);
            });
            muertos.clear();
            
            for(Cherry cher: cherry){
                if (cher.getVidas()<=0){
                    tablero.InsertarVacio(cher.getX(), cher.getY());
                    muertos.add(cher);
                }
            }
            muertos.forEach((pos)->{
                cherry.remove(pos);
            });
            muertos.clear();
            
            for(Nuez nu: Nueces){
                if (nu.getVidas()<=0){
                    tablero.InsertarVacio(nu.getX(), nu.getY());
                    muertos.add(nu);
                }
            }
            muertos.forEach((pos)->{
                lanza_guisantes.remove(pos);
            });
            muertos.clear();
            /** metodo para saber cuando los zombies gan ganado
             * 
             */
            for (int i = 0; i < tablero.getY(); i++) {
                if(tablero.getTablero(0, i).impresion.substring(0,1).
                        equals("Z")||tablero.getTablero(0, i).impresion.substring(0,1).
                        equals("C")||tablero.getTablero(0, i).impresion.substring(0,1).
                        equals("D")){
                    System.out.println("Partida terminada, ZOMBIES ganan.");
                    tablero.ImprimirTabliero();
                    corriendo=false;
                } 
            }
            /** metodo para saber cuando has ganado
             * 
             */
            if((tablero.nZom_enTablero()==0&&nZombies==0)||(tablero.nZom_enTablero()==0&&nTurnos>nTurnosConZ)){
                System.out.println("Partida terminada, JUGADOR gana.");
            }
        }           
    }
}


