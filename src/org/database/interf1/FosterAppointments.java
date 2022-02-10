package org.database.interf1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.database.actors.Animal;
import org.database.actors.Shelter;
import org.database.contact.Appointment;

public class FosterAppointments extends JFrame {
	
	private JPanel panel;             // A panel container
	private JLabel animalDescription;      // A message to display
	private JButton createButton;       // Move to adoption page
	private final int WINDOW_WIDTH = 300;  // Window width
	private final int WINDOW_HEIGHT = 200; // Window height
	private Animal currentanimal;
	private String personname;
	private JLabel typeofapp;
	private JTextField apptype;
	private JLabel dayofweek;
	private JTextField day;
	private JLabel appstarttime;
	private JTextField starttime;
	private JLabel appdate;
	private JTextField dateenter;
	private int numofappointments;
	
	FosterAppointments() {
		
		// Call the JFrame constructor.
	      super("Make appointments");

	      // Set the size of the window.
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	      // Specify what happens when the close
	      // button is clicked.
	      
	      setLocationRelativeTo(null);

	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setcurrentAnimal(Animal an) {
		currentanimal = an;
	}
	
	public void setpersonName(String name) {
		personname = name;
	}
	public void setnumAppointments(int na) {
		numofappointments = na;
	}

	public void makeAppointments() {
		
		// Build the panel and add it to the frame.
	      buildPanel();

	      // Add the panel to the frame's content pane.
	      add(panel);
	      
	      setVisible(true);
	      
	}
	
	private void buildPanel() {
		
		String animal = currentanimal.getName();
		String species = currentanimal.getSpecies();
		
		animalDescription = new JLabel(animal + ", the animal you are trying to foster is a " + species + ".\n" + "The format"
				+ " for appointment type is like dog to dog, cat to dog, child to dog, etc.");
		
		appdate = new JLabel("What day should the appointment be on?");
		dateenter = new JTextField(20);
		typeofapp = new JLabel("What is the appointment type?");
		apptype = new JTextField(20);
		dayofweek = new JLabel("What day of the week will the appointment be on?");
		day = new JTextField(20);
		appstarttime = new JLabel("What time should the appointment start?");
		starttime = new JTextField(20);
		createButton = new JButton("Create Appointment");
		
		createButton.addActionListener(new CreateButtonListener());

      // Add an action listener to the button.	      

      // Create a panel to hold the components.
      panel = new JPanel();
      
      // Add the label, text field, and button to the panel.
      panel.add(animalDescription);
      panel.add(appdate);
      panel.add(dateenter);
      panel.add(typeofapp);
      panel.add(apptype);
      panel.add(dayofweek);
      panel.add(day);
      panel.add(appstarttime);
      panel.add(starttime);
      panel.add(createButton);
	
	}
	
	public class CreateButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  
	    	String date;
	    	String type;
	    	String time;
	    	String dayy;
	    	
	    	date = dateenter.getText();
	    	type = apptype.getText();
	    	time = starttime.getText(); 
	    	dayy = day.getText();
	    	
	    	if(date != null && type != null && time != null && dayy != null && !(date.equals("")) &&
	    			!(type.equals("")) && !(time.equals("")) && !(dayy.equals(""))) {
	    		
	    		type = type.toLowerCase();
	    		
	    		int checkdate;
	    		int checktime;
	    		int duration = 0;
	    		int daw = 0;
	    		
	    		if(dayy.equals("Monday")) {
	    			daw = 1;
	    		}
	    		else if(dayy.equals("Tuesday")) {
	    			daw = 2;
	    		}
	    		else if(dayy.equals("Wednesday")) {
	    			daw = 3;
	    		}
	    		else if(dayy.equals("Thursday")) {
	    			daw = 4;
	    		}
	    		else if(dayy.equals("Friday")) {
	    			daw = 5;
	    		}
	    		else if(dayy.equals("Saturday")) {
	    			daw = 6;
	    		}
	    		else if(dayy.equals("Sunday")) {
	    			daw = 7;
	    		}
	    		else {
	    			String errory = "The day of the week you entered is invalid. Please enter a valid day of the week.";
	    			JOptionPane.showMessageDialog(null, errory, "Invalid day of the week", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		
	    		
	    		checkdate = Integer.parseInt(date);
	    		checktime = Integer.parseInt(time);
	    		
	    		if(type.equals("dog to dog")) {
	    			duration = 40; //measured in minutes
	    		}
	    		else if(type.equals("dog to cat") || type.equals("cat to dog")) {
	    			duration = 30; //measured in minutes
	    		}
	    		else if(type.equals("cat to cat")) {
	    			duration = 20; //measured in minutes
	    		}
	    		else if(type.equals("dog to critter") || type.equals("critter to dog")) {
	    			duration = 50; //measured in minutes
	    		}
	    		else if(type.equals("cat to critter") || type.equals("cat to critter")) {
	    			duration = 40; //measured in minutes
	    		}
	    		else if(type.equals("critter to critter")) {
	    			duration = 30; //measured in minutes
	    		}
	    		else if(type.equals("dog to child") || type.equals("child to dog")) {
	    			duration = 40; //measured in minutes
	    		}
	    		else if(type.equals("child to cat") || type.equals("cat to child")) {
	    			duration = 30; //measured in minutes
	    		}
	    		else if(type.equals("child to critter") || type.equals("critter to child")) {
	    			duration = 30; //measured in minutes
	    		}
	    		else {
	    			String error = "The appointment type you put is invalid. The possible types either based on dog, cat, child, or critter.";
	    			JOptionPane.showMessageDialog(null, error, "Invalid appointment type", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		
	    		Shelter s = currentanimal.getShelter();
	    		boolean check = false;
	    		
	    		for(int i = 0; i < s.getAppointments().size(); ++i) {
	    			int compareday = s.getAppointments().get(i).getdayofWeek();
	    			int compare = s.getAppointments().get(i).getStartTime();
	    			int comparedate = s.getAppointments().get(i).getDate();
	    			if(compare == checktime && compareday == daw && comparedate == checkdate) {
	    				check = true;
	    				break;
	    			}
	    		}
	    		
	    		if(check == true) {
	    			String error = "There is already an appointment at the specified time. Please pick a different time.";
	    			JOptionPane.showMessageDialog(null, error, "Invalid appointment type", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		else {
	    			//boolean check2 = false;
	    			
	    			//for(int i = 0; i < s.getAppointments().size(); ++i) {
		    			//int compare = s.getAppointments().get(i).getStartTime();
		    			//int ch = compare % 100;
		    			//int ct = checktime % 100;
		    			
		    			//if((ch - ct) == 1) {
		    				//check = true;
		    			//	break;
		    			//}
	    			String error = null;
	    			boolean check2 = false;
	    			int dday = 0;
	    	  		int dmonth = 0;

	    	  		dmonth = checkdate / 1000000;
	    	  		dday = checkdate / 10000;
	    	  		dday = dday % 100;
	    	  		
	    	  		if(checkdate <= 0) {
	    	  			error = "The date you entered is invalid. The date can't be negative or 0.";
	    	  			JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
	    	  		}
	    	  		else if(checkdate <= 1000000) {
	    	  			error = "The date can't be less than 7 digits.";
	    	  		}
	    			else if(dmonth > 12 && dday > 31) {
	    				error = "The month and day you entered is invalid. The month can't be greater than 12, and the day can't be greater than 31."; 
	    				JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else if(dmonth > 12 || dmonth == 0) {
	    	  			error = "The month you entered is invalid. The month ranges from 1 to 12.";
	    	  			JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
	    			}
	    	  		else if(dday > 31 || dday == 0) {
	    	  			error = "The day you entered is invalid. The month ranges from 1 to 31 depending upon the month.";
	    	  			JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
	    	  		}
	    	  		else if((dmonth == 4 || dmonth == 6 || dmonth == 9 || dmonth == 11) && (dday > 30)) {
	    	  			error = "The day you entered is invalid. The month ranges from 1 to 30 for the inputted month.";
	    	  			JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
	    	  		}
	    	  		else if(dmonth == 2 && (dday > 28)) {
	    	  			error = "The day you entered is invalid. The month ranges from 1 to 28 for the inputted month. "
	    	  					+ "This system ignores leap years.";
	    	  			JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
	    	  		}
	    	  		else {
	    	  			int checkhour = checktime / 100;
	    	  			int checkmin = checktime % 100;
	    	  			
	    	  			if(checktime <= 0) {
	    	  				String errors = "The time you put is invalid. The time can't be zero or negative.";
	    	  				JOptionPane.showMessageDialog(null, errors, "Incorrect time", JOptionPane.INFORMATION_MESSAGE);
	    	  			}
	    	  			else if(checkhour > 24) {
	    	  				String errors = "The hour ranges from 1 to 24. Please enter a valid hour.";
	    	  				JOptionPane.showMessageDialog(null, errors, "Invalid hour", JOptionPane.INFORMATION_MESSAGE);
	    	  			}
	    	  			else if(checkmin >= 60) {
	    	  				String errors = "The minutes you put in are invalid. Minutes range from 0 to 59.";
	    	  				JOptionPane.showMessageDialog(null, errors, "Incorrect time", JOptionPane.INFORMATION_MESSAGE);
	    	  			}
	    	  			else {
	    	  				int detectt = -1;
	    	  				for(int j = 0; j < s.getOpenHour().size(); ++j) {
	    	  					int compareday = s.getOpenHour().get(j) / 10000;
	    	  					if(compareday == daw) {
	    	  						detectt = 1;
	    	  						break;
	    	  					}
	    	  				}
	    	  				if(detectt == 1) {
	    	  				int detectc = 1;
	    	  				for(int i = 0; i < s.getOpenHour().size(); ++i) {
	    	  					int compareday = s.getOpenHour().get(i) / 10000;
	    	  					if(compareday == daw) {
	    	  						int lookatopen = s.getOpenHour().get(i) % 10000;
	    	  						int lookatclose = s.getCloseHour().get(i) % 10000;
	    	  						if(checktime < lookatopen || checktime > lookatclose) {
	    	  							detectc = -1;
	    	  							break;
	    	  						}
	    	  					}
	    	  				}
	    	  				if(detectc == 1) {
	    	  				check2 = true;
	    	  				}
	    	  				else {
	    	  					String o = "The time you inputted was outsie the operation hours of the shelter."
	    	  							+ " Please make an appointment within the open and closing hours of the shelter.";
	    	  					JOptionPane.showMessageDialog(null, o, "Outside hours of operation", JOptionPane.INFORMATION_MESSAGE);
	    	  				}
	    	  				}
	    	  				else {
	    	  					String p = "The shelter doesn't operate on the day you specified. Please make an appointment on "
	    	  							+ "a day that the shelter operates.";
	    	  					JOptionPane.showMessageDialog(null, p, "Outside hours of operation", JOptionPane.INFORMATION_MESSAGE);
	    	  				}
	    	  			}
	    	  		}
	    	  		
	    	  		if(check2 == true) {
	    	  			--numofappointments;
	    	  			Appointment a = new Appointment();
	    	  			a.setPersonName(personname);
	    	  			a.setAppointmentType(type);
	    	  			a.setStartTime(checktime);
	    	  			a.setDate(checkdate);
	    	  			a.setDuration(duration);
	    	  			a.setDayofWeek(daw);
	    	  			currentanimal.addAppointment(a);
	    	  			
	    	  			int checkhour = checktime / 100;
	    	  			int checkmin = checktime % 100;
	    	  			String tag = null;
	    	  			
	    	  			if(checkhour > 12) {
	    	  				checkhour = checkhour - 12;
	    	  				tag = "P.M.";
	    	  			}
	    	  			else {
	    	  				tag = "A.M.";
	    	  			}
	    	  			
	    	  			String min = null;
	    	  			
	    	  			if(checkmin < 10) {
	    	  				min = "0" + checkmin;
	    	  			}
	    	  			else {
	    	  				min = "" + checkmin;
	    	  			}
	    	  			
	    	  			
	    	  			String info = "Your appointment is on " + dayy + " " + checkdate + " at " + checkhour + ":" + min + " " + tag 
	    	  					+ "\n The appointment type is " + type + " and lasts for " + duration + " minutes.";
	    	  			JOptionPane.showMessageDialog(null, info, "Appointment created", JOptionPane.INFORMATION_MESSAGE);
	    	  			
	    	  		}
	    		}
	    		
	    	}
	    	else {
	    		String error = "Either one, two, three, or all of the fields are blank, so the appointment can't be created.";
	    		JOptionPane.showMessageDialog(null, error, "Empty fields", JOptionPane.INFORMATION_MESSAGE);
	    	}
	      if(numofappointments == 0) {
	    	  Shelter s = currentanimal.getShelter();
	    	  s.animalAwaitingFoster(currentanimal);
	    	  String complete = "You have created your neccessary number of appointments.\n" + 
	      "The animal has been put on the waiting list and if your appoinments are succesful, you can foster " + currentanimal.getName() + ".";
	    	  JOptionPane.showMessageDialog(null, complete, "Appointments made", JOptionPane.INFORMATION_MESSAGE);
	    	   
	      }
	    	
	      }
	   }
}
