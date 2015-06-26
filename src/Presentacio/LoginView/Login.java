/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio.LoginView;

import Presentacio.Comuns.BotoOK;
import Presentacio.Comuns.BotoSortir;
import Presentacio.Comuns.PanellAmbMsg;
import Presentacio.Comuns.PanellSeparador;
import Presentacio.Comuns.TextMesCamp;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.event.ActionListener;
import static java.lang.String.valueOf;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JOAN
 */
public class Login extends PanellAmbMsg{

    private JTextField UserName;
    private JPasswordField Pass;
    
    public Login(ActionListener OKHandler,ActionListener SortirHandler){


        this.setLayout(new BorderLayout());

        this.add(msg, NORTH);
        
        JPanel Misc = new JPanel();
        Misc.setLayout(new BorderLayout());
        
        Misc.add(new BotoSortir(SortirHandler), WEST);
        Misc.add(new BotoOK(OKHandler), EAST);
        
        this.add(Misc, SOUTH);
        
        PanellSeparador Camps = new PanellSeparador();
        
        
        UserName = new JTextField();
        JLabel UserNameText = new JLabel("Usuari: ");       
        TextMesCamp User = new TextMesCamp(UserNameText,UserName);
        Camps.afegir(User);

        Pass = new JPasswordField();
        JLabel PassText = new JLabel("Password: ");
        TextMesCamp Cont = new TextMesCamp(PassText,Pass);
        
        Camps.afegir(Cont);
        
        this.add(Camps, CENTER);
        
        UserName.setText("2048");
        Pass.setText("2048");

    }
    
    public String getUserName(){
        return UserName.getText();
    }
    
    public String getPassword(){
        return valueOf(Pass.getPassword());
    }
    

}
