package com.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue( value = "student" )
//@PrimaryKeyJoinColumn(referencedColumnName="sid")

public class Student extends Person {
	private static final long serialVersionUID = 1L;
private String areaOfStudy;

   public Student( int sid, String sname, String areaOfStudy ) {
      super( sid, sname );
      this.areaOfStudy = areaOfStudy;
   }

   public Student( ) {
      super( );
   }

	public String getAreaOfStudy() {
		return areaOfStudy;
	}
	
	public void setAreaOfStudy(String areaOfStudy) {
		this.areaOfStudy = areaOfStudy;
	}

}