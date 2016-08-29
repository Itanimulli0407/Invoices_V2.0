package easp.serviceAPI;

import easp.exceptions.EASPException;

public interface EASPLoginService {

	public void connect(String username, String password) throws EASPException;
	
	public EASPException handleServerError();
	
}
