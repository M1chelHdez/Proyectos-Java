package com.employees.dominio;

import java.sql.Date;
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
@Table(name = "EMPLOYEES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employees {

//	  Employees 
//	  CREATE TABLE EMPLOYEES( ID NUMBER PRIMARY KEY, 
//			  NAME NVARCHAR2(50),
//	  LAST_NAME NVARCHAR2(50), 
//	  BIRTHDATE DATE );

	@Id
	@Column
	int id;
	@Column()
	String name;
	@Column()
	String last_name;
	@Column
	Date birthday;

	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	@JsonIgnore
	Genders gender;
	
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employee_Worked_Hours> lista = new ArrayList<Employee_Worked_Hours>();

	public Employees() {
	}

	public Employees(int id, String name, String last_name, Date birthday, List<Employee_Worked_Hours> lista) {
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.lista = lista;
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<Employee_Worked_Hours> getLista() {
		return lista;
	}

	public void setLista(List<Employee_Worked_Hours> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", last_name=" + last_name + ", birthday=" + birthday
				+ ", lista=" + lista + "]";
	}

}
