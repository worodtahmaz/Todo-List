package individualProject;

import java.util.ArrayList;
import java.io.Serializable;


public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private ArrayList<Project> projects = new ArrayList<>();
	
	public User() {}
	public User (String name, String password) {
		this.setName(name);
		this.setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// add Project in to the User
	public void addProject (Project project) {
		this.getProjects().add(project);
	}
	// search Project
	public Project searchProject (String name) {
		Project tempProject;
		int i = 0;
		boolean find = false;
		int index = -1;
		
		while (i < this.getProjects().size() && find == false) {
			tempProject = this.getProjects().get(i);
			if (tempProject.getTitle().equals(name)) {
				index = i;
				find = true;
			}
			i++;
		}
		if (index != -1) {
			tempProject = this.getProjects().get(index);
		}
		else {
			tempProject = null;
		}
		return tempProject;
	}	
}
