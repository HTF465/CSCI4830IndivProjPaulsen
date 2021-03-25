/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import datamodel.Contact;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration();
      configuration.configure();

      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure();
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Contact> listContacts() {
      List<Contact> resultList = new ArrayList<Contact>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> employees = session.createQuery("FROM Contact").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            Contact contact = (Contact) iterator.next();
            resultList.add(contact);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Contact> listContacts(String keyword) {
      List<Contact> resultList = new ArrayList<Contact>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         System.out.println((Contact)session.get(Contact.class, 1)); // use "get" to fetch data
        // Query q = session.createQuery("FROM Employee");
         List<?> employees = session.createQuery("FROM Contact").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            Contact contact = (Contact) iterator.next();
            if (contact.getHidden() == 0 && (contact.getFname().contains(keyword) || (contact.getDname()!= null && contact.getDname().contains(keyword)))) 
            {
//            	System.out.println("test " + contact.toString());
               resultList.add(contact);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
   
   public static void updateContacts(int id, String fName, String lName, String number, String dname, String email, int hidden) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.update((new Contact(id, fName, lName, number, dname, email, hidden)));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }

   public static void createContacts(String fName, String lName, String number, String dname, String email) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Contact(fName, lName, number, dname, email));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
