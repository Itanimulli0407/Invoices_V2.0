package easp.facadeAPI;

public interface EASPFacade {

	public void connectToDB(String username, String password);
	
	public void handleServerError(Exception e);

	public void closeGUI();
	
}
