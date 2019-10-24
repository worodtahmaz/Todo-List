package individualProjectApp;

import individualProject.Project;
import individualProject.Task;

import individualProject.User;
import individualProject.UserReg;

public  class Controller {
	private UserReg userReg ;
	private String userName;
	private String password;
	
	public Controller(UserReg userReg, String userName ,String Password) {
		
		this.userReg = userReg;
		this.userName= userName;
		this.password = Password;
	}
	
	public String getUserNames() {
		return userName;
	}

	public void setUserNames(String userName) {
		this.userName = userName;
	}

	public String getPasswords() {
		return password;
	}
	public void setPasswords(String password) {
		this.password = password;
	}

	public UserReg getUserReg() {
		return userReg;
	}

	public void setUserreg(UserReg userReg) {
		this.userReg = userReg;
	}
	
	public User getUser() {
		User tmp = getUserReg().signIn(getUserNames(), getPasswords());
		return tmp;
	}
	
	// Search project
	public Project searchProject (String name) {
		Project tempProject;
		int i = 0;
		boolean find = false;
		int index = -1;
		
		while (i < this.getUser().getProjects().size() && find == false) {
			tempProject = this.getUser().getProjects().get(i);
			if (tempProject.getTitle().equals(name)) {
				index = i;
				find = true;
			}
			i++;
		}
		if (index != -1) {
			tempProject = this.getUser().getProjects().get(index);
		}
		else {
			tempProject = null;
		}
		return tempProject;
	}	
	
	// Tasks to do and tasks are done
	public String todoTask () {
		String result = null;
		int notDone = 0;
		int done = 0;
		for (int i = 0; i < this.getUser().getProjects().size(); i++) {
			Project tempProject = this.getUser().getProjects().get(i);
			for (int index = 0; index < tempProject.getTasks().size(); index++) {
				Task tempTask = tempProject.getTasks().get(index);
				if (tempTask.getMarkAsDone() == true) {
					done++;
				}
				else {
					notDone++;
				}
			}	
		}
		result = " You have " + notDone + " tasks todo and " + done + " tasks are done!" ;
		return result;		
	}
	
}
