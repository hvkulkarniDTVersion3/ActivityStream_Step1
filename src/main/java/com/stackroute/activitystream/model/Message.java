package com.stackroute.activitystream.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

@Entity
public class Message {

	/*
	 * This class should have four fields
	 * (messageId,senderName,postedDate,message). Out of these four fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int messageId;
	private String senderName;
	private String message;
	private String postedDate;

	public Message(String senderName, String message) {

		this.senderName = senderName;
		this.message = message;
		this.postedDate = new Date().toString();
	}

	public Message() {
		this.postedDate = new Date().toString();
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;

	}

	public void setMessage(String message) {
		this.message = message;

	}

	public void setPostedDate() {
		postedDate = new Date().toString();
	}

	public String getSenderName() {
		return senderName;
	}

	public String getMessage() {
		return message;
	}
}