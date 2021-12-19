package Appointment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class AppointmentTest {
	LocalDate initialDate = LocalDate.of(2099, 11, 26);

	@Test
	//This tests the construction of the Appointment object
	void testAppClass() {
		Appointment testApp = new Appointment("12345", initialDate,"Task Description");
		assertTrue(testApp.getAppointId().equals("12345"));
		assertTrue(testApp.getAppointDate().equals(initialDate.toString()));
		assertTrue(testApp.getDescription().equals("Task Description"));
	}

	//Tests ID field locally as TaskService generates ID
		@Test
		void testAppIdIsTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{new Appointment("12345678910",initialDate,"Task Description");}
			);
		}
		@Test
		//Tests to find if task ID throws when null
		void testAppIdIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{new Appointment( null,initialDate,"Task Description");}
			);
		}
		@Test
		//Tests to find if task Date throws when null
		void testAppDateIsNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> 
			{new Appointment( "12345",null,"Task Description");}
			);
		}

}
