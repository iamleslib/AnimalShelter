package org.database.actors;

import org.database.contact.Appointment;
import org.database.transactions.Transaction;

import java.io.Serializable;
import java.util.ArrayList;

public class Animal implements Serializable {
	private String name;
	private String owner; //when adopted, the animal's owner name is set
	private String species; //dog, cat, or critter (critter can be ferret, hamster, guinea pig, bunny, etc.)
	private int IDnumber;
	private String description;
	private double adoptionFee;
	private String gender;
	private String breed;
	private Shelter location;
	private double weight; //in pounds
	private String size;
	private boolean foster;
	private boolean surrendered;
	private boolean stray;
	private boolean adopted;
	private boolean neutered; 
	private ArrayList<Appointment> prospectiveadoption;
	private int arrivalDate; //format: 01192018 represents January 19th, 2018
	private int birthDate; //if a dog has a certain birthday, it will be used when displaying their age
	//if the dog is a stray, their birthDate will be considered to be their arrival date dependent on their suspected age
	private boolean nodog; //true if animal can't live with any dogs
	private boolean nocat; //true if animal can't live with any cats
	private boolean nocritter; //true if animal can't live with any other critters
	private Transaction pending;
	
	public Animal() {
		prospectiveadoption = new ArrayList<Appointment>();

	}
	
	public void setTransaction(Transaction t) {
		pending = t;
	}
	
	public Transaction getTransaction() {
		return pending;
	}
	
	public void addAppointment(Appointment ap) {
		prospectiveadoption.add(ap);
		location.addAppointment(ap);
		ap.setAnimal(this);
	}
	public ArrayList<Appointment> getAppoinments() {
		return prospectiveadoption;
	}
	public void resetAppointments() {
		prospectiveadoption = new ArrayList<Appointment>();
	}
	
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public void setOwnerName(String o) {
		owner = o;
	}
	public String getOwnerName() {
		return owner;
	}
	
	public void setSpecies(String s) {
		species = s;
	}
	public String getSpecies() {
		return species;
	}
	
	public void setID(int id) {
		if(id < 0) {
			System.out.println("ID numbers must be positive. Please enter a positive ID number.");
		}
		else {
		IDnumber = id;
		}
	}
	public int getID() {
		return IDnumber;
	}
	
	public void writeDescription(String d) {
		description = d;
	}
	public String displayDescription() {
		return description;
	}
	
	public void setAdoptionFee(double af) {
		if(af >= 0) {
		adoptionFee = af;
		}
		else {
			System.out.println("The adoption fee can't be a negative amount. Please enter a valid price.");
		}
	}
	public double getAdoptionFee() {
		return adoptionFee;
	}
	
	public void setGender(String  g) {
		if(g.equals("girl")) {
			gender = "Female";
		}
		else if (g.equals("boy")) {
			gender = "Male";
		}
		else if (g.equals("female")) {
			gender = "Female";
		}
		else if (g.equals("male")) {
			gender = "Male";
		}
		else if (g.equals("Female") || g.equals("Male")) {
			gender = g;
		}
		else if (g.equals("F")) {
			gender = "Female";
		}
		else if (g.equals("M")) {
			gender = "Male";
		}
		else if (g.equals("f")) {
			gender = "Female";
		}
		else if (g.equals("m")) {
			gender = "Male";
		}
		else {
			System.out.println("The gender you put in isn't a valid option. The possible entries are female, male, "
					+ "boy, girl, f, or m.");
		}
	}
	public String getGender() {
		return gender;
	}
	
	public void setBreed(String b) {
		breed = b;
	}
	public String getBreed() {
		return breed;
	}
	
	public void setShelter(Shelter s) {
		location = s;
	}
	public Shelter getShelter() {
		return location;
	}
	
	public void setWeight(double w) {
		weight = w;
	}
	public double getWeight() {
		return weight;
	}
	public String getSize() {
		if(weight < 25) {
			size = "Small";
		}
		if(weight >= 25 && weight <= 60) {
			size = "Medium";
		}
		if(weight > 60) {
			size = "Large";
		}
		return size;
	}
	
	public void setFoster(boolean f) {
		foster = f;
	}
	public boolean getFoster() {
		return foster;
	}
	
	public void setSurrendered(boolean s) {
		surrendered = s;
	}
	public boolean getSurrendered() {
		return surrendered;
	}
	
	public void setStray(boolean sy) {
		stray = sy;
	}
	public boolean getStray() {
		return stray;
	}
	
	public void setAdopted(boolean a) {
		adopted = a;
	}
	public boolean getAdopted() {
		return adopted;
	}
	
	
	public void setNeutered(boolean n) {
		neutered = n;
	}
	public boolean getNeutered() {
		return neutered;
	}
	
	public void setNoDog(boolean nd) {
		nodog = nd;
	}
	public boolean getNoDog() {
		return nodog;
	}
	
	public void setNoCat(boolean nc) {
		nocat = nc;
	}
	public boolean getNoCat() {
		return nocat;
	}
	
	public void setNoCritter(boolean nct) {
		nocritter = nct;
	}
	public boolean getNoCritter() {
		return nocritter;
	}
	
	public void setArrival(int date) {
		int dday = 0;
		int dmonth = 0;

		dmonth = date / 1000000;
		dday = date / 10000;
		dday = dday % 100;
		
		if(date <= 0) {
  			System.out.println("The date you entered is invalid. The date can't be negative or 0.");
  		}
  		else if(date <= 1000000) {
  			System.out.println("The date can't be less than 7 digits.");
  		}
  		else if(dmonth > 12 || dmonth == 0) {
  			System.out.println("The month you entered is invalid. The month ranges from 1 to 12.");
  		}
  		else if(dday > 31 || dday == 0) {
  			System.out.println("The day you entered is invalid. The month ranges from 1 to 31 depending upon the month.");
  		}
  		else if((dmonth == 4 || dmonth == 6 || dmonth == 9 || dmonth == 11) && (dday > 30)) {
  			System.out.println("The day you entered is invalid. The month ranges from 1 to 30 for the inputted month.");
  		}
  		else if(dmonth == 2 && (dday > 28)) {
  			System.out.println("The day you entered is invalid. The month ranges from 1 to 28 for the inputted month. "
  					+ "This system ignores leap years.");
  		}
		else {
		arrivalDate = date;
		}
	}
	public String getArrival() {
		int day = 0;
		int month = 0;
		int year = 0;
		year = arrivalDate % 10000;
		month = arrivalDate / 1000000;
		day = arrivalDate / 10000;
		day = day % 100;
		String output = null;
		
		if(month == 1) {
			output = "January " + day + " " + year;
		}
		else if (month == 2) {
			output = "February " + day + " " + year;
		}
		else if (month == 3) {
			output = "March " + day + " " + year;
		}
		else if (month == 4) {
			output = "April " + day + " " + year;
		}
		else if (month == 5) {
			output = "May " + day + " " + year;
		}
		else if (month == 6) {
			output = "June " + day + " " + year;
		}
		else if (month == 7) {
			output = "July " + day + " " + year;
		}
		else if (month == 8) {
			output = "August " + day + " " + year;
		}
		else if (month == 9) {
			output = "September " + day + " " + year;
		}
		else if (month == 10) {
			output = "October " + day + " " + year;
		}
		else if (month == 11) {
			output = "November " + day + " " + year;
		}
		else {
			output = "December " + day + " " + year;
		}
	return output;
	}
	
	public int convertDatetoInt(String s) {
		int date = 0;
		int m = 0;
		int day = 0;
		int year = 0;
		
		String[] split = s.split("\\s+");
		
		String month = split[0];
		
		if(month.equals("January")) {
			m = 1;
		}
		else if (month.equals("February")) {
			m = 2;
		}
		else if (month.equals("March")) {
			m = 3;
		}
		else if (month.equals("April")) {
			m = 4;
		}
		else if (month.equals("May")) {
			m = 5;
		}
		else if (month.equals("June")) {
			m = 6;
		}
		else if (month.equals("July")) {
			m = 7;
		}
		else if (month.equals("August")) {
			m = 8;
		}
		else if (month.equals("September")) {
			m = 9;
		}
		else if (month.equals("October")) {
			m = 10;
		}
		else if (month.equals("November")) {
			m = 11;
		}
		else if (month.equals("December")) {
			m = 12;
		}
		else {
			return date;
		}
		
		day = Integer.parseInt(split[1]);
		
		if(day > 31 || day == 0) {
  			return date;
  		}
  		else if((m == 4 || m == 6 || m == 9 || m == 11) && (day > 30)) {
  			return date;
  		}
  		else if(m == 2 && (date > 28)) {
  			return date;
  		}
  		
		year = Integer.parseInt(split[2]);
		
		date = m * 1000000 + day * 10000 + year;
		
		return date;
		
	}
	
	public int getArrivalDate() {
		return arrivalDate;
	}
	
	public void setbirthDate(int b, int suspectedage, String ageunits) { 
		boolean sy;
		sy = this.getStray();

		if(sy == true) {
			if(!(ageunits.equals("days")) && !(ageunits.equals("day")) && !(ageunits.equals("months")) 
					&& !(ageunits.equals("month")) && !(ageunits.equals("years")) && !(ageunits.equals("year"))) {
				System.out.println("The unit of time you put is invalid. The valid units of time for the age of an animal "
						+ "is either day(s), month(s), or year(s).");
			}
			else if(suspectedage < 0) {
				System.out.println("The suspected age of an animal can't be negative. Please input a valid suspected age.");
			}
			else {
				int arrival;
				arrival = arrivalDate;
				int day = 0;
				int month = 0;
				int year = 0;
				year = arrival % 10000;
				month = arrival / 1000000;
				day = arrival / 10000;
				day = day % 100;
				
					if(ageunits.equals("day") || ageunits.equals("days")) {
						int newday = 0;
						int oldday = 0;
						int check;
						check = suspectedage/30;
						if(check != 0) { //if input is more than 30 days, automatically convert to months
							ageunits = "month";
							suspectedage = check;
						}
						else {
							oldday = arrival / 10000;
							oldday = oldday % 100;
							newday = oldday - suspectedage;
							if(newday < 0) {
								if(month == 1) {
									month = 12;
									year = year - 1;
									newday = newday + 31;
								}
								if(month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11) {
									month = month - 1;
									newday = newday + 31;
								}
								else if(month == 3) {
									month = month - 1;
									newday = newday + 28;
								}
								else {
									month = month - 1;
									newday = newday + 30;
								}
							}
							birthDate = month * 1000000 + newday * 10000 + year;
						}
					}
					
					if(ageunits.equals("month") || ageunits.equals("months")) {
						int oldmonth = 0;
						int newmonth = 0;
						int check2;
						check2 = suspectedage / 12;
						if(check2 != 0) { //if input is more than 12 months, automatically converts to years
							ageunits = "year";
							suspectedage = check2;
						}
						else {
							oldmonth = arrival / 1000000;
							newmonth = oldmonth - suspectedage;
							if(newmonth <= 0) {
								newmonth = newmonth + 12;
								year = year - 1;
							}
							birthDate = newmonth * 1000000 + day * 10000 + year;
						}
					}
					
					if(ageunits.equals("year") || ageunits.equals("years")) {
						int oldyear = 0;
						int newyear = 0;
						oldyear = arrival % 10000;
						newyear = oldyear - suspectedage;
						birthDate = month * 1000000 + day * 10000 + newyear;
					}
			}
		}
		
		else {
			int dday = 0;
			int dmonth = 0;

			dmonth = b / 1000000;
			dday = b / 10000;
			dday = b % 100;
			
			if(dmonth > 12 || dmonth == 0) {
				System.out.println("The month you entered is invalid. The month ranges from 1 to 12.");
			}
			else if(dday > 31 || dday == 0) {
				System.out.println("The day you entered is invalid. The month ranges from 1 to 31 depending upon the month.");
			}
			else if(b <= 0) {
				System.out.println("The date you entered is invalid. The date can't be negative or 0.");
			}
			else if((dmonth == 4 || dmonth == 6 || dmonth == 9 || dmonth == 11) && (dday > 30)) {
				System.out.println("The day you entered is invalid. The month ranges from 1 to 30 for the inputted month.");
			}
			else if(dmonth == 2 && (dday > 28)) {
				System.out.println("The day you entered is invalid. The month ranges from 1 to 28 for the inputted month. "
						+ "This system ignores leap years.");
			}
			else {
			birthDate = b;
			}
		}
		
	}

	public String getbirthDate() {
		int day = 0;
		int month = 0;
		int year = 0;
		year = birthDate % 10000;
		month = birthDate / 1000000;
		day = birthDate / 10000;
		day = day % 100;
		String output = null;
		
		if(month == 1) {
			output = "January " + day + ", " + year;
		}
		else if (month == 2) {
			output = "February " + day + ", " + year;
		}
		else if (month == 3) {
			output = "March " + day + ", " + year;
		}
		else if (month == 4) {
			output = "April " + day + ", " + year;
		}
		else if (month == 5) {
			output = "May " + day + ", " + year;
		}
		else if (month == 6) {
			output = "June " + day + ", " + year;
		}
		else if (month == 7) {
			output = "July " + day + ", " + year;
		}
		else if (month == 8) {
			output = "August " + day + ", " + year;
		}
		else if (month == 9) {
			output = "September " + day + ", " + year;
		}
		else if (month == 10) {
			output = "October " + day + ", " + year;
		}
		else if (month == 11) {
			output = "November " + day + ", " + year;
		}
		else {
			output = "December " + day + ", " + year;
		}
	return output;	
	}
	
	public String getAge(int currdate) {
		int bday = 0;
		int bmonth = 0;
		int byear = 0;
		String result = null;
		//int databasemade = 11052018; //database made Nov 5th, 2018
		
		byear = birthDate % 10000;
		bmonth = birthDate / 1000000;
		bday = birthDate / 10000;
		bday = bday % 100;
		
		int cday = 0;
		int cmonth = 0;
		int cyear = 0;
		cyear = currdate % 10000;
		cmonth = currdate / 1000000;
		cday = currdate / 10000;
		cday = cday % 100;
		
		if(currdate <= 0) {
			System.out.println("The current date can't be negative or 0. Please enter a valid date.");
		}
		//else if((databasemade - currdate) > 0) {
			//System.out.println("This database was made on November 5th, 2018. The current date can't be any earlier than that.");
		//}
		else {
		int ageyear = 0;
		int agemonth = 0;
		int ageday = 0;
		
		ageyear = cyear - byear;
		agemonth = cmonth - bmonth;
		ageday = cday - bday;
		
		
		if(agemonth == 0 && ageyear == 0) { //within the same month
			if(ageday == 1) {
				result = "1 day old.";
			}
			else {
				result = ageday + " days old.";
			}
		}
		
		if(agemonth == 1 && ageyear == 0 && ageday < 0) { //less than a month, different months
			if(bmonth == 1 || bmonth == 3 || bmonth == 5 || bmonth == 7 || bmonth == 8 || bmonth == 10|| bmonth == 12) {
				ageday = ageday + 31;
			}
			else if(bmonth == 2) {
				ageday = ageday + 28;
			}
			else {
				ageday = ageday + 30;
			}
			
			if(ageday == 1) {
				result = "1 day old.";
			}
			else {
				result = ageday + " days old.";
			}
		}
		
		if(agemonth == -11 && ageyear == 1 && ageday < 0) { //less than a month, end of the year
				ageday = ageday + 31;
			
			if(ageday == 1) {
				result = "1 day old.";
			}
			else {
				result = ageday + " days old.";
			}
		}
		
		if(agemonth >= 1 && ageyear == 0 && ageday >= 0) { //within the same year
			if(agemonth == 1) {
				result = "1 month old.";
			}
			else {
				result = agemonth + " months old."; 
			}
		}
		
		if(agemonth > 1 && ageyear == 0 && ageday < 0) { //within the same year, less than a month
			agemonth = agemonth - 1;
			if(agemonth == 1) {
				result = "1 month old.";
			}
			else {
				result = agemonth + " months old."; 
			}
		}
		
		if(agemonth < 0 && ageyear == 1 && ageday >= 0) { //within 1 year
			agemonth = agemonth + 12;
			if(agemonth == 1) {
				result = "1 month old.";
			}
			else {
				result = agemonth + " months old."; 
			}
		}
		
		if(agemonth <= 0 && agemonth != -11 && ageyear == 1 && ageday < 0) { //within 1 year, less than month, != 11 ensures won't write over end of the year days case
			agemonth = agemonth + 11;
			if(agemonth == 1) {
				result = "1 month old.";
			}
			else {
				result = agemonth + " months old."; 
			}
		}
		
		
		if(agemonth == 0 && ageday == 0 && ageyear >= 1) { //if exact same day and month, only years apart
			if(ageyear == 1) {
				result = "1 year old.";
			}
			else {
				result = ageyear + " years old."; 
			}
		}
		
		if(agemonth > 0 && ageyear >= 1) { //if more than 1 month, the year stays the same
			if(ageyear == 1) {
				result = "1 year old.";
			}
			else {
				result = ageyear + " years old."; 
			}
		}
		
		if(agemonth == 0 && ageday < 0 && ageyear > 1) {
			ageyear = ageyear - 1;
			if(ageyear == 1) {
				result = "1 year old.";
			}
			else {
				result = ageyear + " years old."; 
			}
		}
		
		if(agemonth < 0 && ageyear > 1) { //if less than a month, then it's less than a year Jan 2018 vs Dec 2016 is 1 year
			ageyear = ageyear - 1;
			if(ageyear == 1) {
				result = "1 year old.";
			}
			else {
				result = ageyear + " years old."; 
			}
		}
		}
		
		return result;
	}
}
 

