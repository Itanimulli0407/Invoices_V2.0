package easp.DAOAPI;

import java.sql.ResultSet;
import java.sql.Statement;

public interface EASPExecution {

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
	
}
