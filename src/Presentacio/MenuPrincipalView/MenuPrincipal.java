package Presentacio.MenuPrincipalView;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Presentacio.Comuns.PanellContenidor;
import Presentacio.Comuns.PanellSeparador;

public class MenuPrincipal extends PanellContenidor {
	public MenuPrincipal(ActionListener Penjar,ActionListener VeureResultats,ActionListener VeureRanking){
		this.setLayout(new GridBagLayout());
		PanellSeparador P = new PanellSeparador();
		
		JButton penjar = new JButton("Penjar Fitxer");
		penjar.addActionListener(Penjar);
		P.afegir(penjar);
		
		JButton resultats = new JButton("Veure Resultats");
		resultats.addActionListener(VeureResultats);
		P.afegir(resultats);
		
		JButton ranking= new JButton("Veure Ranking");
		ranking.addActionListener(VeureRanking);
		P.afegir(ranking);
	
		
		this.add(P);
	}

}
