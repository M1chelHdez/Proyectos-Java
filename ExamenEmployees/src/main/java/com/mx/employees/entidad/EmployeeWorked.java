package com.mx.employees.entidad;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_WORKED")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeWorked {
	/* CREATE TABLE EMPLOYEE_WORKED(
ID NUMBER PRIMARY KEY NOT NULL,
EMPLOYEE_ID NUMBER,
WORKED_HOURS NUMBER,
WORKED_DATE DATE,
FOREIGN KEY(EMPLOYEE_ID) REFERENCES EMPLOYEES(ID)
); */
	@Id
	@Column
	int id;
	@Column
	int worked_hours;
	@Column
	Date worked_date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	Employees employee;
}
