package com.student.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private int rollNo;
	@Column
	private String fullName;
	@Column
	private String joinedDate;
	
	@OneToMany(targetEntity = Contact.class,cascade = CascadeType.ALL )
	@JoinColumn(name ="StuContact_foreignKey", referencedColumnName = "rollNo")
	private List<Contact> contacts;

	
}
