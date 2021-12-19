package Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

  private List<Contact> contactList = new ArrayList<>();
  private int intId = 0;
  private String uniqueId;
  
  private String generateId() {
	  intId++;
	  return uniqueId = String.valueOf(intId);
	  }

  public void newContact(String firstName, String lastName, String phone,String address) {
    Contact contact =
        new Contact(generateId(), firstName, lastName, phone, address);
    contactList.add(contact);
  }

  public void deleteContact(String contactID) throws Exception {
    contactList.remove(searchForContact(contactID));
  }

  public void updateFirstName(String contactID, String firstName) throws Exception {
    searchForContact(contactID).updateFirstName(firstName);
  }

  public void updateLastName(String contactID, String lastName) throws Exception {
    searchForContact(contactID).updateLastName(lastName);
  }

  public void updatePhoneNumber(String contactID, String phone) throws Exception {
    searchForContact(contactID).updatePhoneNumber(phone);
  }

  public void updateAddress(String contactID, String address) throws Exception {
    searchForContact(contactID).updateAddress(address);
  }

  public Contact searchForContact(String contactID) throws Exception {
    int index = 0;
    while (index < contactList.size()) {
      if (contactID.equals(contactList.get(index).getContactId())) {
        return contactList.get(index);
      }
      index++;
    }
    throw new Exception("No contact found.");
  }
}