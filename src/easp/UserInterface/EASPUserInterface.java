package easp.UserInterface;

import easp.exceptions.EASPException;
import javafx.util.Pair;

public interface EASPUserInterface {

	public Pair<String, String> getLogin() throws EASPException;
	
}
