package easp.DAOAPI;

import java.sql.Connection;

import easp.exceptions.EASPException;

public interface EASPConnector {

	/**
	 * 
	 * @param username
	 *            The username to connect
	 * @param password
	 *            The password matching with username
	 * @return New connection to postgresql database
	 * @throws EASPException
	 *             Exception can be used to check if there was a server error
	 *             (you have to check if it was because of a wrong
	 *             username/password or if there were other problems)
	 */
	public Connection connect(String username, String password) throws EASPException;
	
	public void closeConnection(Connection dbConnection) throws EASPException;

}
