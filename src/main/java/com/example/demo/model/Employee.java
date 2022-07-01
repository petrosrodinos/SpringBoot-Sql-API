package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Name should not be null")
	private String name;
//	@JsonIgnore
	private Long age=0L;
	private String location;
	@Email(message="Enter a valid email address")
	private String email;
	@NotNull(message="Department should not be null")
	private String department;
	
	
	
	
	
}
