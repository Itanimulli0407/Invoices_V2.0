package easp.facadeAPI;

import easp.UserInterface.EASPUserInterface;
import easp.commands.EASPCommand;
import easp.exceptions.EASPException;

public interface EASPFacade {
	
	// ---------------------------------- DB ---------------------------------- //

	public void connectToDB(String username, String password);
	
	public void closeConnection();
		
	// ------------------------------ UserInterface --------------------------- //
	
	public void startUI(EASPUserInterface ui);
	
	public void closeUI();
	
	public EASPCommand createCommand(String input);
	
	public void executeCommand(EASPCommand command);
			
	// -------------------------------- Exceptions ---------------------------- //
	
	public void handleEASPException(EASPException easpException);
	
}
