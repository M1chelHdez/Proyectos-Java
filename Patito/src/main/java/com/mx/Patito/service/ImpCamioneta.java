package com.mx.Patito.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Patito.Respuesta.Respuesta;
import com.mx.Patito.dao.CamionetaDao;
import com.mx.Patito.entidad.Camioneta;

@Service
public class ImpCamioneta {
	@Autowired
	CamionetaDao dao;
	
	public List<Camioneta> mostrar(){		
		
		return dao.findByALLCamioneta();
	}
	
	public Respuesta guardar(Camioneta cami) {
		Respuesta r = new Respuesta();
		r.setAction(true);
		
		if (dao.existsByMarca(cami.getMarca()) && dao.existsByModelo(cami.getModelo())) {
			r.setAction(false);
			r.setMessage("Ya existe una camioneta con ese modelo y marca");
		}
		
		if (r.isAction()) {
			cami.setHawa(String.valueOf(generateHawa()));
			
			if (dao.existsById(cami.getHawa())) {
				cami.setHawa(String.valueOf(generateHawa()));
			}
			
			if (cami.getDescuento() != null) {
				cami.setDescuento(cami.getDescuento() / 100);
			}
			
			dao.save(cami);
			r.setMessage("Agregado");
		}
		
		return r;
	}
	
	public int generateHawa() {
		Random random = new Random();
		int number = random.nextInt(9000) + 1000;
		
		return number;
	}
	
	public void confirmChanges(Camioneta cami) {
		dao.save(cami);
	}
	
	public void editar(Camioneta cami) {
		dao.save(cami);
	}
	
	public Camioneta buscarId(Camioneta cami) {
		return dao.findById(cami.getHawa()).orElse(null);
	}
	
	public void eliminar(Camioneta cami) {
		cami = buscarId(cami);		
		cami.setStock(cami.getStock() - 1);
		
	    dao.save(cami);

		if (cami.getStock() == 0) {
			dao.delete(cami);
		}		
	}
}
