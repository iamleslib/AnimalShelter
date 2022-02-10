package org.database.interf;

import javax.swing.*;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.actors.Customer;
import org.database.contact.Appointment;
import org.database.contact.Email;
import org.database.interf.ShelterGUI;

public class RunDatabase2 {
	
	public static void main(String[] args)
    {
		
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
		
		Email e1 = new Email();
		Email e2 = new Email();
		
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		
		c1.setName("Jordan Barakat");
		c1.setVerified(true);
		c2.setName("Helga Troganoff");
		c2.setVerified(false);
		
		Appointment ap = new Appointment();
		ap.setAppointmentType("cat to dog");
		ap.setDate(11282018);
		ap.setDayofWeek(1);
		ap.setDuration(30);
		ap.setStartTime(1230);
		
		a1.setArrival(3142018);
		a1.setGender("Female");
		a1.setSpecies("Dog");
		a1.setWeight(73.4);
		a1.setBreed("Labrador Retriever");
		a1.setName("Sierra");
		
		a2.setStray(true);
		a2.setNoCat(false);
		a2.setArrival(11282018);
		a2.setbirthDate(1, 6,"years");
		a2.setAdoptionFee(200.00);
		a2.setGender("Male");
		a2.setSpecies("Dog");
		a2.setBreed("Rottweiler");
		a2.setName("Brody");
		a2.setID(859);
		a2.setWeight(95.5);
		a2.writeDescription("I'm a large boy weighing in at 95.5 pounds.\n I love to play and run around "
				+ "so I will need to go to a large home where I can use up all my energy.\n I don't do "
				+ "well with cats and need to live in a home without them.\n I'd love to meet you!");
		
		a3.setArrival(5092014);
		a3.setGender("Male");
		a3.setSpecies("Cat");
		a3.setBreed("British Shorthair");
		a3.setName("Checkers");
		a3.setWeight(7.21);
		a3.setNoDog(false);
		a3.setNoCat(false);
		a3.setNoCritter(false);
		a3.writeDescription("I am the coolest dude around and I weigh 7.21 lbs!\n"
				+ "My favorite place to wind down is at the top of my cat condo!");
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
		a4.writeDescription("I'm Sierra! I'm a gorgeous girl weighing 57.5 lbs!\n "
				+ "I may be shy at first, but when I get to know you I'm a very sweet and loving girl!\n"
				+ "I'm looking for a house with no other cats or dogs.\n "
				+ "I must meet all children living in the home, and they must be 13+ years old. ");
		a4.setAdoptionFee(175.00);
		
		a5.setArrival(11282016);
		a5.setGender("Female");
		a5.setSpecies("Cat");
		a5.setBreed("Bombay");
		a5.setName("Princess");
		a5.setWeight(5.64);
		
		a6.setArrival(11292018);
		a6.setGender("Female");
		a6.setID(4);
		a6.setFoster(true);
		a6.setSpecies("Critter");
		a6.setNoCat(true);
		a6.setNoDog(false);
		a6.setNoCritter(false);
		a6.setBreed("Hamster");
		a6.setName("Cupcake");
		a6.setWeight(0.375);
		a6.setAdoptionFee(20.00);
		a6.writeDescription("I'm a little guy at 6 ounces. I like to laze around my cage. I've had problems with "
				+ "cats in the past so my foster home can't have them. I caught a case of ringworm so I need to "
				+ "be given the proper medication and monitored.");
		
		a7.setArrival(10202018);
		a7.setGender("Female");
		a7.setNoCat(false);
		a7.setFoster(true);
		a7.setNoCritter(false);
		a7.setNoCritter(false);
		a7.setSpecies("Dog");
		a7.setBreed("Pug");
		a7.setName("Monica");
		a7.setWeight(21.3);
		a7.setAdoptionFee(120.00);
		a7.writeDescription("I'm a small girl weighing in at 21.3 pounds. I love to cuddle and am a regular couch potato."
				+ " I was hit by a car and need a foster home that so that my pelvic fracture can heal.");
		
		a8.setArrival(11172018);
		a8.setGender("Male");
		a8.setSpecies("Dog");
		a8.setFoster(true);
		a8.setBreed("Golden Retriever");
		a8.setName("Chuck");
		a8.setID(5);
		a8.setAdoptionFee(200.00);
		a8.setOwnerName("Helga Troganoff");
		
		s1.addCurrentAnimal(a1);
		s1.addCurrentAnimal(a2);
		s1.addCurrentAnimal(a3);
		s1.addCurrentAnimal(a4);
		
		s2.addCurrentAnimal(a5);
		
		a2.addAppointment(ap);
		
		s1.setState("Arizona");
		s2.setState("Arizona");
		s3.setState("Arizona");
		
		s1.setName("Shelter 1");
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
		
		s2.setEmail("shelter2rocks@hotmail.com");
		
		e1.setSubjectLine("Test");
		e1.setMessageBody("this is a test.");
		e1.setReceiverEmail("imsodone58@gmail.com");
		e1.setSenderEmail(s1.getEmail());
		s1.sendEmail(e1);
		
		e2.setSubjectLine("Recent Inquiry");
		e2.setMessageBody("You sent us an email asking if you could volunteer at our shelter. The answer is of course"
				+ " you can!\n" + "Please sign up for our animal information course to become a verified volunteer "
						+ "here at the shelter. The link is here:\n" + "http://www.shelter2.com/become-a-volunteer");
		e2.setReceiverEmail("imsodone58@gmail.com");
		e2.setSenderEmail(s2.getEmail());
		s2.sendEmail(e2);
		
		s3.addCurrentAnimal(a6);
		s3.addCurrentAnimal(a7);
		s3.addtoHistory(a8);
		s3.addVerifiedFoster(c1);
		s3.addVerifiedFoster(c2);
		s3.setOpenHour(30700);
		s3.setCloseHour(31730);
		
		Database testshelter = new Database();
		
		testshelter.addShelter(s1);
		testshelter.addShelter(s2);
		testshelter.addShelter(s3);
		
		new ShelterGUI(testshelter);

    }

}
