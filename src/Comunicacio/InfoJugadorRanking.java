package Comunicacio;

public class InfoJugadorRanking extends Tipus implements Comparable {
	private InfoJugadorPosicio Pos;
	private InfoJugadorNPartides N;
	
	
	
	@Override
	public int compareTo(Object o) {
		return ((InfoJugadorRanking) o).Pos.compareTo(Pos); 
	}



	public InfoJugadorPosicio getPos() {
		return Pos;
	}



	public void setPos(InfoJugadorPosicio pos) {
		Pos = pos;
	}



	public InfoJugadorNPartides getN() {
		return N;
	}



	public void setN(InfoJugadorNPartides n) {
		N = n;
	}
	
	
}
