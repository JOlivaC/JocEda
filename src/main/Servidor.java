/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;

import Comunicacio.Fitxer;
import Dades.Factories.HibernateUtil;
import Domini.CasosUs.CasUsCrearDummy;
import Domini.CasosUs.CasUsPartidaProva;
import Domini.Factories.FactoriaControladors;
import Domini.Model.Lliga;
import Domini.Transaccions.TxEngegarAlarmes;
import Domini.Transaccions.TxProgramarSessio;
import Xarxa.Servidor.Escoltador;

/**
 *
 * @author JOAN
 */
public class Servidor {

    /**
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        new Escoltador().start();
        new TxEngegarAlarmes().Executar();
        Scanner in = new Scanner(System.in);
        String input;
        while ((input = in.nextLine()).compareTo("exit") != 0){
        	if (input.equalsIgnoreCase("programar")){
        		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        		System.out.print("Escriu el dia d'inici i despres el de fi: yyyy-mm-dd:\n");
        		Date i = f.parse(in.nextLine());
        		Date c = f.parse(in.nextLine());
        		System.out.print("Escriu la hora d'inici: Hora,Minut\n");
        		LocalTime horai = LocalTime.of(Integer.parseInt(in.nextLine()),Integer.parseInt(in.nextLine()));
        		System.out.print("Escriu la hora de fi: Hora,Minut\n");
        		LocalTime horaf = LocalTime.of(Integer.parseInt(in.nextLine()),Integer.parseInt(in.nextLine()));
        		
        		new TxProgramarSessio(i,c,horai,horaf,6).Executar();
        	}
        	else if (input.equalsIgnoreCase("dummy")){
				JFileChooser Sel = new JFileChooser();
				File f;
				if (Sel.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					 f = Sel.getSelectedFile();
					 new CasUsCrearDummy().CrearDummy(new Fitxer(f));
				}
	       		 
	       		 
	       		 
        	}
        	else if (input.equalsIgnoreCase("droplliga")){
				Lliga l = FactoriaControladors.getInstance().getCtrlLliga().Get(Integer.valueOf(in.nextLine()));
				FactoriaControladors.getInstance().getCtrlLliga().Delete(l);
	       		 
        	}
        	else if (input.equalsIgnoreCase("test")){
        		Set<String> j = new HashSet<String>();
        		for (int i = 0; i < 4; i ++){
        			j.add(in.nextLine());
        		}
        		CasUsPartidaProva c = new CasUsPartidaProva();
        		c.PartidaProva(j);
        	}
        }
        HibernateUtil.getSessionFactory().close();
    }
    
}
