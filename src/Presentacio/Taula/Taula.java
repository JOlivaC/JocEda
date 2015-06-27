package Presentacio.Taula;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static javax.swing.BorderFactory.createTitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author JOAN
 */
public class Taula extends JPanel{
    protected TaulaBloquejada taula;
    public Taula(String titol,String[] Headers){
            Border lineBorder = createTitledBorder("Resultats");
            this.setBorder(lineBorder);
            this.setOpaque(false);
            taula = new TaulaBloquejada();
            DefaultTableModel t = (DefaultTableModel)taula.getModel();
            
            t.setColumnIdentifiers(Headers);
            taula.getTableHeader().setReorderingAllowed(false);
            this.setLayout(new GridLayout());
            JScrollPane scrollPane = new JScrollPane(taula); 
            this.add(scrollPane);
          
    }
    
    public void Insereix(Object[] components){
        DefaultTableModel t = (DefaultTableModel)taula.getModel();
        t.addRow(components);
    }
    public void Set(int row,int column,Object component){
    	taula.setValueAt(component, row, column);
    }
    public void TransformarEnBoto(int row,Action a){
    	new ButtonColumn(taula,a, row);
    }
    

}
