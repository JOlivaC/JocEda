package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Alarma;
import Dades.Tipus.Jugador;
import Dades.Tipus.TipusBD;

public class AccesJugador extends AccesClauPrimariaUnica {
	public static String tableName = "jugador";
	
	public static String[] ColumnNames = {"nom",AccesFitxer.PKIdentifier};
	public static String[] ColumnTypes = {"VARCHAR(255)",AccesFitxer.PKType};

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
		Jugador ret = new Jugador();
		ret.Llegir(rs);
		return ret;
	}
	
	

}
