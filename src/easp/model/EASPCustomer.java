package easp.model;

import java.util.HashMap;
import java.util.Map;

public class EASPCustomer {

	private String firstName, lastName;
	private String birthday; // Format: yyyy.MM.dd
	private String street;
	private Integer zipCode;
	private String city;
	private String mailAdress;
	private String privateNumber;
	private String mobileNumber;
	private String workNumber;
	private String faxNumber;
	private Integer id;

	// TODO: null Werte zulassen -> Im Customer Overview abfangen
	public EASPCustomer() {
		
	}

	public EASPCustomer(Map<String, Object> customerData) {
		
	}

	@Override
	public String toString() {
		return (firstName.toString() + "\n" + lastName.toString() + "\n" + birthday.toString() + "\n" + mailAdress.toString()
				+ "\n" + street.toString() + "\n" + zipCode.toString() + "\n" + city.toString() + "\n"
				+ privateNumber.toString());
	}

	public Map<String, String> getNumbers() {
		Map<String, String> map = new HashMap<>();
		if (!this.getPrivateNumber().trim().equals("")) {
			map.put("private", this.getPrivateNumber());
		}
		if (!this.getMobileNumber().trim().equals("")) {
			map.put("mobile", this.getMobileNumber());
		}
		if (!this.getWorkNumber().trim().equals("")) {
			map.put("work", this.getWorkNumber());
		}
		if (!this.getFaxNumber().trim().equals("")) {
			map.put("fax", this.getFaxNumber());
		}
		return map;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public String getPrivateNumber() {
		return privateNumber;
	}

	public void setPrivateNumber(String privateNumber) {
		this.privateNumber = privateNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
