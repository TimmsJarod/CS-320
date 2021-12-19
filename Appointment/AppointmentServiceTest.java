package Appointment;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	AppointmentService newList = new AppointmentService();

	@BeforeEach
	void createList() {
		newList = new AppointmentService();
	}
	
	//Test for throws
			//Tests Date field - Cannot be in the past.
			@Test
			void testAppNameIsTooLong() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newAppointment(1990, 1, 31 ,"Just a discription.");}
				);
			}
			
			//Tests Description field - Limit of fifty characters and cannot be null.
			@Test
			void testAppDiscIsTooLong() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newAppointment(2099, 1, 31,
				">>>>>>>>>>>>>>>>>>>>>>>>>TaskDisc<<<<<<<<<<<<<<<<<<<<<<<<");}
				);
			}
			@Test
			void testAppDiscIsNull() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newAppointment(2099, 1, 31, null);}
				);
			}
			@Test
			void testAppDelete() {
				Assertions.assertThrows(Exception.class, () -> 
				{newList.deleteAppointment("1");}
				);
			}
	//Test for Assertions
			//Tests add
			@Test
			void testAdd() throws Exception {
				newList.newAppointment(2099, 1, 31, "Task Description");
				assertTrue(newList.searchForAppointment("1").getDescription().equals("Task Description"));
			}
			
			//Tests Delete
			@Test
			void testDelete() throws Exception {
				newList.newAppointment(2099, 1, 31, "Description");
				assertTrue(newList.searchForAppointment("1").getDescription().equals("Description"));
				newList.deleteAppointment("1");
				testAppDelete();
			}

}
