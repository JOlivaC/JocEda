package Domini.InterficieBD;

import java.util.Set;

import Domini.Model.Lliga;

public interface CtrlLliga {
	public Set<Lliga> getAll() throws Exception;
	public void Insert(Lliga l) throws Exception;
	public Lliga Get(int ID) throws Exception;
	public void Delete(Lliga l) throws Exception;
	public void Update(Lliga l) throws Exception;
}
