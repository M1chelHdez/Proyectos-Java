package com.mx.Patito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignar {
	String pedido;
	String hawa;
	
	
	public Asignar(String pedido, String hawa) {
		super();
		this.pedido = pedido;
		this.hawa = hawa;
	}


	public String getPedido() {
		return pedido;
	}


	public void setPedido(String pedido) {
		this.pedido = pedido;
	}


	public String getHawa() {
		return hawa;
	}


	public void setHawa(String hawa) {
		this.hawa = hawa;
	}
	
	
	
}
