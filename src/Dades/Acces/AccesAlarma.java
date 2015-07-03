package Dades.Acces;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Dades.Controladors.TaulaPartida;
import Dades.Factories.ConnexioBD;
import Dades.Tipus.Alarma;
import Dades.Tipus.TipusBD;

public class AccesAlarma extends AccesClauPrimariaUnica {
	public static String tableName = "alarma";
	
	public static String[] ColumnNames = {"IDPartida","data"};
	public static String[] ColumnTypes = {"INTEGER","TIMESTAMP"};

	public static String PKIdentifier = ColumnNames[0];
	public static String PKType = ColumnTypes[0];
	
	public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")",
											"FOREIGN KEY (" + PKIdentifier + ") REFERENCES " + TaulaPartida.TableName};
	
	@Override
	public  String getPKIdentifier() {
		return PKIdentifier;
	}
	@Override
	public  String getPKType() {
		return PKType;
	}
	@Override
	protected String[] getColumnNames() {
		return ColumnNames;
	}

	@Override
	protected String[] getColumnTypes() {
		// TODO Auto-generated method stub
		return ColumnTypes;
	}

	@Override
	protected String[] getConstraints() {
		// TODO Auto-generated method stub
		return Constraints;
	}

	@Override
	protected String getTableName() {
		// TODO Auto-generated method stub
		return tableName;
	}
	

	@Override
	protected TipusBD LlegirResultat(ResultSet rs) throws SQLException {
		Alarma ret = new Alarma();
		ret.Llegir(rs);
		return ret;
	}
	

	

	
	
				

	
}
