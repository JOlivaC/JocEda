package Comunicacio;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class InfoUsuarisJugadors implements Serializable {
	public InfoUsuarisJugadors(Map<String, Set<String>> info) {
		super();
		this.info = info;
	}
	public InfoUsuarisJugadors(){}

	Map<String,Set<String>> info;

	public Map<String, Set<String>> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Set<String>> info) {
		this.info = info;
	}
	
	
}
