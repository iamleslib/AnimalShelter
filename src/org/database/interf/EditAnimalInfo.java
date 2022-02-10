package org.database.interf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.transactions.Transfer;

public class EditAnimalInfo extends JPanel{
	private JLabel name;
	private JLabel species;
	private JLabel breed;
	private JPanel info;
	private JButton transfer;
	private JButton editInfo;

	
	public EditAnimalInfo(Animal a, Shelter s, Database d) {
		
		name = new JLabel(a.getName());
		species = new JLabel("Species: " + a.getSpecies());
		breed = new JLabel("Breed: " + a.getBreed());
		transfer = new JButton("Transfer");
		editInfo = new JButton("Edit Info");
		
		//
		JPanel pName = new JPanel();
		JLabel lName = new JLabel("Name");
		JTextField tName = new JTextField(5);
		tName.setText(a.getName());
		pName.add(lName);
		pName.add(tName);
		
		/*
		JPanel pOwnerName = new JPanel();
		JLabel lOwnerName = new JLabel("Owner name");
		JTextField tOwnerName = new JTextField();
		tOwnerName.setText(a.getOwnerName());
		pOwnerName.add(lOwnerName);
		pOwnerName.add(tOwnerName);
		*/
		JPanel pSpecies = new JPanel();
		JLabel lSpecies = new JLabel("Species");
		JTextField tSpecies = new JTextField(5);
		tSpecies.setText(a.getSpecies());
		pSpecies.add(lSpecies);
		pSpecies.add(tSpecies);

		JPanel pIDnumber = new JPanel();
		JLabel lIDnumber = new JLabel("ID number");
		JTextField tIDnumber = new JTextField(5);
		tIDnumber.setText(Integer.toString(a.getID()));
		pIDnumber.add(lIDnumber);
		pIDnumber.add(tIDnumber);
		/*
		JPanel pDescription = new JPanel();
		JLabel lDescription = new JLabel("Description");
		JTextField tDescription = new JTextField();
		tDescription.setText(Integer.toString(s.getZipcode()));
		pDescription.add(lDescription);
		pDescription.add(tDescription);
		*/
		JPanel pAdoptionFee = new JPanel();
		JLabel lAdoptionFee = new JLabel("Adoption Fee");
		JTextField tAdoptionFee = new JTextField(5);
		tAdoptionFee.setText(Double.toString(a.getAdoptionFee()));
		pAdoptionFee.add(lAdoptionFee);
		pAdoptionFee.add(tAdoptionFee);
		
		JPanel pGender = new JPanel();
		JLabel lGender = new JLabel("Gender");
		JTextField tGender = new JTextField(5);
		tGender.setText(a.getGender());
		pGender.add(lGender);
		pGender.add(tGender);
		
		JPanel pBreed = new JPanel();
		JLabel lBreed = new JLabel("Breed");
		JTextField tBreed = new JTextField(5);
		tBreed.setText(a.getBreed());
		pBreed.add(lBreed);
		pBreed.add(tBreed);
		
		JPanel pWeight = new JPanel();
		JLabel lWeight = new JLabel("Weight");
		JTextField tWeight = new JTextField(5);
		tWeight.setText(Double.toString(a.getWeight()));
		pWeight.add(lWeight);
		pWeight.add(tWeight);
		
		JPanel pSize = new JPanel();
		JLabel lSize = new JLabel("Size");
		JTextField tSize = new JTextField(5);
		tSize.setText(a.getSize());
		pSize.add(lSize);
		pSize.add(tSize);
		/*
		JPanel pBirthDate = new JPanel();
		JLabel lBirthDate = new JLabel("Birthdate");
		JTextField tBirthDate = new JTextField();
		tBirthDate.setText(a.getSize());
		pBirthDate.add(lBirthDate);
		pBirthDate.add(tBirthDate);
		*/
		
		JPanel pArrivalDate = new JPanel();
		JLabel lArrivalDate = new JLabel("Arrival Date");
		JTextField tArrivalDate = new JTextField(20);
		tArrivalDate.setText(a.getArrival());
		pArrivalDate.add(lArrivalDate);
		pArrivalDate.add(tArrivalDate);
		
		transfer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String state;   // To hold text entered
		        Shelter sRecieve = null;
		        
		        while(sRecieve == null) {
		        	//JOptionPane.showInputDialog(null, "Enter shelter to be transferred to:", "Transfer", JOptionPane.OK_CANCEL_OPTION);
		        	
		        	state = JOptionPane.showInputDialog("Enter shelter to be transferred to:");
		        	
		        	if(state != null) {
		        		sRecieve = d.findShelter(state); //check if input is within the US
		        		if(sRecieve != null) {
		        			break;
		        		}
		        		else {
		        			String error = "The input that you entered is either not a valid shelter or misspelled. Please enter "+
		    						"a valid shelter name.";
		        			JOptionPane.showMessageDialog(null, error, "Invalid Shelter", JOptionPane.INFORMATION_MESSAGE);
		        		}
		        	}
		        }
				Transfer t = new Transfer(a, s, sRecieve);
				t.PerformTransaction();
				JOptionPane.showMessageDialog(null, "Transfer Completed Successfully", "Transfer Completed", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		editInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				a.setName(tName.getText());
				//a.setOwnerName(tOwnerName.getText());
				a.setSpecies(tSpecies.getText());
				a.setID(Integer.parseInt(tIDnumber.getText()));
				a.setAdoptionFee(Double.parseDouble(tAdoptionFee.getText()));
				a.setGender(tGender.getText());
				a.setBreed(tBreed.getText());
				a.setWeight(Double.parseDouble(tWeight.getText()));
				
				int date = a.convertDatetoInt(tArrivalDate.getText());
				
				if(date != 0) {
				a.setArrival(date);
				JOptionPane.showMessageDialog(null, "Animal Information update successfully", "Edit Info Complete", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String error = "The date format you put in is incorrect. The date format should be like November 28 2018, with no commas.";
					JOptionPane.showMessageDialog(null, error, "Invalid Shelter", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			
			
		});
		
		info = new JPanel(new FlowLayout());
//		info.add(species);
//		info.add(breed);
		info.add(transfer);
		info.add(editInfo);
		if(a.getTransaction() != null) {
			JButton transaction = new JButton("Complete Transaction");
			transaction.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					a.getTransaction().PerformTransaction();
					
				}
				
			});
			info.add(transaction);
		}
		
		setLayout(new BorderLayout());
		add(name, BorderLayout.NORTH);
		add(info, BorderLayout.SOUTH);
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JPanel panel = new JPanel();
		panel.setSize(40,40);
		panel.setLayout(new GridLayout(4,2));
		panel.add(pName);
		//panel.add(pOwnerName);
		panel.add(pSpecies);
		//panel.add(pIDnumber);
		panel.add(pAdoptionFee);
		panel.add(pGender);
		panel.add(pBreed);
		panel.add(pWeight);
		panel.add(pSize);
		panel.add(pArrivalDate);
		add(panel);
		setPreferredSize(new Dimension(375,250));
	}
}
