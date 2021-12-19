package Contact;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	//Tests for successful constructor
	@Test
	void testContactClass() {
		Contact contact = new Contact("12345","Jarod","Timms","5551234","1234 aplacethatisreal blvd.");
		assertTrue(contact.getContactId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Jarod"));
		assertTrue(contact.getLastName().equals("Timms"));
		assertTrue(contact.getPhoneNumber().equals("5551234"));
		assertTrue(contact.getAddress().equals("1234 aplacethatisreal blvd."));
	}
	
	//Tests ID field locally as ContactService generates ID
	@Test
	void testContactIdIsTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact("12345678910","Jarod","Timms","5551234","1234 aplacethatisreal blvd.");}
		);
	}
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> 
		{new Contact( null,"Jarod","Timms","5551234","1234 aplacethatisreal blvd.");}
		);
	}
	
}
