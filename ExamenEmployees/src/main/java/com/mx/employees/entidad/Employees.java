package com.mx.employees.entidad;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employees implements Comparable<Employees> {
	/* CREATE TABLE EMPLOYEES(
ID NUMBER PRIMARY KEY NOT NULL,
GENDER_ID NUMBER,
JOB_ID NUMBER,
NAME NVARCHAR2(40),
LAST_NAME NVARCHAR2(40),
BIRTHDATE DATE,
FOREIGN KEY(GENDER_ID) REFERENCES GENDERS(ID),
FOREIGN KEY (JOB_ID) REFERENCES JOBS(ID)
); */
	@Id
	@Column
	int id;
	@Column
	String name;
	@Column
	String last_name;
	@Column
	Date birthdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	Genders gender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID")
	Jobs job;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonIgnore
	List<EmployeeWorked> listWorkeds = new ArrayList<EmployeeWorked>();

	@Override
	public int compareTo(Employees o) {
		return this.last_name.compareTo(o.last_name);
	}
}
