package Dades.Acces;

public abstract  class AccesClauPrimariaComposta extends Acces {
	public abstract String getPrimaryKeyExpression();
	
	public String getPreparedSelect(){
		String[] c = this.getColumnNames();
		String ret = "";
		for (int i = 0; i < c.length; i++){
			ret += (c[i] + " = ? ");
			if (i < c.length - 1) ret += "AND";
		}
		return ret;
	}
}
