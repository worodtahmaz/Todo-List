package individualProjectApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import individualProject.Task;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectNameApp {

	private JFrame frmTodoListApplication;
	private Controller controller;//
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectNameApp window = new ProjectNameApp();
					window.frmTodoListApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProjectNameApp() {
	
		initialize();
	}
	/**
	 * Create the application.
	 */
	
	public ProjectNameApp(Controller controller) {//
		this.controller = controller;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTodoListApplication = new JFrame();
		frmTodoListApplication.setTitle("Todo List Application");
		frmTodoListApplication.setBounds(100, 100, 574, 300);
		frmTodoListApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTodoListApplication.getContentPane().setLayout(null);
		
		// project title
		int yPosition = 35;//
		// Task details position
		int title = 0;
		
		for(int i = 0 ; i < controller.getUser().getProjects().size();i++) {
			//create label project name
			JLabel tmp = new JLabel("Project Title: " + controller.getUser().getProjects().get(i).getTitle());	
			tmp.setBounds(24, yPosition, 250, 16);
			tmp.setVisible(true);
			frmTodoListApplication.getContentPane().add(tmp);
			title = yPosition + 30;
			
			//create label title name
			JLabel tmp1 = new JLabel("Title");
			tmp1.setBounds(24, title, 86, 16);
			tmp1.setVisible(true);
			frmTodoListApplication.getContentPane().add(tmp1);
			
			//create label Due Date name
			JLabel lblDueDate = new JLabel("Due Date");
			lblDueDate.setBounds(115, title, 61, 16);
			frmTodoListApplication.getContentPane().add(lblDueDate);
			
			
			//create label Status name
			JLabel lblStatus = new JLabel("Status");
			lblStatus.setBounds(233, title, 70, 16); //
			frmTodoListApplication.getContentPane().add(lblStatus); //
			
			//create label mark AS DONE name
			JLabel lblNewLabel = new JLabel("Mark as done");
			lblNewLabel.setBounds(319, title, 86, 16); //
			frmTodoListApplication.getContentPane().add(lblNewLabel); //
			
			
			for(int index = 0; index < controller.getUser().getProjects().get(i).getTasks().size(); index++) {
				title +=25;
				//create temp task object
				Task tmptask = controller.getUser().getProjects().get(i).getTasks().get(index);
				
				//create label task title
				JLabel tmpname = new JLabel(tmptask.getTitle());				 
				tmpname.setBounds(24, title, 86, 16);
				frmTodoListApplication.getContentPane().add(tmpname);
				
				//create label task due date
				JLabel tmpdate = new JLabel(tmptask.getDueDate());
				tmpdate.setBounds(115, title, 128, 16);
				frmTodoListApplication.getContentPane().add(tmpdate);
				
				//create label task status
				JLabel tmpstatus = new JLabel(tmptask.status());
				tmpstatus.setBounds(233, title, 70, 16);
				frmTodoListApplication.getContentPane().add(tmpstatus);
				
				 //create button task edit
			    int tskindex = index;
			    int projectindex = i;
			    JButton btnEditTask = new JButton("Edit Task");
				btnEditTask.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						EditTaskApp edit = new EditTaskApp(controller,tskindex,projectindex);
						edit.setVisible(true);
						setVisible(false);
					}
				});
				btnEditTask.setBounds(451, title, 117, 29);
				frmTodoListApplication.getContentPane().add(btnEditTask);
				
				//create check box  mark as done
				JCheckBox Markasdone = new JCheckBox("");
				Markasdone.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Markasdone.isSelected()) {
							tmptask.setMarkAsDone(true);
							tmpstatus.setText(tmptask.status());
							
							
						}else {
							tmptask.setMarkAsDone(false);
							tmpstatus.setText(tmptask.status());
						}
					}
				});
				Markasdone.setVisible(true);
				Markasdone.setSelected(tmptask.getMarkAsDone());
				Markasdone.setBounds(319, title, 128, 23);
				frmTodoListApplication.getContentPane().add(Markasdone);
				
			}		
			frmTodoListApplication.setBounds(100, 100, 574, title+100);
			yPosition = title + 30;
			//
		}
			
		btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//
			WelcomeTodoList welcome = new WelcomeTodoList(controller.getUserReg(), controller.getUserNames(), controller.getPasswords());
			welcome.setVisible(true);
			setVisible(false);
			}
		});
		btnNewButton.setBounds(427, 19, 117, 29);
		frmTodoListApplication.getContentPane().add(btnNewButton);		
	}
	
	public void setVisible (Boolean yes) {
		this.frmTodoListApplication.setVisible(yes);	
	}
}
