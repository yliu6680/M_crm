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

@Entity
@Table(name="groupwork")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gid")
	private int gid;
	
	@Column(name = "group_name")
	private String groupName;
	
	// CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
	@OneToMany(mappedBy = "group",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonManagedReference(value = "group")
	private Set<GroupEmployee> groupEmployees = new HashSet<GroupEmployee>();

	public Group() {

	}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Set<GroupEmployee> getGroupEmployees() {
		return groupEmployees;
	}

	public void setGroupEmployees(Set<GroupEmployee> groupEmployees) {
		this.groupEmployees = groupEmployees;
	}
	
	public void addGroupEmployees(GroupEmployee groupEmployee) {
		this.groupEmployees.add(groupEmployee);
		
		groupEmployee.setGroup(this);
	}
	
	@Override
	public String toString() {
		return "Group [gid=" + gid + ", groupName=" + groupName + "]";
	}
	
}
