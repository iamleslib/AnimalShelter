package org.database.interf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.database.actors.Shelter;

public class EditShelterInfoPanel extends JPanel{
	
	
	public EditShelterInfoPanel(Shelter s) {
		JPanel pName = new JPanel();
		JLabel lName = new JLabel("Name");
		JTextField tName = new JTextField(10);
		tName.setText(s.getName());
		pName.add(lName);
		pName.add(tName);
		
		JPanel pAddress = new JPanel();
		JLabel lAddress = new JLabel("Address");
		JTextField tAddress = new JTextField(10);
		tAddress.setText(s.getAddress());
		pAddress.add(lAddress);
		pAddress.add(tAddress);
		
		JPanel pCity = new JPanel();
		JLabel lCity = new JLabel("City");
		JTextField tCity = new JTextField(10);
		tCity.setText(s.getCity());
		pCity.add(lCity);
		pCity.add(tCity);

		JPanel pState = new JPanel();
		JLabel lState = new JLabel("State");
		JTextField tState = new JTextField(10);
		tState.setText(s.getState());
		pState.add(lState);
		pState.add(tState);
		
		JPanel pZipcode = new JPanel();
		JLabel lZipcode = new JLabel("Zipcode");
		JTextField tZipcode = new JTextField(10);
		tZipcode.setText(Integer.toString(s.getZipcode()));
		pZipcode.add(lZipcode);
		pZipcode.add(tZipcode);
		
		JPanel pEmail = new JPanel();
		JLabel lEmail = new JLabel("Email");
		JTextField tEmail = new JTextField(10);
		tEmail.setText(s.getEmail());
		pEmail.add(lEmail);
		pEmail.add(tEmail);

		JPanel pPhoneNumber = new JPanel();
		JLabel lPhoneNumber = new JLabel("PhoneNumber");
		JTextField tPhoneNumber = new JTextField(10);
		tPhoneNumber.setText(Double.toString(s.getPhoneNumber()));
		pPhoneNumber.add(lPhoneNumber);
		pPhoneNumber.add(tPhoneNumber);
		
//		JPanel pOpenHour = new JPanel();
//		JLabel lOpenHour = new JLabel("Open Hours");
//		JTextField tOpenHour = new JTextField();
//		tOpenHour.setText(s.printShelterInfo());
//		pOpenHour.add(lOpenHour);
//		pOpenHour.add(tOpenHour);
//		
		JButton save = new JButton("Save");	
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				s.setName(tName.getText());
				s.setCity(tCity.getText());
				s.setState(tState.getText());
				s.setZipcode(Integer.parseInt(tZipcode.getText()));
				s.setEmail(tEmail.getText());
				s.setPhoneNumber(Double.parseDouble(tPhoneNumber.getText()));
    			JOptionPane.showMessageDialog(null, "The shelter info has been successfully updated", "Shelter Updated", JOptionPane.INFORMATION_MESSAGE);

			}
			
		});
		
		
		add(pName);
		add(pCity);
		add(pState);
		add(pZipcode);
		add(pEmail);
		add(pPhoneNumber);
//		add(pOpenHour);
		add(save);
	}
}
