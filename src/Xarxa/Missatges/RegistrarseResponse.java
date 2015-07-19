package Xarxa.Missatges;

public class RegistrarseResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RegistrarseResponse(){}
    public boolean EsRegistrarseResponse(){return true;}
    public RegistrarseResponse(Exception e){super(e);}
}
