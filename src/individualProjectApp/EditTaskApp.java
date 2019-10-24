package individualProjectApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import individualProject.Task;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditTaskApp {

	private JFrame frmTodoListApplication;
	private JTextField textField_Title;
	private JTextField textField_DueDate;
	private int indextesk;
	private int projectindex;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTaskApp window = new EditTaskApp();
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
	public EditTaskApp() {
	
		
		initialize();
	}

	public EditTaskApp(Controller cont, int taskindex,int project) {
		controller= cont;
		indextesk=taskindex;
		
		projectindex = project;
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
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String title = textField_Title.getText();//
			String duedate = textField_DueDate.getText();
			Task tmptask = controller.getUser().getProjects().get(projectindex).getTasks().get(indextesk);
			controller.getUser().getProjects().get(projectindex).updateTask(tmptask.getTitle(), title, tmptask.getDueDate(), duedate);
				
			}
		});
		btnUpdate.setBounds(59, 186, 117, 29);
		frmTodoListApplication.getContentPane().add(btnUpdate);
		
		JLabel lblEdit = new JLabel("Edit Task");
		lblEdit.setBounds(155, 39, 61, 16);
		frmTodoListApplication.getContentPane().add(lblEdit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectNameApp welcome = new ProjectNameApp(controller);//
				welcome.setVisible(true);
				frmTodoListApplication.setVisible(false);
			}
		});
		btnMainMenu.setBounds(137, 243, 117, 29);
		frmTodoListApplication.getContentPane().add(btnMainMenu);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(90, 88, 61, 16);
		frmTodoListApplication.getContentPane().add(lblTitle);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(90, 139, 61, 16);
		frmTodoListApplication.getContentPane().add(lblDueDate);
		
		textField_Title = new JTextField(controller.getUser().getProjects().get(projectindex).getTasks().get(indextesk).getTitle());
		textField_Title.setBounds(230, 83, 130, 26);
		
		frmTodoListApplication.getContentPane().add(textField_Title);
		textField_Title.setColumns(10);
		
		textField_DueDate = new JTextField(controller.getUser().getProjects().get(projectindex).getTasks().get(indextesk).getDueDate());
		textField_DueDate.setBounds(230, 134, 130, 26);
		frmTodoListApplication.getContentPane().add(textField_DueDate);
		textField_DueDate.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //
				controller.getUser().getProjects().get(projectindex).getTasks().remove(indextesk);
				JOptionPane.showMessageDialog(null, "Task is removed");
			}
		});
		btnRemove.setBounds(227, 186, 117, 29);
		frmTodoListApplication.getContentPane().add(btnRemove);
	}
	public void setVisible (Boolean yes) { //
		this.frmTodoListApplication.setVisible(yes);
	}
}
