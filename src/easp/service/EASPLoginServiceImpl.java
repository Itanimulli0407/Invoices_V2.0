package easp.service;

import easp.DAO.EASPConnectorImpl;
import easp.exceptions.EASPException;
import easp.serviceAPI.EASPLoginService;

public class EASPLoginServiceImpl implements EASPLoginService {

	@Override
	public void connect(String username, String password) throws EASPException {
		EASPConnectorImpl connector = new EASPConnectorImpl();
		try {
			connector.connect(username, password);
		} catch (EASPException easpException) {
			throw easpException;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public EASPException handleServerError() {
		// TODO Auto-generated method stub
		return null;
	}

}
