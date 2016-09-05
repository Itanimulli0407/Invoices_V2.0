package easp.serviceAPI;

import easp.exceptions.EASPException;

public interface EASPCheckService {

	public boolean checkFirstName(String firstName) throws EASPException;
	
	public boolean checkLastName(String lastName) throws EASPException;
	
	public boolean checkBirthday(String birthday) throws EASPException;
	
	public boolean checkStreet(String street) throws EASPException;
	
	public boolean checkZipCode(String zipCode) throws EASPException;
	
	public boolean checkCity(String city) throws EASPException;
	
	public boolean checkEmail(String email) throws EASPException;
	
	public boolean checkPhoneNumber(String phoneNumber) throws EASPException;

}
