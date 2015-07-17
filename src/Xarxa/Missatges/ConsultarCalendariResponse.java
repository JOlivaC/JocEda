package Xarxa.Missatges;

import java.util.SortedSet;

import Comunicacio.InfoCalendariPartida;

public class ConsultarCalendariResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SortedSet<InfoCalendariPartida> info;
	public boolean EsConsultarCalendariResponse(){return true;}
	public ConsultarCalendariResponse(SortedSet<InfoCalendariPartida> info){this.info = info;}
	public ConsultarCalendariResponse(Exception e){super(e);}
	public SortedSet<InfoCalendariPartida> getInfo(){return info;}
}
