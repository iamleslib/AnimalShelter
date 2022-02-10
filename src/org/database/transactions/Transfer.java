package org.database.transactions;

import java.io.Serializable;

import org.database.actors.Animal;
import org.database.actors.Shelter;

public class Transfer extends Transaction implements Serializable {
	
	public Transfer(Animal a1, Shelter s1, Shelter s2) {
		this.setShelterReceiving(s2);
		this.setShelterGiving(s1);
		this.setAnimal(a1);
	}

	public void PerformTransaction() {
		if(this.isValid()) {
			this.getShelterReceiving().addCurrentAnimal(this.getAnimal());
			this.getShelterGiving().removeAnimal(this.getAnimal());
		}
		
	}

	public boolean isValid() {
		if(!this.getShelterGiving().getCurrentAnimals().contains(this.getAnimal())) {
			System.out.println("The animal selected is not at the chosen shelter");
			return false;
		}
		else if(false/*this.getShelterReceiving().getCapacity() <= this.getShelterReceiving().getAnimals().size()*/) {
			System.out.println("The shelter selected is already at max capacity");
			return false;
		}
		return true;
	}

}


