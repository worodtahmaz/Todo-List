package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import individualProject.Task;

public class TaskTest {
	
	private Task task;

	@Before
	public void setUp()  {
		task = new Task ("Shopping", "2010-05-10", true);
	}

	@Test
	public void testTitleThrowError() {
		try {
			task.setTitle(null);
			fail("This title is empty ");
		}
		catch(IllegalArgumentException e) {		
		}
	}
	
	@Test
	public void testDueDateThrowError() {
		try {
			task.setDueDate(null);
			fail("This dueDate is empty ");
		}
		catch(IllegalArgumentException e) {	
		}
		try {
			task.setDueDate("");
			fail("This dueDate is not dateformate ");
		}
		catch(IllegalArgumentException e) {	
		}
	}
	
	@Test
	public void testMarkAsDoneThrowError() {
		try {
			task.setMarkAsDone(null);
			fail("Mark as done is empty ");
		}
		catch(IllegalArgumentException e) {		
		}
	}

	@Test
	public void testStatus() {
		
		assertEquals("done", task.status());;
	}
}
