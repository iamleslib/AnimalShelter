package org.database.interf1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import org.database.actors.Animal;
//import org.database.interf1.PickOneShelter.AdoptButtonListener;

public class AdoptionDisqualifiers extends JFrame {
	
	private JPanel panel;             // A panel container
	private JLabel wanringMessage;      // A message to display
	private JButton continueButton;       // Move to adoption page
	private final int WINDOW_WIDTH = 300;  // Window width
	private final int WINDOW_HEIGHT = 200; // Window height
	private Animal currentanimal;
	private JLabel nodog;
	private JTextField nodogresponse;
	private JLabel nocat;
	private JTextField nocatresponse; 
	private JLabel nocritter;
	private JTextField nocritterresponse; 
 
	
	public AdoptionDisqualifiers() {
		
		// Call the JFrame constructor.
	    super("Adoption Disqualifiers");

	    // Set the size of the window.
	    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	    // Specify what happens when the close
	    // button is clicked.

		setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
}
	
	public void setAnimal(Animal an) {
		currentanimal = an;
	}
	
	public void checkDisqualifiers() {
		// Build the panel and add it to the frame.
	    buildPanel();

	    // Add the panel to the frame's content pane.
	    add(panel);
	    
	    setVisible(true);
	}
	
	private void buildPanel() {
		
		boolean nodog1;
		boolean nocat1;
		boolean nocritter1;
		
		panel = new JPanel();

		nodog1 = currentanimal.getNoDog();
		if(nodog1 == true) {
			nodog = new JLabel("Do you have any dogs?");
			nodogresponse = new JTextField(5);
			panel.add(nodog);
			panel.add(nodogresponse);
		}

		nocat1 = currentanimal.getNoCat();
		if(nocat1 == true) {
			nocat = new JLabel("Do you have any cats?");
			nocatresponse = new JTextField(5);
			panel.add(nocat);
			panel.add(nocatresponse);
		}

		nocritter1 = currentanimal.getNoCritter();
		if(nocritter1 == true) {
			nocritter = new JLabel("Do you have any critters?");
			nocritterresponse = new JTextField(5); 
			panel.add(nocritter);
			panel.add(nocritterresponse);
		}
		
		continueButton = new JButton("Continue to adoption");
		continueButton.addActionListener(new ContinueButtonListener());
		panel.add(continueButton);
		
	}
	
	public class ContinueButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
			String nodog2 = null;
			String nocat2 = null;
	    	String nocritter2 = null;
			String wrongresponse = null;
			String conflicts = null;
			
			boolean nodog1;
			boolean nocat1;
			boolean nocritter1;
			
			nodog1 = currentanimal.getNoDog();
			if(nodog1 == true) {
				nodog2 = nodogresponse.getText().toLowerCase();
				wrongresponse = null;
				conflicts = null;
			}
			
			nocat1 = currentanimal.getNoCat();
			if(nocat1 == true) {
				nocat2 = nocatresponse.getText().toLowerCase();
				wrongresponse = null;
				conflicts = null;
			}
			
			nocritter1 = currentanimal.getNoCritter();
			if(nocritter1 == true) {
				nocritter2 = nocritterresponse.getText().toLowerCase();
				wrongresponse = null;
				conflicts = null;
			}

			if(nodog2 != null) {
			if(nodog2.equals("yes") || nodog2.equals("no")) {
				wrongresponse = null;
			}
			else {
				wrongresponse = "Your input for the dog response field is invalid. Appropriate reponses are either yes or no.";
			}
			}
			
			if(nocat2 != null) {
			if(nocat2.equals("yes") || nocat2.equals("no")) {
				if(wrongresponse == null) {
				wrongresponse = null;
				}
			}
			else {
				if(wrongresponse != null) {
					wrongresponse = wrongresponse + "\nYour input for the cat response field is invalid. Appropriate reponses are either yes or no.";
				}
				else {
					wrongresponse = "Your input for the cat response field is invalid. Appropriate reponses are either yes or no.";
				}
			}
			}
			
			if(nocritter2 != null) {
			if(nocritter2.equals("yes") || nocritter2.equals("no")) {
				if(wrongresponse == null) {
				wrongresponse = null;
				}
			}
			else {
				if(wrongresponse != null) {
					wrongresponse = wrongresponse + "\nYour input for the critter response field is invalid. Appropriate reponses are either yes or no.";
				}
				else {
					wrongresponse = "Your input for the cat response field is invalid. Appropriate reponses are either yes or no.";
				}
			}
			}
			
			if(wrongresponse != null) {
				JOptionPane.showMessageDialog(null, wrongresponse, "Incorrect response", JOptionPane.WARNING_MESSAGE);
			}
			
			if(nodog2 != null) {
			if(nodog2.equals("yes")) {
				conflicts = "This animal can't live with dogs and since you own dogs, you can't adopt this animal.";
			}
			}
			
			if(nocat2 != null) {
			if(nocat2.equals("yes")) {
				if(conflicts != null) {
				conflicts = conflicts + "\nThis animal can't live with cats and since you own cats, you can't adopt this animal.";
				}
				else {
				conflicts = "This animal can't live with cats and since you own cats, you can't adopt this animal.";	
				}
			}
			}
			
			if(nocritter2 != null) {
			if(nocritter2.equals("yes")) {
				if(conflicts != null) {
				conflicts = conflicts + "\nThis animal can't live with critters and since you own critters, you can't adopt this animal.";
			}
				else {
				conflicts = "This animal can't live with critters and since you own critters, you can't adopt this animal.";	
				}
			}
			}
			
			if(conflicts != null) {
				JOptionPane.showMessageDialog(null, conflicts, "Adoption not possible", JOptionPane.WARNING_MESSAGE);
			}

			if(conflicts == null && wrongresponse == null) {
			//proceed to adoption page
				String personname;
				
				personname = JOptionPane.showInputDialog("Enter your name:");
				if(personname != null && !(personname.equals(""))) {
				AdoptingAnimal aa = new AdoptingAnimal();
				aa.setcurrentAnimal(currentanimal);
				aa.setpersonName(personname);
				disposeFrame();
				aa.displayAdoption();
				
				}
				else {
					String error = "The name field is blank. Please enter a name to proceed.";
					JOptionPane.showMessageDialog(null, error, "Blank name", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			}
		}
	
	public void disposeFrame() {
		this.dispose();
	}
	  }


