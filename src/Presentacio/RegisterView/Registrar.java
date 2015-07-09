package Presentacio.RegisterView;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.lang.String.valueOf;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Presentacio.Comuns.BotoOK;
import Presentacio.Comuns.PanellAmbMsg;
import Presentacio.Comuns.PanellGeneral;
import Presentacio.Comuns.PanellSeparador;
import Presentacio.Comuns.TextMesCamp;

public class Registrar extends PanellGeneral {
	 private JTextField UserName;
	    private JPasswordField Pass;
	    
	    public Registrar(ActionListener OKHandler,ActionListener Retrocedir){

	    	super(Retrocedir);
	    	
	    	super.Centre.setLayout(new BorderLayout());
	        
	        JPanel Misc = new JPanel();
	        Misc.setLayout(new BorderLayout());
	        
	        Misc.add(new BotoOK(OKHandler), EAST);
	        
	        super.Centre.add(Misc, SOUTH);
	        
	        PanellSeparador Camps = new PanellSeparador();
	        
	        
	        UserName = new JTextField();
	        JLabel UserNameText = new JLabel("Usuari: ");       
	        TextMesCamp User = new TextMesCamp(UserNameText,UserName);
	        Camps.afegir(User);

	        Pass = new JPasswordField();
	        JLabel PassText = new JLabel("Password: ");
	        TextMesCamp Cont = new TextMesCamp(PassText,Pass);
	        
	        Camps.afegir(Cont);
	        
	        super.Centre.add(Camps, CENTER);
	        

	    }
	    
	    public String getUserName(){
	        return UserName.getText();
	    }
	    
	    public String getPassword(){
	        return valueOf(Pass.getPassword());
	    }
}
