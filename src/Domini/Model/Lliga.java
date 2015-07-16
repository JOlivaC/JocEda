package Domini.Model;

import java.util.Set;

public class Lliga {
	
	private int ID;
	private Set<Partida> partides;
	public Lliga(){}
	public Lliga(int iD, Set<Partida> partides) {
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
	public Set<Partida> getPartides() {
		return partides;
	}
	public void setPartides(Set<Partida> partides) {
		this.partides = partides;
	}
	
	
}
