package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Alarma;
import Dades.Tipus.Partida;
import Dades.Tipus.TipusBD;

public class AccesPartida extends AccesClauPrimariaUnica {
	public static String tableName = "partida";
	
	public static String[] ColumnNames = {"IDPartida","fitxer","estat"};
	public static String[] ColumnTypes = {"INTEGER","INTEGER"};

	public static String PKIdentifier = ColumnNames[0];
	public static String PKType = ColumnTypes[0];
	
	public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")",
											"FOREIGN KEY (" + ColumnNames[1] + ") REFERENCES " + AccesFitxer.tableName + "(" + AccesFitxer.PKIdentifier + ")"};
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
		Partida ret = new Partida();
		ret.Llegir(rs);
		return ret;
	}
	

	


}
