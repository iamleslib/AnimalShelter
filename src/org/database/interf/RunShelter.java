package org.database.interf;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;

public class RunShelter {
	public static void main(String[] args){
		Shelter s1 = new Shelter();
		Shelter s2 = new Shelter();
		Shelter s3 = new Shelter();
		
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		Animal a3 = new Animal();
		Animal a4 = new Animal();
		Animal a5 = new Animal();
		Animal a6 = new Animal();
		Animal a7 = new Animal();
		Animal a8 = new Animal();
		
		a1.setArrival(3142018);
		a1.setGender("Female");
		a1.setSpecies("Dog");
		a1.setBreed("Labrador Retrivier");
		a1.setName("Sierra");
		
		a2.setArrival(12282010);
		a2.setGender("Male");
		a2.setSpecies("Dog");
		a2.setBreed("Rottweiler");
		a2.setName("Brody");
		
		a3.setArrival(5092014);
		a3.setGender("Male");
		a3.setSpecies("Cat");
		a3.setBreed("British Shorthair");
		a3.setName("Checkers");
		a3.setWeight(7.21);
		a3.setNoDog(false);
		a3.setNoCat(false);
		a3.setNoCritter(false);
		a3.writeDescription("I am the coolest dude around and I weigh 7.21 lbs! My favorite place to wind down is at the top of my cat condo!");
		a3.setAdoptionFee(100.00);
		
		a4.setArrival(3072012);
		a4.setGender("Female");
		a4.setSpecies("Dog");
		a4.setBreed("Boxer");
		a4.setName("Sierra");
		a4.setWeight(57.5);
		a4.setNoDog(true);
		a4.setNoCat(true);
		a4.setNoCritter(false);
		a4.writeDescription("I'm Sierra! I'm a gorgeous girl weighing 57.5 lbs! "
				+ "I may be shy at first, but when I get to know you I'm a very sweet and loving girl!"
				+ "I must meet all children living in the home, and they must be 13+ years old. ");
		a4.setAdoptionFee(175.00);
		
		a5.setArrival(3142018);
		a5.setGender("Female");
		a5.setSpecies("Dog");
		a5.setBreed("Labrador Retrivier");
		a5.setName("Sierra");
		
		a6.setArrival(12282010);
		a6.setGender("Male");
		a6.setSpecies("Dog");
		a6.setBreed("Rottweiler");
		a6.setName("Brody");
		
		a7.setArrival(5092014);
		a7.setGender("Male");
		a7.setSpecies("Cat");
		a7.setBreed("British Shorthair");
		a7.setName("Checkers");
		a7.setWeight(7.21);
		a7.setNoDog(false);
		a7.setNoCat(false);
		a7.setNoCritter(false);
		a7.writeDescription("I am the coolest dude around and I weigh 7.21 lbs! My favorite place to wind down is at the top of my cat condo!");
		a7.setAdoptionFee(100.00);
		
		a8.setArrival(3072012);
		a8.setGender("Female");
		a8.setSpecies("Dog");
		a8.setBreed("Boxer");
		a8.setName("Sierra");
		a8.setWeight(57.5);
		a8.setNoDog(true);
		a8.setNoCat(true);
		a8.setNoCritter(false);
		a8.writeDescription("I'm Sierra! I'm a gorgeous girl weighing 57.5 lbs! "
				+ "I may be shy at first, but when I get to know you I'm a very sweet and loving girl!"
				+ "I must meet all children living in the home, and they must be 13+ years old. ");
		a8.setAdoptionFee(175.00);
		
		s1.addCurrentAnimal(a1);
		s1.addCurrentAnimal(a2);
		s1.addCurrentAnimal(a3);
		s1.addCurrentAnimal(a4);
		s1.addCurrentAnimal(a5);
		s1.addCurrentAnimal(a6);
		s1.addCurrentAnimal(a7);
		s1.addCurrentAnimal(a8);
		
		s1.setState("Arizona");
		s2.setState("Arizona");
		s3.setState("Arizona");
		
		s1.setName("Shelter 111");
		s2.setName("Shelter 2");
		s3.setName("Shelter 3");
		
		s1.setCity("Phoenix");
		s1.setEmail("arizonashelter1@gmail.com");
		s1.setPhoneNumber(18008675309.0);
		s1.setZipcode(85239);
		s1.setstreetAddress("124 W Van Buren St.");
		s1.setAddress();
		s1.setOpenHour(10630);
		s1.setCloseHour(11730);
		s1.setOpenHour(30800);
		s1.setCloseHour(31800);
		s1.setOpenHour(61230);
		s1.setCloseHour(61530);
		
		Database testshelter = new Database();
		
		testshelter.addShelter(s1);
		testshelter.addShelter(s2);
		testshelter.addShelter(s3);

		new ShelterGUI(testshelter);
	}
}
