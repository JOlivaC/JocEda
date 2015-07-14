package Domini.InterficieBD;

import java.util.Set;

import Domini.Model.Dummy;
import Domini.Model.Huma;

public interface CtrlDummy {
	public Set<Dummy> getAll() throws Exception;
	public void Insert(Dummy d) throws Exception;
	public void Delete(Dummy d) throws Exception;
	public void Update(Dummy d) throws Exception;
}
