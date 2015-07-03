package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Dades.Controladors.TaulaPartida;
import Dades.Tipus.Alarma;
import Dades.Tipus.Fitxer;
import Dades.Tipus.TipusBD;

public class AccesFitxer extends AccesClauPrimariaUnica {
	public static String tableName = "fitxer";
	
	public static String[] ColumnNames = {"Nom","Dades"};
	public static String[] ColumnTypes = {"VARCHAR(255)","BYTEA"};

	public static String PKIdentifier = ColumnNames[0];
	public static String PKType = ColumnTypes[0];
	
	public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")"};
	

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
		Fitxer ret = new Fitxer();
		ret.Llegir(rs);
		return ret;
	}
	

}
