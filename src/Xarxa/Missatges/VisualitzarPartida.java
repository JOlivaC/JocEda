package Xarxa.Missatges;

public class VisualitzarPartida extends Paquet {
	private int ID;
	public VisualitzarPartida(int ID){this.ID = ID;}
	public boolean EsVisualitzarPartida(){return true;}
	public int getID(){return ID;}
}
