package com.mx.CrudEmpleados.dominio;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLEADOS_ENCOM")
public class Empleado {

//	CREATE TABLE EMPLEADOS_ENCOM(
//			ID NUMBER PRIMARY KEY,
//			NOMBRE NVARCHAR2(50),
//			APP NVARCHAR2(50),
//			FECHA_NACIMIENTO DATE,
//			EDAD NUMBER,
//			FECHA_INGRESE DATE,
//			DEPARTAMENTO NVARCHAR2(50),
//			SUELDO NUMBER,
//			CHECK (EDAD >= 30 AND EDAD <= 40),
//			CHECK  (DEPARTAMENTO IN ('PROGRAMACION','SOPORTE','RH','VENTAS'))
//			);

	@Id
	@Column()
	int id;
	@Column()
	String nombre;
	@Column()
	String app;
	@Column()
	Date fecha_nacimiento;
	@Column()
	int edad;
	@Column()
	Date fecha_ingrese;
	@Column()
	String departamento;
	@Column()
	double sueldo;

	public Empleado() {
		super();
	}

	public Empleado(int id, String nombre, String app, Date fecha_nacimiento, int edad, Date fecha_ingrese,
			String departamento, double sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.fecha_ingrese = fecha_ingrese;
		this.departamento = departamento;
		this.sueldo = sueldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFecha_ingrese() {
		return fecha_ingrese;
	}

	public void setFecha_ingrese(Date fecha_ingrese) {
		this.fecha_ingrese = fecha_ingrese;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", app=" + app + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", edad=" + edad + ", fecha_ingrese=" + fecha_ingrese + ", departamento=" + departamento + ", sueldo="
				+ sueldo + "]/n";
	}

}
