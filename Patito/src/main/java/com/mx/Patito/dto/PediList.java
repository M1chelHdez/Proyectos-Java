package com.mx.Patito.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mx.Patito.entidad.Camioneta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PediList {
	String codigo;
	String estatus;
	String nombrec;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone = "America/Mexico_City")
	Timestamp fecha_creacion;
	int cantidad;
	List<Camioneta> listcamionetas;
	
	
	
	
	public PediList(String codigo, String estatus, String nombrec, Timestamp fecha_creacion, int cantidad,
			List<Camioneta> listcamionetas) {
	
		this.codigo = codigo;
		this.estatus = estatus;
		this.nombrec = nombrec;
		this.fecha_creacion = fecha_creacion;
		this.cantidad = cantidad;
		this.listcamionetas = listcamionetas;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getNombrec() {
		return nombrec;
	}
	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}
	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public List<Camioneta> getListcamionetas() {
		return listcamionetas;
	}
	public void setListcamionetas(List<Camioneta> listcamionetas) {
		this.listcamionetas = listcamionetas;
	}
	
	
	
}
