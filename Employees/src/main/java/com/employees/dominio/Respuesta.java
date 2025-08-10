package com.employees.dominio;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

	String mensaje;
	Employees emp;
	List<Employees> employees = new ArrayList<>();
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<Employees> getEmployee(){
		return employees;
	}
	public void setEmployees(List<Employees> employee) {
		this.employees = employees;
	}
}
