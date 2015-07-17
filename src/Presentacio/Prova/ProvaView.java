package Presentacio.Prova;

import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Presentacio.Comuns.BotoOK;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Comuns.PanellSeparador;

public class ProvaView extends PanellGeneral {

	
	private Map<String,Set<String>> NomsJugadors;
	
	private JList<String> Usuaris;
	private JList<String> Jugadors;
	private JList<String> Seleccio;
	
	private DefaultListModel<String> usuaris;
	private DefaultListModel<String> jugadors;
	private DefaultListModel<String> seleccio;
	
	public ProvaView(ActionListener retrocedir,ActionListener Acceptar) {
		super(retrocedir);
		// TODO Auto-generated constructor stub
		
		Construeix();
		ConstrueixComponents(Acceptar);
		
	}
	public Set<String> getJugadors(){
		Set<String> ret = new HashSet<>();
		for (Object o: seleccio.toArray()){
			String s = o.toString();
			ret.add(s);
		}
		return ret;
	}
	private void ConstrueixComponents(ActionListener Acceptar){
		JScrollPane a = new JScrollPane(Usuaris);
		JScrollPane b = new JScrollPane(Jugadors);
		JScrollPane c = new JScrollPane(Seleccio);
		
		PanellSeparador p = new PanellSeparador();
		
		JPanel Cont = new JPanel();
		JPanel A = new JPanel();
		Border lineBorder = createTitledBorder("Usuaris");
        A.add(a);
        A.setBorder(lineBorder);
        
        JPanel B = new JPanel();
		Border lineBorderB = createTitledBorder("Jugadors");
        B.add(b);
        B.setBorder(lineBorderB);
        
        JPanel C = new JPanel();
		Border lineBorderC = createTitledBorder("Partida");
        C.add(c);
        C.setBorder(lineBorderC);
        
		Cont.add(A);
		Cont.add(B);
		Cont.add(C);
		
		p.afegir(Cont);
		p.afegir(new BotoOK("Acceptar",Acceptar));
		
		Centre.add(p);
	}
	public void SetDades(Map<String,Set<String>> n){
		this.NomsJugadors = n;
		for (String s: NomsJugadors.keySet()) usuaris.addElement(s);
	}
	
	private void Construeix(){
		usuaris = new DefaultListModel<String>();
		Usuaris = new JList<>(usuaris);
		Usuaris.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Usuaris.addListSelectionListener(new SeleccioUsuari());
		Usuaris.setFixedCellWidth(150);
		
		jugadors = new DefaultListModel<String>();
		Jugadors = new JList<>(jugadors);
		Jugadors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Jugadors.addListSelectionListener(new SeleccioJugador());
		Jugadors.setFixedCellWidth(150);
		
		seleccio = new DefaultListModel<String>();
		Seleccio = new JList<>(seleccio);
		Seleccio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Seleccio.addListSelectionListener(new SeleccioSel());
		Seleccio.setFixedCellWidth(150);
	}
	
	private void SeleccionaUsuari(String usuari){
		jugadors.removeAllElements();
		for (String s: NomsJugadors.get(usuari)){
			 jugadors.addElement(s);
		}
	}
	
	private void AfegirJugador(String j){
		if (!seleccio.contains(j))
		seleccio.addElement(j);
	}
	private void RetirarJugador(String j){
		seleccio.removeElement(j);
	}
	
	private boolean Seleccionant = false;
	private boolean SeleccionantJ = false;
	private class SeleccioUsuari implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			Seleccionant = true;
			if (!arg0.getValueIsAdjusting())
			SeleccionaUsuari(usuaris.get(Usuaris.getSelectedIndex()));
			Seleccionant = false;
		}
		
	}
	
	private class SeleccioJugador implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			SeleccionantJ = true;
			if (!arg0.getValueIsAdjusting() && !Seleccionant)
			AfegirJugador(jugadors.get(Jugadors.getSelectedIndex()));
			SeleccionantJ = false;
		}
		
	}
	private class SeleccioSel implements  ListSelectionListener{

		private boolean erasing = false;
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting() && !SeleccionantJ && !erasing){
				erasing = true;
				RetirarJugador(seleccio.get(Seleccio.getSelectedIndex()));
				erasing = false;
			}
				
		}
		
	}
	


	
	

}
