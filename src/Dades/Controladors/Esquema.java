package Dades.Controladors;

import java.sql.Connection;
import java.sql.SQLException;

import Dades.Connexio.ConnexioBD;

public class Esquema {
	
	public static String Alarma_TableName = "alarma";
	
	public void CrearEsquema() throws Exception{
		Connection con = ConnexioBD.getInstance().getConnexio();
		if (TaulaAlarma.TableExists(con))TaulaAlarma.DropTable(con);
		TaulaAlarma.CreateTable(con);
		
	}
}
