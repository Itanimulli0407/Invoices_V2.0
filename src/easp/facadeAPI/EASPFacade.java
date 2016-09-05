package easp.facadeAPI;

import java.sql.SQLException;

import easp.commands.EASPCommand;
import easp.exceptions.EASPException;
import easp.userInterfaceAPI.EASPUserInterface;

public interface EASPFacade {
	
	// ---------------------------------- DB ---------------------------------- //

	public void connectToDB(String username, String password);
	
	public void closeConnection();
	
	public void createNewCustomer() throws SQLException;
		
	// ------------------------------ UserInterface --------------------------- //
	
	public void startUI(EASPUserInterface ui);
	
	public void closeUI();
	
	public EASPCommand createCommand(String input);
	
	public void executeCommand(EASPCommand command);
			
	// -------------------------------- Exceptions ---------------------------- //
	
	public void handleEASPException(EASPException easpException);
	
}
