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
@Table(name = "GENDERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genders {

//	CREATE TABLE GENDERS(
//			ID NUMBER PRIMARY KEY,
//			NAME NVARCHAR2(50),
//			ID_EMPLOYEES NUMBER,
//			FOREIGN KEY(ID_EMPLOYEES) REFERENCES EMPLOYEES(ID)
//			);

	@Id
	@Column
	int id;
	@Column()
	String name;

	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employees> list = new ArrayList<Employees>();

	public Genders() {
	}

	public Genders(int id, String name, List<Employees> listE) {
		this.id = id;
		this.name = name;
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

	public List<Employees> getList() {
		return list;
	}

	public void setListE(List<Employees> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Genders [id=" + id + ", name=" + name + ", listE=" + list + "]";
	}

}
