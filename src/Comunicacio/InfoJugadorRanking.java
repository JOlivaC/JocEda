package Comunicacio;

public class InfoJugadorRanking implements Comparable {
	private InfoJugadorPosicio Pos;
	private InfoJugadorNPartides N;
	
	
	
	@Override
	public int compareTo(Object o) {
		return ((InfoJugadorRanking) o).Pos.compareTo(Pos); 
	}
	
	
}
