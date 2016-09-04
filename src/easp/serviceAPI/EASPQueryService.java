package easp.serviceAPI;

import java.sql.ResultSet;
import java.sql.Statement;

import easp.statements.EASPStatementEnum;

public interface EASPQueryService {

	/**
	 * 
	 * @param statement
	 *            the statement which will be executed
	 * @return returns the result of a query on the database
	 */
	public ResultSet executeQuery(Statement statement);

	/**
	 * 
	 * @param statement
	 *            the statement which will be executed
	 * 
	 *            This method is called when executing Statement with no result
	 *            like updates or insertions
	 */
	public void executeStatement(Statement statement);

	/**
	 * 
	 * @param statement
	 *            the statement-string which should be filled with informations
	 * @param args
	 *            the arguments that will be inserted into the statement
	 * @return the final statement that will be executed by "executeStatement"
	 */
	public Statement prepareStatement(EASPStatementEnum statement, String[] args);

	/**
	 * 
	 * @param statement
	 *            the statement-string which should be converted to a
	 *            sql-statement
	 * @return the final statement that will be executed by "executeQuery"
	 */
	public Statement prepareStatement(EASPStatementEnum statement);

}
