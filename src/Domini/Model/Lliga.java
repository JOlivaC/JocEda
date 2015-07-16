package Domini.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lliga {
	
	private int ID;
	private List<Partida> partides;
	public Lliga(){
		partides = new ArrayList<>();
	}
	public Lliga(int iD, List<Partida> partides) {
		super();
		ID = iD;
		this.partides = partides;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public List<Partida> getPartides() {
		return partides;
	}
	public void setPartides(List<Partida> partides) {
		this.partides = partides;
	}
	
	
}
