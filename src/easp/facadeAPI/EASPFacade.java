package easp.facadeAPI;

import easp.exceptions.EASPException;

public interface EASPFacade {
	
	// ---------------------------------- DB ---------------------------------- //

	public void connectToDB(String username, String password);
	
	public void closeConnection();
		
	// ---------------------------------- GUI ---------------------------------- //
	
	public void startGUI();
	
	public void closeGUI();
	
	// -------------------------------- Exceptions -------------------------------- //
	
	public void handleEASPException(EASPException easpException);
	
}
