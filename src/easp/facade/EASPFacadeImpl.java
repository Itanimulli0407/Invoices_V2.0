package easp.facade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import easp.commands.EASPCommand;
import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import easp.service.EASPCommandServiceImpl;
import easp.service.EASPLoginServiceImpl;
import easp.service.EASPQueryServiceImpl;
import easp.serviceAPI.EASPCommandService;
import easp.serviceAPI.EASPQueryService;
import easp.statements.EASPStatement;
import easp.statements.EASPStatementEnum;
import easp.userInterfaceAPI.EASPUserInterface;
import javafx.util.Pair;

public class EASPFacadeImpl implements EASPFacade {

	private EASPLoginServiceImpl loginService;
	private Connection dbConnection;
	private EASPUserInterface ui;

	//////////////////////////////////////////////////////////////////////////
	//
	// COMMANDS
	//
	//////////////////////////////////////////////////////////////////////////

	@Override
	public void executeCommand(EASPCommand command) {
		EASPCommandService commandService = new EASPCommandServiceImpl(this);
		try {
			commandService.executeCommand(command);
		} catch (EASPException easpException) {
			this.handleEASPException(easpException);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public EASPCommand createCommand(String input) {
		EASPCommand result = null;
		EASPCommandService commandService = new EASPCommandServiceImpl(this);
		result = commandService.createCommand(input);
		return result;
	}

	//////////////////////////////////////////////////////////////////////////
	//
	// DATABASE
	//
	//////////////////////////////////////////////////////////////////////////

	@Override
	public void connectToDB(String username, String password) {
		loginService = new EASPLoginServiceImpl();
		try {
			dbConnection = loginService.connect(username, password);
			ui.showMessage("Connection established");
		} catch (EASPException easpException) {
			handleEASPException(easpException);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		try {
			loginService.closeConnection(dbConnection);
			ui.showMessage("Connection established");
		} catch (EASPException easpException) {
			handleEASPException(easpException);
		}
	}

	@Override
	public void createNewCustomer() {
		// Fields
		Map<String, String> customerData = null;
		PreparedStatement statement = null;
		EASPStatement easpStatement = null;

		try {
			// Get and check data
			customerData = ui.getCustomerData();

			// Prepare customer statement
			EASPQueryService queryService = new EASPQueryServiceImpl();
			easpStatement = new EASPStatement(EASPStatementEnum.NEW_CUSTOMER);
			statement = queryService.prepareStatement(this.dbConnection, easpStatement, customerData);

			// Execute customer statement
			queryService.executeUpdate(dbConnection, statement);
			ui.showMessage("Customer " + customerData.get("firstName") + " " + customerData.get("lastName")
					+ " inserted into database.");
		} catch (EASPException easpException) {
			this.handleEASPException(easpException);
		}
	}

	//////////////////////////////////////////////////////////////////////////
	//
	// USER-INTERFACE
	//
	//////////////////////////////////////////////////////////////////////////

	@Override
	public void closeUI() {
		ui.close();
		closeConnection();
		System.exit(0);
	}

	@Override
	public void startUI(EASPUserInterface ui) {
		ui.start(this);
		this.ui = ui;
		Pair<String, String> login;
		try {
			login = ui.getLogin();
			this.connectToDB(login.getKey(), login.getValue());
			ui.run();
		} catch (EASPException easpException) {
			this.handleEASPException(easpException);
		}
		closeUI();
	}

	//////////////////////////////////////////////////////////////////////////
	//
	// EXCEPTION-HANDLING
	//
	//////////////////////////////////////////////////////////////////////////

	@Override
	public void handleEASPException(EASPException easpException) {
		switch (easpException.getType()) {
		case E005:
			ui.showMessage("Unknown command");
			break;
		case E006:
			ui.showInputError(new Pair<String, String>(easpException.getParameters()[0], easpException.getParameters()[1]));
			break;
		default:
			ui.showError(easpException);
			break;
		}
	}

}
