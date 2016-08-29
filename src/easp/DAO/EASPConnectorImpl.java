package easp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		
		String driverPath = "jdbc:postgresql://localhost/EASP";

		// Start connection
		try {
			connection = DriverManager.getConnection(driverPath, connProps);
		} catch (PSQLException psqlException) {
			throw new EASPException(EASPExceptionEnum.E001, psqlException, driverPath, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection dbConnection) throws EASPException {
		try {
			dbConnection.close();
		} catch (NullPointerException nullPointerException) {
			throw new EASPException(EASPExceptionEnum.E002, nullPointerException);
		} catch (SQLException sqlException) {
			throw new EASPException(EASPExceptionEnum.E003, sqlException);
		}
	}
	
}
