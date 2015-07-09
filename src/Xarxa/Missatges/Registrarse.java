package Xarxa.Missatges;

public class Registrarse extends Paquet {
	 public String User;
    public String Pass;

    public Registrarse(){}
    public Registrarse(String Name,String Pass){
        User = Name;
        Pass = Pass;
    }
    public boolean EsRegistrarse(){return true;}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
}
