package Contact;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	ContactService newList = new ContactService();
	
	@BeforeEach
	void createList() {
		newList = new ContactService();
	}
	//Test for throws
		//Tests Name field
		@Test
		void testContactNameIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{newList.newContact("Jarod Timms","","5551234","1234 aplacethatisreal blvd.");}
			);
		}
		@Test
		void testContactNameIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{newList.newContact(null,"Timms","5551234","1234 aplacethatisreal blvd.");}
			);
		}
		//Tests Phone Number field
		@Test
		void testContactPhoneNumberIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{newList.newContact("Jarod","Timms","55512345551234","1234 aplacethatisreal blvd.");}
			);
		}
		@Test
		void testContactPhoneNumberIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{newList.newContact("Jarod","Timms",null,"1234 aplacethatisreal blvd.");}
			);
		}
		//Tests Address Field
		@Test
		void testContactAddressIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{newList.newContact("Jarod","Timms","5551234","1234 aplacethatisreal blvd.1234 aplacethatisreal blvd.");}
			);
		}
		@Test
		void testContactAddressIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{newList.newContact("Jarod","Timms","5551234",null);}
			);
		}
		//Tests Update and Remove Functions
		@Test
		void testContactUpdate() {
			Assertions.assertThrows(Exception.class, () -> 
			{newList.updateFirstName(null,"Jared");}
			);
		}
		@Test
		void testContactDelete() {
			Assertions.assertThrows(Exception.class, () -> 
			{newList.deleteContact("1");}
			);
		}
		
	//Test for Assertions
		//Tests add
		@Test
		void testAdd() throws Exception {
			newList.newContact("Jarod", "Timms", "5551234", "1234 aplacethatisreal blvd.");
			assertTrue(newList.searchForContact("1").getFirstName().equals("Jarod"));
		}
		//Tests Update
		@Test
		void testUpdate() throws Exception {
			newList.newContact("Jarod", "Timms", "5551234", "1234 aplacethatisreal blvd.");
			newList.updateLastName("1", "NewName");
			assertTrue(newList.searchForContact("1").getLastName().equals("NewName"));
		}
		//Tests Delete
		@Test
		void testDelete() throws Exception {
			newList.newContact("Jarod", "Timms", "5551234", "1234 aplacethatisreal blvd.");
			assertTrue(newList.searchForContact("1").getPhoneNumber().equals("5551234"));
			newList.deleteContact("1");
			testContactDelete();
		}
}