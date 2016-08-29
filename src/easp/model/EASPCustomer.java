package easp.model;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class EASPCustomer {

	private StringProperty firstName, lastName;
	private StringProperty birthday; // Format: yyyy.MM.dd
	private StringProperty street;
	private IntegerProperty zipCode;
	private StringProperty city;
	private StringProperty mailAdress;
	private StringProperty privateNumber;
	private StringProperty mobileNumber;
	private StringProperty workNumber;
	private StringProperty faxNumber;
	private IntegerProperty id;

	// TODO: null Werte zulassen -> Im Customer Overview abfangen
	public EASPCustomer() {
		this.id = new SimpleIntegerProperty(0);
	}

	@Override
	public String toString() {
		return (firstName.toString() + "\n" + lastName.toString() + "\n" + birthday.toString() + "\n" + mailAdress.toString()
				+ "\n" + street.toString() + "\n" + zipCode.toString() + "\n" + city.toString() + "\n"
				+ privateNumber.toString());
	}

	public Map<String, String> getNumbers() {
		Map<String, String> map = new HashMap<>();
		if (!this.getPrivateNumber().get().trim().equals("")) {
			map.put("Privat", this.getPrivateNumber().get());
		}
		if (!this.getMobileNumber().get().trim().equals("")) {
			map.put("Mobil", this.getMobileNumber().get());
		}
		if (!this.getWorkNumber().get().trim().equals("")) {
			map.put("Geschaeftlich", this.getWorkNumber().get());
		}
		if (!this.getFaxNumber().get().trim().equals("")) {
			map.put("Fax", this.getFaxNumber().get());
		}
		return map;
	}

	public StringProperty getFirstName() {
		return firstName;
	}

	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	public StringProperty getLastName() {
		return lastName;
	}

	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	public StringProperty getBirthday() {
		return birthday;
	}

	public void setBirthday(StringProperty birthday) {
		this.birthday = birthday;
	}

	public StringProperty getStreet() {
		return street;
	}

	public void setStreet(StringProperty street) {
		this.street = street;
	}

	public IntegerProperty getZipCode() {
		return zipCode;
	}

	public void setZipCode(IntegerProperty zipCode) {
		this.zipCode = zipCode;
	}

	public StringProperty getCity() {
		return city;
	}

	public void setCity(StringProperty city) {
		this.city = city;
	}

	public StringProperty getMailAdress() {
		return mailAdress;
	}

	public void setMail(StringProperty mailAdress) {
		this.mailAdress = mailAdress;
	}

	public StringProperty getPrivateNumber() {
		return privateNumber;
	}

	public void setPrivateNumber(StringProperty privateNumber) {
		this.privateNumber = privateNumber;
	}

	public StringProperty getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringProperty mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public StringProperty getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(StringProperty workNumber) {
		this.workNumber = workNumber;
	}

	public StringProperty getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(StringProperty faxNumber) {
		this.faxNumber = faxNumber;
	}

	public IntegerProperty getId() {
		return id;
	}

	public void setId(IntegerProperty id) {
		this.id = id;
	}

}
