package com.crm.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="group_employee")
public class GroupEmployee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="geid")
	private int geid;
	
	@Column(name="employee_role")
	private String employeeRole;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "eid")
	@JsonBackReference(value = "employee")
	private Employee employee;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "gid")
	@JsonBackReference(value = "group")
	private Group group;
	
	public GroupEmployee() {
		
	}

	public GroupEmployee(String employeeRole, Employee employee, Group group) {
		super();
		this.employeeRole = employeeRole;
		this.employee = employee;
		this.group = group;
	}

	public int getGeid() {
		return geid;
	}

	public void setGeid(int geid) {
		this.geid = geid;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "GroupEmployee [geid=" + geid + ", employeeRole=" + employeeRole + ", employee=" + employee + ", group="
				+ group + "]";
	}
	
}
