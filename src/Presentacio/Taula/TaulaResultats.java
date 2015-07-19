package Presentacio.Taula;

public class TaulaResultats extends Taula {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String ID = "ID";
	private static String Visualitzar = "Visualitzar";
	private static String Resultat = "Resultat";
	private static String Jugador = "J";
	public TaulaResultats(int n){	
		super("Resultats",CrearHeaders(n));
		super.taula.SetEditableRows(getEditableRows(n));
	}
	
	private static String[] CrearHeadersJugadors(int n){
		String[] ret = new String[n];
		for (int i = 0; i < n; i++){
			ret[i] = Jugador + ": " + String.valueOf(i + 1);
		}
		return ret;
	}
	private static boolean[] getEditableRows(int n){
		boolean[] ret = new boolean[3 + n];
		for (int i = 0; i < 1 + n; i++){
			ret[i] = false;
		}
		for (int i = 1 + n; i < n + 3; i ++){
			ret[i] = true;
		}
		
		return ret;
	}
	
	
	private static String[] CrearHeaders(int n){
		String[] j = CrearHeadersJugadors(n);
		String[] ret = new String[3 + n];
		int i = 0;
		ret[i] = ID; i++;
		for (int k = 0; k < n; k ++){
			ret[k + i] = j[k];
		}
		ret[i + n] = Resultat; i++;
		ret[i + n] = Visualitzar;
		
		return ret;
	}
	
	
}
