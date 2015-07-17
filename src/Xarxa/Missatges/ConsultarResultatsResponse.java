package Xarxa.Missatges;

import java.util.SortedSet;

import Comunicacio.InfoPartida;

public class ConsultarResultatsResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SortedSet<InfoPartida> Info;
	public ConsultarResultatsResponse(SortedSet<InfoPartida> info){Info = info;}
	public boolean EsConsultarResultatsResponse(){return true;}
	public SortedSet<InfoPartida> getInfo(){return Info;}
	public ConsultarResultatsResponse(Exception e){
		super(e);
	}
}
