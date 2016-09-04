package easp.UserInterface;

import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import javafx.util.Pair;

public interface EASPUserInterface {

	public Pair<String, String> getLogin() throws EASPException;

	public void start(EASPFacade easpFacade);

	public String readCommand() throws EASPException;

	public void close();
	
}
