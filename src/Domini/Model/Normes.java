package Domini.Model;

public abstract class Normes {
	
	public static int getPuntsPosicio(int pos,int NParticipants){
		return NParticipants - pos + 1;
	}
}
