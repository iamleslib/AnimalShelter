package org.database.contact;

import java.io.Serializable;

import org.database.actors.Animal;

public class Appointment implements Serializable {
	
	private int date;
	private int startTime;
	private int endTime;
	private int duration;
	private String appointmentType;
	private String personname;
	//for one appointment 
	//dog to dog will be 40 minutes
	//dog to cat will be 30 minutes
	//cat to cat will be 20 minutes
	//dog to critter will be 50 minutes
	//cat to critter will be 40 minutes
	//critter to critter will be 30 minutes
	//child to dog will be 40 minutes
	//child to cat will be 30 minutes
	//child to critter will be 30 minutes
	private int dayofweek;
	private Animal appointmentanimal;
	
	public Appointment() {
		date = 0;
		startTime = 0;
		endTime = 0;
		duration = 0;
		appointmentType = new String();
	}
	
	
	public void setPersonName(String pn) {
		personname = pn;
	}
	public String getPersonName() {
		return personname;
	}
	public void setDate(int aDate) {
		date = aDate;
	}
	
	public int getDate() {
		return date;
	}
	
	public void setStartTime(int time) {
		startTime = time;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	//public void setEndTime(int time) {
	//	endTime = time;
	//}
	
	public int getEndTime() {
		int result;
		int check;
		
		result = startTime + duration;
		
		check = result % 100;
		
		if(check >= 60) {
			result = (result - 60) + 100;
		}
		
		endTime = result;
		return endTime;
		
	}
	
	public void setDuration(int aTime) {
		duration = aTime;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setAppointmentType(String type) {
		appointmentType = type;
	}
	
	public String getAppointmentType() {
		return appointmentType;
	}


	public void setDayofWeek(int dow) {
		dayofweek = dow;
	}
	public int getdayofWeek() {
		return dayofweek;
	}
	
	public void setAnimal(Animal a) {
		appointmentanimal = a;
	}
	public Animal getAnimal() {
		return appointmentanimal;
	}
	

}