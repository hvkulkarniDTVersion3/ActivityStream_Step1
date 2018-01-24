package com.stackroute.activitystream.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

/*
 * This class contains the code for database interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
@Repository
@Transactional
public class MessageRepository {

	/*
	 * declare SessionFactory and Session objects
	 */
	Session session = null;

	public MessageRepository() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	/*
	 * create a hibernate SessionFactory from HibernateUtil
	 * 
	 * 
	 * 
	 * 
	 * /* This method is used to save messages in database. Perform exception
	 * handling and close the session in the finally block
	 */
	public boolean sendMessage(Message message) {
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		//session.close();
		return true;
	}

	/*
	 * This method is used to retrieve all messages in database. Perform
	 * exception handling and close the session in the finally block
	 */
	public List<Message> getAllMessages() {
		Session session=null;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Message order by postedDate desc");
		List<Message> messages = query.list();
		session.getTransaction().commit();
	//	session.close();
		return messages;
	}
}