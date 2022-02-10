package org.database.interf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;

public class DisplaySheltersPanel extends JPanel {
	public Database d;
	private JPanel panelCont;
	private JPanel options;
	private CardLayout c1;
	private JPanel welcome;
	private JPanel info;
	
	public DisplaySheltersPanel(Database db) {
		d = db;
		c1 = new CardLayout();
		panelCont = new JPanel();
		options = new JPanel();
		welcome = new JPanel();
		info = new JPanel(new FlowLayout());
		options.setLayout(new FlowLayout());
		options.setBorder(BorderFactory.createTitledBorder("Select Shelter"));
		
		panelCont.setLayout(c1);
		panelCont.add(welcome, "Welcome");
		
		for(Shelter s : d.getstateShelters()) {
			JButton btn = new JButton(s.getName());
			ShelterSearchPanel panel = new ShelterSearchPanel(s);
			//panel.add(new JLabel(s.getName()));
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					c1.show(panelCont, s.getName());
					info.removeAll();
					info.add(new JLabel(s.getAddress()));
					info.add(new JLabel(s.getEmail()));
				}
				
			});
			
			options.add(btn);
			panelCont.add(panel, s.getName());
		}
		
		setLayout(new BorderLayout());
		Dimension d = new Dimension(600,400);
		setPreferredSize(d);
		
		add(panelCont, BorderLayout.CENTER);
		add(options, BorderLayout.NORTH);
		add(info, BorderLayout.SOUTH);
		c1.show(panelCont, "Welcome");
		setVisible(true);
	}
		



	
}
	