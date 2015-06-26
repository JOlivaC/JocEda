/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import java.io.File;
import java.net.Socket;

import Domini.LectorResultat.InfoResultat;
import Domini.LectorResultat.LectorResultat;

/**
 *
 * @author JOAN
 */
public class CasUsSessio {
    public void Login(String User,String Pass) throws Exception
    {
        
       
    }
    
    public void Penjar(File f){
    	LectorResultat LR = new LectorResultat();
    	try {
			System.out.printf(LR.Llegir(f).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
