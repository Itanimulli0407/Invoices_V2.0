package easp.serviceAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import easp.exceptions.EASPException;
import easp.statements.EASPStatement;

public interface EASPQueryService {

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
	public void executeUpdate(Connection con, PreparedStatement statement) throws EASPException;

	/**
	 * 
	 * @param statement
	 *            the statement-string which should be filled with informations
	 * @param args
	 *            the arguments that will be inserted into the statement
	 * @return the final statement that will be executed by "executeStatement"
	 * @throws SQLException
	 * @throws EASPException
	 */
	public PreparedStatement prepareStatement(Connection con, EASPStatement easpStatement, Map<String, String> args)
			throws EASPException;

	/**
	 * 
	 * @param statement
	 *            the statement-string which should be converted to a
	 *            sql-statement
	 * @return the final statement that will be executed by "executeQuery"
	 * @throws SQLException
	 */
	public Statement prepareStatement(Connection con) throws SQLException;

}
