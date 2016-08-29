package easp.serviceAPI;

import java.sql.Connection;

import easp.exceptions.EASPException;

public interface EASPLoginService {

	public Connection connect(String username, String password) throws EASPException;
	
	public EASPException handleServerError();

	public void closeConnection(Connection dbConnection) throws EASPException;
	
}
