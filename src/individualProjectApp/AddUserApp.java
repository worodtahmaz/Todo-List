package individualProjectApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import individualProject.User;
import individualProject.UserReg;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AddUserApp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private UserReg userReg;//
	private User user;//
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserApp window = new AddUserApp();
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
	public AddUserApp() {
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
		userReg = new UserReg();//
		userReg.readFromFile();//
		textField = new JTextField();
		textField.setBounds(240, 24, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 76, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();//
				String password = textField_1.getText();
				user = new User(username,password);
				userReg.addUser(user);//
			}
		});
		btnNewButton.setBounds(161, 153, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Log in");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserApplication login = new UserApplication();//
				login.setuserReg(userReg);
				login.setVisible(true);//
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(161, 194, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(137, 29, 67, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(137, 81, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
