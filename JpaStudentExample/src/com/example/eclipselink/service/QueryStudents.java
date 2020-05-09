package com.example.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.eclipselink.entity.Student;

public class QueryStudents {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(ManageStudents.PERSISTENCE_UNIT_NAME);
		EntityManager entitymanager = emfactory.createEntityManager();
		
		//Dynamic query 1
		Query query1 = entitymanager.createQuery( "Select s from Student s WHERE s.name LIKE '%a%' ORDER BY s.age ASC" );
		List<Student> list = query1.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
		
		System.out.println("\n------------------\n");

		//Dynamic query 2
		Query query2 = entitymanager.createQuery( "Select s.id from Student s WHERE s.name = :name", Integer.class ).setParameter("name", "Marina Rappoport");
		List<Integer> ids = query2.getResultList();
		System.out.println("Id of the student: " + ids.get(0));
		
		
		System.out.println("\n------------------\n");
		
		//Static (named) query 
		Query nQuery = entitymanager.createNamedQuery("findAll", Student.class);
		list = nQuery.getResultList();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}

}
