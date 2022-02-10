package org.database.interf;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;

public class EditAnimalsPanel extends JPanel{
	public EditAnimalsPanel(ArrayList<Animal> displayAnimals, Shelter s, Database d) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		for(Animal a : displayAnimals) {
			panel.add(new EditAnimalInfo(a, s, d));
		}

	//	panel.setPreferredSize(new Dimension(650, 800));
		panel.setAutoscrolls(true);
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(700,400));
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMinimum());

		add(scroll);
	}
}
