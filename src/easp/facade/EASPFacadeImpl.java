package easp.facade;

import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import easp.service.EASPLoginServiceImpl;

public class EASPFacadeImpl implements EASPFacade {
	
	public static void main (String[] args){
		EASPFacadeImpl impl = new EASPFacadeImpl();
		impl.connectToDB("lukas", "");
	}
	
	@Override
	public void connectToDB(String username, String password) {
		EASPLoginServiceImpl loginService = new EASPLoginServiceImpl();
		try {
			loginService.connect(username, password);
		} catch (EASPException easpException) {
			System.out.println(easpException.getOldException().getMessage());
			// TODO: showServerErrorMessage -> GUI
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void handleServerError(Exception e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeGUI() {
		// TODO Auto-generated method stub

	}

}
