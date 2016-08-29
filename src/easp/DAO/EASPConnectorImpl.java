package easp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.postgresql.util.PSQLException;

import easp.DAOAPI.EASPConnector;
import easp.exceptions.EASPExceptionEnum;
import easp.exceptions.EASPException;

public class EASPConnectorImpl implements EASPConnector {

	@Override
	public Connection connect(String username, String password) throws EASPException {
		Properties connProps = new Properties();
		connProps.put("username", username);
		connProps.put("password", password);
		
		Connection connection = null;
		
		String driverPath = "jdbc:postgresql://localhost/Quark";

		// Start connection
		try {
			connection = DriverManager.getConnection(driverPath, connProps);
		} catch (PSQLException psqlException) {
			throw new EASPException(EASPExceptionEnum.E001, psqlException, driverPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
