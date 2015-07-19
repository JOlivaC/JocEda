package Xarxa.Missatges;

public class BooleanResponse extends Paquet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean result;
    
    public boolean EsBooleanResponse(){return true;}
    public BooleanResponse(){}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
    
}
