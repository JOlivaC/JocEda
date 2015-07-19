package Presentacio.PenjarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import Client.BD.Propietats;
import Excepcions.NoHiHaFitxer;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Comuns.PanellSeparador;
import Presentacio.Comuns.TextMesCamp;

public class Penjar extends PanellGeneral{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File f;
	private JLabel FitxerText;
	
	public Penjar(ActionListener Acceptar,ActionListener PenjarIVeure,ActionListener Retrocedir){
			super(Retrocedir);
	        
			
	        JButton Examinar = new JButton("Examinar...");
	        Examinar.addActionListener(new Examinar());
	        
	        FitxerText = new JLabel("Penja un fitxer...");
	        
	        TextMesCamp Seleccio = new TextMesCamp(FitxerText,Examinar);
	        
	        PanellSeparador S = new PanellSeparador();
	        S.afegir(Seleccio);
	        
	        PanellSeparador p = new PanellSeparador(false);
	        JButton BotoAcceptar = new JButton("Acceptar");
	        BotoAcceptar.addActionListener(Acceptar);
	        
	        JButton BotoPIV = new JButton("Acceptar i Visualitzar");
	        BotoPIV.addActionListener(PenjarIVeure);
	        
	        p.add(BotoAcceptar);
	        p.add(BotoPIV);
	        
	        S.afegir(p);
	        Centre.add(S);
	}
	public void SeleccionaFitxer() {
		 JFileChooser Sel;
		 Propietats p = null;
		try {
			p = new Propietats();
			if (p.getRutafitxer() != null) Sel = new JFileChooser(p.getRutafitxer());
			else Sel = new JFileChooser();
		} catch (IOException e) {
			Sel = new JFileChooser();
		}
		 if (Sel.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			 f = Sel.getSelectedFile();
			 FitxerText.setText(f.getName());
			 if (p != null) {
				 p.setRutafitxer(f.getParent());
				 try {
					p.Save();
				} catch (IOException e) {
					
				}
			 }
		 }
	}
	public File getFitxer()throws NoHiHaFitxer{
		if (f == null) throw new NoHiHaFitxer();
		return f;
		
	}
	
	private class Examinar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			SeleccionaFitxer();
			
		}
		
	}
}
