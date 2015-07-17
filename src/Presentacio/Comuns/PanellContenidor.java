/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

import javax.swing.JPanel;

/**
 *
 * @author JOAN
 */
public class PanellContenidor extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titol;
	public PanellContenidor(){
		
	}
	public  PanellContenidor(String t){titol = t;}
    public void Show(){
        this.setVisible(true);
    }
    public void tancar(){
        this.setVisible(false);
    }
    
    public String getTitol(){return titol;}
    public void setTitol(String titol){this.titol = titol;}
}
