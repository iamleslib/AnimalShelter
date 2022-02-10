package org.database.contact;

import java.io.Serializable;

public class Email implements Serializable {
	
	private String senderEmail;
	private String subjectLine;
	private String messageBody;
	private String receiverEmail; 
	
	
	public Email() {
		
	}
	
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String se) {
		senderEmail = se;
	}
	public void setSubjectLine(String sl) {
		subjectLine = sl;
	}
	public String getSubjectLine() {
		return subjectLine;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String mb) {
		messageBody = mb;
	}
	
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String re) {
		receiverEmail = re;
	}
	
	public String displayEmail() {
		String d;
		
		d = "Subject: " + subjectLine + "\n" + "\n";
		d = d + "Sender: " + senderEmail + "\n" + "\n";
		d = d + "Receipient: " + receiverEmail + "\n" + "\n";
		d = d + "Message:" + "\n" + messageBody + "\n";
		
		return d;
	}

}