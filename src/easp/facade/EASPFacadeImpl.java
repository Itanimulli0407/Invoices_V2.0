package easp.facade;

import java.sql.Connection;

import easp.UserInterface.EASPUserInterface;
import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import easp.service.EASPLoginServiceImpl;
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
	
	private void executeCommand(String command) {
		switch(command){
		case "exit":
			closeConnection();
			closeUI();
			System.exit(0);
			break;
		default:
			System.out.println("Command not available");
			break;
		}
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
	}

	@Override
	public void startUI(EASPUserInterface ui) {
		ui.start(this);
		this.ui = ui;
		Pair<String, String> login;
		try {
			login = ui.getLogin();
			this.connectToDB(login.getKey(), login.getValue());
		} catch (EASPException e) {
			e.printStackTrace();
		}
		run();
	}
	
	@Override
	public void run() {
		String command = "initial";
		while (!command.equals("exit")){
			try {
				command = ui.readCommand();
				executeCommand(command);	
			} catch (EASPException easpException) {
				this.handleEASPException(easpException);
			}
		}
		closeConnection();
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
