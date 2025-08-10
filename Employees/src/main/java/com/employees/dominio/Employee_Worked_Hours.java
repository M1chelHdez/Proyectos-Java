package com.employees.dominio;

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
@Table(name = "EMPLOYEE_WORKED_HOURS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee_Worked_Hours {

//	CREATE TABLE EMPLOYEE_WORKED_HOURS(
//			ID NUMBER PRIMARY KEY,
//			WORKED_HOURS NUMBER,
//			WORKED_DATE DATE,
//			ID_EMPLOYEES NUMBER,
//			FOREIGN KEY(ID_EMPLOYEES) REFERENCES EMPLOYEES(ID)
//			);

	@Id
	@Column
	int id;
	@Column
	int worked_hours;
	@Column
	Date worked_date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_EMPLOYEES")
	Employees employees;

	public Employee_Worked_Hours() {
	}

	public Employee_Worked_Hours(int id, int worked_hours, Date worked_date, Employees employees) {
		this.id = id;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}

	public Date getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Employee_Worked_Hours [id=" + id + ", worked_hours=" + worked_hours + ", worked_date=" + worked_date
				+ ", employees=" + employees + "]";
	}

}
