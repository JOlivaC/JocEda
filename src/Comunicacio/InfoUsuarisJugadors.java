package Comunicacio;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class InfoUsuarisJugadors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
