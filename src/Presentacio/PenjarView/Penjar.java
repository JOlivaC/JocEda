package Presentacio.PenjarView;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Excepcions.NoHiHaFitxer;
import Presentacio.Comuns.BotoOK;
import Presentacio.Comuns.PanellAmbMsg;
import Presentacio.Comuns.PanellSeparador;
import Presentacio.Comuns.TextMesCamp;

public class Penjar extends PanellAmbMsg {
	private File f;
	private JLabel FitxerText;
	
	public Penjar(ActionListener Acceptar,ActionListener Retrocedir){
		 	this.setLayout(new BorderLayout());
	        this.add(msg, NORTH);
	        
	        JButton Examinar = new JButton("Examinar...");
	        Examinar.addActionListener(new Examinar());
	        
	        FitxerText = new JLabel("Penja un fitxer...");
	        
	        TextMesCamp Seleccio = new TextMesCamp(FitxerText,Examinar);
	        
	        PanellSeparador S = new PanellSeparador();
	        S.afegir(Seleccio);
	        
	        JButton BotoAcceptar = new JButton("Acceptar");
	        BotoAcceptar.addActionListener(Acceptar);
	        
	        S.afegir(BotoAcceptar);
	        
	        JPanel C = new JPanel(new GridBagLayout());
	        C.add(S);
	        this.add(C, CENTER);
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
