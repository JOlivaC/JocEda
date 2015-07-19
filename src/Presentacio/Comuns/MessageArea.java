/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.Comuns;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import static javax.swing.BorderFactory.createTitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;

/**
 *
 * @author JOAN
 */
public class MessageArea extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel Contingut;
    public MessageArea(){
        /*this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);*/
        Border lineBorder = createTitledBorder("Missatges");
        Contingut = new JLabel();
        Contingut.setHorizontalAlignment(CENTER);
        Contingut.setVerticalAlignment(CENTER);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        this.add(Contingut,c);
        this.setBorder(lineBorder);
    }
    
    public void SetText(String text){
        Contingut.setText(text);
    }
}
