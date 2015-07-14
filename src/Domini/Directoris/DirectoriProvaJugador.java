package Domini.Directoris;

import java.io.IOException;

public class DirectoriProvaJugador extends DirectoriPartida {
	private static final String DirName = "Prova";
	public DirectoriProvaJugador(String clau) throws IOException{
		super(clau);
	}
	@Override
	protected String getDirName() {
		return DirName;
	}

}
