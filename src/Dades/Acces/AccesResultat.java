package Dades.Acces;

import java.sql.ResultSet;
import java.sql.SQLException;

import Dades.Tipus.Resultat;
import Dades.Tipus.TipusBD;
import Dades.Tipus.Usuari;

public class AccesResultat extends AccesPartidaJugador {
	public static String TableName = "resultat";
	public static String[] ColumnNames = {"Posicio","Puntuacio"};
	public static String[] ColumnTypes = {"INTEGER","INTEGER"};

	
	
	@Override
	protected String[] getColumnNames() {
		return  concat(super.getColumnNames(),ColumnNames);
	}

	@Override
	protected String[] getColumnTypes() {
		return ColumnTypes;
	}
	
	@Override
	protected String getTableName() {
		return TableName;
	}
	@Override
	protected TipusBD LlegirResultat(ResultSet rs) throws SQLException {
		Resultat ret = new Resultat();
		ret.Llegir(rs);
		return ret;
	}
	
	
	private String[] concat(String[] a, String[] b) {
		   int aLen = a.length;
		   int bLen = b.length;
		   String[] c= new String[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   return c;
		}


}
