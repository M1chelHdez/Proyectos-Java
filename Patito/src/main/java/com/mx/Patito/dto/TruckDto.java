package com.mx.Patito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TruckDto {
	String hawa;
	String marca;
	String modelo;
	int anio;
	int precio;
	Double descuento;
	int cantidad;
	
	public TruckDto(String hawa, String marca, String modelo, int anio, int precio, Double descuento, int cantidad) {
		super();
		this.hawa = hawa;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
		this.descuento = descuento;
		this.cantidad = cantidad;
	}

	public String getHawa() {
		return hawa;
	}

	public void setHawa(String hawa) {
		this.hawa = hawa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
