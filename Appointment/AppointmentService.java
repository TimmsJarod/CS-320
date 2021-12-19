package Appointment;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class AppointmentService {
	private List<Appointment> appList = new ArrayList<>();
	private int intId = 0;
	private String uniqueId;
	
	//Generates incremented ID in order of creation
	private String generateId() {
		  intId++;
		  return uniqueId = String.valueOf(intId);
		  }
	  //Creates a new appointment, generates an id, and adds to list
	  public void newAppointment(int year, int month, int day, String disc) throws Exception {
		  
			LocalDate newApp = LocalDate.of(year, month, day);
		
		
	    Appointment appointment = new Appointment(generateId(), newApp, disc);
	    appList.add(appointment);
	  }
	  //Deletes task from list based off ID search
	  public void deleteAppointment(String appID) throws Exception {
		  appList.remove(searchForAppointment(appID));
	  }
	  
	  //list search used by other functions.
	  public Appointment searchForAppointment(String appID) throws Exception {
	    int index = 0;
	    while (index < appList.size()) {
	      if (appID.equals(appList.get(index).getAppointId())) {
	        return appList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("No appointment found.");
	  }
}
