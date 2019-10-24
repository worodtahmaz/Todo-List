package individualProjectApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import individualProject.Task;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTaskApplication {

	private JFrame frmTodoListApplication;
	private JTextField textField_Title;
	private JTextField textField_DueDate;
	private JTextField textField_project;
	private Controller controller; //
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTaskApplication window = new AddTaskApplication();
					window.frmTodoListApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddTaskApplication() {
		
		initialize();
	}
	public AddTaskApplication(Controller controller) { //
		this.controller= controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTodoListApplication = new JFrame();
		frmTodoListApplication.setTitle("Todo List Application");
		frmTodoListApplication.setBounds(100, 100, 450, 300);
		frmTodoListApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTodoListApplication.getContentPane().setLayout(null);
		
		JLabel lblAddTask = new JLabel("Add New Task");
		lblAddTask.setBounds(81, 26, 90, 16);
		frmTodoListApplication.getContentPane().add(lblAddTask);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(81, 99, 61, 16);
		frmTodoListApplication.getContentPane().add(lblTitle);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(81, 137, 61, 16);
		frmTodoListApplication.getContentPane().add(lblDueDate);
		
		textField_Title = new JTextField();
		textField_Title.setBounds(177, 94, 130, 26);
		frmTodoListApplication.getContentPane().add(textField_Title);
		textField_Title.setColumns(10);
		
		textField_DueDate = new JTextField();
		textField_DueDate.setBounds(177, 132, 130, 26);
		frmTodoListApplication.getContentPane().add(textField_DueDate);
		textField_DueDate.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String porjecttitle = textField_project.getText(); //
				String tasktitle= textField_Title.getText();	
				String duedate = textField_DueDate.getText();
				Task tmp = new Task(tasktitle, duedate, false);
				controller.searchProject(porjecttitle).addTask(tmp);
			}
			
		});
		btnAdd.setBounds(81, 185, 117, 29);
		frmTodoListApplication.getContentPane().add(btnAdd);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //
			WelcomeTodoList welcome = new WelcomeTodoList(controller.getUserReg(),controller.getUserNames(),controller.getPasswords());
			welcome.setVisible(true);
			frmTodoListApplication.setVisible(false);
				
			}
		});
		btnMainMenu.setBounds(281, 185, 117, 29);
		frmTodoListApplication.getContentPane().add(btnMainMenu);
		
		JLabel lblProjectname = new JLabel("Projectname");
		lblProjectname.setBounds(81, 61, 77, 16);
		frmTodoListApplication.getContentPane().add(lblProjectname);
		
		textField_project = new JTextField();
		textField_project.setBounds(177, 56, 130, 26);
		frmTodoListApplication.getContentPane().add(textField_project);
		textField_project.setColumns(10);
	}
	public void setVisible(Boolean yes) { //
		this.frmTodoListApplication.setVisible(yes);
	}
}
