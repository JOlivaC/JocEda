package Presentacio.Resultats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Comunicacio.InfoJugadorPartida;
import Comunicacio.InfoPartida;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Taula.TaulaResultats;

public class ResultatsView extends PanellGeneral {
	private TaulaResultats t;
	private int n;
	SortedSet<InfoPartida> Info;
	Map<String,InfoPartida> Acces;
	
	private ActionListener Visualitzar;
	private int LastId;
	public ResultatsView(ActionListener Retrocedir,ActionListener Visualitzar,SortedSet<InfoPartida> Info){
		super(Retrocedir);
		
		this.Visualitzar = Visualitzar;
		if (Info.size() > 0){
			n = Info.first().Jugadors.size();
			t = new TaulaResultats(n);
			SetResultats(Info);
			this.add(t);
		}
	}
	public int getLastID(){return LastId;}
	public void SetResultats(SortedSet<InfoPartida> Info){
		t.TransformarEnBoto(1 + n, new Resultats());
		t.TransformarEnBoto(1 + n + 1, new Visualitzar());
		for (InfoPartida i:Info){
			Object[] x = new Object[3 + n];
			x[0] = i.IDPartida;
			int k = 0;
			for (InfoJugadorPartida IJ: i.Jugadors){
				k++;
				x[k] = IJ.getNom();
				
			}
			k++;
			x[k] = "";
			
			x[k + 1] = "";
			
			
			t.Insereix(x);
			
		}
		Acces = new HashMap<String,InfoPartida>();
		for (InfoPartida i: Info){
			Acces.put(String.valueOf(i.IDPartida), i);
		}
		this.Info = Info;
	}
	
	private class Visualitzar extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			JTable table = (JTable)e.getSource();
	        int modelRow = Integer.valueOf( e.getActionCommand() );
	        
	        LastId = Integer.valueOf(String.valueOf(((DefaultTableModel)table.getModel()).getValueAt(modelRow, 0)));
			Visualitzar.actionPerformed(e);
		}
		
	}
	
	private class Resultats extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			JTable table = (JTable)e.getSource();
	        int modelRow = Integer.valueOf( e.getActionCommand() );
	        
	        String id = String.valueOf(((DefaultTableModel)table.getModel()).getValueAt(modelRow, 0));
	        InfoPartida j = Acces.get(id);
	        
	        int k = 0;
	        for (InfoJugadorPartida ij: j.Jugadors){
	        	
	        	t.Set(modelRow, 1 + k, ij);
	        	k ++;
	        }
			
			
		}
		
	}
}
