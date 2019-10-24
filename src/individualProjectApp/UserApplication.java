package individualProjectApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import individualProject.User;
import individualProject.UserReg;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserApplication  {

	private JFrame frmShawqi;
	private JTextField textField_Name;
	private JTextField textField_Password;
	private User user;//
	private UserReg userReg;//
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserApplication window = new UserApplication();
					window.frmShawqi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setuserReg(UserReg userReg) { //
		this.userReg = userReg;
	}
	public UserReg getuserReg() { //
		return userReg;
	}
	

	/**
	 * Create the application.
	 */
	public UserApplication() {
		userReg= new UserReg();//
		userReg.readFromFile();//
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShawqi = new JFrame();
		frmShawqi.setTitle("Todo List Application");
		frmShawqi.setBounds(100, 100, 450, 300);
		frmShawqi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShawqi.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Username");
		lblName.setBounds(82, 99, 74, 16);
		frmShawqi.getContentPane().add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(168, 94, 130, 26);
		frmShawqi.getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_Name.getText();//
				String password = textField_Password.getText();
				user = getuserReg().signIn(name, password);
				if ( user == null) {
					JOptionPane.showMessageDialog(null, "user not found");
				}
				else {
					WelcomeTodoList welcome = new WelcomeTodoList(userReg,name,password);
				
					welcome.setVisible(true);
					frmShawqi.setVisible(false);//
				}
			}
		});
		btnSignIn.setBounds(168, 171, 130, 29);
		frmShawqi.getContentPane().add(btnSignIn);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(82, 127, 61, 16);
		frmShawqi.getContentPane().add(lblPassword);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(168, 122, 130, 26);
		frmShawqi.getContentPane().add(textField_Password);
		textField_Password.setColumns(10);
	}
	
	public void setVisible (Boolean yes) {//
		this.frmShawqi.setVisible(yes);
	}
}