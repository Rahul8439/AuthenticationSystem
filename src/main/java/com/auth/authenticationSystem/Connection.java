package com.auth.authenticationSystem;



import java.util.List;

import org.hibernate.*;

import org.hibernate.Session;


public class Connection {
	static Session session=null;
	
		
		/*
		 * session.beginTransaction(); session.save(tempStudent);
		 * session.getTransaction().commit();
		 */

	public static void insertRecord(Student student) {
		session=HibernateSession.gethibernateSession();		
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}
  
	public static List<Student> checkUserExistInDB(String name) {
		session=HibernateSession.gethibernateSession();
		String queryString="from Student where name= ?";
		Query queryObject=session.createQuery(queryString);
		queryObject.setParameter(0, name);
		List Studentlist = queryObject.list();
		return Studentlist;
	}
	void updateRecord() {

	}

	public static List<Student> fetchRecord() {
		session=HibernateSession.gethibernateSession();		
		session.beginTransaction();
		List<Student> li = session.createQuery("from Student").list();
		/*
		 * java.util.Iterator<Student> itr = li.iterator(); while (itr.hasNext()) {
		 * Student e = (Student) itr.next(); System.out.println(e.Age + "---" + e.Name);
		 * }
		 */
		return li;
	}
	
	public static int verifyData(Student student) {
		String  verifyName = student.getName();
		List Studentlist = checkUserExistInDB(verifyName);
		if(Studentlist.isEmpty())
			return 0;
		else
			return 1;	
	}

	public static List<Student>deleteRecord(int Age) {
		 String queryString = "from Student where Age= ?";
		 session=HibernateSession.gethibernateSession();	
	        Query queryObject = session.createQuery(queryString);
	        queryObject.setParameter(0, Age);
	        List Studentlist=queryObject.list();
	        for (Object student : Studentlist) {
				if(student instanceof Student) {
					if(((Student) student).Age==22) {
						session.delete(student);
						session.beginTransaction();
						session.getTransaction().commit();
					}
				}
				
			}
			return Studentlist;
	}


}






