package easp.DAOAPI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import easp.exceptions.EASPException;
import easp.statements.EASPStatement;

public interface EASPExecutionUnit {

	/**
	 * 
	 * @param statement
	 *            the statement which will be executed
	 * @return returns the result of a query on the database
	 * @throws SQLException 
	 */
	public ResultSet executeQuery(Statement statement, EASPStatement easpStatement) throws SQLException;

	/**
	 * 
	 * @param statement
	 *            the statement which will be executed
	 * 
	 *            This method is called when executing Statement with no result
	 *            like updates or insertions
	 * @throws EASPException 
	 */
	public void executeUpdate(PreparedStatement statement) throws EASPException;
	
}
