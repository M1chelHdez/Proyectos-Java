package com.mx.Patito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TruckPrice {
	String hawa;
	int precio;
	Double descuento;
	int cantidad;
	
	public TruckPrice(String hawa, int precio, Double descuento, int cantidad) {
		super();
		this.hawa = hawa;
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
