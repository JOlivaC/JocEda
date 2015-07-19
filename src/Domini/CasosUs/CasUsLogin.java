/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.CasosUs;

import Domini.Factories.FactoriaControladors;
import Domini.Model.Usuari;
import Excepcions.InvalidLogin;

/**
 *
 * @author JOAN
 */
public class CasUsLogin {
	public CasUsLogin(){}
    public Usuari Login(String User,String Pass) throws InvalidLogin{
    	try {
    		
			Usuari u = FactoriaControladors.getInstance().getCtrlUsuari().get(User);
			if (! u.getPass().equals(Pass)) throw new InvalidLogin();
			return u;
		} catch (Exception e) {
			throw new InvalidLogin();
		}
    }
}
