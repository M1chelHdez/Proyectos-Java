package com.mx.Patito.entidad;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRUCK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camioneta {
	@Id
	@Column
	String hawa;
	@Column
	String marca;
	@Column
	String modelo;
	@Column
	int anio;
	@Column
	int precio;
	@Column
	int stock;
	@Column 
	Double descuento;


	@OneToMany(mappedBy = "camioneta", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Auditoria> listaAuditoria = new ArrayList<>();
	@ManyToMany(mappedBy = "listaCamioneta")
	@JsonIgnore
	List<Pedido> listaPedido = new ArrayList<>();
	
	
	
	public Camioneta() {
		super();
	}

	public Camioneta(String hawa) {
		this.hawa = hawa;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public List<Auditoria> getListaAuditoria() {
		return listaAuditoria;
	}

	public void setListaAuditoria(List<Auditoria> listaAuditoria) {
		this.listaAuditoria = listaAuditoria;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	
	
}
