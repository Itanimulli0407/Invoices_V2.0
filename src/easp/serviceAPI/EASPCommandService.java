package easp.serviceAPI;

import easp.commands.EASPCommand;
import easp.exceptions.EASPException;

public interface EASPCommandService {

	public EASPCommand createCommand(String input);
	
	public void executeCommand(EASPCommand command) throws EASPException;
	
}
