package org.database.transactions;

import java.io.Serializable;

import org.database.actors.Animal;
import org.database.actors.Customer;
import org.database.actors.Shelter;

public class Stray extends Transaction implements Serializable {

	
	public Stray(Animal a, Customer customer, Shelter s1) {
		this.setCustomer(customer);
		this.setShelterReceiving(s1);
		this.setAnimal(a);
	}

	public void PerformTransaction() {
		if(this.isValid()) {
			this.getAnimal().setStray(true);
			this.getShelterReceiving().addCurrentAnimal(this.getAnimal());
			this.getShelterReceiving().removeStray(this.getAnimal());
		}
	}

	public boolean isValid() {
//		if(!this.getCustomer().getStrays().contains(this.getAnimal())) {
//			System.out.println("The animal selected is not entered as one of the customer's strays");
//			return false;
//		}
		return true;
	}


}

