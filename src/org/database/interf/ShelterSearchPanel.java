package org.database.interf;

import javax.swing.*;

import org.database.actors.Animal;
import org.database.actors.Shelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShelterSearchPanel extends JPanel {
private JPanel panel;             // A panel container
private JLabel searchMessage;      // A message to display
private DisplayAnimalsPanel displayAnimals;
private JPanel centerDisplay;
private CardLayout c1;
private JButton performSearch;
private JCheckBox breed;
private JCheckBox species;     
private JCheckBox size;   
private JCheckBox age;
private JCheckBox gender;
private Shelter currentshelter;
private final int WINDOW_WIDTH = 300;  // Window width
private final int WINDOW_HEIGHT = 200; // Window height
private int currentDate;
private Integer sView = 0;

public ShelterSearchPanel(Shelter s) {
	JPanel welcome = new JPanel();
	welcome.setBackground(Color.darkGray);
	currentshelter = s;
	c1 = new CardLayout();
	setLayout(new BorderLayout());
	centerDisplay = new JPanel(c1);
	centerDisplay.add(welcome, "Welcome");
	add(centerDisplay, BorderLayout.CENTER);
	displaySearch();
	c1.show(centerDisplay, "Welcome");
	
}

public void setShelter(Shelter s) {
	currentshelter = s;
}

public void setCurrentDate(int date) {
	currentDate = date;
}

public void displaySearch() {
		
	 panel = new JPanel();
		
	 //searchMessage = new JLabel("You can search for animals here. Please specify which search critiera you "
	 //		+ "would like to search by.");
	breed = new JCheckBox("Breed");
	species = new JCheckBox("Species");
	size = new JCheckBox("Size");
	age = new JCheckBox("Age");
	gender = new JCheckBox("Gender");
	performSearch = new JButton("Search");
	performSearch.addActionListener(new SearchButtonListener());
	
//	panel.add(searchMessage);
	panel.add(breed);
	panel.add(species);
	panel.add(gender);
	panel.add(size);
	panel.add(age);
	panel.add(performSearch);
    panel.setBorder(BorderFactory.createTitledBorder("Select Search Criteria"));
	add(panel, BorderLayout.NORTH);


	currentshelter.setSearchforAdoption();
	
	setVisible(true);
}


public class SearchButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	  currentshelter.setSearchforAdoption();
    	  
    	  JPanel add = new JPanel();
    	  
    	  JLabel b = new JLabel("Breed:");
    	  JTextField bn = new JTextField(30);
    	  JLabel s = new JLabel("Species:");
    	  JTextField sp = new JTextField(20);
    	  JLabel g = new JLabel("Gender:");
    	  JTextField gn = new JTextField(20);
    	  JLabel agenum = new JLabel("Age number:");
    	  JTextField agen = new JTextField(30);
    	  JLabel ageunits = new JLabel("Age units: (days, months, years)");
    	  JTextField ageu = new JTextField(20);
    	  JLabel ss = new JLabel("Size: (small, medium, large)");
    	  JTextField sz = new JTextField(20);
    	  
  		
  			if(breed.isSelected()) {
  				add.add(b);
  				add.add(bn);
  			}
  			if(species.isSelected()) {
  				add.add(s);
  				add.add(sp);
  			}
  			if(gender.isSelected()) {
  				add.add(g);
  				add.add(gn);
  			}
  			if(age.isSelected()) {
  				add.add(agenum);
  				add.add(agen);
  				add.add(ageunits);
  				add.add(ageu);
  			}
  			if(size.isSelected()) {
  				add.add(ss);
  				add.add(sz);
  			}
  			
  			int result = JOptionPane.showConfirmDialog(null, add, 
 	               "Searching", JOptionPane.OK_CANCEL_OPTION);
  			
  			if (result == JOptionPane.OK_OPTION) {
  				
  				if(breed.isSelected()) {
  					String br;
  					
  					br = bn.getText(); 
  					
  					if(br != null && !(br.equals(""))) {
  						currentshelter.breedSearchCriteria(br);
  					}
  					else {
  						String error = "The breed field is blank even though you selected it. Please enter a breed.";
  						JOptionPane.showMessageDialog(null, error, "Blank breed", JOptionPane.ERROR_MESSAGE);
  					}
  				}
  				if(species.isSelected()) {
  					String spec;
  					
  					spec = sp.getText();
  					
  					if(spec != null && !(spec.equals(""))) {
  						currentshelter.speciesSearchCriteria(spec);
  					}
  					else {
  						String error = "The species field is blank even though you selected it. Please enter a species.";
  						JOptionPane.showMessageDialog(null, error, "Blank species", JOptionPane.ERROR_MESSAGE);
  					}
  					
  				}
  				if(gender.isSelected()) {
  					String gen;
  					
  					gen = gn.getText();
  					
  					if(gen != null && !(gen.equals(""))) {
  						String gg;
  						gg = gen;
  						
  						if(gg.equals("Female") || gg.equals("Male") || gg.equals("Boy") || gg.equals("Girl") || gg.equals("M") || 
  								gg.equals("F")) {
  							currentshelter.genderSearchCriteria(gen);
  						}
  						else {
  							String error = "The gender you put in isn't a valid option. The possible entries are Female, Male, " 
  									+ "Boy, Girl, F, or M.";
  							JOptionPane.showMessageDialog(null, error, "Invalid gender", JOptionPane.ERROR_MESSAGE);
  						}
  					}
  					else {
  						String error = "The gender field is blank even though you selected it. Please enter a valid gender.";
  						JOptionPane.showMessageDialog(null, error, "Blank gender", JOptionPane.ERROR_MESSAGE);
  					}
  					
  				}
  				if(size.isSelected()) {
  					String sjjg;
  					sjjg = sz.getText();
  					if(sjjg != null && !(sjjg.equals(""))) {
  						String sjj = sjjg;
  						
  						if(sjj.equals("small") || sjj.equals("medium") || sjj.equals("large")) {
  							currentshelter.sizeSearchCriteria(sjjg);
  						}
  						else {
  							String error = "The options for size are either small, medium, or large.";
  							JOptionPane.showMessageDialog(null, error, "Invalid size", JOptionPane.ERROR_MESSAGE);
  						}
  					}
  					else {
  						String error = "The size field is blank even though you selected it. Please enter a valid size.";
  						JOptionPane.showMessageDialog(null, error, "Blank size", JOptionPane.ERROR_MESSAGE);
  					}
  					
  				}
  				if(age.isSelected()) {
  					String ageuu = ageu.getText();
  					String agenn = agen.getText();
  					
  					if(ageuu != null & !(ageuu.equals("")) && agenn != null && !(agenn.equals(""))) {
  						
  						int agecheck = Integer.parseInt(agenn);
  						
  						if(agecheck >= 0) {
  							String ageunitcheck = ageuu;
  							
  							if(!(ageunitcheck.equals("days")) && !(ageunitcheck.equals("day")) && !(ageunitcheck.equals("months")) 
  								&& !(ageunitcheck.equals("month")) && !(ageunitcheck.equals("years")) && !(ageunitcheck.equals("year"))) {
  							String error = "The unit of time you put is invalid. The valid units of time for the age of an animal "
  										+ "is either day(s), month(s), or year(s).";
  							JOptionPane.showMessageDialog(null, error, "Invalid age", JOptionPane.ERROR_MESSAGE);
  							}
  							else {
  								currentshelter.ageSearchCriteria(agecheck, ageuu, currentDate);
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
  			
  				if(currentshelter.getSearchCriteria().size() == 0) {
  					String error = "No animals meet your search critiera. Please make an entirely new search"
  							+ " by closing the checklist and reopening the search window.";
  					JOptionPane.showMessageDialog(null, error, "No animal found", JOptionPane.INFORMATION_MESSAGE);
  				}
  				else {
  					displayAnimals = new DisplayAnimalsPanel(currentshelter.getSearchCriteria());
  					for(Animal a : currentshelter.getSearchCriteria()) {
  						System.out.println(a.getName());
  					}
  					centerDisplay.add(displayAnimals, sView.toString());
  					c1.show(centerDisplay, sView.toString());
  					sView++;
//  					String toprint = null;
//  					
//  					//DefaultListModel<String> animallist = new DefaultListModel<>();
//  			      
//  			      for(int i = 0; i < currentshelter.getSearchCriteria().size(); ++i) {
//  			    	  String ssss;
//  			    	  ssss = currentshelter.getSearchCriteria().get(i).getName();
//  			    	  if(i == 0) {
//  			    		  toprint = ssss;
//  			    	  }
//  			    	  else {
//  			    		  toprint = toprint + "\n" + ssss;
//  			    	  }
//  			      }
//  			      
//  			    JOptionPane.showMessageDialog(null, toprint, "Animals found", JOptionPane.INFORMATION_MESSAGE);
  				}
  				
  			}
  			
  			}
      }
}

