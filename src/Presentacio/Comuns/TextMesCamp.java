/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author JOAN
 */
public class TextMesCamp extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextMesCamp(Component c1,Component c2){
        this.setLayout(new GridLayout(0,2));
        this.add(c1);
        this.add(c2);
        c2.setPreferredSize(new Dimension(100,0));
    }
}
