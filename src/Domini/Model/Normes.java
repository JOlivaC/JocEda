package Domini.Model;

public abstract class Normes {
	private static final String UserProhibit = "dummy";
	public static int getPuntsPosicio(int pos,int NParticipants){
		return NParticipants - pos + 1;
	}
	
	public static boolean IsUserValid(String UserName){
		return !UserName.toLowerCase().contains(UserProhibit.toLowerCase());
	}
	
	public static boolean IsPlayerValid(String PlayerName){
		return !PlayerName.toLowerCase().contains(UserProhibit.toLowerCase());
	}
}
