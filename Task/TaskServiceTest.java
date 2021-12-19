package Task;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	TaskService newList = new TaskService();

	@BeforeEach
	void createList() {
		newList = new TaskService();
	}
	
	//Test for throws
			//Tests Name field - Limit of twenty characters and cannot be null.
			@Test
			void testTaskNameIsTooLong() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newTask("Task Name that is longer than twenty characters.","That's quite a task name.");}
				);
			}
			@Test
			void testTaskNameIsNull() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newTask(null,"Now the task name is gone.");}
				);
			}
			
			//Tests Description field - Limit of fifty characters and cannot be null.
			@Test
			void testTaskDiscIsTooLong() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newTask("Task",
				">>>>>>>>>>>>>>>>>>>>>>>>>TaskDisc<<<<<<<<<<<<<<<<<<<<<<<<");}
				);
			}
			@Test
			void testTaskDiscIsNull() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> 
				{newList.newTask("Task", null);}
				);
			}
			@Test
			void testTaskUpdate() {
				Assertions.assertThrows(Exception.class, () -> 
				{newList.updateTaskName(null,"Jared");}
				);
			}
			@Test
			void testTaskDelete() {
				Assertions.assertThrows(Exception.class, () -> 
				{newList.deleteTask("1");}
				);
			}
	//Test for Assertions
			//Tests add
			@Test
			void testAdd() throws Exception {
				newList.newTask("Task", "Task Description");
				assertTrue(newList.searchForTask("1").getTaskName().equals("Task"));
			}
			//Tests Update
			@Test
			void testUpdate() throws Exception {
				newList.newTask("Task", "Description");
				newList.updateTaskDescription("1", "NewName");
				assertTrue(newList.searchForTask("1").getDescription().equals("NewName"));
			}
			//Tests Delete
			@Test
			void testDelete() throws Exception {
				newList.newTask("Task", "Description");
				assertTrue(newList.searchForTask("1").getTaskName().equals("Task"));
				newList.deleteTask("1");
				testTaskDelete();
			}

}
