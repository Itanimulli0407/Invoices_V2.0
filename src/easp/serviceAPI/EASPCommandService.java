package easp.serviceAPI;

import java.sql.SQLException;

import easp.commands.EASPCommand;
import easp.exceptions.EASPException;

public interface EASPCommandService {

	public EASPCommand createCommand(String input);
	
	public void executeCommand(EASPCommand command) throws EASPException, SQLException;
	
}
