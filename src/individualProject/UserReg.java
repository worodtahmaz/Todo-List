package individualProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserReg {
	
	private ArrayList<User> users = new ArrayList<>();
	
	public UserReg () {
		this.setUsers(new ArrayList<User>());
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	// add User in to the UserReg
	public void addUser (User user) {
		this.getUsers().add(user);
	}
	// signIn User
	public User signIn (String name, String password) {
			User tempUser;
			int i = 0;
			boolean find = false;
			int index = -1;
			
			while (i < this.getUsers().size() && find == false) {
				tempUser = this.getUsers().get(i);
				if (tempUser.getName().equals(name) && tempUser.getPassword().equals(password) ) {
					index = i;
					find = true;
				}
				i++;
			}
			if (index != -1) {
				tempUser = this.getUsers().get(index);
			}
			else {
				tempUser = null;
			}
			return tempUser;
		}
	// write to file	
	public void writeToFile(){
		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			// Write objects to file
			for (User aUser : this.getUsers()){
				o.writeObject(aUser);
			}
			o.close();
			f.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} 		
	}
	
	// read from file
	public void readFromFile(){
		try {
			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			User p = (User) oi.readObject();
			
			while(p != null){
			 this.addUser(p);	
			 p = (User) oi.readObject();	
			}
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	}
	