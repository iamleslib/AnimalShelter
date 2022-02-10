package org.database.interf1;

import javax.swing.*;

import org.database.actors.Animal;
import org.database.actors.Database;
import org.database.actors.Shelter;
import org.database.contact.Email;
//import org.database.interf.PickOneShelter.AdoptButtonListener;
//import org.database.interf.PickOneShelter.SearchButtonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CustomerEmail extends JFrame {

	private JPanel panel;             // A panel container
	private JLabel emailMessage;      // A message to display
	private JList<String> listofemails;			//list of emails
	private JButton sendButton;       // Make new email
	private final int WINDOW_WIDTH = 300;  // Window width
	private final int WINDOW_HEIGHT = 200; // Window height
	private String currentEmail;
	private Database d;
	private ArrayList<Email> emailstodisplay;
	
	public CustomerEmail() {
		
		// Call the JFrame constructor.
	      super("Customer Email System");

	      // Set the size of the window.
	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	      
	      emailstodisplay = new ArrayList<Email>();

	      // Specify what happens when the close
	      // button is clicked.
	      
	      setLocationRelativeTo(null);
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setDatabase(Database db) { //make sure the database is added and then display the window
		d = db;
	}
	
	public void setCurrentEmail(String e) {
		currentEmail = e;
	}
	
	public void displayEmail() {

	      // Build the panel and add it to the frame.
	      buildPanel();

	      // Add the panel to the frame's content pane.
	      add(panel);
	      
	      setVisible(true);
	      
	}
	
	private void buildPanel() {
	
		emailMessage = new JLabel("You can view and send emails here. Below are the emails sent to " + currentEmail);
		
		sendButton = new JButton("Create An Email");
	    
	    DefaultListModel<String> listofemails = new DefaultListModel<>();
	      
	    
	      for(int i = 0; i < d.getAllShelters().size(); ++i) {
	    	  Shelter current = d.getAllShelters().get(i);
	    	  for(int j = 0; j < current.getEmailList().size(); ++j) {
	    		  Email e = current.getEmailList().get(j);
	    		  String r = e.getReceiverEmail();
	    		  //System.out.println(r + "  space     " + currentEmail);
	    		  if(r.equals(currentEmail)) {
	    			  String whole = e.getSubjectLine() + "                                  " + e.getSenderEmail();
	    			  listofemails.addElement(whole);
	    			  emailstodisplay.add(e);
	    		  }
	    	  }
	      }
	      
	      JList<String> list = new JList<>(listofemails);
	      
	      list.addMouseListener(new MouseAdapter() {
	    	    public void mouseClicked(MouseEvent evt) {
	    	        JList list = (JList)evt.getSource();
	    	        if (evt.getClickCount() == 2) {

	    	            // Double-click detected
	    	            int index = list.locationToIndex(evt.getPoint());
	    	            Email a;
	    	            String result;
	    	            a = emailstodisplay.get(index);
	    	            result = a.displayEmail();
	    	            
	    	            JOptionPane.showMessageDialog(null, result, "Email information", JOptionPane.INFORMATION_MESSAGE);
	    	        } 
	    	    }
	    	});
	      
	      sendButton.addActionListener(new SendButtonListener());
	      
	      panel = new JPanel();
	      
	      panel.add(sendButton);
	      panel.add(list);
		
	}
	
	public class SendButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	    	JPanel drop = new JPanel();
	  		
	  		JLabel sub = new JLabel("Subject line:");
	  		JTextField line = new JTextField(30);
	  		
	  		JLabel rep = new JLabel("Receipent:");
	  		JTextField rec = new JTextField(30);
	  		
	  		JLabel mes = new JLabel("Message:");
	  		JTextField m = new JTextField(100);
	  		
	  		drop.add(sub);
	  		drop.add(line);
	  		drop.add(rep);
	  		drop.add(rec);
	  		drop.add(mes);
	  		drop.add(m);
	  		
	  		int result = JOptionPane.showConfirmDialog(null, drop, 
		               "Send Email", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) {
		    	  
		    	  String subject = line.getText();
		    	  String receiver = rec.getText();
		    	  String body = m.getText();
		    	  
		    	  if(subject.equals("") || subject == null) {
		    		  String error = "The subject field is blank. Please enter a response for the subject line.";
		    		  JOptionPane.showMessageDialog(null, error,
	    					  "Blank Subject", JOptionPane.ERROR_MESSAGE); 
		    	  }
		    	  else if(receiver.equals("") || receiver == null) {
		    		  String error = "The receipient field is blank. Please enter a response for the that line.";
		    		  JOptionPane.showMessageDialog(null, error,
	    					  "Blank Receipient", JOptionPane.ERROR_MESSAGE); 
		    	  }
		    	  else if(body.equals("") || body == null) {
		    		  String error = "The message is blank. Please enter a message.";
		    		  JOptionPane.showMessageDialog(null, error,
	    					  "Blank Message", JOptionPane.ERROR_MESSAGE); 
		    	  }
		    	  else {
		    		  
		    		  int detect = -1;
		    	 
		    		  for(int i = 0; i < d.getAllShelters().size(); ++i) {
		    	    	  Shelter current = d.getAllShelters().get(i);
		    	    	  String r = current.getEmail();
		    	    	  if(r != null) {
		    	    		  if(r.equals(receiver)) {
		    	    			  detect = i;
		    	    			  break;
		    	    		  }
		    	    	  }
		    		  }
		    		  
		    		  if(detect == -1) {
		    			  String error = "The receiver email you inputted doesn't match any of the shelters' emails. "
		    			  		+ "Please enter a shelter's email to send a mesaage.";
		    			  JOptionPane.showMessageDialog(null, error,
		    					  "Invalid Email", JOptionPane.ERROR_MESSAGE); 
		    		  }
		    		  else {
		    			  Email o = new Email();
		    			  o.setSenderEmail(currentEmail);
		    			  o.setReceiverEmail(d.getAllShelters().get(detect).getEmail());
		    			  o.setSubjectLine(subject);
		    			  o.setMessageBody(body);
		    			  d.getAllShelters().get(detect).sendEmail(o);
		    			  JOptionPane.showMessageDialog(null, "Message Sent", "Message Sent", JOptionPane.ERROR_MESSAGE); 
		    		  
		    		  }
		    	  
		      }
	  		
	  		
	      }
	   }
	   }
	
}
