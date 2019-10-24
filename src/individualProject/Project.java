package individualProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Project implements Serializable {
	
	private String title;
	private ArrayList<Task> tasks = new ArrayList<>();
	
	public Project (String title) {
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null)
			throw new IllegalArgumentException();
		this.title = title;
	}

	public ArrayList<Task> getTasks() {
		Collections.sort(tasks, TaskDateComparator);
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
		
	// add Task in to the Project
	public void addTask (Task task) {
		Task tempTask;
		tempTask = this.searchTask(task.getTitle());
		if (tempTask == null) {
			this.getTasks().add(task);
		}
		else {
			System.out.println("This task " +task.getTitle()+ " already found");
		}
	}
	
	// remove Task from the Project
	public void removeTask (String name) {
		
		Task tempTask;
		int index;
		tempTask = this.searchTask(name);
	    if(tempTask == null)
			throw new IllegalArgumentException();
		if (tempTask != null) {
		index = tasks.indexOf(tempTask);
		tasks.remove(index);
		
		}	
	}
	
	// search Task in the Project
	public Task searchTask (String name) {
		Task tempTask;
		int i = 0;
		boolean find = false;
		int index = -1;
		
		while (i < this.getTasks().size() && find == false) {
			tempTask = this.getTasks().get(i);
			if (tempTask.getTitle().equals(name)) {
				index = i;
				find = true;
			}
			i++;
		}
		if (index != -1) {
			tempTask = this.getTasks().get(index);
		}
		else {
			tempTask = null;
		}
		return tempTask;
	}
	
	// update Task in the Project
	public void updateTask (String oldTitle, String newTitle, String oldDate, String newDate) {
		Task tempTask;
		tempTask = this.searchTask(oldTitle);
		if (tempTask == null) 
			throw new IllegalArgumentException();
		tempTask.setTitle(newTitle);
		tempTask.setDueDate(newDate);
	}
	
    //Comparator for sorting the list by Task Date
	 public static Comparator<Task> TaskDateComparator = new Comparator<Task>() {

			public int compare(Task s1, Task s2) {
			   String TaskDate1 = s1.getDueDate();
			   String TaskDate2 = s2.getDueDate();

			   //ascending order
			   return TaskDate1.compareTo(TaskDate2);
		    }};
}
