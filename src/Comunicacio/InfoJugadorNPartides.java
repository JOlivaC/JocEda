package Comunicacio;

import java.util.Map;

public class InfoJugadorNPartides extends Tipus {
	private Map<Integer,Integer> Posicions;

	public Map<Integer, Integer> getPosicions() {
		return Posicions;
	}

	public void setPosicions(Map<Integer, Integer> posicions) {
		Posicions = posicions;
	}
}
