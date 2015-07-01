package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import Dades.Tipus.Partida;

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

		
		private static Partida Llegir(ResultSet rs) throws SQLException{
			return new Partida(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
		private static void Escriure(PreparedStatement ps,Partida p) throws SQLException{
			ps.setInt(1,p.getIDPartida());
		    ps.setString(2, p.getFitxer());
		    ps.setInt(3, p.getEstat());
		}
		
		public void Insert(Partida p) throws Exception {          
	        PreparedStatement ps = con.prepareStatement("INSERT INTO " + getTableName() + " VALUES (?,?,?)");
	        Escriure(ps,p);
	        ps.executeUpdate();
	        ps.close();
		}
		
		public  Set<Partida> getAll() throws Exception {
			Set<Partida> ret = new HashSet<>();
			ResultSet rs;
			rs = con.createStatement().executeQuery("SELECT * FROM " + getTableName());
			while (rs.next()) ret.add(Llegir(rs));	
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
