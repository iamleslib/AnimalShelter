package org.database.interf;

import javax.imageio.ImageIO;
import javax.swing.*;
import org.database.actors.Database;
import org.database.actors.Shelter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ShelterGUI extends JFrame {

	public Database d;
	
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem fileSave;
	private JMenuItem fileLoad;
	private JMenuItem fileExit;
	private JMenu shelterMenu;
	private JMenuItem shelterAdd;
	private JMenuItem shelterRemove;
	private JPanel panelCont;
	private JPanel options;
	private JPanel welcome;
	private CustomerPanel customer;
	private ShelterPanel shelter;
	private JButton buttonShelter;
	private JButton buttonCustomer;
	private CardLayout c1;
	
	public ShelterGUI(Database db) {
		super("Animal Shelter System");
		d = db;

		// Builds menu bar with file(save, load, exit) and shelter(add, remove)
		buildMenuBar();
		
		// Builds panel to select a user
		createUserSelectionPanel();
		
		// Creates main panel for the program to display further information
		createMainPanel();
		
		setLayout(new BorderLayout());
		add(panelCont, BorderLayout.CENTER);
		add(options, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,900);
		setLocationRelativeTo(null);
	//	this.setResizable(false);
		setVisible(true);
	}
	
	private void buildMenuBar() {
		menuBar = new JMenuBar();
		buildFileMenu();
		buildShelterMenu();
		
		menuBar.add(fileMenu);
		menuBar.add(shelterMenu);
		
		setJMenuBar(menuBar);
	}
	
	private void buildFileMenu() {
		fileSave = new JMenuItem("Save");
		fileSave.addActionListener(new MenuListener());
		fileLoad = new JMenuItem("Load");
		fileLoad.addActionListener(new MenuListener());
		fileExit = new JMenuItem("Exit");
		fileExit.addActionListener(new MenuListener());
		
		fileMenu = new JMenu("File");
		
		fileMenu.add(fileSave);
		fileMenu.add(fileLoad);
		fileMenu.add(fileExit);
	}
	
	private void buildShelterMenu() {
		shelterAdd = new JMenuItem("Add New Shelter");
		shelterAdd.addActionListener(new MenuListener());
		shelterRemove = new JMenuItem("Remove Existing Shelter");
		shelterRemove.addActionListener(new MenuListener());
		
		shelterMenu = new JMenu("Shelter");
		
		shelterMenu.add(shelterAdd);
		shelterMenu.add(shelterRemove);
	}
	
	private class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(fileSave)) {
				handleSave();
			}
			else if(source.equals(fileLoad)) {
				handleLoad();
			}
			else if(source.equals(fileExit)) {
				handleExit();
			}
			else if(source.equals(shelterAdd)) {
				handleAdd();
			}
			else if(source.equals(shelterRemove)) {
				handleRemove();
			}
		}
		
		public void handleSave() {
			Database.saveData(d);
		}
		public void handleLoad() {
			d = Database.loadData();
			System.out.println("Loaded: " + d.getAllShelters().get(0).getName());
		}
		public void handleExit() {
			System.exit(0);
		}
		
		public void handleAdd() {
			String state1 = "";   // To hold text entered
	        boolean check1 = false;

	        while(check1 == false) {
		        state1 = JOptionPane.showInputDialog("Enter shelter name:");
		         
		        if(state1 != "" && state1 != null) {
		        	check1 = true;
		        	for(Shelter existingShelter : d.getAllShelters()) {
		        		if(existingShelter.getName().equals(state1)) {
		        			check1 = false;
		        		}
		        	}
		         }
	         }
	        
	        String state = "";   // To hold text entered
	        boolean check = false;

	        while(check == false) {
		        state = JOptionPane.showInputDialog("Enter state name:");
		         
		        if(state != null && state != "") {
		        check = d.isWithinUS(state); //check if input is within the US
		        if(check == true) {
		        	break;
		         }
				else {
				String error = "The input that you entered is either not a valid US state or misspelled. Please enter "+
						"a state in the US.";
				JOptionPane.showMessageDialog(null, error, "Not located in the US", JOptionPane.INFORMATION_MESSAGE);
	
		         }
		         }
	         }
	       
	        
	        Shelter addedShelter = new Shelter();
	        addedShelter.setName(state1);
	        addedShelter.setState(state);
	        d.addShelter(addedShelter);
	        JOptionPane.showMessageDialog(null, "Select this shelter as the user to edit remaining information.", "Shelter Added", JOptionPane.OK_OPTION);
	       
		}
		
		public void handleRemove() {
			String state;   // To hold text entered
	        Shelter s = null;
	        
	        while(s == null) {
	        	state = JOptionPane.showInputDialog("Enter shelter name:");
	         
	        	if(state != null) {
	        		s = d.findShelter(state); //check if input is within the US
	        		if(s != null) {
	        			break;
	        		}
	        		else {
	        			String error = "The input that you entered is either not a valid shelter or misspelled. Please enter "+
	    						"a valid shelter name.";
	        			JOptionPane.showMessageDialog(null, error, "Not located in the US", JOptionPane.INFORMATION_MESSAGE);
	        		}
	        	}
	        }
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this shelter?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
			if(confirm == 0) {
				d.removeShelter(s);
			}
		
		}
		
		
	}
	
	public void createUserSelectionPanel() {
		options = new JPanel();
		buttonShelter = new JButton("Shelter");
		buttonCustomer = new JButton("Customer");
		//image 
		
		
		options.setLayout(new FlowLayout());
		options.setBorder(BorderFactory.createTitledBorder("Select User"));
		options.add(buttonCustomer);
		options.add(buttonShelter);
		
		buttonShelter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String state;   // To hold text entered
		        Shelter s = null;
		        
		        while(s == null) {
		        	state = JOptionPane.showInputDialog("Enter shelter name:");
		         
		        	if(state != null) {
		        		s = d.findShelter(state); //check if input is within the US
		        		if(s != null) {
		        			break;
		        		}
		        		else {
		        			String error = "The input that you entered is either not a valid shelter or misspelled. Please enter "+
		    						"a valid shelter name.";
		        			JOptionPane.showMessageDialog(null, error, "Not located in the US", JOptionPane.INFORMATION_MESSAGE);
		        		}
		        	}
		        }
				shelter = new ShelterPanel(d, s);
				panelCont.add(shelter, s.getName());
				c1.show(panelCont, s.getName());
			}
		});
		
		buttonCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String state;   // To hold text entered
		        boolean check = false;

		        while(check == false) {
		        state = JOptionPane.showInputDialog("Enter state name:");
		         
		        if(state != null) {
		        check = d.isWithinUS(state); //check if input is within the US
		        if(check == true) {
		        	d.findstateShelters(state);
		        	if(d.getstateShelters().size() == 0) {
		        		String error = "There are no shelters registered in " + state + ".";
		        		JOptionPane.showMessageDialog(null, error, "No shelters in the state", JOptionPane.INFORMATION_MESSAGE);
		        		check = false;
		        	}
		        	else {
		        		 break;
		        	 }
		         }
				else {
				String error = "The input that you entered is either not a valid US state or misspelled. Please enter "+
						"a state in the US.";
				JOptionPane.showMessageDialog(null, error, "Not located in the US", JOptionPane.INFORMATION_MESSAGE);

		         }
		         }
		         }
		        customer = new CustomerPanel(d);
		        panelCont.add(customer, "Customer");
				c1.show(panelCont, "Customer");
			}
		});
	}
	
	public void createMainPanel() {
		panelCont = new JPanel();
		welcome = new JPanel();
		
		ImageIcon image = new ImageIcon(getClass().getResource("AnimalShelter.jpg"));
		welcome.add(new JLabel(image), BorderLayout.SOUTH);
		
		c1 = new CardLayout();
		
		welcome.setBackground(Color.WHITE);
		options.setBackground(Color.orange);
		
		
//		shelter.setBackground(Color.red);
				
		panelCont.setLayout(c1);

		panelCont.add(welcome, "Welcome");

		c1.show(panelCont, "Welcome");
	}
}