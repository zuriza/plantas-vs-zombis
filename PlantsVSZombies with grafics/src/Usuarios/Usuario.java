/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.*;
import java.util.*;
import javax.swing.*;
import plantsvszombies.Dificultad;

/**
 *
 * @author Miguel
 */
public class Usuario implements Serializable {
    
    /**  
     * Nombre identificativo del usuario 
     */
    private final String nombre;
    /**
     * DNI del usuario
     */
    private final String DNI;
    /**
     * Puntos totales que el usuario ha obtenido
     */
    private int pts;
    /**
     * Partidas jugadas por el usuario
     */
    private ArrayList<Partidas> p_jugadas;
    /**
     * Numero de partidas ganadas
     */
    private int p_ganadas;
    public void imprimirTargeta(){
        TargetaUsuario tar= new TargetaUsuario(this);
        
    }
    /**
     * 
     * @param diff
     * @param pts
     * @param ganada 
     */
   
    public void PartidaJugada(Dificultad diff, int pts, boolean ganada){
        p_jugadas.add(new Partidas(diff,pts,ganada));
        this.pts+=pts;
        if(ganada){
            p_ganadas+=1;
        }
    }
    /**
     * 
     * @return 
     */
    public String getDNI(){
        return DNI;
    }
    /**
     * 
     * @return 
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * 
     * @return 
     */
    public int getPts(){
        return pts;
    }
    /**
     * 
     * @return 
     */
    public int getP_jugadas(){
        return p_jugadas.size();
    }
    /**
     * 
     * @return 
     */
    public int getP_ganadas(){
        return p_ganadas;
    }
    /**
     * 
     * @param nomb
     * @param dni 
     */
    public Usuario(String nomb,String dni){
        this.nombre=nomb;
        this.DNI=dni;
        pts=0;
        p_jugadas=new ArrayList();
        
    }
}
