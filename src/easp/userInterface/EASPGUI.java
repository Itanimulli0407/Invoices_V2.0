package easp.userInterface;

import java.util.Map;

import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import easp.userInterfaceAPI.EASPUserInterface;
import javafx.util.Pair;

public class EASPGUI implements EASPUserInterface {

	@Override
	public Pair<String, String> getLogin() throws EASPException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, String> getCustomerData() throws EASPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(EASPFacade easpFacade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() throws EASPException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showImportantMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showError(EASPException easpException) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showInputError(Pair<String, String> inputPair) {
		// TODO Auto-generated method stub
		
	}

}
