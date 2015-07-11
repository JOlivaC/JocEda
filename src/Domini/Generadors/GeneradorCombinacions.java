/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Generadors;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

/**
 *
 * @author JOAN
 */
public class GeneradorCombinacions {
	
	private Set<Integer> IDSJugadors;
	private int JugadorsPerPartida;
    public GeneradorCombinacions(Set<Integer> IDSJugadors,int NJugadorsPartida){
    	this.IDSJugadors = IDSJugadors;
    	JugadorsPerPartida = NJugadorsPartida;
    }
    public List<Set<Integer>> Generar() throws Exception{
    	GeneradorJose j = new GeneradorJose();
    	List<Set<Integer>> ret = j.Sort(IDSJugadors.size());
    	return ret;
    }
}
