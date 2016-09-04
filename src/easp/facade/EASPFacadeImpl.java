package easp.facade;

import java.sql.Connection;

import easp.exceptions.EASPException;
import easp.facadeAPI.EASPFacade;
import easp.service.EASPLoginServiceImpl;


public class EASPFacadeImpl implements EASPFacade {
	
	EASPLoginServiceImpl loginService;
	Connection dbConnection;
	
	public static void main (String[] args){
		EASPFacadeImpl impl = new EASPFacadeImpl();
		impl.connectToDB("lukas", "");
		impl.closeConnection();
	}
	
	//////////////////////////////////////////////////////////////////////////
	//																		//
	//								DATABASE								//
	//																		//
	//////////////////////////////////////////////////////////////////////////
	
	@Override
	public void connectToDB(String username, String password) {
		//dbConnection = null;
		loginService = new EASPLoginServiceImpl();
		try {
			dbConnection = loginService.connect(username, password);
			System.out.println("Connection established");
		} catch (EASPException easpException) {
			handleEASPException(easpException);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void closeConnection() {
		try {
			loginService.closeConnection(dbConnection);
			System.out.println("Connection closed");
		} catch (EASPException easpException){
			handleEASPException(easpException);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////
	//																		//
	//							USER-INTERFACE								//
	//																		//
	//////////////////////////////////////////////////////////////////////////
	
	@Override
	public void closeUI() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startUI() {
		// TODO Auto-generated method stub
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	//																		//
	//							EXCEPTION-HANDLING							//
	//																		//
	//////////////////////////////////////////////////////////////////////////
	
	@Override
	public void handleEASPException(EASPException easpException) {
		
		// TODO: Show error messages in GUI
		
		switch (easpException.getType()){
		// Server Error
		case E001:
			System.out.println(easpException.getOldException());
			System.out.println("Parameters:");
			for (String p : easpException.getParameters()){
				System.out.println(p);
			}
			break;
		// Null Pointer Error
		case E002:
			System.out.println(easpException.getOldException());
			System.out.println("Parameters:");
			if (easpException.getParameters() != null){
				for (String p : easpException.getParameters()){
					System.out.println(p);
				}
			}
			easpException.getOldException().printStackTrace();
			break;
		// SQL Error
		case E003:
			System.out.println(easpException.getOldException());
			System.out.println("Parameters:");
			for (String p : easpException.getParameters()){
				System.out.println(p);
			}
			break;
		default:
			System.out.println(easpException.getOldException());
			System.out.println("Parameters:");
			for (String p : easpException.getParameters()){
				System.out.println(p);
			}
			break;
		}
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}

}
