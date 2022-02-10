package org.database.interf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.contact.Email;


public class ShelterPanel extends JPanel {
	private Shelter s;
	//private Database d;
	private JPanel panelCont;
	private JPanel welcome;
	private JPanel options;
	private AddNewAnimalPanel addNewAnimal;
	private EditAnimalsPanel viewAnimals;
	private EditShelterInfoPanel viewShelter;
	private JPanel emails;
	private JButton buttonAvailableAnimals;
	private JButton buttonWaitingAnimals;
	private JButton buttonShelter;
	private JButton buttonAddNew;
	private JButton buttonEmail;
	private CardLayout c1;
	
	public ShelterPanel(Database db, Shelter sh) {
		s = sh;
		//d = db;
		panelCont = new JPanel();
		options = new JPanel();
		welcome = new JPanel();
		viewShelter = new EditShelterInfoPanel(s);
		emails = new JPanel();
		buttonAvailableAnimals = new JButton("Available Animals");
		buttonWaitingAnimals = new JButton("Waiting Animals");
		buttonShelter = new JButton("View/Edit Shelter");
		buttonAddNew = new JButton("Add New Animal");
		buttonEmail = new JButton("Email");
		c1 = new CardLayout();
		
		welcome.setBackground(Color.black);
		//viewAnimals.setBackground(Color.blue);
		//viewShelter.setBackground(Color.red);
		
		options.setLayout(new FlowLayout());
		options.setBorder(BorderFactory.createTitledBorder("Select Action"));
		options.add(buttonAvailableAnimals);
		options.add(buttonWaitingAnimals);
		options.add(buttonShelter);
		options.add(buttonAddNew);
		options.add(buttonEmail);
		
		panelCont.setLayout(c1);
		panelCont.add(viewShelter, "Shelter");
		panelCont.add(welcome, "Welcome");
		
		buttonAvailableAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAnimals = new EditAnimalsPanel(s.getCurrentAnimals(), s, db);
				panelCont.add(viewAnimals, "A Animals");
				c1.show(panelCont, "A Animals");
			}
		});
		buttonWaitingAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAnimals = new EditAnimalsPanel(s.getWaitingList(), s, db);
				panelCont.add(viewAnimals, "W Animals");
				c1.show(panelCont, "W Animals");
			}
		});
		
		buttonShelter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				c1.show(panelCont, "Shelter");
			}
		});
		
		buttonAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewAnimal = new AddNewAnimalPanel(new Animal(), s, db);
				panelCont.add(addNewAnimal, "Add New");
				c1.show(panelCont, "Add New");
				
			}
			
			
		});
		
		buttonEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emails.removeAll();
				for(Email em : s.getEmailList()) {
					JPanel emailPanel = new JPanel();
					JTextArea text = new JTextArea(em.displayEmail());
					text.setEditable(false);
					text.setBorder(BorderFactory.createLineBorder(Color.black));
					emailPanel.add(text);
					emails.add(emailPanel);
				}
				
				
				panelCont.add(emails, "Email");
				c1.show(panelCont, "Email");
				
			}
			
			
		});
		
		
		
		setLayout(new BorderLayout());
		//Dimension d = new Dimension(600,400);
		//setPreferredSize(d);
		
		add(panelCont, BorderLayout.CENTER);
		add(options, BorderLayout.NORTH);
		c1.show(panelCont, "Welcome");
		setVisible(true);
	}
	
}



//
//	private JPanel panelShow;
//	private JRadioButton buttonViewAnimals;
//	private JRadioButton buttonShelterInfo;
//	private JButton buttonContinue;
//
//	private ButtonGroup bg;
//   /**
//    *  Constructor
//    */
//
//	public ShelterPanel(){
//	   panelShow = new JPanel(new CardLayout());
//      // Create a GridLayout manager with
//      // two rows and one column.
//      setLayout(new GridLayout(2, 3));
//
//      // Create the radio buttons.
//      buttonViewAnimals = new JRadioButton("View Animals");
//      buttonShelterInfo = new JRadioButton("View Shelter Info");
//
//      buttonContinue = new JButton("Continue");
//      buttonContinue.addActionListener(new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			System.exit(0);
//		}
//    	  
//      });
//
//
//      // Add a border around the panel.
//      setBorder(BorderFactory.createLineBorder(Color.black));
//
//      // Group the radio buttons.
//      bg = new ButtonGroup();
//      bg.add(buttonViewAnimals);
//      bg.add(buttonShelterInfo);
//
//
//      // Add the radio buttons to this panel.
//      add(buttonViewAnimals);
//      add(buttonShelterInfo);
//      add(buttonContinue);
//   }
//   
//}