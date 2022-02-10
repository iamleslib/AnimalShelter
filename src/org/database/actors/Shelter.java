package org.database.actors;

import java.io.Serializable;
import java.util.ArrayList;
import org.database.contact.Appointment;
import org.database.actors.Animal;
import org.database.contact.Email;
import org.database.contact.PhoneCall;
import org.database.actors.Customer;

public class Shelter implements Serializable {
	
	private String name;
	private String address;
	private String streetaddress;
	private String city;
	private String state;
	private Database data; //to get back to original database ????
	private int zipcode; //Integer?
	private ArrayList<Integer> openHour; //11230 represents Monday 12:30 PM
	private ArrayList<Integer> closeHour; //21830 represents Tuesday 6:30 PM
	private ArrayList<Animal> appointmentanimals; //animals on hold, awaiting appointments
	private ArrayList<Animal> currentanimals; //animals currently at the shelter and are to be adopted
	private ArrayList<Animal> historyanimals; //all the animals ever located at the shelter, even if they are now adopted
	private ArrayList<Animal> waitingList; //animals waiting to be put for up for adoption or foster/found strays
	private ArrayList<Animal> searchCriteria; //list of animals matching the search criteria
	private ArrayList<Animal> fosterList;

	private boolean clearSearch; //need to know when to clear list of animals from searchCriteria
	private String email;
	private ArrayList<Email> emailList;
	private ArrayList<Appointment> appointments;
	//private PhoneCall phone;
	private double phoneNumber;
	private ArrayList<Customer> verifiedfosters;

	public Shelter(){
		currentanimals = new ArrayList<Animal>();
		openHour = new ArrayList<Integer>();
		closeHour = new ArrayList<Integer>();
		historyanimals = new ArrayList<Animal>();
		waitingList = new ArrayList<Animal>();
		fosterList = new ArrayList<Animal>();
		emailList = new ArrayList<Email>();
		appointments = new ArrayList<Appointment>();
		verifiedfosters = new ArrayList<Customer>();
		searchCriteria = new ArrayList<Animal>();
		appointmentanimals = new ArrayList<Animal>();
	}

	public String getName(){
		return this.name;
	}
	public void setName(String n){
		this.name = n;
	} 
	
	public void setPhoneNumber(double pn) {
		phoneNumber = pn;
	}
	public double getPhoneNumber() {
		return phoneNumber;
	}
	
	public void addVerifiedFoster(Customer c) {
		verifiedfosters.add(c);
	}
	public ArrayList<Customer> getVerifiedFosters() {
		return verifiedfosters;
	}
	
	public void setstreetAddress(String sa) {
		streetaddress = sa;
	}
	public String getstreetAddress() {
		return streetaddress;
	}

	public void setAddress(){
		int putzero;
		
		putzero = zipcode / 10000;
		
		if(putzero == 0) { //check if need to put a 0 to make zipcode 5 digits, ex. 04761
			address = streetaddress + " \n" + city + ", " + state + " 0" + zipcode;
		}
		else {
			address = streetaddress + " \n" + city + ", " + state + " " + zipcode;
		}
	}
	
	public String getAddress() {
		return address;
	}

	public String getCity(){
		return this.city;
	}
	public void setCity(String c){
		city = c;
	} 

	public String getState(){
		return this.state;
	}
	public void setState(String s){
		state = s;
	} 
	public int getZipcode(){
		return this.zipcode;
	}
	public void setZipcode(int z){
		if(z >= 1111 && z < 100000) {
		zipcode = z;
		}
		else if (z < 0) {
			System.out.println("A zipcode can't be negative. Please input a valid zipcode.");
		}
		else {
			System.out.println("A zipcode is a 5 digit number. Please input a valid zipcode.");
		}
	} 

	public String getEmail(){
		return this.email;
	}
	public void setEmail(String e){
		email = e;
	}
	
	public void setOpenHour(int oh) {
		openHour.add(oh);
	}

	public ArrayList<Integer> getOpenHour() {
		return openHour;
	}
	
	public void setCloseHour(int ch) {
		closeHour.add(ch);
	}
	
	public void animalAwaitingFoster(Animal a) {
		
		for(int i = 0; i < fosterList.size(); ++i) {
			Animal compare = fosterList.get(i);
			if(compare == a) {
				fosterList.remove(i);
				break;
			}
		}
		
	}
	
	public String printShelterInfo() {
		String info = name;
		info = info + "\n" + address;
		
		double firstdigit;
		int fd;
		double firstthreedigits;
		int ftd;
		double middledigits;
		int md;
		double lastfourdigits;
		int lfd;
		
		firstdigit = Math.floor(phoneNumber / 10000000000.0);
		if(firstdigit == 0) {
		firstthreedigits = Math.floor(phoneNumber / 10000000);
		middledigits = Math.floor(phoneNumber / 10000 % 1000);
		lastfourdigits = Math.floor(phoneNumber % 10000);
		
		ftd = (int) firstthreedigits;
		md = (int) middledigits;
		lfd = (int) lastfourdigits;

		info = info + "\n" + ftd + "-" + md + "-" + lfd;		
		}
		else {
			firstthreedigits = Math.floor(phoneNumber / 10000000 % 1000);
			middledigits = Math.floor(phoneNumber / 10000 % 1000);
			lastfourdigits = Math.floor(phoneNumber % 10000);
			
		fd = (int) firstdigit;
		ftd = (int) firstthreedigits;
		md = (int) middledigits;
		lfd = (int) lastfourdigits;

		info = info + "\n" + fd + "-" + ftd + "-" + md + "-" + lfd;
		}
		
		info = info + "\n" + email;


		for(int i = 0; i < openHour.size(); ++i) {
		String day;
		String open;
		String close;
		String tag;
		int daynum;
		int openhour;
		int closehour;
		int hour;
		int min;

		daynum = (openHour.get(i)/ 10000);	
		openhour = (openHour.get(i)% 10000);
		closehour = (closeHour.get(i)% 10000);

		if(daynum == 1) {
			day = "Monday ";
		}
		else if(daynum == 2) {
			day = "Tuesday ";
		}
		else if(daynum == 3) {
			day = "Wednesday ";
		}
		else if(daynum == 4) {
			day = "Thursday ";
		}
		else if(daynum == 5) {
			day = "Friday ";
		}
		else if(daynum == 6) {
			day = "Saturday ";
		}
		else {
			day = "Sunday ";
			}

		hour = openhour / 100;
		min = openhour % 100;

		if(hour < 12) {
			tag = " A.M.";
		}
		else if(hour == 12) {
			tag = " P.M.";
		}
		else {
			hour = hour - 12;
			tag = " P.M.";
		}
		
		if(min < 10) {
			open = hour + ":0" + min + tag; 
		}
		else {
			open = hour + ":" + min + tag; 
		}

		hour = closehour / 100;
		min = closehour % 100;

		if(hour < 12) {
			tag = " A.M.";
		}
		else if(hour == 12) {
			tag = " P.M.";
		}
		else {
			hour = hour - 12;
			tag = " P.M.";
		}
		
		if(min < 10) {
			close = hour + ":0" + min + tag; 
		}
		else {
			close = hour + ":" + min + tag; 
		}
		
		info = info + "\n" + day + open + " to " + close;
		
		}
		return info;
	}
	
	public ArrayList<Integer> getCloseHour() {
		return closeHour;
	}
	
	public void addtoHistory(Animal a){
		historyanimals.add(a);
		a.setShelter(this);
	}
	
	public ArrayList<Animal> getHistory(){
		return historyanimals;
	}
	
	public void addCurrentAnimal(Animal an) {
		boolean result;
		currentanimals.add(an);
		
		result = historyanimals.contains(an);
		if(result == false) {
		historyanimals.add(an);
		}
		an.setShelter(this);
	}
	
	public ArrayList<Animal> getCurrentAnimals() {
		return currentanimals;
	}
	public void removeAnimal(Animal an) {
		currentanimals.remove(an);
		an.setShelter(new Shelter());
	}
	
	public void moveAdoptedAnimal(Animal a, String newowner) {
		
		int index = -1; 
		for(int i = 0; i < currentanimals.size(); ++i) {
			Animal compare = currentanimals.get(i);
			if(a == compare) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
		currentanimals.remove(index);
		a.setAdopted(true);
		a.setOwnerName(newowner);
		}
	}
	
	
	public void addtoWaitingList(Animal w) {
		boolean result;
		waitingList.add(w);
		result = historyanimals.contains(w);
		if(result == false) {
			historyanimals.add(w);
		}
		w.setShelter(this);
	}
	public ArrayList<Animal> getWaitingList() {
		return waitingList;
	}
	public void removeFosterList(Animal f) {
		for(int i = 0; i < fosterList.size(); ++i) {
			Animal a = fosterList.get(i);
			if(a == f) {
				fosterList.remove(i);
				break;
			}
		}
		f.setFoster(false);
		f.setShelter(new Shelter());
	}
	
	public void moveFosteredAnimal(Animal f, String fostername) {
		
		int index = -1; 
		for(int i = 0; i < fosterList.size(); ++i) {
			Animal compare = fosterList.get(i);
			if(f == compare) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
		fosterList.remove(index);
		f.setOwnerName(fostername);
		}
	}
	public void setFosterList(Animal f) {
		fosterList.add(f);
		if(!(historyanimals.contains(f))) {
			historyanimals.add(f);
		}
		f.setFoster(true);
		f.setShelter(this);
	}
	
	public ArrayList<Animal> getFosterList() {
		return fosterList;
	}
	
	public void sendEmail(Email e) {
		emailList.add(e);
	}
	
	public ArrayList<Email> getEmailList() {
		return emailList;
	}
	
	public void addAppointment(Appointment a) {
		appointments.add(a);
	}
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	//public PhoneCall getPhone() {
		//return phone;
	//}
	//public void setPhone(PhoneCall p){
		//this.phone = p;
	//}
	
	public int findAnimalById(int ID) {
		int detect = 0;
		
		for(int i = 0; i < currentanimals.size(); ++i) {
			int currnum = 0;
			currnum = currentanimals.get(i).getID();
			if(currnum == ID) {
				detect = 1;
				break;
			}
		}
		return detect;
	}
	
	public void displayAllAnimals() {
		searchCriteria = currentanimals; //populate searchCriteria with all current animals
		for(int i = 0; i < currentanimals.size(); ++i) {
			System.out.println(currentanimals.get(i).getName() + "        " + currentanimals.get(i).getSpecies());
		}
	}
	
public void displaySearchCriteria(String s, int age) { //print search criteria list
		
		if(searchCriteria.size() != 0) {
		if(s != null && age == -1) { //for printing the string only criteria
		for(int i = 0; i < searchCriteria.size(); ++i) {
			System.out.println(searchCriteria.get(i).getName() + "        " + s);
		}
		}
		else { //for printing the animals based on age
			if(age == 1) {
			for(int i = 0; i < searchCriteria.size(); ++i) {
				System.out.println(searchCriteria.get(i).getName() + "        " + "1 " + s + " old.");
			}
			}
			else {
				for(int i = 0; i < searchCriteria.size(); ++i) {
					System.out.println(searchCriteria.get(i).getName() + "        " + age + " " + s + "s old.");
				}
			}
		}
		}
		else {
			searchCriteria = currentanimals;
			System.out.println("There were no animals that met all of your search criteria. Would you like to do "
					+ "a new search or go back to the list of shelters?");
		}
	}
	
	public void setSearchforAdoption() {
		searchCriteria = new ArrayList<Animal>();
		
		for(int i = 0; i < currentanimals.size(); ++i) {
			Animal a = currentanimals.get(i);
			searchCriteria.add(a);
		}
	}
	
//	public void setSearchforFoster() {
//		searchCriteria = new ArrayList<Animal>();
//		for(int i = 0; i < fosterList.size(); ++i) {
//			Animal a = fosterList.get(i);
//			searchCriteria.add(a);
//		}
//	}
//	
	public boolean resetSearchCritera(String yn) { //not sure if we need this
		String lyn = yn.toLowerCase();
		
		if(lyn == "search") {
			this.displayAllAnimals();
			return true;
		}
		else if(lyn == "list") {
			data.displayStateShelters();
			return false;
		}
		else {
			System.out.println("Your input isn't a valid response. The options are either search (to do a new search) "
					+ "or list (to return to the list of shelters in a state).");
			return true;
		}
	}
	
	public void sizeSearchCriteria(String sz) {
		String lsz = sz;
		String compare;
		
		if(lsz.equals("small") || lsz.equals("medium") || lsz.equals("large")) {
			for(int i = searchCriteria.size() - 1; i >= 0; --i) {
				compare = searchCriteria.get(i).getSize();
				if(!(compare.equals(lsz))) {
					searchCriteria.remove(i);
				}
			}
			//this.displaySearchCriteria(sz, -1);
		}
		//else {
		//	System.out.print("The options for size are either small, medium, or large. "
		//			+ "Please re-enter your search criteria.");
			
		//}
	
	}
	
	public void speciesSearchCriteria(String sp) {
		String lsp = sp;
		String compare;
		
		for(int i = searchCriteria.size() - 1; i >= 0; --i) {
				compare = searchCriteria.get(i).getSpecies();
				if(!(compare.equals(lsp))) {
					searchCriteria.remove(i);
				}
			}
			//this.displaySearchCriteria(sp, -1);
	}
	
	public void breedSearchCriteria(String bd) {
		String lbd = bd;
		String compare;
		
		for(int i = searchCriteria.size() - 1; i >= 0; --i) {
				compare = searchCriteria.get(i).getBreed();
				if(!(compare.equals(lbd))) {
					searchCriteria.remove(i);
				}
			}
		//	this.displaySearchCriteria(bd, -1);
	}
	

	
	public void genderSearchCriteria(String g) {
		String lg = g;
		String compare;
		
		
		if(g.equals("Female") || g.equals("Male") || g.equals("Boy") || g.equals("Girl") || g.equals("M") || g.equals("F")) {
			for(int i = searchCriteria.size() - 1; i >= 0; --i) {
				if(g.equals("Female") || g.equals("F") || g.equals("Girl")) {
					lg = "Female";
				}
				else {
					lg = "Male";
				}
				compare = searchCriteria.get(i).getGender();
				if(!(compare.equals(lg))) {
					searchCriteria.remove(i);
				}
			}
			//this.displaySearchCriteria(g, -1);
		}
		//else {
		//	System.out.println("The gender you put in isn't a valid option. The possible entries are female, male, "
		//			+ "boy, girl, f, or m.");	
		//}
	}
	
	public ArrayList<Animal> getSearchCriteria() {
		return searchCriteria;
	}
	
	public void ageSearchCriteria(int a, String ageunits, int currday) {
		String compare;
		String whole;
		
		if(a >= 0) {
			//if(!(ageunits.equals("days")) || !(ageunits.equals("day")) || !(ageunits.equals("months")) 
			//		|| !(ageunits.equals("month")) || !(ageunits.equals("years")) || !(ageunits.equals("year"))) {
			//		System.out.println("The unit of time you put is invalid. The valid units of time for the age of an animal "
			//				+ "is either day(s), month(s), or year(s).");
			//	}
			//else {
				if(a == 1) {
				whole = "1 " + ageunits + " old";
				}
				else {
					whole = a + " " + ageunits +" old";
				}
				for(int i = searchCriteria.size() - 1; i >= 0; --i) {
				compare = searchCriteria.get(i).getAge(currday);
				if(!(compare.equals(whole))) {
					searchCriteria.remove(i);
				}
			}
			//this.displaySearchCriteria(ageunits, a);
		
			}
	}
	
	public void animalAwaitingAdoption(Animal a) {
		for(int i = 0; i < currentanimals.size(); ++i) {
			Animal compare = currentanimals.get(i);
			if(compare == a) {
				currentanimals.remove(i);
				break;
			}
		}
		
	}

	public void removeStray(Animal animal) {
		this.waitingList.remove(animal);
	}
}

