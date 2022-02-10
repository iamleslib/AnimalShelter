package org.database.actors;

import java.io.Serializable;
import java.util.ArrayList;


public class Customer implements Serializable {
	
	private String name;
	private boolean verified;
	private String state;
	private ArrayList<Animal> ownsAnimals;
	private ArrayList<Animal> strays;
	
	public Customer() {
		name = new String();
		setState(new String());
		verified = false;
		setOwnsAnimals(new ArrayList<Animal>());
		setStrays(new ArrayList<Animal>());
		
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String location) {
		this.state = location;
	}

	public boolean isVerified() {
		return verified;
	
	}
	
	public void setVerified(boolean v) {
		verified = v;
	}

	
	public ArrayList<Animal> getOwnsAnimals() {
		return ownsAnimals;
	}

	public void setOwnsAnimals(ArrayList<Animal> ownsAnimals) {
		this.ownsAnimals = ownsAnimals;
	}

	public ArrayList<Animal> getStrays() {
		return strays;
	}

	public void setStrays(ArrayList<Animal> strays) {
		this.strays = strays;
	}

	public void addStray(Animal a1) {
		strays.add(a1);
	}
	
	public void addAnimal(Animal a1) {
		ownsAnimals.add(a1);
	}
	
//	public void giveStray(Shelter s1) {
//		Transaction t1 = new Stray(this, s1);
//		
//		t1.PerformTransaction();
//	}
//	
//	public void surrenderPet(Shelter s1) {
//		Transaction t1 = new Surrender(this, s1);
//		
//		t1.PerformTransaction();
//	}
//	
//	public void enterInfo() {
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("What is your name?");
//		name = keyboard.nextLine();
//		System.out.println("What is your location?");
//		location = keyboard.nextLine();
//		keyboard.close();
//	}
	public String toString() {
		String s = name + ": " + state + ", Animals: ";
		for(Animal a1 : this.ownsAnimals) {
			s = s + a1 + "|";
		}
		s = s + " Strays:";
		for(Animal a1 : this.strays) {
			s = s + a1 + "|";
		}
		return s;
	}

	//public void searchForShelters(Database db) {
		/// TODO Auto-generated method stub
		//if(!db.printStateShelters(this.state)) {
			//System.out.println("There are no shelters near this customer.");
		//};
	//}

}

