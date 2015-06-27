package Presentacio.Comuns;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanellGeneral extends PanellAmbMsg {
	protected JPanel Centre;
	public PanellGeneral(ActionListener retrocedir){
		this.setLayout(new BorderLayout());
		
		this.add(super.msg,BorderLayout.NORTH);
		Centre = new JPanel(new GridBagLayout());
		this.add(Centre,BorderLayout.CENTER);
		
		JButton Retrocedir = new JButton("Retrocedir");
		Retrocedir.addActionListener(retrocedir);
		JPanel R = new JPanel(new BorderLayout());
		R.add(Retrocedir,BorderLayout.WEST);
		
		this.add(R,BorderLayout.SOUTH);
	}
	
}
