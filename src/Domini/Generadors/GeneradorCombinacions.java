/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Generadors;

import java.util.Set;
import java.util.SortedSet;

/**
 *
 * @author JOAN
 */
public class GeneradorCombinacions {
	private int NJug;
	private int NJugPar;
	private int NPar;
    public GeneradorCombinacions(int NJugadors,int NJugadorsPartida,int NPartides){
    	NJug = NJugadors;
    	NJugPar = NJugadorsPartida;
    	NPar = NPartides;
    }
    public SortedSet<Set<Integer>> Generar(){
    	return null;
    }
}
