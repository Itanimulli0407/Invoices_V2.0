package easp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import easp.exceptions.EASPException;
//import easp.exceptions.EASPExceptionEnum;

public class ESAPCMD {

	public static void main(String[] args) throws EASPException{
		InputStreamReader isr = null;
		BufferedReader br = null;
		String username = "";
		String login = "";
	    
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
	    
			System.out.print("Username: ");
			username = br.readLine();
			System.out.print("login: ");
			login = br.readLine();
			
		
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//throw new EASPException(EASPExceptionEnum.E001, e, "username: " + username,"login: " + login);
			

		}
	    System.out.println("username: " + username + "  --   login: " + login);

	}

}