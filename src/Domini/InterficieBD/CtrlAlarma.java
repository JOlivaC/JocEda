package Domini.InterficieBD;

import java.util.Set;

import Actors.Alarmes.AlarmaJugar;

public interface CtrlAlarma {
	public Set<AlarmaJugar> getAll() throws Exception;
	public void Insert(AlarmaJugar a) throws Exception;
	void DeleteAll() throws Exception;
	public void Create() throws Exception;
	public void Delete(AlarmaJugar a) throws Exception;
	public void Delete(int IDPartida) throws Exception;
}
