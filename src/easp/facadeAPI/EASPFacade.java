package easp.facadeAPI;

import easp.exceptions.EASPException;

public interface EASPFacade {
	
	// ---------------------------------- DB ---------------------------------- //

	public void connectToDB(String username, String password);
	
	public void closeConnection();
		
	// ------------------------------ UserInterface --------------------------- //
	
	public void startUI();
	
	public void closeUI();
	
	// -------------------------------- Exceptions ---------------------------- //
	
	public void handleEASPException(EASPException easpException);
	
}
