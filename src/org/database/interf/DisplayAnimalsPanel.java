package org.database.interf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;

public class DisplayAnimalsPanel extends JPanel {
	public DisplayAnimalsPanel(ArrayList<Animal> displayAnimals) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 2));
		
		for(Animal a : displayAnimals) {
			panel.add(new AnimalPreviewPanel(a));
		}
		panel.setAutoscrolls(true);
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(700,400));


		add(scroll);
	
	}
	
}
