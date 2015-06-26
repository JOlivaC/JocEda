package Domini.LectorResultat;

public class InfoJugador {
        private String nom;
        private int puntuacio;
        
        public InfoJugador(String n, int p){
            nom = n;
            puntuacio = p;
        }
        
        public String getNom(){
            return nom;
        }
        
        public int getPuntuacio(){
            return puntuacio;
        }
        
        public String toString(){
        	return nom + ": " + String.valueOf(puntuacio);
        }
}
