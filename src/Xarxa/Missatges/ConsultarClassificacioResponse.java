package Xarxa.Missatges;

import java.util.SortedSet;

import Comunicacio.InfoJugadorRanking;

public class ConsultarClassificacioResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SortedSet<InfoJugadorRanking> Info;
	public ConsultarClassificacioResponse( SortedSet<InfoJugadorRanking> info){Info = info;}
	public boolean EsConsultarClassificacioResponse(){return true;}
	public SortedSet<InfoJugadorRanking> getInfo(){return Info;}
}
