package com.auth.authenticationSystem;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name")
	private String Name;

	@Column(name = "Password")
	private String Password;


	public Student() {
	}

	public Student(int id, String Name, String Password) {
		this.id = id;
		this.Name = Name;
		this.Password = Password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
