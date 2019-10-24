package individualProjectApp;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;

import individualProject.UserReg;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class WelcomeTodoList {

	private JFrame frmTodo;
	private Controller controller;//
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeTodoList window = new WelcomeTodoList();
					window.frmTodo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeTodoList() {
		initialize();
	}

	public WelcomeTodoList(UserReg userReg,String username,String password) {//
		this.controller = new Controller(userReg, username, password);//
		initialize();//
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTodo = new JFrame();
		frmTodo.setTitle("Todo List Application");
		frmTodo.setBounds(100, 100, 450, 332);
		frmTodo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTodo.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcom to Todo List");
		lblWelcome.setBounds(135, 26, 154, 16);
		frmTodo.getContentPane().add(lblWelcome);
		
		JLabel lblTasks = new JLabel(controller.todoTask());
		lblTasks.setBounds(79, 67, 318, 16);
		frmTodo.getContentPane().add(lblTasks);
		
		JButton btnShow = new JButton("Show Task List");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectNameApp projectname = new ProjectNameApp(controller);//
				projectname.setVisible(true);
				setVisible(false);
			}
		});
		btnShow.setBounds(135, 195, 137, 29);
		frmTodo.getContentPane().add(btnShow);
		
		JButton btnAdd = new JButton("Add New Task");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTaskApplication addTask = new AddTaskApplication(controller);//
				addTask.setVisible(true);
				setVisible(false);		
			}
		});
		btnAdd.setBounds(135, 146, 137, 29);
		frmTodo.getContentPane().add(btnAdd);
		
		JButton btnSave = new JButton("Save and Quit");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.getUserReg().writeToFile();
				System.exit(0); // stop program
				frmTodo.dispose(); // close window
				frmTodo.setVisible(false);
			}
		});
		btnSave.setBounds(135, 245, 137, 29);
		frmTodo.getContentPane().add(btnSave);
		
		JButton btnAddProject = new JButton("Add Project");
		btnAddProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProjectApp project = new ProjectApp(controller);//	
				project.setVisible(true);
				setVisible(false);
			}
		});
		btnAddProject.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAddProject.setBounds(142, 95, 117, 29);
		frmTodo.getContentPane().add(btnAddProject);
	}
	public void setVisible(Boolean yes) {//
		this.frmTodo.setVisible(yes);
	}
}
