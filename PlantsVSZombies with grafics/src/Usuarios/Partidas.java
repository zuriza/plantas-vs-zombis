/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.*;
import plantsvszombies.Dificultad;
/**
 *
 * @author Miguel Y Ricardo
 * 
 */
/**
 * 
 * Donde se guarda los puntos de la partida
 */
public class Partidas implements Serializable{
    
    /**
     * Cantidad de puntos obtenidos en una partida
     */
    private final int pts;
    /**
     * Dificultad de la partida
     */
    private final Dificultad diff;
    /**
     * Partida ganada o no, si es true la partida esta ganada, si no, esta perdida.
     */
    private final boolean p_ganada;
    /**
     * 
     * @param diff
     * @param pts
     * @param ganada 
     */
    public Partidas(Dificultad diff, int pts, boolean ganada){
        this.diff=diff;
        this.pts=pts;
        this.p_ganada=ganada;
    }
}
