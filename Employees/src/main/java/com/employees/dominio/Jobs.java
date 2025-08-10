package com.employees.dominio;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JOBS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Jobs {

//	CREATE TABLE JOBS(
//			ID NUMBER PRIMARY KEY,
//			NAME NVARCHAR2(50),
//			SALARY NUMBER,
//			ID_EMPLOYEES NUMBER,
//			FOREIGN KEY(ID_EMPLOYEES) REFERENCES EMPLOYEES(ID)
//			);

	@Id
	@Column
	int id;
	@Column()
	String name;
	@Column
	int salary;

	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employees> list = new ArrayList<Employees>();

	public Jobs() {
	}

	public Jobs(int id, String name, int salary, List<Employees> listE) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Employees> getListE() {
		return list;
	}

	public void setListE(List<Employees> listE) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", salary=" + salary + ", listE=" + list + "]";
	}

}
