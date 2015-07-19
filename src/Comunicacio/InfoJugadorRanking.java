package Comunicacio;

public class InfoJugadorRanking extends Tipus implements Comparable<Object> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InfoJugadorPosicio Pos;
	private InfoJugadorNPartides N;
	
	
	
	@Override
	public int compareTo(Object o) {
		InfoJugadorRanking x = ((InfoJugadorRanking) o);
		int i = x.Pos.compareTo(Pos); 
		if (i == 0) i = x.Pos.getNom().compareTo(Pos.getNom());
		return i;
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
