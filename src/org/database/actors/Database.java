package org.database.actors;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Database implements Serializable {
		
	private ArrayList<Shelter> shelters;
	private ArrayList<String> states;
	private ArrayList<Shelter> stateShelters;
		
	public Database() {
		shelters = new ArrayList<Shelter>();
		states = new ArrayList<String>();
		stateShelters = new ArrayList<Shelter>();
		
		states.add("Alabama");
		states.add("Alaska");
		states.add("Arizona");
		states.add("Arkansas");
		states.add("California");
		states.add("Colorado");
		states.add("Connecticut");
		states.add("Delaware");
		states.add("Florida");
		states.add("Georgia");
		states.add("Hawaii");
		states.add("Idaho");
		states.add("Illinois");
		states.add("Indiana");
		states.add("Iowa");
		states.add("Kansas");
		states.add("Kentucky");
		states.add("Louisiana");
		states.add("Maine");
		states.add("Maryland");
		states.add("Massachusetts");
		states.add("Michigan");
		states.add("Minnesota");
		states.add("Mississippi");
		states.add("Missouri");
		states.add("Montana");
		states.add("Nebraska");
		states.add("Nevada");
		states.add("New Hampshire");
		states.add("New Jersey");
		states.add("New Mexico");
		states.add("New York");
		states.add("North Carolina");
		states.add("North Dakota");
		states.add("Ohio");
		states.add("Oklahoma");
		states.add("Oregon");
		states.add("Pennsylvania");
		states.add("Rhode Island");
		states.add("South Carolina");
		states.add("South Dakota");
		states.add("Tennessee");
		states.add("Texas");
		states.add("Utah");
		states.add("Vermont");
		states.add("Virginia");
		states.add("Washington");
		states.add("West Virginia");
		states.add("Wisconsin");
		states.add("Wyoming");
		
		}
		
	public ArrayList<Shelter> getAllShelters() {
		return shelters;
	}
		
	public boolean isWithinUS(String check) {
		String newcheck;

		int detect = 0;
		newcheck = check.toLowerCase();
		
		for(int i = 0; i < states.size(); ++i) {
			String compare;
			compare = states.get(i).toLowerCase();
			if(compare.equals(newcheck)) {
				detect = 1;
				break;
			}
		}
		
		if(detect == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void addShelter(Shelter s) {
		boolean result;
		String stateofshelter;
		
		stateofshelter = s.getState();
		
		result = this.isWithinUS(stateofshelter);
		
		if(result == true) {
			shelters.add(s);
			
		}
	}
	
	public void findstateShelters(String state) {
		stateShelters = new ArrayList<Shelter>();
		//boolean result;
		
		//result = this.isWithinUS(state);
		
		//if(result == true) {
			String lstate = state.toLowerCase();
			
			for(int i = 0; i < shelters.size(); ++i) {
				String lcompare = shelters.get(i).getState().toLowerCase();
				if(lstate.equals(lcompare)) {
					stateShelters.add(shelters.get(i));
				}
			}
			
		//}
		//if(stateShelters.size() == 0) {
			//System.out.println("There are no shelters registered in " + state + ".");
		//}
	}
	
	public ArrayList<Shelter> getstateShelters() {
		return stateShelters;
	}
	
	public void displayStateShelters() {
		System.out.println("These are all of the shelters in " + stateShelters.get(0).getName() + ":");
		for(int i = 0; i < stateShelters.size(); ++i) {
			System.out.print(stateShelters.get(i).getName());
		}
	}
	
	public void displayAnimalsinState() {
		System.out.println("These are all of the animals in the state of " + stateShelters.get(0).getName() + ":");
			for(int i = 0; i < stateShelters.size(); ++i) {
				for(int j = 0; j < stateShelters.get(i).getCurrentAnimals().size(); ++j) {
					String aname;
					String theshelter;
					aname = stateShelters.get(i).getCurrentAnimals().get(j).getName();
					theshelter = stateShelters.get(i).getName();
					System.out.print(aname + "          " + theshelter);
				}
			}
	}
	
	public void findaShelter(String sheltername) {
		int detect = 0;
		String lname = sheltername.toLowerCase();
		
		for(int i = 0; i < shelters.size(); ++i) {
			String lcompare = shelters.get(i).getName().toLowerCase();
			if(lname == lcompare) {
				detect = 1;
				break;
			}
		}
		if(detect != 1) {
			System.out.println("The shelter you inputted wasn't found in our database. Please make sure you spelled the name "
					+ "correctly or input your shelter's information into the database.");
		}
	}
	
	public Shelter findShelter(String name) {
		Shelter shelter = null;
		for(Shelter s : this.getAllShelters()) {
			if(name.equals(s.getName())) {
				shelter = s;
			}
		}
		return shelter;
	}
	
	public static void saveData(Database db) {
		try {
			FileOutputStream fileOut = new FileOutputStream("database.ser");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(db);
			objOut.close();
			fileOut.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static Database loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Database db = null;
		try {
			fileIn = new FileInputStream("database.ser");
			objIn = new ObjectInputStream(fileIn);
			db = (Database) objIn.readObject();
			objIn.close();
			fileIn.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		return db;
	}
	
	public ArrayList<Animal> getAllAnimals() {
		ArrayList<Animal> allAnimals = new ArrayList<Animal>();
			for(Shelter s : stateShelters) {
				for(Animal a : s.getCurrentAnimals()) {
					allAnimals.add(a);
				}
			}
			return allAnimals;
	}

	public void removeShelter(Shelter s) {
		shelters.remove(s);
	}

}
