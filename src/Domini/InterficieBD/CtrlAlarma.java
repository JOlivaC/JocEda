package Domini.InterficieBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Actors.Alarmes.AlarmaJugar;

public class CtrlAlarma {
	//public Set<AlarmaJugar> getAll();
	public void Insert(AlarmaJugar a){
	        try
	        {            
	            String db_file_name_prefix = "c:\\alarma";

	            Connection con = null;
	            // Load the HSQL Database Engine JDBC driver
	            // hsqldb.jar should be in the class path or made part of the current jar
	            Class.forName("org.hsqldb.jdbcDriver");

	            // connect to the database.   This will load the db files and start the
	            // database if it is not alread running.
	            // db_file_name_prefix is used to open or create files that hold the state
	            // of the db.
	            // It can contain directory names relative to the
	            // current working directory
	            con = DriverManager.getConnection("jdbc:hsqldb:file:" + db_file_name_prefix, // filenames
	                    "admin", // username
	                    "admin");  // password

	            //Statement statement = con.createStatement();
	            PreparedStatement ps = con.prepareStatement("INSERT INTO Alarma VALUES (?,?,?)");
	            //look at " for table name
	            
	            java.sql.Date sqlDate = new java.sql.Date(a.getData().getTime());
	            ps.setInt(1, a.getIDPartida());
	            ps.setDate(2, sqlDate);
	            ps.setInt(3, a.getIDPartida());

	            ps.executeUpdate();

	            ps.close();
	            con.close();

	        } catch (SQLException ex)
	        {

	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex)
	        {
	        
	        }
	}
}
