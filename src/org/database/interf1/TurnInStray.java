package org.database.interf1;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.transactions.Stray;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class TurnInStray extends JFrame {
	
	private JPanel panel;             // A panel container
	private JLabel shelterList;      // A message to display
	private JButton chooseShelter;
	private final int WINDOW_WIDTH = 300;  // Window width
	private final int WINDOW_HEIGHT = 200; // Window height
	private ArrayList<Shelter> currentShelters; //set of shelters you're currently working with
	private int currentDate;

	public TurnInStray() {
		// Call the JFrame constructor.
	    super("List of shelters");

	    // Set the size of the window.
	    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	    // Specify what happens when the close
	    // button is clicked.
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
		}
	
	public void setShelterList(ArrayList<Shelter> sh) {
		currentShelters = sh;
	}
	
	public void setCurrentDate(int cd) {
		currentDate = cd;
	}
	
	public void displayShelters() {
		// Build the panel and add it to the frame.
	    buildPanel();

	    // Add the panel to the frame's content pane.
	    add(panel);
	    
	    setVisible(true);
	}
	
	private void buildPanel() {
		
		// Create the label, text field, and button components.
			String state = currentShelters.get(0).getState();
	
	      shelterList = new JLabel("List of shelters in " + state);
	      
	      DefaultListModel<String> shelterNames = new DefaultListModel<>();
	      
	      for(int i = 0; i < currentShelters.size(); ++i) {
	    	  String s;
	    	  s = currentShelters.get(i).getName();
	    	  shelterNames.addElement(s);
	      }
	      
	      JList<String> list = new JList<>(shelterNames);
	      
	      list.addMouseListener(new MouseAdapter() {
	    	    public void mouseClicked(MouseEvent evt) {
	    	        JList list = (JList)evt.getSource();
	    	        if (evt.getClickCount() == 2) {

	    	            // Double-click detected
	    	            int index = list.locationToIndex(evt.getPoint());
	    	            Shelter s;
	    	            String result;
	    	            s = currentShelters.get(index);
	    	            result = s.printShelterInfo();
	    	            
	    	            JOptionPane.showMessageDialog(null, result, "Shelter information", JOptionPane.INFORMATION_MESSAGE);
	    	        } 
	    	    }
	    	});
	      
	      chooseShelter = new JButton("Pick one shelter");
	      
	   // Add an action listener to the buttons.
	      chooseShelter.addActionListener(new ShelterButtonListener());
	      //fosterButton.addActionListener(new FosterButtonListener());
	      //surrenderButton.addActionListener(new SurrenderButtonListener());

	      // Create a panel to hold the components.
	      panel = new JPanel();
	      
	      // Add the label, text field, and button to the panel.
	      panel.add(shelterList);
	      panel.add(chooseShelter);
	      panel.add(list);
	      
	}


	public class ShelterButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
			
				String sheltername;
				int detect = -1;
	    	  
	    	  //while(detect == -1) {
	    	  sheltername = JOptionPane.showInputDialog("Enter shelter name:");
	    	  
	    	  if(sheltername != null) {
	    	  String sn = sheltername.toLowerCase();
	    	  
	    	  for(int i = 0; i < currentShelters.size(); ++i) {
	    		  String s = currentShelters.get(i).getName().toLowerCase();
	    		  if(s.equals(sn)) {
	    			  detect = i;
	    			  break;
	    		  }
	    	  }
	    	  //}
	    	  
	    	  if(detect != -1) {
	    		String species;
	    		
	    		species = JOptionPane.showInputDialog("Enter stray's species:");
	    		
	    		if(species != null && !(species.equals(""))) {
	    			Animal a = new Animal();
	    			a.setSpecies(species);
	    			a.setStray(true);
	    			a.setArrival(currentDate);
	    			currentShelters.get(detect).addtoWaitingList(a);
	    			a.setTransaction(new Stray(a, null, a.getShelter()));
	    			String info = "The stray has been successfully added into the shelter's system. Please"
	    					+ " drop the animal off at the shelter. Its address is:\n"
	    					+ currentShelters.get(detect).getAddress();
	    			JOptionPane.showMessageDialog(null, info, "Stray registered", JOptionPane.INFORMATION_MESSAGE);
	    			
	    		}
	    		else {
	    			String error = "The input is blank. Please enter a species.";
		    		  JOptionPane.showMessageDialog(null, error, "Blank species", JOptionPane.ERROR_MESSAGE);
	    		}
	    		
	    	  }
	    	  else {
	    		  String response = sheltername + " was not found in the list of shelters in " + currentShelters.get(0).getState() + ".";
	    		  JOptionPane.showMessageDialog(null, response, "Shelter not found", JOptionPane.INFORMATION_MESSAGE);
	    	  }
	    	  }
	    	  else {
	    		  String error = "The input is blank. Please enter a valid shelter name.";
	    		  JOptionPane.showMessageDialog(null, error, "Blank name", JOptionPane.ERROR_MESSAGE);
	    	  }
			
			}
	}
}
	

