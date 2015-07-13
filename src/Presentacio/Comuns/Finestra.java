/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

import java.awt.Dimension;
import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.JFrame;

/**
 *
 * @author JOAN
 */
public  class Finestra extends JFrame {
    public Finestra(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,600));
        this.setPreferredSize(new Dimension(600,600));
        Dimension dim = getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
    }
    public void Show(){
        this.setVisible(true);
    }
    public void tancar(){
        this.dispose();
        this.setVisible(false);
    }
    
    public void CanviarContext(String titol,PanellContenidor p){
        this.setPreferredSize(this.getSize());
        this.setTitle(titol);
        this.setContentPane(p);
        this.pack();
    }
}
