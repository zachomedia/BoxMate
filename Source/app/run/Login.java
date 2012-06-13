package app.run;

//Import the required packages
import app.boxmate.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Shows the Dashboard GUI to the user of the application.
 * This dashboard is that for a normal employee.
 *
 * @author Zachary Seguin
 * @version 1.0.0 (6/6/2012)
 * @since 1.0.0
 */
public class Login extends JFrame implements ActionListener
{
	//Declare GUI components
	private JLabel lblLogo;

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton cmdLogin;

	/**
	 * Constructs and shows the Dashboard GUI.
	 *
	 * @since 1.0.0
	 */
	public Login()
	{
		//Initialize the GUI
		this.initializeGUI();

		//Setup the JFrame
		this.setTitle(Application.NAME);
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}//End of constructor

	/**
	 * Initializes the GUI components and places them on the screen.
	 *
	 * @since 1.0.0
	 */
	private void initializeGUI()
	{
		//Setup the GUI layout manager for the content pane
		this.getContentPane().setLayout(new GridLayout(1, 2, 0, 0));

		//Initialize the left side
		ImageIcon imgLogo = new ImageIcon("P:/Final Project/Project/BoxMate/Build/app/images/logo.png");

		this.lblLogo = new JLabel(imgLogo);
		this.lblLogo.setHorizontalAlignment(JLabel.CENTER);

		this.add(lblLogo);

		//Initialize the right side
		SpringLayout rightSideLayout = new SpringLayout();
		JPanel rightSidePanel = new JPanel(rightSideLayout);
		rightSidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 20));

		JPanel loginPanel = new JPanel(new GridLayout(5, 1, 5, 5));

		this.txtUsername = new JTextField();
		this.txtPassword = new JPasswordField();
		this.cmdLogin = new JButton("Login");
		this.cmdLogin.addActionListener(this);

		loginPanel.add(new JLabel("Username"));
		loginPanel.add(this.txtUsername);
		loginPanel.add(new JLabel("Password"));
		loginPanel.add(this.txtPassword);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
		buttonPanel.add(new JLabel());
		buttonPanel.add(new JLabel());
		buttonPanel.add(this.cmdLogin);

		loginPanel.add(buttonPanel);

		//Position the elements
		rightSideLayout.putConstraint(SpringLayout.VERTICAL_CENTER, loginPanel, 0, SpringLayout.VERTICAL_CENTER, rightSidePanel);
		//rightSideLayout.putConstraint(SpringLayout.SOUTH, loginPanel, 0, SpringLayout.SOUTH, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.WEST, loginPanel, 0, SpringLayout.WEST, rightSidePanel);
		rightSideLayout.putConstraint(SpringLayout.EAST, loginPanel, 0, SpringLayout.EAST, rightSidePanel);


		rightSidePanel.add(loginPanel);

		this.add(rightSidePanel);
	}//End of initializeGUI method

	/**
	 * Handles user interactions with the GUI components on the screen. This is called automatically by the action listener.
	 *
	 * @param event The event that was generated.
	 *
	 * @since 1.0.0
	 */
	public void actionPerformed(ActionEvent event)
	{
		Object trigerObject = event.getSource();

		if (trigerObject == this.cmdLogin)
		{
			try
			{
				Database db = new Database();

				if (db.usernameExists(txtUsername.getText()))
				{
					Session.login(txtUsername.getText());

					new Dashboard();
					this.dispose();
				}
				else
					JOptionPane.showMessageDialog(this, "No account matched the provided username and/or password.", Application.NAME, JOptionPane.WARNING_MESSAGE);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, "An error occured querying the database.", Application.NAME, JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			JOptionPane.showMessageDialog(this, "This option is temporarily unavailable.", Application.NAME, JOptionPane.INFORMATION_MESSAGE);
	}//End of actionPerformed method
}//End of class