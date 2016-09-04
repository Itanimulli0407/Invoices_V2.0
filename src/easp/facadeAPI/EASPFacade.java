package easp.facadeAPI;

import easp.UserInterface.EASPUserInterface;
import easp.exceptions.EASPException;

public interface EASPFacade {
	
	// ---------------------------------- DB ---------------------------------- //

	public void connectToDB(String username, String password);
	
	public void closeConnection();
		
	// ------------------------------ UserInterface --------------------------- //
	
	public void startUI(EASPUserInterface ui);
	
	public void closeUI();
	
	void run();
	
	// -------------------------------- Exceptions ---------------------------- //
	
	public void handleEASPException(EASPException easpException);

	
}
