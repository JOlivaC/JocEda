package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Partida;
import Dades.Tipus.PartidaJugador;

public class AccesPartidaJugador extends AccesClauPrimariaComposta {
		
		public static String[] ColumnNames = {AccesPartida.PKIdentifier,AccesJugador.PKIdentifier};
		public static String[] ColumnTypes = {AccesPartida.PKType,AccesJugador.PKType};

		public static String[] PKIdentifiers = {ColumnNames[0],ColumnNames[1]};
		public static String[] PKTypes = {ColumnTypes[0],ColumnTypes[1]};
		
		public static String[] Constraints = {"PRIMARY KEY (" + CompositePK() + ")",
				"FOREIGN KEY (" + ColumnNames[0] + ") REFERENCES " + AccesPartida.tableName + "(" + AccesPartida.PKIdentifier + ")",
				"FOREIGN KEY (" + ColumnNames[1] + ") REFERENCES " + AccesJugador.tableName + "(" + AccesJugador.PKIdentifier + ")",								
		};

		public static String CompositePK(){
			String ret = "";
			for (int i = 0; i < PKIdentifiers.length; i++){
				if (i < PKIdentifiers.length) ret += PKIdentifiers[i] + ", ";
				else ret += PKIdentifiers[i];
			}
			return ret;
		}
		@Override
		public String getPrimaryKeyExpression() {
			return CompositePK();
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
		

		
		public void Insert(PartidaJugador pj) throws Exception {          
	        PreparedStatement ps = con.prepareStatement("INSERT INTO " + getTableName() + " VALUES (" + super.getPreparedInsert() +")");
	        pj.Escriure(ps);
	        ps.executeUpdate();
	        ps.close();
		}
		
		public  Set<Partida> getAll() throws Exception {
			Set<Partida> ret = new HashSet<>();
			ResultSet rs;
			rs = con.createStatement().executeQuery("SELECT * FROM " + getTableName());
			while (rs.next()) ret.add(new PartidaJugador);	
			return ret;
		}
		
		public Partida get(int IDPartida) throws Exception {		
			ResultSet rs;
			PreparedStatement ps = con.prepareStatement("SELECT FROM " + getTableName() + " WHERE " + PKIdentifier + " = ?");
			ps.setInt(1, IDPartida);
			rs = ps.executeQuery();	
			return Llegir(rs);
		}

}
