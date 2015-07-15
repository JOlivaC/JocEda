package Client.VisualitzarPartida;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import Comunicacio.Fitxer;

public class VisualitzarPartida {
	private static final String Dir = System.getProperty("user.dir") + File.separator + "Viewer";
	private static final String htmlF = Dir + File.separator + "viewer.html";
	private static final String gameFile = Dir + File.separator + "game.br";
	private static final String Html = "file:///" + System.getProperty("user.dir") + File.separator + "Viewer" + File.separator + "viewer.html";
	
	public void Visualitzar(Fitxer partida) throws IOException, URISyntaxException{
		
		partida.WriteFile(gameFile);
		
		File htmlFile = new File(htmlF);
		Desktop.getDesktop().open(htmlFile);
	}
}
