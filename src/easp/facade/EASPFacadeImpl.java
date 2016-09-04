package easp.facade;

import java.sql.Connection;

import easp.UserInterface.EASPUserInterface;
import easp.commands.EASPCommand;
import easp.commands.EASPCommandEnum;
import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import easp.service.EASPCommandServiceImpl;
import easp.service.EASPLoginServiceImpl;
import easp.serviceAPI.EASPCommandService;
import javafx.util.Pair;


public class EASPFacadeImpl implements EASPFacade {
	
	EASPLoginServiceImpl loginService;
	Connection dbConnection;
	private EASPUserInterface ui;
		
	//////////////////////////////////////////////////////////////////////////
	//																		//
	//								COMMANDS								//
	//																		//
	//////////////////////////////////////////////////////////////////////////
	
	@Override
	public void executeCommand(EASPCommand command) {
		if (command.getType().equals(EASPCommandEnum.EXIT)){
			this.closeUI();
		} else {
			System.out.println("Command not available");
		}
	}
	
	@Override
	public EASPCommand createCommand(String input) {
		EASPCommand result = null;
		EASPCommandService commandService = new EASPCommandServiceImpl();
		result = commandService.createCommand(input);
		return result;
	}
	
	//////////////////////////////////////////////////////////////////////////
	//																		//
	//								DATABASE								//
	//																		//
	//////////////////////////////////////////////////////////////////////////
	
	@Override
	public void connectToDB(String username, String password) {
		loginService = new EASPLoginServiceImpl();
		try {
			dbConnection = loginService.connect(username, password);
			System.out.println("Connection established");
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
			System.out.println("Connection closed");
		} catch (EASPException easpException){
			handleEASPException(easpException);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////
	//																		//
	//							USER-INTERFACE								//
	//																		//
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
	//																		//
	//							EXCEPTION-HANDLING							//
	//																		//
	//////////////////////////////////////////////////////////////////////////

	@Override
	public void handleEASPException(EASPException easpException) {
		
		// TODO: Show error messages in GUI
		
		switch (easpException.getType()){
		// Server Error
		case E001:
			System.err.println(easpException.getOldException());
			System.err.println("Parameters:");
			for (String p : easpException.getParameters()){
				System.err.println(p);
			}
			break;
		// Null Pointer Error
		case E002:
			System.err.println(easpException.getOldException());
			System.err.println("Parameters:");
			if (easpException.getParameters() != null){
				for (String p : easpException.getParameters()){
					System.err.println(p);
				}
			}
			easpException.getOldException().printStackTrace();
			break;
		// SQL Error
		case E003:
			System.err.println(easpException.getOldException());
			System.err.println("Parameters:");
			for (String p : easpException.getParameters()){
				System.err.println(p);
			}
			break;
		default:
			System.err.println(easpException.getOldException());
			System.err.println("Parameters:");
			for (String p : easpException.getParameters()){
				System.err.println(p);
			}
			break;
		}
	}

}
