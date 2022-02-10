package org.database.interf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.transactions.Transfer;


public class AddNewAnimalPanel extends JPanel {
	private JLabel name;
	private JLabel species;
	private JLabel breed;
	private JLabel adoptionFee;
	private JLabel gender;
	private JLabel weight;
	private JLabel arrivalDate;
	
	public AddNewAnimalPanel(Animal a, Shelter s, Database d) {
		
		//name = new JLabel();
		
		JPanel pName = new JPanel();
		JLabel lName = new JLabel("Name");
		JTextField tName = new JTextField(10);
		tName.setText(a.getName());
		pName.add(lName);
		pName.add(tName);
		
		JPanel pSpecies = new JPanel();
		JLabel lSpecies = new JLabel("Species");
		JTextField tSpecies = new JTextField(10);
		tSpecies.setText(a.getSpecies());
		pSpecies.add(lSpecies);
		pSpecies.add(tSpecies);
		
		JPanel pBreed = new JPanel();
		JLabel lBreed = new JLabel("Breed");
		JTextField tBreed = new JTextField(10);
		tBreed.setText(a.getBreed());
		pBreed.add(lBreed);
		pBreed.add(tBreed);
		
		JPanel pAdoptionFee = new JPanel();
		JLabel lAdoptionFee = new JLabel("Adoption Fee");
		JTextField tAdoptionFee = new JTextField(10);
		tAdoptionFee.setText(Double.toString(a.getAdoptionFee()));
		pAdoptionFee.add(lAdoptionFee);
		pAdoptionFee.add(tAdoptionFee);
		
		JPanel pGender = new JPanel();
		JLabel lGender = new JLabel("Gender");
		JTextField tGender = new JTextField(10);
		tGender.setText(a.getGender());
		pGender.add(lGender);
		pGender.add(tGender);
		
		JPanel pWeight = new JPanel();
		JLabel lWeight = new JLabel("Weight");
		JTextField tWeight = new JTextField(5);
		tWeight.setText(Double.toString(a.getWeight()));
		pWeight.add(lWeight);
		pWeight.add(tWeight);
		
		JPanel pArrivalDate = new JPanel();
		JLabel lArrivalDate = new JLabel("Arrival Date");
		JTextField tArrivalDate = new JTextField(10);
		tArrivalDate.setText(Integer.toString(a.getID()));
		pArrivalDate.add(lArrivalDate);
		pArrivalDate.add(tArrivalDate);
		
		
		JButton save = new JButton("Save");	
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				a.setName(tName.getText());
				//a.setOwnerName(tOwnerName.getText());
				a.setSpecies(tSpecies.getText());
//				a.setID(Integer.parseInt(tIDnumber.getText()));
				a.setAdoptionFee(Double.parseDouble(tAdoptionFee.getText()));
				a.setGender(tGender.getText());
				a.setBreed(tBreed.getText());
				a.setWeight(Double.parseDouble(tWeight.getText()));
				a.setArrival(Integer.parseInt(tArrivalDate.getText()));
				
				JOptionPane.showMessageDialog(null, "Animal Information update successfully", "Edit Info Complete", JOptionPane.INFORMATION_MESSAGE);
				s.addCurrentAnimal(a);
			}
			
			
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
       
		panel.add(pName);
		//panel.add(pOwnerName);
		panel.add(pSpecies);
		//panel.add(pIDnumber);
		panel.add(pAdoptionFee);
		panel.add(pGender);
		panel.add(pBreed);
		panel.add(pWeight);
		//panel.add(tSize);
		panel.add(pArrivalDate);
		panel.add(save);
		add(panel);
	}
	
	
	
}
