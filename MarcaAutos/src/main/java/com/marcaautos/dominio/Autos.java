package com.marcaautos.dominio;

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
@Table(name="MODELO_MARCA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Autos {

	/*
	 * CREATE TABLE MODELO_MARCA(
ID NUMBER PRIMARY KEY,
NOMBRE_MODELO NVARCHAR2(50),
COLOR NVARCHAR2(50),
PRECIO NUMBER,
NUM_PUERTAS NUMBER,
TIPO NVARCHAR2(50),
ID_MARCA NUMBER,
FOREIGN KEY(ID_MARCA) REFERENCES MARCA_AUTO(ID)
);
	 * */
	
	@Id
	@Column()
	int id;
	@Column()
	String nombre_modelo;
	@Column()
	String color;
	@Column()
	double precio;
	@Column()
	int num_puertas;
	@Column()
	String tipo;
	
	/*@ManyToOne de muchos a uno -> se liga con la Marca 
	 * fetch -> le indica a spring como debe de ser carga la endiad --> Cascade
	 * FetchType.EAGER --> indica la relacion como de se ser cargada cuando entre la entidad
	 * */
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_MARCA")
	Marca marca;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNum_puertas() {
		return num_puertas;
	}

	public void setNum_puertas(int num_puertas) {
		this.num_puertas = num_puertas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Autos [id=" + id + ", nombre_modelo=" + nombre_modelo + ", color=" + color + ", precio=" + precio
				+ ", num_puertas=" + num_puertas + ", tipo=" + tipo + ", marca=" + marca + "]/n";
	}
	
	
	
}
