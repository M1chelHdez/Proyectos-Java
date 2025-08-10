package com.mx.Patito.entidad;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "AUDITO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auditoria {
	@Id
	@Column
	int id;
	@Column
	Timestamp fecha_evento;
	@Column
	String usuario;
	@Column
	String id_tienda;
	@Column
	String nombre_cliente;
	@Column
	String nombre_ven;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_HAWA")
	Camioneta camioneta;

	public Auditoria() {
	}

	public Auditoria(String nombreCliente, Camioneta camioneta) {
		this.nombre_cliente = nombreCliente;
		this.camioneta = camioneta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha_evento() {
		return fecha_evento;
	}

	public void setFecha_evento(Timestamp fecha_evento) {
		this.fecha_evento = fecha_evento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(String id_tienda) {
		this.id_tienda = id_tienda;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getNombre_ven() {
		return nombre_ven;
	}

	public void setNombre_ven(String nombre_ven) {
		this.nombre_ven = nombre_ven;
	}

	public Camioneta getCamioneta() {
		return camioneta;
	}

	public void setCamioneta(Camioneta camioneta) {
		this.camioneta = camioneta;
	}

}
