package org.database.interf;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import org.database.actors.Animal;
import org.database.actors.Shelter;
import org.database.interf1.AdoptingAnimal;
import org.database.interf1.AdoptionDisqualifiers;
import org.database.interf1.FosterDisqualifiers;
import org.database.interf1.FosterProcess;


public class AnimalPreviewPanel extends JPanel{
	private JLabel name;
	private JLabel species;
	private JLabel breed;
	private JPanel info;
	private JPanel action;
	private JButton adopt;
	private JButton foster;
	private Animal animal;

	
	public AnimalPreviewPanel(Animal a) {
		animal = a;
		name = new JLabel(a.getName());
		
		
		// Panel for Animal description
		createDescriptionPanel();
		
		// Panel for adopt and foster buttons
		createActionPanel();
		
		setLayout(new BorderLayout());
		add(name, BorderLayout.NORTH);
		add(info);
		add(action, BorderLayout.SOUTH);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setPreferredSize(new Dimension(325,200));
	}
	
	public void createActionPanel() {
		action = new JPanel();
		action.setLayout(new FlowLayout());
		adopt = new JButton("Adopt");
		foster = new JButton("Foster");
		adopt.addActionListener(new AdoptButtonListener());
		
		foster.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Integer dNum = 0;
		    	  LocalDate today = LocalDate.now();
		    	  dNum += 1000000 * today.getMonthValue();
		    	  dNum += 10000 * today.getDayOfMonth();
		    	  dNum += today.getYear();
		    	  
		    	  Shelter compare = animal.getShelter();
		    	  
		    	  String personname = JOptionPane.showInputDialog("Enter your full name:");
		    	  
		    	  int detect = -1;
		    	  		    	  
		    	  for(int i = 0; i < compare.getVerifiedFosters().size(); ++i) {
		    		  String name = compare.getVerifiedFosters().get(i).getName();
		    		  if(name.equals(personname)) {
		    			  detect = i;
		    			  break;
		    		  }
		    	  }
		    	  
					if(personname != null && !(personname.equals("")) && detect != -1) {
						boolean nodog = false;
				    	  boolean nocat = false;
				    	  boolean nocritter = false;
				    	  
				    	  nodog = animal.getNoDog();
				    	  nocat = animal.getNoCat();
				    	  nocritter = animal.getNoCritter();
				    	  
				    	  if(nodog == true || nocat == true || nocritter == true) {
				    		  FosterDisqualifiers fd = new FosterDisqualifiers();
				    		  fd.setAnimal(animal);
				    		  fd.setcurrentPerson(personname);
				    		  fd.checkDisqualifiers();
				    	  }
				    	  else {
				    	  //move immediately to foster page
				    		 // String personname;
								
				    		 // personname = JOptionPane.showInputDialog("Enter your name:");
				    		  
				    		  //if(personname != null && !(personname.equals(""))) {
				    		  	FosterProcess fp = new FosterProcess();
								fp.setcurrentAnimal(animal);
								fp.setpersonName(personname);
								fp.displayFoster();

				    	  }
					
					}
					else if(detect == -1) {
						String error = "You aren't in this shelter's list of verified fosters, therefore you can't foster this animal.";
						JOptionPane.showMessageDialog(null, error, "Blank name", JOptionPane.ERROR_MESSAGE);
					}
					else {
						String error = "The name field is blank. Please enter a name to proceed.";
						JOptionPane.showMessageDialog(null, error, "Blank name", JOptionPane.ERROR_MESSAGE);
					}
			}
		    	  
		    	  
		});
		
		action.add(adopt);
		if(animal.getFoster() == true) {
		action.add(foster);
		}
	}
	
	public void createDescriptionPanel() {
		species = new JLabel("Species: " + animal.getSpecies());
		breed = new JLabel("Breed: " + animal.getBreed());
		info = new JPanel();
		JPanel c = new JPanel();
		JTextArea description = new JTextArea(animal.displayDescription());
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		//info.setSize(50, 50);
		info.setLayout(new GridLayout(1,2));
		c.add(species);
		c.add(breed);
		info.add(c);
		info.add(description, getRootPane());
	}
	
	public class AdoptButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {

	    	  Animal check = animal;
	    	  boolean nodog = false;
	    	  boolean nocat = false;
	    	  boolean nocritter = false;
	    	  
	    	  nodog = check.getNoDog();
	    	  nocat = check.getNoCat();
	    	  nocritter = check.getNoCritter();
	    	  
	    	  if(nodog == true || nocat == true || nocritter == true) {
	    		  AdoptionDisqualifiers ad = new AdoptionDisqualifiers();
	    		  ad.setAnimal(check);
	    		  ad.checkDisqualifiers();
	    	  }
	    	  else {
	    	  //move immediately to adoption page
	    		  
	    			  AdoptionDisqualifiers ad = new AdoptionDisqualifiers();
		    		  ad.setAnimal(check);
		    		  ad.checkDisqualifiers();
	    		  
	    	  }
	      }
	   }
}
