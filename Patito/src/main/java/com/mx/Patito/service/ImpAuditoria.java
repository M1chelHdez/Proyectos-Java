package com.mx.Patito.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Patito.dao.AuditoriaDao;
import com.mx.Patito.entidad.Auditoria;

@Service
public class ImpAuditoria {
	@Autowired
	AuditoriaDao dao;
	
	public List<Auditoria> mostrar(){
		return dao.findAll();
	}
	
	public void guardar(Auditoria audito) {
		audito.setId(generteCode());
		
		LocalDateTime time = LocalDateTime.now();
		Timestamp dateNow = Timestamp.valueOf(time);
		audito.setFecha_evento(dateNow);
		
		audito.setUsuario("simulandoIP...");
		audito.setId_tienda("7HF9");
		audito.setNombre_ven("Patito");
		
		
		dao.save(audito);
	}
	
	public int generteCode() {
		Random random = new Random();
		
		int number = random.nextInt(1000) + 1;
		
		return number;
	}
	
	
}
