package individualProject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserReg userReg = new UserReg ();
		userReg.readFromFile();
		System.out.println(userReg.getUsers().get(0).getProjects().get(0).getTitle());
	
		// Create the following projects:
		Project project1 = new Project("Shopping");
		Project project2 = new Project("Cleaning");
		
		// Create the following users to projects above :
		User user1 = new User("Maria", "123" );
		user1.addProject(project1);;
		User user2 = new User("Ahmad","456");
		user2.addProject(project2);;
		
        //Add the users in to the register
		userReg.addUser(user1);
		userReg.addUser(user2);
		
		// Create the following tasks:
		Task task2 = new Task("Milk", "2019-01-01", true);
		Task task3 = new Task("Cofee", "2019-10-01", true);

        //Add tasks in to the project
		//project1.addTask(task1);
		project1.addTask(task3);
		project2.addTask(task2);
		
		Task tempTask;
		tempTask = project2.searchTask("Milk");
		System.out.println(tempTask.getTitle());
		System.out.println(tempTask.getDueDate());
		System.out.println(tempTask.getMarkAsDone());
		
		project2.updateTask("Milk", "soap", "2019-10-25", "2020-01-01");
		System.out.println(task2.getTitle());
		System.out.println(task2.getDueDate());
		System.out.println(project2.searchTask("soap").getTitle());
		
		User tempUser;
		tempUser = userReg.signIn("Ahmad","456");
		System.out.println(tempUser.getName() + tempUser.getPassword());
		
		tempTask.status();
		userReg.writeToFile();
		userReg.readFromFile();
		
	}
}
