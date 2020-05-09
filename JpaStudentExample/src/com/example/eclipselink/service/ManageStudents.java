package com.example.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.eclipselink.entity.Student;

public class ManageStudents {
	public static final String PERSISTENCE_UNIT_NAME = "JpaStudentExample";

	public static void main(String[] args) {

		// create an EntityManagerFactory for the persistence unit
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

		// create an EntityManager for interacting with the persistence unit
		EntityManager entitymanager = emfactory.createEntityManager();

		// get an EntityTransaction to manage insert operation
		EntityTransaction transaction = entitymanager.getTransaction();

		// create students
		create(entitymanager, transaction);

		// update student
		update(entitymanager, transaction);

		// delete student
		delete(entitymanager, transaction);

		// close Entity manager & factory
		entitymanager.close();
		emfactory.close();
	}

	private static void create(EntityManager entitymanager, EntityTransaction transaction) {
		// start transaction
		try {
			transaction.begin();

			// create new instance
			Student student1 = new Student(342432044, "Marina Rappoport", 32);
			Student student2 = new Student(111111111, "Amit Kalish", 23);

			Student student3 = new Student(222222222, "Dan Tal", 30);

			Student student4 = new Student(333333333, "John Smith", 40);

			// persist - instance to save
			entitymanager.persist(student1);
			entitymanager.persist(student2);
			entitymanager.persist(student3);
			entitymanager.persist(student4);

			// end transaction
			transaction.commit();
			
			System.out.println("Students were added successfully");
		} catch (Exception e) // if transaction failed
		{
			transaction.rollback(); // undo database operations
			System.out.println("Failed to add students");
		}
	}

	private static void update(EntityManager entitymanager, EntityTransaction transaction) {
		transaction.begin();

		// FIND
		Student student = entitymanager.find(Student.class, 111111111);

		// before update
		System.out.println("Before update: " + student);

		student.setAge(24);
		transaction.commit();

		// after update
		System.out.println("Ufter update: " + student);
	}

	private static void delete(EntityManager entitymanager, EntityTransaction transaction) {
		transaction.begin();
		
		Student student = entitymanager.find(Student.class, 111111111);
		entitymanager.remove(student);
		
		transaction.commit();
		System.out.println("Student was removed");
	}
}
