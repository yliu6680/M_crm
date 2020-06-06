package com.crm.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// employee_id(U), first_name, last_name, title, phone, email

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eid")
	private int eid;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="title")
	private String title;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="employee",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonManagedReference(value = "employee")
	private Set<GroupEmployee> groupEmployees = new HashSet<GroupEmployee>();

	public Employee() {
		
	}

	public Employee(String firstName, String lastName, String title, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.phone = phone;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<GroupEmployee> getGroupEmployees() {
		return groupEmployees;
	}

	public void setGroupEmployees(Set<GroupEmployee> groupEmployees) {
		this.groupEmployees = groupEmployees;
	}
	
	public void addGroupEmployees(GroupEmployee groupEmployee) {
		this.groupEmployees.add(groupEmployee);
		
		groupEmployee.setEmployee(this);
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	// if add "groupEmployees= + groupEmployees", then stackoverflow error in tostring method
	
}
