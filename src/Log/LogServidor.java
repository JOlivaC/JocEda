package Log;

public abstract class LogServidor {
	public static void WriteLine(String line){
		System.out.print(line + "\n");
	}
	
	public static void WriteException(Exception e){
		System.out.print(e + "\n");
	}
}
