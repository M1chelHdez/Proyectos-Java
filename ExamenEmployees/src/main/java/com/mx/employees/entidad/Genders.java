package com.mx.employees.entidad;

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
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genders {
	/*CREATE TABLE GENDERS(
ID NUMBER PRIMARY KEY NOT NULL,
NAME NVARCHAR2(40)
); */
	@Id
	@Column
	int id;
	@Column
	String name;
	
	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employees> listE = new ArrayList<Employees>();
	
}
