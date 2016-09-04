package easp.UserInterface;

import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import javafx.util.Pair;

public interface EASPUserInterface {

	public Pair<String, String> getLogin() throws EASPException;

	public void start(EASPFacade easpFacade);

	public void close();

	public void run() throws EASPException;
	
	public void showMessage(String message);
	
	public void showImportantMessage(String message);
	
	public void showError(EASPException easpException);
	
}
