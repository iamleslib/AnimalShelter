package org.database.contact;

import java.io.Serializable;

public class PhoneCall implements Serializable{
		
		private int phoneNumber;
		private boolean busyLine;
		
		//public Phonecall() {

		//}
		
		public int getPhoneNumber() {
			return phoneNumber;
		}
		
		public void setPhoneNumber(int num) {
			phoneNumber = num;
		}
		
		public void isBusy() {
			
		}

	}

