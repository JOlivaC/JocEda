package Dades.Acces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dades.Claus.PrimaryKey;
import Dades.Tipus.Alarma;
import Dades.Tipus.TipusBD;

public abstract class AccesClauPrimariaUnica extends Acces {
	public abstract String getPKIdentifier();
	public abstract String getPKType();
	
	
	public String getPreparedSelect(){
		return (this.getPKIdentifier() + " = ? ");
	}
}
