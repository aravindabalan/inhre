package com.rags.manytoone;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {

	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	private Session getSession() {
		Session s = null;
		try {
			sessionFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
			s = sessionFactory.openSession();

		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}

	public void insertStudent(Student bk) {
		try {
			Session s = getSession();
			Transaction transaction = s.beginTransaction();
			s.save(bk);
			//s.save(b);
			transaction.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public Student getStudent(long id) {
		Student ls=new Student();	
		try {
			Session s = getSession();
			ls=(Student) s.load(Student.class,id);
          //  System.out.println(ls.size());
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		return ls;
	}
	
	

}
