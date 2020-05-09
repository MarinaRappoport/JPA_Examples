package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.example.entity.Student;
import com.example.entity.Teacher;

public class SaveClient {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("InheritanceExample");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Teacher entity
		Teacher t1 = new Teacher(11111111, "John Smith", "MSc MEd", "Maths");
		Teacher t2 = new Teacher(22222222, "Tal Kolgan", "BSc BEd", "English");

		// Student entity
		Student s1 = new Student(33333333, "Marina Rappoport", "Computer Sience");
		Student s2 = new Student(44444444, "Maksim Pekalov", "Management");

		// storing all entities
		entitymanager.persist(t1);
		entitymanager.persist(t2);
		entitymanager.persist(s1);
		entitymanager.persist(s2);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
