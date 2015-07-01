package Dades.Tipus;


public class Resultat extends PartidaJugador{
	private int Posicio;
	private int Puntuacio;
	
	public Resultat(int iDPartida, String nomJugador, int posicio, int puntuacio) {
		super(iDPartida,nomJugador);
		Posicio = posicio;
		Puntuacio = puntuacio;
	}
	public Resultat(){}
	
	
	
	public int getPosicio() {
		return Posicio;
	}
	public void setPosicio(int posicio) {
		Posicio = posicio;
	}
	public int getPuntuacio() {
		return Puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		Puntuacio = puntuacio;
	}

	

}
