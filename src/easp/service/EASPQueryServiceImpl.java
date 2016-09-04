package easp.service;

import java.sql.ResultSet;
import java.sql.Statement;

import easp.DAO.EASPExecutionImpl;
import easp.DAOAPI.EASPExecution;
import easp.serviceAPI.EASPQueryService;
import easp.statements.EASPStatementEnum;

public class EASPQueryServiceImpl implements EASPQueryService {

	@Override
	public ResultSet executeQuery(Statement statement) {
		EASPExecution executionUnit = new EASPExecutionImpl();
		ResultSet result = null;
		result = executionUnit.executeQuery(statement);
		return result;
	}

	@Override
	public void executeStatement(Statement statement) {
		EASPExecution executionUnit = new EASPExecutionImpl();
		executionUnit.executeStatement(statement);
	}

	@Override
	public Statement prepareStatement(EASPStatementEnum statement, String[] args) {
		// TODO Auto-generated method stub
		Statement result = null;
		return result;
	}

	@Override
	public Statement prepareStatement(EASPStatementEnum statement) {
		// TODO Auto-generated method stub
		Statement result = null;
		return result;
	}

}
