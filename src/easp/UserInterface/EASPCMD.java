package easp.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
//import easp.exceptions.EASPExceptionEnum;
import javafx.util.Pair;

public class EASPCMD implements EASPUserInterface {

	public static void main(String[] args) throws EASPException{
		EASPCMD cmd = new EASPCMD();
		cmd.getLogin();
	}

	@Override
	public Pair<String, String> getLogin() throws EASPException {
		InputStreamReader isr = null;
		BufferedReader br = null;
		String username = "";
		String password = "";
	    
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
	    
			System.out.print("Username: ");
			username = br.readLine();
			System.out.print("Password: ");
			password = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new EASPException(EASPExceptionEnum.E004, e, "Username: " + username,"Password: " + password);
		}
		
	    System.out.println("Username: " + username + "  --   Password: " + password);
	    return new Pair<String, String>(username, password);
	}

}