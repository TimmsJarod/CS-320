package Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
	private List<Task> taskList = new ArrayList<>();
	private int intId = 0;
	private String uniqueId;
	
	//Generates incremented ID in order of creation
	private String generateId() {
		  intId++;
		  return uniqueId = String.valueOf(intId);
		  }
	  //Creates a new task, generates an id, and adds to list
	  public void newTask(String name, String disc) {
	    Task task =
	        new Task(generateId(), name, disc);
	    taskList.add(task);
	  }
	  //Deletes task from list based off ID search
	  public void deleteTask(String taskID) throws Exception {
		  taskList.remove(searchForTask(taskID));
	  }
	  //Updates Task name after searching ID
	  public void updateTaskName(String taskID, String name) throws Exception {
		  searchForTask(taskID).updateTaskName(name);
	  }
	  //Updates Task name after searching ID
	  public void updateTaskDescription(String taskID, String disc) throws Exception {
		  searchForTask(taskID).updateDescription(disc);
	  }
	  //list search used by other functions.
	  public Task searchForTask(String taskID) throws Exception {
	    int index = 0;
	    while (index < taskList.size()) {
	      if (taskID.equals(taskList.get(index).getTaskId())) {
	        return taskList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("No task found.");
	  }
}