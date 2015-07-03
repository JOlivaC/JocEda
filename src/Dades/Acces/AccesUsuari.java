package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Alarma;
import Dades.Tipus.Partida;
import Dades.Tipus.TipusBD;
import Dades.Tipus.Usuari;

public class AccesUsuari extends AccesClauPrimariaUnica {
		public static String tableName = "usuari";
		
		public static String[] ColumnNames = {"user","pass"};
		public static String[] ColumnTypes = {"VARCHAR(255)","VARCHAR(255)"};

		public static String PKIdentifier = ColumnNames[0];
		public static String PKType = ColumnTypes[0];
		
		public static String[] Constraints = {"PRIMARY KEY (" + PKIdentifier + ")"};
												
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
			Usuari ret = new Usuari();
			ret.Llegir(rs);
			return ret;
		}
		

}
