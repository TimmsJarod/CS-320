package Contact;

public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address)
	{
		updateContactId(contactID);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phone);
		updateAddress(address);
		
	}
	
	//Setters for each field with check
	void updateContactId(String contactId_) 
	{
		if (contactId_ == null || contactId_.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.contactID = contactId_;
	}
	void updateFirstName(String firstname_)
	{
		if (firstname_ == null || firstname_.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstname_;
	}	
	void updateLastName(String lastname_)
	{
		if (lastname_ == null || lastname_.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastname_;
	}
	void updatePhoneNumber(String phone_)
	{
		if (phone_ == null || phone_.length() > 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone_;
	}
	void updateAddress(String address_)
	{
		if (address_ == null || address_.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address_;
	}
	
	//Value Get methods
	String getContactId()
	{
		return contactID;
	}
	String getFirstName()
	{
		return firstName;
	}
	String getLastName()
	{
		return lastName;
	}
	String getPhoneNumber()
	{
		return phone;
	}
	String getAddress()
	{
		return address;
	}
};
