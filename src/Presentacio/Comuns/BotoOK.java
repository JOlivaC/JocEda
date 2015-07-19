/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author JOAN
 */
public class BotoOK extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotoOK(){
        this.setText("OK");
    }
    
    public BotoOK(ActionListener a){
        this.setText("OK");
        this.addActionListener(a);
    }
    
    public BotoOK(String text,ActionListener a){
        this.setText(text);
        this.addActionListener(a);
    }
}
