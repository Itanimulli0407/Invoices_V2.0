package easp.DAOAPI;

import java.sql.Connection;

import easp.exceptions.EASPException;

public interface EASPConnector {

	public Connection connect(String username, String password) throws EASPException;
	
}
