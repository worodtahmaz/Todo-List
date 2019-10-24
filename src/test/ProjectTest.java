package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import individualProject.Project;
import individualProject.Task;

public class ProjectTest {
	
	private Project project;
	private Task task;

	@Before
	public void setUp() {
		project  = new Project ("Shopping");
		task = new Task("Milk", "2019-01-01", true);
		project.addTask(task);		
	}

	@Test
	public void testTitleThrowError() {
		try {
			project.setTitle(null);
		fail("This title is empty");
		}
		catch (IllegalArgumentException e) {
		}	
	}

	@Test
	public void testAddTask() {
		assertEquals("Milk", project.getTasks().get(0).getTitle());	
	}

	@Test
	public void testSearchTask() {
		assertNotEquals(null, project.searchTask("Milk"));
	}

	@Test
	public void testUpdateTask() {
		try {
			project.updateTask("Milk", "Cofee", "2019-01-01", "2019-10-01");
		}
		catch (IllegalArgumentException e) {
			fail("Not updated");	
		}
	}
	@Test
	public void testRemoveTask() {
		try {
			project.removeTask("Milk");		
		}
		catch (IllegalArgumentException e) {
			fail ("Task not found");
		}
	}
}
