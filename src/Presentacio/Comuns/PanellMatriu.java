/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

import java.awt.Component;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.BOTH;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author JOAN
 */
public class PanellMatriu extends JPanel {

    public PanellMatriu(){
        this.setLayout(new GridBagLayout());
    }
    
    public void Add(Component c,int i,int j){
       GridBagConstraints t;
       t = new GridBagConstraints();
       t.fill = BOTH;
       t.weightx = 1;
       t.weighty = 1;
       t.gridx = i;
       t.gridy = j;
       this.add(c,t);
    }
}
