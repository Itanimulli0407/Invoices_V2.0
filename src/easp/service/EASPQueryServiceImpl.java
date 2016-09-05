package easp.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import easp.DAO.EASPExecutionUnitImpl;
import easp.DAOAPI.EASPExecutionUnit;
import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
import easp.serviceAPI.EASPQueryService;
import easp.statements.EASPStatement;
import easp.statements.EASPStatementEnum;

public class EASPQueryServiceImpl implements EASPQueryService {

	// Statements with result set

	@Override
	public ResultSet executeQuery(Statement statement, EASPStatement easpStatement) throws SQLException {
		EASPExecutionUnit executionUnit = new EASPExecutionUnitImpl();
		ResultSet result = null;
		result = executionUnit.executeQuery(statement, null);
		return result;
	}

	@Override
	public Statement prepareStatement(Connection conn) throws SQLException {
		Statement result = null;
		result = conn.createStatement();
		return result;
	}

	// Statements without result set

	@Override
	public void executeUpdate(Connection con, PreparedStatement statement) throws EASPException {
		EASPExecutionUnit executionUnit = new EASPExecutionUnitImpl();
		executionUnit.executeUpdate(statement);
	}

	@Override
	public PreparedStatement prepareStatement(Connection conn, EASPStatement easpStatement, Map<String, String> args)
			throws EASPException {
		PreparedStatement result = null;
		
		try{
			result = conn.prepareStatement(easpStatement.getType().getStatement());

			if (easpStatement.getType() == EASPStatementEnum.NEW_CUSTOMER) {
				// Prepare Statement for inserting a new Customer
				result.setString(1, args.get("lastName"));
				result.setString(2, args.get("firstName"));
				if (!args.get("birthday").equals(""))
					result.setDate(3, Date.valueOf(args.get("birthday")));
				else
					result.setDate(3, Date.valueOf("1901-01-01"));
				result.setString(4, args.get("street"));
				result.setInt(5, Integer.parseInt(args.get("zipCode")));
				result.setString(6, args.get("city"));
				result.setString(7, args.get("email"));
			} else if (easpStatement.getType() == EASPStatementEnum.NEW_NUMBER) {
				// Prepare Statement for inserting numbers
				result.setString(1, args.get("number"));
				result.setString(2, args.get("kind"));
				result.setInt(3, Integer.parseInt(args.get("customerID")));
			}
		} catch (SQLException e) {
			throw new EASPException(EASPExceptionEnum.E003, e);
		}
		
		// TODO: Implement other prepared statements

		return result;

	}

}
