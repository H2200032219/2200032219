package com.klef.jfsd.exam;

import org.hibernate.annotations.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(appliesTo = "clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String gender;
    private int age;
    private String location;
    private String emailAddress;
    private String mobileNumber;

    public Client() {}

    public Client(String name, String gender, int age, String location, String emailAddress, String mobileNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAge() {
		// TODO Auto-generated method stub
		return null;
	}
}
