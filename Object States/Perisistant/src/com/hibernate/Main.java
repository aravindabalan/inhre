package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	public static void main(String[] args) {
		
		Student student = null;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();

		student = (Student) session1.get(Student.class, 1);
		
		System.out.println("Student object retrieved: name = "+student.getStudent_name());

		student.setStudent_name("modifying student name having student id as 1");

		//session1.delete(student);
		
		session1.getTransaction().commit();
		session1.close();
		
	}
}
