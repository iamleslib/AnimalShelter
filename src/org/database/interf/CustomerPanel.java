package org.database.interf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.*;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.interf1.CustomerEmail;
import org.database.interf1.SurrenderAnimal;
import org.database.interf1.TurnInStray;

public class CustomerPanel extends JPanel{
	public Database d;
	private JPanel panelCont;
	private JPanel welcome;
	private JPanel options;
	private JPanel adopt;
	private JPanel shelters;
	private JPanel surrender;
	private JButton buttonAdopt;
	private JButton buttonFoster;
	private JButton buttonSurrender;
	private JButton buttonStray;
	private JButton buttonEmail;
	private JButton returnFoster;
	private DisplayAnimalsPanel p;
	private DisplaySheltersPanel s;
	private CardLayout c1;

	public CustomerPanel(Database db) {
		d = db;
		panelCont = new JPanel();
		options = new JPanel();
		adopt = new JPanel();
		surrender = new JPanel();
		shelters = new JPanel();
		welcome = new JPanel();
		
		buttonAdopt = new JButton("View All Animals");
		buttonFoster = new JButton("View Shelters");
		buttonSurrender = new JButton("Surrender");
		buttonStray = new JButton("Stray");
		buttonEmail = new JButton("Email");
		returnFoster = new JButton("Return Foster");
		c1 = new CardLayout();
		
		welcome.setBackground(Color.darkGray);
		//adopt.setBackground(Color.blue);
		surrender.setBackground(Color.darkGray);
		
		panelCont.setLayout(c1);
		
		options.setLayout(new FlowLayout());
		options.setBorder(BorderFactory.createTitledBorder("Select Action"));
		options.add(buttonAdopt);
		options.add(buttonFoster);
		options.add(buttonStray);
		options.add(buttonSurrender);
		options.add(buttonEmail);
		options.add(returnFoster);
		
		panelCont.add(adopt, "Adopt");
		panelCont.add(surrender, "Surrender");
		panelCont.add(shelters, "Shelters");
		panelCont.add(welcome, "Welcome");
		adopt.setLayout(new BorderLayout());

		
		buttonAdopt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = new DisplayAnimalsPanel(d.getAllAnimals());
				adopt.add(p);
				c1.show(panelCont, "Adopt");
				for(Shelter s : d.getstateShelters()) {
					System.out.println(s.getName());
					for(Animal a : s.getCurrentAnimals()) {
						System.out.println(a.getName());
					}
				}
			}
		});
		
		shelters.setLayout(new BorderLayout());
		buttonFoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = new DisplaySheltersPanel(d);
				shelters.add(s);
				c1.show(panelCont, "Shelters");
			}
		});
		buttonSurrender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer dNum = 0;
		    	  LocalDate today = LocalDate.now();
		    	  dNum += 1000000 * today.getMonthValue();
		    	  dNum += 10000 * today.getDayOfMonth();
		    	  dNum += today.getYear(); 
				SurrenderAnimal sa = new SurrenderAnimal();
		    	sa.setShelterList(d.getstateShelters());
		    	sa.setCurrentDate(dNum);
		    	sa.displayShelters();
				c1.show(panelCont, "Surrender");
			}
		});
		
		buttonStray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	  TurnInStray ts = new TurnInStray();
		    	  Integer dNum = 0;
		    	  LocalDate today = LocalDate.now();
		    	  dNum += 1000000 * today.getMonthValue();
		    	  dNum += 10000 * today.getDayOfMonth();
		    	  dNum += today.getYear();
		    	  System.out.println(dNum);
		    	  ts.setCurrentDate(dNum);
		    	  ts.setShelterList(d.getstateShelters());
		    	  ts.displayShelters();
				c1.show(panelCont, "Surrender");
			}
		});
		
		buttonEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    	  String email = JOptionPane.showInputDialog("Enter your email:");
		    	  
		    	  CustomerEmail ce = new CustomerEmail();
		    	  ce.setDatabase(db);
		    	  ce.setCurrentEmail(email);
		    	  ce.displayEmail();				
			}
			
		});
		
		returnFoster.addActionListener(new ReturnButtonListener());
		
		setLayout(new BorderLayout());
		Dimension d = new Dimension(600,400);
		setPreferredSize(d);
		
		add(panelCont, BorderLayout.CENTER);
		add(options, BorderLayout.NORTH);
		c1.show(panelCont, "Welcome");
		setVisible(true);
		
	}
	
	public class ReturnButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	      }
	   }
	      }
	    	/*  
	    	  int detect = -1; 
	    	  
	    	  String sheltername = JOptionPane.showInputDialog("Enter shelter name:");
	    	  
	    	  for(int i = 0; i < d.getstateShelters().size(); ++i) {
	    		  String s = d.getstateShelters().get(i).getName();
	    		  if(sheltername.equals(s)) {
	    			  detect = i;
	    			  break;
	    		  }
	    	  }
	    	  
	    	  if(detect != -1) {
	    		  
	    	  Shelter currentShelter = d.getstateShelters().get(detect);
	    	  
	    	  String idnum;
	    	  
	    	  idnum = JOptionPane.showInputDialog("Enter ID number of the animal you're returning:");
	    	  
	    	  if(idnum != null && !(idnum.equals(""))) {
	    		  
	    		  int i = Integer.parseInt(idnum);
	    		  if (i >= 0) {
	    		  int detect1 = -1;
	    		  
	    		  for(int j = 0; j < currentShelter.getHistory().size(); ++j) {
	    			  Animal current = currentShelter.getHistory().get(j);
	    			  if(current.getFoster() == true && current.getID() == i &&
	    					  current.getOwnerName().equals(currentPerson)) {
	    				  		detect = j;
	    				  		break;
	    			  }
	    		  }
	    		  
	    		  if(detect != -1) {
	    			  
	    			  Animal a = currentShelter.getHistory().get(detect);
	    			  
	    			  String adopt;
	    			  DecimalFormat df2 = new DecimalFormat("#.00");
	    			  
	    			  adopt = JOptionPane.showInputDialog("Would you like to adopt this animal?");
	    			  
	    			  if(adopt != null && !(adopt.equals(""))) {
	    				  if(adopt.equals("yes")) {
	    					  a.setFoster(false);
	    					  String message = "You have adopted " + a.getName() + "! " +
	    							  a.getName() + "'s adoption fee is $" + 
	    							  df2.format(a.getAdoptionFee()) + ". Please come into the "
	    							  		+ "shelter to make the payment.";
	    					  JOptionPane.showMessageDialog(null, message, "Adoption Successful", 
	    							  JOptionPane.INFORMATION_MESSAGE);
	    				  }
	    				  else if(adopt.equals("no")) {
	    					  a.setFoster(false);
	    					  currentShelter.addCurrentAnimal(a);
	    				  }
	    				  else {
	    					  String error = "The valid responses are eithter yes or no. Please enter a valid "
	    					  		+ "response.";
	    					  JOptionPane.showMessageDialog(null, error, "Invalid response", JOptionPane.ERROR_MESSAGE);
	    				  }
	    			  }
	    			  else {
	    				  String error = "The input is blank. Please input either yes or no.";
	    				  JOptionPane.showMessageDialog(null, error, "Blank response", JOptionPane.ERROR_MESSAGE);
	    			  }
	    			  
	    		  }
	    		  else {
	    			  String error = "The animal ID you specified either doesn't exist in the system, it isn't "
	    			  		+ "a fosterable animal, or your name doesn't match the foster animal's current "
	    			  		+ "foster name.";
	    			  JOptionPane.showMessageDialog(null, error, "Couldn't Find Animal", JOptionPane.ERROR_MESSAGE);
	    		  }
	    		  }
	    		  else {
	    			  String error = "ID numbers can't be negative. Please input a valid ID number.";
	    			  JOptionPane.showMessageDialog(null, error, "Invalid Animal ID", JOptionPane.ERROR_MESSAGE);
	    		  }
	    	  }
	    	  else {
	    		  String error = "The ID field is blank. Please input a valid animal ID to continue";
	    		  JOptionPane.showMessageDialog(null, error, "Blank ID", JOptionPane.ERROR_MESSAGE);
	    	  }
	    	  
	      }
	   }*/

	
