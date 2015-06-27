package Presentacio.PenjarView;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import Excepcions.NoHiHaFitxer;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Comuns.PanellSeparador;
import Presentacio.Comuns.TextMesCamp;

public class Penjar extends PanellGeneral{
	private File f;
	private JLabel FitxerText;
	
	public Penjar(ActionListener Acceptar,ActionListener Retrocedir){
			super(Retrocedir);
	        
			
	        JButton Examinar = new JButton("Examinar...");
	        Examinar.addActionListener(new Examinar());
	        
	        FitxerText = new JLabel("Penja un fitxer...");
	        
	        TextMesCamp Seleccio = new TextMesCamp(FitxerText,Examinar);
	        
	        PanellSeparador S = new PanellSeparador();
	        S.afegir(Seleccio);
	        
	        JButton BotoAcceptar = new JButton("Acceptar");
	        BotoAcceptar.addActionListener(Acceptar);
	        
	        S.afegir(BotoAcceptar);
	        Centre.add(S);
	}
	public void SeleccionaFitxer() {
		 JFileChooser Sel = new JFileChooser();
		 if (Sel.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			 f = Sel.getSelectedFile();
			 FitxerText.setText(f.getName());
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
