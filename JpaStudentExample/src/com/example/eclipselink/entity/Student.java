package com.example.eclipselink.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "findByID", query = "SELECT s FROM Student s WHERE s.id = :id")})
public class Student implements Serializable{
	 @Id	
	 @GeneratedValue(strategy = GenerationType.TABLE) 	
	   private int id;
	   private String name;
	   private int age;
	   
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
