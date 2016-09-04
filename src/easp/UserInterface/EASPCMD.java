package easp.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
import easp.facade.EASPFacadeImpl;
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
			System.out.print("Username: \n");
			username = br.readLine();
			System.out.print("Password: \n");
			password = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new EASPException(EASPExceptionEnum.E004, e, "Username: " + username,"Password: " + password);
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

	@Override
	public String readCommand() throws EASPException {
		String result = "";
		try {
			System.out.println("Type command: \n");
			result = commandReader.readLine();
		} catch (IOException ioException) {
			throw new EASPException(EASPExceptionEnum.E004, ioException, result);
		}
		return result;
	}

}