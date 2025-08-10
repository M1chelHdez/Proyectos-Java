package com.mx.Patito.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Patito.Respuesta.Respuesta;
import com.mx.Patito.dao.PedidoDao;
import com.mx.Patito.dto.Asignar;
import com.mx.Patito.dto.Detalles;
import com.mx.Patito.dto.PediList;
import com.mx.Patito.dto.TruckDto;
import com.mx.Patito.dto.TruckPrice;
import com.mx.Patito.entidad.Auditoria;
import com.mx.Patito.entidad.Camioneta;
import com.mx.Patito.entidad.Pedido;

@Service
public class ImpPedido {
	@Autowired
	PedidoDao dao;
	
	@Autowired
	ImpCamioneta impC;
	
	@Autowired
	ImpAuditoria impA;
	
	public List<PediList> mostrar(){
		List<PediList> listP = new ArrayList<>();
		
		for (Pedido p : dao.findAll()) {
			List<Camioneta> listC = new ArrayList<>();
			int cantidad = 0;
			for (Camioneta c : p.getListaCamioneta()) {
				cantidad++;
				
				listC.add(c);
			}
			PediList pedi = new PediList(p.getCodigo(), p.getEstatus(), p.getNombrec(), p.getFecha_creacion(), cantidad, listC);
			listP.add(pedi);
		}
		
		return listP;
	}
	
	public Respuesta guardar(Pedido pedido) {
		Respuesta r = new Respuesta();
		r.setAction(true);
		
		if (dao.existsByNombrec(pedido.getNombrec())) {
			r.setAction(false);
			r.setMessage("Ya existe un pedido con ese nombre");
		}
		
		if (r.isAction()) {
			pedido.setCodigo(generateCode());
			
			if (dao.existsById(pedido.getCodigo())) {
				pedido.setCodigo(generateCode());
			}
			
			pedido.setEstatus("PENDIENTE");
			pedido.setFecha_creacion(new Timestamp(System.currentTimeMillis()));
			
			dao.save(pedido);
			r.setMessage("Registrado");
		}
		
		return r;
	}
	
	public Respuesta editar(Pedido pedido) {
		Respuesta r = new Respuesta();
		r.setAction(true);
		
		Pedido p = buscarId(pedido);
		
		LocalDateTime time = LocalDateTime.now();
		Timestamp fin = Timestamp.valueOf(time);

		
		long diferenciaMilis = fin.getTime() - p.getFecha_creacion().getTime();
		long diferenciaMinutos = diferenciaMilis / 60000;
		
		if (pedido.getEstatus().equals("CANCELADO") &&  diferenciaMinutos > 10) {
			r.setMessage("No puedes cancelar el pedido, porque ha pasado mas de 10 minutos, desde la creación del pedido");
			r.setAction(false);
		}
		
		if (p.getEstatus().equals("ENTREGADO") || p.getEstatus().equals("CANCELADO"))  {
			r.setMessage("No se puede cambiar el estado del pedidos, porque esta finalizado");
			r.setAction(false);
		}
		
		if (r.isAction()) {
			p.setEstatus(pedido.getEstatus());
			//incrementar camioneta si es cancelado
			if (pedido.getEstatus().equals("CANCELADO")) {
				if (!p.getListaCamioneta().isEmpty())   {
					for (Camioneta c : p.getListaCamioneta()) {
						c.setStock(c.getStock() + 1);
						
						impC.confirmChanges(c);
					}
				}
			}
			
			dao.save(p);
			r.setMessage("Editado");
			r.setAction(true);
		}
		return r;
	}
	
	public String generateCode() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			int randomIndex = r.nextInt(caracteres.length());
			char randomChar = caracteres.charAt(randomIndex);
			sb.append(randomChar);
		}
		
		/*
		 * Random random = new Random();
		 * int number = random.nextInt(9000) + 100; return number;
		 */
		return sb.toString();
	}
	
	public Respuesta hacerPedido(Asignar asignar) {
		Respuesta r = new Respuesta();
		r.setAction(true);
		
		Pedido p = dao.findById(asignar.getPedido()).orElse(null);
		Camioneta c = impC.buscarId(new Camioneta(asignar.getHawa()));
		
		//verificar camioneta existencia
		if (c.getStock() == 0) {
			r.setAction(false);
			r.setMessage("No se puede agregar la camioneta, ya que no hay inventario");;
		}
		
		if (p.getEstatus().equals("CANCELADO") || p.getEstatus().equals("ENTREGADO")) {
			r.setAction(false);
			r.setMessage("No se puede agregar mas camionetas, porque el pedido esta finalizado");		
		}
		
		if (r.isAction()) {
			//agregar y actualizar relaciones manualmente
			p.getListaCamioneta().add(c);
			dao.save(p);
			
			//update table camioneta
			c.setStock(c.getStock() - 1);
			impC.confirmChanges(c);
			
			//insertAuditoria
			//Auditoria a = new Auditoria(p.getNombrec(), new Camioneta(c.getHawa()));
			
			//impA.guardar(a);
			
			r.setAction(true);
			r.setMessage("Pedido creado");
		}
		
		return r;
	}
	
	public Pedido buscarId(Pedido pedido) {
		return dao.findById(pedido.getCodigo()).orElse(null);
	}
	
	public List<Detalles> listarDetalles() {
		List<Pedido> pedido = dao.findAll();
		List<Detalles> d = new ArrayList<>();		
		
		for (Pedido p : pedido) {
			Set<TruckDto> truckD = new HashSet<>();
			
			int cantidad = 0;
			double descuento = 0;
			double totalDescuento = 0;
			double precio = 0;
			
			if (!p.getListaCamioneta().isEmpty()) {
				for (Camioneta c : p.getListaCamioneta()) {
					
					cantidad++;
					precio = c.getPrecio();
					
					if (c.getDescuento() != null) {
						descuento = c.getPrecio() * c.getDescuento();
						precio -= descuento;
					}
					
					totalDescuento += precio;
					
					TruckDto t = new TruckDto(c.getHawa(), c.getMarca(), c.getModelo(), c.getAnio(), c.getPrecio(), c.getDescuento(), cantidad);
					truckD.add(t);
				}
			}
			
			Detalles detallesD = new Detalles(p.getCodigo(), p.getEstatus(), p.getNombrec(), cantidad, totalDescuento, truckD);
			d.add(detallesD);
		}
		
		return d;
	}
	
	public Detalles detalleId(Pedido pedido) {
		Pedido p = dao.findById(pedido.getCodigo()).orElse(null);
		Detalles d = null;
		
		if (!p.getListaCamioneta().isEmpty()) {
			int cantidad = 0;
			double total = 0;
			double precio = 0;
			double descuento = 0;
			Map<String, TruckPrice> mapTruck = new HashMap<>();

			for (Camioneta c : p.getListaCamioneta()) {
				cantidad++;
				
				precio = c.getPrecio();
				
				if (c.getDescuento() != null ) {
					descuento = c.getPrecio() * c.getDescuento();
					precio -= descuento;
				}
				total += precio; 
				
				TruckPrice priceDetail = mapTruck.get(c.getHawa());
				if (priceDetail == null) {
					priceDetail = new TruckPrice(c.getHawa(), c.getPrecio(), c.getDescuento(), 1);
				}else {
					priceDetail.setCantidad(priceDetail.getCantidad() + 1);;
				}
				mapTruck.put(c.getHawa(), priceDetail);
				d = new Detalles(p.getCodigo(), p.getEstatus(), p.getNombrec(), cantidad, total, mapTruck);
			}
		}
	
		return d;
	}
	
	public void eliminarRe(Pedido pedido) {
		pedido = dao.findById(pedido.getCodigo()).orElse(null);
		
		if (!pedido.getListaCamioneta().isEmpty()) {
			pedido.getListaCamioneta().remove(0);
			dao.save(pedido);
		}
		
		if (pedido.getListaCamioneta().isEmpty()){
			dao.delete(pedido);
		}
		
	}
}
