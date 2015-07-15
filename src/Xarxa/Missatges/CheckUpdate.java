package Xarxa.Missatges;

public class CheckUpdate extends Paquet{
	private int versio;
	public boolean EsCheckUpdate(){return true;}
	public CheckUpdate(int v){this.versio = v;}
	public int getVersio(){return versio;}
}
