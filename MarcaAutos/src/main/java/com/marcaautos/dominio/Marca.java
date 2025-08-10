package com.marcaautos.dominio;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "MARCA_AUTO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marca {
	/*
	 * CREATE TABLE MARCA_AUTO( ID NUMBER PRIMARY KEY, NOMBRE_MARCA NVARCHAR2(50),
	 * PAIS NVARCHAR2(50), NUM_EMPLEADOS NUMBER, ANIOS NUMBER, FUNDADOR
	 * NVARCHAR2(50) );
	 */

	@Id
	@Column()
	int id;
	@Column()
	String nombre_marca;
	@Column()
	String pais;
	@Column()
	int num_empleados;
	@Column()
	int anios;
	@Column()
	String fundador;

	/*
	 * -> RElaciones de uno a muchos @OneToMany --> cuando la relacion es de uno a
	 * muchos pasos una lista de objetos mappedBy -> indica a spring que la relacion
	 * esta en otra tabla por que el conexto es en cascada --> CascadeType.ALL
	 */

	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Autos> lista = new ArrayList<Autos>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getNum_empleados() {
		return num_empleados;
	}

	public void setNum_empleados(int num_empleados) {
		this.num_empleados = num_empleados;
	}

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	public String getFundador() {
		return fundador;
	}

	public void setFundador(String fundador) {
		this.fundador = fundador;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre_marca=" + nombre_marca + ", pais=" + pais + ", num_empleados="
				+ num_empleados + ", anios=" + anios + ", fundador=" + fundador + ", lista=" + lista + "]/n";
	}

	
}
