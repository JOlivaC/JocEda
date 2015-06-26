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
public class BotoSortir extends JButton {
    public BotoSortir(){
        this.setText("Sortir");
    }
    
    public BotoSortir(ActionListener l){
        this.setText("Sortir");
        this.addActionListener(l);
    }
}
