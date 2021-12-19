package Task;

public class Task {
	private String taskID;
	private String name;
	private String disc;
	
	//Constructor
		public Task(String taskID, String name, String disc)
		{
			updateTaskId(taskID);
			updateTaskName(name);
			updateDescription(disc);
			
		}
	
		//Setters for the Task Class
	void updateTaskId(String taskId_) 
	{
		if (taskId_ == null || taskId_.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.taskID = taskId_;
	}
	void updateTaskName(String name_)
	{
		if (name_ == null || name_.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		this.name = name_;
	}	
	void updateDescription(String disc_)
	{
		if (disc_ == null || disc_.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.disc = disc_;
	}
	
	//Getters for the Task class
	String getTaskId()
	{
		return taskID;
	}
	String getTaskName()
	{
		return name;
	}
	String getDescription()
	{
		return disc;
	}
}
