package org.database.interf1;

import org.database.actors.Animal;

import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.interf1.TurnInStray.ShelterButtonListener;
import org.database.transactions.Surrender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class SurrenderInfo extends JFrame {
	
	private JPanel panel;             // A panel container
	private JButton continueButton;      
	private final int WINDOW_WIDTH = 300;  // Window width
	private final int WINDOW_HEIGHT = 200; // Window height
	private Shelter currentShelter; //set of shelters you're currently working with
	private int currentDate;
	private JLabel nameanimal;
	private JTextField name;
	private JLabel speciesanimal;
	private JTextField species; 
	private JLabel animalgender;
	private JTextField gender;
	private JLabel animalbreed;
	private JTextField breed;
	private JLabel animalstray;
	private JTextField stray; 
	
	SurrenderInfo() {
		// Call the JFrame constructor.
	    super("Surrendered Animal Info");

	    // Set the size of the window.
	    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	    // Specify what happens when the close
	    // button is clicked.
	    
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
		}
	
	public void setShelterList(Shelter sh) {
		currentShelter = sh;
	}
	
	public void setCurrentDate(int cd) {
		currentDate = cd;
	}
	
	public void fillInInfo() {
		// Build the panel and add it to the frame.
	    buildPanel();

	    // Add the panel to the frame's content pane.
	    add(panel);
	    
	    setVisible(true);
	}
	
	private void buildPanel() {
		
		nameanimal = new JLabel("Animal Name:");
		name = new JTextField(30);
		speciesanimal = new JLabel("Species:");
		species = new JTextField(20); 
		animalgender = new JLabel("Gender:");
		gender = new JTextField(10);
		animalbreed = new JLabel("Breed:");
		breed = new JTextField(30);
		animalstray = new JLabel("Is the animal a stray?:");
		stray = new JTextField(5);
		
		continueButton = new JButton("Continue");
		
		continueButton.addActionListener(new ContinueButtonListener());
		
		panel = new JPanel();
		
		panel.add(nameanimal);
		panel.add(name);
		panel.add(speciesanimal);
		panel.add(species);
		panel.add(animalbreed);
		panel.add(breed);
		panel.add(animalgender);
		panel.add(gender);
		panel.add(animalstray);
		panel.add(stray);
		panel.add(continueButton);
		
	}
	
	public class ContinueButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
				String n = name.getText();
				String sp = species.getText();
				String br = breed.getText();
				String ge = gender.getText();
				String st = stray.getText();
				int detect = -1;
				boolean check = false;
				
				
				if(n == null || n.equals("")) {
					String error = "The name input is blank. Please input a name for the animal.";
					JOptionPane.showMessageDialog(null, error, "Blank name", JOptionPane.ERROR_MESSAGE);
				}
				else if(sp == null || sp.equals("")) {
					String error = "The species input is blank. Please input a species for the animal.";
					JOptionPane.showMessageDialog(null, error, "Blank species", JOptionPane.ERROR_MESSAGE);
				}
				else if(br == null || br.equals("")) {
					String error = "The breed input is blank. Please input a breed for the animal.";
					JOptionPane.showMessageDialog(null, error, "Blank breed", JOptionPane.ERROR_MESSAGE);
				}
				else if(ge == null || ge.equals("")) {
					String error = "The gender input is blank. Please input a gender for the animal.";
					JOptionPane.showMessageDialog(null, error, "Blank gender", JOptionPane.ERROR_MESSAGE);
				}
				else if(st == null || st.equals("")) {
					String error = "The stray input is blank. Please input whether the animal is a stray or not.";
					JOptionPane.showMessageDialog(null, error, "Blank stray", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
						if(ge.equals("Female") || ge.equals("Male")) {
							if(st.equals("yes") || st.equals("no")) {
								if(st.equals("yes")) {
									check = true;
								}
								else {
									check = false;
								}
								detect = 1;
							}
							else {
								String error = "The stray option you put in is invalid. The options are either"
										+ " yes or no.";
								JOptionPane.showMessageDialog(null, error, "Blank stray", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							String error = "The gender you put is invalid. The options are either Female or Male.";
							JOptionPane.showMessageDialog(null, error, "Blank stray", JOptionPane.ERROR_MESSAGE);
						}
				}
				
				if(detect == 1) {
					Animal a = new Animal();
					a.setName(n);
					a.setSpecies(sp);
					a.setBreed(br);
					a.setGender(ge);
					a.setStray(check);
					a.setArrival(currentDate);
					currentShelter.addtoWaitingList(a);
					a.setTransaction(new Surrender(a, null, currentShelter));
					String info = "The pet has been successfully added into the shelter's system. Please"
	    					+ " drop the animal off at the shelter. Its address is:\n"
	    					+ currentShelter.getAddress();
	    			JOptionPane.showMessageDialog(null, info, "Surrender registered", JOptionPane.INFORMATION_MESSAGE);
					if(check == true) {
						
						JPanel set = new JPanel();
						
						JLabel age = new JLabel("Age:");
						JTextField agefield = new JTextField(20);
						
						JLabel units = new JLabel("Units:");
						JTextField unitsfield = new JTextField(10);
						
						set.add(age);
						set.add(agefield);
						set.add(units);
						set.add(unitsfield);
						
						int result = JOptionPane.showConfirmDialog(null, set, 
					               "Set Age", JOptionPane.OK_CANCEL_OPTION);
					      if (result == JOptionPane.OK_OPTION) {
					    	  String af = agefield.getText();
					    	  String uf = unitsfield.getText();
					    	  
					    	  if(af != null && !(af.equals("")) && uf != null && !(uf.equals(""))) {
					    		  int imtired = Integer.parseInt(af);
					    		  
					    		  if(imtired >= 0) {
			  							String ageunitcheck = uf;
			  							
			  							if(!(ageunitcheck.equals("days")) && !(ageunitcheck.equals("day")) && !(ageunitcheck.equals("months")) 
			  								&& !(ageunitcheck.equals("month")) && !(ageunitcheck.equals("years")) && !(ageunitcheck.equals("year"))) {
			  							String error = "The unit of time you put is invalid. The valid units of time for the age of an animal "
			  										+ "is either day(s), month(s), or year(s).";
			  							JOptionPane.showMessageDialog(null, error, "Invalid age", JOptionPane.ERROR_MESSAGE);
			  							}
			  							else {
			  								a.setbirthDate(1, imtired, uf);
			  							}
			  						}
			  						else {
			  							String error = "The age can't be negative. Please enter a valid age.";
			  							JOptionPane.showMessageDialog(null, error, "Invalid age", JOptionPane.ERROR_MESSAGE);
			  						}
			  						
			  						}
			  					else {
			  						String error = "Either one of the age fields or both of the age fields are blank. Please"
			  								+ " enter a valid age and age units.";
			  						JOptionPane.showMessageDialog(null, error, "Blank age", JOptionPane.ERROR_MESSAGE);
			  						
			  					}
					    	  }
					      }
					
//					else {
//						String birthdate = JOptionPane.showInputDialog("Enter animal's birthdate:");
//						if(birthdate != null && !(birthdate.equals(""))) {
//							String error = null;
//					  	    int date;
//					  	    boolean checks = false;
//					  	    
//					  	    
//					  	    date = Integer.parseInt(birthdate);
//					  	    
//					  	    int dday = 0;
//					  		int dmonth = 0;
//
//					  		dmonth = date / 1000000;
//					  		dday = date / 10000;
//					  		dday = dday % 100;
//					  		
//					  		if(date <= 0) {
//					  			error = "The date you entered is invalid. The date can't be negative or 0.";
//					  		}
//					  		else if(date <= 1000000) {
//					  			error = "The date can't be less than 7 digits.";
//					  		}
//							else if(dmonth > 12 && dday > 31) {
//								error = "The month and day you entered is invalid. The month can't be greater than 12, and the day can't be greater than 31."; 
//							}
//							else if(dmonth > 12 || dmonth == 0) {
//					  			error = "The month you entered is invalid. The month ranges from 1 to 12.";
//					  		}
//					  		else if(dday > 31 || dday == 0) {
//					  			error = "The day you entered is invalid. The month ranges from 1 to 31 depending upon the month.";
//					  		}
//					  		else if((dmonth == 4 || dmonth == 6 || dmonth == 9 || dmonth == 11) && (dday > 30)) {
//					  			error = "The day you entered is invalid. The month ranges from 1 to 30 for the inputted month.";
//					  		}
//					  		else if(dmonth == 2 && (dday > 28)) {
//					  			error = "The day you entered is invalid. The month ranges from 1 to 28 for the inputted month. "
//					  					+ "This system ignores leap years.";
//					  		}
//					  		else {
//					  			checks = true;
//					  		}
//					  		
//					  		if(checks == true) {
//					  			a.setbirthDate(date, 1, "year");
//					  		}
//					  		else {
//					  			JOptionPane.showMessageDialog(null, error, "Incorrect date", JOptionPane.INFORMATION_MESSAGE);
//					  		}
//						}
//						else {
//							String error = "The birth date is empty. Please enter a valid birth date.";
//							JOptionPane.showMessageDialog(null, error, "Blank date", JOptionPane.ERROR_MESSAGE);
//						}
//					}
						
					}
				}
			
			
			}
		
	}

