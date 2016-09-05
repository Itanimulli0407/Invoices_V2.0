package easp.service;

import java.io.IOException;

import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
import easp.serviceAPI.EASPCheckService;

public class EASPCheckServiceImpl implements EASPCheckService {

	@Override
	public boolean checkFirstName(String firstName) throws EASPException {
		if (!firstName.matches("[a-zA-Z\\-\\söüäß]*") || firstName.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "First Name" ,firstName));
		}
		return true;
	}

	@Override
	public boolean checkLastName(String lastName) throws EASPException {
		if (!lastName.matches("[a-zA-Z\\-\\söüäß]*") || lastName.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "Last Name", lastName));
		}
		return true;
	}

	@Override
	public boolean checkBirthday(String birthday) throws EASPException {
		if (!birthday.equals("") && !birthday.matches("\\d\\d\\d\\d\\-\\d\\d\\-\\d\\d")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "Birthday", birthday));
		}
		return true;
	}

	@Override
	public boolean checkStreet(String street) throws EASPException {
		if (!street.matches("[a-zA-Z_0-9öüäß\\-\\s]*") || street.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "Street", street));
		}
		return true;
	}

	@Override
	public boolean checkZipCode(String zipCode) throws EASPException {
		if (!zipCode.matches("[0-9][0-9][0-9][0-9][0-9]") || zipCode.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "Zip Code", zipCode));
		}
		return true;
	}

	@Override
	public boolean checkCity(String city) throws EASPException {
		if (!city.matches("[a-zA-Z_0-9öüäß\\-\\s]*") || city.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "City", city));
		}
		return true;
	}

	@Override
	public boolean checkEmail(String email) throws EASPException {
		if (!email.matches("[a-z0-9\\.\\-_]*@[a-z0-9\\.\\-_]*") && !email.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "E-Mail", email));
		}
		return true;
	}

	@Override
	public boolean checkPhoneNumber(String phoneNumber) throws EASPException {
		if (!phoneNumber.matches("[0-9\\-_/\\s+]*") && !phoneNumber.equals("")) {
			throw (new EASPException(EASPExceptionEnum.E006, new IOException(), "Phone Number", phoneNumber));
		}
		return true;
	}

}
