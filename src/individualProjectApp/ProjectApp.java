package individualProjectApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import individualProject.Project;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectApp   {

	private JFrame frame;
	private JTextField textField;
	private Project project;//
	private Controller controller;//
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectApp window = new ProjectApp();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public ProjectApp() {
	
		initialize();
	
	}
	public ProjectApp(Controller Cont) {//
		this.controller = Cont;		
	
		initialize();
	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JLabel lblNewLabel = new JLabel("Project Name");
		lblNewLabel.setBounds(49, 52, 93, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd2 = new JButton("Add Project");
		btnAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addproject = textField.getText();//
				JOptionPane.showMessageDialog(null, "Project added ");
				project = new Project (addproject);
				controller.getUser().addProject(project);//
				
			}
		});
		btnAdd2.setBounds(43, 115, 117, 29);
		frame.getContentPane().add(btnAdd2);
		
		textField = new JTextField();
		textField.setBounds(232, 47, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Main Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
	WelcomeTodoList welcome = new WelcomeTodoList(controller.getUserReg(),controller.getUserNames(),controller.getPasswords());//
		welcome.setVisible(true);
		setVisible(false);
			}
		});
		btnNewButton_1.setBounds(245, 115, 117, 29);
		frame.getContentPane().add(btnNewButton_1);	
	}
	public void setVisible (Boolean yes) {//
		this.frame.setVisible(yes);		
	}
}
