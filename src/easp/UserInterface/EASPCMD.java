package easp.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import easp.commands.EASPCommand;
import easp.commands.EASPCommandEnum;
import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
import easp.facadeAPI.EASPFacade;
//import easp.exceptions.EASPExceptionEnum;
import javafx.util.Pair;

public class EASPCMD implements EASPUserInterface {

	private EASPFacade easpFacade;
	private BufferedReader commandReader;

	@Override
	public Pair<String, String> getLogin() throws EASPException {
		InputStreamReader isr = null;
		BufferedReader br = null;
		String username = "";
		String password = "";

		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);

			System.out.println("Please login to access customer data.");
			System.out.println("Username: ");
			username = br.readLine();
			System.out.println("Password: ");
			password = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new EASPException(EASPExceptionEnum.E004, e, "Username: " + username, "Password: " + password);
		}

		return new Pair<String, String>(username, password);
	}

	@Override
	public void start(EASPFacade easpFacade) {
		this.easpFacade = easpFacade;
		System.out.println("------------------------------------------");
		System.out.println("--                                      --");
		System.out.println("--         WELCOME TO EASP 2016         --");
		System.out.println("--                                      --");
		System.out.println("------------------------------------------");
		InputStreamReader isr = new InputStreamReader(System.in);
		this.commandReader = new BufferedReader(isr);
	}

	@Override
	public void close() {
		System.out.println("Bye!");
	}

	private EASPCommand readCommand() throws EASPException {
		EASPCommand result = new EASPCommand(EASPCommandEnum.DEAULT);
		try {
			System.out.println("Type command: ");
			String input = commandReader.readLine();
			result = easpFacade.createCommand(input);
		} catch (IOException ioException) {
			throw new EASPException(EASPExceptionEnum.E004, ioException, result.getType().toString());
		}
		System.out.println("Command: " + result.getType());
		return result;
	}

	@Override
	public void run() throws EASPException {
		EASPCommand command = new EASPCommand(EASPCommandEnum.DEAULT);
		while (true) {
			command = readCommand();
			easpFacade.executeCommand(command);
		}
	}

}