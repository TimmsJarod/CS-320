package Appointment;
import java.time.LocalDate;

public class Appointment {
	private String appID;
	private String date; //consider storing to string for output
	private String disc;
	
	//Constructor
		public Appointment(String id, LocalDate date, String disc)
		{
			updateAppointId(id);
			updateAppointDate(date);
			updateDescription(disc);
			
		}
	
		//Setters for the Task Class
	void updateAppointId(String taskId_) 
	{
		if (taskId_ == null || taskId_.length() > 10) 
		{throw new IllegalArgumentException("Invalid ID");}
		
		this.appID = taskId_;
		}
	
	void updateAppointDate(LocalDate date_)
	{
		LocalDate currDate = LocalDate.now();
		
		if (date_ == null ||
		   (currDate.getYear() > date_.getYear()) ||
		   (currDate.getYear() == date_.getYear() && currDate.getDayOfYear() > date_.getDayOfYear())
		   ) {throw new IllegalArgumentException("Invalid date");}
		
		this.date = date_.toString();
	}
	
	void updateDescription(String disc_)
	{
		if (disc_ == null || disc_.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.disc = disc_;
	}
	
	//Getters for the Task class
	String getAppointId()
	{
		return appID;
	}
	String getAppointDate()
	{
		return date;
	}
	String getDescription()
	{
		return disc;
	}
}
