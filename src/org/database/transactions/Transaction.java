package org.database.transactions;

import java.io.Serializable;

import org.database.actors.Animal;
import org.database.actors.Customer;
import org.database.actors.Shelter;

public abstract class Transaction implements Serializable {
		
		private Animal animal;
		private Integer animalId;
		private Customer customer;
		private Shelter shelterReceiving;
		private Shelter shelterGiving;

		public Transaction(){
			
		}

		public Animal getAnimal() {
			return animal;
		}

		public Integer getAnimalId() {
			return animalId;
		}

		public void setAnimalId(Integer animalId) {
			this.animalId = animalId;
		}

		public void setAnimal(Animal animal) {
			this.animal = animal;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Shelter getShelterReceiving() {
			return shelterReceiving;
		}

		public void setShelterReceiving(Shelter shelterReceiving) {
			this.shelterReceiving = shelterReceiving;
		}

		public Shelter getShelterGiving() {
			return shelterGiving;
		}

		public void setShelterGiving(Shelter shelterGiving) {
			this.shelterGiving = shelterGiving;
		}

		public abstract void PerformTransaction();

		public abstract boolean isValid();
		
	}
