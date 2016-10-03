package easp.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import easp.commands.EASPCommand;
import easp.commands.EASPCommandEnum;
import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
import easp.facadeAPI.EASPFacade;
import easp.userInterfaceAPI.EASPUserInterface;
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
	public Map<String, String> getCustomerData() throws EASPException {
		Map<String, String> result = new HashMap<>();
		InputStreamReader isr = null;
		BufferedReader br = null;

		String firstName = "";
		String lastName = "";
		String birthday = "";
		String street = "";
		String zipCode = "";
		String city = "";
		String email = "";
		String privateNumber = "";
		String mobileNumber = "";
		String workNumber = "";
		String faxNumber = "";

		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);

			System.out.println("First Name:");
			firstName = br.readLine();
			System.out.println("Last Name:");
			lastName = br.readLine();
			System.out.println("Birthday (yyyy-mm-dd):");
			birthday = br.readLine();
			System.out.println("Street:");
			street = br.readLine();
			System.out.println("Zip-Code:");
			zipCode = br.readLine();
			System.out.println("City:");
			city = br.readLine();
			System.out.println("Email:");
			email = br.readLine();
			System.out.println("Number Private:");
			privateNumber = br.readLine();
			System.out.println("Number Mobile:");
			mobileNumber = br.readLine();
			System.out.println("Number Work:");
			workNumber = br.readLine();
			System.out.println("Number Fax:");
			faxNumber = br.readLine();
			
			result.put("firstName", firstName);
			result.put("lastName", lastName);
			result.put("birthday", birthday);
			result.put("street", street);
			result.put("zipCode", zipCode);
			result.put("city", city);
			result.put("email", email);
			result.put("privateNumber", privateNumber);
			result.put("mobileNumber", mobileNumber);
			result.put("workNumber", workNumber);
			result.put("faxNumber", faxNumber);	
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new EASPException(EASPExceptionEnum.E004, e, firstName, lastName, birthday, street, zipCode, city,
					email, privateNumber, mobileNumber, workNumber, faxNumber);
		}
		return result;
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
		EASPCommand result = new EASPCommand(EASPCommandEnum.DEFAULT);
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
		EASPCommand command = new EASPCommand(EASPCommandEnum.DEFAULT);
		while (true) {
			command = readCommand();
			easpFacade.executeCommand(command);
		}
	}

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void showImportantMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void showError(EASPException easpException) {
		System.err.println("Error!");
		System.err.println(easpException.getOldException());
		if (easpException.getParameters() != null) {
			System.err.println("Parameters: ");
			for (String parameter : easpException.getParameters()) {
				System.err.println(parameter);
			}
		}
	}

	@Override
	public void showInputError(Pair<String, String> inputPair) {
		System.err.println("Input error in field: " + inputPair.getKey());
		System.err.println("Input was: " + inputPair.getValue());
	}

}