package org.database.transactions;

import java.io.Serializable;
import java.util.Calendar;

import org.database.actors.Animal;
import org.database.actors.Customer;
import org.database.actors.Shelter;

public class Adopt extends Transaction implements Serializable {
	
	public Adopt(Animal a1, Customer customer, Shelter s1) {
		this.setCustomer(customer);
		this.setShelterGiving(s1);
		this.setAnimal(a1);
	}
	public void PerformTransaction() {
		if(this.isValid()) {
			this.getCustomer().addAnimal(this.getAnimal());
			this.getAnimal().setAdopted(true);
			this.getShelterGiving().removeAnimal(this.getAnimal());
		}
		
	}
	
	public boolean isValid() {
		if(!this.getShelterGiving().getCurrentAnimals().contains(this.getAnimal())) {
			System.out.println("The animal selected is not at the chosen shelter");
			return false;
		}
		return true;
	}



}

