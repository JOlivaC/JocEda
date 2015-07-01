package Dades.Connexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioBD {
	private static ConnexioBD instance = new ConnexioBD();
	public static ConnexioBD getInstance() {return instance;}
	
	public ConnexioBD(){
		
	}
	private Connection con;
	public Connection getConnexio() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
	    String url = "jdbc:postgresql://localhost:5432/postgres";
	    con = DriverManager.getConnection(url,"postgres", "eda");
	    con.setSchema("EDA");
	    return con;
	}
}
