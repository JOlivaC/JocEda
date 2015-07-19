package Xarxa.Missatges;

import Comunicacio.InfoUsuarisJugadors;

public class VeureProvaResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeureProvaResponse(InfoUsuarisJugadors info) {
		super();
		this.info = info;
	}

	public VeureProvaResponse(Exception e) {
		super(e);
	}

	private InfoUsuarisJugadors info;

	public InfoUsuarisJugadors getInfo() {
		return info;
	}

	public void setInfo(InfoUsuarisJugadors info) {
		this.info = info;
	}

}
