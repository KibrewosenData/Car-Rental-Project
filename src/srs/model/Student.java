package srs.model;

import java.time.LocalDate;

public class Student {
	
	private int studentId;
	private String studentNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private LocalDate admissionDate;

	public Student() {
		
	}
	
	public Student(String studentNumber, String firstName) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
	}

	public Student(int studentId, String studentNumber, String firstName, String lastName, String email, String street,
			String city, String state, String zipCode, LocalDate admissionDate) {
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.admissionDate = admissionDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

}
